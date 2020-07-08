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
public class PraticaDTO {

	@NotNull(message = "Il campo codSuperPratica non può essere vuoto!")
	@NotBlank(message = "Il campo codSuperPratica non può essere stringa vuota!")
	@Pattern(regexp = "[0-9]{13,13}", message = "Il campo codSuperPratica può solo numerico con lunghezza 13")
	private String codSuperPratica;
	
	@NotNull(message = "Il campo codPratica non può essere vuoto!")
	@NotBlank(message = "Il campo codPratica non può essere stringa vuota!")
	@Pattern(regexp = "[0-9]{13,13}", message = "Il campo codPratica può solo numerico con lunghezza 13")
	private String codPratica;
	
	private String codPropostaComm;
}
