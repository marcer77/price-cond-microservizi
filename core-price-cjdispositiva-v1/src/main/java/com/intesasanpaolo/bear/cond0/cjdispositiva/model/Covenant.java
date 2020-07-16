package com.intesasanpaolo.bear.cond0.cjdispositiva.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Covenant {
	
	private String beneficioCondizionatoDataFine;
	private String beneficioCondizionatoDataInizio;
	private String beneficioIncondizionatoDataFine;
	private String beneficioIncondizionatoDatainizio;
	private String beneficioIncondizionatoNumrilevazioni;
	private String beneficioIncondizionatoPresente;
	private String beneficioIngressoDataFine;
	private String beneficioIngressoDataInizio;
	private String beneficioIngressoPresente;
	private String codCondizione;
	private String codCondizioneRealeMlt;
	private String covenantDataFine;
	private String covenantDataInizio;
	private String flagEntitaPrincipale;
	private String progressivo;
	private String rapportoCategoria;
	private String rapportoConto;
	private String rapportoFiliale;
	private String codiceTemplate;
	private String condizioniFiglie;
	private String livelloGerarchia;
	private String versioneTemplate;

}
