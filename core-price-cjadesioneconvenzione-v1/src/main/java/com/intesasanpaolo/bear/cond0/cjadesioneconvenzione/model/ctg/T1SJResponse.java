package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class T1SJResponse {
	private String esito;
	private String livelloSegnalazione;
	private String txtSegnalazione;
	
	private String t1SjOKeyOperazione;
	private Double t1SjOProgStampa;
	private String t1SjOReturnCode;
		
}
