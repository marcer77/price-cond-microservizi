package com.intesasanpaolo.bear.cond0.cj.lib.exception;

public abstract class CJBaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public abstract String formattaMessaggio();

	public abstract String getErrorCode();

	public CJBaseException() {
		super();
		
	}

	@Override
	public String getMessage() {
		return formattaMessaggio();
		
	}

	public CJBaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CJBaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CJBaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
