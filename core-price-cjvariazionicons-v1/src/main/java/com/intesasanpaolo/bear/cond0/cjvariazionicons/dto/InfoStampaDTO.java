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
	@NotNull(message = "Il campo data non può essere vuoto!")
	private Date data;

	@NotNull(message = "Il campo tipoStampa non può essere vuoto!")
	@NotBlank(message = "Il campo tipoStampa non può essere stringa vuota!")
	private String tipoStampa;

	@NotNull(message = "Il campo tipoOfferta non può essere vuoto!")
	@NotBlank(message = "Il campo tipoOfferta non può essere stringa vuota!")
	private String tipoOfferta;

	@NotNull(message = "Il campo tipoFirma non può essere vuoto!")
	@NotBlank(message = "Il campo tipoFirma non può essere stringa vuota!")
	private String tipoFirma;

	@NotNull(message = "Il campo codLingua non può essere vuoto!")
	@NotBlank(message = "Il campo codLingua non può essere stringa vuota!")
	private String codLingua;

	@NotNull(message = "Il campo keyOper non può essere vuoto!")
	@NotBlank(message = "Il campo keyOper non può essere stringa vuota!")
	@Pattern(regexp = "^.{30,30}", message = "Il campo keyOper deve avere lunghezza 30")
	private String keyOper;
}
