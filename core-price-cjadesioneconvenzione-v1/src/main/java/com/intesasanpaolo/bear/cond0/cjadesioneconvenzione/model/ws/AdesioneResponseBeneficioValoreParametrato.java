package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdesioneResponseBeneficioValoreParametrato {

	private String parametroCodice1;
	private BigDecimal parametroPerc1;
	private BigDecimal parametroSpread;


}
