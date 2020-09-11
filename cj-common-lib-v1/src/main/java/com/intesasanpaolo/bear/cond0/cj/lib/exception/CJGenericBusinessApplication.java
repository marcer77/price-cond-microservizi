package com.intesasanpaolo.bear.cond0.cj.lib.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CJGenericBusinessApplication extends CJBaseException{
	private static final long serialVersionUID = 1L;
	
	private final String errorCode;
	private final String message;
	
	public CJGenericBusinessApplication(String errorCode,String message,Exception e){
		super(e);
		this.errorCode=errorCode;
		this.message=message;
	}
	@Override
	public String formattaMessaggio() {
		return message;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}


}
