package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class IntestatarioDTO {

	@NotNull(message = "Il campo ndg non può essere null")
	@NotBlank(message = "Il campo ndg non può essere vuoto")
	@Pattern(regexp = "[0-9]{13,13}", message = "Il campo ndg può solo numerico con lunghezza 13")
	private String ndg;

	@NotNull(message = "Il campo intestazione non può essere null")
	@NotBlank(message = "Il campo intestazione non può essere vuoto")
	@Pattern(regexp = "^.{1,70}", message = "Il campo intestazione può avere lunghezza massima 70")
	private String intestazione;

	@Pattern(regexp = "^$|^.{1,5}", message = "Il campo specieGiur può avere lunghezza massima 5")
	private String specieGiur;

	@Pattern(regexp = "^$|^([A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1})|([0-9]{11})$", message = "CodFiscale non valido.")
	private String codFiscale;

	@Pattern(regexp = "^$|[0-9]{11,11}", message = "Il campo pIva deve avere lunghezza 11")
	private String pIva;

	@NotNull(message = "La lista dei recapiti non può essere vuota")
	@Size(min = 1)
	private List<@Valid RecapitoDTO> recapiti;
	
	//Controlla se specieGiur, codFiscale, pIva è valorizzato
	@AssertTrue(message="Valorizzare almeno uno di questi campi: specieGiur, codFiscale, pIva")
	@JsonIgnore
	public boolean isValidIdentificativoIntestatario() {
	    return !( StringUtils.isEmpty(specieGiur)
	            && StringUtils.isEmpty(codFiscale)
	            && StringUtils.isEmpty(pIva));
	}
	
}
