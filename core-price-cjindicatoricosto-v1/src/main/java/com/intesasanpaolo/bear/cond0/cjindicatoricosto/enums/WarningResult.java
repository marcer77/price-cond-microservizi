package com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarningResult implements Comparable<WarningResult>{
	private String codeBS;
	private String msgBS;
	private String descrizione;
	private Integer priorita;
	
	@Override
	public int compareTo(WarningResult o) {
		return this.priorita.compareTo(o.priorita);
	}
}
