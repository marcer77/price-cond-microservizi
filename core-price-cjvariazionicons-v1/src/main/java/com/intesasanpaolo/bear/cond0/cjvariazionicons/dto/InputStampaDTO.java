package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import java.util.List;

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

	private String codAppl;
	@NotNull(message = "Il campo codProcesso non può essere vuoto!")
	@NotBlank(message = "Il campo codProcesso non può essere stringa vuota!")
	private String codProcesso;
	@NotNull(message = "Il campo pratica non può essere vuota!")
	private PraticaDTO pratica;
	@NotNull(message = "Il campo rapporto non può essere vuoto!")
	private RapportoDTO rapporto;
	@NotNull(message = "Il campo intestatario non può essere vuoto!")
	private IntestatarioDTO intestatario;
	@NotNull(message = "La lista dei firmatari non può essere vuota!")
	@Size(min = 1, max = 13)
	private List<FirmatarioDTO> firmatari;
	@NotNull(message = "Il campo infoStampa non può essere vuota!")
	private InfoStampaDTO infoStampa;

}
