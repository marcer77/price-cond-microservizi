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
public class AdesioneResponseBeneficioValoreParametrato {

	private String parametroCodice1;
	private BigDecimal parametroPerc1;
	private BigDecimal parametroSpread;

	private String parametroCodice2;
	private BigDecimal parametroPerc2;
}
