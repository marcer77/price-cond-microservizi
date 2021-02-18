package com.intesasanpaolo.bear.bear_v3.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoRequest;
import com.intesasanpaolo.bear.cond0.condizioniconto.common.BaseTest;

@RunWith(SpringRunner.class)
public class RESTControllerControlloTipoContoTest extends BaseTest {

	 
	@Rule
	public WireMockRule backendService = new WireMockRule(4545);

	@Before
	public void initMocks() throws Exception {
		stubRestToHost();		
	}

		
	private void stubRestToHost() {
		StubMapping stub = stubFor(post(urlEqualTo("/bridge/pcmm"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/json")
						.withBodyFile("ControlloTipoConto-responseOK.json")));
	}

	@Test
	public void testControlloTipoConto() throws Exception {
		
		String uriString = "/condizioniconto/controlloTipoConto";
		
		ControlloTipoContoRequest controlloTipoContoRequest=new ControlloTipoContoRequest();
		controlloTipoContoRequest.setCdAbi("01025");
		controlloTipoContoRequest.setCdMatricola("U015886");
		controlloTipoContoRequest.setCdFunzione("CCJ");
		controlloTipoContoRequest.setCdPrdotto("ID0000POSC");
		controlloTipoContoRequest.setCdRapporto("00700569905154286");  
		  
		String inputJson = mapToJson(controlloTipoContoRequest);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uriString).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("cdEsito\":\"00"));
		
	}

	
}
