package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.StoreCovenantAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.StoreCovenantAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.StoreCovenantAdesioneConvenzioneResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;

@Service
public class ConvenzioniHostService {
	
	@Autowired
	private StoreCovenantAdesioneConvenzioneConnector connector;
	@Autowired
	private StoreCovenantAdesioneConvenzioneResponseTransformer responseTransformer;
	@Autowired
	private StoreCovenantAdesioneConvenzioneRequestTransformer requestTrasformer;
	
	public RespStoreCovenantAdesioneConvenzione storeCovenantAdesioneConvenzione(ReqStoreCovenantAdesioneConvenzione request) {
		
		RespStoreCovenantAdesioneConvenzione response =(RespStoreCovenantAdesioneConvenzione) connector.call(request, requestTrasformer, responseTransformer, null);
		return response;
	}

}
