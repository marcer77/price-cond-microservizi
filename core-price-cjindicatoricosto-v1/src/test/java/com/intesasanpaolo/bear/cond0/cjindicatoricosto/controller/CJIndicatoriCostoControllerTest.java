package com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorPCUJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorWKCJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.WKCJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.WKCJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.EventoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.TipoRichiestaEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutRIP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutTAS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutCNF;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRAF;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRAP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutSTP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.SuperPraticaService;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg.PCUJServiceBS;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
//@Ignore
public class CJIndicatoriCostoControllerTest extends BaseTest {

	@Rule
	public WireMockRule backendService = new WireMockRule(4545);

	private HttpHeaders httpHeaders;

	@MockBean
	private CTGConnectorWKCJ ctgConnectorWKCJ;

	@MockBean
	private WKCJCtgRequestTrasformer requestTransformer;

	@MockBean
	private WKCJCtgResponseTansformer responseTransformer;

	@MockBean
	private CTGConnectorPCUJ ctgConnectorPCUJ;

	@MockBean
	private PCUJCtgRequestTrasformer requestTransformerPCUJ;

	@MockBean
	private PCUJCtgResponseTansformer responseTransformerPCUJ;

	private WKCJRequest wkcjRequest;
	private PCUJRequest pcujRequest;

	@Before
	public void initMock() throws BSException {

		httpHeaders = new HttpHeaders();
		httpHeaders.add("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", "01025");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", "01");
		httpHeaders.add("ISPWebservicesHeader.OperatorInfo.UserID", "U015886");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.Timestamp", "0");
		httpHeaders.add("ISPWebservicesHeader.RequestInfo.TransactionId", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ApplicationID", "0");
		httpHeaders.add("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", "0");

		wkcjRequest = WKCJRequest.builder().ispWebservicesHeaderType(buildMockHeader()).pratica("").superpratica("")
				.tipoChiamata("A4").build();

		pcujRequest = PCUJRequest.builder().ispWebservicesHeaderType(buildMockHeader()).nrSuperpratica("")
				.nrPratica("").build();

	}

	/*
	 * private WKCJResponse buildWKCJResponse(String tipoRichiesta) { WKCJResponse
	 * wkcjResponse = new WKCJResponse(); ArrayList<OutCNF> outCNFList = new
	 * ArrayList<OutCNF>(); if
	 * (TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString().equals(tipoRichiesta)) {
	 * OutCNF outCNF = new OutCNF(); outCNF.setCodCnd("cndTest");
	 * outCNFList.add(outCNF); } wkcjResponse.setOutCNFList(outCNFList);
	 * 
	 * List<OutRAF> outRAFList = new ArrayList<>(); List<OutRAP> outRAPList = new
	 * ArrayList<>(); List<OutSTP> outSTPList = new ArrayList<>();
	 * wkcjResponse.setOutRAFList(outRAFList);
	 * wkcjResponse.setOutRAPList(outRAPList);
	 * wkcjResponse.setOutSTPList(outSTPList); return wkcjResponse; }
	 */

	/*
	 * @Test public void testCalcola() throws Exception {
	 * 
	 * dto.setRichiesta(TipoRichiestaEnum.CALCOLA.toString());
	 * 
	 * WKCJRequest wkcjRequest =
	 * WKCJRequest.builder().ispWebservicesHeaderType(buildMockHeader()).pratica(
	 * pratica)
	 * .superpratica(dto.getPratica().getCodSuperPratica()).tipoChiamata("A4").build
	 * ();
	 * 
	 * Mockito.when(ctgConnectorWKCJ.call(wkcjRequest, requestTransformer,
	 * responseTransformer, new Object[] {}))
	 * .thenReturn(buildWKCJResponse(dto.getRichiesta()));
	 * 
	 * String inputJson = mapToJson(dto); String uri = "/cjindicatoricosto/calcolo";
	 * 
	 * MvcResult mvcResult =
	 * mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.
	 * APPLICATION_JSON_VALUE)
	 * .headers(httpHeaders).content(inputJson)).andReturn();
	 * 
	 * String content = mvcResult.getResponse().getContentAsString(); int status =
	 * mvcResult.getResponse().getStatus(); log.info("status = " + status);
	 * Assert.assertEquals(200, status); log.info("content = {}", content);
	 * System.err.println("TestCalcola " + content);
	 * Assert.assertTrue(content.contains("\"codErrore\":\"00\""));
	 * 
	 * }
	 */
	// @Autowired
	// private PCUJServiceBS pCUJServiceBS;

	// @Autowired
	// private SuperPraticaService superPraticaService;
	// System.out.println(pCUJServiceBS.getDescrizioneCondizione("00813"));
	// System.out.println(superPraticaService.recuperaPraticheBySuperPratica("01025",
	// "0001161961"));

	@Test
	public void testCalcolaAndControllaOK() throws Exception {
		mock_PCUJ_OK();
		mock_WKCJ_OK();

		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"00\""));

	}

	@Test
	public void testCalcolaOK() throws Exception {
		mock_PCUJ_OK();
		mock_WKCJ_OK();

		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(TipoRichiestaEnum.CALCOLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"00\""));

	}

	@Test
	public void testCalcolaAndControllaKOSuperPraticaNonTrovata() throws Exception {
		mock_PCUJ_OK();
		mock_WKCJ_OK();

		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		indicatoriCostoDTO.getPratica().setCodSuperPratica("9999999999");

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"92\""));
		// CommonErrorCode.DB2_EXCEPTION=92 per SuperPraticaNotFoundDB2Exception
	}

	@Test
	public void testCalcolaAndControllaKO_ERRORE_WKCJ() throws Exception {
		mock_PCUJ_OK();
		mock_WKCJ_KO();

		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"97\""));
		// CommonErrorCode.BS_SRV_EXCEPTION=97
	}

	@Test
	public void testCalcolaAndControllaKO_ERRORE_PCUJ() throws Exception {
		mock_PCUJ_KO();
		mock_WKCJ_OK();

		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"97\""));
		// CommonErrorCode.BS_SRV_EXCEPTION=97
	}

	@Test
	public void testCalcolaAndControllaKO_WARNING_WKCJ_1() throws Exception {
		mock_PCUJ_OK();
		mock_WKCJ_WARNING();

		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"01\""));
		// CommonErrorCode.BS_SRV_EXCEPTION=97
	}

	@Test
	public void testCalcolaAndControllaKO_WARNING_WKCJ_2() throws Exception {
		mock_WKCJ_WARNING();
		mock_PCUJ_WARNING("02");
		
		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"01\""));
	}
	
	@Test
	public void testCalcolaAndControllaKO_WARNING_WKCJ_3() throws Exception {
		mock_WKCJ_WARNING();
		mock_PCUJ_WARNING("03");
		
		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"01\""));
	}
	
	@Test
	public void testCalcolaAndControllaKO_WARNING_WKCJ_4() throws Exception {
		mock_WKCJ_WARNING();
		mock_PCUJ_WARNING("02");
		
		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"01\""));
	}
	
	@Test
	public void testCalcolaAndControllaKO_WARNING_PCUJ_1() throws Exception {
		mock_WKCJ_OK();
		mock_PCUJ_WARNING("02");
		
		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"02\""));
		// CommonErrorCode.BS_SRV_EXCEPTION=97
	}
	
	@Test
	public void testCalcolaAndControllaKO_WARNING_PCUJ_2() throws Exception {
		mock_WKCJ_OK();
		mock_PCUJ_WARNING("03");
		
		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"03\""));
		// CommonErrorCode.BS_SRV_EXCEPTION=97
	}
	
	@Test
	public void testCalcolaAndControllaKO_WARNING_PCUJ_3() throws Exception {
		mock_WKCJ_OK();
		mock_PCUJ_WARNING("01");
		
		IndicatoriCostoDTO indicatoriCostoDTO = mockIndicatoriCostoDTO(
				TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString());

		String inputJson = mapToJson(indicatoriCostoDTO);
		String uri = "/cjindicatoricosto/calcolo";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(httpHeaders).content(inputJson)).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		log.info("status = " + status);
		Assert.assertEquals(200, status);
		log.info("content = {}", content);
		Assert.assertTrue(content.contains("\"codErrore\":\"01\""));
		// CommonErrorCode.BS_SRV_EXCEPTION=97
	}
	
	
	
	private void mock_WKCJ_WARNING() {
		// LA WKCJ RITORNA CONDIZIONI VARIATE
		WKCJResponse wkcjResponse = new WKCJResponse();
		ArrayList<OutCNF> outCNFList = new ArrayList<OutCNF>();

		OutCNF outCNF = new OutCNF();
		outCNF.setCodCnd("cndTest");
		outCNFList.add(outCNF);

		wkcjResponse.setOutCNFList(outCNFList);
		wkcjResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		wkcjResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());

		Mockito.when(ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, new Object[] {}))
				.thenReturn(wkcjResponse);

	}

	private void mock_WKCJ_OK() {
		// MOCK WKCJ: non ritorna condizioni variate
		WKCJResponse wkcjResponse = new WKCJResponse();
		ArrayList<OutCNF> outCNFList = new ArrayList<OutCNF>();
		/*
		 * OutCNF outCNF = new OutCNF(); outCNF.setCodCnd("cndTest");
		 * outCNFList.add(outCNF);
		 */
		wkcjResponse.setOutCNFList(outCNFList);
		wkcjResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		wkcjResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());

		Mockito.when(ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, new Object[] {}))
				.thenReturn(wkcjResponse);

	}

	private void mock_PCUJ_OK() {

		// MOCK PCUJ
		PCUJResponse pcujResponse = new PCUJResponse();
		List<OutRIP> outRIPList = new ArrayList<OutRIP>();

		///////
		OutRIP outRIP = new OutRIP();
		outRIP.setCodFt("test");
		outRIP.setImportoFidoEur(10);
		outRIP.setImportoFido(10);

		OutTAS outTAS = new OutTAS();
		outTAS.setValParametro(12.5);
		outTAS.setPercParametro(5.0);
		outTAS.setValSpread(2.0);
		outTAS.setSegnoValSpread("+");
		outTAS.setTassoDebitore(1.0);
		outTAS.setCodParametro("00813");
		outRIP.setOutTas(outTAS);
		//////
		outRIPList.add(outRIP);

		pcujResponse.setOutRIPList(outRIPList);
		pcujResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		pcujResponse.setCodEsito("00");// no warning
		pcujResponse.setMsgEsito("---OK---");

		Mockito.when(
				ctgConnectorPCUJ.call(pcujRequest, requestTransformerPCUJ, responseTransformerPCUJ, new Object[] {}))
				.thenReturn(pcujResponse);

	}
	
	private void mock_PCUJ_WARNING(String esitoWarning) {

		// MOCK PCUJ
		PCUJResponse pcujResponse = new PCUJResponse();
		List<OutRIP> outRIPList = new ArrayList<OutRIP>();

		///////
		OutRIP outRIP = new OutRIP();
		outRIP.setCodFt("test");
		outRIP.setImportoFidoEur(10);
		outRIP.setImportoFido(10);

		OutTAS outTAS = new OutTAS();
		outTAS.setValParametro(12.5);
		outTAS.setPercParametro(5.0);
		outTAS.setValSpread(2.0);
		outTAS.setSegnoValSpread("+");
		outTAS.setTassoDebitore(1.0);
		outTAS.setCodParametro("00813");
		outRIP.setOutTas(outTAS);
		//////
		outRIPList.add(outRIP);

		pcujResponse.setOutRIPList(outRIPList);
		pcujResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0000").build());
		pcujResponse.setCodEsito(esitoWarning);//
		pcujResponse.setMsgEsito("---BS WARNING ---");

		Mockito.when(
				ctgConnectorPCUJ.call(pcujRequest, requestTransformerPCUJ, responseTransformerPCUJ, new Object[] {}))
				.thenReturn(pcujResponse);

	}

	private void mock_WKCJ_KO() {
		WKCJResponse wkcjResponse = new WKCJResponse();
		wkcjResponse.setOutEsi(
				OutEsi.builder().mdwEsiRetc("0012").mdwEsiAnom("-errore wkcj-").mdwEsiMsg("-errore wkcj-").build());
		wkcjResponse.setOutSeg(OutSeg.builder().livelloSegnalazione("").txtSegnalazione("").build());

		Mockito.when(ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, new Object[] {}))
				.thenReturn(wkcjResponse);

	}

	private void mock_PCUJ_KO() {
		PCUJResponse pcujResponse = new PCUJResponse();
		List<OutRIP> outRIPList = new ArrayList<OutRIP>();
		pcujResponse.setOutRIPList(outRIPList);
		pcujResponse.setOutEsi(OutEsi.builder().mdwEsiRetc("0012").mdwEsiAnom("").mdwEsiMsg("").build());
		pcujResponse.setOutSeg(OutSeg.builder().build());
		pcujResponse.setCodEsito("00");// no warning
		pcujResponse.setMsgEsito("---OK---");

		Mockito.when(
				ctgConnectorPCUJ.call(pcujRequest, requestTransformerPCUJ, responseTransformerPCUJ, new Object[] {}))
				.thenReturn(pcujResponse);

	}

	private IndicatoriCostoDTO mockIndicatoriCostoDTO(String richiesta) {
		IndicatoriCostoDTO dto = new IndicatoriCostoDTO();
		PraticaDTO pratica = new PraticaDTO();
		pratica.setCodPratica("");
		pratica.setCodPropostaComm("");
		pratica.setCodSuperPratica("0001161961");
		dto.setCodAppl(CodApplEnum.CARTE.toString());
		dto.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		dto.setClassificazione("test");
		dto.setPratica(pratica);
		EventoDTO evento = new EventoDTO();
		evento.setCodice("test");
		evento.setSubCodice("test");
		dto.setEvento(evento);
		dto.setPratica(pratica);
		dto.setRichiesta(richiesta);
		return dto;
	}

	private ISPWebservicesHeaderType buildMockHeader() {
		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("0").callerCompanyIDCode("01").callerProgramName(null).channelIDCode("0").codABI("01025")
				.codUnitaOperativa(null).customerID(null).isVirtualUser(null).language(null).serviceCompanyIDCode("01")
				.serviceID(null).userID("U015886").transactionId("0").timestamp("0").serviceVersion(null).build();
		return ispWebservicesHeaderType;
	}
	
	@Test
	public void testMock() {
		CJIndicatoriCostoController cj=new CJIndicatoriCostoController();
		cj.mockResponse();
	}
	
}
