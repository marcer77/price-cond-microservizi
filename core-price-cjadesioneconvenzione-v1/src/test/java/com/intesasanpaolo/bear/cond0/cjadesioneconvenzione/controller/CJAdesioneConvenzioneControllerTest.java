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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
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
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.SuperPraticaService;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.any;



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
	
	public InputStampaDTO inputStampaDTO = new InputStampaDTO();
	
	@Before
	public void initMock() {

		buildInputStampa();
		
		T1SJResponse t1sfResponse=new T1SJResponse();
		FL03Response fl03Response=new FL03Response();
		fl03Response.setRc("06");
		fl03Response.setStringaOut("<xml>Documento di test.</xml>");
		Mockito.when(ctgConnectorT1SJ.call(t1SFRequest, requestTransformer, responseTransformer,new Object[] {})).thenReturn(t1sfResponse);
		Mockito.when(ctgConnectorFL03.call(fL03Request, fl03CtgRequestTrasformer, fl03CtgResponseTansformer,new Object[] {})).thenReturn(fl03Response);
		
		List<String> codConvenzione = new ArrayList<String>();
		codConvenzione.add("00700100000005749CC1000S0                         ");
		
		ReqGetCovenantPerConvenzione getCovPerConRequest = new ReqGetCovenantPerConvenzione();
		getCovPerConRequest.setAbi("01025");
		getCovPerConRequest.setApplicativoId("0");
		getCovPerConRequest.setCodConvenzione("00700100000005749CC1000S0                         ");
		getCovPerConRequest.setDataAdesione(ServiceUtil.dateToString(new Date(), "yyyyMMdd"));
		getCovPerConRequest.setUserId("U015886");
		
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp = new ArrayList<RespGetCovenantPerConvenzioneCovenantDaAttivare>();
		RespGetCovenantPerConvenzioneCovenantDaAttivare resp = new RespGetCovenantPerConvenzioneCovenantDaAttivare();
		resp.setBeneficioCondizionatoDataFine("123");
		resp.setBeneficioCondizionatoDataInizio("456");
		getCovPerConResp.add(resp);

		stubFor(post(urlEqualTo("/ConvenzioniHostService.svc")).withRequestBody(containing("GetCovenantPerConvenzione"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-type", 
                          "text/xml")                             
                .withBodyFile("GetCovenantPerConvenzione-response2.xml")
                )
        );
		
		System.out.println("Inizio test");
	}
	
	private void buildInputStampa() {
		PraticaDTO pratica = new PraticaDTO();
		pratica.setCodPratica("0000655703");
		pratica.setCodPropostaComm("");
		pratica.setCodSuperPratica("0001161961");
		inputStampaDTO.setPratica(pratica);

		inputStampaDTO.setCodAppl("X");
		inputStampaDTO.setCodProcesso("CJCPG");
		
		RapportoDTO rapportoDTO = new RapportoDTO();
		rapportoDTO.setCodFiliale("12345");
		rapportoDTO.setCodCategoria("1234");
		rapportoDTO.setCodProgressivo("12345678");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		IntestatarioDTO intestatarioDTO = new IntestatarioDTO();
		
		intestatarioDTO.setNdg("1234561234560");
		intestatarioDTO.setIntestazione("Intestazione di test");
		intestatarioDTO.setSpecieGiur("PERSO");
		intestatarioDTO.setCodFiscale("RSSMRA80A01H703F");
		intestatarioDTO.setPIva("12345678901");

		ArrayList<RecapitoDTO> recapiti = new ArrayList<RecapitoDTO>();

		RecapitoDTO recapitoDTO = new RecapitoDTO();
		recapitoDTO.setTipo("test tipo");
		recapitoDTO.setIndirizzo("via dei test");
		recapitoDTO.setCap("00000");
		recapitoDTO.setComune("Comune di test");
		recapitoDTO.setFrazione("Frazione di test");
		recapitoDTO.setProvincia("TE");
		recapiti.add(recapitoDTO);

		intestatarioDTO.setRecapiti(recapiti);
		
		inputStampaDTO.setIntestatario(intestatarioDTO);

		ArrayList<FirmatarioDTO> listaFirmatari = new ArrayList<FirmatarioDTO>();

		for (int i = 0; i < 13; i++) {
			listaFirmatari.add(new FirmatarioDTO("1234561234560","Intestazione di test"));
		}

		inputStampaDTO.setFirmatari(listaFirmatari);

		InfoStampaDTO infoStampa = new InfoStampaDTO();
		infoStampa.setData(new Date(System.currentTimeMillis()));
		infoStampa.setTipoStampa("Stampa di test");
		infoStampa.setTipoOfferta("Offerta di test");
		infoStampa.setTipoFirma("Firma di test");
		infoStampa.setCodLingua("Lingua di test");
		infoStampa.setKeyOper("123456789012345678901234567890");
		infoStampa.setData(new Date());
		inputStampaDTO.setInfoStampa(infoStampa);
	}
	
	@Test
	public void testStampaOK() throws Exception {
		
		
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
                .withBodyFile("GetRequisitiAdesioneConvenzione-response2.xml")
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

}
