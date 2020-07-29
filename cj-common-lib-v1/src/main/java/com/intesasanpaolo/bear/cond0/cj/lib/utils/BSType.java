package com.intesasanpaolo.bear.cond0.cj.lib.utils;

public enum BSType {
	FL03S00("FL03", "Stampa", "FL030FLA01"),
	T1SJS00("T1SJ", "Stampa", "T1SJSTCVNE"),
	PCUJS00("PCUJ", "Calcolo / Controllo TEG e TAEG", "PCUJCJAFFI");
	
	
	private final String code;
	private final String desc;
	private final String idServizio;
	
	private BSType(String code, String desc, String idServizio) {
		this.code = code;
		this.desc = desc;
		this.idServizio = idServizio;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public String getIdServizio() {
		return idServizio;
	}
}
