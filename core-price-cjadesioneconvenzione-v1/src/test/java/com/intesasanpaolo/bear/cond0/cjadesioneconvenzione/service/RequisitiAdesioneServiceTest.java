package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;

@RunWith(SpringRunner.class)
public class RequisitiAdesioneServiceTest extends BaseTest{

	@Autowired
	private RequisitiAdesioneService requisitiAdesioneService;
	
	@Test
	public void testGetRequisitiAdesione() {
		Assert.assertNotNull(requisitiAdesioneService.getRequisitiAdesione());
	}

}
