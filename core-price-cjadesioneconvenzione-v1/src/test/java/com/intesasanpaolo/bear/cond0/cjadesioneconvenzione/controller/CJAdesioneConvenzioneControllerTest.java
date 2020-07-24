package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorT1SJ;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.T1SJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.T1SJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;



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
	
	@Before
	public void initMock() {
		T1SJResponse t1sfResponse=new T1SJResponse();
		FL03Response fl03Response=new FL03Response();
		
		Mockito.when(ctgConnectorT1SJ.call(t1SFRequest, requestTransformer, responseTransformer,new Object[] {})).thenReturn(t1sfResponse);
		Mockito.when(ctgConnectorFL03.call(fL03Request, fl03CtgRequestTrasformer, fl03CtgResponseTansformer,new Object[] {})).thenReturn(fl03Response);
		 
	}
	
	@Test
	public void testStampaOK() throws Exception {
		
		
		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc")).withRequestBody(containing("GetCovenantPerConvenzione"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-type", 
                          "text/xml")                             
                .withBodyFile("GetCovenantPerConvenzione-response.xml")
                )
        );

		stubFor(post(urlEqualTo("/ConvenzioniService.svc")).withRequestBody(containing("GetRequisitiAdesioneConvenzione"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-type", 
                          "text/xml")                             
                .withBodyFile("GetRequisitiAdesioneConvenzione-response.xml")
                )
        );

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		InputStampaDTO inputStampaDTO = new InputStampaDTO();
		
		IntestatarioDTO intestatario = new IntestatarioDTO();
		
		List<RecapitoDTO> recapiti = new ArrayList<>();
		RecapitoDTO e = new RecapitoDTO();
		recapiti.add(e);
		
		intestatario.setRecapiti(recapiti );
		inputStampaDTO.setIntestatario(intestatario );
		
		InfoStampaDTO infoStampa = new InfoStampaDTO();
		inputStampaDTO.setInfoStampa(infoStampa );
		
		
		PraticaDTO pratica = new PraticaDTO();
		inputStampaDTO.setPratica(pratica  );
		
		pratica.setCodPratica("11");
		pratica.setCodPropostaComm("12");
		pratica.setCodSuperPratica("12");
		
		RapportoDTO rapporto = new RapportoDTO();
		inputStampaDTO.setRapporto(rapporto );
		
		
		InfoStampaDTO infoStampaDTO = new InfoStampaDTO();
		infoStampaDTO.setData(new Date());
		inputStampaDTO.setInfoStampa(infoStampaDTO);
		String inputJson = mapToJson(inputStampaDTO);
		String uri = "/cjadesioneconvenzione/stampa";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

}
