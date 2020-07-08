package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorT1SF;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SFServiceBS extends BaseService{

	@Autowired
	private CTGConnectorT1SF ctgConnectorT1SF;
	
	public ResponseResource test(InputStampaDTO inputStampaDTO) throws Exception {
		/*inputStampaDTO.getPratica().getCodPratica();
		inputStampaDTO.getPratica().getCodSuperPratica();
		inputStampaDTO.getPratica().getCodPropostaComm();
		inputStampaDTO.getRapporto().getCodCategoria();
		inputStampaDTO.getRapporto().getCodFiliale();
		inputStampaDTO.getRapporto().getCodProgressivo();
		inputStampaDTO.getInfoStampa().getCodLingua(); //I_COD_LINGUA
		inputStampaDTO.getInfoStampa().getKeyOper();   //I_KEY_OPERAZIONE
		inputStampaDTO.getFirmatari().get(0).G
		*/
		ResponseResource responseResource= this.ctgConnectorT1SF.call(inputStampaDTO);
		return responseResource;
		
	}

/*
INPUT_DESCRIPTION
INPBST
I_FUNZIONE
I_COD_LINGUA         X
I_COD_FIL_RAPP       X
I_COD_CAT_RAPP       X
I_NUM_PROG_RAPP      X
I_CQ_FIL_RAPP
I_CQ_CAT_RAPP           
I_CQ_NUM_RAPP
I_PROPOSTA_USURA
I_TIPO_FT
I_COD_FT
I_IMPORTO_FIDO
I_DIVISA_FIDO
I_DATA_DECORRENZA_FIDO
I_DATA_SCADENZA_FIDO
I_PROG_FIDO
I_DATA_RIFERIMENTO
I_KEY_OPERAZIONE         X
I_TIPO_OFFERTA
I_NR_SUPERPRATICA   	X
I_NR_PRATICA   			X
I_PROPOSTA_COMM   		X
I_FIRMA

OUTPUT_DESCRIPTION

OUTBST
O_RETURN_CODE
O_KEY_OPERAZIONE*/
}
