package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;

@RunWith(SpringRunner.class)
@Ignore
public class SimulatorControllerTest extends BaseTest {

	@Test
	public void db2Test() throws Exception {
		String codAbi = "10125";
		String codSuperPratica = "0001161961";
		String codEntita = "00700100000005749CC1000S0";

		String uri = "/cjadesioneconvenzione/pratiche?codAbi=" + codAbi + "&codSuperPratica=" + codSuperPratica;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertEquals("[\"" + codEntita + "\"]", content);

	}

}
