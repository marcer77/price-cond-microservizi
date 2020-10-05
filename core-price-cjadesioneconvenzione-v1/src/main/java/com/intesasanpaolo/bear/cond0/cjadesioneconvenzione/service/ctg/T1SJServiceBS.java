package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorT1SJ;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.T1SJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers.T1SJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SJServiceBS extends BaseService {
	private static final Logger logger = LoggerUtils.getLogger(T1SJServiceBS.class);	
	
	@Autowired
	private CTGConnectorT1SJ ctgConnectorT1SJ ;

	@Autowired
	private T1SJCtgRequestTrasformer requestTransformer;

	@Autowired
	private T1SJCtgResponseTansformer responseTransformer;

	public T1SJResponse callBS(T1SJRequest t1sjRequest){
		T1SJResponse t1sjResponse =this.ctgConnectorT1SJ.call(t1sjRequest, requestTransformer, responseTransformer,null);			

		String[] parametriAggiuntivi = new String[0];

		CJErrorUtil.checkErrore(BSType.T1SJS00, t1sjResponse.getOutEsi(), t1sjResponse.getOutSeg(), this::additionalCheckErrorFunction, parametriAggiuntivi);

		return t1sjResponse;
	}
	
	private boolean additionalCheckErrorFunction(String... st) {
		return false;
	}
}

