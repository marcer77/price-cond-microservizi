package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.ObjectFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorRequest;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapRequestTransformer;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@Service
public class ProposteCJPOSWSRevocaPropostaRequestTransformer
		implements ISoapRequestTransformer<RevocaProposta, JAXBElement<RevocaProposta>> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSRevocaPropostaRequestTransformer.class);

	private ObjectFactory objectFactory;

	public ProposteCJPOSWSRevocaPropostaRequestTransformer() {
		objectFactory = new ObjectFactory();
	}

	@Override
	public SoapConnectorRequest<JAXBElement<RevocaProposta>> transform(RevocaProposta om, Object... args) {
		log.info(" - transform RevocaProposta {"+om.toString()+"}");
		SoapConnectorRequest<JAXBElement<RevocaProposta>> request = new SoapConnectorRequest<>();
		request.setPayload(objectFactory.createRevocaProposta(om));
		request.setSoapHeader((ISPWebservicesHeaderType) args[0]);
		return request;
	}

}