package com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
	
	@NotNull(message = "Il campo codice non può essere null")
	@NotBlank(message = "Il campo codice non può essere vuoto")
	private String codice; 
	@NotNull(message = "Il campo subCodice non può essere null")
	@NotBlank(message = "Il campo subCodice non può essere vuoto")
	private String subCodice; 
}
