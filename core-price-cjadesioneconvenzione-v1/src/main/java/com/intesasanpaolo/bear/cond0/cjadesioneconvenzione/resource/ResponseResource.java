package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.Base64Serializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResource {
	
	private Esito esito;
	private String keyOper;
	//@JsonSerialize(using = Base64Serializer.class)
	private String documento;

}
