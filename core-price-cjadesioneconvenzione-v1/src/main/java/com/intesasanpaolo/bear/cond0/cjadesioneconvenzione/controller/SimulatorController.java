package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
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

	@PostMapping(value="/call-GetCovenantPerConvenzioni")
	public ResponseEntity<List<RespGetCovenantPerConvenzioneCovenantDaAttivare>> callGetCovenantPerConvenzioni(@RequestBody ReqGetCovenantPerConvenzione request){
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> response = convenzioniHostService.getCovenantPerConvenzione(request );

		return ResponseEntity.ok(response);


	}

	@GetMapping(value="/call-GetRequisitiAdesioneConvenzione")
	public ResponseEntity<RespGetRequisitiAdesioneConvenzione> callGetRequisitiAdesioneConvenzione(@RequestBody ReqGetRequisitiAdesioneConvenzione request){

//		RequisitiAdesioneConvenzione request = new RequisitiAdesioneConvenzione();
//
//		requisitiAdesioneConvenzioneDTO.setAbi("01025");
//
//		List codiciFiscali = Arrays.asList(new String[] {"CRLRERD44","PEORDERFF"});
//		requisitiAdesioneConvenzioneDTO.setCodiciFiscali(codiciFiscali);

		RespGetRequisitiAdesioneConvenzione response = convenzioniService.getRequisitiAdesioneConvenzione(request);

		return ResponseEntity.ok(response);


	}

}
