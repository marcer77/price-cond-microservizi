package com.intesasanpaolo.bear.cond0.cjdispositiva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdesioneEntity {

	private String codConvenzione;
	private String intestatarioNDG;
	private String intestatazione ;
	private String intestatarioSpecieGiur;
	private String intestatarioCodFiscale;
	private String intestatarioPIVA;
	private String rapportoCodFiliale;
	private String rapportoCodCategoria;
	private String rapportoCodProgressivo;
	private String infoStampaData;
	private String infoStampakeyOper;


}
