package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.GetRequisitiAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetRequisitiAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer.GetRequisitiAdesioneConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;

@Service
public class ConvenzioniService {
	
	@Autowired
	private GetRequisitiAdesioneConvenzioneConnector convenzioniServiceConnector;
	@Autowired
	private GetRequisitiAdesioneConvenzioneResponseTrasformer getRequisitiAdesioneConvenzioneResponseTrasformer;
	@Autowired
	private GetRequisitiAdesioneConvenzioneRequestTransformer getRequisitiAdesioneConvenzioneRequestTransformer;
	
	public RespGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzione(ReqGetRequisitiAdesioneConvenzione request) {
		
		RespGetRequisitiAdesioneConvenzione response = (RespGetRequisitiAdesioneConvenzione) convenzioniServiceConnector.call(request, getRequisitiAdesioneConvenzioneRequestTransformer, getRequisitiAdesioneConvenzioneResponseTrasformer, null);
		return response;
	}

}
