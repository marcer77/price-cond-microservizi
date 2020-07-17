package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.convenzionihostservice.StoreCovenantAdesioneConvenzioneResponse;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ErrorCovenant;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.StoreCovenantAdesioneConvenzioneResult;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
@Service
public class StoreCovenantAdesioneConvenzioneResponseTransformer implements ISoapResponseTransformer<StoreCovenantAdesioneConvenzioneResponse,StoreCovenantAdesioneConvenzioneResult> {

	@Override
	public StoreCovenantAdesioneConvenzioneResult transform(SoapConnectorResponse<StoreCovenantAdesioneConvenzioneResponse> soapConnectorResponse) {

		StoreCovenantAdesioneConvenzioneResponse resp = soapConnectorResponse.getResponse();

		return toModel(resp.getStoreCovenantAdesioneConvenzioneResult().getValue());
	}
	
	private StoreCovenantAdesioneConvenzioneResult toModel(ResponseStoreCovenantAdesioneConvenzione response) {
		ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione res = response
				.getResponseStoreCovenantAdesioneConvenzione().getValue();
		
		List<ErrorCovenant> listaErroriCovenantDaAttivare = new ArrayList<>();
		List<ErrorCovenant> listaErroriCovenantDaCessare = new ArrayList<>();
		
		if(CollectionUtils.isNotEmpty(res.getErroriListaCovenantDaAttivare().getValue().getResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare())){
			for (ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare element : res.getErroriListaCovenantDaAttivare().getValue().getResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare()) {
				ErrorCovenant e = new ErrorCovenant(element.getProgressivo().getValue(),element.getErrorMessage().getValue());
				listaErroriCovenantDaAttivare.add(e );
			}
			
		}
		
		if(CollectionUtils.isNotEmpty(res.getErroriListaCovenantDaCessare().getValue().getResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare())){
			for (ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare element : res.getErroriListaCovenantDaCessare().getValue().getResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare()) {
				ErrorCovenant e = new ErrorCovenant(element.getProgressivo().getValue(),element.getErrorMessage().getValue());
				listaErroriCovenantDaAttivare.add(e );
			}
			
		}
		
		
		
		return StoreCovenantAdesioneConvenzioneResult.builder()
				.esitoResultCode(res.getEsito().getValue().getResultCode().getValue())
				.esitoErrorMessage(res.getEsito().getValue().getErrorMessage().getValue())
				.listaErroriCovenantDaAttivare(listaErroriCovenantDaAttivare)
				.listaErroriCovenantDaCessare(listaErroriCovenantDaCessare).build();
		 

	}

}
