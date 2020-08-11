package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg;

import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;

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
public class FL03Response {
	private OutEsi outEsi;
	private OutSeg outSeg;
	private String codAppli;
	private String codErr;
	private String codSottoAppl;
	private String descErr;
	private String formatoStr;
	private String idTemplate;
	private String keyOper;
	private String numRapporto;
	private String stringaOut;
	private String rc;

}
