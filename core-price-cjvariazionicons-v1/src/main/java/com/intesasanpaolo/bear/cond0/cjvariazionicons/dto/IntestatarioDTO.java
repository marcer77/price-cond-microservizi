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
public class IntestatarioDTO {

	
	private String codFiliale;
	private String codCategoria;
	private String codProgressivo;
	private String ndg;
	private String intestazione;
	private String specieGiur;
	private String codFiscale;
	private String pIva;
	private List<RecapitoDTO> recapiti;
}
