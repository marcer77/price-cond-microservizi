package com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.AffidamentoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.CondizioneResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.ParametriResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.PraticaResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.TanResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.utils.HeaderAttribute;
import com.intesasanpaolo.bear.core.controller.CoreController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("cjindicatoricosto")
public class CJIndicatoriCostoController extends CoreController {

	@PostMapping(value = "/calcolo", produces = "application/json")
	@ApiOperation(value = "Implementazione nuovo servizio per stampa addendum Bersani")
	public ResponseEntity<IndicatoriCostoResource> calcolo(
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_ABI, required = true) String codABI,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_COD_UNITA_OPERATIVA, required = false) String codUnitaOperativa,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID, required = false) String customerID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE, required = true) String callerCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE, required = true) String serviceCompanyIDCode,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID, required = true) String userID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER, required = false) String isVirtualUser,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_LANGUAGE, required = false) String language,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_ID, required = false) String serviceID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_SERVICE_VERSION, required = false) String serviceVersion,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TIMESTAMP, required = true) String timestamp,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_TRANCACTION_ID, required = true) String transactionId,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_APPLICATION_ID, required = true) String applicationID,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CALLER_PGM_NAME, required = false) String callerProgramName,
			@RequestHeader(value = HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE, required = true) String channelIDCode,
			@RequestBody IndicatoriCostoDTO dto)  {

		IndicatoriCostoResource resource = new IndicatoriCostoResource();

		logger.info(HeaderAttribute.ISP_HEADER_APPLICATION_ID);
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE);
		logger.info(HeaderAttribute.ISP_HEADER_COD_ABI);
		logger.info(HeaderAttribute.ISP_HEADER_LANGUAGE);
		logger.info(HeaderAttribute.ISP_HEADER_IS_VIRTUAL_USER);
		logger.info(HeaderAttribute.ISP_HEADER_TRANCACTION_ID);
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_CUSTOMER_ID);
		logger.info(HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID);
		logger.info(HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE);

		//mock response
		resource.setEsito(new EsitoResource());
		resource.getEsito().setCodErrore("00");
		resource.getEsito().setDescErrore("");
		
		resource.setPratica(new ArrayList<PraticaResource>());
		resource.getPratica().add(mockPraticaResource("1012347865123","00001","00002","ft1","ft2"));
		resource.getPratica().add(mockPraticaResource("2012347865119","00003","00004","ft1","ft2"));
		
		return ResponseEntity.status(HttpStatus.OK).body(resource);

	}
	
	
	private PraticaResource mockPraticaResource(String codPratica,String codiceCondizione1,String codiceCondizione2,String formatecnica1,String formatecnica2) {
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
		affidamentoResource.setIndicatori(new IndicatoriResource());
		affidamentoResource.getIndicatori().setCdf("0000012.21");
		affidamentoResource.getIndicatori().setTaeg("011.91567");
		affidamentoResource.getIndicatori().setTeg("018.21981");
		
		affidamentoResource.getIndicatori().setTan(new TanResource());
		affidamentoResource.getIndicatori().getTan().setFlUsura("S");
		affidamentoResource.getIndicatori().getTan().setValore("012.89786");
		affidamentoResource.getIndicatori().getTan().setParametri(new ParametriResource());
		affidamentoResource.getIndicatori().getTan().getParametri().setPercApplic("005.50123");
		affidamentoResource.getIndicatori().getTan().getParametri().setDescIndice("-TAN-");
		affidamentoResource.getIndicatori().getTan().getParametri().setSegnoSpread("+");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreIndice("111.12221");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreSpread("17.81234");
		
		praticaResource.getAffidamenti().add(affidamentoResource);
		
		//secondo affidamento
		affidamentoResource=new AffidamentoResource();
		affidamentoResource.setFormaTecnica(formatecnica2);
		affidamentoResource.setImporto("100100");
		affidamentoResource.setScadenza("31.07.2020");
		affidamentoResource.setTipoFTecnica("T_FT_2");
		affidamentoResource.setIndicatori(new IndicatoriResource());
		affidamentoResource.getIndicatori().setCdf("0000010.21");
		affidamentoResource.getIndicatori().setTaeg("010.91997");
		affidamentoResource.getIndicatori().setTeg("010.21981");
		
		affidamentoResource.getIndicatori().setTan(new TanResource());
		affidamentoResource.getIndicatori().getTan().setFlUsura("S");
		affidamentoResource.getIndicatori().getTan().setValore("013.89786");
		affidamentoResource.getIndicatori().getTan().setParametri(new ParametriResource());
		affidamentoResource.getIndicatori().getTan().getParametri().setPercApplic("002.50123");
		affidamentoResource.getIndicatori().getTan().getParametri().setDescIndice("-TAN-");
		affidamentoResource.getIndicatori().getTan().getParametri().setSegnoSpread("+");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreIndice("021.12221");
		affidamentoResource.getIndicatori().getTan().getParametri().setValoreSpread("17.11234");
		
		praticaResource.getAffidamenti().add(affidamentoResource);
		
		return praticaResource;
		
	}

}
