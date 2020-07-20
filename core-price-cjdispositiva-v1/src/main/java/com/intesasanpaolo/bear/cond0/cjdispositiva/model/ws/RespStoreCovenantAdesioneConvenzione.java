package com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespStoreCovenantAdesioneConvenzione {
	
	private List<ErrorCovenant> listaErroriCovenantDaAttivare;
	private List<ErrorCovenant> listaErroriCovenantDaCessare;
	private String esitoErrorMessage;
	private String esitoResultCode;

}
