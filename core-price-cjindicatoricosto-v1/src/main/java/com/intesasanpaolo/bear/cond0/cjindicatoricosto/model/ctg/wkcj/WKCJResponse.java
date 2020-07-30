package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WKCJResponse {

	private String livelloSegnalazione;
	private String txtSegnalazione;
	private String mdwEsiAnom;
	private String mdwEsiMsg;
	private String mdwEsiRetc;
	
	private String flCnf;
	private String flRaf;
	private String flRap;
	private String flStp;
	private String retCode;

	private List<OutCNF> outCNFList;
	private List<OutRAF> outRAFList;
	private List<OutRAP> outRAPList;
	private List<OutSTP> outSTPList;
}
