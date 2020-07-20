package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.intesasanpaolo.bear.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.ProposteCJPOSWSInviaPropostaV2Connector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoInviaPropostaV2Response;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2RequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2ResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

public class ProposteCJPOSWSInviaPropostaV2CommandTest extends BaseTest {

	private Logger log = Logger.getLogger(ProposteCJPOSWSInviaPropostaV2CommandTest.class);

	@Autowired
	private ProposteCJPOSWSInviaPropostaV2Command proposteCJPOSWSInviaPropostaV2Command;

	@MockBean
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2Connector proposteCJPOSWSInviaPropostaV2Connector;

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2RequestTransformer proposteCJPOSWSInviaPropostaV2RequestTransformer;

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2ResponseTransformer proposteCJPOSWSInviaPropostaV2ResponseTransformer;
	
	private ISPWebservicesHeaderType header;

	private InviaPropostaV2 inviaProposta;

	private EsitoOperazioneCJPOSV2 esitoOperazioneCJPOSV2;

	private EsitoInviaPropostaV2Response esitoInviaPropostaV2Response;

	@Before
	public void initMocks() throws Exception {
		
		header = ProposteCJPOSWSUtils._buildMockedHeader();

		inviaProposta = ProposteCJPOSWSUtils._buildMockInviaPropostaV2();

		esitoOperazioneCJPOSV2 = new EsitoOperazioneCJPOSV2();
		
		esitoOperazioneCJPOSV2.setEsitoCodice("OK");

		esitoInviaPropostaV2Response = new EsitoInviaPropostaV2Response();
		
		esitoInviaPropostaV2Response.setEsito(esitoOperazioneCJPOSV2);
		
	}
	
	@Test
	public void canExecuteTest() throws Exception {
		
		log.debug(" canExecute START ");

		proposteCJPOSWSInviaPropostaV2Command.setHeader(header);

		proposteCJPOSWSInviaPropostaV2Command.setInviaPropostaV2(inviaProposta);

		Mockito.when(proposteCJPOSWSService.inviaPropostaV2(inviaProposta, header)).thenReturn(esitoOperazioneCJPOSV2);

		Mockito.when(proposteCJPOSWSInviaPropostaV2Connector.call(inviaProposta,
				proposteCJPOSWSInviaPropostaV2RequestTransformer, proposteCJPOSWSInviaPropostaV2ResponseTransformer,
				header)).thenReturn(esitoInviaPropostaV2Response);

		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSInviaPropostaV2Command.execute();

		assertTrue("OK".equals(esito.getEsitoCodice()));
		
		log.debug(" canExecute END ");

	}

	@Test(expected = BearForbiddenException.class)
	public void cantExecuteTest() throws Exception {
		
		log.debug(" cantExecute START ");

		proposteCJPOSWSInviaPropostaV2Command.setHeader(null);

		proposteCJPOSWSInviaPropostaV2Command.setInviaPropostaV2(null);

		proposteCJPOSWSInviaPropostaV2Command.execute();
		
		log.debug(" cantExecute END ");

	}
}
