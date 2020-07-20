package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BloccoValore {

	    private String codice;
	    private String tipoDeroga;
	    private BigDecimal valoreNumerico;
	    private ValoreParametrato valoreParametrato;
	
}
