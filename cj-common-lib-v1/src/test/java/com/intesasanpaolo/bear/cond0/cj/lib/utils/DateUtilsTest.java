package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

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
	
}
