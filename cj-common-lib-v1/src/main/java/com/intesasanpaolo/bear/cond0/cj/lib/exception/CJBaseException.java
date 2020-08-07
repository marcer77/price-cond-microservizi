package com.intesasanpaolo.bear.cond0.cj.lib.exception;

public abstract class CJBaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public abstract String formattaMessaggio();

	public abstract String getErrorCode();
	
	
}
