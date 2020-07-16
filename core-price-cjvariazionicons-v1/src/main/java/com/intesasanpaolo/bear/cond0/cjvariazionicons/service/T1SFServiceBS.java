package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorT1SF;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SFServiceBS extends BaseService {
	private static final Logger logger = LoggerUtils.getLogger(T1SFServiceBS.class);	
	
	@Autowired
	private CTGConnectorT1SF ctgConnectorT1SF;

	@Autowired
	private T1SFCtgRequestTrasformer requestTransformer;

	@Autowired
	private T1SFCtgResponseTansformer responseTransformer;

	public T1SFResponse callBS(T1SFRequest t1sfRequest) throws Exception {
		T1SFResponse t1sfResponse =null;
		try{
			t1sfResponse = this.ctgConnectorT1SF.call(t1sfRequest, requestTransformer, responseTransformer,null);			
		}catch (Exception e) {
			logger.error("Errore-",e);
			//TODO:GESTIRE L'ERRORE
		}
		return t1sfResponse;
	}
}
