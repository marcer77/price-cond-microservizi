package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;

@RunWith(SpringRunner.class)
public class SuperPraticaServiceTest extends BaseTest{

	@Autowired
	private SuperPraticaService superPraticaService;
	
	@Test
	public void testRecuperaCodConvenzione() {
		String codConvenzione=superPraticaService.recuperaCodConvenzione("01025", "0001161961", "0000655703");
		Assert.assertTrue(codConvenzione.equalsIgnoreCase("0070010"));
	}
	@Test(expected = CJBaseException.class)
	public void testRecuperaCodConvenzioneKO() {
		superPraticaService.recuperaCodConvenzione("01025", "9991161961", "9999655703");
	}
}
