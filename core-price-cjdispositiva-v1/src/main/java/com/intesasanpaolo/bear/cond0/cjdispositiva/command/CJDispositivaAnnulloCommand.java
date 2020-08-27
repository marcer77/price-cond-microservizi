package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaAnnulloCommand extends CJDispositivaCommand {

	private Logger log = Logger.getLogger(CJDispositivaAnnulloCommand.class);

	private DispositivaRequestDTO dispositivaRequestDTO;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;

	@Override
	protected EsitoResponseResource doExecute() throws Exception {
		log.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("00", "OK");
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		String codUnitaOperativa = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA);
		String branchCode = ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode();
		String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();

		log.info("execute OK");

		List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
		if(CollectionUtils.isNotEmpty(listaAdesioni)) {

			if( CodProcessoEnum.CJ_AFFIDAMENTI.toString().equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
				
				List<PropostaEntity> listaProposte = coreConvenzioneService.getCodiciProposte(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(),  dispositivaRequestDTO.getPraticaDTO().getCodPratica());

				if(CollectionUtils.isNotEmpty(listaProposte)) {
					for(PropostaEntity proposta : listaProposte) {
						// WS COND0 GESTCJPOSV.revocaProposta
						String dataRespinta = DateUtils.dateToString(new Date(ispWebservicesHeaderType.getRequestInfo().getTimestamp()), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID);
						callWsRevocaProposta(codAbi, proposta.getAnnoProposta(), proposta.getCodiceProposta(), dataRespinta, userId, codUnitaOperativa);
					}
				}
				
				coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(),  dispositivaRequestDTO.getPraticaDTO().getCodPratica());

			}
			
			List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
			List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
			
			if(CollectionUtils.isNotEmpty(covenantDaAttivare) || CollectionUtils.isNotEmpty(covenantDaCessare)) {
				if(CollectionUtils.isNotEmpty(covenantDaAttivare) ) {
					covenantDaAttivare = recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);
				}
				
				// WS VDM rollback storecovenant
				callConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId);
			}
	
			// IIB PCK8 PCGESTIXME/Gestione rollback aggiornamento Condizioni
			callGestioneService(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(dispositivaRequestDTO.getCodProcesso()) ? "AAF": "ADA", dispositivaRequestDTO, listaAdesioni.get(0));
			
			// BS PCMK aggiorna elenco cod.prop. fittizie
			callAggiornaCodfittizie();
		}
		
		// return
		return esitoResource;
	}
	
	private boolean callAggiornaCodfittizie() {
		log.info("callAggiornaCodfittizie START");
		log.info("callAggiornaCodfittizie END");
		return recuperoInformazioniService.aggiornaCodFittizie();
	}

	private EsitoOperazioneCJPOSV2 callWsRevocaProposta(String codAbi, String annoProposta, String codiceProposta, String dataRespinta,String userId,String codUnitaOperativa ) {
		log.info("_revocaProposta START");
		RevocaProposta revocaProposta = wsRequestFactory.assemblaRequestRevocaProposta( codAbi,  annoProposta,  codiceProposta,  dataRespinta, userId, codUnitaOperativa );
		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSService.revocaProposta(revocaProposta,ispWebservicesHeaderType);
		log.info("_revocaProposta END");
		return esito;
	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		boolean esitoControlli = false;
		esitoControlli =
				super.canExecute()
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
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
	
	private RespRollbackStoreCovenantAdesioneConvenzione callConvenzioniHostService(AdesioneEntity adesione, List<CovenantEntity> covenantDaAttivare, List<CovenantEntity> covenantDaCessare, String codAbi, String codProcesso, String branchCode , String userId) {
		log.info("callStoreCovenantAdesioneConvenzione START");
		ReqRollbackStoreCovenantAdesioneConvenzione request = wsRequestFactory.assemblaRequestConvenzione(adesione,covenantDaAttivare, covenantDaCessare, codAbi, codProcesso , branchCode, userId);
		RespRollbackStoreCovenantAdesioneConvenzione resp = convenzioniHostService.rollbackStoreCovenantAdesioneConvenzione(request);
		log.info("callStoreCovenantAdesioneConvenzione END");
		checkResponseRollbackCovenantAdesioneConvenzione(resp);
		return resp;
	}
	
	private void checkResponseRollbackCovenantAdesioneConvenzione(RespRollbackStoreCovenantAdesioneConvenzione resp) {
		log.info("checkResponseRollbackCovenantAdesioneConvenzione START");
		if(resp.getIsHasError().booleanValue()){
			throw CJWebServiceException.builder().webServiceName("RollbackCovenantAdesioneConvenzione").codiceErroreWebService("")
			.descrErroreWebService(resp.getErrorDescription()).build();
		}
		log.info("checkResponseRollbackCovenantAdesioneConvenzione END");
	}
	
}
