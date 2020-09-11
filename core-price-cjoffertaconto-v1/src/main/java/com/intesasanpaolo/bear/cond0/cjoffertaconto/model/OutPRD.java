package com.intesasanpaolo.bear.cond0.cjoffertaconto.model;

import java.util.List;

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
public class OutPRD {
	private String codCondizione;
	private String descrProdotto;
	private List<OutCPR> outCPRList;

}
