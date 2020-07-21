package com.intesasanpaolo.bear.cond0.cjdispositiva.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivaRequestDTO {

	@NotNull(message = "Il campo codAppl non può essere null")
	@NotBlank(message = "Il campo codAppl non può essere vuoto")
	private String codAppl;

	@NotNull(message = "Il campo codProcesso non può essere null")
	@NotBlank(message = "Il campo codProcesso non può essere vuoto")
	private String codProcesso;

	@Valid
	private PraticaDTO praticaDTO;

}
