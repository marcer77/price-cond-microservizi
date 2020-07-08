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
public class RecapitoDTO{
	
	@NotNull(message = "Il campo tipo non può essere null")
	@NotBlank(message = "Il campo tipo non può essere vuoto")
	private String tipo;
	
	@NotNull(message = "Il campo indirizzo non può essere null")
	@NotBlank(message = "Il campo indirizzo non può essere vuoto")
	private String indirizzo;
	
	@Pattern(regexp = "[0-9]{5,5}", message = "Il campo cap può essere solo numerico con lunghezza 5")
	private String cap;
	
	@NotNull(message = "Il campo comune non può essere null")
	@NotBlank(message = "Il campo comune non può essere vuoto")
	@Pattern(regexp = "^.{0,32}", message = "Il campo comune può avere lunghezza massima 32")
	private String comune;
	
	@Pattern(regexp = "^.{0,25}", message = "Il campo frazione può avere lunghezza massima 25")
	private String frazione;
	
	@NotNull(message = "Il campo provincia non può essere null")
	@NotBlank(message = "Il campo provincia non può essere vuoto")
	@Pattern(regexp = "^.{2,2}", message = "Il campo provincia può essere solo numerico con lunghezza 2")
	private String provincia;
}
