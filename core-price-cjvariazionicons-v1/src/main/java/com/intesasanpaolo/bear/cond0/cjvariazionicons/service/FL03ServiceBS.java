package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class FL03ServiceBS extends BaseService{
	private static final Logger logger = LoggerUtils.getLogger(FL03ServiceBS.class);	
	
	@Autowired
	private CTGConnectorFL03 ctgConnectorFL03;
	
	public ResponseResource test(InputStampaDTO inputStampaDTO) throws Exception {
		
		ResponseResource responseResource= this.ctgConnectorFL03.call(inputStampaDTO);
		return responseResource;
		
	}
	
}
