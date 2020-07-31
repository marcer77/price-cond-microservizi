package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;

public class BSException extends CJBaseException{
	private String mdwEsiRetc;
	private String mdwEsiMsg;
	private String mdwEsiAnom;
	public BSException(String mdwEsiRetc, String mdwEsiMsg, String mdwEsiAnom) {
		this.mdwEsiAnom=mdwEsiAnom;
		this.mdwEsiRetc=mdwEsiRetc;
		this.mdwEsiMsg=mdwEsiMsg;
	}
	public String getMdwEsiRetc() {
		return mdwEsiRetc;
	}
	public String getMdwEsiMsg() {
		return mdwEsiMsg;
	}
	public String getMdwEsiAnom() {
		return mdwEsiAnom;
	}
}
