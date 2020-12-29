package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.factory.RequisitiAdesioneFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitiAdesione;


@Service
public class RequisitiAdesioneService {
	
	private Logger log = Logger.getLogger(RequisitiAdesioneService.class);
	
	@Autowired
	private RequisitiAdesioneFactory requisitiAdesioneFactory;
	
	public RequisitiAdesione getRequisitiAdesione() {
		log.debug("getRequisitiAdesione START");
		
		RequisitiAdesione response = requisitiAdesioneFactory.createRequisitiAdesione();
		
		log.debug("getRequisitiAdesione END");				
		return response;
	}
	

}
