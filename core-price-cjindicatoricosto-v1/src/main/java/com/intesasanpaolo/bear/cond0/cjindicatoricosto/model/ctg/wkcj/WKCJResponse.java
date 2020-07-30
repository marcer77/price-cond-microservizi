package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj;

import java.util.ArrayList;
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

	@Builder.Default
	private List<OutCNF> outCNFList=new ArrayList<>();
	@Builder.Default
	private List<OutRAF> outRAFList=new ArrayList<>();
	@Builder.Default
	private List<OutRAP> outRAPList=new ArrayList<>();
	@Builder.Default
	private List<OutSTP> outSTPList=new ArrayList<>();
}
