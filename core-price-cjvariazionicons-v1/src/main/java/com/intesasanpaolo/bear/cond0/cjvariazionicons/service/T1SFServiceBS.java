package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorT1SF;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SFServiceBS extends BaseService{

	@Autowired
	private CTGConnectorT1SF ctgConnectorT1SF;
	
	public ResponseResource test(InputStampaDTO inputStampaDTO) throws Exception {
		
		ResponseResource responseResource= this.ctgConnectorT1SF.call(inputStampaDTO);
		return responseResource;
		
	}
	
}
