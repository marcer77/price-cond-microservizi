package com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd;

import java.util.List;

public class InquiryContoCndOutput {
	
	private String cdEsito;
	private String msgEsito;
	
	private List<CondizioneConto> condizioni;
	
	public InquiryContoCndOutput() {
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

	public List<CondizioneConto> getCondizioni() {
		return condizioni;
	}

	public void setCondizioni(List<CondizioneConto> condizioni) {
		this.condizioni = condizioni;
	}
	
}
