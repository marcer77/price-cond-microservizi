package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJGenericBusinessApplication;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.DBCond0Service;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.exceptions.BearTransactionException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaInserimentoCommand extends CJDispositivaCommand {

	private Map<String,List<EsitoOperazioneCJPOSV2>> mapTranslistaEsitoInviaPropostaV2 = new HashMap<>();

	@Autowired
	private DBCond0Service dbCond0Service;
	
	private String codAbi;
	private String userId; 
	private String codUnitaOperativa;
	private String branchCode;
	
	
	@Override
	protected EsitoResponseResource doExecute() throws Exception{
		logger.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("00", "OK");
		this.codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		this.codUnitaOperativa = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA);
		this.branchCode = ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode();
		this.userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();

		try {
			List<String> elencoPratiche=this.coreConvenzioneService.getElencoPratiche(codAbi , this.dispositivaRequestDTO.getCodProcesso(), this.dispositivaRequestDTO.getPratica().getCodSuperPratica(), this.dispositivaRequestDTO.getPratica().getCodPratica());

			for (int i=0;i<elencoPratiche.size();i++) {
				final String pratica= elencoPratiche.get(i);
				final String transactionID = "TX" + i;
				callInTransaction(()->executeSinglePratica(pratica,transactionID),()->rollbackPratica(pratica),"TX_EXTERNAL");
			}
			callInTransaction(() -> invokeWKCJ(),"TX_EXTERNAL");

			logger.info("execute SUCCESS ");
		}catch(BearTransactionException ex) {
			throw (Exception)ex.getCause();
		}
		return esitoResource;
	}


	private Integer rollbackPratica(String codPratica) {
	
		annulloPratica(codAbi, codPratica , dispositivaRequestDTO.getPratica().getCodSuperPratica(),  branchCode, userId);
		return 1;
	}
	
	private Integer executeSinglePratica (String codPratica,String transactionID)  {
	
			// Recupero informazioni superpratica (…)
			List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, codPratica , dispositivaRequestDTO.getPratica().getCodSuperPratica());
			if(CollectionUtils.isNotEmpty(listaAdesioni)) {
				final List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, codPratica , dispositivaRequestDTO.getPratica().getCodSuperPratica());
				final List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, codPratica , dispositivaRequestDTO.getPratica().getCodSuperPratica());
				try {
				recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);


				// IIB PCK8 PCGESTIXME/Gestione aggiornamento Condizioni
				callInTransaction(()->
				callGestioneService( CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(dispositivaRequestDTO.getCodProcesso()) ? "CAF": "CDA" ,codPratica, dispositivaRequestDTO, listaAdesioni.get(0))
				,()->callGestioneService(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(dispositivaRequestDTO.getCodProcesso()) ? "AAF": "ADA",codPratica ,dispositivaRequestDTO, listaAdesioni.get(0)),transactionID);


				// WS VDM StoreCovenantAdesioneConvenzione
				if(CollectionUtils.isNotEmpty(covenantDaAttivare) || CollectionUtils.isNotEmpty(covenantDaCessare)) {
					callInTransaction(()->
					callConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId)
					,()->callRollbackConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId),transactionID);
				}
				//6)	Se input.codProcesso == ‘CJAFF’
				//  •	DELETE codici proposte
				if(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
					coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(),  codPratica);
					List<RapportoEntity> elencoRapporti = coreConvenzioneService.getElencoRapportiConTassiAbbattuti(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(), codPratica);

					if(CollectionUtils.isNotEmpty(elencoRapporti)) {
						for (RapportoEntity rapporto : elencoRapporti) {
							callInTransaction(
									()->creaProposta(rapporto,listaAdesioni.get(0),codPratica,transactionID),
									()->revocaProposte(transactionID,codPratica),transactionID);
						}
					}
				}
				}catch(Exception be) {
					if(be.getCause() instanceof RuntimeException) {
						throw (RuntimeException)be.getCause();
					}
					throw new CJGenericBusinessApplication("99",be.getMessage(),be);
				}
			}else {
				throw CJDispositivaNotFoundDB2Exception.builder().messaggio("Operazione non ammessa, eseguire funzione 'Adesione a Convenzione' per la pratica  [ codSuperPratica:{}, nrPratica:{} ]")
				.param(new String[]{dispositivaRequestDTO.getPratica().getCodSuperPratica(), codPratica}).build();
			}

		return 1;

		
	}
	
	
	private Integer revocaProposte(String transactionID, String codPratica) {
		logger.info("revocaProposte START ");
		
		List<EsitoOperazioneCJPOSV2> listaEsitoInviaPropostaV2 = mapTranslistaEsitoInviaPropostaV2.get(transactionID);
		if(CollectionUtils.isNotEmpty(listaEsitoInviaPropostaV2)) {

			for (EsitoOperazioneCJPOSV2 esitoOperazioneCJPOSV2 : listaEsitoInviaPropostaV2) {
				//annulla proposta sul database oracle COND0
				dbCond0Service.annullaProposta(codAbi, esitoOperazioneCJPOSV2.getCodiceProposta().substring(0, 4), esitoOperazioneCJPOSV2.getCodiceProposta());
			}
		}
		
		
		coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(),  codPratica);
		
		
		
		listaEsitoInviaPropostaV2.clear(); //rimuovo tutto in modo che se anche il revoca viene invocato più volte
		                                   //agira e saranno rollbackate tutte le pratiche solo nella prima chiamata
		
		logger.info("revocaProposte END OK ");
		return 1;
	}

	private Integer creaProposta(RapportoEntity rapporto, AdesioneEntity adesione,String codPratica,String transactionID) {

		logger.info("creaProposta START ");

		logger.info("rapporto:" + rapporto);
		List<TassoEntity> tassiAbbattuti = coreConvenzioneService.getElencoTassiAbbattuti(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(), codPratica, rapporto);

		// WS COND0 GESTCJPOSV.inviaPropostaV2
		if(CollectionUtils.isNotEmpty(tassiAbbattuti)) {
			EsitoOperazioneCJPOSV2 esitoInviaPropostaV2 = callInviaPropostaV2Service(codAbi,codUnitaOperativa,adesione, rapporto,tassiAbbattuti);
			
			List<EsitoOperazioneCJPOSV2> listaEsitoInviaPropostaV2 = mapTranslistaEsitoInviaPropostaV2.get(transactionID);
			if(listaEsitoInviaPropostaV2 == null) {
				listaEsitoInviaPropostaV2 = new ArrayList<>();
				mapTranslistaEsitoInviaPropostaV2.put(transactionID,listaEsitoInviaPropostaV2);
			}
			listaEsitoInviaPropostaV2.add(esitoInviaPropostaV2);
			coreConvenzioneService.saveCodiceProposta(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(), codPratica, esitoInviaPropostaV2.getCodiceProposta(), ispWebservicesHeaderType.getOperatorInfo().getUserID());
		}
		logger.info("creaProposta END OK ");
		return 1;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	private EsitoOperazioneCJPOSV2 callInviaPropostaV2Service(String codAbi, String codUnitaOperativa,AdesioneEntity adesione, RapportoEntity rapporto, List<TassoEntity> tassiAbbattuti) {
		logger.info("inviaPropostaV2 START");
		EsitoOperazioneCJPOSV2 esitoOperazione = new EsitoOperazioneCJPOSV2();
		InviaPropostaV2 request = wsRequestFactory.assemblaRequestInviaProposta(codAbi, codUnitaOperativa,adesione, rapporto, tassiAbbattuti);
		logger.info("inviaPropostaV2 CAN EXECUTE");
		esitoOperazione = proposteCJPOSWSService.inviaPropostaV2(request, ispWebservicesHeaderType);

		logger.info("inviaPropostaV2 END");
		return esitoOperazione;
	}

	private RespStoreCovenantAdesioneConvenzione callConvenzioniHostService(AdesioneEntity adesione, List<CovenantEntity> covenantDaAttivare, List<CovenantEntity> covenantDaCessare, String codAbi, String codProcesso, String branchCode , String userId) {
		logger.info("callStoreCovenantAdesioneConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = wsRequestFactory.assemblaRequestConvenzione(adesione,covenantDaAttivare, covenantDaCessare, codAbi, codProcesso , branchCode, userId);
		RespStoreCovenantAdesioneConvenzione resp = convenzioniHostService.storeCovenantAdesioneConvenzione(request);
		logger.info("callStoreCovenantAdesioneConvenzione END");
		checkResponseStoreCovenantAdesioneConvenzione(resp);
		return resp;
	}

	private void checkResponseStoreCovenantAdesioneConvenzione(RespStoreCovenantAdesioneConvenzione resp) {
		logger.info("checkResponseStoreCovenantAdesioneConvenzione START");
		if("KO".equals(resp.getEsitoResultCode())){
			throw CJWebServiceException.builder().webServiceName("StoreCovenantAdesioneConvenzione").codiceErroreWebService(resp.getEsitoResultCode())
			.descrErroreWebService(resp.getEsitoErrorMessage()+" "+resp.getListaErroriCovenantDaAttivare()).build();
		}
		logger.info("checkResponseStoreCovenantAdesioneConvenzione END");
	}

	private Integer invokeWKCJ() {
		
		String tipoChiamata=CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(this.dispositivaRequestDTO.getCodProcesso())?"A2":
			CodProcessoEnum.CJ_CUI_DA.toString().equals(this.dispositivaRequestDTO.getCodProcesso())?"02":"";
		
		this.invokeWKCJ(ispWebservicesHeaderType, this.dispositivaRequestDTO.getCodProcesso(), this.dispositivaRequestDTO.getPratica().getCodSuperPratica(), this.dispositivaRequestDTO.getPratica().getCodPratica(), tipoChiamata);
	
		return 1;
	}
	
	
}
