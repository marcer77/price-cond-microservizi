package com.intesasanpaolo.bear.bear_v3.connector.ws.transformers;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.command.CondizioniContoUtils;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ObjectFactory;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSHeader;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorRequest;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapRequestTransformer;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.BusinessInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.CompanyInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.OperatorInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.RequestInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.TechnicalInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Service
public class InquiryContoCndRequestTransformer<InqCondLivelloDerogaRequest> implements ISoapRequestTransformer<IIBCDPRCMSRequest,JAXBElement<IIBCDPRCMSRequestType>>{


    @Override
    public SoapConnectorRequest<JAXBElement<IIBCDPRCMSRequestType>> transform(IIBCDPRCMSRequest req, Object... args) {
        
		// si istanzia il wrapper per impostare l'oggetto di request
    	IIBCDPRCMSRequestType reqWrapper = new IIBCDPRCMSRequestType();
    	IIBCDPRCMSHeader reqHeader = req.getHeader();
    	
    	for (IIBCDPRCMSSingleRequestType prod : req.getBody()) {
    		reqWrapper.getProdotto().add(prod);
		}
		reqWrapper.setFlagODM("N");//S chiama il flusso vecchio e non il servizio REST
    	
		String timestamp = CondizioniContoUtils.today_yyyyMMddHHmm();
		
    	RequestInfo requestInfo = new RequestInfo();
		requestInfo.setTransactionId("IIBCDPRCMS"+timestamp);
		requestInfo.setTimestamp(Long.parseLong(timestamp));
		requestInfo.setServiceID("IIBCDPRCMS");
		requestInfo.setServiceVersion("00");
		requestInfo.setLanguage("I");
	    OperatorInfo operatorInfo = new OperatorInfo();
	    operatorInfo.setUserID(reqHeader.getUserID());
	    operatorInfo.setIsVirtualUser(false);
	    //operatorInfo.setNotISPUserID("");
	    CompanyInfo companyInfo = new CompanyInfo();
	    companyInfo.setISPCallerCompanyIDCode(reqHeader.getIspCallerCompanyIDCode());
	    companyInfo.setNotISPCompanyIDCode("");
	    companyInfo.setISPBranchCode(reqHeader.getIspBranchCode());
	    companyInfo.setISPServiceCompanyIDCode("01");
	    BusinessInfo businessInfo = new BusinessInfo();
	    /*businessInfo.setBusinessFileID("");
	    businessInfo.setBusinessOperation("");
	    businessInfo.setBusinessProcessID("");
	    businessInfo.setBusinessProcessName("");
	    businessInfo.setCustomerID("");*/
	    TechnicalInfo technicalInfo = new TechnicalInfo();
	    technicalInfo.setChannelIDCode("44");
	    technicalInfo.setApplicationID("EEIB0");
	    technicalInfo.setCallerServerName("10.248.74.24");
	    //technicalInfo.setCallerProgramName("");
	    AdditionalBusinessInfo additionalBusinessInfo = new AdditionalBusinessInfo();
	    ISPWebservicesHeaderType.AdditionalBusinessInfo.Param cdAbi = new ISPWebservicesHeaderType.AdditionalBusinessInfo.Param();
	    cdAbi.setName(ParamList.COD_ABI);
	    cdAbi.setValue(reqHeader.getCodABI());
	    additionalBusinessInfo.getParam().add(cdAbi);
	    
	    ISPWebservicesHeaderType header = new ISPWebservicesHeaderType();
	    header.setAdditionalBusinessInfo(additionalBusinessInfo);
	    header.setBusinessInfo(businessInfo);
	    header.setCompanyInfo(companyInfo);
	    header.setOperatorInfo(operatorInfo);
	    header.setRequestInfo(requestInfo);
	    header.setTechnicalInfo(technicalInfo);
	    
		// si setta payload e eventuale header
		SoapConnectorRequest<JAXBElement<IIBCDPRCMSRequestType>> request = new SoapConnectorRequest<JAXBElement<IIBCDPRCMSRequestType>>();
        request.setSoapHeader(header);
        //request.setPayload(reqWrapper);
        request.setPayload(new ObjectFactory().createRequest(reqWrapper));
        return request;
    }

}
