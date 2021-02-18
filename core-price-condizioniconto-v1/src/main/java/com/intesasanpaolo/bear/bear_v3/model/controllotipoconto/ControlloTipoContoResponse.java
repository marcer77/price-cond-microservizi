package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto;

import java.util.List;

public class ControlloTipoContoResponse {
	
	private String cdEsito;
	private String msgEsito;
	
	private String cdTipoConto;
	private String cdPrdotto;
	private String flCruscotto;
	private String cdConvenzioneRif;
	private String cdConvenzioneAde;
	private String dsConvenzione;
	private String dtDecorrenzaAdeConv;
	private String dtScadenzaAdeConv;
	private String cdPromozione;
	private String dtDecorrenzaPromo;
	private String dtScadenzaPromo;
	private int niListiniCC;
	private int niListiniACC;
	private int niPromoMulti;
	
	private List<ListinoContoCorrente> listiniCC;
	private List<RapportoAccessorio> rapportiACC;
	private List<Promozione> promozioni;
	
	public ControlloTipoContoResponse() {
	}
	
	public String getCdEsito() {
		return cdEsito;
	}
	public void setCdEsito(String cdEsito) {
		this.cdEsito = cdEsito;
	}
	public String getMsgEsito() {
		return msgEsito;
	}
	public void setMsgEsito(String msgEsito) {
		this.msgEsito = msgEsito;
	}
	public String getCdTipoConto() {
		return cdTipoConto;
	}
	public void setCdTipoConto(String cdTipoConto) {
		this.cdTipoConto = cdTipoConto;
	}
	public String getCdPrdotto() {
		return cdPrdotto;
	}
	public void setCdPrdotto(String cdPrdotto) {
		this.cdPrdotto = cdPrdotto;
	}
	public String getFlCruscotto() {
		return flCruscotto;
	}
	public void setFlCruscotto(String flCruscotto) {
		this.flCruscotto = flCruscotto;
	}
	public String getCdConvenzioneRif() {
		return cdConvenzioneRif;
	}
	public void setCdConvenzioneRif(String cdConvenzioneRif) {
		this.cdConvenzioneRif = cdConvenzioneRif;
	}
	public String getCdConvenzioneAde() {
		return cdConvenzioneAde;
	}
	public void setCdConvenzioneAde(String cdConvenzioneAde) {
		this.cdConvenzioneAde = cdConvenzioneAde;
	}
	public String getDsConvenzione() {
		return dsConvenzione;
	}
	public void setDsConvenzione(String dsConvenzione) {
		this.dsConvenzione = dsConvenzione;
	}
	public String getDtDecorrenzaAdeConv() {
		return dtDecorrenzaAdeConv;
	}
	public void setDtDecorrenzaAdeConv(String dtDecorrenzaAdeConv) {
		this.dtDecorrenzaAdeConv = dtDecorrenzaAdeConv;
	}
	public String getDtScadenzaAdeConv() {
		return dtScadenzaAdeConv;
	}
	public void setDtScadenzaAdeConv(String dtScadenzaAdeConv) {
		this.dtScadenzaAdeConv = dtScadenzaAdeConv;
	}
	public int getNiListiniCC() {
		return niListiniCC;
	}
	public void setNiListiniCC(int niListiniCC) {
		this.niListiniCC = niListiniCC;
	}
	public int getNiListiniACC() {
		return niListiniACC;
	}
	public void setNiListiniACC(int niListiniACC) {
		this.niListiniACC = niListiniACC;
	}

	public String getCdPromozione() {
		return cdPromozione;
	}

	public void setCdPromozione(String cdPromozione) {
		this.cdPromozione = cdPromozione;
	}

	public String getDtDecorrenzaPromo() {
		return dtDecorrenzaPromo;
	}

	public void setDtDecorrenzaPromo(String dtDecorrenzaPromo) {
		this.dtDecorrenzaPromo = dtDecorrenzaPromo;
	}

	public String getDtScadenzaPromo() {
		return dtScadenzaPromo;
	}

	public void setDtScadenzaPromo(String dtScadenzaPromo) {
		this.dtScadenzaPromo = dtScadenzaPromo;
	}

	public int getNiPromoMulti() {
		return niPromoMulti;
	}

	public void setNiPromoMulti(int niPromoMulti) {
		this.niPromoMulti = niPromoMulti;
	}

	public List<ListinoContoCorrente> getListiniCC() {
		return listiniCC;
	}

	public void setListiniCC(List<ListinoContoCorrente> listiniCC) {
		this.listiniCC = listiniCC;
	}

	public List<RapportoAccessorio> getRapportiACC() {
		return rapportiACC;
	}

	public void setRapportiACC(List<RapportoAccessorio> rapportiACC) {
		this.rapportiACC = rapportiACC;
	}

	public List<Promozione> getPromozioni() {
		return promozioni;
	}

	public void setPromozioni(List<Promozione> promozioni) {
		this.promozioni = promozioni;
	}
	
}
