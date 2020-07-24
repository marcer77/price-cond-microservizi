package com.intesasanpaolo.bear.cond0.cjvariazionicons.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.assembler.StampaResponseResourceAssembler;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.command.StampaCommand;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.StampaResponse;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.StampaResponseResource;
import com.intesasanpaolo.bear.core.controller.CoreController;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.exceptions.BearDomainRuntimeException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("cjvariazionicons")
@Validated
public class CJVariazioniController extends CoreController {

	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private StampaResponseResourceAssembler stampaResponseResourceAssembler;
	
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
			//@Valid 
			@RequestBody InputStampaDTO inputStampaDTO) throws Exception {

		logger.info("start EndPoint stampa");
		
		StampaResponseResource stampaResponseResource=null;
		
		try {
			
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
					
			
			StampaCommand stampaCommand = beanFactory.getBean(StampaCommand.class, inputStampaDTO,ispWebservicesHeaderType);
			StampaResponse stampaResponse = stampaCommand.execute();
			
			stampaResponseResource= stampaResponseResourceAssembler.toResource(stampaResponse);
					
		
		} catch (Exception e) {
			logger.error("Errore in EndPoint stampa: ", e);
			throw new BearDomainRuntimeException("Errore generico in Stampa", "", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(HttpStatus.OK).body(stampaResponseResource);

	}
	
	
}
/*
Content-Type:application/json
Accept:application/json
ISPWebservicesHeader.AdditionalBusinessInfo.CodABI:01025
ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode:01
ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode:01
ISPWebservicesHeader.OperatorInfo.UserID:U015886
ISPWebservicesHeader.RequestInfo.Timestamp:0
ISPWebservicesHeader.RequestInfo.TransactionId:0
ISPWebservicesHeader.TechnicalInfo.ApplicationID:0
ISPWebservicesHeader.TechnicalInfo.ChannelIDCode:0
*/