package com.intesasanpaolo.bear.cond0.cjoffertaconto.command;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.InputEsponiDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsponiResponseResource;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OffertaContoCommand extends BaseCommand<EsponiResponseResource> {

	private Logger log = Logger.getLogger(OffertaContoCommand.class);


	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	private String codAbi;
	private InputEsponiDTO dto;

	public OffertaContoCommand(InputEsponiDTO inputEsponiDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = inputEsponiDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		/*boolean esitoControlli = false;
		logger.info(HeaderAttribute.ISP_HEADER_COD_ABI + " " + ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE + " " + ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
		logger.info(HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE + " " + ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
		logger.info(HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID + " " + ispWebservicesHeaderType.getOperatorInfo().getUserID());
		logger.info(HeaderAttribute.ISP_HEADER_TIMESTAMP + " " + ispWebservicesHeaderType.getRequestInfo().getTimestamp());
		logger.info(HeaderAttribute.ISP_HEADER_TRANCACTION_ID + " " + ispWebservicesHeaderType.getRequestInfo().getTransactionId());
		logger.info(HeaderAttribute.ISP_HEADER_APPLICATION_ID + " " + ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
		logger.info(HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE + " " + ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		esitoControlli = dto != null && !StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("canExecute END - " + esitoControlli);
		return esitoControlli;*/
		return true;
	}

	@Override
	protected EsponiResponseResource doExecute() {
		log.info("doExecute START");
		
		EsponiResponseResource response =new EsponiResponseResource();
		

		String codiceErrore = "00";
		response.getEsito().setCodErrore(codiceErrore);
		String descErrore="";
		response.getEsito().setDescErrore(descErrore);
		
		return response;
	}

}
