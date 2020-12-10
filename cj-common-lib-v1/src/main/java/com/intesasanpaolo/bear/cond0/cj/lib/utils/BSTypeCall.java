package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BSTypeCall {

	FL03S00_CALL(
			BSType.FL03S00 
			,"31" //canale
			, "FL999" // Acronimo proprietario BS
	),
	T1SJ00_CALL(
			BSType.T1SJS00 
			,"31" //canale
			, "T1999" // Acronimo proprietario BS
	),
	PCUJS00_CALL(
			BSType.PCUJS00 
			,"31" //canale
			, "PC999" // Acronimo proprietario BS
			),
	
	WKCJS00_CALL(
			BSType.WKCJS00 
			,"31" //canale
			, "WK999" // Acronimo proprietario BS
			),
	
	T1SFS00_CALL(
			BSType.T1SFS00 
			,"31" //canale
			, "T1999" // Acronimo proprietario BS
			),
	
	WKNBS00_CALL(
			BSType.WKNBS00
			,"31" //canale
			, "WK999" // Acronimo proprietario BS
			),
	
	PCMYS00_CALL(
			BSType.PCMYS00
			,"31" //canale
			, "PC999" // Acronimo proprietario BS
			)
	;
	
	private final BSType bsType;
	private final String channel;
	private final String acronimoOwnerBS;
	
}
