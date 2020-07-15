package com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class T1SFResponse {
	private String esito;
	private String oLivelloSegnalazione;
	private String oTxtSegnalazione;
	private String oReturnCode;
	private String oKeyOperazione;
	
}
