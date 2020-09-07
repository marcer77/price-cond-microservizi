package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws;

import java.util.Iterator;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.dom.DOMResult;

import org.apache.log4j.Logger;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.SoapMessage;
import org.w3c.dom.Node;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoInviaPropostaV2Response;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.connector.ws.connector.BaseDataPowerSoapConnector;

@Service
public class ProposteCJPOSWSInviaPropostaV2Connector extends
		BaseDataPowerSoapConnector<InviaPropostaV2, EsitoInviaPropostaV2Response, JAXBElement<InviaPropostaV2>, JAXBElement<EsitoInviaPropostaV2Response>> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSInviaPropostaV2Connector.class);

	protected void handleSoapFault(SoapMessage soapMessage, Unmarshaller unmarshaller) throws RuntimeException {
		log.info(" handleSoapFault START");
		StringBuilder errorMessage = new StringBuilder();
		SoapFaultDetail faultDetail = ((SoapMessage) soapMessage).getSoapBody().getFault().getFaultDetail();
		Iterator<SoapFaultDetailElement> detailEntries = faultDetail.getDetailEntries();
		while (detailEntries.hasNext()) {
			SoapFaultDetailElement detailElement = detailEntries.next();
			Node node = ((DOMResult) detailElement.getResult()).getNode();
			log.debug("Nome nodo: " + node.getNodeName() + " Valore nodo: " + node.getNodeValue() + " Testo nodo: "
					+ node.getTextContent());
			errorMessage.append(node.getTextContent());
			log.info(" handleSoapFault ERROR: " + node.getTextContent());
		}
		log.info(" handleSoapFault END");
		throw CJWebServiceException.builder().webServiceName("inviaPropostaV2").codiceErroreWebService("KO")
		.descrErroreWebService(errorMessage.toString()).build();
//		throw new RuntimeException(errorMessage.toString());
	}

}
