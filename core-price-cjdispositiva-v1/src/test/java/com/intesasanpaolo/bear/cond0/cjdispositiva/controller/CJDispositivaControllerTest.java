package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

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
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjdispositiva.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PraticaDTO;

@RunWith(SpringRunner.class)
public class CJDispositivaControllerTest extends BaseTest {

	private DispositivaRequestDTO dispositivaRequestDTO;

	private HttpHeaders httpHeaders;

	private HttpHeaders httpHeadersCorrotto;

	@Rule
	public WireMockRule backendService = new WireMockRule(4545);

	@Before
	public void initMocks() throws Exception {
		dispositivaRequestDTO = new DispositivaRequestDTO();
		
		dispositivaRequestDTO.setCodAppl(CodApplEnum.FIDI.toString());
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString());
		dispositivaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		dispositivaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		dispositivaRequestDTO.setCodAppl(CodApplEnum.AREA_FINANZA.toString());
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		dispositivaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		dispositivaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		dispositivaRequestDTO.setCodAppl(CodApplEnum.CARTE.toString());
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		dispositivaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		dispositivaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		PraticaDTO praticaDTO = new PraticaDTO();
		praticaDTO.setCodPratica("0000655703");
		praticaDTO.setCodPropostaComm("");
		praticaDTO.setCodSuperPratica("0001161961");
		dispositivaRequestDTO.setPraticaDTO(praticaDTO);

		httpHeaders = new HttpHeaders();

		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.ServiceID", "PCGESTIXME");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.ServiceVersion", "00");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		httpHeadersCorrotto = new HttpHeaders();

		httpHeadersCorrotto.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeadersCorrotto.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "");
		httpHeadersCorrotto.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "");
		httpHeadersCorrotto.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.ServiceID", "PCGESTIXME");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.ServiceVersion", "00");
		httpHeadersCorrotto.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
	}
	
	private void stubStoreCovenantWSKO() {
		StubMapping stubConvenzione = stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
				.withRequestBody(containing("StoreCovenantAdesioneConvenzione"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
						.withBodyFile("StoreCovenantAdesioneConvenzione-responseKO.xml")));

		log.info("Esito StoreCovenantAdesioneConvenzione: " + stubConvenzione.getResponse().getStatus());

		Assert.assertEquals(200, stubConvenzione.getResponse().getStatus());
	}
	
	private void stubStoreCovenantWSOK() {
		StubMapping stubConvenzione = stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
				.withRequestBody(containing("StoreCovenantAdesioneConvenzione"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
						.withBodyFile("StoreCovenantAdesioneConvenzione-responseOK.xml")));

		log.info("Esito StoreCovenantAdesioneConvenzione: " + stubConvenzione.getResponse().getStatus());

		Assert.assertEquals(200, stubConvenzione.getResponse().getStatus());
	}
	
	
	
	private void stubRollbackStoreCovenantWSOK() {
		StubMapping stubConvenzione = stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
				.withRequestBody(containing("RollbackStoreCovenantAdesioneConvenzione"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
						.withBodyFile("RollbackStoreCovenantAdesioneConvenzione-responseOK.xml")));

		log.info("Esito StoreCovenantAdesioneConvenzione: " + stubConvenzione.getResponse().getStatus());

		Assert.assertEquals(200, stubConvenzione.getResponse().getStatus());
	}
	
	private void stubRollbackStoreCovenantWSKO() {
		StubMapping stubConvenzione = stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
				.withRequestBody(containing("RollbackStoreCovenantAdesioneConvenzione"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "text/xml")
						.withBodyFile("RollbackStoreCovenantAdesioneConvenzione-responseKO.xml")));

		log.info("Esito StoreCovenantAdesioneConvenzione: " + stubConvenzione.getResponse().getStatus());

		Assert.assertEquals(200, stubConvenzione.getResponse().getStatus());
	}
	
	
	private void stubInviaPropostaOK() {
		StubMapping stub = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("inviaPropostaV2"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/soap+xml")
						.withBodyFile("InviaPropostaV2-response.xml")));

		log.info("Esito invia proposta v2: " + stub.getResponse().getStatus());

		Assert.assertEquals(200, stub.getResponse().getStatus());
	}
	
	private void stubRevocaPropostaOK() {
		StubMapping stub = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("revocaProposta"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/soap+xml")
						.withBodyFile("RevocaProposta-response.xml")));

		log.info("Esito invia proposta v2: " + stub.getResponse().getStatus());

		Assert.assertEquals(200, stub.getResponse().getStatus());
	}
	
	private void stubGestioneOk() {
		StubMapping stubRest = stubFor(post(urlEqualTo("/Gestione.svc")).withRequestBody(containing("DatiInput"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/json")
						.withBodyFile("Gestione-responseOK.json")));

		log.info("Esito Gestione: " + stubRest.getResponse().getStatus());

		Assert.assertEquals(200, stubRest.getResponse().getStatus());
	}
	
	private void stubGestioneKO() {
		StubMapping stubRest = stubFor(post(urlEqualTo("/Gestione.svc")).withRequestBody(containing("DatiInput"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/json")
						.withBodyFile("Gestione-responseKO.json")));

		log.info("Esito Gestione: " + stubRest.getResponse().getStatus());

		Assert.assertEquals(200, stubRest.getResponse().getStatus());
	}


	@Test
	public void testInserimentoOK() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();

		stubInviaPropostaOK();

		stubGestioneOk();
		
		dispositivaRequestDTO.getPraticaDTO().setCodPratica("0000655703");
		
		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

	//vario la pratica in modo da generare eccezioni db2 le chiamate esterno sono tutte ok
	@Test
	public void testInserimentoKO_DatiDb2() throws Exception {
		
		String uri = "/cjdispositiva/inserimento";
		
		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		String[] codPraticaList = new String[] {"0000655704","0000655706"};

		for (String pratica : codPraticaList) {

			dispositivaRequestDTO.getPraticaDTO().setCodPratica(pratica);

			String inputJson = mapToJson(dispositivaRequestDTO);

			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
					.headers(httpHeaders).content(inputJson)).andReturn();

			String content = mvcResult.getResponse().getContentAsString();
			int status = mvcResult.getResponse().getStatus();
			log.info("status = " + status);
			Assert.assertEquals(200, status);
			log.info("content = {}", content);
			Assert.assertTrue(!content.contains("codErrore\":\"00"));
		}
	}
	
	@Test
	public void testInserimentoKO_Adesione() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		dispositivaRequestDTO.getPraticaDTO().setCodPratica("0000655704");

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(!content.contains("codErrore\":\"00"));
	}
	
	@Test
	public void testInserimentoKO_CovenantDaAttivare() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		dispositivaRequestDTO.getPraticaDTO().setCodPratica("0000655705");

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		System.err.println(content);
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("codErrore\":\"00"));
		
	}
	
	@Test
	public void testInserimentoKO_Figlie() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		dispositivaRequestDTO.getPraticaDTO().setCodPratica("0000655706");

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(!content.contains("codErrore\":\"00"));
	}

	//KO restituito dal servizio store Covenant
	@Test
	public void testInserimentoKO_StoreCovenant() throws Exception {

		String uri = "/cjdispositiva/inserimento";
		
		stubStoreCovenantWSKO();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}
	
	@Test
	public void testInserimentoKO_WsGestione() throws Exception {

		String uri = "/cjdispositiva/inserimento";
		
		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneKO();

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(!content.contains("codErrore\":\"00"));

	}

	@Test
	public void testInserimento_HeadersKO() throws Exception {
		
		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSKO();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).headers(httpHeadersCorrotto))
				.andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertNotEquals(200, status);
		log.info("content = {}", content);

	}

	@Test
	public void testAnnulloOK() throws Exception {
		
		dispositivaRequestDTO.getPraticaDTO().setCodPratica("0000655713");
		
		String inputJson = mapToJson(dispositivaRequestDTO);
		
		String uri = "/cjdispositiva/annullo";

		stubRollbackStoreCovenantWSOK();
		
		stubRevocaPropostaOK();

		stubGestioneOk();

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

	@Test
	public void testAnnullo_WS_KO() throws Exception {

		String inputJson = mapToJson(dispositivaRequestDTO);
		
		String uri = "/cjdispositiva/annullo";

		stubRollbackStoreCovenantWSKO();
		
		stubRevocaPropostaOK();

		stubGestioneOk();

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

	
	
	@Test
	public void testAnnullo_HeadersKO() throws Exception {

		String inputJson = mapToJson(dispositivaRequestDTO);
		
		String uri = "/cjdispositiva/annullo";

		stubStoreCovenantWSOK();
		
		stubRevocaPropostaOK();

		stubGestioneOk();

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeadersCorrotto).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertNotEquals(200, status);
		log.info("content = {}", content);

	}

}
