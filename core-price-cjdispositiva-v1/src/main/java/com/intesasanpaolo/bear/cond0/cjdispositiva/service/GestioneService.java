package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.GestioneRestConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.transformers.GestioneRequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.transformers.GestioneResponseTransformer;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class GestioneService extends BaseService {

	private Logger log = Logger.getLogger(GestioneService.class);

	@Autowired
	private GestioneRequestTransformer gestioneRequestTransformer;

	@Autowired
	private GestioneResponseTransformer gestioneResponseTransformer;

	@Autowired
	private GestioneRestConnector gestioneRestConnector;

	public NewAccountOutput gestione(NewAccountInput request, HashMap<String, String> headerParams) {
		log.info(" - gestione START");
		NewAccountOutput out = gestioneRestConnector.call(request, gestioneRequestTransformer,
				gestioneResponseTransformer, headerParams);
		log.info(" - gestione END");
		return out;
	}
}
