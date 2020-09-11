package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils.DatePattern;

public class DateUtilsTest {
	@Test	
	public void testConvertiDate01() throws ParseException {
		String d=DateUtils.convertiDate("20201231", "yyyyMMdd","dd.MM.yyyy");
		Assert.assertTrue(d.equals("31.12.2020"));
	}
	@Test(expected = ParseException.class)	
	public void testConvertiDate02() throws ParseException {
		String d=DateUtils.convertiDate("a0202231", "yyyyMMdd","dd.MM.yyyy");
	}
	@Test
	public void testDateToString() {
		System.out.println(">>>>>>" + DateUtils.dateToString(new Date(), "yyyyMMdd"));
	}
	@Test
	public void localDateToString() {
		System.out.println(">>>>>>" + DateUtils.localDateToString(DateUtils.localDateNow(), DatePattern.PRICE_GESTIONE));
		
		LocalDate localDate = null;
		System.out.println(">>>>>>" + DateUtils.localDateToString(localDate, DatePattern.PRICE_GESTIONE));

	}
	
	@Test
	public void localDateTimeToString() {
		System.out.println(">>>>>>" + DateUtils.localDateToString(LocalDateTime.now(), DatePattern.PRICE_GESTIONE));
		
		System.out.println(">>>>>>" + DateUtils.localDateToString(LocalDateTime.now(), DatePattern.ISO_ZONED));
	}
	@Test
	public void localDateNow() {
		System.out.println(">>>>>>" + DateUtils.localDateNow());
	}
	
	@Test
	public void dateToString() {
		String data =  DateUtils.dateToString(new Date());
		System.out.println(">>>>>>" + DateUtils.stringToDate(DateUtils.DATE_FORMAT_YYYY_MM_DD));
		SimpleDateFormat sdfFrom = new SimpleDateFormat(DateUtils.DATE_FORMAT_YYYY_MM_DD);
		SimpleDateFormat sdfTo = new SimpleDateFormat(DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID);
		System.out.println(">>>>>>" + DateUtils.changeFormatDateString(data,sdfFrom, sdfTo));
	}
}
