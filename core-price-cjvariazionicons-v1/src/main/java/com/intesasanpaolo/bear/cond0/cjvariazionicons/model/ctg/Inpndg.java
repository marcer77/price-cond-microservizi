package com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg;

import java.util.List;

import javax.validation.Valid;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.FirmatarioDTO;

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
public class Inpndg {
	
	private List<String> iNdgFirma;
	private List<String> iIntestazFirma;
	
}
