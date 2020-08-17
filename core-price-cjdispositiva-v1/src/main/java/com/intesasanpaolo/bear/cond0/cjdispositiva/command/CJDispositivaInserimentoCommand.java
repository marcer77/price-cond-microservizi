package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;
import java.util.List;

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
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.Adesione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaInserimentoCommand extends BaseCommand<EsitoResource> {

	private Logger log = Logger.getLogger(CJDispositivaInserimentoCommand.class);

	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	private PraticaDTO praticaDTO;

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
	public EsitoResource execute() throws Exception {
		log.info("execute START");
		EsitoResource esitoResource = new EsitoResource("KO", "Si è verificato un errore.");
		if (canExecute()) {

			//TODO
//			List<String> codConvenzione = recuperoInformazioniSuperPratica();
//
//			if (codConvenzione != null && codConvenzione.size() == 1) {
//
//				String codiceConvenzione = codConvenzione.get(0);

			String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
			String codConvenzione = "";

			// Recupero informazioni superpratica (…)
			List<Adesione> result = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, praticaDTO.getCodPratica() , praticaDTO.getCodSuperPratica(), codConvenzione);

			// IIB PCK8 PCGESTIXME/Gestione aggiornamento Condizioni
			InformazioniPraticaDTO informazioniPraticaDTO = new InformazioniPraticaDTO();
			NewAccountOutput output = callGestioneService(informazioniPraticaDTO);

			// WS VDM StoreCovenantAdesioneConvenzione
			RespStoreCovenantAdesioneConvenzione resp = callConvenzioniHostService(informazioniPraticaDTO);

			// WS COND0 GESTCJPOSV.inviaPropostaV2
			EsitoOperazioneCJPOSV2 esitoOperazione = callInviaPropostaV2Service(informazioniPraticaDTO);

			// BS PCMK registrazione elenco cod.prop. “fittizie”
			boolean esito = recuperoInformazioniService.registrazioneCodFittizie();

			// return
			esitoResource.setCodErrore(esitoOperazione.getEsitoCodice());
			esitoResource.setDescErrore(esitoOperazione.getEsitoMessaggio());
			log.info("execute SUCCESS ");
			return esitoResource;
		} else {
			log.info("execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
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

	private RespStoreCovenantAdesioneConvenzione callConvenzioniHostService(InformazioniPraticaDTO informazioniPraticaDTO) {
		log.info("callStoreCovenantAdesioneConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = wsRequestFactory.assemblaRequestConvenzione(informazioniPraticaDTO);
		RespStoreCovenantAdesioneConvenzione resp = convenzioniHostService.storeCovenantAdesioneConvenzione(request);
		log.info("callStoreCovenantAdesioneConvenzione END");
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

	public void setPraticaDTO(PraticaDTO praticaDTO) {
		this.praticaDTO = praticaDTO;
	}

}
