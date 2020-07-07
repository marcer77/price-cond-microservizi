package com.intesasanpaolo.bear.cond0.cjvariazionicons.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.command.StampaCommand;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.core.controller.StatelessController;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("cjvariazionicons")
public class CJVariazioniController extends StatelessController {

	@Autowired
	private BeanFactory beanFactory;

	@PostMapping(value = "/stampa", produces = "application/json")
	@ApiOperation(value = "Implementazione nuovo servizio per stampa addendum Bersani")
	public ResponseEntity<ResponseResource> stampa(@RequestBody @Valid InputStampaDTO inputStampaDTO) throws Exception {
		logger.info("start EndPoint stampa");
		ResponseResource calcoloRischioCambioResource = null;
		try {
			StampaCommand condizioneCommand = beanFactory.getBean(StampaCommand.class, inputStampaDTO);
			ResponseResource condizioneObj = condizioneCommand.execute();		
			
		
		} catch (Exception e) {
			 logger.error("EndPoint recuperaCalcoloRischioCambio error : ", e);
			 throw new Exception();
		}
		return ResponseEntity.status(HttpStatus.OK).body(calcoloRischioCambioResource);
				
	}

}
