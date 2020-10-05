package com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd;

public class CondizioneContoDettaglio extends CondizioneConto {
	
	private String cdRifLivello;
	
	public CondizioneContoDettaglio(){
	}

	public String getCdRifLivello() {
		return cdRifLivello;
	}

	public void setCdRifLivello(String cdRifLivello) {
		this.cdRifLivello = cdRifLivello;
	}

	@Override
	public String toString() {
		return "CondizioneContoDettaglio [cdRifLivello=" + cdRifLivello + ", getCdDescCnd()=" + getCdDescCnd()
				+ ", getCdTipoCnd()=" + getCdTipoCnd() + ", getCdCnd()=" + getCdCnd() + ", getCdTipoLivello()="
				+ getCdTipoLivello() + ", getCdUDM()=" + getCdUDM() + ", getFlBlindaturaCnd()=" + getFlBlindaturaCnd()
				+ ", getFlCovenantCnd()=" + getFlCovenantCnd() + ", getFlVisualizzaCnd()=" + getFlVisualizzaCnd()
				+ ", getFlStampaCnd()=" + getFlStampaCnd() + ", getCdTipoCndTec()=" + getCdTipoCndTec()
				+ ", getCdSegnoCndTec()=" + getCdSegnoCndTec() + ", getCdTipoValore()=" + getCdTipoValore()
				+ ", getCdValore()=" + getCdValore() + ", getCdSegnoValore()=" + getCdSegnoValore()
				+ ", getCdEtichetta()=" + getCdEtichetta() + ", getNrValore()=" + getNrValore()
				+ ", getNrValCalcolatoPro()=" + getNrValCalcolatoPro() + ", getDtDecorrenza()=" + getDtDecorrenza()
				+ ", getDtScadenza()=" + getDtScadenza() + ", getCdAttrCond()=" + getCdAttrCond() + "]";
	}
	
	

}