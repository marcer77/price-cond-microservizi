package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorWKCJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.WKCJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.WKCJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class WKCJServiceBS extends BaseService{
	private static final Logger logger = LoggerUtils.getLogger(WKCJServiceBS.class);	
	
	@Autowired
	private CTGConnectorWKCJ ctgConnectorWKCJ;
	
	
	@Autowired
	private WKCJCtgRequestTrasformer requestTransformer;

	@Autowired
	private WKCJCtgResponseTansformer responseTransformer;

	public WKCJResponse callBS(WKCJRequest wkcjRequest) throws Exception {	
		WKCJResponse wkcjResponse =WKCJResponse.builder().build();
		try {
			wkcjResponse =this.ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, null);				
		} catch (Exception e) {
			logger.error("Errore",e);
			//throw e;
			// TODO: handle exception
		}
		return wkcjResponse	;
		
		
	}

}
