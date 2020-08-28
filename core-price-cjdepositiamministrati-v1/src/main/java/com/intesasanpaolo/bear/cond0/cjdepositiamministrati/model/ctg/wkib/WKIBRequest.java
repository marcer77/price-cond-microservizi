package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKIBRequest {

	private ISPWebservicesHeaderType ispWebservicesHeaderType;	
	
	private String tipoFunzione;
	private String codAbi;
	private String codDipendente;
	
	private String codFiliale;
	private String codCategoria;
	private String codProgressivo;
	private String attributi;
	
	private String ndg;
	
	private String dataRif;
	private String tipoStampa; // usi futuri
	private String codLingua;
	private String dataFine;
}
