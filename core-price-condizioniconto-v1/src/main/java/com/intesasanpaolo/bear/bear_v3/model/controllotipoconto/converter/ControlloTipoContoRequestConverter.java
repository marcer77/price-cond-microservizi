package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.converter;

import java.util.HashMap;

import javax.transaction.SystemException;

import com.intesasanpaolo.bear.bear_v3.command.CondizioniContoUtils;
import com.intesasanpaolo.bear.bear_v3.dto.utils.StrUtils;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoRequest;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestBody;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestHeader;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestHostBridge;

public class ControlloTipoContoRequestConverter {
	
	public RequestHostBridge to(ControlloTipoContoRequest request, String cdIstituto) throws SystemException {
		RequestHostBridge requestHostBridge = new RequestHostBridge();
		requestHostBridge.body = convertRequestBody(request);
		requestHostBridge.header = convertRequestHeader(request, cdIstituto);
		return requestHostBridge;
	}
	
	private RequestBody convertRequestBody(ControlloTipoContoRequest request) throws SystemException {
		RequestBody requestBody = new RequestBody();
		requestBody.PCMM_I_COD_PRODOTTO = request.getCdPrdotto();
		if (StrUtils.isNullOrEmpty(request.getCdFunzione())){
			throw new SystemException("Codice funzione obbligatorio");
		}
		requestBody.PCMM_I_TIPO_FUNZIONE = request.getCdFunzione();
		requestBody.PCMM_I_FLG_FIL_AMICA = request.getCdFilialeAmica();
		requestBody.PCMM_I_NUM_MAX_LISTINI = 100;
		requestBody.PCMM_I_RICERCA_CONV = request.getCdRicercaConv();
		requestBody.PCMM_I_RICERCA_VAL_RAPP = request.getCdRicercaValRapp();
		requestBody.PCMM_I_DATA_DECORRENZA = request.getDtDecorrenza() == null || request.getDtDecorrenza().isEmpty() ? CondizioniContoUtils.today_yyyyMMdd(): request.getDtDecorrenza();
		if (StrUtils.isNullOrEmpty(request.getCdRapporto())) {
			throw new SystemException("Codice rapporto obbligatorio"); 
		}
		if (request.getCdRapporto().length() == 17) {
			HashMap<String,String> infoRapporto = CondizioniContoUtils.getInfoRapporto(request.getCdRapporto());
			requestBody.PCMM_I_COD_CAT_RAPP = infoRapporto.get(CondizioniContoUtils.RAPP_CATEGORIA);
			requestBody.PCMM_I_COD_FIL_RAPP = infoRapporto.get(CondizioniContoUtils.RAPP_FILIALE);
			requestBody.PCMM_I_NUM_PROG_RAPP = infoRapporto.get(CondizioniContoUtils.RAPP_CONTO);
		}else {
			throw new SystemException("Il codice rapporto deve essere di 17 caratteri.");
		}
		return requestBody;
	}
	
	private RequestHeader convertRequestHeader(ControlloTipoContoRequest request, String cdIstituto) throws SystemException {
		if (StrUtils.isNullOrEmpty(request.getCdMatricola())) {
			throw new SystemException("Matricola obbligatoria.");
		}
		RequestHeader requestHeader = new RequestHeader();
		requestHeader.setCOD_RICH_CANALE("44");
		requestHeader.setID_SERVIZIO("PCMMINCMOD"); 
		requestHeader.setDATA_CONT(CondizioniContoUtils.today_ddMMyyyy()); // data odierna
		requestHeader.setCOD_ABI(request.getCdAbi());
		requestHeader.setCODICE_TIPO_CANALE("44");
		requestHeader.setCODICE_SOCIETA(cdIstituto);
		requestHeader.setCODICE_USERID(request.getCdMatricola()); // da modificare
		return requestHeader;
	}

}
