package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TB59R009 {
	
	private String NrSuperpratica;
	private String NrPratica;
	private String IdEntita;
	private String Stato;
	private int ProgrEntita;
	private int ProgrDati;
	private String CodEntita;
	private String DatiEntita;
	private String TipoAggiornamento;
	private String CodOpeUltModif;
	private String DataInser;
	private String DtUltModifica;

}
