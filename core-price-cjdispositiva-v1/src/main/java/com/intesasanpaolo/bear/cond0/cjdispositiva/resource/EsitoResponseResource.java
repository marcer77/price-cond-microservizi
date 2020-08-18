package com.intesasanpaolo.bear.cond0.cjdispositiva.resource;

import com.intesasanpaolo.bear.core.resource.BaseResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsitoResponseResource extends BaseResource {

	private String codErrore;
	private String descErrore;
	
}
