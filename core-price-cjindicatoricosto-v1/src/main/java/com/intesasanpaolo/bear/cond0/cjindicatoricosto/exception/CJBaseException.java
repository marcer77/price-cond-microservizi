package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;

import org.springframework.http.HttpStatus;

import com.intesasanpaolo.bear.exceptions.BearDomainRuntimeException;

public class CJBaseException extends BearDomainRuntimeException{
/*
	public CJBaseException(String message, String code, HttpStatus responseStatus, BearErrorTypeEnum errorType,
			BearSeverityEnum severity, Map<String, Object> additionalInfo, String rawRemoteError, String remoteSource) {
		super(message, code, responseStatus, errorType, severity, additionalInfo, rawRemoteError, remoteSource);
		// TODO Auto-generated constructor stub
	}

	public CJBaseException(String message, String code, HttpStatus responseStatus, BearErrorTypeEnum errorType,
			BearSeverityEnum severity, Map<String, Object> additionalInfo) {
		super(message, code, responseStatus, errorType, severity, additionalInfo);
		// TODO Auto-generated constructor stub
	}

	public CJBaseException(String message, String code, HttpStatus responseStatus, BearErrorTypeEnum errorType,
			BearSeverityEnum severity, String rawRemoteError, String remoteSource) {
		super(message, code, responseStatus, errorType, severity, rawRemoteError, remoteSource);
		// TODO Auto-generated constructor stub
	}

	public CJBaseException(String message, String code, HttpStatus responseStatus, BearErrorTypeEnum errorType,
			BearSeverityEnum severity) {
		super(message, code, responseStatus, errorType, severity);
		// TODO Auto-generated constructor stub
	}
*/
	public CJBaseException(String message, String code, HttpStatus responseStatus) {
		super(message, code, responseStatus);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
