package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.transformers;


import java.util.HashMap;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.connector.rest.model.RestConnectorRequest;
import com.intesasanpaolo.bear.connector.rest.transformer.IRestRequestTransformer;



@Component
public class GestioneRequestTransformer implements IRestRequestTransformer<NewAccountInput, NewAccountInput> {

	@Override
	public RestConnectorRequest<NewAccountInput> transform(NewAccountInput request, Object... args) {
		RestConnectorRequest<NewAccountInput> restConnectorRequest = new RestConnectorRequest<>();
		restConnectorRequest.setMethod(HttpMethod.POST);
		_buildHeader(restConnectorRequest, (HashMap<String,String>) args[0]);
		restConnectorRequest.setRequest(request);
		return restConnectorRequest;
	}
	
	private void _buildHeader(RestConnectorRequest<NewAccountInput> restConnectorRequest, HashMap<String,String> headaerParams) {
		restConnectorRequest.addHeader("Content-Type", "application/json");
		restConnectorRequest.addHeader("Accept", "application/json");
		if(headaerParams!=null) {
			for(String key: headaerParams.keySet()) {
				restConnectorRequest.addHeader(key, headaerParams.get(key));
			}
		}
	}

}
