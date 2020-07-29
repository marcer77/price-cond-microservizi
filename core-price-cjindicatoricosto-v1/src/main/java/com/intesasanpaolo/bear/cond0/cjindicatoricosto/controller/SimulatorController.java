package com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.SuperPraticaService;
import com.intesasanpaolo.bear.core.controller.CoreController;

@RestController
@RequestMapping("cjindicatoricosto")
public class SimulatorController extends CoreController {

	@Autowired
	private SuperPraticaService superPraticaService;



	@GetMapping(value="/pratiche")
	public ResponseEntity<List<String>> testDb2(@RequestParam String codAbi,@RequestParam String codSuperPratica){

		List<String> response = superPraticaService.recuperaPraticheBySuperPratica(codAbi, codSuperPratica);

		return ResponseEntity.ok(response);


	}

}
