package com.intesasanpaolo.bear.bear_v3.connector.rest.transformers;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoResponse;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseHostBridge;
import com.intesasanpaolo.bear.connector.rest.model.RestConnectorResponse;
import com.intesasanpaolo.bear.connector.rest.transformer.IRestResponseTransformer;

@Service
public class ControlloTipoContoResponseTransformer implements IRestResponseTransformer<ResponseHostBridge,ResponseHostBridge>{

	// faccio la conversione nel command perchè la response contine informazioni in più che servono nelle logiche del command
	@Override
	public ResponseHostBridge transform(
			RestConnectorResponse<ResponseHostBridge> restConnectorResponse) {
		ResponseHostBridge response = restConnectorResponse.getResponse().getBody();
		return response;
	}

}
