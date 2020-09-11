package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib;

import java.util.List;

import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKIBResponse {
	
	private OutEsi outEsi;
	private OutSeg outSeg;

	private String codErrore;
	private String msgErrore;
	
	private String codDDS;
	private String codTemplate;
	
	private List<WKIBResponseRigheDiStampa> elenco;

}
