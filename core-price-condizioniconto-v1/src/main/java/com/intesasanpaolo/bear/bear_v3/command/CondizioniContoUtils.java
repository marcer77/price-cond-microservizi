package com.intesasanpaolo.bear.bear_v3.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndDettaglioOutput;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndOutput;

//classe di utility
public class CondizioniContoUtils {

	public static final String RAPP_CATEGORIA = "rapp_categoria";
	public static final String RAPP_CONTO = "rapp_conto";
	public static final String RAPP_FILIALE = "rapp_filiale";
	public static final String ESITO_OK = "00";
	public static final String ESITO_KO = "01";
	public static final String ESITO_WARNING = "00";

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

	public static HashMap<String, String> getInfoRapporto(String cdRapporto) {
		HashMap<String, String> infoRapporto = new HashMap<String, String>();
		byte[] bytes = cdRapporto.getBytes();
		infoRapporto.put(RAPP_FILIALE, new String(bytes, 0, 5));
		infoRapporto.put(RAPP_CATEGORIA, new String(bytes, 5, 4));
		infoRapporto.put(RAPP_CONTO, new String(bytes, 9, 8));
		return infoRapporto;
	}

	public static void segnalaWarning(InquiryContoCndDettaglioOutput output, IIBCDPRCMSResponseType response) {

		if (response != null && response.getResponse() != null && response.getResponse().getNBPErrorInfo() != null) {
			output.setCdEsito(CondizioniContoUtils.ESITO_WARNING);
			String msg = response.getResponse().getNBPErrorInfo().getErrReason();
			output.setMsgEsito(
					StringUtils.isNotEmpty(output.getMsgEsito()) ? 
							output.getMsgEsito()+ " - " + msg
							: output.getMsgEsito() + msg);
		}

	}

	public static void segnalaWarning(InquiryContoCndOutput output, String msg) {

		output.setCdEsito(CondizioniContoUtils.ESITO_WARNING);
		output.setMsgEsito(
				StringUtils.isNotEmpty(output.getMsgEsito()) ? 
						output.getMsgEsito()+ " - " + msg
						: output.getMsgEsito() + msg);

	}
}
