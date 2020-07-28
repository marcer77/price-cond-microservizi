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
public class ValoreIndicatore {
	
	    private String alfanumericoSogliaA;
	    private String alfanumericoSogliaDa;
	    private String codiceFasciaIndicatore;
	    private BigDecimal numericoSogliaA;
	    private BigDecimal numericoSogliaDa;
	    private Short numeroFasciaDifferenziazione;
	    private String tipoIndicatore;
	    private Valore valore;

}
