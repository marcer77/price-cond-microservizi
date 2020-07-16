package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformer;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.StoreCovenantAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
@Service
public class StoreCovenantAdesioneConvenzioneResponseTransformer implements ISoapResponseTransformer<ResponseStoreCovenantAdesioneConvenzione,ResponseStoreCovenantAdesioneConvenzione> {

	@Override
	public ResponseStoreCovenantAdesioneConvenzione transform(SoapConnectorResponse soapConnectorResponse) {

		StoreCovenantAdesioneConvenzioneResponse resp = (StoreCovenantAdesioneConvenzioneResponse) soapConnectorResponse.getResponse();

		return resp.getStoreCovenantAdesioneConvenzioneResult().getValue();
	}

}
