package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.handler.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.StampaResponseResource;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CJAdesioneConvenzioneExceptionHandler extends CJBaseExceptionHandler<StampaResponseResource> {
	// private static final Logger logger =
	// LoggerUtils.getLogger(CJAdesioneConvenzioneExceptionHandler.class);

	@Override
	public StampaResponseResource errorResponseForCJBaseException(String errorCode, String errorMessage) {
		EsitoStampaResource esito = new EsitoStampaResource(errorCode, errorMessage);
		return StampaResponseResource.builder().esitoStampaResource(esito).build();
	}

}
