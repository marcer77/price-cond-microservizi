package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputStampaDTO {
	
	private String codAppl;
	private String codProcesso;
	private PraticaDTO pratica;
	private RapportoDTO rapporto;
	private IntestatarioDTO intestatario;
	private List<FirmatarioDTO> firmatari;
	private InfoStampaDTO infoStampa;

}
