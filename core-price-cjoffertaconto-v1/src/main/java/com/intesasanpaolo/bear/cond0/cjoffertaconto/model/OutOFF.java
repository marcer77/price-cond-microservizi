package com.intesasanpaolo.bear.cond0.cjoffertaconto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OutOFF {

	private Double costoListino;
	private Double costoOfferta;
	private String flAgevolato;
	private String decaOfferta;
	private String decoOfferta;

}
