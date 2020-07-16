package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class FL03ServiceBS extends BaseService{
	private static final Logger logger = LoggerUtils.getLogger(FL03ServiceBS.class);	
	
	@Autowired
	private CTGConnectorFL03 ctgConnectorFL03;
	
	
	@Autowired
	private FL03CtgRequestTrasformer requestTransformer;

	@Autowired
	private FL03CtgResponseTansformer responseTransformer;

	public FL03Response callBS(FL03Request fl03Request) throws Exception {	
		FL03Response fl03Response =null;
		try {
			fl03Response =this.ctgConnectorFL03.call(fl03Request, requestTransformer, responseTransformer, null);				
		} catch (Exception e) {
			logger.error("Errore",e);
			//throw e;
			// TODO: handle exception
		}
		return fl03Response;
		
		
	}
	
}
