package com.intesasanpaolo.bear.bear_v3.connector.ws;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSResponseType;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.connector.ws.connector.BaseDataPowerSoapConnector;

@Service
public class InquiryContoCndConnectorV2 extends BaseDataPowerSoapConnector<IIBCDPRCMSRequest, IIBCDPRCMSResponseType, JAXBElement<IIBCDPRCMSRequestType>, JAXBElement<IIBCDPRCMSResponseType>>{
	
}
