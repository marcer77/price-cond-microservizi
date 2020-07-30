package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.SuperPraticaService;
import com.intesasanpaolo.bear.core.controller.CoreController;

@RestController
@RequestMapping("cjadesioneconvenzione")
public class SimulatorController extends CoreController {

	@Autowired
	private ConvenzioniHostService convenzioniHostService;

	@Autowired
	private ConvenzioniService convenzioniService;
	
	@Autowired
	private SuperPraticaService superPraticaService;

	@GetMapping(value="/codConvenzioni")
	public ResponseEntity<List<String>> testDb2(@RequestParam String codAbi,@RequestParam String codSuperPratica, @RequestParam String nrEntita ){

		List<String> response = superPraticaService.recuperaCodConvenzione(codAbi, codSuperPratica,nrEntita);

		return ResponseEntity.ok(response);


	}

	@PostMapping(value="/call-GetCovenantPerConvenzioni")
	public ResponseEntity<List<RespGetCovenantPerConvenzioneCovenantDaAttivare>> callGetCovenantPerConvenzioni(@RequestBody ReqGetCovenantPerConvenzione request){
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> response = convenzioniHostService.getCovenantPerConvenzione(request );

		return ResponseEntity.ok(response);


	}

	@PostMapping(value="/call-GetRequisitiAdesioneConvenzione")
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
	
	@PostMapping(value="/insertDb2")
	public ResponseEntity<Integer> insertdb2(@RequestBody TB59R009 entity,@RequestParam String codAbi ) {

//		RequisitiAdesioneConvenzione request = new RequisitiAdesioneConvenzione();
//
//		requisitiAdesioneConvenzioneDTO.setAbi("01025");
//
//		List codiciFiscali = Arrays.asList(new String[] {"CRLRERD44","PEORDERFF"});
//		requisitiAdesioneConvenzioneDTO.setCodiciFiscali(codiciFiscali);

		superPraticaService.insertEntita(codAbi,entity);

		return ResponseEntity.ok(Integer.parseInt("1"));


	}
	
	@PostMapping(value="/deleteDb2")
	public ResponseEntity<Integer> deletedb2(@RequestParam String codAbi, @RequestParam String codSuperPratica,@RequestParam String numeroPratica,@RequestParam String idEntita) {

//		RequisitiAdesioneConvenzione request = new RequisitiAdesioneConvenzione();
//
//		requisitiAdesioneConvenzioneDTO.setAbi("01025");
//
//		List codiciFiscali = Arrays.asList(new String[] {"CRLRERD44","PEORDERFF"});
//		requisitiAdesioneConvenzioneDTO.setCodiciFiscali(codiciFiscali);

		superPraticaService.deleteEntita(codAbi, codSuperPratica, numeroPratica, idEntita);

		return ResponseEntity.ok(Integer.parseInt("1"));


	}

}
