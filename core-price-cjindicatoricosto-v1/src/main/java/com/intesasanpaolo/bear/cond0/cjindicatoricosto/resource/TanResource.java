package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TanResource {
	private String valore;
	private String flUsura;
	private ParametriResource parametri;
}
