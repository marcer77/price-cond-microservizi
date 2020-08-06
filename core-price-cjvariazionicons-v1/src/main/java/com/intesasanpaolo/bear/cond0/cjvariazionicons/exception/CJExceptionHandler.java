package com.intesasanpaolo.bear.cond0.cjvariazionicons.exception;

import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.StampaResponseResource;
import com.intesasanpaolo.bear.config.LoggerUtils;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class CJExceptionHandler extends CJBaseExceptionHandler<StampaResponseResource>{
	private static final Logger logger = LoggerUtils.getLogger(CJExceptionHandler.class);

	@Override
	public StampaResponseResource getBaseResource() {
		return StampaResponseResource.builder().documento(null).esitoStampaResource(null).build();
		
	}
	@ExceptionHandler({ CJBaseException.class })
    public ResponseEntity<StampaResponseResource> handleException(CJBaseException e) {
		logger.error("handleException {}", e.getMessage(), e);
		
		EsitoStampaResource esito=new EsitoStampaResource();
		esito.setCodErrore(e.getErrorCode());
	    esito.setDescErrore(e.formattaMessaggio());
	    StampaResponseResource resource = StampaResponseResource.builder().esitoStampaResource(esito).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(resource);    	
    } 
	
	
}
