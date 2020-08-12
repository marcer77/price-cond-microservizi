package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.GetRequisitiAdesioneConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers.GetRequisitiAdesioneConvenzioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers.GetRequisitiAdesioneConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception.CJWebServiceException;
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
		//gestione eccezioni applicative
		checkWSResult(response);
		return response;
	}
	
	/**
	 * 
	 * @param response
	 */
	private void checkWSResult(RespGetRequisitiAdesioneConvenzione response ) {
		boolean checkEsitoPositivo=response!=null&&response.getEsitoResultCode()!=null&&response.getEsitoResultCode().equalsIgnoreCase("OK");
		if (!checkEsitoPositivo){
			throw CJWebServiceException.builder().codiceErroreWebService(response.getEsitoResultCode()).descrErroreWebService(response.getEsitoErrorMessage()).build();
		}
	}

}
