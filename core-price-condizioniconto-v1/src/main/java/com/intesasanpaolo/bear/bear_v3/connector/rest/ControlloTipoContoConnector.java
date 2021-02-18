package com.intesasanpaolo.bear.bear_v3.connector.rest;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoResponse;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoRequest;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestHostBridge;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseHostBridge;
import com.intesasanpaolo.bear.connector.rest.connector.BaseRestConnector;

//BaseRestConnector<INPUT,OUTPUT,DTO,RESOURCE>
@Service
public class ControlloTipoContoConnector extends BaseRestConnector<RequestHostBridge,ResponseHostBridge,Void,ResponseHostBridge>{

}
