package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import org.apache.commons.lang3.builder.Builder;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;

public class InfoCovenantBuilder implements Builder<String> {
	
	private RespGetCovenantPerConvenzioneCovenantDaAttivare infoConvenant;

	public InfoCovenantBuilder(RespGetCovenantPerConvenzioneCovenantDaAttivare infoConvenant) {
		this.infoConvenant = infoConvenant;
	}
	
	@Override
	public String build() {
		return 
		infoConvenant.getBeneficioCondizionatoDataFine()+
		infoConvenant.getBeneficioCondizionatoDataInizio();
	}

}
