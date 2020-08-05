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
	private String nrPratica;
	private String nrSuperpratica;
	private String numProgRapp;
	private String propostaComm;
	private String subEvento;
	private String tipoFunzione;
}
