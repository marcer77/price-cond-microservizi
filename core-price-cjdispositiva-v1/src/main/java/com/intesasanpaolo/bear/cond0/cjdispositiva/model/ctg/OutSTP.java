package com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg;

import java.util.ArrayList;
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

	@Builder.Default
	private List<OutRC4> outRC4List=new ArrayList<>();
	@Builder.Default
	private List<OutRCZ> outRCZList=new ArrayList<>();
	@Builder.Default
	private List<OutRNO> outRNOList=new ArrayList<>();
	@Builder.Default
	private List<OutRPR> outRPRList=new ArrayList<>();
	@Builder.Default
	private List<OutRTS> outRTSList=new ArrayList<>();

}
