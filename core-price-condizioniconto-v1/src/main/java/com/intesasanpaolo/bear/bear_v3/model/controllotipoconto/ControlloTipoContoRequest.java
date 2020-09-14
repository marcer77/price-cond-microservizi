package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto;

import io.swagger.annotations.ApiModelProperty;

public class ControlloTipoContoRequest {
	
	@ApiModelProperty(value="Tipo funzione", required = true)
	private String cdFunzione;
	
	@ApiModelProperty(value="Codice rapporto", required = true)
	private String cdRapporto;
	
	@ApiModelProperty(value="Data ricerca", required = false)
	private String dtDecorrenza;
	
	@ApiModelProperty(value="Indicatore ricerca convenzione", required = false)
	private String cdRicercaConv;
	
	@ApiModelProperty(value="Indicatore ricerca valori di rapporto", required = false)
	private String cdRicercaValRapp;
	
	@ApiModelProperty(value="Codice prodotto", required = false)
	private String cdPrdotto;	
	
	@ApiModelProperty(value="Chiamata proveniente da filiale amica", required = false)
	private String cdFilialeAmica;
	
	@ApiModelProperty(value="Codice ABI", required = true)
	private String cdAbi;
	
	@ApiModelProperty(value="Matricola", required = true)
	private String cdMatricola;

	public ControlloTipoContoRequest() {
	}

	public String getCdFunzione() {
		return cdFunzione;
	}

	public void setCdFunzione(String cdFunzione) {
		this.cdFunzione = cdFunzione;
	}

	public String getCdRapporto() {
		return cdRapporto;
	}

	public void setCdRapporto(String cdRapporto) {
		this.cdRapporto = cdRapporto;
	}

	public String getDtDecorrenza() {
		return dtDecorrenza;
	}

	public void setDtDecorrenza(String dtDecorrenza) {
		this.dtDecorrenza = dtDecorrenza;
	}

	public String getCdRicercaConv() {
		return cdRicercaConv;
	}

	public void setCdRicercaConv(String cdRicercaConv) {
		this.cdRicercaConv = cdRicercaConv;
	}

	public String getCdRicercaValRapp() {
		return cdRicercaValRapp;
	}

	public void setCdRicercaValRapp(String cdRicercaValRapp) {
		this.cdRicercaValRapp = cdRicercaValRapp;
	}

	public String getCdPrdotto() {
		return cdPrdotto;
	}

	public void setCdPrdotto(String cdPrdotto) {
		this.cdPrdotto = cdPrdotto;
	}

	public String getCdFilialeAmica() {
		return cdFilialeAmica;
	}

	public void setCdFilialeAmica(String cdFilialeAmica) {
		this.cdFilialeAmica = cdFilialeAmica;
	}

	public String getCdAbi() {
		return cdAbi;
	}

	public void setCdAbi(String cdAbi) {
		this.cdAbi = cdAbi;
	}

	public String getCdMatricola() {
		return cdMatricola;
	}

	public void setCdMatricola(String cdMatricola) {
		this.cdMatricola = cdMatricola;
	}

}
