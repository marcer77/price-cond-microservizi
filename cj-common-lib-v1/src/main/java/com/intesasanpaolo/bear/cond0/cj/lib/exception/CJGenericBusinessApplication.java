package com.intesasanpaolo.bear.cond0.cj.lib.exception;

import lombok.Builder;

@Builder
public class CJGenericBusinessApplication extends CJBaseException{
	private static final long serialVersionUID = 1L;
	
	private final String errorCode;
	private final String message;
	
	@Override
	public String formattaMessaggio() {
		return message;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

}
