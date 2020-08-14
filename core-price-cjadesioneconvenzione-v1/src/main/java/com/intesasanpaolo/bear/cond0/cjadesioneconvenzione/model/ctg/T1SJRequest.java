package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg;

import java.util.List;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class T1SJRequest {

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	private String  t1SjICapRes;
	private String  t1SjIChiamante;
	private String  t1SjICodCatRapp;
	private String  t1SjICodFilRapp;
	private String  t1SjICodFiscale;
	private String  t1SjICodUtente;
	private String  t1SjICodiceLingua;
	private String  t1SjIComuneRes;
	private String  t1SjIDataRiferimento;
	private String  t1SjIFilialeOper;
	private String  t1SjIFirma;
	private String  t1SjIFrazione;
	private String  t1SjIIntestaz;
	private String  t1SjIKeyOperazione;
	private String  t1SjINdgIntestatario;
	private String  t1SjINrPratica;
	private String  t1SjINrSuperpratica;
	private String  t1SjINumProgRapp;
	private Double  t1SjIProgStampa;
	private String  t1SjIPropostaComm;
	private String  t1SjIProvRes;
	private String  t1SjISpecieGiu;
	private String  t1SjITipoOfferta;
	private String  t1SjITipoStampa;
	private String  t1SjIViaRes;
	private String  t1SjIFunzione;
	
	
	private List<InpNDG> inpNDGList;
	

}
