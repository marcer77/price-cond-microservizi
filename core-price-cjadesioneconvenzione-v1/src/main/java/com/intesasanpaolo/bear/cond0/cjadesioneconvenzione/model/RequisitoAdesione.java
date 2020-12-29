package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequisitoAdesione {

	private String flRequisito;
	private String cdRequisito;
	private String dsRequisito;
	private String valNumericoRequisito;
	private String valAlfanumericoRequisito;
	
}
