package com.intesasanpaolo.bear.cond0.cjvariazionicons.model;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class T1SFRequest {

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	private String iCodCatRapp;
	private String iCodFilRapp;
	private String iCodFT;
	private String iCodLingua;
	private String iCQCatRapp;
	private String iCQFilRapp;
	private String iCQNumRapp;
	private String iDataDecorrenzaFido;
	private String iDataRiferimento;
	private String iDataScadenzaFido;
	private String iDivisaFido;
	private String iFirma;
	private String iFunzione;
	private Double iImportoFido;
	private String iKeyOperazione;
	private Integer iNrPratica;
	private Integer iNrSuperPratica;
	private String iNumProgRapp;
	private Integer iProgFido;
	private Integer iPropostaComm;
	private String iPropostaUsura;
	private String iTipoFT;
	private String iTipoOfferta;

}
