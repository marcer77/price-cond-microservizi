package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intesasanpaolo.bear.core.resource.BaseResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequisitiAdesioneResponseResource extends BaseResource {

	private String cdEsito;
	private String dsErrore;
	private Long nrRequisiti;
	private List<RequisitoResource> listaRequisiti;

}
