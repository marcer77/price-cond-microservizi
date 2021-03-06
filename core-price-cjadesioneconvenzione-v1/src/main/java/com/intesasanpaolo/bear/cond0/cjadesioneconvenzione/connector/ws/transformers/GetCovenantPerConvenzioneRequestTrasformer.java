package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorRequest;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapRequestTransformer;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.CovenantPerConvenzioneRequest;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzione;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ObjectFactory;

@Service
public class GetCovenantPerConvenzioneRequestTrasformer implements ISoapRequestTransformer<ReqGetCovenantPerConvenzione,JAXBElement<GetCovenantPerConvenzione>>{
	
	private ObjectFactory objectFactory;
	
	private static final Logger log = LoggerUtils.getLogger(GetCovenantPerConvenzioneRequestTrasformer.class);

    public GetCovenantPerConvenzioneRequestTrasformer() {
		objectFactory = new ObjectFactory();
    }

    @Override
    public SoapConnectorRequest<JAXBElement<GetCovenantPerConvenzione>> transform(ReqGetCovenantPerConvenzione input, Object... args) {
    	
    	log.info("transform(  ) - START");
    	GetCovenantPerConvenzione getCovenantPerConvenzione = objectFactory.createGetCovenantPerConvenzione();
    	
    	CovenantPerConvenzioneRequest in = new CovenantPerConvenzioneRequest();
    	
    	in.setABI(objectFactory.createCovenantPerConvenzioneRequestABI(input.getAbi()));
    	in.setApplicativoId(objectFactory.createCovenantPerConvenzioneRequestApplicativoId(input.getApplicativoId()));
    	in.setCodConvenzione(objectFactory.createCovenantPerConvenzioneRequestCodConvenzione(input.getCodConvenzione()));
    	in.setDataAdesione(objectFactory.createCovenantPerConvenzioneRequestDataAdesione(input.getDataAdesione()));
    	in.setDataDiNascita(objectFactory.createCovenantPerConvenzioneRequestDataDiNascita(input.getDataDiNascita()));
    	in.setFilialeUserId(objectFactory.createCovenantPerConvenzioneRequestFilialeUserId(input.getFilialeUserId()));
    	in.setIDProdottoCovenant(objectFactory.createCovenantPerConvenzioneRequestIDProdottoCovenant(input.getIdProdottoCovenant()));
    	in.setRapportoABI(objectFactory.createCovenantPerConvenzioneRequestRapportoABI(input.getRapportoAbi()));
    	in.setRapportoCategoria(objectFactory.createCovenantPerConvenzioneRequestRapportoCategoria(input.getRapportoCategoria()));
    	in.setRapportoConto(objectFactory.createCovenantPerConvenzioneRequestRapportoConto(input.getRapportoConto()));
    	in.setRapportoFiliale(objectFactory.createCovenantPerConvenzioneRequestRapportoFiliale(input.getRapportoFiliale()));
    	in.setUserId(objectFactory.createCovenantPerConvenzioneRequestUserId(input.getUserId()));
    	
    	getCovenantPerConvenzione.setInput(objectFactory.createGetCovenantPerConvenzioneInput(in));
        SoapConnectorRequest<JAXBElement<GetCovenantPerConvenzione>> request = new SoapConnectorRequest<>();
        request.setPayload(new JAXBElement(new QName("http://tempuri.org/","GetCovenantPerConvenzione"),GetCovenantPerConvenzione.class,getCovenantPerConvenzione));
        log.info("transform(  ) - END");
        return request;
    }
}
