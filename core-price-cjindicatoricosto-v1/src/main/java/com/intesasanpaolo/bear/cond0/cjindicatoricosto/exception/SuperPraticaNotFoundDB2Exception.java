package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;

import org.springframework.http.HttpStatus;

public class SuperPraticaNotFoundDB2Exception extends CJBaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperPraticaNotFoundDB2Exception(String codSuperPratica) {
		super("Nessuna Pratica trovata per SuperPratica "+codSuperPratica,ErrorCode.SUPERPATICA_NOT_FOUND_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
