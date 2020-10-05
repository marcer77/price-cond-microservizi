package com.intesasanpaolo.bear.cond0.cjdispositiva.dto;

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
	
	@NotNull(message = "Il campo codSuperPratica non pu� essere null")
	@NotBlank(message = "Il campo codSuperPratica non pu� essere vuoto")
	@Pattern(regexp = "[0-9]{10,10}", message = "Il campo codSuperPratica pu� essere solo numerico con lunghezza 10")
	private String codSuperPratica;
	
	@NotNull(message = "Il campo codPratica non pu� essere null")
	@NotBlank(message = "Il campo codPratica non pu� essere vuoto")
	@Pattern(regexp = "[0-9]{10,10}", message = "Il campo codPratica pu� essere solo numerico con lunghezza 10")
	private String codPratica;
	
	private String codPropostaComm;
	
}
