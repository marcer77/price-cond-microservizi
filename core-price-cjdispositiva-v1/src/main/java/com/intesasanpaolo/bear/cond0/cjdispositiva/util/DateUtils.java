package com.intesasanpaolo.bear.cond0.cjdispositiva.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final SimpleDateFormat FORMAT_YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

	public static final SimpleDateFormat FORMAT_DDMMYYYY = new SimpleDateFormat("dd-MM-yyyy");

	public static String dateToString(Date date) {
		String strDate = null;
		if(date != null) {
			strDate = FORMAT_YYYYMMDD.format(date);
		}
		return strDate;
	}

	public static Date stringToDate(String strDate) {
		Date dateFormatted = null;
		if(strDate != null) {
			try {
				dateFormatted = FORMAT_YYYYMMDD.parse(strDate);
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
}
