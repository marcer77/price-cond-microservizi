package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.AdesioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.ResponseResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniService;
import com.intesasanpaolo.bear.core.controller.CoreController;

@RestController
@RequestMapping("cjadesioneconvenzione")
public class SimulatorController extends CoreController {
	
	@Autowired
	private ConvenzioniHostService convenzioniHostService;
	
	@Autowired
	private ConvenzioniService convenzioniService;
	
	@GetMapping(value="/call-GetCovenantPerConvenzioni")
	public ResponseEntity<ResponseGetCovenantPerConvenzione> callGetCovenantPerConvenzioni(){
		
		
		ResponseGetCovenantPerConvenzione response = convenzioniHostService.getCovenantPerConvenzione();
		
		return ResponseEntity.ok(response);
		
		
	}
	
	@GetMapping(value="/call-GetRequisitiAdesioneConvenzione")
	public ResponseEntity<GetRequisitiAdesioneConvenzioneResponse> callGetRequisitiAdesioneConvenzione(){
		
		GetRequisitiAdesioneConvenzioneResponse response = convenzioniService.getRequisitiAdesioneConvenzione();
		
		return ResponseEntity.ok(response);
		
		
	}

}
