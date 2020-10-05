package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseRollBackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.RollbackStoreCovenantAdesioneConvenzioneResponse;
@Service
public class RollbackStoreCovenantAdesioneConvenzioneResponseTransformer implements ISoapResponseTransformer<RollbackStoreCovenantAdesioneConvenzioneResponse,RespRollbackStoreCovenantAdesioneConvenzione> {

	@Override
	public RespRollbackStoreCovenantAdesioneConvenzione transform(SoapConnectorResponse<RollbackStoreCovenantAdesioneConvenzioneResponse> soapConnectorResponse) {

		RollbackStoreCovenantAdesioneConvenzioneResponse resp = soapConnectorResponse.getResponse();

		return toModel(resp.getRollbackStoreCovenantAdesioneConvenzioneResult().getValue());
	}
	
	private RespRollbackStoreCovenantAdesioneConvenzione toModel(ResponseRollBackStoreCovenantAdesioneConvenzione response) {
		
		
		return RespRollbackStoreCovenantAdesioneConvenzione.builder()
				.errorDescription(response.getErrorDescription().getValue())
				.isHasError(response.isHasError())
				.build();
		 

	}

}
