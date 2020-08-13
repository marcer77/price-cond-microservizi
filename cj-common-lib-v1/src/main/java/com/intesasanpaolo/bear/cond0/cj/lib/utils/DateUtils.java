package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.intesasanpaolo.bear.config.LoggerUtils;

public class DateUtils {
	private static final Logger logger = LoggerUtils.getLogger(DateUtils.class);

	private DateUtils() {}
	public static final String DATE_FORMAT_YYYY_MM_DD_SOLID = "yyyyMMdd";
	public static final String DATE_FORMAT_DD_MM_YYYY_DOTS	= "dd.MM.yyyy";
	public static final String DATE_FORMAT_YYYY_MM_DD 		= "yyyy-MM-dd";
	public static final String DATE_FORMAT_DD_MM_YYYY 		= "dd-MM-yyyy";
	
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		return sdf.format(date);
	}
	
	public static String convertiDate(String dateInput, String dateFormatInput,String dateFormatOutput) throws ParseException {
		SimpleDateFormat sdfInput = new SimpleDateFormat(dateFormatInput);
		SimpleDateFormat sdfOutput = new SimpleDateFormat(dateFormatOutput);
		String output=null;
		try {
			Date dataScadenzaInput= StringUtils.isNotEmpty(dateInput)?sdfInput.parse(dateInput):null;
			if (dataScadenzaInput!=null)
				output=sdfOutput.format(dataScadenzaInput);
		} catch (ParseException e) {
			logger.error("Problema nella conversione della data {} dal formato {} al formato {}",dateInput,dateFormatInput,dateFormatOutput);
			throw e;
		}
		return output;
	}
}