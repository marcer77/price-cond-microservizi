package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PCUJRequest {
	private ISPWebservicesHeaderType ispWebservicesHeaderType;	
	private String classificCliente;
	private String codCatRapp;
	private String codEvento;
	private String codFilRapp;
	private String codUtente;
	private String dataRiferimento;
	private String filialeOper;
	private Integer nrPratica;
	private Integer nrSuperpratica;
	private String numProgRapp;
	private Integer propostaComm;
	private String subEvento;
	private String tipoFunzione;
}
