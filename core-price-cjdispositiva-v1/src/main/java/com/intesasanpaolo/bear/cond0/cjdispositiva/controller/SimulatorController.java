package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PropostaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.core.controller.CoreController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("simulator")
@Validated
public class SimulatorController extends CoreController {

	private Logger log = Logger.getLogger(SimulatorController.class);

	@PostMapping(value = "/wsProposteCJPOSinviaPropostaV2", produces = "application/json")
	@ApiOperation(value = "WS ProposteCJPOS inviaPropostaV2")
	public ResponseEntity<EsitoResource> inviaPropostaV2(@RequestBody(required = false) PropostaDTO proposta,

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

		// mock
		EsitoResource esito = new EsitoResource();
		esito.setCodErrore("00");
		esito.setDescErrore("");
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.status(HttpStatus.OK).body(esito);
	}

	@PostMapping(value = "/wsProposteCJPOSrevocaProposta", produces = "application/json")
	@ApiOperation(value = "WS ProposteCJPOS revocaProposta")
	public ResponseEntity<EsitoResource> revocaProposta(@RequestBody(required = false) PropostaDTO proposta,
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

		// mock
		EsitoResource esito = new EsitoResource();
		esito.setCodErrore("00");
		esito.setDescErrore("");
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

}
