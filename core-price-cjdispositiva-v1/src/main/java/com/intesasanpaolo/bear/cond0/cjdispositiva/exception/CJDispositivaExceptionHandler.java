package com.intesasanpaolo.bear.cond0.cjdispositiva.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.handler.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CJDispositivaExceptionHandler extends CJBaseExceptionHandler<EsitoResponseResource> {
	
	@Override
	public EsitoResponseResource errorResponseForCJBaseException(String errorCode, String errorMessage) {
		EsitoResponseResource esito = new EsitoResponseResource(errorCode, errorMessage);
		return esito;
	}

}
