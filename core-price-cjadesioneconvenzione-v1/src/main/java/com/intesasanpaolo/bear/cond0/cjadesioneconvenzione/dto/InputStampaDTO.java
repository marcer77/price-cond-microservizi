package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputStampaDTO {

	@NotNull(message = "il campo codAppl non puo' essere null")
	@NotBlank(message = "Il campo codAppl non puo' essere vuoto")
	private String codAppl;
	@NotNull(message = "Il campo codProcesso non puo' essere null")
	@NotBlank(message = "Il campo codProcesso non puo' essere vuoto")
	private String codProcesso;
	@NotNull(message = "Il campo pratica non puo' essere vuota!")
	@Valid
	private PraticaDTO pratica;
	@NotNull(message = "Il campo rapporto non puo' essere null")
	@Valid
	private RapportoDTO rapporto;
	@NotNull(message = "Il campo intestatario non puo' essere null")
	@Valid
	private IntestatarioDTO intestatario;
	@NotNull(message = "La lista dei firmatari non puo' essere vuota")
	@Size(min = 1, max = 13)
	private List<@Valid FirmatarioDTO> firmatari;
	@NotNull(message = "Il campo infoStampa non può essere vuoto")
	@Valid
	private InfoStampaDTO infoStampa;

	@AssertTrue(message = "Uno o più formati errati (CodFiliale numerico a 5 cifre, CodCategoria numerico a 4 cifre, CodProgressivo numerico a 8 cifre) per codProcesso CJAFF.")
	@JsonIgnore
	public boolean isValidCampiRapporto() {
		if (CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)) {
			return (rapporto.getCodFiliale() != null && !"".contentEquals(rapporto.getCodFiliale())
					&& StringUtils.isNumeric(rapporto.getCodFiliale()) && rapporto.getCodFiliale().length() == 5

					&& rapporto.getCodCategoria() != null && !"".contentEquals(rapporto.getCodCategoria())
					&& StringUtils.isNumeric(rapporto.getCodCategoria()) && rapporto.getCodCategoria().length() == 4

					&& rapporto.getCodProgressivo() != null && !"".contentEquals(rapporto.getCodProgressivo())
					&& StringUtils.isNumeric(rapporto.getCodProgressivo())
					&& rapporto.getCodProgressivo().length() == 8);
		}
		return true;
	}
}
