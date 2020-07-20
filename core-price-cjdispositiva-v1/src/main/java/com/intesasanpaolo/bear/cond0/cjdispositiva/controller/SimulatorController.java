package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.core.controller.CoreController;

@RestController
@RequestMapping("cjdispositiva")
public class SimulatorController extends CoreController {
	
	@Autowired
	private ConvenzioniHostService convenzioniHostService;
	
	@PostMapping(value="/call-StoreCovenantAdesioneConvenzione")
	public ResponseEntity<RespStoreCovenantAdesioneConvenzione> callGetCovenantPerConvenzioni(@RequestBody ReqStoreCovenantAdesioneConvenzione request){
		
		
		 RespStoreCovenantAdesioneConvenzione response = convenzioniHostService.storeCovenantAdesioneConvenzione(request);
		
		return ResponseEntity.ok(response);
		
		
	}
	

}
