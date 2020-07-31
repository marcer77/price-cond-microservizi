package com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.EventoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.TipoRichiestaEnum;

@RunWith(SpringRunner.class)
//@Ignore
public class CJIndicatoriCostoControllerTest extends BaseTest {
	@Test
	public void testCalcola() throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		IndicatoriCostoDTO dto = new IndicatoriCostoDTO();
		dto.setCodAppl(CodApplEnum.CARTE.toString());
		dto.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		dto.setRichiesta(TipoRichiestaEnum.CALCOLA.toString());
		dto.setClassificazione("test");
		PraticaDTO pratica = new PraticaDTO();
		pratica.setCodSuperPratica("1234567890");
		dto.setPratica(pratica);
		EventoDTO evento = new EventoDTO();
		evento.setCodice("test");
		evento.setSubCodice("test");
		dto.setEvento(evento);

		
		String inputJson = mapToJson(dto);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		System.err.println(status);
		//Assert.assertEquals(200, status);
		log.info("content = {}", content);
		System.err.println(content);

	}

}
