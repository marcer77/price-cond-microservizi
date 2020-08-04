package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorWKCJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.WKCJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.WKCJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception.BSException;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception.CJBaseException;
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

	public WKCJResponse callBS(WKCJRequest wkcjRequest) throws BSException {	
		WKCJResponse wkcjResponse =WKCJResponse.builder().build();
		//try {
			wkcjResponse =this.ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, null);				
			checkResult(wkcjResponse);
			
			//if (true)
			//	throw new CJBaseException();
			
			
		//} catch (Exception e) {
		//	logger.error("Errore",e);
			//throw e;
			// TODO: handle exception
		//	throw new BSException();
		//}
		return wkcjResponse	;
		
		
	}
	
	private void checkResult(WKCJResponse wkcjResponse) throws BSException {
		//TODO:CASO POSITIVO??
		if (StringUtils.isNotEmpty(wkcjResponse.getMdwEsiRetc())) {
			throw new BSException(wkcjResponse.getMdwEsiRetc(),wkcjResponse.getMdwEsiMsg(),wkcjResponse.getMdwEsiAnom(),wkcjResponse.getLivelloSegnalazione(),wkcjResponse.getTxtSegnalazione(),"WKCJ");		
		}
		
	}

}
