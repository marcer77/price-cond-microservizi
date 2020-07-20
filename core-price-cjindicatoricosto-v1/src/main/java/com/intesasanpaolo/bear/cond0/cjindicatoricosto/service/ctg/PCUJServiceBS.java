package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class PCUJServiceBS extends BaseService{
	private static final Logger logger = LoggerUtils.getLogger(PCUJServiceBS.class);	
	
	/*@Autowired
	private CTGConnectorWKCJ ctgConnectorWKCJ;
	
	@Autowired
	private WKCJCtgRequestTrasformer requestTransformer;

	@Autowired
	private WKCJCtgResponseTansformer responseTransformer;
	*/
	public PCUJResponse callBS(PCUJRequest pcujRequest) throws Exception {	
		PCUJResponse pcujResponse =new PCUJResponse();
		return pcujResponse;
		/*
		try {
			wkcjResponse =this.ctgConnectorWKCJ.call(wkcjRequest, requestTransformer, responseTransformer, null);				
		} catch (Exception e) {
			logger.error("Errore",e);
			//throw e;
			// TODO: handle exception
		}
		return wkcjResponse	;
		*/
		
	}

}
