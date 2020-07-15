package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmatarioDTO {

	@NotNull(message = "Il campo ndg non può essere null")
	@NotBlank(message = "Il campo ndg non può essere vuoto")
	@Pattern(regexp = "[0-9]{13,13}", message = "Il campo ndg può essere solo numerico con lunghezza 13")
	private String ndg;

	@NotNull(message = "Il campo intestazione non può essere null")
	@NotBlank(message = "Il campo intestazione non può essere vuoto")
	@Pattern(regexp = "^.{1,70}", message = "Il campo intestazione può avere lunghezza massima 70")
	private String intestazione;

}
