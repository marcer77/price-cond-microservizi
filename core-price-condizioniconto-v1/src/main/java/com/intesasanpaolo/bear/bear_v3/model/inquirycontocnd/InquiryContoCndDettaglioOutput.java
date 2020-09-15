package com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd;

import java.util.List;

public class InquiryContoCndDettaglioOutput {
	
	private String cdEsito;
	private String msgEsito;
	
	private List<CondizioneContoDettaglio> condizioni;
	
	public InquiryContoCndDettaglioOutput() {
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

	public List<CondizioneContoDettaglio> getCondizioni() {
		return condizioni;
	}

	public void setCondizioni(List<CondizioneContoDettaglio> condizioni) {
		this.condizioni = condizioni;
	}
	
}
