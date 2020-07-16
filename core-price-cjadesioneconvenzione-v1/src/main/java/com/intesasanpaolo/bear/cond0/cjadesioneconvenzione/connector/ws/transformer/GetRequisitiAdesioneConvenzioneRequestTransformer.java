package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformer;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.AdesioneRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.ArrayOfCodiceFiscale;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.CodiceFiscale;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice.ObjectFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorRequest;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapRequestTransformer;

@Service
public class GetRequisitiAdesioneConvenzioneRequestTransformer implements ISoapRequestTransformer<RequisitiAdesioneConvenzione,JAXBElement<AdesioneRequest>>{
	
	private ObjectFactory objectFactory = new ObjectFactory();

	@Override
	public SoapConnectorRequest<JAXBElement<AdesioneRequest>> transform(RequisitiAdesioneConvenzione input, Object... args) {
				
		GetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzione = objectFactory.createGetRequisitiAdesioneConvenzione();
		
		AdesioneRequest in = new AdesioneRequest();
		in.setABI(objectFactory.createAdesioneRequestABI(input.getAbi()));
		in.setApplicativoId(objectFactory.createAdesioneRequestApplicativoId(input.getApplicativoId()));
		in.setCodiceConvenzione(objectFactory.createAdesioneRequestCodiceConvenzione(input.getCodiceConvenzione()));
		in.setDataAccensione(objectFactory.createAdesioneRequestDataAccensione(input.getDataAccensione()));
		in.setDataAdesione(objectFactory.createAdesioneRequestDataAdesione(input.getDataAdesione()));
		in.setFiliale(objectFactory.createAdesioneRequestFiliale(input.getFiliale()));
		in.setFlagTipoCliente(objectFactory.createAdesioneRequestFlagTipoCliente(input.getFlagTipoCliente()));
		in.setNDG(objectFactory.createAdesioneRequestNDG(input.getNdg()));
		in.setPIVA(objectFactory.createAdesioneRequestPIVA(input.getPIva()));
		in.setRapportoCategoria(objectFactory.createAdesioneRequestRapportoCategoria(input.getRapportoCategoria()));
		in.setRapportoCategoriaStipendio(objectFactory.createAdesioneRequestRapportoCategoriaStipendio(input.getRapportoCategoriaStipendio()));
		in.setRapportoCodice(objectFactory.createAdesioneRequestRapportoCodice(input.getRapportoCodice()));
		in.setRapportoCodiceStipendio(objectFactory.createAdesioneRequestRapportoCodiceStipendio(input.getRapportoCodiceStipendio()));
		in.setRapportoFiliale(objectFactory.createAdesioneRequestRapportoFiliale(input.getRapportoFiliale()));
		in.setRapportoFilialeStipendio(objectFactory.createAdesioneRequestRapportoFilialeStipendio(input.getRapportoFilialeStipendio()));
		in.setRating(objectFactory.createAdesioneRequestRating(input.getRating()));
		in.setROL(objectFactory.createAdesioneRequestROL(input.getRol()));
		in.setTipoChiamata(objectFactory.createAdesioneRequestTipoChiamata(input.getTipoChiamata()));
		in.setUserId(objectFactory.createAdesioneRequestUserId(input.getUserId()));
		in.setListaCodiciFiscali(objectFactory.createAdesioneRequestListaCodiciFiscali(getListaCodiciFiscali(input.getCodiciFiscali())));
		
		getRequisitiAdesioneConvenzione.setInput(objectFactory.createGetRequisitiAdesioneConvenzioneInput(in));
		
		SoapConnectorRequest<JAXBElement<AdesioneRequest>> request = new SoapConnectorRequest<>();
		request.setPayload(new JAXBElement(new QName("http://tempuri.org/","GetRequisitiAdesioneConvenzione"),GetRequisitiAdesioneConvenzione.class,getRequisitiAdesioneConvenzione));
		return request;
	}

	private ArrayOfCodiceFiscale getListaCodiciFiscali(List<String> codiciFiscali){
		ArrayOfCodiceFiscale arrayOfCodiceFiscale = new ArrayOfCodiceFiscale();
		if(CollectionUtils.isNotEmpty(codiciFiscali)) {
			for(String cf:codiciFiscali) {
				CodiceFiscale codiceFiscale = new CodiceFiscale();
				codiceFiscale.setCF(objectFactory.createCodiceFiscaleCF(cf));
				arrayOfCodiceFiscale.getCodiceFiscale().add(codiceFiscale);
			}
		}
		return arrayOfCodiceFiscale;
	}


}
