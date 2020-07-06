package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
@AllArgsConstructor
@PackagePrivate
@Builder
public class RapportoDTO {
	
	private String codFiliale;
	private String codCategoria;
	private String codProgressivo;

}
