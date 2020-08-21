package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
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
public class CJDispositivaInserimentoCommand extends BaseCommand<EsitoResponseResource> {

	private Logger log = Logger.getLogger(CJDispositivaInserimentoCommand.class);

	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	
	private DispositivaRequestDTO dispositivaRequestDTO;

	@Autowired
	private GestioneService gestioneService;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;
	
	@Autowired
	private ConvenzioniHostService convenzioniHostService;
	
	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;
	
	@Autowired
	private CoreConvenzioneService coreConvenzioneService;
	
	private WsRequestFactory wsRequestFactory = new WsRequestFactory();

	@Override
	protected EsitoResponseResource doExecute() throws Exception {
		log.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("00", "OK");
			InformazioniPraticaDTO informazioniPraticaDTO = new InformazioniPraticaDTO();
			String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
			String branchCode = ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode();
			String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();

			// Recupero informazioni superpratica (…)
			List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
			if(CollectionUtils.isNotEmpty(listaAdesioni)) {
				List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
				List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodPratica() , dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
				
				covenantDaAttivare = recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);

				// IIB PCK8 PCGESTIXME/Gestione aggiornamento Condizioni
//				NewAccountOutput output = callGestioneService(informazioniPraticaDTO);

				// WS VDM StoreCovenantAdesioneConvenzione
				RespStoreCovenantAdesioneConvenzione resp = callConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId);
		
				//6)	Se input.codProcesso == ‘CJAFF’
				//  •	DELETE codici proposte
				if("CJAFF".equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {
					coreConvenzioneService.deleteCodiciProposte(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(),  dispositivaRequestDTO.getPraticaDTO().getCodPratica());
					List<RapportoEntity> elencoRapporti = coreConvenzioneService.getElencoRapportiConTassiAbbattuti(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica());
					
					elencoRapporti.stream().forEach(rapporto -> {

						List<TassoEntity> tassiAbbattuti = coreConvenzioneService.getElencoTassiAbbattuti(codAbi, dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica(), rapporto);
						// WS COND0 GESTCJPOSV.inviaPropostaV2
//						EsitoOperazioneCJPOSV2 esitoOperazione = callInviaPropostaV2Service(informazioniPraticaDTO);

					});

				}


				// BS PCMK registrazione elenco cod.prop. “fittizie”
				boolean esito = recuperoInformazioniService.registrazioneCodFittizie();

			}else {
				throw CJDispositivaNotFoundDB2Exception.builder().messaggio("Nessuna Adesione trovata per la pratica fornita [ codSuperPratica:{}, nrPratica:{} ]")
				.param(new String[]{dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica(), dispositivaRequestDTO.getPraticaDTO().getCodPratica()}).build();
			}

			log.info("execute SUCCESS ");
			return esitoResource;
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

	private RespStoreCovenantAdesioneConvenzione callConvenzioniHostService(AdesioneEntity adesione, List<CovenantEntity> covenantDaAttivare, List<CovenantEntity> covenantDaCessare, String codAbi, String codProcesso, String branchCode , String userId) {
		log.info("callStoreCovenantAdesioneConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = wsRequestFactory.assemblaRequestConvenzione(adesione,covenantDaAttivare, covenantDaCessare, codAbi, codProcesso , branchCode, userId);
		RespStoreCovenantAdesioneConvenzione resp = convenzioniHostService.storeCovenantAdesioneConvenzione(request);
		log.info("callStoreCovenantAdesioneConvenzione END");
		checkResponseStoreCovenantAdesioneConvenzione(resp);
		return resp;
	}
	
	private EsitoOperazioneCJPOSV2 callInviaPropostaV2Service(InformazioniPraticaDTO informazioniPraticaDTO) throws BearForbiddenException {
		log.info("inviaPropostaV2 START");

		EsitoOperazioneCJPOSV2 esitoOperazione = new EsitoOperazioneCJPOSV2();
		if (informazioniPraticaDTO != null) {
			InviaPropostaV2 request = wsRequestFactory.assemblaRequestInviaProposta(informazioniPraticaDTO);
			log.info("inviaPropostaV2 CAN EXECUTE");
			esitoOperazione = proposteCJPOSWSService.inviaPropostaV2(request, ispWebservicesHeaderType);
		} else {
			log.info("inviaPropostaV2 ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
		log.info("inviaPropostaV2 END");
		return esitoOperazione;
	}

	private NewAccountOutput callGestioneService(InformazioniPraticaDTO informazioniPraticaDTO) throws BearForbiddenException {
		log.info("callWsGestione START");
		if (informazioniPraticaDTO != null) {
			log.info("callWsGestione CAN EXECUTE");

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

			NewAccountInput newAccountInput = wsRequestFactory.assemblaRequestGestione(informazioniPraticaDTO);
			
			return gestioneService.gestione(newAccountInput, headerParams);

		} else {
			log.info("callWsGestione ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}
	
	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	public void setDispositivaRequestDTO(DispositivaRequestDTO dispositivaRequestDTO) {
		this.dispositivaRequestDTO = dispositivaRequestDTO;
	}

}
