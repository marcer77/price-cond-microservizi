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
public class ValoreParametrato {

	    private String codice1;
	    private Float perc1;
	    private BigDecimal spread;
	
	
}
