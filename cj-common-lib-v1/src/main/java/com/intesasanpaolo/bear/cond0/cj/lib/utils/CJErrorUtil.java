package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.util.function.Function;

import org.apache.commons.lang.StringUtils;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;

public class CJErrorUtil {
	private CJErrorUtil() {
	}

	public static void checkErrore(BSType bsType, OutEsi outEsi, OutSeg outSeg,
			Function<String[], Boolean> additionalCheckErrorFunction, String... additionalParam) {

		String mdwEsiRetc = StringUtils.isNotBlank(outEsi.getMdwEsiRetc()) ? outEsi.getMdwEsiRetc() : "";
		boolean checkKO = !mdwEsiRetc.equals("0000");

		if (!checkKO && additionalCheckErrorFunction != null)
			checkKO = additionalCheckErrorFunction.apply(additionalParam);

		if (checkKO) {
			throw BSException.builder().bsName(bsType.getCode()).outEsi(outEsi).outSeg(outSeg).build();
		}
	}
}
