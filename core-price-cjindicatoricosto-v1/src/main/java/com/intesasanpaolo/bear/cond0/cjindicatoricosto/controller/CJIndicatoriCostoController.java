package com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.assembler.IndicatoriCostoResourceAssembler;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.command.IndicatoriCostoCommand;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCosto;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.AffidamentoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.CondizioneResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.ParametriResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.PraticaResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.RapportoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.TanResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg.PCUJServiceBS;
import com.intesasanpaolo.bear.core.controller.CoreController;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("cjindicatoricosto")
public class CJIndicatoriCostoController extends CoreController {

	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private PCUJServiceBS testService;

	@Autowired
	private IndicatoriCostoResourceAssembler indicatoriCostoResourceAssembler;

	@PostMapping(value = "/calcolo", produces = "application/json")
	@ApiOperation(value = "Implementazione nuovo servizio per stampa addendum Bersani")
	public ResponseEntity<IndicatoriCostoResource> calcolo(@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true) String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = true) String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false) String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true) String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true) String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true) String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false) String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = true) String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = true) String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true) String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true) String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true) String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false) String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true) String channelIDCode,
			@Valid @RequestBody IndicatoriCostoDTO dto) throws Exception {

		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType().applicationID(applicationID)
				.callerCompanyIDCode(callerCompanyIDCode).callerProgramName(callerProgramName).channelIDCode(channelIDCode).codABI(codABI)
				.codUnitaOperativa(codUnitaOperativa).customerID(customerID).isVirtualUser(isVirtualUser).language(language)
				.serviceCompanyIDCode(serviceCompanyIDCode).serviceID(serviceID).userID(userID).transactionId(transactionId).timestamp(timestamp)
				.serviceVersion(serviceVersion).build();

		
		//String x=testService.getDescrizioneCondizione("012345678");
		//System.out.println(">>>>>>>>>>>>>>>>>><"+x);
		
		IndicatoriCostoCommand cmd = beanFactory.getBean(IndicatoriCostoCommand.class, dto, ispWebservicesHeaderType);
		IndicatoriCosto indicatoriCosto = cmd.execute();

		IndicatoriCostoResource resource = indicatoriCostoResourceAssembler.toResource(indicatoriCosto);

		// mock response
//			resource=this.mockResponse();

		return ResponseEntity.status(HttpStatus.OK).body(resource);

	}

	protected IndicatoriCostoResource mockResponse() {
		IndicatoriCostoResource resource = new IndicatoriCostoResource();
		// mock response
		resource.setEsito(new EsitoResource());
		resource.getEsito().setCodErrore("00");
		resource.getEsito().setDescErrore("");
		resource.setPratica(new ArrayList<PraticaResource>());
		resource.getPratica().add(mockPraticaResource("1", "00001", "00002", "ft1", "ft2"));
		resource.getPratica().add(mockPraticaResource("2", "00003", "00004", "ft1", "ft2"));
		return resource;
	}

	protected PraticaResource mockPraticaResource(String codPratica,String codiceCondizione1,String codiceCondizione2,String formatecnica1,String formatecnica2) {
		PraticaResource praticaResource=new PraticaResource();
		praticaResource.setCodPratica(codPratica);
		praticaResource.setCondizioni(new ArrayList<CondizioneResource>());
		praticaResource.getCondizioni().add(new CondizioneResource(codiceCondizione1));
		praticaResource.getCondizioni().add(new CondizioneResource(codiceCondizione2));
		
		//affidamenti
		praticaResource.setAffidamenti(new ArrayList<AffidamentoResource>());
		
		//primo affidamento
		AffidamentoResource affidamentoResource=new AffidamentoResource();
		affidamentoResource.setFormaTecnica(formatecnica1);
		affidamentoResource.setImporto("100100000");
		affidamentoResource.setScadenza("31.07.2020");
		affidamentoResource.setTipoFTecnica("T_FT_1");
		affidamentoResource.setDescFTecnica("DESC_TF_1");
		affidamentoResource.setDivisa("EUR");
		affidamentoResource.setImportoEUR("100020009");
		
		affidamentoResource.setIndicatori(new IndicatoriResource());
		affidamentoResource.getIndicatori().setCdf("001.23421");
		affidamentoResource.getIndicatori().setTaeg("011.91567");
		affidamentoResource.getIndicatori().setTeg("018.21981");
		
		affidamentoResource.getIndicatori().setTan(new TanResource());
		affidamentoResource.getIndicatori().getTan().setFlUsura("S");
		affidamentoResource.getIndicatori().getTan().setValore("012.89786");
		affidamentoResource.getIndicatori().getTan().setParametri(new ParametriResource());
		affidamentoResource.getIndicatori().getTan().getParametri().setPercApplic("005.50123");
		affidamentoResource.getIndicatori().getTan().getParametri().setDescIndice("-TAN-");
		affidamentoResource.getIndicatori().getTan().getParametri().setSegnoSpread("+");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreIndice("+111.12221");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreSpread("17.81234");
		
		affidamentoResource.setRapporto(new RapportoResource());
		affidamentoResource.getRapporto().setCategoria("1000");
		affidamentoResource.getRapporto().setFiliale("00700");
		affidamentoResource.getRapporto().setNumero("65676767");
		
		
		praticaResource.getAffidamenti().add(affidamentoResource);
		
		//secondo affidamento
		affidamentoResource=new AffidamentoResource();
		affidamentoResource.setFormaTecnica(formatecnica2);
		affidamentoResource.setImporto("100100");
		affidamentoResource.setScadenza("31.07.2020");
		affidamentoResource.setTipoFTecnica("T_FT_2");
		affidamentoResource.setDescFTecnica("DESC_TF_2");
		affidamentoResource.setDivisa("EUR");
		affidamentoResource.setImportoEUR("100020001");
		affidamentoResource.setIndicatori(new IndicatoriResource());
		affidamentoResource.getIndicatori().setCdf("003.56785");
		affidamentoResource.getIndicatori().setTaeg("010.91997");
		affidamentoResource.getIndicatori().setTeg("010.21981");
		
		affidamentoResource.getIndicatori().setTan(new TanResource());
		affidamentoResource.getIndicatori().getTan().setFlUsura("S");
		affidamentoResource.getIndicatori().getTan().setValore("013.89786");
		affidamentoResource.getIndicatori().getTan().setParametri(new ParametriResource());
		affidamentoResource.getIndicatori().getTan().getParametri().setPercApplic("002.50123");
		affidamentoResource.getIndicatori().getTan().getParametri().setDescIndice("-TAN-");
		affidamentoResource.getIndicatori().getTan().getParametri().setSegnoSpread("+");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreIndice("+021.12221");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreSpread("17.11234");
		
		
		affidamentoResource.setRapporto(new RapportoResource());
		affidamentoResource.getRapporto().setCategoria("1000");
		affidamentoResource.getRapporto().setFiliale("00700");
		affidamentoResource.getRapporto().setNumero("65676767");
		
		praticaResource.getAffidamenti().add(affidamentoResource);
		
		return praticaResource;
		
	}

}
