package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj;

import java.util.ArrayList;
import java.util.List;

import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PCUJResponse {
	private OutEsi outEsi;
	private OutSeg outSeg;
	
	// body
	private String codEsito;
	private String msgEsito;
	@Builder.Default
	private List<OutRIP> outRIPList=new ArrayList<>();

}
