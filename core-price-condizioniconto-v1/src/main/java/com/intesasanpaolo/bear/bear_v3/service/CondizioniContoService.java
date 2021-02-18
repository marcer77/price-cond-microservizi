package com.intesasanpaolo.bear.bear_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.connector.rest.ControlloTipoContoConnector;
import com.intesasanpaolo.bear.bear_v3.connector.rest.transformers.ControlloTipoContoRequestTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.rest.transformers.ControlloTipoContoResponseTransformer;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestHostBridge;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseHostBridge;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class CondizioniContoService extends BaseService{
	
	@Autowired
	private ControlloTipoContoConnector controlloTipoContoConnector;
	@Autowired
	private ControlloTipoContoRequestTransformer controlloTipoContoRequestTransformer;
	@Autowired
	private ControlloTipoContoResponseTransformer controlloTipoContoResponseTransformer;
	
	public ResponseHostBridge controlloTipoConto(RequestHostBridge request) {
		ResponseHostBridge response = controlloTipoContoConnector.call(request, controlloTipoContoRequestTransformer, controlloTipoContoResponseTransformer);
		return response;
	}

}
