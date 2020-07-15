package com.intesasanpaolo.bear.cond0.cjvariazionicons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FL03Response {
	
	private String livelloSegnalazione;
	private String txtSegnalazione;
	private String mdwEsiAnom;
	private String mdwEsiMsg;
	private String mdwEsiRetc;
	private String codAppli;
	private String codErr;
	private String codSottoAppl;
	private String descErr;
	private String formatoStr;
	private String idTemplate;
	private String keyOper;
	private String numRapporto;
	private String stringaOut;

}
