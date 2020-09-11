package com.intesasanpaolo.bear.cond0.cjoffertaconto.controller;

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
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.CTGConnectorPCMY;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers.PCMYCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers.PCMYCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.InputEsponiDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.PromozioniDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutCPR;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutOFF;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutPRD;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYRequest;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYResponse;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.OffertaResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ProdottoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ValoriOffertaResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ValoriProdottoResource;

@RunWith(SpringRunner.class)
public class CJOffertaContoControllerTest extends BaseTest{
	
	private HttpHeaders httpHeaders;
	private HttpHeaders httpHeadersCorrotto;
	private InputEsponiDTO inputEsponiDTO;
	
	@MockBean
	private CTGConnectorPCMY ctgConnectorPCMY;
	
	@MockBean
	private PCMYCtgRequestTrasformer pcmyCtgRequestTrasformer;
	
	@MockBean
	private PCMYCtgResponseTansformer pcmyCtgResponseTansformer;
	
	@MockBean
	private PCMYRequest request;
	
	@Before
	public void initMocks() throws Exception {
		
		inputEsponiDTO = new InputEsponiDTO();

		inputEsponiDTO.setCodAppl(CodApplEnum.AREA_FINANZA.toString());
		inputEsponiDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		inputEsponiDTO.setRapporto(new RapportoDTO("12345", "1234", "12345678"));
		inputEsponiDTO.setTipoDA("CU");
		inputEsponiDTO.setDataRif(new Date());
		List<PromozioniDTO> promozioni = new ArrayList<PromozioniDTO>();
		PromozioniDTO promozione = new PromozioniDTO();
		promozione.setCodice("12345");
		promozione.setDataDecorrenza(new Date());
		promozione.setDataScadenza(new Date());
		promozioni.add(promozione);
		inputEsponiDTO.setPromozioni(promozioni);
		
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
		httpHeadersCorrotto.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa", "01025");
		httpHeadersCorrotto.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "");
		httpHeadersCorrotto.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "");
		httpHeadersCorrotto.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.ServiceID", "PCGESTIXME");
		httpHeadersCorrotto.add("ISPWebservicesHeader.RequestInfo.ServiceVersion", "00");
		httpHeadersCorrotto.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeadersCorrotto.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "");
	}
	
	
	@Test
	public void testStampaOK() throws Exception {
		mockPCMYServiceBS_OK();
		String uri = "/cjoffertaconto/esponi";

		String inputJson = mapToJson(inputEsponiDTO);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);

	}
	
	private void mockPCMYServiceBS_OK() {
		PCMYResponse pcmyResponse = new PCMYResponse();
		pcmyResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		pcmyResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());
		pcmyResponse.setCodOfferta("");
		pcmyResponse.setCodEsito("00");
		
		List<OutOFF> outOffList = new ArrayList<OutOFF>();
		OutOFF outOff = new OutOFF();
		outOff.setCostoListino(new Double("0.0"));
		outOff.setCostoOfferta(new Double("0.0"));
		outOffList.add(outOff);
		
		List<OutPRD> outPrdList = new ArrayList<OutPRD>();
		OutPRD outPRD = new OutPRD();
		outPrdList.add(outPRD);
		
		List<OutCPR> outCPRList = new ArrayList<OutCPR>();
		OutCPR outCPR = new OutCPR();
		outCPR.setCostoProdotto(new Double("0.0"));
		outCPR.setCostoProdottoPRM(new Double("0.0"));
		outCPRList.add(outCPR);
		outPrdList.get(0).setOutCPRList(outCPRList);
		
		
		pcmyResponse.setOutOffList(outOffList);
		pcmyResponse.setOutPrdList(outPrdList);
		Mockito.when(
				this.ctgConnectorPCMY.call(request, pcmyCtgRequestTrasformer, pcmyCtgResponseTansformer, new Object[] {})
		).thenReturn(pcmyResponse);
	}
	
	
	@Test
	public void testStampa_HeadersKO() throws Exception {
		
		String uri = "/cjoffertaconto/esponi";

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
