package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.RollbackStoreCovenantAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.StoreCovenantAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.RollbackStoreCovenantAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.RollbackStoreCovenantAdesioneConvenzioneResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.StoreCovenantAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.StoreCovenantAdesioneConvenzioneResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;

@Service
public class ConvenzioniHostService {
	
	@Autowired
	private StoreCovenantAdesioneConvenzioneConnector storeConnector;
	
	@Autowired
	private RollbackStoreCovenantAdesioneConvenzioneConnector rollbackConnector;
	
	@Autowired
	private StoreCovenantAdesioneConvenzioneResponseTransformer responseTransformer;
	@Autowired
	private StoreCovenantAdesioneConvenzioneRequestTransformer requestTrasformer;
	
	@Autowired
	private RollbackStoreCovenantAdesioneConvenzioneResponseTransformer rollbackResponseTransformer;
	@Autowired
	private RollbackStoreCovenantAdesioneConvenzioneRequestTransformer rollbackRequestTrasformer;
	
	public RespStoreCovenantAdesioneConvenzione storeCovenantAdesioneConvenzione(ReqStoreCovenantAdesioneConvenzione request) {
		
		RespStoreCovenantAdesioneConvenzione response =(RespStoreCovenantAdesioneConvenzione) storeConnector.call(request, requestTrasformer, responseTransformer, null);
		return response;
	}

	public RespRollbackStoreCovenantAdesioneConvenzione rollbackStoreCovenantAdesioneConvenzione(ReqRollbackStoreCovenantAdesioneConvenzione request) {
		
		RespRollbackStoreCovenantAdesioneConvenzione response =(RespRollbackStoreCovenantAdesioneConvenzione) rollbackConnector.call(request, rollbackRequestTrasformer, rollbackResponseTransformer, null);
		return response;
	}
}
