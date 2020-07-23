package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.ObjectFactory;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorRequest;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapRequestTransformer;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@Service
public class ProposteCJPOSWSInviaPropostaV2RequestTransformer
		implements ISoapRequestTransformer<InviaPropostaV2, JAXBElement<InviaPropostaV2>> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSInviaPropostaV2RequestTransformer.class);

	private ObjectFactory objectFactory;

	public ProposteCJPOSWSInviaPropostaV2RequestTransformer() {
		objectFactory = new ObjectFactory();
	}

	@Override
	public SoapConnectorRequest<JAXBElement<InviaPropostaV2>> transform(InviaPropostaV2 om, Object... args) {
		SoapConnectorRequest<JAXBElement<InviaPropostaV2>> request = new SoapConnectorRequest<>();
		log.info(" - transform InviaPropostaV2 {"+om.toString()+"}");
		request.setPayload(objectFactory.createInviaPropostaV2(om));
		request.setSoapHeader((ISPWebservicesHeaderType) args[0]);
		return request;
	}

}