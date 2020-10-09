package com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.TipoRichiestaEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatoriCostoDTO {
	
	@NotNull(message = "Il campo codAppl non può essere null")
	@NotBlank(message = "Il campo codAppl non può essere vuoto")
	private String codAppl;
	
	@NotNull(message = "Il campo codProcesso non può essere null")
	@NotBlank(message = "Il campo codProcesso non può essere vuoto")
	private String codProcesso;
	
	@Valid
	private PraticaDTO pratica;
	
	@NotNull(message = "Il campo richiesta non può essere null")
	@NotBlank(message = "Il campo richiesta non può essere vuoto")
	private String richiesta;
	
	@Valid
	private EventoDTO evento;
	
	//@NotNull(message = "Il campo classificazione non può essere null")
	//@NotBlank(message = "Il campo classificazione non può essere vuoto")
	private String classificazione;

	@AssertTrue(message = "Il codAppl inserito non è previsto.")
	@JsonIgnore
	public boolean isValidCodAppl() {
		return (CodApplEnum.CARTE.toString().equals(codAppl) || CodApplEnum.FIDI.toString().equals(codAppl)
				|| CodApplEnum.AREA_FINANZA.toString().equals(codAppl));
	}
	
	@AssertTrue(message = "Il codProcesso inserito non è previsto.")
	@JsonIgnore
	public boolean isValidCodProcesso() {
		return (CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString().equals(codProcesso)
						|| CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)
						|| CodProcessoEnum.CJ_CUI_DA.toString().equals(codProcesso));
	}
	
	@AssertTrue(message = "La richiesta inserita non è prevista.")
	@JsonIgnore
	public boolean isValidRichiesta() {
		return (TipoRichiestaEnum.CALCOLA.toString().equals(richiesta)
						|| TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString().equals(richiesta));
	}

}
