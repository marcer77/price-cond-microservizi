package com.intesasanpaolo.bear.cond0.cj.lib.exception;

import java.util.function.Function;

import org.apache.commons.lang.StringUtils;

import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;

public class BSErrorUtil {
	private BSErrorUtil() {}
	
	public static void checkErrore(BSType bsType,String defaultBSErrorCode,OutEsi outEsi,OutSeg outSeg,Function<String[],Boolean> additionalCheckErrorFunction,String...additionalParam) {
		
		String mdwEsiRetc = StringUtils.isNotBlank(outEsi.getMdwEsiRetc()) ? outEsi.getMdwEsiRetc() : "";
		boolean checkKO=!mdwEsiRetc.equals("0000");
		
		if (!checkKO && additionalCheckErrorFunction!=null) 
			checkKO=additionalCheckErrorFunction.apply(additionalParam);
		
		if (checkKO) {
			throw BSException.builder().livelloSegnalazione(outSeg.getLivelloSegnalazione())
			.txtSegnalazione(outSeg.getTxtSegnalazione()).mdwEsiAnom(outEsi.getMdwEsiAnom())
			.mdwEsiMsg(outEsi.getMdwEsiMsg()).mdwEsiRetc(outEsi.getMdwEsiRetc())
			.bsName(bsType.getCode()).errorCode(defaultBSErrorCode).build();
		
		}
	}
}
