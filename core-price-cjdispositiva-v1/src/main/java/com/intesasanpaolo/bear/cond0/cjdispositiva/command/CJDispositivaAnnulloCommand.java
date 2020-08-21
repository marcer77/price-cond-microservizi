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
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
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
public class CJDispositivaAnnulloCommand extends BaseCommand<EsitoResponseResource> {

	private Logger log = Logger.getLogger(CJDispositivaAnnulloCommand.class);

	private PraticaDTO praticaDTO;

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	@Autowired
	private GestioneService gestioneService;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;

	@Autowired
	private ConvenzioniHostService convenzioniHostService;

	private WsRequestFactory wsRequestFactory = new WsRequestFactory();

	@Override
	protected EsitoResponseResource doExecute() throws Exception {
		log.info("execute START");
		EsitoResponseResource esitoResource = new EsitoResponseResource("KO", "Si è verificato un errore");

		log.info("execute OK");

		// BS PCMK Recupero informazioni superpratica (…)
		InformazioniPraticaDTO informazioniPraticaDTO = recuperoInformazioniService.recuperaInformazioni(praticaDTO,
				ispWebservicesHeaderType);

		// WS COND0 GESTCJPOSV.revocaProposta
		EsitoOperazioneCJPOSV2 esitoOperazione = callWsRevocaProposta(informazioniPraticaDTO);

		// BS PCMK aggiorna elenco cod.prop. fittizie
		boolean esito = callAggiornaCodfittizie();

		// WS VDM rollback storecovenant
		RespRollbackStoreCovenantAdesioneConvenzione resp = callRollbackConvenzioniHostService(informazioniPraticaDTO);

		// IIB PCK8 PCGESTIXME/Gestione rollback aggiornamento Condizioni
		NewAccountOutput output = callWsGestione(informazioniPraticaDTO);

		// return
		esitoResource.setCodErrore(esitoOperazione.getEsitoCodice());
		esitoResource.setDescErrore(esitoOperazione.getEsitoMessaggio());
		return esitoResource;
	}

	private boolean callAggiornaCodfittizie() {
		log.info("callAggiornaCodfittizie START");
		log.info("callAggiornaCodfittizie END");
		return recuperoInformazioniService.aggiornaCodFittizie();
	}

	private EsitoOperazioneCJPOSV2 callWsRevocaProposta(InformazioniPraticaDTO informazioniPraticaDTO)
			throws BearForbiddenException {
		log.info("_revocaProposta START");
		if (informazioniPraticaDTO != null) {
			log.info("- _revocaProposta CAN EXECUTE");
			RevocaProposta revocaProposta = wsRequestFactory.assemblaRequestRevocaProposta(informazioniPraticaDTO);
			EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSService.revocaProposta(revocaProposta,
					ispWebservicesHeaderType);

			log.info("_revocaProposta END");
			return esito;
		} else {
			log.info("_revocaProposta ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	private NewAccountOutput callWsGestione(InformazioniPraticaDTO informazioniPraticaDTO) throws Exception {
		log.info("_callWsGestione START");
		if (informazioniPraticaDTO != null) {
			log.info("_callWsGestione OK");

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
			log.info("_callWsGestione END");

			//TODO COMPILARE CHIAMATA ANNULLA PER WS REST GESTIONE
			NewAccountInput newAccountInput = wsRequestFactory.assemblaRequestGestione(null, null, null, null);

			return gestioneService.gestione(newAccountInput, headerParams);
		} else {
			log.info("_callWsGestione ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	private RespRollbackStoreCovenantAdesioneConvenzione callRollbackConvenzioniHostService(
			InformazioniPraticaDTO informazioniPraticaDTO) {
		log.info("callStoreCovenantAdesioneConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = wsRequestFactory
				.assemblaRequestConvenzione(informazioniPraticaDTO);
		RespRollbackStoreCovenantAdesioneConvenzione resp = convenzioniHostService.rollbackStoreCovenantAdesioneConvenzione(request);
		log.info("callStoreCovenantAdesioneConvenzione END");
		return resp;
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

}
