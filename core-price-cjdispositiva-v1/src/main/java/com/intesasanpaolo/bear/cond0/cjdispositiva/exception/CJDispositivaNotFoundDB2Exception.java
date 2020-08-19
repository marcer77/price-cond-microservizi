package com.intesasanpaolo.bear.cond0.cjdispositiva.exception;

import org.slf4j.helpers.MessageFormatter;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;

import lombok.Builder;


@Builder
public class CJDispositivaNotFoundDB2Exception extends CJBaseException {

	private static final long serialVersionUID = 1L;
	private final String messaggio;
	private final String[] param;
	
	@Override
	public String formattaMessaggio() {
		return MessageFormatter.arrayFormat(messaggio, param).getMessage();
	}

	@Override
	public String getErrorCode() {
		//per il microservizio Adesione è definito un diverso codice di errore per DB2
		return ErrorCode.DB2_EXCEPTION;
	}

}
