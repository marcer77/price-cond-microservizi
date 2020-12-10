package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodLinguaEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.handler.CJBaseExceptionHandler;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.command.CJDepositiAmministratiCommand;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.CTGConnectorWKNB;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers.WKNBCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers.WKNBCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.StampaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBRequest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponse;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponseRigheDiStampa;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.StampaResponseResource;
import com.intesasanpaolo.bear.core.resource.BaseResource;

@RunWith(SpringRunner.class)
public class CJDepositiAmministratiControllerTest extends BaseTest {

	private StampaRequestDTO stampaRequestDTO;

	private HttpHeaders httpHeaders;

	private HttpHeaders httpHeadersCorrotto;
	
	@MockBean
	private CTGConnectorWKNB ctgConnectorWKIB;
	
	@MockBean
	private WKNBCtgRequestTrasformer wkibCtgRequestTrasformer;

	@MockBean
	private WKNBCtgResponseTansformer wkibCtgResponseTansformer;
	
	@MockBean
	private WKNBRequest wkibRequest;
	
	@Before
	public void initMocks() throws Exception {
		
		stampaRequestDTO = new StampaRequestDTO();

		stampaRequestDTO.setCodAppl(CodApplEnum.FIDI.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString());
		stampaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		stampaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		stampaRequestDTO.setCodAppl(CodApplEnum.CARTE.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		stampaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		stampaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		stampaRequestDTO.setCodAppl(CodApplEnum.AREA_FINANZA.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		stampaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		stampaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		stampaRequestDTO.setRapporto(new RapportoDTO("12345", "1234", "12345678", "att"));
		stampaRequestDTO.setIntestatario(new IntestatarioDTO("1234567890123", "mock di test", "P"));
		stampaRequestDTO.setInfoStampa(new InfoStampaDTO(new Date(), "T", CodLinguaEnum.TEDESCO.toString()));
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.FRANCESE.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.INGLESE.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.SPAGNOLO.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.ITALIANO.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
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
		mockWKIBServiceBS_OK();
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
	public void testStampaWKIBServiceBS_KO() throws Exception {
		mockWKIBServiceBS_KO();
		String uri = "/cjdepositiamministrati/stampa";

		String inputJson = mapToJson(stampaRequestDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertFalse(content.contains("\"codErrore\":\"00"));
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

	private void mockWKIBServiceBS_OK() {
		WKNBResponse wkibResponse = new WKNBResponse();
		List<WKNBResponseRigheDiStampa> lista = new ArrayList<WKNBResponseRigheDiStampa>();
		WKNBResponseRigheDiStampa elem = new WKNBResponseRigheDiStampa();
		
		elem = new WKNBResponseRigheDiStampa();
		elem.setTipoStrut("C");
		lista.add(elem);
		
		elem = new WKNBResponseRigheDiStampa();
		elem.setTipoStrut("T");
		lista.add(elem);
		
		elem = new WKNBResponseRigheDiStampa();
		elem.setTipoStrut("Y");
		lista.add(elem);
		
		elem = new WKNBResponseRigheDiStampa();
		elem.setTipoStrut("N");
		lista.add(elem);
		
		elem = new WKNBResponseRigheDiStampa();
		elem.setTipoStrut("M");
		lista.add(elem);
		wkibResponse.setElenco(lista);
		wkibResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		wkibResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());
		Mockito.when(ctgConnectorWKIB.call(wkibRequest, wkibCtgRequestTrasformer, wkibCtgResponseTansformer, new Object[] {}))
		.thenReturn(wkibResponse);
	}
	

	private void mockWKIBServiceBS_KO() {
		WKNBResponse wkibResponse = new WKNBResponse();
		wkibResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0012").build());
		wkibResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());
		Mockito.when(ctgConnectorWKIB.call(wkibRequest, wkibCtgRequestTrasformer, wkibCtgResponseTansformer, new Object[] {}))
		.thenReturn(wkibResponse);
	}
	
}
