package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.cond0.cjdispositiva.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PropostaDTO;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class SimulatorControllerTest extends BaseTest {

	@Before
	public void initMocks() throws Exception {

	}

	@Test
	public void testInviaPropostaV2OK() throws Exception {

		String headerJson = mapToJson(new ISPWebservicesHeaderType());
		String inputJson = mapToJson(new PropostaDTO());
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
	public void testRevocaPropostaOK() throws Exception {

		String headerJson = mapToJson(new ISPWebservicesHeaderType());
		String inputJson = mapToJson(new PropostaDTO());
		String uri = "/simulator/wsProposteCJPOSrevocaProposta";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(headerJson).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}

}
