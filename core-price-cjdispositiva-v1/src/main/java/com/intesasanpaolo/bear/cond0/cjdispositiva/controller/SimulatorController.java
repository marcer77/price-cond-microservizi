package com.intesasanpaolo.bear.cond0.cjdispositiva.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaInserimentoCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaTestCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaAnnulloCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ServiceUtil;
import com.intesasanpaolo.bear.core.controller.CoreController;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RestController
@RequestMapping("cjdispositiva")
@Validated
public class SimulatorController extends CoreController {

	private Logger log = Logger.getLogger(SimulatorController.class);

	@Autowired
	private BeanFactory beanFactory;

	@GetMapping(value = "/testRollback", produces = "application/json")
	public ResponseEntity<String> test() throws Exception
			 {
		log.info(" - testRollback START: ");
 

		
		CJDispositivaTestCommand cmd = beanFactory
				.getBean(CJDispositivaTestCommand.class);

		String esito = cmd.execute();
		log.info(" - inviaPropostaV2 END: esito {" + esito.toString() + "}");
		return ResponseEntity.ok(esito);
	}

}
