package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoInviaPropostaV2Response;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;

@Service
public class ProposteCJPOSWSInviaPropostaV2ResponseTransformer
		implements ISoapResponseTransformer<JAXBElement<EsitoInviaPropostaV2Response>, EsitoInviaPropostaV2Response> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSInviaPropostaV2ResponseTransformer.class);

	@Override
	public EsitoInviaPropostaV2Response transform(
			SoapConnectorResponse<JAXBElement<EsitoInviaPropostaV2Response>> soapConnectorResponse) {
		log.info(" - transform");
		return soapConnectorResponse.getResponse().getValue();
	}
}