package com.intesasanpaolo.bear.bear_v3.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

//classe di utility
public class CondizioniContoUtils {
	
	public static final String RAPP_CATEGORIA = "rapp_categoria";
	public static final String RAPP_CONTO = "rapp_conto";
	public static final String RAPP_FILIALE = "rapp_filiale";
	public static final String ESITO_OK = "00";
	public static final String ESITO_KO = "01"; 
	
	
	public static String yyyyMMdd(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}
	
	public static String today_yyyyMMdd() {
		Date today = new Date();
		return yyyyMMdd(today);
	}
	
	public static String today_ddMMyyyy() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		return dateFormat.format(today);
	}
	
	public static String today_yyyyMMddHHmm() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		return dateFormat.format(today);
	}
	
	public static HashMap<String,String> getInfoRapporto(String cdRapporto) {
		HashMap<String,String> infoRapporto = new HashMap<String,String>();
		byte[] bytes = cdRapporto.getBytes();
		infoRapporto.put(RAPP_FILIALE, new String(bytes, 0, 5));
		infoRapporto.put(RAPP_CATEGORIA, new String(bytes, 5, 4));
		infoRapporto.put(RAPP_CONTO, new String(bytes, 9, 8));
		return infoRapporto;
	}
}
