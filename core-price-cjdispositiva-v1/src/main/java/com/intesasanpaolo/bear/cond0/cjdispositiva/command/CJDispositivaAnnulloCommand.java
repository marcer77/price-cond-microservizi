package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaAnnulloCommand extends BaseCommand<EsitoResource> {

	private Logger log = Logger.getLogger(CJDispositivaAnnulloCommand.class);

	private DispositivaRequestDTO dispositivaRequestDTO;
	private NewAccountInput newAccountInput;

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	@Autowired
	private GestioneService gestioneService;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Override
	public EsitoResource execute() throws Exception {
		log.info("execute START");
		EsitoResource esitoResource = new EsitoResource("KO","Si è verificato un errore");
		if (canExecute()) {
			log.info("execute OK");

			// BS PCMK Recupero informazioni superpratica (…)
			// TODO

			// WS COND0 GESTCJPOSV.revocaProposta
			dispositivaRequestDTO = new DispositivaRequestDTO();
			EsitoOperazioneCJPOSV2 esitoOperazione = _revocaProposta();

			// BS PCMK aggiorna elenco cod.prop. fittizie
			// TODO

			// WS VDM rollback storecovenant
			// TODO

			// IIB PCK8 PCGESTIXME/Gestione rollback aggiornamento Condizioni
			newAccountInput = new NewAccountInput();
//			NewAccountOutput output = _callWsGestione(); //DA DECOMMENTARE APPENA FATTO IL MOCK DEL WS REST
 
			// return
			esitoResource.setCodErrore(esitoOperazione.getEsitoCodice());
			esitoResource.setDescErrore(esitoOperazione.getEsitoMessaggio());
			return esitoResource;
		} else {
			log.info("execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	private EsitoOperazioneCJPOSV2 _revocaProposta() throws BearForbiddenException {
		log.info("_revocaProposta START");
		if (dispositivaRequestDTO != null) {
			log.info("- _revocaProposta CAN EXECUTE");
			RevocaProposta revocaProposta = ProposteCJPOSWSUtils._buildMockRevocaProposta();
			EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSService.revocaProposta(revocaProposta,
					ispWebservicesHeaderType);

			log.info("_revocaProposta END");
			return esito;
		} else {
			log.info("_revocaProposta ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	private NewAccountOutput _callWsGestione() throws Exception {
		log.info("_callWsGestione START");
		if (newAccountInput != null) {
			log.info("_callWsGestione OK");

			HashMap<String, String> headerParams = new HashMap<String, String>();
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceID",
					ispWebservicesHeaderType.getRequestInfo().getServiceID());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode",
					ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode",
					ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
			List<Param> listParams = ispWebservicesHeaderType.getAdditionalBusinessInfo().getParam();
			if (listParams != null && listParams.size() > 0) {
				for (Param param : listParams) {
					if (ParamList.COD_ABI.equals(param.getName().COD_ABI)) {
						headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", param.getValue());
					}
					if (ParamList.COD_UNITA_OPERATIVA.equals(param.getName().COD_UNITA_OPERATIVA)) {
						headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa",
								param.getValue());
					}
				}
			}
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
			return gestioneService.gestione(newAccountInput, headerParams);
		} else {
			log.info("_callWsGestione ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		boolean esitoControlli = false;
		esitoControlli = ispWebservicesHeaderType != null;
		log.info("canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

}