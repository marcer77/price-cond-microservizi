package com.intesasanpaolo.bear.cond0.cjdispositiva.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.CTGConnectorWKCJ;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.transformers.WKCJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.transformers.WKCJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJResponse;
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
		wkcjResponse =this.ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, null);				
		String[] parametriAggiuntivi=new String[0];
		CJErrorUtil.checkErrore(BSType.WKCJS00, wkcjResponse.getOutEsi(),wkcjResponse.getOutSeg(),this::additionalCheckErrorFunction,parametriAggiuntivi);
		
		return wkcjResponse	;
	}
	
	private boolean additionalCheckErrorFunction(String... st) {
		return false;
	}

	
}
