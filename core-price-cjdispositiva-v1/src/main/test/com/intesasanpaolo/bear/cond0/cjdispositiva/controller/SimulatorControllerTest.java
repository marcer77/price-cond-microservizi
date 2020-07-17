package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.ProposteCJPOSWSInviaPropostaV2Command;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.ProposteCJPOSWSRevocaPropostaCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

public class SimulatorControllerTest extends BaseTest {
	
	private Logger log = Logger.getLogger(SimulatorControllerTest.class);

	@MockBean
	private ProposteCJPOSWSInviaPropostaV2Command proposteCJPOSWSInviaPropostaV2Command;

	@MockBean
	private ProposteCJPOSWSRevocaPropostaCommand proposteCJPOSWSRevocaPropostaCommand;

	private EsitoOperazioneCJPOSV2 esito;

	private ISPWebservicesHeaderType header;

	@Before
	public void initMocks() throws Exception {

		esito = new EsitoOperazioneCJPOSV2();

		header = new ISPWebservicesHeaderType();

	}

	@Test
	public void wsProposteCJPOSinviaPropostaV2Test() throws Exception {
		
		log.debug(" wsProposteCJPOSinviaPropostaV2Test START ");

		String URI = "/simulator/wsProposteCJPOSinviaPropostaV2";

		Mockito.when(proposteCJPOSWSInviaPropostaV2Command.execute()).thenReturn(esito);

		mockMvc.perform(MockMvcRequestBuilders.post(URI).content(asJsonString(header)).contentType(MediaTypes.HAL_JSON))
				.andExpect(status().isOk());
		
		log.debug(" wsProposteCJPOSinviaPropostaV2Test END ");
	}

	@Test
	public void wsProposteCJPOSrevocaPropostaTest() throws Exception {
		
		log.debug(" wsProposteCJPOSrevocaPropostaTest START ");

		String URI = "/simulator/wsProposteCJPOSrevocaProposta";

		Mockito.when(proposteCJPOSWSRevocaPropostaCommand.execute()).thenReturn(esito);

		mockMvc.perform(MockMvcRequestBuilders.post(URI).content(asJsonString(header)).contentType(MediaTypes.HAL_JSON))
				.andExpect(status().isOk());
		
		log.debug(" wsProposteCJPOSrevocaPropostaTest END ");
	}

}