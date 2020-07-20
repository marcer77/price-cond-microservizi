package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import lombok.Builder;
import lombok.Data;

/**
 * Response del servizio GetCovenantPerConvenzione
 * 
 *
 */
@Data
@Builder
public class RespGetCovenantPerConvenzioneCovenantDaAttivare {
	
    private String beneficioCondizionatoDataFine;
    private String beneficioCondizionatoDataInizio;
    private String beneficioIncondizionatoDataFine;
    private String beneficioIncondizionatoDataInizio;
    private String beneficioIncondizionatoNumRilevazioni;
    private String beneficioIncondizionatoPresente;
    private String beneficioIngressoDataFine;
    private String beneficioIngressoDataInizio;
    private String beneficioIngressoPresente;
    private String codCondizione;
    private String covenantDataFine;
    private String covenantDataInizio;
    private String flagEffettoRilevato;
    private String flagEventoEtaCliente;
    private String codiceTemplate;
    private String versioneTemplate;
    
}
