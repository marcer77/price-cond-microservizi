package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.GetRequisitiAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.AdesioneRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetRequisitiAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetRequisitiAdesioneConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitiAdesioneConvenzione;

@Service
public class ConvenzioniService {
	
	@Autowired
	private GetRequisitiAdesioneConvenzioneConnector<RequisitiAdesioneConvenzione,GetRequisitiAdesioneConvenzioneResponse,JAXBElement<AdesioneRequest>,GetRequisitiAdesioneConvenzioneResponse> convenzioniServiceConnector;
	@Autowired
	private GetRequisitiAdesioneConvenzioneResponseTrasformer getRequisitiAdesioneConvenzioneResponseTrasformer;
	@Autowired
	private GetRequisitiAdesioneConvenzioneRequestTransformer getRequisitiAdesioneConvenzioneRequestTransformer;
	
	public GetRequisitiAdesioneConvenzioneResponse getRequisitiAdesioneConvenzione() {
		
		RequisitiAdesioneConvenzione requisitiAdesioneConvenzioneDTO = new RequisitiAdesioneConvenzione();
		
		requisitiAdesioneConvenzioneDTO.setAbi("01025");
		
		List codiciFiscali = Arrays.asList(new String[] {"CRLRERD44","PEORDERFF"});
		requisitiAdesioneConvenzioneDTO.setCodiciFiscali(codiciFiscali);
		
		GetRequisitiAdesioneConvenzioneResponse response = convenzioniServiceConnector.call(requisitiAdesioneConvenzioneDTO, getRequisitiAdesioneConvenzioneRequestTransformer, getRequisitiAdesioneConvenzioneResponseTrasformer, null);
		return response;
	}

}
