package com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;

@RunWith(SpringRunner.class)
@Ignore
public class SimulatorControllerTest extends BaseTest {

	@Test
	public void db2Test() throws Exception {
		String codAbi = "10125";
		String codSuperPratica = "0001161961";
		String codEntita = "00700100000005749CC1000S0                         \",\"00700100000120230CC1000S0                         ";

		String uri = "/cjindicatoricosto/pratiche?codAbi=" + codAbi + "&codSuperPratica=" + codSuperPratica;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertEquals("[\"" + codEntita + "\"]", content);

	}

}
