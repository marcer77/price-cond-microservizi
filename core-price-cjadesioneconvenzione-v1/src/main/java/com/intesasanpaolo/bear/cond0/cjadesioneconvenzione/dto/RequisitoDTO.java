package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequisitoDTO {

	@NotNull(message = "Il campo cdTipoRequisito non può essere null")
	@NotBlank(message = "Il campo cdTipoRequisito non può essere vuoto")
	private String cdTipoRequisito;

	@NotNull(message = "Il campo valRequisito non può essere null")
	@NotBlank(message = "Il campo valRequisito non può essere vuoto")
	private String valRequisito;

}
