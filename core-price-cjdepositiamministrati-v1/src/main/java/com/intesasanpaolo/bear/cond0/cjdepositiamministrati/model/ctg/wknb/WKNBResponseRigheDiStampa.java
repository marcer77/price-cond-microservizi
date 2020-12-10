package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKNBResponseRigheDiStampa {
	private String prgStp;
	private String prgStrut;
	private String tipoStrut;
	private String tipoSezione;

	private String flContinua;
	
	private String testo1;
	private String testo2;
	private String testo3;
	private String testo4;
	
	private String testo;
	private String evidTesto;
	
	private String codCond;
	private String dataDeco;
	private String evidDtDeco;
	private String descrCond;
	private String evidDescr;
	private String valore;
	private String evidValore;
	private String indNota;
	private String evidNota;
	
	private String num;
	private String evidNrNota;
	private String testoNota;
	private String evidTxNota;
	private String testoPromozione;
}
