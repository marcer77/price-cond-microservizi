package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKIBResponse {

	private String codErrore;
	private String msgErrore;
	
	private String codDDS;
	private String codTemplate;
	
	private List<WKIBResponseRigheDiStampa> elenco;

}
