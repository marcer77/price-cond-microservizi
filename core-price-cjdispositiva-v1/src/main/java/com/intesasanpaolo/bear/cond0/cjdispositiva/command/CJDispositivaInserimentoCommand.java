package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.DBCond0Service;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.exceptions.BearTransactionException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaInserimentoCommand extends CJDispositivaCommand {


	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;

	@Autowired
	private CoreConvenzioneService coreConvenzioneService;

	private WsRequestFactory wsRequestFactory = new WsRequestFactory();

	private List<EsitoOperazioneCJPOSV2> listaEsitoInviaPropostaV2 = new ArrayList<>();

	@Autowired
	private DBCond0Service dbCond0Service;

	@Override
	protected EsitoResponseResource doExecute() throws Exception{
		logger.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("00", "OK");
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		String codUnitaOperativa = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA);
		String branchCode = ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode();
		String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();
		try {
			// Recupero informazioni superpratica (…)
			List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
			if(CollectionUtils.isNotEmpty(listaAdesioni)) {
				final List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
				final List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());

				recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);


				// IIB PCK8 PCGESTIXME/Gestione aggiornamento Condizioni
				callInTransaction(()->
				callGestioneService( CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(dispositivaRequestDTO.getCodProcesso()) ? "CAF": "CDA" , dispositivaRequestDTO, listaAdesioni.get(0))
				,()->callGestioneService(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(dispositivaRequestDTO.getCodProcesso()) ? "AAF": "ADA", dispositivaRequestDTO, listaAdesioni.get(0)));


				// WS VDM StoreCovenantAdesioneConvenzione
				callInTransaction(()->
				callConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId)
				,()->callRollbackConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId));

				//6)	Se input.codProcesso == ‘CJAFF’
				//  •	DELETE codici proposte
				if(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
					coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(),  dispositivaRequestDTO.getPraticaDTO().getCodPratica());
					List<RapportoEntity> elencoRapporti = coreConvenzioneService.getElencoRapportiConTassiAbbattuti(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica());

					if(CollectionUtils.isNotEmpty(elencoRapporti)) {
						for (RapportoEntity rapporto : elencoRapporti) {
							callInTransaction(
									()->creaProposta(rapporto,codAbi,codUnitaOperativa,listaAdesioni.get(0)),
									()->revocaProposte(codAbi, userId, codUnitaOperativa));
						}
					}

				}
			}else {
				throw CJDispositivaNotFoundDB2Exception.builder().messaggio("Nessuna Adesione trovata per la pratica fornita [ codSuperPratica:{}, nrPratica:{} ]")
				.param(new String[]{dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica()}).build();
			}

			logger.info("execute SUCCESS ");
		}catch(BearTransactionException ex) {
			throw (Exception)ex.getCause();
		}
		return esitoResource;
	}

	private Integer revocaProposte(String codAbi, String userId, String codUnitaOperativa) {
		logger.info("revocaProposte START ");
		if(CollectionUtils.isNotEmpty(listaEsitoInviaPropostaV2)) {

			for (EsitoOperazioneCJPOSV2 esitoOperazioneCJPOSV2 : listaEsitoInviaPropostaV2) {
				//annulla proposta sul database oracle COND0
				dbCond0Service.annullaProposta(codAbi, esitoOperazioneCJPOSV2.getCodiceProposta().substring(0, 4), esitoOperazioneCJPOSV2.getCodiceProposta());
			}
		}

		coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(),  dispositivaRequestDTO.getPraticaDTO().getCodPratica());
		
		
		listaEsitoInviaPropostaV2.clear(); //rimuovo tutto in modo che se anche il revoca viene invocato più volte
		                                   //agira e saranno rollbackate tutte le pratiche solo nella prima chiamata
		
		logger.info("revocaProposte END OK ");
		return 1;
	}

	private Integer creaProposta(RapportoEntity rapporto, String codAbi,String codUnitaOperativa,AdesioneEntity adesione) {
		logger.info("creaProposta START ");

		logger.info("rapporto:" + rapporto);
		List<TassoEntity> tassiAbbattuti = coreConvenzioneService.getElencoTassiAbbattuti(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica(), rapporto);

		// WS COND0 GESTCJPOSV.inviaPropostaV2
		EsitoOperazioneCJPOSV2 esitoInviaPropostaV2 = callInviaPropostaV2Service(codAbi,codUnitaOperativa,adesione, rapporto,tassiAbbattuti);
		this.listaEsitoInviaPropostaV2.add(esitoInviaPropostaV2);
		coreConvenzioneService.saveCodiceProposta(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica(), esitoInviaPropostaV2.getCodiceProposta(), ispWebservicesHeaderType.getOperatorInfo().getUserID());

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

}
