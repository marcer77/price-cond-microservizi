package com.intesasanpaolo.bear.cond0.cjdispositiva.dto;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivaRequestDTO {

	@NotNull(message = "Il campo codAppl non può essere null")
	@NotBlank(message = "Il campo codAppl non può essere vuoto")
	private String codAppl;

	@NotNull(message = "Il campo codProcesso non può essere null")
	@NotBlank(message = "Il campo codProcesso non può essere vuoto")
	private String codProcesso;

	@Valid
	private PraticaDTO pratica;

	@AssertTrue(message = "Il codAppl inserito non è previsto.")
	@JsonIgnore
	public boolean isValidCodAppl() {
		return (CodApplEnum.CARTE.toString().equals(codAppl) || CodApplEnum.FIDI.toString().equals(codAppl)
				|| CodApplEnum.AREA_FINANZA.toString().equals(codAppl));
	}
	
	@AssertTrue(message = "Il codProcesso inserito non è previsto.")
	@JsonIgnore
	public boolean isValidCodProcesso() {
		return (CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString().equals(codProcesso)
						|| CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)
						|| CodProcessoEnum.CJ_CUI_DA.toString().equals(codProcesso));
	}
	
	@AssertTrue(message = "CodPratica assente o formato errato (previso numerico con lunghezza 10) per codProcesso CJDA.")
	@JsonIgnore
	public boolean isValidCodPratica() {
		if(CodProcessoEnum.CJ_CUI_DA.toString().equals(codProcesso)) {
			return (
					pratica!=null 
					&& pratica.getCodPratica()!=null 
					&& !"".contentEquals(pratica.getCodPratica())
					&& StringUtils.isNumeric(pratica.getCodPratica())
					&& pratica.getCodPratica().length()==10
				);
		}
		return true;
	}
}
