package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.StampaResponseResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.HeaderAttribute;
import com.intesasanpaolo.bear.core.controller.CoreController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("cjadesioneconvenzione")
public class CJAdesioneConvenzioneController extends CoreController {

	@PostMapping(value = "/stampa", produces = "application/json")
	@ApiOperation(value = "Implementazione nuovo servizio per stampa addendum Bersani")
	public ResponseEntity<StampaResponseResource> stampa(
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true) String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = false) String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false) String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true) String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true) String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true) String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false) String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = false) String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = false) String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true) String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true) String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true) String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false) String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true) String channelIDCode,
			@RequestBody InputStampaDTO inputStampaDTO) throws Exception {

		StampaResponseResource stampaResponseResource = new StampaResponseResource();

		logger.info(HeaderAttribute.ISP_HEADER_APPLICATION_ID);
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE);
		logger.info(HeaderAttribute.ISP_HEADER_COD_ABI);
		logger.info(HeaderAttribute.ISP_HEADER_LANGUAGE);
		logger.info(HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER);
		logger.info(HeaderAttribute.ISP_HEADER_TRANCACTION_ID);
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID);
		logger.info(HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID);
		logger.info(HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE);

		stampaResponseResource.setKeyOper("012345678901234567890123456789");
		stampaResponseResource.setEsitoStampaResource(new EsitoStampaResource());
		stampaResponseResource.getEsitoStampaResource().setCodErrore("00");
		stampaResponseResource.getEsitoStampaResource().setDescErrore("");

		try(InputStream stream1 = CJAdesioneConvenzioneController.class.getResourceAsStream("/mock/01U33146920200626GFADD121837_1.xml");
			InputStream stream2 = CJAdesioneConvenzioneController.class.getResourceAsStream("/mock/01U33146920200626GFADD121837_1.xml");
			) {
				StringWriter writer1 = new StringWriter();
				IOUtils.copy(stream1, writer1, StandardCharsets.UTF_8);

				StringWriter writer2 = new StringWriter();
				IOUtils.copy(stream2, writer2, StandardCharsets.UTF_8);

				stampaResponseResource.setDocumento(writer1.toString().concat(writer2.toString()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(stampaResponseResource);

	}

}
