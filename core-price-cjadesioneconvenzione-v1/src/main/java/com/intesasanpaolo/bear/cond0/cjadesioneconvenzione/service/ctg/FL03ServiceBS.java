package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
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

	public FL03Response callBS(FL03Request fl03Request) {
		FL03Response fl03Response = this.ctgConnectorFL03.call(fl03Request, requestTransformer, responseTransformer,new Object());
		String[] parametriAggiuntivi=new String[0];
		CJErrorUtil.checkErrore(BSType.FL03S00, fl03Response.getOutEsi(),fl03Response.getOutSeg(),this::additionalCheckErrorFunction,parametriAggiuntivi);
		return fl03Response;
	}

	private boolean additionalCheckErrorFunction(String... st) {
		//String test= StringUtils.isNotEmpty(fl03Response.getCodErr())?fl03Response.getCodErr():"";
		//return !st[0].equalsIgnoreCase("0");
		return false;
	}
}
