package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception;

import java.io.StringWriter;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;

import lombok.Builder;

@Builder
public class CJWebServiceException extends CJBaseException {

	private static final long serialVersionUID = 1L;
	private final String webServiceName;
	private final String codiceErroreWebService;
	private final String descrErroreWebService;
	

	@Override
	public String formattaMessaggio() {
		StringWriter st = new StringWriter();
		st.append("Si è verifica un errore durante l'invocazione del WebService ").append(webServiceName);
		st.append(" [ ");
		st.append(" codiceErroreWebService:").append(codiceErroreWebService);
		st.append(" descrErroreWebService:").append(descrErroreWebService);
		st.append(" ] ");
		return st.toString();
	}

	@Override
	public String getErrorCode() {
		//il codice di errore del microservizio è 97
		return CommonErrorCode.BS_SRV_EXCEPTION;
	}

}
