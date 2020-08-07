package com.intesasanpaolo.bear.cond0.cjvariazionicons.exception;

import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.handler.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.StampaResponseResource;
import com.intesasanpaolo.bear.config.LoggerUtils;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class CJExceptionHandler extends CJBaseExceptionHandler<StampaResponseResource>{
	private static final Logger logger = LoggerUtils.getLogger(CJExceptionHandler.class);

	@Override
	public StampaResponseResource errorResponseForCJBaseException(String errorCode, String errorMessage) {
		EsitoStampaResource esito=new EsitoStampaResource();
		esito.setCodErrore(errorCode);
	    esito.setDescErrore(errorMessage);
	    StampaResponseResource resource = StampaResponseResource.builder().esitoStampaResource(esito).build();
		return resource;
	}
	
}
