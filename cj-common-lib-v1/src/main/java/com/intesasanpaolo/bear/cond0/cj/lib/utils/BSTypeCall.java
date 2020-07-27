package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BSTypeCall {

	FL03S00_CALL(
			BSType.FL03S00 
			,"31" //canale
			, "00" // Version
			, "0001" // Riciclo Tracciato
			, "FL999" // Acronimo proprietario BS
			, 1000 // Lunghezza area
	),
	T1SJ00_CALL(
			BSType.T1SJS00 
			,"31" //canale
			, "00" // Version
			, "0003" // Riciclo Tracciato
			, "T1999" // Acronimo proprietario BS
			, 9999 // Lunghezza area
	);
	;

	private final BSType bsType;
	private final String channel;
	private final String version;
	private final String recyclingVersion;
	private final String acronimoOwnerBS;
	private final int lenArea;

}
