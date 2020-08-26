package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodLinguaEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;

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

	private String tipoStampa;

	@NotNull(message = "Il campo codLingua non può essere null")
	@NotBlank(message = "Il campo codLingua non può essere vuoto")
	private String codLingua;

	@AssertTrue(message = "Il codLingua inserito non è previsto.")
	@JsonIgnore
	public boolean isValidCodLingua() {
		return (CodLinguaEnum.ITALIANO.toString().equals(codLingua)
						|| CodLinguaEnum.TEDESCO.toString().equals(codLingua)
						|| CodLinguaEnum.INGLESE.toString().equals(codLingua)
						|| CodLinguaEnum.FRANCESE.toString().equals(codLingua)
						|| CodLinguaEnum.SPAGNOLO.toString().equals(codLingua));
	}
}
