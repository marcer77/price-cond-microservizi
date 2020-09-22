package com.intesasanpaolo.bear.bear_v3.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.bear_v3.command.ControlloTipoContoCommand;
import com.intesasanpaolo.bear.bear_v3.command.InquiryContoCndCommand;
import com.intesasanpaolo.bear.bear_v3.command.InquiryContoCndDettaglioCommand;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoResponse;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoRequest;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndDettaglioOutput;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndOutput;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndRequest;
import com.intesasanpaolo.bear.core.controller.StatelessController;


@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(value = "condizioniconto", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class RESTController extends StatelessController {   
	
	@Autowired
	private BeanFactory beanFactory;

	@PostMapping(value = "/controlloTipoConto")
	@ResponseBody
	public ControlloTipoContoResponse controlloTipoConto(@RequestBody ControlloTipoContoRequest request) throws Exception {

		ControlloTipoContoCommand command = beanFactory.getBean(ControlloTipoContoCommand.class, request);
		ControlloTipoContoResponse res = command.execute();
		return res;
	}

	@PostMapping(value = "/inquiryContoCnd")
	@ResponseBody
	public InquiryContoCndOutput inquiryContoCnd(@RequestBody InquiryContoCndRequest request) throws Exception {

		InquiryContoCndCommand command = beanFactory.getBean(InquiryContoCndCommand.class, request);
		InquiryContoCndOutput res = command.execute();
		return res;
	}
	
	@PostMapping(value = "/inquiry")
	@ResponseBody
	public InquiryContoCndDettaglioOutput inquiryContoCndDettaglio(@RequestBody InquiryContoCndRequest request) throws Exception {

		InquiryContoCndDettaglioCommand command = beanFactory.getBean(InquiryContoCndDettaglioCommand.class, request);
		InquiryContoCndDettaglioOutput res = command.execute();
		return res;
	}

}
