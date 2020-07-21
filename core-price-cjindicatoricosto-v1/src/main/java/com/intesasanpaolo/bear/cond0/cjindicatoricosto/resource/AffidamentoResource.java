package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffidamentoResource {
	private String formaTecnica;
	private String tipoFTecnica;
	private String scadenza;
	private String importo;
	private IndicatoriResource indicatori;

}