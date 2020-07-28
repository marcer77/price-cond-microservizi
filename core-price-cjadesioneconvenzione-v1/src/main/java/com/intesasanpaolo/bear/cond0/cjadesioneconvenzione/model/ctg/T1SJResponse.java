package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg;

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
public class T1SJResponse {
	//private String esito;
	private String mdwEsiAnom;
	private String mdwEsiMsg;
	private String mdwEsiRetc;
	
	private String livelloSegnalazione;
	private String txtSegnalazione;
	
	private String t1SjOKeyOperazione;
	private Double t1SjOProgStampa;
	private String t1SjOReturnCode;
		
}
