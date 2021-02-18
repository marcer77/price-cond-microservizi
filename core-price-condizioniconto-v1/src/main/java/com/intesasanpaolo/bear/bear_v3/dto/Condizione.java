package com.intesasanpaolo.bear.bear_v3.dto;

import java.io.Serializable;

public class Condizione implements Serializable {

	public Condizione(){}
	
	public Condizione(String codiceCondizione, String codiceSottocondizione){
		this();
		setCodiceCondizione(codiceCondizione);
		setCodiceSottocondizione(codiceSottocondizione);
	}
	
	private String codiceCondizione="";	
	private String codiceSottocondizione="";

	public String getCodiceCondizione() {
		return codiceCondizione;
	}

	public void setCodiceCondizione(String codiceCondizione) {
		if(null!=codiceCondizione)
			this.codiceCondizione = codiceCondizione;
	}

	public String getCodiceSottocondizione() {
		return codiceSottocondizione;
	}

	public void setCodiceSottocondizione(String codiceSottocondizione) {
		if(null!=codiceSottocondizione)
			this.codiceSottocondizione = codiceSottocondizione;
	}
	
	
	private static final long serialVersionUID = 1L;
}

