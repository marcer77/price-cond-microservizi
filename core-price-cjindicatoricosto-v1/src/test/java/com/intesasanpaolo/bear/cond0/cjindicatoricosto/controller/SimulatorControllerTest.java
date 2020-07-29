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

	@Rule
	public WireMockRule backendService = new WireMockRule(4545);

	@Test
	public void db2Test() throws Exception {
		String codAbi = "10125";
		String codSuperPratica = "0001161961";
		String nrPratica = "0000655703";

		String uri = "/cjindicatoricosto/pratiche?codAbi=" + codAbi + "&codSuperPratica=" + codSuperPratica;

//		StubMapping stub = stubFor(get(urlEqualTo("/db2.svc")).withRequestBody(containing("inviaPropostaV2"))
//				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/soap+xml")
//						.withBodyFile("InviaPropostaV2-response.xml")));
//		
		StubMapping stub = stubFor(get(urlEqualTo("/db2.svc"))
	            .willReturn(aResponse()
	                .withHeader("Content-Type", "text/plain")
	                .withBody("0000655703")));

		log.info("Esito invia proposta v2: " + stub.getResponse().getStatus());

		Assert.assertEquals(200, stub.getResponse().getStatus());

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertEquals("[\"" + nrPratica + "\"]", content);

	}

}
