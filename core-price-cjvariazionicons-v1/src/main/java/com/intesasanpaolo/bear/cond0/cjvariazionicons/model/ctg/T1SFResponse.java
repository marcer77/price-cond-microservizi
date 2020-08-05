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
public class T1SFResponse {
	private String mdwEsiAnom;
	private String mdwEsiMsg;
	private String mdwEsiRetc;
	private String oLivelloSegnalazione;
	private String oTxtSegnalazione;
	private String oReturnCode;
	private String oKeyOperazione;
	
}
