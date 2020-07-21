package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ErrorCovenant;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.StoreCovenantAdesioneConvenzioneResponse;
@Service
public class StoreCovenantAdesioneConvenzioneResponseTransformer implements ISoapResponseTransformer<StoreCovenantAdesioneConvenzioneResponse,RespStoreCovenantAdesioneConvenzione> {

	@Override
	public RespStoreCovenantAdesioneConvenzione transform(SoapConnectorResponse<StoreCovenantAdesioneConvenzioneResponse> soapConnectorResponse) {

		StoreCovenantAdesioneConvenzioneResponse resp = soapConnectorResponse.getResponse();

		return toModel(resp.getStoreCovenantAdesioneConvenzioneResult().getValue());
	}
	
	private RespStoreCovenantAdesioneConvenzione toModel(ResponseStoreCovenantAdesioneConvenzione response) {
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
				listaErroriCovenantDaCessare.add(e );
			}
			
		}
		
		
		
		return RespStoreCovenantAdesioneConvenzione.builder()
				.esitoResultCode(res.getEsito().getValue().getResultCode().getValue())
				.esitoErrorMessage(res.getEsito().getValue().getErrorMessage().getValue())
				.listaErroriCovenantDaAttivare(listaErroriCovenantDaAttivare)
				.listaErroriCovenantDaCessare(listaErroriCovenantDaCessare).build();
		 

	}

}
