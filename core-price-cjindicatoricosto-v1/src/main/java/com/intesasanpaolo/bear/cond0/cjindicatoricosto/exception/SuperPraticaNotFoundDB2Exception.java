package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;

import java.io.StringWriter;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;

import lombok.Builder;

@Builder
public class SuperPraticaNotFoundDB2Exception extends CJBaseException {

	private static final long serialVersionUID = 1L;

	private final String codSuperPratica;

	@Override
	public String formattaMessaggio() {
		StringWriter sw = new StringWriter();
		sw.append("Nessuna Pratica trovata per SuperPratica ").append(codSuperPratica);
		return sw.toString();
	}

	@Override
	public String getErrorCode() {
		return CommonErrorCode.DB2_EXCEPTION;
	}

}
