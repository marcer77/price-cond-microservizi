package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponse;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ClassEsito;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetRequisitiAdesioneConvenzioneResponseTrasformerTest extends JUnitUtils {

	private Logger log = Logger.getLogger(GetRequisitiAdesioneConvenzioneResponseTrasformerTest.class);

	private GetRequisitiAdesioneConvenzioneResponseTrasformer getRequisitiAdesioneConvenzioneResponseTrasformer;

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		getRequisitiAdesioneConvenzioneResponseTrasformer = new GetRequisitiAdesioneConvenzioneResponseTrasformer();

	}

	@Test
	public void testOK() {

		SoapConnectorResponse<GetRequisitiAdesioneConvenzioneResponse> soapConnectorResponse = new SoapConnectorResponse<GetRequisitiAdesioneConvenzioneResponse>();
		
		GetRequisitiAdesioneConvenzioneResponse response = new GetRequisitiAdesioneConvenzioneResponse();

		soapConnectorResponse.setResponse(response);
		
		getRequisitiAdesioneConvenzioneResponseTrasformer.transform(soapConnectorResponse);

	}
}
