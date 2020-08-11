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
public class T1SJResponse {
	private OutEsi outEsi;
	private OutSeg outSeg;
	
	
	private String t1SjOKeyOperazione;
	private Double t1SjOProgStampa;
	private String t1SjOReturnCode;
		
}
