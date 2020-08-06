package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

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
@ToString
public class PraticaDTO {

	@NotNull(message = "Il campo codSuperPratica non può essere null")
	@NotBlank(message = "Il campo codSuperPratica non può essere vuoto")
	@Pattern(regexp = "[0-9]{10,10}", message = "Il campo codSuperPratica può essere solo numerico con lunghezza 10")
	private String codSuperPratica;
	
	@NotNull(message = "Il campo codPratica non può essere null")
	@NotBlank(message = "Il campo codPratica non può essere vuoto")
	@Pattern(regexp = "[0-9]{10,10}", message = "Il campo codPratica può solo essere numerico con lunghezza 10")
	private String codPratica;
	
	@Pattern(regexp = "[0-9]{13,13}", message = "Il campo codPropostaComm può solo essere numerico con lunghezza 13")
	private String codPropostaComm;
}
