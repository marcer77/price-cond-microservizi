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
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseAdesioneDettaglio;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseBenefici;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseBeneficioValoreParametrato;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ArrayOfAdesioneResponseAdesioneDettaglio;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ArrayOfAdesioneResponseBenefici;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ArrayOfFasce;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ClassEsito;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ConfigurazioneFasce;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ObjectFactory;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ResponseLog;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.Fasce;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetRequisitiAdesioneConvenzioneResponseTrasformerTest extends JUnitUtils {

	private Logger log = Logger.getLogger(GetRequisitiAdesioneConvenzioneResponseTrasformerTest.class);

	private GetRequisitiAdesioneConvenzioneResponseTrasformer getRequisitiAdesioneConvenzioneResponseTrasformer;

	private ObjectFactory objectFactory = new ObjectFactory();
	
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

		AdesioneResponse ade = new AdesioneResponse();
		
		//
		
		ClassEsito esito = objectFactory.createClassEsito();

		esito.setResultCode(objectFactory.createClassEsitoResultCode("OK"));
		
		ade.setEsito(objectFactory.createClassEsito(esito));
		
		//
		
		ResponseLog log = objectFactory.createResponseLog();
		
		log.setErrorDescription(objectFactory.createResponseLogErrorDescription("test"));
		
		ade.setResponseLog(objectFactory.createResponseLog(log));
		
		//
		ArrayOfAdesioneResponseBenefici benefici = objectFactory.createArrayOfAdesioneResponseBenefici();
		
		AdesioneResponseBenefici ben = new AdesioneResponseBenefici();
		
		AdesioneResponseBeneficioValoreParametrato adeParam = objectFactory.createAdesioneResponseBeneficioValoreParametrato();
		
		adeParam.setParametroCodice1(objectFactory.createValoreParametratoCodice1("1"));
		
		ben.setBeneficioValoreParametrato(objectFactory.createAdesioneResponseBeneficioValoreParametrato(adeParam));
		
		ConfigurazioneFasce fasce = objectFactory.createConfigurazioneFasce();
		
		fasce.setCodiceFasciaIndicatoreBeneficiIn(objectFactory.createConfigurazioneFasceCodiceFasciaIndicatoreBeneficiIn(""));
		fasce.setCodificaIndicatore(objectFactory.createConfigurazioneFasceCodificaIndicatore(""));
		fasce.setDisabilitaMonitoraggio(objectFactory.createConfigurazioneFasceDisabilitaMonitoraggio(""));
		ArrayOfFasce listaFasce = objectFactory.createArrayOfFasce();
		listaFasce.getFasce().add(new Fasce());
		fasce.setListaFasce(objectFactory.createArrayOfFasce(listaFasce));
		
		ben.setConfigurazioneFasceApprovato(objectFactory.createConfigurazioneFasce(fasce));
		
		benefici.getAdesioneResponseBenefici().add(ben);
		
		JAXBElement<ArrayOfAdesioneResponseBenefici> tabellaBenefici = objectFactory.createArrayOfAdesioneResponseBenefici(benefici);
		
		ade.setTabellaBenefici(tabellaBenefici);
		
//		.getValue().getCodiceFasciaIndicatoreBeneficiIn().getValue()
//		.getValue().getCodificaIndicatore().getValue(),
//		.getValue().getCodificaIndicatoreSottorequisito(),
//		.getValue().getDisabilitaMonitoraggio().getValue(),
//		.getValue().getListaFasce().getValue(),
		ArrayOfAdesioneResponseAdesioneDettaglio adeDett = objectFactory.createArrayOfAdesioneResponseAdesioneDettaglio();

		AdesioneResponseAdesioneDettaglio elem = new AdesioneResponseAdesioneDettaglio();
		
		adeDett.getAdesioneResponseAdesioneDettaglio().add(elem);
		
		ade.setTabellaRequisiti(objectFactory.createAdesioneResponseTabellaRequisiti(adeDett));
		
		response.setGetRequisitiAdesioneConvenzioneResult(objectFactory.createAdesioneResponse(ade));
		
		soapConnectorResponse.setResponse(response);
		
		getRequisitiAdesioneConvenzioneResponseTrasformer.transform(soapConnectorResponse);

	}
}
