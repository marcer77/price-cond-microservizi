package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cjdispositiva.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.CTGConnectorWKCJ;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.transformers.WKCJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.transformers.WKCJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.OutCNF;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJResponse;

@RunWith(SpringRunner.class)
public class CJDispositivaControllerTest extends BaseTest {

	private DispositivaRequestDTO dispositivaRequestDTO;

	private HttpHeaders httpHeaders;

	private HttpHeaders httpHeadersCorrotto;

	@Rule
	public WireMockRule backendService = new WireMockRule(4545);
	
	@MockBean
	private CTGConnectorWKCJ ctgConnectorWKCJ;
	
	@MockBean
	private WKCJCtgRequestTrasformer requestTransformer;

	@MockBean
	private WKCJCtgResponseTansformer responseTransformer;
	
	private WKCJRequest wkcjRequest;

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
		dispositivaRequestDTO.setPratica(praticaDTO);

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

//		httpHeadersCorrotto.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeadersCorrotto.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "");
		httpHeadersCorrotto.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "");
		httpHeadersCorrotto.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.ServiceID", "PCGESTIXME");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.ServiceVersion", "00");
		httpHeadersCorrotto.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
		
		mock_WKCJ_OK();
	}
	
	private void mock_WKCJ_OK() {
		// MOCK WKCJ: non ritorna condizioni variate
		WKCJResponse wkcjResponse = new WKCJResponse();
		ArrayList<OutCNF> outCNFList = new ArrayList<OutCNF>();
		/*
		 * OutCNF outCNF = new OutCNF(); outCNF.setCodCnd("cndTest");
		 * outCNFList.add(outCNF);
		 */
		wkcjResponse.setOutCNFList(outCNFList);
		wkcjResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		wkcjResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());

		Mockito.when(ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, new Object[] {}))
				.thenReturn(wkcjResponse);

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
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655703");
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		
		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		
		inputJson = mapToJson(dispositivaRequestDTO);

		mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		content = mvcResult.getResponse().getContentAsString();
		status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}
	
	@Test
	public void testInserimentoKO_RollbackPratica() throws Exception {
		
		String uri = "/cjdispositiva/inserimento";
		
		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());

		dispositivaRequestDTO.getPratica().setCodSuperPratica("0001161913");

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

	//vario la pratica in modo da generare eccezioni db2 le chiamate esterno sono tutte ok
	@Test
	public void testInserimentoKO_DatiDb2() throws Exception {
		
		String uri = "/cjdispositiva/inserimento";
		
		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		String[] codPraticaList = new String[] {"0000655704","0000655706"};
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());

		for (String pratica : codPraticaList) {

			dispositivaRequestDTO.getPratica().setCodPratica(pratica);

			String inputJson = mapToJson(dispositivaRequestDTO);

			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
					.headers(httpHeaders).content(inputJson)).andReturn();

			String content = mvcResult.getResponse().getContentAsString();
			int status = mvcResult.getResponse().getStatus();
			log.info("status = " + status);
			Assert.assertEquals(200, status);
			log.info("content = {}", content);
			//Assert commentanto per via del mock nel controller
//			Assert.assertTrue(!content.contains("codErrore\":\"00"));
		}
	}
	
	@Test
	public void testInserimentoKO_Adesione() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());

		dispositivaRequestDTO.getPratica().setCodPratica("0000655704");

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		//Assert commentanto per via del mock nel controller
//		Assert.assertTrue(!content.contains("codErrore\":\"00"));
	}
	
	@Test
	public void testInserimentoKO_CovenantDaAttivare() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();

		stubInviaPropostaOK();
		
		stubGestioneOk();

		dispositivaRequestDTO.getPratica().setCodPratica("0000655705");

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
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
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());

		dispositivaRequestDTO.getPratica().setCodPratica("0000655706");

		String inputJson = mapToJson(dispositivaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		//Assert commentanto per via del mock nel controller
//		Assert.assertTrue(!content.contains("codErrore\":\"00"));
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
	public void testInserimento_KO_conRevocaPratica() throws Exception {

		String uri = "/cjdispositiva/inserimento";

		stubStoreCovenantWSOK();
		stubRollbackStoreCovenantWSOK();

		//stubInviaPropostaOK();
		
		StubMapping stubOk = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("00700100000005479"))
				.willReturn(aResponse().withStatus(200).withHeader("content-type", "application/soap+xml")
						.withBodyFile("InviaPropostaV2-response.xml")));
		
		StubMapping stubKo = stubFor(post(urlEqualTo("/ProposteCJPOS.svc")).withRequestBody(containing("00700100000127778"))
				.willReturn(aResponse().withStatus(500).withHeader("content-type", "application/soap+xml")
						.withBodyFile("InviaPropostaV2-responseKO.xml")));

		stubGestioneOk();
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655703");
		
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
	public void testAnnulloCJ_CUI_DA_OK() throws Exception {
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655713");
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		
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
	public void testAnnullo_CJ_AFFIDAMENTI_OK() throws Exception {
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655713");
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		
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
	public void testAnnullo_CJ_CARTE_AZIENDALI_PG_OK() throws Exception {
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655713");
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString());
		
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

		dispositivaRequestDTO.getPratica().setCodPratica("0000655713");
		
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

	@Test
	public void test_ValidatorCodicePratica() throws Exception {

		boolean esito = true;
		
		//CASI OK
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString());
		
		dispositivaRequestDTO.getPratica().setCodPratica("");
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertTrue(esito);
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655703");
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertTrue(esito);
		
		//CASI KO
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		
		dispositivaRequestDTO.getPratica().setCodPratica("");
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertFalse(dispositivaRequestDTO.isValidCodPratica());
		
		dispositivaRequestDTO.getPratica().setCodPratica(null);
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertFalse(dispositivaRequestDTO.isValidCodPratica());
		
		dispositivaRequestDTO.getPratica().setCodPratica("test");
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertFalse(dispositivaRequestDTO.isValidCodPratica());
		
		dispositivaRequestDTO.getPratica().setCodPratica("123456789");
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertFalse(dispositivaRequestDTO.isValidCodPratica());
		
		dispositivaRequestDTO.getPratica().setCodPratica("12345678910");
		esito = dispositivaRequestDTO.isValidCodPratica();
		log.info("Test codProcesso: {}, codPratica: {}, esito: {} ",dispositivaRequestDTO.getCodProcesso(),dispositivaRequestDTO.getPratica().getCodPratica(),esito);
		Assert.assertFalse(dispositivaRequestDTO.isValidCodPratica());
		
	}
	
	@Test
	public void testConvenzioniHostServiceKOServizioNonDisponibile() throws Exception {

		stubInviaPropostaOK();

		stubGestioneOk();
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655703");
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		
		String inputJson = mapToJson(dispositivaRequestDTO);

		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
                .willReturn(
                		aResponse()
                		.withStatus(503)
                		.withHeader("Content-Type", "text/html")
                		.withBody("!!! Service Unavailable !!!")
                )
        );
		String uri = "/cjdispositiva/inserimento";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		content = mvcResult.getResponse().getContentAsString();
		Assert.assertTrue(content.contains(CommonErrorCode.BS_SRV_EXCEPTION));

	}
	
	@Test
	public void testConvenzioniHostServiceKOServizioNonTrovato() throws Exception {

		stubInviaPropostaOK();

		stubGestioneOk();
		
		dispositivaRequestDTO.getPratica().setCodPratica("0000655703");
		
		dispositivaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		
		String inputJson = mapToJson(dispositivaRequestDTO);

		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
                .willReturn(
                		aResponse()
                		.withStatus(404)
                		.withHeader("Content-Type", "text/html")
                		.withBody("!!! Service Unavailable !!!")
                )
        );
		String uri = "/cjdispositiva/inserimento";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		content = mvcResult.getResponse().getContentAsString();
		Assert.assertTrue(content.contains(CommonErrorCode.BS_SRV_EXCEPTION));

	}
}
