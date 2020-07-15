package com.intesasanpaolo.bear.cond0.cjvariazionicons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StampaResponse {

	private EsitoStampa esitoStampa;
	private String keyOper;
	private String documento;
}
