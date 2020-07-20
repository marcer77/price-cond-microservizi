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
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ServiceUtil;
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
			@RequestBody(required = false) InviaPropostaV2 inviaPropostaV2,

			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.TransactionId", required = false, defaultValue = "NPUA020200417GEN00164904998") String transactionId,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.Timestamp", required = false, defaultValue = "1587135953280") String timestamp,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.ServiceID", required = false, defaultValue = "PCGESTIXME") String serviceID,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.ServiceVersion", required = false, defaultValue = "00") String serviceVersion,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.Language", required = false, defaultValue = "I") String language,

			@RequestHeader(value = "ISPWebservicesHeader.OperatorInfo.UserID", required = false, defaultValue = "U004835") String userID,
			@RequestHeader(value = "ISPWebservicesHeader.OperatorInfo.IsVirtualUser", required = false) String isVirtualUser,

			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", required = false, defaultValue = "01") String ispCallerCompanyIDCode,
			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPBranchCode", required = false, defaultValue = "01383") String ispBranchCode,
			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", required = false, defaultValue = "01") String ispServiceCompanyIDCode,

			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.CustomerID", required = false, defaultValue = "0002896811838000") String customerID,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessProcessName", required = false, defaultValue = "anonym") String businessProcessName,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessProcessID", required = false, defaultValue = "anonym") String businessProcessID,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessOperation", required = false, defaultValue = "anonym") String businessOperation,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessFileID", required = false, defaultValue = "anonym") String businessFileID,

			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", required = false, defaultValue = "31") String channelIDCode,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ApplicationID", required = false, defaultValue = "NPUC0") String applicationID,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.CallerServerName", required = false, defaultValue = "salclp8940") String callerServerName,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.CallerProgramName", required = false, defaultValue = "NPUC0") String callerProgramName,

			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.COD_ABI", required = false, defaultValue = "01025") String codAbi,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.COD_UNITA_OPERATIVA", required = false, defaultValue = "01383") String codUnitaOperativa,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.COD_OPERATIVITA", required = false, defaultValue = "0") String codOperativa,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.DATA_CONTABILE", required = false, defaultValue = "1007020") String dataContabile

	) throws Exception {
		log.info(" - inviaPropostaV2 START: ");

		ISPWebservicesHeaderType header = ServiceUtil.buildISPWebservicesHeader(transactionId, timestamp, serviceID,
				serviceVersion, language, userID, isVirtualUser, ispCallerCompanyIDCode, ispBranchCode,
				ispServiceCompanyIDCode, customerID, businessProcessName, businessProcessID, businessOperation,
				businessFileID, channelIDCode, applicationID, callerServerName, callerProgramName, codAbi,
				codUnitaOperativa, codOperativa, dataContabile);

		ProposteCJPOSWSInviaPropostaV2Command proposteCJPOSWSInviaPropostaV2Command = beanFactory
				.getBean(ProposteCJPOSWSInviaPropostaV2Command.class);
		proposteCJPOSWSInviaPropostaV2Command.setInviaPropostaV2(inviaPropostaV2);
		proposteCJPOSWSInviaPropostaV2Command.setHeader(header);
		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSInviaPropostaV2Command.execute();
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

	@PostMapping(value = "/wsProposteCJPOSrevocaProposta", produces = "application/json")
	@ApiOperation(value = "WS ProposteCJPOS revocaProposta")
	public ResponseEntity<EsitoOperazioneCJPOSV2> revocaProposta(
			@RequestBody(required = false) RevocaProposta propostaV2,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.TransactionId", required = false, defaultValue = "NPUA020200417GEN00164904998") String transactionId,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.Timestamp", required = false, defaultValue = "1587135953280") String timestamp,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.ServiceID", required = false, defaultValue = "PCGESTIXME") String serviceID,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.ServiceVersion", required = false, defaultValue = "00") String serviceVersion,
			@RequestHeader(value = "ISPWebservicesHeader.RequestInfo.Language", required = false, defaultValue = "I") String language,

			@RequestHeader(value = "ISPWebservicesHeader.OperatorInfo.UserID", required = false, defaultValue = "U004835") String userID,
			@RequestHeader(value = "ISPWebservicesHeader.OperatorInfo.IsVirtualUser", required = false) String isVirtualUser,

			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", required = false, defaultValue = "01") String ispCallerCompanyIDCode,
			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPBranchCode", required = false, defaultValue = "01383") String ispBranchCode,
			@RequestHeader(value = "ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", required = false, defaultValue = "01") String ispServiceCompanyIDCode,

			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.CustomerID", required = false, defaultValue = "0002896811838000") String customerID,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessProcessName", required = false, defaultValue = "anonym") String businessProcessName,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessProcessID", required = false, defaultValue = "anonym") String businessProcessID,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessOperation", required = false, defaultValue = "anonym") String businessOperation,
			@RequestHeader(value = "ISPWebservicesHeader.BusinessInfo.BusinessFileID", required = false, defaultValue = "anonym") String businessFileID,

			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", required = false, defaultValue = "31") String channelIDCode,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ApplicationID", required = false, defaultValue = "NPUC0") String applicationID,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.CallerServerName", required = false, defaultValue = "salclp8940") String callerServerName,
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.CallerProgramName", required = false, defaultValue = "NPUC0") String callerProgramName,

			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.COD_ABI", required = false, defaultValue = "01025") String codAbi,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.COD_UNITA_OPERATIVA", required = false, defaultValue = "01383") String codUnitaOperativa,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.COD_OPERATIVITA", required = false, defaultValue = "0") String codOperativa,
			@RequestHeader(value = "ISPWebservicesHeader.AdditionalBusinessInfo.DATA_CONTABILE", required = false, defaultValue = "1007020") String dataContabile)
			throws Exception {
		log.info(" - inviaPropostaV2 START: ");
		ProposteCJPOSWSRevocaPropostaCommand proposteCJPOSWSRevocaPropostaCommand = beanFactory
				.getBean(ProposteCJPOSWSRevocaPropostaCommand.class);

		ISPWebservicesHeaderType header = ServiceUtil.buildISPWebservicesHeader(transactionId, timestamp, serviceID,
				serviceVersion, language, userID, isVirtualUser, ispCallerCompanyIDCode, ispBranchCode,
				ispServiceCompanyIDCode, customerID, businessProcessName, businessProcessID, businessOperation,
				businessFileID, channelIDCode, applicationID, callerServerName, callerProgramName, codAbi,
				codUnitaOperativa, codOperativa, dataContabile);

		proposteCJPOSWSRevocaPropostaCommand.setRevocaProposta(propostaV2);
		proposteCJPOSWSRevocaPropostaCommand.setHeader(header);
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
			@RequestHeader(value = "ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", required = false, defaultValue = "0") String channelIDCode)
			throws Exception {
		log.info(" - gestione START: ");
		HashMap<String, String> headerParams = new HashMap<String, String>();
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
