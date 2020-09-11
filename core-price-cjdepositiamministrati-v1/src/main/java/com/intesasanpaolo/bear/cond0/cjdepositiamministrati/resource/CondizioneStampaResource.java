package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CondizioneStampaResource {
	
	private String codCond;
	private String dataDeco;
	private String descrCond;
	private String valore;
	private String indNota;
	
}
