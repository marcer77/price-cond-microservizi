package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

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
public class RapportoResource {
	private String filiale;
	private String categoria;
	private String numero;
}
