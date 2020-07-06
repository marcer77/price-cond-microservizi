package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
@AllArgsConstructor
@PackagePrivate
@Builder
public class RecapitoDTO{

	
	private String codSuperPratica;
	private String codPratica;
	private String codPropostaComm;
	private String tipo;
	private String indirizzo;
	private String cap;
	private String comune;
	private String frazione;
	private String provincia;
}
