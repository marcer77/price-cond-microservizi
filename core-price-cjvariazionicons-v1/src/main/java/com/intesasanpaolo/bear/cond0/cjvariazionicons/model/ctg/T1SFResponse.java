package com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg;

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
public class T1SFResponse {
	private OutEsi outEsi;
	private OutSeg outSeg;
	private String oReturnCode;
	private String oKeyOperazione;
	
}
