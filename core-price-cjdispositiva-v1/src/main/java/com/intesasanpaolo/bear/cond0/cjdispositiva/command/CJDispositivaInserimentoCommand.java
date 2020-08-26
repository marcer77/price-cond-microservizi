package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaInserimentoCommand extends CJDispositivaCommand {

	private Logger log = Logger.getLogger(CJDispositivaInserimentoCommand.class);
	
	private DispositivaRequestDTO dispositivaRequestDTO;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;
	
	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;
	
	@Autowired
	private CoreConvenzioneService coreConvenzioneService;
	
	private WsRequestFactory wsRequestFactory = new WsRequestFactory();

	@Override
	protected EsitoResponseResource doExecute() throws Exception {
		log.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("00", "OK");
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		String codUnitaOperativa = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA);
		String branchCode = ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode();
		String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();

		// Recupero informazioni superpratica (…)
		List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
		if(CollectionUtils.isNotEmpty(listaAdesioni)) {
			List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
			List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
			
			covenantDaAttivare = recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);

			// IIB PCK8 PCGESTIXME/Gestione aggiornamento Condizioni
			callGestioneService(dispositivaRequestDTO, listaAdesioni.get(0));

			// WS VDM StoreCovenantAdesioneConvenzione
			callConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId);
	
			//6)	Se input.codProcesso == ‘CJAFF’
			//  •	DELETE codici proposte
			if(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
				coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(),  dispositivaRequestDTO.getPraticaDTO().getCodPratica());
				List<RapportoEntity> elencoRapporti = coreConvenzioneService.getElencoRapportiConTassiAbbattuti(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica());
				
				elencoRapporti.stream().forEach(rapporto -> {

					List<TassoEntity> tassiAbbattuti = coreConvenzioneService.getElencoTassiAbbattuti(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica(), rapporto);
					// WS COND0 GESTCJPOSV.inviaPropostaV2
					EsitoOperazioneCJPOSV2 esitoInviaPropostaV2 = callInviaPropostaV2Service(codAbi,codUnitaOperativa,listaAdesioni.get(0), rapporto,tassiAbbattuti);
					
					coreConvenzioneService.saveCodiceProposta(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica(), esitoInviaPropostaV2.getCodiceProposta(), ispWebservicesHeaderType.getOperatorInfo().getUserID());

				});

			}

			// BS PCMK registrazione elenco cod.prop. “fittizie”
			recuperoInformazioniService.registrazioneCodFittizie();

		}else {
			throw CJDispositivaNotFoundDB2Exception.builder().messaggio("Nessuna Adesione trovata per la pratica fornita [ codSuperPratica:{}, nrPratica:{} ]")
			.param(new String[]{dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica()}).build();
		}

		log.info("execute SUCCESS ");
		return esitoResource;
	}
	
	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		boolean esitoControlli = false;
		esitoControlli = 
				!StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getServiceID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getServiceVersion())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("canExecute END - " + esitoControlli);
		return esitoControlli;
	}
	
	private EsitoOperazioneCJPOSV2 callInviaPropostaV2Service(String codAbi, String codUnitaOperativa,AdesioneEntity adesione, RapportoEntity rapporto, List<TassoEntity> tassiAbbattuti) {
		log.info("inviaPropostaV2 START");
		EsitoOperazioneCJPOSV2 esitoOperazione = new EsitoOperazioneCJPOSV2();
		InviaPropostaV2 request = wsRequestFactory.assemblaRequestInviaProposta(codAbi, codUnitaOperativa,adesione, rapporto, tassiAbbattuti);
		log.info("inviaPropostaV2 CAN EXECUTE");
		esitoOperazione = proposteCJPOSWSService.inviaPropostaV2(request, ispWebservicesHeaderType);
		log.info("inviaPropostaV2 END");
		return esitoOperazione;
	}
	
	private RespStoreCovenantAdesioneConvenzione callConvenzioniHostService(AdesioneEntity adesione, List<CovenantEntity> covenantDaAttivare, List<CovenantEntity> covenantDaCessare, String codAbi, String codProcesso, String branchCode , String userId) {
		log.info("callStoreCovenantAdesioneConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = wsRequestFactory.assemblaRequestConvenzione(adesione,covenantDaAttivare, covenantDaCessare, codAbi, codProcesso , branchCode, userId);
		RespStoreCovenantAdesioneConvenzione resp = convenzioniHostService.storeCovenantAdesioneConvenzione(request);
		log.info("callStoreCovenantAdesioneConvenzione END");
		checkResponseStoreCovenantAdesioneConvenzione(resp);
		return resp;
	}
	
	private void checkResponseStoreCovenantAdesioneConvenzione(RespStoreCovenantAdesioneConvenzione resp) {
		log.info("checkResponseStoreCovenantAdesioneConvenzione START");
		if("KO".equals(resp.getEsitoResultCode())){
			throw CJWebServiceException.builder().webServiceName("StoreCovenantAdesioneConvenzione").codiceErroreWebService(resp.getEsitoResultCode())
			.descrErroreWebService(resp.getEsitoErrorMessage()+" "+resp.getListaErroriCovenantDaAttivare()).build();
		}
		log.info("checkResponseStoreCovenantAdesioneConvenzione END");
	}
	
	public void setDispositivaRequestDTO(DispositivaRequestDTO dispositivaRequestDTO) {
		this.dispositivaRequestDTO = dispositivaRequestDTO;
	}
}
