package com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource;

import java.util.ArrayList;
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
	@Builder.Default
	private List<AffidamentoResource> affidamenti=new ArrayList<>();
	@Builder.Default
	private List<CondizioneResource> condizioni=new ArrayList<>();
	
}
