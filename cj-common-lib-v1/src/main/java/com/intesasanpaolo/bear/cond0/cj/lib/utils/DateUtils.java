package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
	public static final String DATE_FORMAT_DD_MM_YYYY_SLASH = "dd/MM/yyyy";
	
	public static String dateToString(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(DATE_FORMAT_YYYY_MM_DD);
		if(date != null) {
			strDate = sdf.format(date);
		}
		return strDate;
	}

	public static Date stringToDate(String strDate) {
		Date dateFormatted = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(DATE_FORMAT_YYYY_MM_DD);
		if(strDate != null) {
			try {
				dateFormatted = sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateFormatted;
	}

	public static String changeFormatDateString(String dateString, SimpleDateFormat from, SimpleDateFormat to) {
		String strDate = null;
		if(dateString != null) {
			try {
				Date date = from.parse(dateString);
				strDate = to.format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return strDate;
	}

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

	public static String localDateToString(LocalDate localDate, DatePattern pattern) {
		if (localDate == null) {
			return null;
		}
		LocalDateTime ldt = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0, 0));
		return DateUtils.localDateToString(ldt, pattern);
	}

	public static String localDateToString(LocalDateTime localDateTime, DatePattern pattern) {
		String patternStr = pattern.getValue();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternStr);
		if (patternStr.contains("Z")) {
			ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Rome"));
			return zonedDateTime.format(formatter);
		} else {
			return localDateTime.format(formatter);
		}
	}

	public static LocalDate localDateNow() {
		return LocalDate.now(ZoneId.of("Europe/Rome"));
	}
	
	public enum DatePattern {



		ANAG("yyyyMMdd"),
		ISO("yyyy-MM-dd'T'HH:mm:ss.SSS"),
		ISO_ZONED("yyyy-MM-dd'T'HH:mm:ss.SSZ"),
		ISO_DATE("yyyy-MM-dd"),
		ISO_IT_SLASH("dd/MM/yyyy HH:mm:ss"),
		RUD("ddMMyyyyHHmmssSS"),
		AUP("yyyyMMddHHmmss"),
		LIVECYCLE("dd.MM.yyyy"),
		LIVECYCLE_TIME("HH:mm:ss"),
		LIVECYCLE_SLASH("dd/MM/yyyy"),
		WFM_DATIAGGIUNTIVI("yyyy-MM-dd'T'HH:mm:ss.SSZ"),
		GIORNALE("yyyy-MM-dd'T'HH:mm:ss"),
		T1SAVESPRA("yyyyMMdd"),
		PRICE("yyyyMMdd"),
		PRICE_GESTIONE("dd.MM.yyyy"),
		GESTIONE_RAPPORTI("yyyyMMdd"),
		CNDPRICEMS("yyyyMMdd"),
		STOREPARAM("ddMMyyyy HHmmss"),
		BATCH_ISSC("yyyyMM"),
		BATCH_RETRO_ISSC("yyyyMMdd"),
		BATCH_RETRO_ISSC_PERIOD("yyyyMM"),
		BATCH_CDM_DATE("yyyyMMdd"),
		BATCH_CDM_DATETIME("yyyyMMddHHmmss"),
		BATCH_CDM_TIME("HHmmss"),
		BATCH_DEBIT_DATE("dd.MM.yyyy"),
		NOTIFICATOR_TIMESTAMP("yyyyMMddHHmmssSSSSSS"),
		MCT_DATE("yyyyMMdd"),
		MCT_TIME("HHmmss"),
		MCT_DDMM("ddMM"),
		PROMOTION_DATE("yyyyMMdd"),
		CUSTOMER_DATA_DATE("yyyyMMdd"),
		INVOICE_DESCRIPTION("dd.MM.yyyy"),
		CONTI("yyyyMMdd"),
		CONTI_BLOCK_KEY("yyyyMMddHHmmss"),
		REPORT_ISSC_DESCRIPTION("MMyyyy"),
		QUAD_MCT("yyyyMMdd:HH:mm"),
		RIORD_DATE_GENE("yyMMdd"),
		RIORD_TIME("HHmmss"),
		RIORD_DATE_OP("yyyyMMdd");

		private String value;

		DatePattern(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

}