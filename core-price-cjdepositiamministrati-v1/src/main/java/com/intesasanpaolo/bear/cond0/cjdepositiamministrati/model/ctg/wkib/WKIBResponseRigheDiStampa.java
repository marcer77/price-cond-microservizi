package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKIBResponseRigheDiStampa {
	private String prgStp;
	private String prgStrut;
	private String tipoStrut;

	private String flContinua;
	
	private String testo1;
	private String testo2;
	private String testo3;
	private String testo4;
	
	private String testo;
	
	private String codCond;
	private String dataDeco;
	private String descrCond;
	private String valore;
	private String indNota;
	
	private String num;
	private String testoNota;
	
	private String testoPromozione;
}
