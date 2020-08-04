package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;

import org.springframework.http.HttpStatus;

public class BSException extends CJBaseException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BSException(String mdwEsiRetc, String mdwEsiMsg, String mdwEsiAnom,String livelloSegnalzione,String txtSegnalazione,String bs) {
		super(format(mdwEsiRetc,mdwEsiMsg, mdwEsiAnom, livelloSegnalzione, txtSegnalazione,bs), ErrorCode.BS_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	private static String format(String mdwEsiRetc, String mdwEsiMsg, String mdwEsiAnom,String livelloSegnalzione,String txtSegnalazione,String bs) {
		StringBuilder buffer=new StringBuilder();
		String separatore=" - ";
		buffer.append("BS=").append(bs).append(separatore);
		buffer.append("mdwEsiRetc=").append(mdwEsiRetc!=null?mdwEsiRetc.trim():"").append(separatore);
		buffer.append("mdwEsiMsg=").append(mdwEsiMsg!=null?mdwEsiMsg.trim():"").append(separatore);
		buffer.append("mdwEsiAnom=").append(mdwEsiAnom!=null?mdwEsiAnom.trim():"").append(separatore);
		buffer.append("livelloSegnalzione=").append(livelloSegnalzione!=null?livelloSegnalzione.trim():"").append(separatore);
		buffer.append("txtSegnalazione=").append(txtSegnalazione!=null?txtSegnalazione.trim():"").append(separatore);
		return buffer.toString();
	}
}
