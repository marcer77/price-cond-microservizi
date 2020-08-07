package com.intesasanpaolo.bear.cond0.cj.lib.exception;

import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
public class BSException extends CJBaseException {
	private static final long serialVersionUID = 1L;
	private final OutEsi outEsi;
	private final OutSeg outSeg;
	private final String bsName;
	
	@Override
	public String formattaMessaggio() {
		StringBuilder buffer = new StringBuilder();
		String separatore = " - ";
		buffer.append("BS=").append(bsName).append(separatore);
		buffer.append("mdwEsiRetc=").append(outEsi.getMdwEsiRetc() != null ? outEsi.getMdwEsiRetc().trim() : "").append(separatore);
		buffer.append("mdwEsiMsg=").append(outEsi.getMdwEsiMsg() != null ? outEsi.getMdwEsiMsg().trim() : "").append(separatore);
		buffer.append("mdwEsiAnom=").append(outEsi.getMdwEsiAnom() != null ? outEsi.getMdwEsiAnom().trim() : "").append(separatore);
		buffer.append("livelloSegnalzione=").append(outSeg.getLivelloSegnalazione() != null ? outSeg.getLivelloSegnalazione().trim() : "").append(separatore);
		buffer.append("txtSegnalazione=").append(outSeg.getTxtSegnalazione() != null ? outSeg.getTxtSegnalazione().trim() : "").append(separatore);
		return buffer.toString();
	}
	
	@Override
	public String getErrorCode() {
		return CommonErrorCode.BS_SRV_EXCEPTION;
	}

}
