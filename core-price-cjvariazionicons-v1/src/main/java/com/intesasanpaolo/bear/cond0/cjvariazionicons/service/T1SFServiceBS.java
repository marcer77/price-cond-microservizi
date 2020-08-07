package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorT1SF;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SFServiceBS extends BaseService {
	//private static final Logger logger = LoggerUtils.getLogger(T1SFServiceBS.class);

	@Autowired
	private CTGConnectorT1SF ctgConnectorT1SF;

	@Autowired
	private T1SFCtgRequestTrasformer requestTransformer;

	@Autowired
	private T1SFCtgResponseTansformer responseTransformer;

	public T1SFResponse callBS(T1SFRequest t1sfRequest) {
		
		T1SFResponse t1sfResponse = this.ctgConnectorT1SF.call(t1sfRequest, requestTransformer, responseTransformer,
				new Object());
		
		
		String[] parametriAggiuntivi=new String[0];
		CJErrorUtil.checkErrore(BSType.FL03S00, t1sfResponse.getOutEsi(),t1sfResponse.getOutSeg(),this::additionalCheckErrorFunction,parametriAggiuntivi);
		
		return t1sfResponse;
	}
	
	private boolean additionalCheckErrorFunction(String... st) {
		//String test= StringUtils.isNotEmpty(fl03Response.getCodErr())?fl03Response.getCodErr():"";
		//return !st[0].equalsIgnoreCase("0");
		return false;
	}

	
}
