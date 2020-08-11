package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import java.util.List;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdesioneConvenzione {
	//private String codiceConvenzione;
	private String codSuperPratica;
	private String codPratica;
	private String codAbi;
	private List<TB59R009> tb59r009List;
}
