package com.intesasanpaolo.bear.cond0.cj.lib.exception;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BSException extends CJBaseException {
	private static final long serialVersionUID = 1L;
	
	private final String mdwEsiRetc;
	private final String mdwEsiMsg;
	private final String mdwEsiAnom;
	private final String livelloSegnalazione;
	private final String txtSegnalazione;
	private final String bsName;
	private final String errorCode;
	
	@Override
	public String formattaMessaggio() {
		StringBuilder buffer = new StringBuilder();
		String separatore = " - ";
		buffer.append("BS=").append(bsName).append(separatore);
		buffer.append("mdwEsiRetc=").append(mdwEsiRetc != null ? mdwEsiRetc.trim() : "").append(separatore);
		buffer.append("mdwEsiMsg=").append(mdwEsiMsg != null ? mdwEsiMsg.trim() : "").append(separatore);
		buffer.append("mdwEsiAnom=").append(mdwEsiAnom != null ? mdwEsiAnom.trim() : "").append(separatore);
		buffer.append("livelloSegnalzione=").append(livelloSegnalazione != null ? livelloSegnalazione.trim() : "")
				.append(separatore);
		buffer.append("txtSegnalazione=").append(txtSegnalazione != null ? txtSegnalazione.trim() : "")
				.append(separatore);
		return buffer.toString();
	}
	@Override
	public String getErrorCode() {
		return this.errorCode;
	}

}
