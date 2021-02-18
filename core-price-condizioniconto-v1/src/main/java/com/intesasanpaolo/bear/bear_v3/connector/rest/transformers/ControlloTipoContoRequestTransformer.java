package com.intesasanpaolo.bear.bear_v3.connector.rest.transformers;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoRequest;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.converter.ControlloTipoContoRequestConverter;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestHostBridge;
import com.intesasanpaolo.bear.connector.rest.model.RestConnectorRequest;
import com.intesasanpaolo.bear.connector.rest.transformer.IRestRequestTransformer;

@Service
public class ControlloTipoContoRequestTransformer<RequestHostBridge> implements IRestRequestTransformer<RequestHostBridge,RequestHostBridge>{

	@Override
	public RestConnectorRequest<RequestHostBridge> transform(
			RequestHostBridge request, Object... args) {
		
		RestConnectorRequest<RequestHostBridge> controlloTipoContoRequest = new RestConnectorRequest<>();
		controlloTipoContoRequest.setMethod(HttpMethod.POST);
		controlloTipoContoRequest.setRequest(request);
		
        return controlloTipoContoRequest;
	}

}
