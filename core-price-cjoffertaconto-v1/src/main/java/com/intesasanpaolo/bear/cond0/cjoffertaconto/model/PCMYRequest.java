package com.intesasanpaolo.bear.cond0.cjoffertaconto.model;

import java.util.List;

import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.INPPRM;
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
public class PCMYRequest {
	
	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	private String codCatRapp;
	private String codFilRapp;
	private String dataRiferimento;
	private String numProgRapp;
	private String funzione;
	
	private String tipoDA;
	
	private List<InPPRM> inList;
	
}
