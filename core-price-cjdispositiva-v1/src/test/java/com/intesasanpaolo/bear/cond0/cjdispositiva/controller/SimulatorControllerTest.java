package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.cond0.cjdispositiva.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;

@RunWith(SpringRunner.class)
public class SimulatorControllerTest extends BaseTest {

	private HttpHeaders httpHeaders;
	
	@Before
	public void initMocks() throws Exception {
		
		httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");
		
	}
	
	@Test
	public void testInviaPropostaV2OK() throws Exception {

		String headerJson = mapToJson(ProposteCJPOSWSUtils._buildMockedHeaderInviaProstaV2());
		String inputJson = mapToJson(ProposteCJPOSWSUtils._buildMockInviaPropostaV2());
		String uri = "/simulator/wsProposteCJPOSinviaPropostaV2";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(headerJson).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

	@Test
	public void testInviaPropostaV2KO() throws Exception {

		String headerJson = mapToJson(ProposteCJPOSWSUtils._buildMockedHeaderInviaProstaV2());
		String inputJson = mapToJson(null);
		String uri = "/simulator/wsProposteCJPOSinviaPropostaV2";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(headerJson).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(403, status);
		log.info("content = {}", content);

	}

	@Test
	public void testRevocaPropostaOK() throws Exception {

		String inputJson = mapToJson(ProposteCJPOSWSUtils._buildMockRevocaProposta());
		String uri = "/simulator/wsProposteCJPOSrevocaProposta";

		String headerJson = mapToJson(ProposteCJPOSWSUtils._buildMockedHeaderRevocaProposta());
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(headerJson).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		
	}

	@Test
	public void testRevocaPropostaKO() throws Exception {

		String inputJson = mapToJson(null);
		String uri = "/simulator/wsProposteCJPOSrevocaProposta";

		String headerJson = mapToJson(ProposteCJPOSWSUtils._buildMockedHeaderRevocaProposta());
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(headerJson).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(403, status);
		log.info("content = {}", content);

	}
	
}
