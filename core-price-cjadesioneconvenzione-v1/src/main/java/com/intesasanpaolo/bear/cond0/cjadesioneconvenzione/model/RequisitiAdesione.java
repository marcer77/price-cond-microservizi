package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import java.util.List;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequisitiAdesione {

	private String cdEsito;
	private String dsErrore;
	private Long nrRequisiti;
	private List<RequisitoAdesione> listaRequisiti;
	
}
