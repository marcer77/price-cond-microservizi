package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PCUJResponse {
	private String livelloSegnalazione;
	private String txtSegnalazione;
	private String mdwEsiAnom;
	private String mdwEsiMsg;
	private String mdwEsiRetc;
	// body
	private String codEsito;
	private String msgEsito;

}
