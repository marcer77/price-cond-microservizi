package com.intesasanpaolo.bear.cond0.cjdispositiva.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivaRequestDTO{

	private String codAppl;
	private String codProcesso;
	@JsonProperty("pratica")
	private PraticaDTO praticaDTO;

}
