package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJGenericBusinessApplication;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.GetCovenantPerConvenzioneConnector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers.GetCovenantPerConvenzioneRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers.GetCovenantPerConvenzioneResponseTrasformer;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;

@Service
public class ConvenzioniHostService {

	@Autowired
	private GetCovenantPerConvenzioneConnector convenzioniHostServiceConnector;
	@Autowired
	private GetCovenantPerConvenzioneResponseTrasformer getCovenantPerConvenzioneResponseTrasformer;
	@Autowired
	private GetCovenantPerConvenzioneRequestTrasformer getCovenantPerConvenzioneRequestTrasformer;

	public List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovenantPerConvenzione(
			ReqGetCovenantPerConvenzione request) {
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> response = null;
		try {
			response = (List<RespGetCovenantPerConvenzioneCovenantDaAttivare>) convenzioniHostServiceConnector.call(
					request, getCovenantPerConvenzioneRequestTrasformer, getCovenantPerConvenzioneResponseTrasformer,
					null);
		} catch (Exception e) {
			throw new CJGenericBusinessApplication(CommonErrorCode.BS_SRV_EXCEPTION,
					"ConvenzioniHostService getCovenantPerConvenzione: " + e.getMessage(), e);
		}
		return response;
	}

}
