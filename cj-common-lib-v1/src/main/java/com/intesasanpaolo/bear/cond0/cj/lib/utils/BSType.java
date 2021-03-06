package com.intesasanpaolo.bear.cond0.cj.lib.utils;

public enum BSType {
	FL03S00("FL03", "Stampa", "FL030FLA01"),
	T1SJS00("T1SJ", "Stampa", "T1SJSTCVNE"),
	WKCJS00("WKCJ", "Stampa contratto carte in Customer Journey", "WKCJCNTRZE"),
	PCUJS00("PCUJ", "Calcolo / Controllo TEG e TAEG", "PCUJCJAFFI"),
	T1SFS00("T1SF", "Stampa Bersani da PEF", "T1SFSTPPEF"),
	WKIBS00("WKIB", "Stampa depositi amministrati", "WKIBSTAMP1"),
	PCMYS00("PCMY","Esposizione modale di un XME Conto in CJ DA","PCMYSTCJOF");
	
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
