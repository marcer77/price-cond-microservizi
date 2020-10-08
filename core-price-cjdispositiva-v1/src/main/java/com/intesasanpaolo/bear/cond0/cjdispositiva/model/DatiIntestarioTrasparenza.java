package com.intesasanpaolo.bear.cond0.cjdispositiva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class DatiIntestarioTrasparenza {
	private String trasparenzaNDG;
	private String trasparenzaFiliale;
	private String trasparenzaCategoria;
	private String trasparenzaNumRapp;
	private String trasparenzaDataRiferimento;
}
