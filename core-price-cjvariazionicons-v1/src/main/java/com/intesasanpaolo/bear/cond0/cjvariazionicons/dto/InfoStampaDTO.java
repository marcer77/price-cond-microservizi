package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoStampaDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@NotNull(message = "Il campo data non può essere vuoto")
	private Date data;

	@NotNull(message = "Il campo tipoStampa non può essere null")
	@NotBlank(message = "Il campo tipoStampa non può essere vuoto")
	private String tipoStampa;

	private String tipoOfferta;

	private String tipoFirma;

	@NotNull(message = "Il campo codLingua non può essere null")
	@NotBlank(message = "Il campo codLingua non può essere vuoto")
	private String codLingua;

	@NotNull(message = "Il campo keyOper non può essere null")
	@NotBlank(message = "Il campo keyOper non può essere vuoto")
	@Pattern(regexp = "^.{30,30}", message = "Il campo keyOper deve avere lunghezza 30")
	private String keyOper;
}
