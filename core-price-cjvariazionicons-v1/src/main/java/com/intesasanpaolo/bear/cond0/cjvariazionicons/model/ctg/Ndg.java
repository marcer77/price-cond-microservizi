package com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

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
public class Ndg {
	private String iNdgIntestatario;
	private String iIntestaz;
	private String iCodFiscale;
	private String iSpecieGiu;
	private String iComuneRes;
	private String iCapRes;
	private String iViaRes;
	private String iFrazione;
	private String iProvRes;
}
