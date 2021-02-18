package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response;

public class ResponseHostBridge {
	
	public ResponseHeader header;
	public ResponseBody body;
	public Outcome outcome;
	public Report report;
	
	public class Outcome {
		public String ESITO;
	}
	
	public class Report {
		public String LIVELLO_SEGNALAZIONE;
		public String TXT_SEGNALAZIONE;
	}

}
