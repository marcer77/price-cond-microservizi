package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJGenericBusinessApplication;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
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
		
		RespGetRequisitiAdesioneConvenzione response = null;
		try {
		
			response = (RespGetRequisitiAdesioneConvenzione) convenzioniServiceConnector.call(request, getRequisitiAdesioneConvenzioneRequestTransformer, getRequisitiAdesioneConvenzioneResponseTrasformer, null);
			//gestione eccezioni applicative
			
		}catch (Exception e) {
			throw new CJGenericBusinessApplication(CommonErrorCode.BS_SRV_EXCEPTION,"ConvenzioniService getRequisitiAdesioneConvenzione: "+e.getMessage(),e);
		}
//		checkWSResult(response,request.getCodiceConvenzione());
		return response;
	}
	
	/**
	 * 
	 * @param response
	 */
	private void checkWSResult(RespGetRequisitiAdesioneConvenzione response,String codConvenzione ) {
		boolean checkEsitoPositivo=response!=null&&response.getEsitoResultCode()!=null&&response.getEsitoResultCode().equalsIgnoreCase("OK");
		if (!checkEsitoPositivo){
			throw CJWebServiceException.builder().webServiceName("ConvenzioniService, Codice Convenzione:" + codConvenzione).codiceErroreWebService(response!=null? response.getEsitoResultCode():"").descrErroreWebService(response!=null?response.getEsitoErrorMessage():"").build();
		}
	}

}
