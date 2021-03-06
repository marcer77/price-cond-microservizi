package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intesasanpaolo.bear.core.resource.BaseResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StampaResponseResource extends BaseResource{
	
	@JsonProperty("esito")
	private EsitoStampaResource esitoStampaResource;
	private String keyOper;
	
	//@JsonSerialize(using = Base64Serializer.class)
	private String documento;

}
