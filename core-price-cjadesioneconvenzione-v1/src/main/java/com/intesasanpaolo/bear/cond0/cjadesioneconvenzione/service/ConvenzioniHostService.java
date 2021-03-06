package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.GetCovenantPerConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers.GetCovenantPerConvenzioneRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers.GetCovenantPerConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;

@Service
public class ConvenzioniHostService {
	
	@Autowired
	private GetCovenantPerConvenzioneConnector convenzioniHostServiceConnector;
	@Autowired
	private GetCovenantPerConvenzioneResponseTrasformer getCovenantPerConvenzioneResponseTrasformer;
	@Autowired
	private GetCovenantPerConvenzioneRequestTrasformer getCovenantPerConvenzioneRequestTrasformer;
	
	public List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovenantPerConvenzione(ReqGetCovenantPerConvenzione request) {	
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> response =(List<RespGetCovenantPerConvenzioneCovenantDaAttivare>) convenzioniHostServiceConnector.call(request, getCovenantPerConvenzioneRequestTrasformer, getCovenantPerConvenzioneResponseTrasformer, null);
		//TODO:GESTIONE ECCEZIONI APPLICATIVE  DEL WEBSERVICE
		//questo webservice non sembra ritornare codici di errore
		//if (true)
		//	throw CJWebServiceException.builder().webServiceName("getCovenantPerConvenzione").codiceErroreWebService("--cod_errore_ritornato dal WS --").descrErroreWebService("---descrizione errore ritornato dal WS").build();
		return response;
	}

}
