package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputRequisitiAdesioneDTO {

	@NotNull(message = "il campo cdAbi non puo' essere null")
	@NotBlank(message = "Il campo cdAbi non puo' essere vuoto")
	private String cdAbi;
	@NotNull(message = "Il campo cdNDG non puo' essere null")
	@NotBlank(message = "Il campo cdNDG non puo' essere vuoto")
	private String cdNDG;

	private String cdFilialeRapp;
	private String cdCategoriaRapp;
	private String cdNumeroRapp;

	@NotNull(message = "Il campo cdConvenzione non puo' essere null")
	@NotBlank(message = "Il campo cdConvenzione non puo' essere vuoto")
	private String cdConvenzione;
	@NotNull(message = "Il campo cdChiamata non puo' essere null")
	@NotBlank(message = "Il campo cdChiamata non puo' essere vuoto")
	private String cdChiamata;
	@NotNull(message = "Il campo dtRiferimento non puo' essere null")
	@NotBlank(message = "Il campo dtRiferimento non puo' essere vuoto")
	private String dtRiferimento;	
	@NotNull(message = "Il campo cdUtente non puo' essere null")
	@NotBlank(message = "Il campo cdUtente non puo' essere vuoto")
	private String cdUtente;
	@NotNull(message = "Il campo cdApplicazione non puo' essere null")
	@NotBlank(message = "Il campo cdApplicazione non puo' essere vuoto")
	private String cdApplicazione;
	@NotNull(message = "Il campo flTipoCliente non puo' essere null")
	@NotBlank(message = "Il campo flTipoCliente non puo' essere vuoto")
	private String flTipoCliente;
	@NotNull(message = "Il campo nrDati non puo' essere null")
	private Long nrDati;	
	private List<DatoDTO> listaDati;

}
