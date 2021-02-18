package com.intesasanpaolo.bear.bear_v3.connector.ws.transformers;

import java.util.List; 

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;

@Service
public class InquiryContoCndResponseTransformer implements ISoapResponseTransformer<JAXBElement<IIBCDPRCMSResponseType>,List<IIBCDPRCMSSingleResponseType>>{

	@Override
	public List<IIBCDPRCMSSingleResponseType> transform(
			SoapConnectorResponse<JAXBElement<IIBCDPRCMSResponseType>> soapConnectorResponse) {
		IIBCDPRCMSResponseType resWrapper = soapConnectorResponse.getResponse().getValue();
        return resWrapper.getOutputProdotto();
	}

}
