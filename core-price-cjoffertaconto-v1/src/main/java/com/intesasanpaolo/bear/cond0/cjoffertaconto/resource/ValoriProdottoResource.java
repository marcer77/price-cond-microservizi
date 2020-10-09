package com.intesasanpaolo.bear.cond0.cjoffertaconto.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValoriProdottoResource {

	private String decorrenza;
	private String scadenza;
	private String costo;
	private String flPromo;
	private String costoPromo;
	private String flAcceso;
}
