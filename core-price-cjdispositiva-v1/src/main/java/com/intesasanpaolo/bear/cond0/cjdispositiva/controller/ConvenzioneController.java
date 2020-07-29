package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ConvRiferimento;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.core.controller.CoreController;


import io.swagger.annotations.ApiOperation;

@RestController
@Validated 
@RequestMapping(value = "/convenzione")
public class ConvenzioneController extends CoreController {
       
	private static final Logger logger = LoggerUtils.getLogger(ConvenzioneController.class);
 
	@Autowired
	private CoreConvenzioneService coreConvenzioneService;

	@GetMapping(value="/recupero", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "recupero convenzioni")
	public ResponseEntity<?> recuperaConvenzioni(
			@RequestParam(value = "abi", required = true) String codAbi,
			@RequestParam(value = "codConvenzionePc", required = true) String codConvenzionePc, 
			@RequestParam(value = "dataRiferimento", required = true)@Valid @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Invalid Data richiest Elaborazione")  String dataRichiestaElaborazione
			) throws Exception {
		
	
		List<ConvRiferimento> response;
		try {
			 
			response = coreConvenzioneService.letturaRConvenzioneDiRifiremento(codAbi, codConvenzionePc, dataRichiestaElaborazione);

		} catch(Exception e) {
			logger.error("EndPoint convenzione error : ", e);
			throw e;
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
	@PostMapping(value="/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "recupero convenzioni")
	public ResponseEntity<?> update(
			@RequestParam(value = "abi", required = true) String codAbi,
			@RequestParam(value = "codConvenzionePc", required = true) String codConvenzionePc 
			) throws Exception {
		
	
		int i = 0;
		try {
			 
			i = coreConvenzioneService.updateRConvenzioneDiRifiremento(codAbi, codConvenzionePc);

		} catch(Exception e) {
			logger.error("EndPoint convenzione error : ", e);
			throw e;
		}
		return ResponseEntity.status(HttpStatus.OK).body(i);

	}

	@PostMapping(value="/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "recupero convenzioni")
	public ResponseEntity<?> insert(
			@RequestParam(value = "abi", required = true) String codAbi,
			@RequestParam(value = "codConvenzionePc", required = true) String codConvenzionePc 
			) throws Exception {
		
	
		int i = 0;
		try {
			 
			i = coreConvenzioneService.insertRConvenzioneDiRifiremento(codAbi, codConvenzionePc);

		} catch(Exception e) {
			logger.error("EndPoint convenzione error : ", e);
			throw e;
		}
		return ResponseEntity.status(HttpStatus.OK).body(i);

	}
}