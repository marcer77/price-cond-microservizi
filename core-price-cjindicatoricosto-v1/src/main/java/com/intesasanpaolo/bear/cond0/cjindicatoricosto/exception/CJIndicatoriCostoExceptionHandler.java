package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;

import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.handler.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.config.LoggerUtils;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CJIndicatoriCostoExceptionHandler extends CJBaseExceptionHandler<IndicatoriCostoResource> {
	private static final Logger logger = LoggerUtils.getLogger(CJIndicatoriCostoExceptionHandler.class);

	@Override
	public IndicatoriCostoResource errorResponseForCJBaseException(String errorCode, String errorMessage) {
		EsitoResource esito = new EsitoResource();
		esito.setCodErrore(errorCode);
		esito.setDescErrore(errorMessage);
		IndicatoriCostoResource resource = IndicatoriCostoResource.builder().esito(esito).build();
		return resource;
	}

}
