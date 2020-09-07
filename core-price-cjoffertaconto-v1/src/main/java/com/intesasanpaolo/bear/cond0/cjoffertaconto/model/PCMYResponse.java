package com.intesasanpaolo.bear.cond0.cjoffertaconto.model;

import java.util.List;

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
public class PCMYResponse {
	private OutEsi outEsi;
	private OutSeg outSeg;

	private String codEsito;
	private String codOfferta;
	private List<OutOFF> outOffList;
	private List<OutPRD> outPrdList;

}
