package com.intesasanpaolo.bear.cond0.cjoffertaconto.resource;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValoriOffertaResource {
	
	private String decorrenza;
	private String scadenza;
	private String costo;
	private String flAgevolato;
	private String costoListino;

}
