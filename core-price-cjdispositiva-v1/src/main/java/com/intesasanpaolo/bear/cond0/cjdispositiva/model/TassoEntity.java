package com.intesasanpaolo.bear.cond0.cjdispositiva.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TassoEntity {
	
	private String codCondizioneTX  ;
	private String decoCdzTX;
	private String decaCdzTX;
	private String tipoValCdzTX;
	private BigDecimal valoreCdzTX;
	private String cdParamTX;
	private BigDecimal percApplParTX;
	private String segnoSpreadTX;
	private BigDecimal valoreSprdTX;
	private String attributoRP;
}
