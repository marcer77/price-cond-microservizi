package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoRevocaPropostaResponse;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;

@Service
public class ProposteCJPOSWSRevocaPropostaResponseTransformer
		implements ISoapResponseTransformer<JAXBElement<EsitoRevocaPropostaResponse>, EsitoRevocaPropostaResponse> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSRevocaPropostaResponseTransformer.class);

	@Override
	public EsitoRevocaPropostaResponse transform(
			SoapConnectorResponse<JAXBElement<EsitoRevocaPropostaResponse>> soapConnectorResponse) {
		log.info(" - transform");
		return soapConnectorResponse.getResponse().getValue();
	}
}