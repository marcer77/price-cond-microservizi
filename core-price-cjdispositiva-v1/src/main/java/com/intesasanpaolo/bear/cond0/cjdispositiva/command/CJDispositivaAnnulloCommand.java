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
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.DBCond0Service;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaAnnulloCommand extends CJDispositivaCommand {

	private Logger log = Logger.getLogger(CJDispositivaAnnulloCommand.class);



	@Autowired
	private DBCond0Service dbCond0Service;

	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;

	@Override
	protected EsitoResponseResource doExecute(){
		
		log.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("00", "OK");
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		String codUnitaOperativa = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA);
		String branchCode = ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode();
		String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();

	
		List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, dispositivaRequestDTO.getPratica().getCodPratica() , dispositivaRequestDTO.getPratica().getCodSuperPratica());
		if(CollectionUtils.isNotEmpty(listaAdesioni)) {

			if( CodProcessoEnum.CJ_AFFIDAMENTI.toString().equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
				
				List<PropostaEntity> listaProposte = coreConvenzioneService.getCodiciProposte(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(),  dispositivaRequestDTO.getPratica().getCodPratica());

				if(CollectionUtils.isNotEmpty(listaProposte)) {
					for(PropostaEntity proposta : listaProposte) {
						//annulla proposta sul database oracle COND0
						dbCond0Service.annullaProposta(codAbi, proposta.getAnnoProposta(), proposta.getCodiceProposta());
					}
				}
				
				coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPratica().getCodSuperPratica(),  dispositivaRequestDTO.getPratica().getCodPratica());

			}
			
			List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, dispositivaRequestDTO.getPratica().getCodPratica() , dispositivaRequestDTO.getPratica().getCodSuperPratica());
			List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, dispositivaRequestDTO.getPratica().getCodPratica() , dispositivaRequestDTO.getPratica().getCodSuperPratica());
			
			if(CollectionUtils.isNotEmpty(covenantDaAttivare) || CollectionUtils.isNotEmpty(covenantDaCessare)) {
				if(CollectionUtils.isNotEmpty(covenantDaAttivare) ) {
					covenantDaAttivare = recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);
				}
				
				// WS VDM rollback storecovenant
				callRollbackConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId);
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

	/*
	private EsitoOperazioneCJPOSV2 callWsRevocaProposta(String codAbi, String annoProposta, String codiceProposta, String dataRespinta,String userId,String codUnitaOperativa ) {

		RevocaProposta revocaProposta = wsRequestFactory.assemblaRequestRevocaProposta( codAbi,  annoProposta,  codiceProposta,  dataRespinta, userId, codUnitaOperativa );
		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSService.revocaProposta(revocaProposta,ispWebservicesHeaderType);
		log.info("_revocaProposta END");
		return esito;
	}
	 */
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
	
	
	
}
