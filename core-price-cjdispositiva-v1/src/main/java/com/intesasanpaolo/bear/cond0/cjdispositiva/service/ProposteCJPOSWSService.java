package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.ProposteCJPOSWSInviaPropostaV2Connector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoInviaPropostaV2Response;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2RequestTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2ResponseTransformer;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class ProposteCJPOSWSService extends BaseService {

	private Logger log = Logger.getLogger(ProposteCJPOSWSService.class);

	@Autowired
	private ProposteCJPOSWSInviaPropostaV2RequestTransformer proposteCJPOSWSInviaPropostaV2RequestTransformer;

	@Autowired
	private ProposteCJPOSWSInviaPropostaV2ResponseTransformer proposteCJPOSWSInviaPropostaV2ResponseTransformer;

	@Autowired
	private ProposteCJPOSWSInviaPropostaV2Connector proposteCJPOSWSInviaPropostaV2Connector;
	
	public EsitoOperazioneCJPOSV2 inviaPropostaV2(InviaPropostaV2 request, ISPWebservicesHeaderType header) {
		log.info(" - inviaPropostaV2 START");
		//forzatura AUTODEL
		header.getOperatorInfo().setUserID("AUTODEL");
		EsitoInviaPropostaV2Response esitoInviaPropostaV2Response = proposteCJPOSWSInviaPropostaV2Connector.call(
				request, proposteCJPOSWSInviaPropostaV2RequestTransformer,
				proposteCJPOSWSInviaPropostaV2ResponseTransformer, header);
		EsitoOperazioneCJPOSV2 dto = new EsitoOperazioneCJPOSV2();
		if (esitoInviaPropostaV2Response != null && esitoInviaPropostaV2Response.getEsito() != null) {
			if("OK".equals(esitoInviaPropostaV2Response.getEsito().getEsitoCodice())) {
				log.info(" - inquiry RESPONSE " + esitoInviaPropostaV2Response.getEsito());
				dto.setCodiceProposta(esitoInviaPropostaV2Response.getEsito().getCodiceProposta());
				dto.setEsitoCodice(esitoInviaPropostaV2Response.getEsito().getEsitoCodice());
				dto.setEsitoIter(esitoInviaPropostaV2Response.getEsito().getEsitoIter());
				dto.setEsitoMessaggio(esitoInviaPropostaV2Response.getEsito().getEsitoMessaggio());
				dto.setFaseIter(esitoInviaPropostaV2Response.getEsito().getFaseIter());
				dto.setStatoIter(esitoInviaPropostaV2Response.getEsito().getStatoIter());
			}else {
				dto.setEsitoCodice(esitoInviaPropostaV2Response.getEsito().getEsitoCodice());
				dto.setEsitoMessaggio(esitoInviaPropostaV2Response.getEsito().getEsitoMessaggio());
				throw CJWebServiceException.builder().webServiceName("inviaPropostaV2")
				.codiceErroreWebService(esitoInviaPropostaV2Response.getEsito().getEsitoCodice())
				.descrErroreWebService(esitoInviaPropostaV2Response.getEsito().getEsitoMessaggio()).build();
			}
		} else {
			dto.setEsitoCodice("KO");
			dto.setEsitoMessaggio("Risposta null");
			throw CJWebServiceException.builder().webServiceName("inviaPropostaV2")
			.codiceErroreWebService("KO")
			.descrErroreWebService("Nessun esito ricevuto dal ws.").build();
		}
		log.info(" - inviaPropostaV2 END");
		return dto;
	}

}
