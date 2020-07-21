package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;
@Service
public class GetRequisitiAdesioneConvenzioneResponseTrasformer implements ISoapResponseTransformer<GetRequisitiAdesioneConvenzioneResponse,RespGetRequisitiAdesioneConvenzione> {

	@Override
	public RespGetRequisitiAdesioneConvenzione transform(SoapConnectorResponse<GetRequisitiAdesioneConvenzioneResponse> soapConnectorResponse) {
		return  populateResponse(soapConnectorResponse.getResponse());
	}

	private RespGetRequisitiAdesioneConvenzione populateResponse(GetRequisitiAdesioneConvenzioneResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
