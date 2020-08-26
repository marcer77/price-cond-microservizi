package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.controller;

import java.util.Date;

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
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodLinguaEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.StampaRequestDTO;

@RunWith(SpringRunner.class)
public class CJDepositiAmministratiControllerTest extends BaseTest {

	private StampaRequestDTO stampaRequestDTO;

	private HttpHeaders httpHeaders;

	private HttpHeaders httpHeadersCorrotto;
	
	@Before
	public void initMocks() throws Exception {
		
		stampaRequestDTO = new StampaRequestDTO();

		stampaRequestDTO.setCodAppl(CodApplEnum.AREA_FINANZA.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		stampaRequestDTO.setRapporto(new RapportoDTO("12345", "1234", "12345678", "att"));
		stampaRequestDTO.setIntestatario(new IntestatarioDTO("1234567890123", "mock di test", "P"));
		stampaRequestDTO.setInfoStampa(new InfoStampaDTO(new Date(), "T", CodLinguaEnum.ITALIANO.toString()));
		
		httpHeaders = new HttpHeaders();

		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa", "01025");
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
	
	@Test
	public void testStampaOK() throws Exception {

		String uri = "/cjdepositiamministrati/stampa";

		String inputJson = mapToJson(stampaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}
	
	@Test
	public void testStampa_HeadersKO() throws Exception {
		
		String uri = "/cjdepositiamministrati/stampa";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).headers(httpHeadersCorrotto))
				.andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertNotEquals(200, status);
		log.info("content = {}", content);

	}

}
