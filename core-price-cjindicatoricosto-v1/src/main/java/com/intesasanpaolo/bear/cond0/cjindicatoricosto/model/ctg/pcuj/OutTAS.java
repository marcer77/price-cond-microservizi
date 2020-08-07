package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutTAS {
	private String codParametro;
	private String dataDeca;
	private String dataDeco;
	private String flUsura;
	private Double percParametro;
	private String segnoValParametro;
	private String segnoValSpread;
	private Double tassoDebitore;
	private Double valParametro;
	private Double valSpread;
	/**
	 * Descrizione recuperata dal database
	 */
	private String descrizioneIndiceDB;

}
