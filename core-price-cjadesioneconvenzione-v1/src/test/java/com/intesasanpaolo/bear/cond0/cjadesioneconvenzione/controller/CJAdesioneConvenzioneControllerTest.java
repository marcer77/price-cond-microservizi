package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.http.Fault;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorT1SJ;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.T1SJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.T1SJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception.CJWebServiceException.CJWebServiceExceptionBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception.ErrorCode;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.StampaResponseResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniHostService;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzione;



@RunWith(SpringRunner.class)
public class CJAdesioneConvenzioneControllerTest extends BaseTest {
	
	
	@Rule
    public WireMockRule backendService = new WireMockRule(4545);
	
	@MockBean
	private CTGConnectorT1SJ ctgConnectorT1SJ;

	@MockBean
	private T1SJCtgRequestTrasformer requestTransformer;

	@MockBean
	private  T1SJCtgResponseTansformer responseTransformer;
	
	@MockBean
	private  T1SJRequest t1SFRequest;

	@MockBean
	private  FL03Request fL03Request;

	@MockBean
	private CTGConnectorFL03 ctgConnectorFL03;
		
	@MockBean
	private FL03CtgRequestTrasformer fl03CtgRequestTrasformer;

	@MockBean
	private FL03CtgResponseTansformer fl03CtgResponseTansformer;
	
	
	private InputStampaDTO inputStampaDTO = new InputStampaDTO();
	
	@Before
	public void initMock() {

		inputStampaDTO=buildInputStampaDTO();
		
		//mock connettori CTG
		T1SJResponse t1sjResponse=new T1SJResponse();
		t1sjResponse.setT1SjOReturnCode("00");
		t1sjResponse.setOutEsi(new OutEsi());
		t1sjResponse.getOutEsi().setMdwEsiRetc("0000");
		
		FL03Response fl03Response=new FL03Response();
		fl03Response.setOutEsi(new OutEsi());
		fl03Response.getOutEsi().setMdwEsiRetc("0000");
		fl03Response.setRc("06");
		fl03Response.setStringaOut("<xml>Documento di test.</xml>");
		
		Mockito.when(ctgConnectorT1SJ.call(t1SFRequest, requestTransformer, responseTransformer,new Object[] {})).thenReturn(t1sjResponse);
		Mockito.when(ctgConnectorFL03.call(fL03Request, fl03CtgRequestTrasformer, fl03CtgResponseTansformer,new Object[] {})).thenReturn(fl03Response);
		
		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc")).withRequestBody(containing("GetCovenantPerConvenzione"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-type", 
                          "text/xml")                             
                .withBodyFile("GetCovenantPerConvenzione-response2.xml")
                )
        );

		stubFor(post(urlEqualTo("/ConvenzioniService.svc")).withRequestBody(containing("GetRequisitiAdesioneConvenzione"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-type", 
                          "text/xml")                             
                .withBodyFile("GetRequisitiAdesioneConvenzione-response3.xml")
                )
        );
	}
	
	@Test
	public void testStampaOK() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();

		String inputJson = mapToJson(inputStampaDTO);
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("<xml>Documento di test.</xml>"));

	}
	
	@Test
	public void testStampaXmlCorrotto() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();

		String inputJson = mapToJson(inputStampaDTO);
		String uri = "/cjadesioneconvenzione/stampa";

		FL03Response fl03ResponseCorrotto=new FL03Response();
		fl03ResponseCorrotto.setOutEsi(new OutEsi());
		fl03ResponseCorrotto.getOutEsi().setMdwEsiRetc("0000");
		fl03ResponseCorrotto.setRc("06");
		fl03ResponseCorrotto.setStringaOut("<xml>Documento di test corrotto.");
		
		Mockito.when(ctgConnectorFL03.call(fL03Request, fl03CtgRequestTrasformer, fl03CtgResponseTansformer,new Object[] {})).thenReturn(fl03ResponseCorrotto);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"descErrore\":\"XML di stampa non corretto.\""));

	}
	
	@Test
	public void testStampaOK2() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();

		inputStampaDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		
		String inputJson = mapToJson(inputStampaDTO);
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("<flcnv01_st_banca>INTESA SANPAOLO S.P.A.</flcnv01_st_banca>"));

	}
	
	@Test
	public void testStampaKOErroreT1SJ() throws Exception {
		//mock connettori CTG:supponiamo che T1SJ vada in errore
		T1SJResponse t1sjResponse=new T1SJResponse();
		t1sjResponse.setOutEsi(new OutEsi());
		t1sjResponse.setOutSeg(new OutSeg());
		t1sjResponse.getOutEsi().setMdwEsiRetc("0012");
		t1sjResponse.getOutEsi().setMdwEsiAnom("erroreBS");
		t1sjResponse.getOutEsi().setMdwEsiMsg("erroreBS");
		Mockito.when(ctgConnectorT1SJ.call(t1SFRequest, requestTransformer, responseTransformer,new Object[] {})).thenReturn(t1sjResponse);
		/////////////////
		
		HttpHeaders httpHeaders = mockHttpHeaders();

		String inputJson = mapToJson(inputStampaDTO);
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		StampaResponseResource response=mapFromJson(content, StampaResponseResource.class);
		Assert.assertTrue(response.getEsitoStampaResource().getCodErrore().equalsIgnoreCase(CommonErrorCode.BS_SRV_EXCEPTION));

	}
	
	@Test
	public void testStampaKOConvenzioneInesistente() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();
		//
		inputStampaDTO.getPratica().setCodSuperPratica("9991161961");
		String inputJson = mapToJson(inputStampaDTO);
		
		
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		StampaResponseResource response=mapFromJson(content, StampaResponseResource.class);

	}
	
	@Test
	public void testStampaKOErroreApplicativoWS() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();
		String inputJson = mapToJson(inputStampaDTO);
		
		stubFor(post(urlEqualTo("/ConvenzioniService.svc")).withRequestBody(containing("GetRequisitiAdesioneConvenzione"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-type", 
                          "text/xml")                             
                .withBodyFile("GetRequisitiAdesioneConvenzione-response4.xml")
                )
        );
		
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		StampaResponseResource response=mapFromJson(content, StampaResponseResource.class);
		Assert.assertTrue(response.getEsitoStampaResource().getCodErrore().equalsIgnoreCase("00"));

	}
	
	@Test
	public void testConvenzioniServiceKOServizioNonDisponibile() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();
		String inputJson = mapToJson(inputStampaDTO);

		stubFor(post(urlEqualTo("/ConvenzioniService.svc"))
                .willReturn(
                		aResponse()
                		.withStatus(503)
                		.withHeader("Content-Type", "text/html")
                		.withBody("!!! Service Unavailable !!!")
                )
        );
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		StampaResponseResource response=mapFromJson(content, StampaResponseResource.class);
		Assert.assertTrue(response.getEsitoStampaResource().getCodErrore().equalsIgnoreCase(CommonErrorCode.BS_SRV_EXCEPTION));

	}
	
	@Test
	public void testConvenzioniHostServiceKOServizioNonDisponibile() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();
		String inputJson = mapToJson(inputStampaDTO);

		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
                .willReturn(
                		aResponse()
                		.withStatus(503)
                		.withHeader("Content-Type", "text/html")
                		.withBody("!!! Service Unavailable !!!")
                )
        );
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		StampaResponseResource response=mapFromJson(content, StampaResponseResource.class);
		Assert.assertTrue(response.getEsitoStampaResource().getCodErrore().equalsIgnoreCase(CommonErrorCode.BS_SRV_EXCEPTION));

	}
	
	@Test
	public void testConvenzioniHostServiceKOServizioNonTrovato() throws Exception {
				
		HttpHeaders httpHeaders = mockHttpHeaders();
		String inputJson = mapToJson(inputStampaDTO);

		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc"))
                .willReturn(
                		aResponse()
                		.withStatus(404)
                		.withHeader("Content-Type", "text/html")
                		.withBody("!!! Service Unavailable !!!")
                )
        );
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		StampaResponseResource response=mapFromJson(content, StampaResponseResource.class);
		Assert.assertTrue(response.getEsitoStampaResource().getCodErrore().equalsIgnoreCase(CommonErrorCode.BS_SRV_EXCEPTION));

	}
	
	
	private HttpHeaders mockHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		httpHeaders.add("ISPWebservicesHeader.RequestInfo.ServiceID", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.ServiceVersion", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.CallerProgramName", "0");
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa", "00700");
		httpHeaders.add("ISPWebservicesHeader.BusinessInfo.CustomerID", "U015886");
		return httpHeaders;
	}
	

}
