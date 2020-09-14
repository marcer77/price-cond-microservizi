package com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd;

import java.util.List;

public class InquiryContoCndRequest {

	private String cdProdotto;
	private String cdChiamante;

	public List<DriverInq> driver;
	
	private String cdNDG;
	private String cdAbi;
	private String cdUO;
	private String cdMatricola;
	private String cdRapporto;
	private String cdConv;
	private String cdAttrCnd;
	private List<String> promozioni;

		
	
	public List<DriverInq> getDriver() {
		return driver;
	}
	public void setDriver(List<DriverInq> driver) {
		this.driver = driver;
	}
	public String getCdAttrCnd() {
		return cdAttrCnd;
	}
	public void setCdAttrCnd(String cdAttrCnd) {
		this.cdAttrCnd = cdAttrCnd;
	}
	public List<String> getPromozioni() {
		return promozioni;
	}
	public void setPromozioni(List<String> promozioni) {
		this.promozioni = promozioni;
	}
	private String dtOperazione;
	
	public InquiryContoCndRequest() {
		super();
	}
	public String getCdProdotto() {
		return cdProdotto;
	}
	public void setCdProdotto(String cdProdotto) {
		this.cdProdotto = cdProdotto;
	}
	public String getCdChiamante() {
		return cdChiamante;
	}
	public void setCdChiamante(String cdChiamante) {
		this.cdChiamante = cdChiamante;
	}
	public String getCdNDG() {
		return cdNDG;
	}
	public void setCdNDG(String cdNDG) {
		this.cdNDG = cdNDG;
	}
	public String getCdAbi() {
		return cdAbi;
	}
	public void setCdAbi(String cdAbi) {
		this.cdAbi = cdAbi;
	}
	public String getCdUO() {
		return cdUO;
	}
	public void setCdUO(String cdUO) {
		this.cdUO = cdUO;
	}
	public String getCdMatricola() {
		return cdMatricola;
	}
	public void setCdMatricola(String cdMatricola) {
		this.cdMatricola = cdMatricola;
	}
	public String getCdRapporto() {
		return cdRapporto;
	}
	public void setCdRapporto(String cdRapporto) {
		this.cdRapporto = cdRapporto;
	}
	public String getCdConv() {
		return cdConv;
	}
	public void setCdConv(String cdConv) {
		this.cdConv = cdConv;
	}
	public String getDtOperazione() {
		return dtOperazione;
	}
	public void setDtOperazione(String dtOperazione) {
		this.dtOperazione = dtOperazione;
	}

	

}
