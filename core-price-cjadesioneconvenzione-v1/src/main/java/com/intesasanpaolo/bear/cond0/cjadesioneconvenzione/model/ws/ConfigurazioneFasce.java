package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ConfigurazioneFasce {
	
    protected String codiceFasciaIndicatoreBeneficiIn;
    protected String codificaIndicatore;
    protected Short codificaIndicatoreSottorequisito;
    protected String disabilitaMonitoraggio;
    protected List<Fasce> listaFasce;
    protected Short numeroFasciaDifferenziazioneBeneficiIn;
    protected String periodicita;
}
