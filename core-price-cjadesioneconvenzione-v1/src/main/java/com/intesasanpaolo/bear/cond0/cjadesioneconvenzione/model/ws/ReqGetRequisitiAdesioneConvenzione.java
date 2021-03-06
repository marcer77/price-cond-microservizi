package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqGetRequisitiAdesioneConvenzione {
	
	private String abi;
	private String applicativoId;
	private String codiceConvenzione;
	private String dataAccensione;
	private String dataAdesione;
	private String filiale;
	private String flagTipoCliente;
	private List<String> codiciFiscali; 
	private String ndg;
	private String pIva;
	private String rol;
	private String rapportoCategoria;
	private String rapportoCategoriaStipendio;
	private String rapportoCodice;
	private String rapportoCodiceStipendio;
	private String rapportoFiliale;
	private String rapportoFilialeStipendio;
	private String rating;
	private String tipoChiamata;
	private String userId;

}
