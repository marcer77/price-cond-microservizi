package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.intesasanpaolo.bear.cond0.cjdispositiva.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cjdispositiva.enums.CodProcessoEnum;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(SpringRunner.class)
public class CJDispositivaControllerTest extends BaseTest {

	private DispositivaRequestDTO dispositivaRequestDTO;

	@Rule
	public WireMockRule backendService = new WireMockRule(4545);

	@Before
	public void initMocks() throws Exception {
		dispositivaRequestDTO = new DispositivaRequestDTO();
		dispositivaRequestDTO.setCodAppl(CodApplEnum.CARTE.toString());
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		PraticaDTO praticaDTO = new PraticaDTO();
		praticaDTO.setCodPratica("1234568791123");
		praticaDTO.setCodPropostaComm("1234568791123");
		praticaDTO.setCodSuperPratica("1234568791123");
		dispositivaRequestDTO.setPraticaDTO(praticaDTO);
	}
	
//	@Test
//	public void testMockWS() throws Exception {
//		StubMapping stub = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("InviaPropostaV2"))
//				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
//						.withBodyFile("InviaPropostaV2-response.xml")));
//		
//		System.out.println("Esito invia proposta v2: "+stub.getResponse().getStatus());
//		
//		Assert.assertEquals(200, stub.getResponse().getStatus());
//		
//		stub = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("RevocaProposta"))
//				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
//						.withBodyFile("RevocaProposta-response.xml")));
//		
//		System.out.println("Esito revoca proposta: "+stub.getResponse().getStatus());
//		
//		Assert.assertEquals(200, stub.getResponse().getStatus());
//	}

	@Test
	public void testInserimentoOK() throws Exception {

		String inputJson = mapToJson(dispositivaRequestDTO);
		String uri = "/cjdispositiva/inserimento";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
		
		StubMapping stub = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("inviaPropostaV2"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/soap+xml")
						.withBodyFile("InviaPropostaV2-response.xml")));
		
		System.out.println("Esito invia proposta v2: "+stub.getResponse().getStatus());
		
		Assert.assertEquals(200, stub.getResponse().getStatus());
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

//	@Test
	public void testInserimentoKO2() throws Exception {
		String inputJson = mapToJson(null);
		String uri = "/cjdispositiva/inserimento";

		HttpHeaders httpHeaders = new HttpHeaders();

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(403, status);
		log.info("content = {}", content);

	}

	@Test
	public void testAnnulloOK() throws Exception {

		String inputJson = mapToJson(dispositivaRequestDTO);
		String uri = "/cjdispositiva/annullo";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		StubMapping stub = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("revocaProposta"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/soap+xml")
						.withBodyFile("RevocaProposta-response.xml")));
		
		System.out.println("Esito invia proposta v2: "+stub.getResponse().getStatus());
		
		Assert.assertEquals(200, stub.getResponse().getStatus());
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

//	@Test
	public void testAnnulloKO() throws Exception {

		String inputJson = mapToJson(null);
		String uri = "/cjdispositiva/annullo";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(403, status);
		log.info("content = {}", content);

	}

//	@Test
	public void testAnnulloKO2() throws Exception {

		String inputJson = mapToJson(dispositivaRequestDTO);
		String uri = "/cjdispositiva/annullo";

		HttpHeaders httpHeaders = new HttpHeaders();

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(403, status);
		log.info("content = {}", content);

	}

}
