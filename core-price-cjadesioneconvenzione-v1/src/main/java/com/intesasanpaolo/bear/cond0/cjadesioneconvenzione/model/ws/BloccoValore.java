package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloccoValore {

	    private String codice;
	    private String tipoDeroga;
	    private BigDecimal valoreNumerico;
	    private ValoreParametrato valoreParametrato;
	
}
