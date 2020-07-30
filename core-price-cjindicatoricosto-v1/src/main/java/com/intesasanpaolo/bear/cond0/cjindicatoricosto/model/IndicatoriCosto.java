package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndicatoriCosto {
	private String codErrore;
	private String descErrore;	
	private List<IndicatoriCostoPratica> indicatoriCostoPraticaList;
}
