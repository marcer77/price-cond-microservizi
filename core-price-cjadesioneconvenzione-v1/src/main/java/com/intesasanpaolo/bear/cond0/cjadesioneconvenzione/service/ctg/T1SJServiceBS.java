package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public T1SJResponse callBS(T1SJRequest t1sjRequest) throws Exception {
		T1SJResponse t1sjResponse =null;
		try{
			t1sjResponse = this.ctgConnectorT1SJ.call(t1sjRequest, requestTransformer, responseTransformer,null);			
		}catch (Exception e) {
			logger.error("Errore-",e);
			//throw e;
			//TODO:GESTIRE L'ERRORE
		}
		return t1sjResponse;
	}
}
