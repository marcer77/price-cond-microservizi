package com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatoriCostoDTO {
	private String codAppl;
	private String codProcesso;
	private String richiesta;
	private String classificazione;
	private PraticaDTO pratica;
	private EventoDTO evento;

}
