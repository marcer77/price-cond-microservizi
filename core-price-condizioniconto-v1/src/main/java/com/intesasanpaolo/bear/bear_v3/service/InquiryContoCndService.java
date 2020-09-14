package com.intesasanpaolo.bear.bear_v3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.connector.ws.InquiryContoCndConnector;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.transformers.InquiryContoCndRequestTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.ws.transformers.InquiryContoCndResponseTransformer;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class InquiryContoCndService extends BaseService{
	
	@Autowired
	private InquiryContoCndConnector inquiryContoCndConnector;
	@Autowired
	private InquiryContoCndRequestTransformer inquiryContoCndRequestTransformer;
	@Autowired
	private InquiryContoCndResponseTransformer inquiryContoCndResponseTransformer;
	
	public List<IIBCDPRCMSSingleResponseType> inquiryContoCnd(IIBCDPRCMSRequest request) {
		return inquiryContoCndConnector.call(request, inquiryContoCndRequestTransformer, inquiryContoCndResponseTransformer);
	}

}
