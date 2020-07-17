package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjdispositiva.command.ProposteCJPOSWSInviaPropostaV2Command;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.ProposteCJPOSWSRevocaPropostaCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.WSGestioneCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.controller.CoreController;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("simulator")
@Validated
public class SimulatorController extends CoreController {

	private Logger log = Logger.getLogger(SimulatorController.class);

	@Autowired
	private BeanFactory beanFactory;

	@PostMapping(value = "/wsProposteCJPOSinviaPropostaV2", produces = "application/json")
	@ApiOperation(value = "WS ProposteCJPOS inviaPropostaV2")
	public ResponseEntity<EsitoOperazioneCJPOSV2> inviaPropostaV2(
//			@RequestBody(required = false) InviaPropostaV2 propostaV2,
			@RequestBody(required = false) ISPWebservicesHeaderType header) throws Exception {
		log.info(" - inviaPropostaV2 START: ");
		ProposteCJPOSWSInviaPropostaV2Command proposteCJPOSWSInviaPropostaV2Command = beanFactory
				.getBean(ProposteCJPOSWSInviaPropostaV2Command.class);
		proposteCJPOSWSInviaPropostaV2Command.setInviaPropostaV2(ProposteCJPOSWSUtils._buildMockInviaPropostaV2());
		proposteCJPOSWSInviaPropostaV2Command.setHeader(ProposteCJPOSWSUtils._buildMockedHeaderInviaProstaV2());
		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSInviaPropostaV2Command.execute();
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

	@PostMapping(value = "/wsProposteCJPOSrevocaProposta", produces = "application/json")
	@ApiOperation(value = "WS ProposteCJPOS revocaProposta")
	public ResponseEntity<EsitoOperazioneCJPOSV2> revocaProposta(
//			@RequestBody(required = false) RevocaProposta propostaV2,
			@RequestBody(required = false) ISPWebservicesHeaderType header) throws Exception {
		log.info(" - inviaPropostaV2 START: ");
		ProposteCJPOSWSRevocaPropostaCommand proposteCJPOSWSRevocaPropostaCommand = beanFactory
				.getBean(ProposteCJPOSWSRevocaPropostaCommand.class);
		proposteCJPOSWSRevocaPropostaCommand.setRevocaProposta(ProposteCJPOSWSUtils._buildMockRevocaProposta());
		proposteCJPOSWSRevocaPropostaCommand.setHeader(ProposteCJPOSWSUtils._buildMockedHeaderRevocaProposta());
		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSRevocaPropostaCommand.execute();
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

	@PostMapping(value = "/wsGestione", produces = "application/json")
	@ApiOperation(value = "WS Gestione")
	public ResponseEntity<NewAccountOutput> gestione(@RequestBody NewAccountInput newAccountInput,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.ServiceID", required = false, defaultValue = "PCGESTIXME") String serviceID,
			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", required = false, defaultValue = "01") String ispCallerCompanyIDCode,
			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", required = false, defaultValue = "01") String ispServiceCompanyIDCode,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa", required = false, defaultValue = "00700") String codUnitaOperativa,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", required = false, defaultValue = "01025") String codABI,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.CustomerID", required = false, defaultValue = "0") String customerID,
			@RequestHeader(value = "ISPWebservicesHeader.OperatorInfo.UserID", required = false, defaultValue = "23232") String userID,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.Language", required = false, defaultValue = "0") String language,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.ServiceVersion", required = false, defaultValue = "0") String serviceVersion,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.Timestamp", required = false, defaultValue = "0") String timestamp,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.TransactionId", required = false, defaultValue = "0") String transactionId,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ApplicationID", required = false, defaultValue = "0") String applicationID,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.CallerProgramName", required = false, defaultValue = "0") String callerProgramName,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", required = false, defaultValue = "0") String channelIDCode
			) throws Exception {
		log.info(" - gestione START: ");
		HashMap<String,String> headerParams = new HashMap<String, String>();
		headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceID", "PCGESTIXME");
		headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa", "00700");
		headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		headerParams.put("ISPWebservicesHeader.BusinessInfo.CustomerID", "0");
		headerParams.put("ISPWebservicesHeader.OperatorInfo.UserID", "23232");
		headerParams.put("ISPWebservicesHeader.RequestInfo.Language", "0");
		headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceVersion", "0");
		headerParams.put("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		headerParams.put("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.CallerProgramName", "0");
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
		
		WSGestioneCommand wsGestioneCommand = beanFactory.getBean(WSGestioneCommand.class);
		wsGestioneCommand.setNewAccountInput(newAccountInput);
		wsGestioneCommand.setHeaderParams(headerParams);
		NewAccountOutput esito = wsGestioneCommand.execute();
		log.info(" - gestione END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

}
