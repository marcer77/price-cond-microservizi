package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PraticaResource {
	private String codPratica;
	private List<AffidamentoResource> affidamenti;
	private List<CondizioneResource> condizioni;
	
}
