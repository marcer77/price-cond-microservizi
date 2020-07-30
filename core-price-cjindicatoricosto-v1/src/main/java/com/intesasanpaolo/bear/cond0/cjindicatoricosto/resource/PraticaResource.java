package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PraticaResource {
	private String codPratica;
	private List<AffidamentoResource> affidamenti;
	private List<CondizioneResource> condizioni;
	
}
