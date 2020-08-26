package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@ToString
public class IntestatarioDTO {

	@NotNull(message = "Il campo ndg non può essere null")
	@NotBlank(message = "Il campo ndg non può essere vuoto")
	@Pattern(regexp = "[0-9]{13,13}", message = "Il campo ndg può solo numerico con lunghezza 13")
	private String ndg;

	@Pattern(regexp = "^.{1,70}", message = "Il campo intestazione può avere lunghezza massima 70")
	private String intestazione;

	@Pattern(regexp = "^$|^.{1,5}", message = "Il campo specieGiur può avere lunghezza massima 5")
	private String specieGiur;
	
}
