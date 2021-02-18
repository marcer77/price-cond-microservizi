package com.intesasanpaolo.bear.bear_v3.connector.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleRequestType;
import com.intesasanpaolo.bear.connector.ws.connector.BaseDataPowerSoapConnector;

//BaseRestConnector<INPUT,OUTPUT,DTO,RESOURCE>
@Service
public class InquiryContoCndConnector extends BaseDataPowerSoapConnector<IIBCDPRCMSRequest, List<IIBCDPRCMSSingleResponseType>, JAXBElement<IIBCDPRCMSRequestType>, JAXBElement<IIBCDPRCMSResponseType>>{
	
}
