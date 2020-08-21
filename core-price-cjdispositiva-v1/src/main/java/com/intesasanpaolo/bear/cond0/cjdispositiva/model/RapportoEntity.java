package com.intesasanpaolo.bear.cond0.cjdispositiva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RapportoEntity {

	private String filiale;
	private String categoria;
	private String numero;
}
