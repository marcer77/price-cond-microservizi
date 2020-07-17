package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.StoreCovenantAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.StoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.StoreCovenantAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformer.StoreCovenantAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformer.StoreCovenantAdesioneConvenzioneResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.StoreCovenantAdesioneConvenzioneRequest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.StoreCovenantAdesioneConvenzioneResult;

@Service
public class ConvenzioniHostService {
	
	@Autowired
	private StoreCovenantAdesioneConvenzioneConnector connector;
	@Autowired
	private StoreCovenantAdesioneConvenzioneResponseTransformer responseTransformer;
	@Autowired
	private StoreCovenantAdesioneConvenzioneRequestTransformer requestTrasformer;
	
	public StoreCovenantAdesioneConvenzioneResult storeCovenantAdesioneConvenzione() {
		
		StoreCovenantAdesioneConvenzioneRequest request = StoreCovenantAdesioneConvenzioneRequest.builder().abi("01025").build();
		
		
		StoreCovenantAdesioneConvenzioneResult response =(StoreCovenantAdesioneConvenzioneResult) connector.call(request, requestTrasformer, responseTransformer, null);
		return response;
	}

}
