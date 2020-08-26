package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Valid private PraticaDTO pratica;
	@NotNull(message = "Il campo rapporto non puo' essere null")
	@Valid private RapportoDTO rapporto;
	@NotNull(message = "Il campo intestatario non puo' essere null")
	@Valid private IntestatarioDTO intestatario;
	@NotNull(message = "La lista dei firmatari non puo' essere vuota")
	@Size(min = 1, max = 13)
	private List<@Valid FirmatarioDTO> firmatari;
	@NotNull(message = "Il campo infoStampa non può essere vuoto")
	@Valid private InfoStampaDTO infoStampa;

}
