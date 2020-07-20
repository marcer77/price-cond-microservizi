package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKCJRequest {

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	private String ambitoQ;
	private String attribBpay;
	private String catRapp;
	private String catRappAppo;
	private String catRappBpay;
	private String catSecRapAppo;
	private String catSecRapp;
	private String dataRifer;

	private String dtDecoRapp;
	private String filRapp;
	private String filRappAppo;
	private String filRappBpay;
	private String flBpay;
	private String lingua;
	private String ndg;
	private String nroRapp;
	private String nroRappAppo;
	private String nroRappBpay;

	private String partitaRapp;
	private String pratica;
	private String settRapp;
	private String settRappAppo;
	private String superpratica;
	private String terminale;
	private String tipoChiamata;
	private String tipoStampa;
	private String utente;

}
