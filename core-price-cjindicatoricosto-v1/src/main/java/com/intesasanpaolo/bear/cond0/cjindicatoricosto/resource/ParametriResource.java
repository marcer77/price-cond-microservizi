package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParametriResource {
	private String valoreIndice;
	private String descIndice;
	private String percApplic;
	private String segnoSpread;
	private String valoreSpread;
	
}
