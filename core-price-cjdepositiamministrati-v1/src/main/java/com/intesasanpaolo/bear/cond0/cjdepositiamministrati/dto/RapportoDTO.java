package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapportoDTO {
	
	@NotNull(message = "Il campo codFiliale non può essere null")
	@NotBlank(message = "Il campo codFiliale non può essere vuoto")
	@Pattern(regexp = "[0-9]{5,5}", message = "Il campo codFiliale può solo numerico con lunghezza 5")
	private String codFiliale;
	
	@NotNull(message = "Il campo codCategoria non può essere null")
	@NotBlank(message = "Il campo codCategoria non può essere vuoto")
	@Pattern(regexp = "[0-9]{4,4}", message = "Il campo codCategoria può solo essere solo numerico con lunghezza 4")
	private String codCategoria;
	
	@NotNull(message = "Il campo codProgressivo non può essere vuoto!")
	@NotBlank(message = "Il campo codProgressivo non può essere stringa vuota!")
	@Pattern(regexp = "[0-9]{8,8}", message = "Il campo codProgressivo può essere solo numerico con lunghezza 8")
	private String codProgressivo;
	
//	@NotNull(message = "Il campo attributo non può essere vuoto!")
//	@NotBlank(message = "Il campo attributo non può essere stringa vuota!")
	private String attributo;

}
