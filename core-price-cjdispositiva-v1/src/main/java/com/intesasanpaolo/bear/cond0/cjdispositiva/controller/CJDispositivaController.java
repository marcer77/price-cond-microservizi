package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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

import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaInserimentoCommand;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaAnnulloCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ServiceUtil;
import com.intesasanpaolo.bear.core.controller.CoreController;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RestController
@RequestMapping("cjdispositiva")
@Validated
public class CJDispositivaController extends CoreController {

	private Logger log = Logger.getLogger(CJDispositivaController.class);

	@Autowired
	private BeanFactory beanFactory;

	@PostMapping(value = "/inserimento", produces = "application/json")
	public ResponseEntity<EsitoResponseResource> inserimento(
			@Valid @RequestBody(required = true) DispositivaRequestDTO dispositivaRequestDTO,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true, defaultValue = "") String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = true, defaultValue = "") String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false, defaultValue = "") String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true, defaultValue = "") String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true, defaultValue = "") String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true, defaultValue = "") String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false, defaultValue = "") String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = true, defaultValue = "") String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = true, defaultValue = "") String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true, defaultValue = "0") String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true, defaultValue = "") String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true, defaultValue = "") String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false, defaultValue = "") String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true, defaultValue = "") String channelIDCode) throws Exception
			 {
		log.info(" - inviaPropostaV2 START: ");
 
		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID(applicationID).callerCompanyIDCode(callerCompanyIDCode)
				.callerProgramName(callerProgramName).channelIDCode(channelIDCode).codABI(codABI)
				.codUnitaOperativa(codUnitaOperativa).customerID(customerID).isVirtualUser(isVirtualUser)
				.language(language).serviceCompanyIDCode(serviceCompanyIDCode).serviceID(serviceID).userID(userID)
				.transactionId(transactionId).timestamp(timestamp).serviceVersion(serviceVersion).build();

		   EsitoResponseResource esito = null;
		
			CJDispositivaInserimentoCommand cjDispositivaInserimentoCommand = beanFactory
					.getBean(CJDispositivaInserimentoCommand.class);
			cjDispositivaInserimentoCommand.setDispositivaRequestDTO(dispositivaRequestDTO);
			cjDispositivaInserimentoCommand.setIspWebservicesHeaderType(ispWebservicesHeaderType);
			esito = cjDispositivaInserimentoCommand.execute();
		
		
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

	@PostMapping(value = "/annullo", produces = "application/json")
	public ResponseEntity<EsitoResponseResource> annullo(
			@Valid @RequestBody(required = true) DispositivaRequestDTO dispositivaRequestDTO,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true, defaultValue = "") String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = true, defaultValue = "") String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false, defaultValue = "") String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true, defaultValue = "") String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true, defaultValue = "") String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true, defaultValue = "") String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false, defaultValue = "") String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = true, defaultValue = "") String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = true, defaultValue = "") String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true, defaultValue = "0") String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true, defaultValue = "") String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true, defaultValue = "") String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false, defaultValue = "") String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true, defaultValue = "") String channelIDCode) throws Exception
		{
		log.info(" - annullo START: ");
		
		CJDispositivaAnnulloCommand cjDispositivaAnnulloCommand = beanFactory
				.getBean(CJDispositivaAnnulloCommand.class);
		
		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID(applicationID).callerCompanyIDCode(callerCompanyIDCode)
				.callerProgramName(callerProgramName).channelIDCode(channelIDCode).codABI(codABI)
				.codUnitaOperativa(codUnitaOperativa).customerID(customerID).isVirtualUser(isVirtualUser)
				.language(language).serviceCompanyIDCode(serviceCompanyIDCode).serviceID(serviceID).userID(userID)
				.transactionId(transactionId).timestamp(timestamp).serviceVersion(serviceVersion).build();
		
		EsitoResponseResource esito = null;
		if(CodProcessoEnum.CJ_CUI_DA.toString().equals(dispositivaRequestDTO.getCodProcesso())) {
			
			// mock
			esito = new EsitoResponseResource("00", "");

		}else {
			cjDispositivaAnnulloCommand.setDispositivaRequestDTO(dispositivaRequestDTO);
			cjDispositivaAnnulloCommand.setIspWebservicesHeaderType(ispWebservicesHeaderType);
			esito = cjDispositivaAnnulloCommand.execute();
		}

		log.info(" - annullo END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

	
	
}
