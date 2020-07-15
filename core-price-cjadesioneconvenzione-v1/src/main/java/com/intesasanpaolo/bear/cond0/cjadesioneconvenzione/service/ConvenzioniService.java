package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.ConvenzioniHostServiceConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.ConvenzioniServiceConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.CovenantPerConvenzioneRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.AdesioneRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.AdesioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetCovenantPerConvenzioneRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetCovenantPerConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetRequisitiAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetRequisitiAdesioneConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.ws.CovenantPerConvenzioniRequestDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.ws.RequisitiAdesioneConvenzioneDTO;

@Service
public class ConvenzioniService {
	
	@Autowired
	private ConvenzioniServiceConnector convenzioniServiceConnector;
	@Autowired
	private GetRequisitiAdesioneConvenzioneResponseTrasformer getRequisitiAdesioneConvenzioneResponseTrasformer;
	@Autowired
	private GetRequisitiAdesioneConvenzioneRequestTransformer getRequisitiAdesioneConvenzioneRequestTransformer;
	
	public GetRequisitiAdesioneConvenzioneResponse getRequisitiAdesioneConvenzione() {
		
		RequisitiAdesioneConvenzioneDTO requisitiAdesioneConvenzioneDTO = new RequisitiAdesioneConvenzioneDTO();
		
		requisitiAdesioneConvenzioneDTO.setAbi("01025");
		
		List codiciFiscali = Arrays.asList(new String[] {"CRLRERD44","PEORDERFF"});
		requisitiAdesioneConvenzioneDTO.setCodiciFiscali(codiciFiscali);
		
		GetRequisitiAdesioneConvenzioneResponse response = (GetRequisitiAdesioneConvenzioneResponse) convenzioniServiceConnector.call(requisitiAdesioneConvenzioneDTO, getRequisitiAdesioneConvenzioneRequestTransformer, getRequisitiAdesioneConvenzioneResponseTrasformer, null);
		return response;
	}

}
