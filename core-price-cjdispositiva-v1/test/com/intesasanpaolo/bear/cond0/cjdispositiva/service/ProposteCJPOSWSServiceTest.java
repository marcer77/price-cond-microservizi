package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.intesasanpaolo.bear.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.ProposteCJPOSWSInviaPropostaV2Connector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.ProposteCJPOSWSRevocaPropostaConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoInviaPropostaV2Response;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoRevocaPropostaCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoRevocaPropostaResponse;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2RequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2ResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSRevocaPropostaRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSRevocaPropostaResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

public class ProposteCJPOSWSServiceTest extends BaseTest {

	private Logger log = Logger.getLogger(ProposteCJPOSWSServiceTest.class);

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2Connector proposteCJPOSWSInviaPropostaV2Connector;

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2RequestTransformer proposteCJPOSWSInviaPropostaV2RequestTransformer;

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2ResponseTransformer proposteCJPOSWSInviaPropostaV2ResponseTransformer;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaRequestTransformer proposteCJPOSWSRevocaPropostaRequestTransformer;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaResponseTransformer proposteCJPOSWSRevocaPropostaResponseTransformer;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaConnector proposteCJPOSWSRevocaPropostaConnector;

	private ISPWebservicesHeaderType header;

	private RevocaProposta revocaProposta;

	private InviaPropostaV2 inviaProposta;
	
	private EsitoOperazioneCJPOSV2 esitoOperazioneCJPOSV2;

	private EsitoRevocaPropostaCJPOS esitoRevocaPropostaCJPOS;
	
	private EsitoInviaPropostaV2Response esitoInviaPropostaV2Response;
	
	private EsitoRevocaPropostaResponse esitoRevocaPropostaResponse;

	@Before
	public void initMocks() throws Exception {
		
		header = ProposteCJPOSWSUtils._buildMockedHeader();

		revocaProposta = ProposteCJPOSWSUtils._buildMockRevocaProposta();

		inviaProposta = ProposteCJPOSWSUtils._buildMockInviaPropostaV2();
		
		esitoOperazioneCJPOSV2 = new EsitoOperazioneCJPOSV2();

		esitoRevocaPropostaCJPOS = new EsitoRevocaPropostaCJPOS();
		
		esitoInviaPropostaV2Response = new EsitoInviaPropostaV2Response();
		
		esitoRevocaPropostaResponse = new EsitoRevocaPropostaResponse();
		
		esitoRevocaPropostaCJPOS.setEsitoCodice("OK");

		esitoRevocaPropostaResponse.setEsito(esitoRevocaPropostaCJPOS);
		
		esitoOperazioneCJPOSV2.setEsitoCodice("OK");

		esitoInviaPropostaV2Response.setEsito(esitoOperazioneCJPOSV2);
		
	}
	
	@Test
	public void inviaPropostaV2OKTest() throws Exception {

		Mockito.when(proposteCJPOSWSInviaPropostaV2Connector.call(inviaProposta,
				proposteCJPOSWSInviaPropostaV2RequestTransformer, proposteCJPOSWSInviaPropostaV2ResponseTransformer,
				header)).thenReturn(esitoInviaPropostaV2Response);

		esitoOperazioneCJPOSV2 = proposteCJPOSWSService.inviaPropostaV2(inviaProposta, header);

		assertTrue("OK".equals(esitoOperazioneCJPOSV2.getEsitoCodice()));

	}
	
	@Test
	public void inviaPropostaV2KOTest() throws Exception {

		Mockito.when(proposteCJPOSWSInviaPropostaV2Connector.call(inviaProposta,
				proposteCJPOSWSInviaPropostaV2RequestTransformer, proposteCJPOSWSInviaPropostaV2ResponseTransformer,
				header)).thenReturn(null);

		esitoOperazioneCJPOSV2 = proposteCJPOSWSService.inviaPropostaV2(inviaProposta, header);

		assertTrue("KO".equals(esitoOperazioneCJPOSV2.getEsitoCodice()));

	}

	@Test
	public void revocaInviaPropostaOKTest() throws Exception {
		
		log.debug(" revocaInviaPropostaOK START");

		Mockito.when(proposteCJPOSWSRevocaPropostaConnector.call(revocaProposta,
				proposteCJPOSWSRevocaPropostaRequestTransformer, proposteCJPOSWSRevocaPropostaResponseTransformer,
				header)).thenReturn(esitoRevocaPropostaResponse);

		esitoOperazioneCJPOSV2 = proposteCJPOSWSService.revocaProposta(revocaProposta, header);

		assertTrue("OK".equals(esitoOperazioneCJPOSV2.getEsitoCodice()));
		
		log.debug(" revocaInviaPropostaOK END");

	}
	
	@Test
	public void revocaInviaPropostaKOTest() throws Exception {
		
		log.debug(" revocaInviaPropostaKO START");

		Mockito.when(proposteCJPOSWSRevocaPropostaConnector.call(revocaProposta,
				proposteCJPOSWSRevocaPropostaRequestTransformer, proposteCJPOSWSRevocaPropostaResponseTransformer,
				header)).thenReturn(null);

		esitoOperazioneCJPOSV2 = proposteCJPOSWSService.revocaProposta(revocaProposta, header);

		assertTrue("KO".equals(esitoOperazioneCJPOSV2.getEsitoCodice()));

		log.debug(" revocaInviaPropostaKO END");
		
	}
}
