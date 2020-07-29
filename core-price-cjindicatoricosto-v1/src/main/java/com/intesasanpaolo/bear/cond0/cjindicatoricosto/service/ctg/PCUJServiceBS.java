package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorPCUJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class PCUJServiceBS extends BaseService{
	private static final Logger logger = LoggerUtils.getLogger(PCUJServiceBS.class);	
	
	@Autowired
	private CTGConnectorPCUJ ctgConnectorPCUJ;
	
	@Autowired
	private PCUJCtgRequestTrasformer requestTransformer;

	@Autowired
	private PCUJCtgResponseTansformer responseTransformer;
	
	public PCUJResponse callBS(PCUJRequest pcujRequest) throws Exception {	
		PCUJResponse pcujResponse=new PCUJResponse();
		try {
			pcujResponse =this.ctgConnectorPCUJ.call(pcujRequest, requestTransformer, responseTransformer, null);				
		} catch (Exception e) {
			logger.error("Errore",e);
			//throw e;
			// TODO: handle exception
		}
		return pcujResponse	;
		
	}

}
