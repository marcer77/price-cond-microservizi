package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.CTGConnectorT1SJ;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.ResponseResource;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SJServiceBS extends BaseService{
	private static final Logger logger = LoggerUtils.getLogger(T1SJServiceBS.class);	
	
	@Autowired
	private CTGConnectorT1SJ ctgConnectorT1SJ;
	
	public ResponseResource test(InputStampaDTO inputStampaDTO) throws Exception {
		
		ResponseResource responseResource= this.ctgConnectorT1SJ.call(inputStampaDTO);
		return responseResource;
		
	}
	
}
