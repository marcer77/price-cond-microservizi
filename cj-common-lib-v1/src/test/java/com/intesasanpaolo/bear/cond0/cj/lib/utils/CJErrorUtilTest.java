package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;

@RunWith(SpringRunner.class)
public class CJErrorUtilTest {
	@Test(expected = BSException.class)
	public void test01() {
		OutEsi outEsi=OutEsi.builder().mdwEsiRetc("0012").mdwEsiAnom("Test Errore").mdwEsiMsg("Test Errore").build();
		OutSeg outSeg= OutSeg.builder().livelloSegnalazione("Blocker").txtSegnalazione("E").build();
		CJErrorUtil.checkErrore(BSType.FL03S00, outEsi, outSeg, (x)->true, null);
	}
	@Test
	public void test02() {
		OutEsi outEsi=OutEsi.builder().mdwEsiRetc("0000").mdwEsiAnom("Test Errore").mdwEsiMsg("Test Errore").build();
		OutSeg outSeg= OutSeg.builder().livelloSegnalazione("Blocker").txtSegnalazione("E").build();
		try {
			CJErrorUtil.checkErrore(BSType.FL03S00, outEsi, outSeg, (x)->false, null);	
		}catch (Exception e) {
			fail();
		}
	}
}
