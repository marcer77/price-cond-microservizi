package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import javax.validation.Valid;

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

import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaInserimentoCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaAnnulloCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
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
	public ResponseEntity<EsitoResource> inserimento(
			@Valid @RequestBody(required = false) DispositivaRequestDTO dispositivaRequestDTO,

			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true, defaultValue = "01025") String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = false, defaultValue = "01383") String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false, defaultValue = "0002896811838000") String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true, defaultValue = "01") String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true, defaultValue = "01") String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true, defaultValue = "U004835") String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false, defaultValue = "I") String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = false, defaultValue = "PCGESTIXME") String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = false, defaultValue = "00") String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true, defaultValue = "1587135953280") String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true, defaultValue = "NPUA020200417GEN00164904998") String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true, defaultValue = "NPUC0") String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false, defaultValue = "NPUC0") String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true, defaultValue = "31") String channelIDCode)
			throws Exception {
		log.info(" - inviaPropostaV2 START: ");

		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID(applicationID).callerCompanyIDCode(callerCompanyIDCode)
				.callerProgramName(callerProgramName).channelIDCode(channelIDCode).codABI(codABI)
				.codUnitaOperativa(codUnitaOperativa).customerID(customerID).isVirtualUser(isVirtualUser)
				.language(language).serviceCompanyIDCode(serviceCompanyIDCode).serviceID(serviceID).userID(userID)
				.transactionId(transactionId).timestamp(timestamp).serviceVersion(serviceVersion).build();

		CJDispositivaInserimentoCommand proposteCJPOSWSInviaPropostaV2Command = beanFactory
				.getBean(CJDispositivaInserimentoCommand.class);
		proposteCJPOSWSInviaPropostaV2Command.setInviaPropostaV2(dispositivaRequestDTO);
		proposteCJPOSWSInviaPropostaV2Command.setHeader(ispWebservicesHeaderType);
		EsitoResource esito = proposteCJPOSWSInviaPropostaV2Command.execute();
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

	@PostMapping(value = "/annullo", produces = "application/json")
	public ResponseEntity<EsitoResource> annullo(
			@Valid @RequestBody(required = false) DispositivaRequestDTO dispositivaRequestDTO,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true, defaultValue = "01025") String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = false, defaultValue = "01383") String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false, defaultValue = "0002896811838000") String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true, defaultValue = "01") String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true, defaultValue = "01") String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true, defaultValue = "U004835") String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false, defaultValue = "I") String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = false, defaultValue = "PCGESTIXME") String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = false, defaultValue = "00") String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true, defaultValue = "1587135953280") String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true, defaultValue = "NPUA020200417GEN00164904998") String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true, defaultValue = "NPUC0") String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false, defaultValue = "NPUC0") String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true, defaultValue = "31") String channelIDCode)
			throws Exception {
		log.info(" - annullo START: ");
		CJDispositivaAnnulloCommand proposteCJPOSWSRevocaPropostaCommand = beanFactory
				.getBean(CJDispositivaAnnulloCommand.class);

		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID(applicationID).callerCompanyIDCode(callerCompanyIDCode)
				.callerProgramName(callerProgramName).channelIDCode(channelIDCode).codABI(codABI)
				.codUnitaOperativa(codUnitaOperativa).customerID(customerID).isVirtualUser(isVirtualUser)
				.language(language).serviceCompanyIDCode(serviceCompanyIDCode).serviceID(serviceID).userID(userID)
				.transactionId(transactionId).timestamp(timestamp).serviceVersion(serviceVersion).build();

		proposteCJPOSWSRevocaPropostaCommand.setDispositivaRequestDTO(dispositivaRequestDTO);
		proposteCJPOSWSRevocaPropostaCommand.setIspWebservicesHeaderType(ispWebservicesHeaderType);
		EsitoResource esito = proposteCJPOSWSRevocaPropostaCommand.execute();
		log.info(" - annullo END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

}
