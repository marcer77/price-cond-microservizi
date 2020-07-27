package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

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
public class FL03Request {
	
	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	private String codApplic;
	private String codFunzione;
	private String codSottoApplic;
	private String filler;
	private String keyOper;
	private Integer numStrKey;
	
	
}
