package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoStampaDTO {
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	private Date Data;
	private String tipoStampa;
	private String tipoOfferta;
	private String tipoFirma;
	private String codLingua;
	private String keyOper;
}
