package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.intesasanpaolo.bear.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.ProposteCJPOSWSRevocaPropostaConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoRevocaPropostaCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoRevocaPropostaResponse;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSRevocaPropostaRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSRevocaPropostaResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

public class ProposteCJPOSWSRevocaPropostaCommandTest extends BaseTest {

	private Logger log = Logger.getLogger(ProposteCJPOSWSRevocaPropostaCommandTest.class);

	@Autowired
	private ProposteCJPOSWSRevocaPropostaCommand proposteCJPOSWSRevocaPropostaCommand;

	@MockBean
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaConnector proposteCJPOSWSRevocaPropostaConnector;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaRequestTransformer proposteCJPOSWSRevocaPropostaRequestTransformer;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaResponseTransformer proposteCJPOSWSRevocaPropostaResponseTransformer;

	private ISPWebservicesHeaderType header;

	private RevocaProposta revocaProposta;

	private EsitoOperazioneCJPOSV2 esitoOperazioneCJPOSV2;

	private EsitoRevocaPropostaResponse esitoRevocaPropostaResponse;

	private EsitoRevocaPropostaCJPOS esitoRevocaPropostaCJPOS;

	@Before
	public void initMocks() throws Exception {

		header = ProposteCJPOSWSUtils._buildMockedHeader();

		revocaProposta = ProposteCJPOSWSUtils._buildMockRevocaProposta();

		esitoOperazioneCJPOSV2 = new EsitoOperazioneCJPOSV2();

		esitoOperazioneCJPOSV2.setEsitoCodice("OK");

		esitoRevocaPropostaCJPOS = new EsitoRevocaPropostaCJPOS();

		esitoRevocaPropostaCJPOS.setCodiceProposta("OK");

		esitoRevocaPropostaResponse = new EsitoRevocaPropostaResponse();

		esitoRevocaPropostaResponse.setEsito(esitoRevocaPropostaCJPOS);

	}

	@Test
	public void canExecuteTest() throws Exception {

		log.debug(" canExecute START ");

		proposteCJPOSWSRevocaPropostaCommand.setHeader(header);

		proposteCJPOSWSRevocaPropostaCommand.setRevocaProposta(revocaProposta);

		Mockito.when(proposteCJPOSWSService.revocaProposta(revocaProposta, header)).thenReturn(esitoOperazioneCJPOSV2);

		Mockito.when(proposteCJPOSWSRevocaPropostaConnector.call(revocaProposta,
				proposteCJPOSWSRevocaPropostaRequestTransformer, proposteCJPOSWSRevocaPropostaResponseTransformer,
				header)).thenReturn(esitoRevocaPropostaResponse);

		EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSRevocaPropostaCommand.execute();

		assertTrue("OK".equals(esito.getEsitoCodice()));

		log.debug(" canExecute END ");

	}

	@Test(expected = BearForbiddenException.class)
	public void cantExecuteTest() throws Exception {

		log.debug(" cantExecute START ");

		proposteCJPOSWSRevocaPropostaCommand.setHeader(null);

		proposteCJPOSWSRevocaPropostaCommand.setRevocaProposta(null);

		proposteCJPOSWSRevocaPropostaCommand.execute();

		log.debug(" cantExecute END ");

	}
}
