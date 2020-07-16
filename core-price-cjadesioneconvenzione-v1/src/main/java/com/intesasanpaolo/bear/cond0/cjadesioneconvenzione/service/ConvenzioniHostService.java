package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.GetCovenantPerConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetCovenantPerConvenzioneRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetCovenantPerConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.CovenantPerConvenzioniRequest;

@Service
public class ConvenzioniHostService {
	
	@Autowired
	private GetCovenantPerConvenzioneConnector<CovenantPerConvenzioniRequest,ResponseGetCovenantPerConvenzione,JAXBElement<GetCovenantPerConvenzione>,ResponseGetCovenantPerConvenzione> convenzioniHostServiceConnector;
	@Autowired
	private GetCovenantPerConvenzioneResponseTrasformer getCovenantPerConvenzioneResponseTrasformer;
	@Autowired
	private GetCovenantPerConvenzioneRequestTrasformer getCovenantPerConvenzioneRequestTrasformer;
	
	public ResponseGetCovenantPerConvenzione getCovenantPerConvenzione() {
		
		CovenantPerConvenzioniRequest request = new CovenantPerConvenzioniRequest();
		request.setAbi("01025");
		
		ResponseGetCovenantPerConvenzione response =convenzioniHostServiceConnector.call(request, getCovenantPerConvenzioneRequestTrasformer, getCovenantPerConvenzioneResponseTrasformer, null);
		return response;
	}

}
