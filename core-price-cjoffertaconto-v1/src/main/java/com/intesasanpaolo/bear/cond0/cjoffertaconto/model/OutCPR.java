package com.intesasanpaolo.bear.cond0.cjoffertaconto.model;

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
public class OutCPR {
	private Double costoProdotto;
	private Double costoProdottoPRM;
	private String decaProdotto;
	private String decoProdotto;
	private String flgProdotto;
	private String flgValPromo;
	
}
