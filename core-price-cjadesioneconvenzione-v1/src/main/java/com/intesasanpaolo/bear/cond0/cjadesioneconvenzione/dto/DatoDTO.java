package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatoDTO {

	@NotNull(message = "Il campo cdTipoDato non può essere null")
	@NotBlank(message = "Il campo cdTipoDato non può essere vuoto")
	private String cdTipoDato;

	@NotNull(message = "Il campo valDato non può essere null")
	@NotBlank(message = "Il campo valDato non può essere vuoto")
	private String valDato;

}
