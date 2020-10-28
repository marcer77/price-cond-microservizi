package com.intesasanpaolo.bear.bear_v3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.intesasanpaolo.bear.bear_v3.connector.ws.InquiryContoCndConnector;
import com.intesasanpaolo.bear.bear_v3.connector.ws.InquiryContoCndConnectorV2;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.transformers.InquiryContoCndRequestTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.ws.transformers.InquiryContoCndResponseTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.ws.transformers.InquiryContoCndResponseTransformerV2;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.bear_v3.service.exception.IIBWebServiceException;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class InquiryContoCndService extends BaseService{
	
	@Autowired
	private InquiryContoCndConnector inquiryContoCndConnector;
	@Autowired
	private InquiryContoCndRequestTransformer inquiryContoCndRequestTransformer;
	@Autowired
	private InquiryContoCndResponseTransformer inquiryContoCndResponseTransformer;
	
	@Autowired
	private InquiryContoCndResponseTransformerV2 inquiryContoCndResponseTransformerV2;
	@Autowired
	private InquiryContoCndConnectorV2 inquiryContoCndConnectorV2;
	
	public List<IIBCDPRCMSSingleResponseType> inquiryContoCnd(IIBCDPRCMSRequest request) {
		return inquiryContoCndConnector.call(request, inquiryContoCndRequestTransformer, inquiryContoCndResponseTransformer);
	}
	
	public IIBCDPRCMSResponseType inquiryContoCndV2(IIBCDPRCMSRequest request) throws IIBWebServiceException {
		IIBCDPRCMSResponseType response= inquiryContoCndConnectorV2.call(request, inquiryContoCndRequestTransformer, inquiryContoCndResponseTransformerV2);
		
		if (response.getResponse()!=null) {
			String msg=response.getResponse().getNBPErrorInfo()!=null?response.getResponse().getNBPErrorInfo().getErrReason():null;
			if (msg == null)
				msg="Errore inquiryContoCnd Response: Impossibile verificare l'errore ";
			logger.warn("InquiryContoCndService inquiryContoCndV2: "+msg);
		}
		if (!CollectionUtils.isEmpty(response.getOutputProdotto())) {
			//al massimo  avremo un solo elemento	
			boolean checkErrore= response.getOutputProdotto().get(0)!=null && !CollectionUtils.isEmpty(response.getOutputProdotto().get(0).getNbpErrorInfo());
			if (checkErrore) {
				String msg= response.getOutputProdotto().get(0).getNbpErrorInfo().get(0)!=null? response.getOutputProdotto().get(0).getNbpErrorInfo().get(0).getErrReason():null;
				if (msg == null)
					msg="Errore inquiryContoCnd Response: Impossibile verificare l'errore ";
				throw new IIBWebServiceException(msg,null);
			}
			
		}		
		return response;
	}

}
