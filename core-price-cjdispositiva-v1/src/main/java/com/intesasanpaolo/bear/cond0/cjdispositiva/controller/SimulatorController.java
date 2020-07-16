package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.core.controller.CoreController;

@RestController
@RequestMapping("cjdispositiva")
public class SimulatorController extends CoreController {
	
	@Autowired
	private ConvenzioniHostService convenzioniHostService;
	
	@GetMapping(value="/call-StoreCovenantAdesioneConvenzione")
	public ResponseEntity<ResponseStoreCovenantAdesioneConvenzione> callGetCovenantPerConvenzioni(){
		
		
		 ResponseStoreCovenantAdesioneConvenzione response = convenzioniHostService.storeCovenantAdesioneConvenzione();
		
		return ResponseEntity.ok(response);
		
		
	}
	

}
