package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws;

import org.springframework.stereotype.Service;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.oxm.Unmarshaller;


import com.intesasanpaolo.bear.connector.ws.connector.BaseDataPowerSoapConnector;

@Service
public class RollbackStoreCovenantAdesioneConvenzioneConnector<INPUT,OUTPUT,DTO,RESOURCE> extends BaseDataPowerSoapConnector<INPUT,OUTPUT,DTO,RESOURCE> {
	
	
	
//	@Override
//	protected void handleSoapFault(SoapMessage soapMessage, Unmarshaller unmarshaller) throws RuntimeException {
//		logger.info("handleSoapFault(  ) - START");
//		logger.info("Il servizio Soap ha restituito l'errore: "+ soapMessage.getFaultReason());
//		logger.info("handleSoapFault(  ) - END");
//		throw new RuntimeException("Il servizio Soap ha restituito l'errore: " + soapMessage.getFaultReason());
//	}
	
	
}
