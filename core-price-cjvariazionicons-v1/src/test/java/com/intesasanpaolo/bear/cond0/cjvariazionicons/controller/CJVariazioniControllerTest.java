package com.intesasanpaolo.bear.cond0.cjvariazionicons.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorT1SF;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;

@RunWith(SpringRunner.class)
public class CJVariazioniControllerTest extends BaseTest{
	
	@MockBean
	private CTGConnectorT1SF ctgConnectorT1SF;

	@MockBean
	private T1SFCtgRequestTrasformer requestTransformer;

	@MockBean
	private  T1SFCtgResponseTansformer responseTransformer;
	
	@MockBean
	private  T1SFRequest t1SFRequest;

	@MockBean
	private  FL03Request fL03Request;

	@MockBean
	private CTGConnectorFL03 ctgConnectorFL03;
		
	@MockBean
	private FL03CtgRequestTrasformer fl03CtgRequestTrasformer;

	@MockBean
	private FL03CtgResponseTansformer fl03CtgResponseTansformer;

	@Test
	public void testStampaOK() throws Exception {
		T1SFResponse t1sfResponse=new T1SFResponse();
		FL03Response fl03Response=new FL03Response();
		
		Mockito.when(ctgConnectorT1SF.call(t1SFRequest, requestTransformer, responseTransformer,new Object[] {})).thenReturn(t1sfResponse);
		Mockito.when(ctgConnectorFL03.call(fL03Request, fl03CtgRequestTrasformer, fl03CtgResponseTansformer,new Object[] {})).thenReturn(fl03Response);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
		
		
		InputStampaDTO inputStampaDTO = new InputStampaDTO();
		InfoStampaDTO infoStampaDTO=new InfoStampaDTO();
		infoStampaDTO.setData(new Date());
		inputStampaDTO.setInfoStampa(infoStampaDTO);
		
		inputStampaDTO.setRapporto(new RapportoDTO());
		inputStampaDTO.getRapporto().setCodCategoria("1234");
		
		inputStampaDTO.setPratica(new PraticaDTO());
		inputStampaDTO.getPratica().setCodPratica("1234");
		inputStampaDTO.getPratica().setCodSuperPratica("1234");
		
		
		String inputJson = mapToJson(inputStampaDTO);
		String uri ="/cjvariazionicons/stampa";
		   
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}
	
	@Test
	public void testStampaKO() throws Exception {
		//T1SFResponse t1sfResponse=new T1SFResponse();
		//FL03Response fl03Response=new FL03Response();
		
		//Mockito.when(ctgConnectorT1SF.call(t1SFRequest, requestTransformer, responseTransformer,new Object[] {})).thenReturn(t1sfResponse);
		//Mockito.when(ctgConnectorFL03.call(fL03Request, fl03CtgRequestTrasformer, fl03CtgResponseTansformer,new Object[] {})).thenReturn(fl03Response);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		//httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
		
		
		InputStampaDTO inputStampaDTO = new InputStampaDTO();
		InfoStampaDTO infoStampaDTO=new InfoStampaDTO();
		//infoStampaDTO.setData(new Date());
		inputStampaDTO.setInfoStampa(infoStampaDTO);
		String inputJson = mapToJson(inputStampaDTO);
		String uri ="/cjvariazionicons/stampa";
		   
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(400, status);
		log.info("content = {}", content);

	}
}
