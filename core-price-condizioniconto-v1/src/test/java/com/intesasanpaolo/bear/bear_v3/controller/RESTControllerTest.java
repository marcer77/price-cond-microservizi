package com.intesasanpaolo.bear.bear_v3.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.ArrayList;
import java.util.List;

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
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.DriverInq;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndRequest;
import com.intesasanpaolo.bear.cond0.condizioniconto.common.BaseTest;

@RunWith(SpringRunner.class)
public class RESTControllerTest extends BaseTest {

	private InquiryContoCndRequest inquiryContoCndRequest;

	@Rule
	public WireMockRule backendService = new WireMockRule(4545);

	@Before
	public void initMocks() throws Exception {
		List<DriverInq> driverList = new ArrayList<DriverInq>();
		inquiryContoCndRequest = new InquiryContoCndRequest();
		inquiryContoCndRequest.setCdAbi("01025");
		inquiryContoCndRequest.setCdAttrCnd("ZE5441");
		inquiryContoCndRequest.setCdChiamante("CJCR0");
		inquiryContoCndRequest.setCdMatricola("GAIMW03");
		inquiryContoCndRequest.setCdNDG("0007467982005000");
		inquiryContoCndRequest.setCdProdotto("ID0000XMECPL");
		inquiryContoCndRequest.setCdConv("");
		inquiryContoCndRequest.setCdRapporto("");

		inquiryContoCndRequest.setCdUO("02841");

		DriverInq d1 = new DriverInq();
		d1.etichetta = "ABI";
		d1.val = "01025";

		DriverInq d2 = new DriverInq();

		d2.etichetta = "FUNID";
		d2.val = "CJCARTE";

		driverList.add(d1);
		driverList.add(d2);

		inquiryContoCndRequest.setDriver(driverList);
		inquiryContoCndRequest.setDtOperazione("20200622");

		List<String> promozioniList = new ArrayList<String>();
		promozioniList.add("Q001852");
		inquiryContoCndRequest.setPromozioni(promozioniList);
	}

	private void stubInquiryContoCndOK() {
		StubMapping stub = stubFor(post(urlEqualTo("/T1IB0/IIBCDPRCMS")).withRequestBody(containing("<prodotto>"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
						.withBodyFile("InquiryContoCnd-responseOK.xml")));

		log.info("Esito invia proposta v2: " + stub.getResponse().getStatus());

		Assert.assertEquals(200, stub.getResponse().getStatus());
	}

	@Test
	public void testContoCndDettaglio_PromozioniOK() throws Exception {

		List<String> promozioniList = new ArrayList<String>();
		promozioniList.add("Q001852");
		inquiryContoCndRequest.setPromozioni(promozioniList);

		inquiryContoCndRequest.setCdConv("");
		inquiryContoCndRequest.setCdRapporto("");

		stubInquiryContoCndOK();

		String uriString = "/condizioniconto/inquiryContoCndDettaglio";

		String inputJson = mapToJson(inquiryContoCndRequest);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uriString).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		Assert.assertTrue(content.contains("cdEsito\":\"00"));
		log.info("content = {}", content);

	}

	@Test
	public void testContoCndDettaglio_ConvOK() throws Exception {

		inquiryContoCndRequest.setCdConv("12345");

		stubInquiryContoCndOK();

		String uriString = "/condizioniconto/inquiryContoCndDettaglio";

		String inputJson = mapToJson(inquiryContoCndRequest);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uriString).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		Assert.assertTrue(content.contains("cdEsito\":\"00"));
		log.info("content = {}", content);

	}

	@Test
	public void testContoCndDettaglio_RapportoOK() throws Exception {
		inquiryContoCndRequest.setCdRapporto("12345678901234567");
		inquiryContoCndRequest.getPromozioni().clear();

		stubInquiryContoCndOK();

		String uriString = "/condizioniconto/inquiryContoCndDettaglio";

		String inputJson = mapToJson(inquiryContoCndRequest);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uriString).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		Assert.assertTrue(content.contains("cdEsito\":\"00"));
		log.info("content = {}", content);

	}

}
