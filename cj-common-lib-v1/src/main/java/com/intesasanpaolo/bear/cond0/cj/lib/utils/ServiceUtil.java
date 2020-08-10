package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.core.model.ispHeaders.ObjectFactory;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

import lombok.Builder;

public class ServiceUtil {

	private static final Logger logger = LoggerUtils.getLogger(ServiceUtil.class);

	private ServiceUtil() {
	}

	public static void setBSHeaders(Object header, BSTypeCall bsTypeCall,
			ISPWebservicesHeaderType ispWebservicesHeaderType) {
		HeaderBS headerBS = buildHeaders(bsTypeCall, ispWebservicesHeaderType);
		logger.debug("headerBS = {}", headerBS);
		setHeaders(header, headerBS);
	}

	public static HeaderBS buildHeaders(BSTypeCall bsTypeCall, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		HeaderBS headerBS = new HeaderBS();

		headerBS.setIdServizio(bsTypeCall.getBsType().getIdServizio());
		headerBS.setLunghezzaMsg(bsTypeCall.getLenArea());
		headerBS.setCodRicTrac(bsTypeCall.getRecyclingVersion());
		headerBS.setCodVersioneBs(bsTypeCall.getVersion());

		// campi header nuovi per CTG
		headerBS.setHspAcronimoProvider(bsTypeCall.getAcronimoOwnerBS());
		headerBS.setHspAcronimo("COND0");
		//
		headerBS.setCodiceTipoCanale(bsTypeCall.getChannel());

		// campi prelevati dall'HEADER HTTP del microservizio
		headerBS.setCodAbi(getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
		headerBS.setCodiceUoRich(getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA));
		headerBS.setCodCliRich(ispWebservicesHeaderType.getBusinessInfo().getCustomerID());
		headerBS.setCodiceSocieta(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
		headerBS.setCodAziendaDest(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
		headerBS.setCodiceSportello(getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA));
		headerBS.setCodiceUserid(ispWebservicesHeaderType.getOperatorInfo().getUserID());
		// headerBS.setCodTipoLingua(ispWebservicesHeaderType.getRequestInfo().getLanguage());
		headerBS.setCodTipoLingua("I");
		headerBS.setCodRichCanale(ispWebservicesHeaderType.getRequestInfo().getTransactionId());
		headerBS.setCodRisRich(ispWebservicesHeaderType.getTechnicalInfo().getCallerServerName());
		// TODO: CodiceTipoCanale va preso dagli HEADER HTTP del microservizio o da
		// BSTypeCall?
		// headerBS.setCodiceTipoCanale(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());

		headerBS.setDataCont(new SimpleDateFormat("ddMMyyyy").format(new Date()));

		headerBS.setCodBsm("");
		headerBS.setCodicestato("");
		headerBS.setCodOperativita("");
		headerBS.setCodSsaServizio("");
		headerBS.setCodTermCics("");
		headerBS.setCodVersSic("");
		headerBS.setFlagPaperless("");
		headerBS.setFlagRacf("");

		// Campi nuovi specifici Header CTG
		headerBS.setHspConvNull("");
		headerBS.setHspFlag24X7("");
		headerBS.setHspIndAtom("");
		headerBS.setHspPgmAtom("");
		headerBS.setHspTimeiib("");
		headerBS.setHspTimeout("");
		headerBS.setHspTrnAtom("");
		//////

		headerBS.setIndCompressInp("");
		headerBS.setIndCompressOut("");
		headerBS.setIndInoltroReply("");
		headerBS.setIndMqSincrono("");
		headerBS.setIndRoutingMsg("");
		headerBS.setMqmNameDest("");
		headerBS.setRetCode(0);
		headerBS.setSicKey("");
		headerBS.setSicMac("");
		headerBS.setSicTimestamp("");
		headerBS.setTipoSicApplInp("");
		headerBS.setTipoSicApplOut("");

		return headerBS;

	}

	public static void setHeaders(Object header, HeaderBS headerBS) {

		setHeader(header, "ID_SERVIZIO", headerBS.getIdServizio());
		setHeader(header, "COD_ABI", headerBS.getCodAbi());
		setHeader(header, "CODICE_UO_RICH", ifNull(headerBS.getCodiceUoRich(), ""));
		setHeader(header, "COD_CLI_RICH", ifNull(headerBS.getCodCliRich(), ""));
		setHeader(header, "CODICE_SOCIETA", ifNull(headerBS.getCodiceSocieta(), ""));
		setHeader(header, "COD_AZIENDA_DEST", ifNull(headerBS.getCodAziendaDest(), ""));
		setHeader(header, "CODICE_SPORTELLO", ifNull(headerBS.getCodiceSportello(), ""));
		setHeader(header, "CODICE_USERID", ifNull(headerBS.getCodiceUserid(), ""));
		setHeader(header, "COD_TIPO_LINGUA", ifNull(headerBS.getCodTipoLingua(), ""));
		setHeader(header, "COD_RICH_CANALE", ifNull(headerBS.getCodRichCanale(), ""));
		setHeader(header, "COD_RIS_RICH", ifNull(headerBS.getCodRisRich(), ""));
		setHeader(header, "CODICE_TIPO_CANALE", ifNull(headerBS.getCodiceTipoCanale(), ""));

		setHeader(header, "COD_BSM", ifNull(headerBS.getCodBsm(), ""));
		setHeader(header, "COD_OPERATIVITA", ifNull(headerBS.getCodOperativita(), ""));
		setHeader(header, "COD_RIC_TRAC", ifNull(headerBS.getCodRicTrac(), ""));
		setHeader(header, "COD_SSA_SERVIZIO", ifNull(headerBS.getCodSsaServizio(), ""));

		setHeader(header, "COD_TERM_CICS", ifNull(headerBS.getCodTermCics(), ""));
		setHeader(header, "COD_VERS_SIC", ifNull(headerBS.getCodVersSic(), ""));
		setHeader(header, "COD_VERSIONE_BS", ifNull(headerBS.getCodVersioneBs(), ""));
		setHeader(header, "CODICE_UO_RICH", ifNull(headerBS.getCodiceUoRich(), ""));
		setHeader(header, "CODICESTATO", ifNull(headerBS.getCodicestato(), "0010"));

		setHeader(header, "DATA_CONT", ifNull(headerBS.getDataCont(), ""));
		setHeader(header, "FLAG_PAPERLESS", ifNull(headerBS.getFlagPaperless(), ""));
		setHeader(header, "FLAG_RACF", ifNull(headerBS.getFlagRacf(), ""));
		setHeader(header, "HSP_ACRONIMO", ifNull(headerBS.getHspAcronimo(), ""));
		setHeader(header, "HSP_ACRONIMO_PROVIDER", ifNull(headerBS.getHspAcronimoProvider(), ""));
		setHeader(header, "HSP_CONV_NULL", ifNull(headerBS.getHspConvNull(), ""));
		setHeader(header, "HSP_FLAG24X7", ifNull(headerBS.getHspFlag24X7(), ""));
		setHeader(header, "HSP_IND_ATOM", ifNull(headerBS.getHspIndAtom(), ""));
		setHeader(header, "HSP_PGM_ATOM", ifNull(headerBS.getHspPgmAtom(), ""));
		setHeader(header, "HSP_TIMEIIB", ifNull(headerBS.getHspTimeiib(), ""));
		setHeader(header, "HSP_TIMEOUT", ifNull(headerBS.getHspTimeout(), ""));
		setHeader(header, "HSP_TRN_ATOM", ifNull(headerBS.getHspTrnAtom(), ""));

		setHeader(header, "IND_COMPRESS_INP", ifNull(headerBS.getIndCompressInp(), "N"));
		setHeader(header, "IND_COMPRESS_OUT", ifNull(headerBS.getIndCompressOut(), "N"));
		setHeader(header, "IND_INOLTRO_REPLY", ifNull(headerBS.getIndInoltroReply(), "S"));
		setHeader(header, "IND_MQ_SINCRONO", ifNull(headerBS.getIndMqSincrono(), "S"));
		setHeader(header, "IND_ROUTING_MSG", ifNull(headerBS.getIndRoutingMsg(), "N"));
		setHeader(header, "LUNGHEZZA_MSG", ifNullAsInt(headerBS.getLunghezzaMsg(), 0));
		setHeader(header, "MQM_NAME_DEST", ifNull(headerBS.getMqmNameDest(), ""));
		setHeader(header, "RETCODE", ifNullAsInt(headerBS.getRetCode(), 0));
		setHeader(header, "SIC_KEY", ifNull(headerBS.getSicKey(), ""));
		setHeader(header, "SIC_MAC", ifNull(headerBS.getSicMac(), ""));
		setHeader(header, "SIC_TIMESTAMP", ifNull(headerBS.getSicTimestamp(), ""));
		setHeader(header, "TIPO_SIC_APPL_INP", ifNull(headerBS.getTipoSicApplInp(), "00"));
		setHeader(header, "TIPO_SIC_APPL_OUT", ifNull(headerBS.getTipoSicApplOut(), "00"));

	}

	protected static void setHeader(Object header, String headerName, Object value) {
		try {
			header.getClass().getField(headerName).set(header, value);
			// BeanUtils.setProperty(header, headerName, value);
		} catch (Exception e) {
			logger.error("Proprietà {} non trovata sull'oggetto {}", headerName, header.getClass());
			throw new AssertionError();
		}
	}

	public static String getAdditionalBusinessInfo(ISPWebservicesHeaderType obj, ParamList name) {
		for (Param param : obj.getAdditionalBusinessInfo().getParam()) {
			if (param.getName() == name) {
				return param.getValue();
			}
		}
		return null;
	}

	@Builder(builderMethodName = "buildISPWebservicesHeaderType")
	public static ISPWebservicesHeaderType buildISPWebservicesHeader(String codABI, String codUnitaOperativa,
			String customerID, String callerCompanyIDCode, String serviceCompanyIDCode, String userID,
			String isVirtualUser, String language, String serviceID, String serviceVersion, String timestamp,
			String transactionId, String applicationID, String callerProgramName, String channelIDCode) {

		ObjectFactory factory = new ObjectFactory();

		ISPWebservicesHeaderType obj = factory.createISPWebservicesHeaderType();
		obj.setRequestInfo(factory.createISPWebservicesHeaderTypeRequestInfo());
		obj.setOperatorInfo(factory.createISPWebservicesHeaderTypeOperatorInfo());
		obj.setCompanyInfo(factory.createISPWebservicesHeaderTypeCompanyInfo());
		obj.setBusinessInfo(factory.createISPWebservicesHeaderTypeBusinessInfo());
		obj.setTechnicalInfo(factory.createISPWebservicesHeaderTypeTechnicalInfo());
		obj.setAdditionalBusinessInfo(factory.createISPWebservicesHeaderTypeAdditionalBusinessInfo());

		addIfNonNull(obj.getAdditionalBusinessInfo().getParam(), createParam(ParamList.COD_ABI, codABI));
		addIfNonNull(obj.getAdditionalBusinessInfo().getParam(),
				createParam(ParamList.COD_UNITA_OPERATIVA, codUnitaOperativa));
		obj.getBusinessInfo().setCustomerID(customerID);
		obj.getCompanyInfo().setISPCallerCompanyIDCode(callerCompanyIDCode);
		obj.getCompanyInfo().setISPServiceCompanyIDCode(serviceCompanyIDCode);
		obj.getOperatorInfo().setUserID(userID);
		if (isVirtualUser != null) {
			obj.getOperatorInfo().setIsVirtualUser(Boolean.parseBoolean(isVirtualUser));
		}
		obj.getRequestInfo().setLanguage(language);
		obj.getRequestInfo().setServiceID(serviceID);
		obj.getRequestInfo().setServiceVersion(serviceVersion);

		if (timestamp != null) {
			obj.getRequestInfo().setTimestamp(Long.parseLong(timestamp));
		}
		obj.getRequestInfo().setTransactionId(transactionId);
		obj.getTechnicalInfo().setApplicationID(applicationID);
		obj.getTechnicalInfo().setCallerProgramName(callerProgramName);
		obj.getTechnicalInfo().setChannelIDCode(channelIDCode);
		return obj;
	}

	private static void addIfNonNull(List<Param> paramList, Param param) {
		if (param != null) {
			paramList.add(param);
		}
	}

	private static Param createParam(ParamList name, String value) {
		ObjectFactory factory = new ObjectFactory();

		if (value == null) {
			return null;
		} else {
			Param p = factory.createISPWebservicesHeaderTypeAdditionalBusinessInfoParam();
			p.setName(name);
			p.setValue(value);
			return p;
		}

	}

	public static String ifNull(String value, String defaultValue) {
		if (value != null) {
			return value;
		} else {
			return defaultValue;
		}
	}

	public static int ifNullAsInt(Number value, int defValue) {
		if (value != null) {
			return value.intValue();
		} else {
			return defValue;
		}
	}
	
	public static double ifNullAsDouble(Number value) {
		if (value != null) {
			return value.doubleValue();
		} else {
			return 0;
		}
	}

	public static StringBuilder stampaOggetto(Object obj) {
		StringBuilder buffer = new StringBuilder("[");
		java.util.Arrays.asList(obj.getClass().getDeclaredFields()).forEach(f -> {
			try {
				buffer.append(f.getName() + " = " + f.get(obj)).append(" - ");
			} catch (Exception e) {
			}
		});
		buffer.append("]");
		return buffer;
	}

	public static <T> T withNoException(Supplier<? extends T> supplier, T defaultValue) {
		try {
			return supplier.get();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String formattaNumero(Number number, String pattern) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("it", "IT"));
		symbols.setDecimalSeparator('.');
		if (pattern == null)
			pattern = "###.#####";

		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		return decimalFormat.format(number);
	}

	public static String formattaNumero(Number number) {
		return number!=null ? formattaNumero(number, "###.#####") : formattaNumero(0, "###.#####");
	}

	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		return sdf.format(date);
	}
	
	public static String convertiDate(String dateInput, String dateFormatInput,String dateFormatOutput) throws ParseException {
		SimpleDateFormat sdfInput = new SimpleDateFormat(dateFormatInput);
		SimpleDateFormat sdfOutput = new SimpleDateFormat(dateFormatOutput);
		String output=null;
		try {
			Date dataScadenzaInput= StringUtils.isNotEmpty(dateInput)?sdfInput.parse(dateInput):null;
			if (dataScadenzaInput!=null)
				output=sdfOutput.format(dataScadenzaInput);
		} catch (ParseException e) {
			logger.error("Problema nella conversione della data {} dal formato {} al formato {}",dateInput,dateFormatInput,dateFormatOutput);
			throw e;
		}
		return output;
	}
}
