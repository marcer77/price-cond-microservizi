package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import java.util.ArrayList;
import java.util.List;

import com.intesasanpaolo.bear.core.resource.BaseResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndicatoriCostoResource extends BaseResource{

	private EsitoResource esito;
	@Builder.Default
	private List<PraticaResource> pratica=new ArrayList<>();
	
	
}
