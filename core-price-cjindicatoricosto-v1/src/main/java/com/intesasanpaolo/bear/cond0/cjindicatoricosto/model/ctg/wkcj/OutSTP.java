package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutSTP {
	private String flContinua;
	private String keyPrecontr;
	private String progStrut;
	private String progrStp;
	private String tipoSez;
	private String tipoStrut;

	private List<OutRC4> outRC4List;
	private List<OutRCZ> outRCZList;
	private List<OutRNO> outRNOList;
	private List<OutRPR> outRPRList;
	private List<OutRTS> outRTSList;

}
