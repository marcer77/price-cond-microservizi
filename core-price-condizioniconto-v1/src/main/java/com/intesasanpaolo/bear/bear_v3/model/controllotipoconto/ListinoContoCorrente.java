package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto;

import java.math.BigDecimal;

public class ListinoContoCorrente {
	
	private String cdListino;
	private String dtDecorrenza;
	private String dtScadenza;
	private String cdProgrLegame;
	private String cdServizio;
	private String cdCondizione;
	private BigDecimal nrValoreConvenzione;
	private String cdCnvLivAppl;
	private String cdDivisa;
	
	public ListinoContoCorrente() {
	}

	public String getCdListino() {
		return cdListino;
	}

	public void setCdListino(String cdListino) {
		this.cdListino = cdListino;
	}

	public String getDtDecorrenza() {
		return dtDecorrenza;
	}

	public void setDtDecorrenza(String dtDecorrenza) {
		this.dtDecorrenza = dtDecorrenza;
	}

	public String getDtScadenza() {
		return dtScadenza;
	}

	public void setDtScadenza(String dtScadenza) {
		this.dtScadenza = dtScadenza;
	}

	public String getCdProgrLegame() {
		return cdProgrLegame;
	}

	public void setCdProgrLegame(String cdProgrLegame) {
		this.cdProgrLegame = cdProgrLegame;
	}

	public String getCdServizio() {
		return cdServizio;
	}

	public void setCdServizio(String cdServizio) {
		this.cdServizio = cdServizio;
	}

	public String getCdCondizione() {
		return cdCondizione;
	}

	public void setCdCondizione(String cdCondizione) {
		this.cdCondizione = cdCondizione;
	}

	public BigDecimal getNrValoreConvenzione() {
		return nrValoreConvenzione;
	}

	public void setNrValoreConvenzione(BigDecimal nrValoreConvenzione) {
		this.nrValoreConvenzione = nrValoreConvenzione;
	}

	public String getCdCnvLivAppl() {
		return cdCnvLivAppl;
	}

	public void setCdCnvLivAppl(String cdCnvLivAppl) {
		this.cdCnvLivAppl = cdCnvLivAppl;
	}

	public String getCdDivisa() {
		return cdDivisa;
	}

	public void setCdDivisa(String cdDivisa) {
		this.cdDivisa = cdDivisa;
	}

}
