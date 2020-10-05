package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndicatoriCostoPratica {
	private String pratica;
	private PCUJResponse pcujResponse;
	private WKCJResponse wkcjResponse;
}
