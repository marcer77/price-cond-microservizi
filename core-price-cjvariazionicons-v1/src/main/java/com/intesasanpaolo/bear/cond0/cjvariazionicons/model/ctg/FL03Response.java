package com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg;

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
	private String rc;

}
