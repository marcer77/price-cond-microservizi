package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StampaRequestDTO {

	@NotNull(message = "Il campo codAppl non può essere null")
	@NotBlank(message = "Il campo codAppl non può essere vuoto")
	private String codAppl;
	
	@NotNull(message = "Il campo codProcesso non può essere null")
	@NotBlank(message = "Il campo codProcesso non può essere vuoto")
	private String codProcesso;

	@NotNull(message = "Il campo rapporto non può essere null")
	@Valid private RapportoDTO rapporto;
	
	@NotNull(message = "Il campo intestatario non può essere null")
	@Valid private IntestatarioDTO intestatario;

	@NotNull(message = "Il campo infoStampa non può essere vuoto")
	@Valid private InfoStampaDTO infoStampa;

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

}
