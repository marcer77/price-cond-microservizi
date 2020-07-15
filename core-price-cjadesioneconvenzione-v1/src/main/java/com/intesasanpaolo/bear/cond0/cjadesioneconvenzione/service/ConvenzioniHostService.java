package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.ConvenzioniHostServiceConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.CovenantPerConvenzioneRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetCovenantPerConvenzioneRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetCovenantPerConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.ws.CovenantPerConvenzioniRequestDTO;

@Service
public class ConvenzioniHostService {
	
	@Autowired
	private ConvenzioniHostServiceConnector convenzioniHostServiceConnector;
	@Autowired
	private GetCovenantPerConvenzioneResponseTrasformer getCovenantPerConvenzioneResponseTrasformer;
	@Autowired
	private GetCovenantPerConvenzioneRequestTrasformer getCovenantPerConvenzioneRequestTrasformer;
	
	public ResponseGetCovenantPerConvenzione getCovenantPerConvenzione() {
		
		CovenantPerConvenzioniRequestDTO request = new CovenantPerConvenzioniRequestDTO();
		request.setAbi("01025");
		
		ResponseGetCovenantPerConvenzione response =(ResponseGetCovenantPerConvenzione) convenzioniHostServiceConnector.call(request, getCovenantPerConvenzioneRequestTrasformer, getCovenantPerConvenzioneResponseTrasformer, null);
		return response;
	}

}
