package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
@Service
public class GetCovenantPerConvenzioneResponseTrasformer implements ISoapResponseTransformer<JAXBElement<ResponseGetCovenantPerConvenzione>,ResponseGetCovenantPerConvenzione> {

	 @Override
	    public ResponseGetCovenantPerConvenzione transform(SoapConnectorResponse soapConnectorResponse) {
	    
		 GetCovenantPerConvenzioneResponse resp = (GetCovenantPerConvenzioneResponse) soapConnectorResponse.getResponse();
	    
	        return resp.getGetCovenantPerConvenzioneResult().getValue();
	    }
	
}
