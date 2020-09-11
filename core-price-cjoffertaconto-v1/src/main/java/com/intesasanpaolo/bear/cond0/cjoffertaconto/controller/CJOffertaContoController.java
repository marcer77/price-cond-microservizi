package com.intesasanpaolo.bear.cond0.cjoffertaconto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.command.OffertaContoCommand;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.InputEsponiDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsponiResponseResource;
import com.intesasanpaolo.bear.core.controller.CoreController;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("cjoffertaconto")
public class CJOffertaContoController extends CoreController {
	
	
	@Autowired
	private BeanFactory beanFactory;

	@PostMapping(value = "/esponi", produces = "application/json")
	@ApiOperation(value = "Fornito in input un rapporto e l’elenco delle promozioni, la funzione provvede a fornire le informazioni relative all’offerta e prodotti correlati")
	public ResponseEntity<EsponiResponseResource> esponi(
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true) String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = true) String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false) String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true) String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true) String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true) String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false) String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = true) String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = true) String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true) String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true) String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true) String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false) String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true) String channelIDCode,
			
			@Valid @RequestBody InputEsponiDTO inputEsponiDTO) throws Exception {
		
		logger.info(HeaderAttribute.ISP_HEADER_COD_ABI+" "+codABI);
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE+" "+callerCompanyIDCode);
		logger.info(HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE+" "+serviceCompanyIDCode);
		logger.info(HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID+" "+userID);
		logger.info(HeaderAttribute.ISP_HEADER_TIMESTAMP+" "+timestamp);
		logger.info(HeaderAttribute.ISP_HEADER_TRANCACTION_ID+" "+transactionId);
		logger.info(HeaderAttribute.ISP_HEADER_APPLICATION_ID+" "+applicationID);
		logger.info(HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE+" "+channelIDCode);
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID(applicationID)
				.callerCompanyIDCode(callerCompanyIDCode)
				.callerProgramName(callerProgramName)
				.channelIDCode(channelIDCode)
				.codABI(codABI)
				.codUnitaOperativa(codUnitaOperativa)
				.customerID(customerID)
				.isVirtualUser(isVirtualUser)
				.language(language)
				.serviceCompanyIDCode(serviceCompanyIDCode)
				.serviceID(serviceID)
				.userID(userID)
				.transactionId(transactionId)
				.timestamp(timestamp)
				.serviceVersion(serviceVersion).build();
		
		OffertaContoCommand cmd = beanFactory.getBean(OffertaContoCommand.class, inputEsponiDTO,ispWebservicesHeaderType);
		EsponiResponseResource response = cmd.execute();

		

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
}
