package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception;

import java.io.StringWriter;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;

import lombok.Builder;


@Builder
public class CJConvenzioneNotFoundDB2Exception extends CJBaseException {

	private static final long serialVersionUID = 1L;

	private final String codSuperPratica;
	private final String nrPratica;

	@Override
	public String formattaMessaggio() {
		StringWriter sw = new StringWriter();
		sw.append("Nessuna Convenzione trovata per la pratica fornita ");
		sw.append(" [ ");
		sw.append(" codSuperPratica: "+codSuperPratica);
		sw.append(" nrPratica: "+nrPratica);
		sw.append(" ] ");
		return sw.toString();
	}

	@Override
	public String getErrorCode() {
		//per il microservizio Adesione è definito un diverso codice di errore per DB2
		return ErrorCode.DB2_EXCEPTION;
	}

}
