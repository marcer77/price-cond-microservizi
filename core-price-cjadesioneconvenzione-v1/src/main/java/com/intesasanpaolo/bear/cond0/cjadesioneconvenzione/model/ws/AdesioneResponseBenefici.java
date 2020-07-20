package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class AdesioneResponseBenefici {
	
    private ConfigurazioneFasce configurazioneFasceApprovato;
    private String beneficioTipologia;
    private String beneficioValoreCodice;
    private BigDecimal beneficioValoreNumerico;
    private AdesioneResponseBeneficioValoreParametrato beneficioValoreParametrato;
    private String codiceCondizione;
    private String codiceFascia;
    private String dataDecorrenza;
    private String dataScadenza;
    private String driver1Tipologia;
    private String driver1ValoreCodice;
    private BigDecimal driver1ValoreNumerico;
    private String driver2Tipologia;
    private String driver2ValoreCodice;
    private BigDecimal driver2ValoreNumerico;
    private String flagRolling;
    private Short numeroFascia;

}
