package com.intesasanpaolo.bear.cond0.cjoffertaconto.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
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
public class InputEsponiDTO {
	
	@NotNull(message = "il campo codAppl non puo' essere null")
	@NotBlank(message = "Il campo codAppl non puo' essere vuoto")
	@Pattern(regexp = "(X | F | D)", message = "Il campo codAppl puo' assumere solo i valori X, F, D")
	private String codAppl;
	
	@NotNull(message = "Il campo codProcesso non può essere null")
	@NotBlank(message = "Il campo codProcesso non può essere vuoto")
	private String codProcesso;
	
	@Valid private RapportoDTO rapporto;
	
	@NotNull(message = "il campo tipoDA non puo' essere null")
	@NotBlank(message = "Il campo tipoDA non puo' essere vuoto")
	@Pattern(regexp = "(CU | GA)", message = "Il campo codAppl puo' assumere solo i valor CU, GA")
	private String tipoDA;
	
	@Valid private List<PromozioniDTO> promozioni;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	private Date dataRif;
 

}
