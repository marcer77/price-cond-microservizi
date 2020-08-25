package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.connector.rest.connector.BaseRestConnector;

@Service
public class GestioneRestConnector
		extends BaseRestConnector<NewAccountInput, NewAccountOutput, NewAccountInput, NewAccountOutput> {

}
