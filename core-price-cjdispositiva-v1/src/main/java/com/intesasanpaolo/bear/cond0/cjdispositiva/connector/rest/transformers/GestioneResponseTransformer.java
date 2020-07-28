package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.transformers;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.connector.rest.model.RestConnectorResponse;
import com.intesasanpaolo.bear.connector.rest.transformer.IRestResponseTransformer;

@Service
public class GestioneResponseTransformer implements IRestResponseTransformer<NewAccountOutput, NewAccountOutput> {

	@Override
	public NewAccountOutput transform(RestConnectorResponse<NewAccountOutput> restConnectorResponse) {
		return restConnectorResponse.getResponse().getBody();
	}
}
