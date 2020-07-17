package com.intesasanpaolo.bear.cond0.cjvariazionicons.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.Base64Serializer;
import com.intesasanpaolo.bear.core.resource.BaseResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StampaResponseResource extends BaseResource{
	
	private EsitoStampaResource esitoStampaResource;
	private String keyOper;
	
	@JsonSerialize(using = Base64Serializer.class)
	private String documento;

}