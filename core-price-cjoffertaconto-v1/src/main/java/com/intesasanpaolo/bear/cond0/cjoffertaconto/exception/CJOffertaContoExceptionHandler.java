package com.intesasanpaolo.bear.cond0.cjoffertaconto.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.handler.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsponiResponseResource;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CJOffertaContoExceptionHandler extends CJBaseExceptionHandler<EsponiResponseResource> {
	// private static final Logger logger =
	// LoggerUtils.getLogger(CJAdesioneConvenzioneExceptionHandler.class);

	@Override
	public EsponiResponseResource errorResponseForCJBaseException(String errorCode, String errorMessage) {
		EsitoResource esito = new EsitoResource(errorCode, errorMessage);
		return EsponiResponseResource.builder().esito(esito).build();
	}

}
