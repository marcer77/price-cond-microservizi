package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AffidamentoResource {
	private String formaTecnica;
	private String tipoFTecnica;
	private String descFTecnica;
	private String scadenza;
	private String importo;
	private String divisa;
	private String importoEUR;
	private RapportoResource rapporto;
	
	private IndicatoriResource indicatori;

}
