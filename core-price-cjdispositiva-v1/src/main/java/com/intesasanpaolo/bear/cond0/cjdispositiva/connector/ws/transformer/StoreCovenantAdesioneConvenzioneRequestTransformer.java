package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformer;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ObjectFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.RequestStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.StoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.Covenant;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.StoreCovenantAdesioneConvenzioneRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;


import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorRequest;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapRequestTransformer;

@Service
public class StoreCovenantAdesioneConvenzioneRequestTransformer implements ISoapRequestTransformer<StoreCovenantAdesioneConvenzioneRequest,JAXBElement<StoreCovenantAdesioneConvenzione>>{
	
	private ObjectFactory objectFactory;
	
	private static final Logger log = LoggerUtils.getLogger(StoreCovenantAdesioneConvenzioneRequestTransformer.class);

    public StoreCovenantAdesioneConvenzioneRequestTransformer() {
		objectFactory = new ObjectFactory();
    }

    @Override
    public SoapConnectorRequest<JAXBElement<StoreCovenantAdesioneConvenzione>> transform(StoreCovenantAdesioneConvenzioneRequest input, Object... args) {
    	

    	StoreCovenantAdesioneConvenzione storeCovenantAdesioneConvenzione = objectFactory.createStoreCovenantAdesioneConvenzione();
    	
    	storeCovenantAdesioneConvenzione.setInput(objectFactory.createStoreCovenantAdesioneConvenzioneInput(_populateRequestStoreCovenantAdesioneConvenzione(input)));
        SoapConnectorRequest<JAXBElement<StoreCovenantAdesioneConvenzione>> request = new SoapConnectorRequest<>();
    
        request.setPayload(new JAXBElement(new QName("http://tempuri.org/","StoreCovenantAdesioneConvenzione"),StoreCovenantAdesioneConvenzione.class,storeCovenantAdesioneConvenzione));
   
        return request;
    }
    
    private RequestStoreCovenantAdesioneConvenzione _populateRequestStoreCovenantAdesioneConvenzione(StoreCovenantAdesioneConvenzioneRequest input) {
    	RequestStoreCovenantAdesioneConvenzione in = new RequestStoreCovenantAdesioneConvenzione();
    	
    	in.setABI(objectFactory.createRequestStoreCovenantAdesioneConvenzioneABI(input.getAbi()));
    	in.setApplicativoId(objectFactory.createRequestStoreCovenantAdesioneConvenzioneApplicativoId(input.getApplicativoId()));
    	in.setCodConvenzione(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCodConvenzione(input.getCodiceConvenzione()));
    	in.setCodConvenzioneOLD(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCodConvenzioneOLD(input.getCodiceConvenzioneOld()));
    	in.setDataOperazione(objectFactory.createRequestStoreCovenantAdesioneConvenzioneDataOperazione(input.getDataOperazione()));
    	in.setDataProposta(objectFactory.createRequestStoreCovenantAdesioneConvenzioneDataProposta(input.getDataProposta()));
    	in.setFilialeUserId(objectFactory.createRequestStoreCovenantAdesioneConvenzioneFilialeUserId(input.getFilialeUserId()));
    	in.setIDProdottoCovenant(objectFactory.createRequestStoreCovenantAdesioneConvenzioneIDProdottoCovenant(input.getIdProdottoCovenant()));
    	in.setListaCovenantDaAttivare(objectFactory.createRequestStoreCovenantAdesioneConvenzioneListaCovenantDaAttivare(getListaCovenantDaAttivareJaxb(input.getListaCovenantDaAttivare())));
    	in.setListaCovenantDaCessare(objectFactory.createRequestStoreCovenantAdesioneConvenzioneListaCovenantDaCessare(getListaCovenantDaCessareJaxb(input.getListaCovenantDaCessare())));
    	in.setNSG(objectFactory.createRequestStoreCovenantAdesioneConvenzioneNSG(input.getNsg()));
    	in.setNumeroProposta(objectFactory.createRequestStoreCovenantAdesioneConvenzioneNumeroProposta(input.getNumeroProposta()));
    	in.setTipoOperazione(objectFactory.createRequestStoreCovenantAdesioneConvenzioneTipoOperazione(input.getTipoOperazione()));
    	in.setUserId(objectFactory.createRequestStoreCovenantAdesioneConvenzioneUserId(input.getUserId()));
    	
    	return in;
    }

	private ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare getListaCovenantDaCessareJaxb(
			List<Covenant> listaCovenantDaCessare) {
		ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare arrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare = objectFactory.createArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare();
		if(CollectionUtils.isNotEmpty(listaCovenantDaCessare)) {
			for (Covenant covenant : listaCovenantDaCessare) {
				RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare e = objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare();
				e.setCodCondizione(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareCodCondizione(covenant.getCodCondizione()));
				e.setCodiceTemplate(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareCodiceTemplate(covenant.getCodiceTemplate()));
				e.setProgressivo(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareProgressivo(covenant.getProgressivo()));
				e.setRapportoCategoria(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareRapportoCategoria(covenant.getRapportoCategoria()));
				e.setRapportoConto(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareRapportoConto(covenant.getRapportoConto()));
				e.setRapportoFiliale(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareRapportoFiliale(covenant.getRapportoFiliale()));
				e.setVersioneTemplate(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareVersioneTemplate(covenant.getVersioneTemplate()));
				
				arrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.getRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare().add(e);
			}
			
		}
		
		return arrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare;
	}

	private ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare getListaCovenantDaAttivareJaxb(
			List<Covenant> listaCovenantDaAttivare) {
		ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare arrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare = objectFactory.createArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare();
		if(CollectionUtils.isNotEmpty(listaCovenantDaAttivare)) {
			for (Covenant covenant : listaCovenantDaAttivare) {
				RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare e = objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare();
				e.setBeneficioCondizionatoDataFine(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataFine(covenant.getBeneficioCondizionatoDataFine()));
				e.setBeneficioCondizionatoDataInizio(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataInizio(covenant.getBeneficioCondizionatoDataInizio()));
				e.setBeneficioIncondizionatoDataFine(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataFine(covenant.getBeneficioIncondizionatoDataFine()));
				e.setBeneficioIncondizionatoDataInizio(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataInizio(covenant.getBeneficioIncondizionatoDatainizio()));
				e.setBeneficioIncondizionatoNumRilevazioni(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoNumRilevazioni(covenant.getBeneficioIncondizionatoNumrilevazioni()));
				e.setBeneficioIncondizionatoPresente(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoPresente(covenant.getBeneficioIncondizionatoPresente()));
				e.setBeneficioIngressoDataFine(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataFine(covenant.getBeneficioIngressoDataFine()));
				e.setBeneficioIngressoDataInizio(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataInizio(covenant.getBeneficioIngressoDataInizio()));
				e.setBeneficioIngressoPresente(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoPresente(covenant.getBeneficioIngressoPresente()));
				e.setCodCondizione(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodCondizione(covenant.getCodCondizione()));
				e.setCodCondizioneRealeMLT(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodCondizioneRealeMLT(covenant.getCodCondizioneRealeMlt()));
				e.setCodiceTemplate(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodiceTemplate(covenant.getCodiceTemplate()));
				e.setCondizioniFiglie(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCondizioniFiglie(covenant.getCondizioniFiglie()));
				e.setCovenantDataFine(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataFine(covenant.getCovenantDataFine()));
				e.setCovenantDataInizio(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataInizio(covenant.getCovenantDataInizio()));
				e.setFlagEntitaPrincipale(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareFlagEntitaPrincipale(covenant.getFlagEntitaPrincipale()));
				e.setLivelloGerarchia(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareLivelloGerarchia(covenant.getLivelloGerarchia()));
				e.setProgressivo(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareProgressivo(covenant.getProgressivo()));
				e.setRapportoCategoria(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareRapportoCategoria(covenant.getRapportoCategoria()));
				e.setRapportoConto(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareRapportoConto(covenant.getRapportoConto()));
				e.setRapportoFiliale(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareRapportoFiliale(covenant.getRapportoFiliale()));
				e.setVersioneTemplate(objectFactory.createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareVersioneTemplate(covenant.getVersioneTemplate()));
				
			}
			
		}
		return null;
	}
}
