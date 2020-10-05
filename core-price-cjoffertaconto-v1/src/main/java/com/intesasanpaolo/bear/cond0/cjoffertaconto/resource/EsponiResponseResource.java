package com.intesasanpaolo.bear.cond0.cjoffertaconto.resource;

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
public class EsponiResponseResource extends BaseResource{

	private EsitoResource esito;
	private OffertaResource offerta;
	private List<ProdottoResource> prodotti;
	
	
}
