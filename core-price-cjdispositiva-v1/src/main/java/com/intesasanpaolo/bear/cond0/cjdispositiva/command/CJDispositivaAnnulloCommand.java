package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaAnnulloCommand extends BaseCommand<EsitoResponseResource> {

	private Logger log = Logger.getLogger(CJDispositivaAnnulloCommand.class);

	private DispositivaRequestDTO dispositivaRequestDTO;

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	@Autowired
	private GestioneService gestioneService;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;

	@Autowired
	private ConvenzioniHostService convenzioniHostService;
	
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

		log.info("execute OK");

		List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
		if(CollectionUtils.isNotEmpty(listaAdesioni)) {

			if("CJAFF".equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
				
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
			callGestioneService(dispositivaRequestDTO, listaAdesioni.get(0));
			
			// BS PCMK aggiorna elenco cod.prop. fittizie
			callAggiornaCodfittizie();
		}
		
		// return
		return esitoResource;
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

	private List<CovenantEntity> recuperaInfoCovenantDaAttivare(String codAbi, List<CovenantEntity> covenantDaAttivare) {
		log.info("START recuperaInfoCovenantDaAttivare");
			for(CovenantEntity covenantEntity : covenantDaAttivare) {
				List<String> livelloGerarchia = coreConvenzioneService.getLivelloGerarchia(codAbi, covenantEntity.getCodCondizione());
				log.info("livelloGerarchia: "+livelloGerarchia);
				if(CollectionUtils.isNotEmpty(livelloGerarchia)) {
					if("1".equals(livelloGerarchia.get(0))) {
						List<String> stringaElencoCondizioniFiglie = coreConvenzioneService.getCondizioniFiglie(codAbi, covenantEntity.getCodCondizione());
						if(CollectionUtils.isNotEmpty(stringaElencoCondizioniFiglie) && stringaElencoCondizioniFiglie.get(0)!=null) {
							log.info("elencoCondizioniFiglie: "+stringaElencoCondizioniFiglie.get(0));
							covenantEntity.setCondizioniFiglie(stringaElencoCondizioniFiglie.get(0));
						}else {
							throw CJDispositivaNotFoundDB2Exception.builder().messaggio("CondizioniFiglie non recuperabili per il covCodCondizione: {}")
							.param(new String[]{covenantEntity.getCodCondizione()}).build();
						}
					}
					covenantEntity.setLivelloGerarchia(livelloGerarchia.get(0));
				}
			}
		log.info("END recuperaInfoCovenantDaAttivare");
		return covenantDaAttivare;
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

	private NewAccountOutput callGestioneService(DispositivaRequestDTO dispositivaRequestDTO, AdesioneEntity adesione) throws BearForbiddenException {
		log.info("callWsGestione START");

			HashMap<String, String> headerParams = new HashMap<String, String>();
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceID",
					ispWebservicesHeaderType.getRequestInfo().getServiceID());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode",
					ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode",
					ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
			headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI",
					ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
			headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa",
					ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA));
			headerParams.put("ISPWebservicesHeader.BusinessInfo.CustomerID",
					ispWebservicesHeaderType.getBusinessInfo().getCustomerID());
			headerParams.put("ISPWebservicesHeader.OperatorInfo.UserID",
					ispWebservicesHeaderType.getOperatorInfo().getUserID());
			headerParams.put("ISPWebservicesHeader.RequestInfo.Language",
					ispWebservicesHeaderType.getRequestInfo().getLanguage());
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceVersion",
					ispWebservicesHeaderType.getRequestInfo().getServiceVersion());
			headerParams.put("ISPWebservicesHeader.RequestInfo.Timestamp",
					ispWebservicesHeaderType.getRequestInfo().getTimestamp() + "");
			headerParams.put("ISPWebservicesHeader.RequestInfo.TransactionId",
					ispWebservicesHeaderType.getRequestInfo().getTransactionId());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.ApplicationID",
					ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.CallerProgramName",
					ispWebservicesHeaderType.getTechnicalInfo().getCallerProgramName());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode",
					ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());

			log.info("- callWsGestione END");

			NewAccountInput newAccountInput = wsRequestFactory.assemblaRequestGestione(dispositivaRequestDTO, adesione,ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA) ,ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
			
			NewAccountOutput newAccountOutput = gestioneService.gestione(newAccountInput, headerParams);
			
			if(!"00".equals(newAccountOutput.getOutput().getDatiDebug().getReturnCode())) {
				throw CJWebServiceException.builder().webServiceName("StoreCovenantAdesioneConvenzione").codiceErroreWebService(newAccountOutput.getOutput().getDatiDebug().getReturnCode())
				.descrErroreWebService(newAccountOutput.getOutput().getDatiDebug().getTxTMessaggio()).build();
			}
			
			return newAccountOutput;

	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		boolean esitoControlli = false;
		esitoControlli = !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
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

	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	public void setDispositivaRequestDTO(DispositivaRequestDTO dispositivaRequestDTO) {
		this.dispositivaRequestDTO = dispositivaRequestDTO;
	}
	
}
