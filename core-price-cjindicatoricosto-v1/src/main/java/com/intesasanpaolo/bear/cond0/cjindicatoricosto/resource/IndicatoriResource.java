package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndicatoriResource {
	private String cdf;
	private String taeg;
	private String teg;
	private TanResource tan;
}
