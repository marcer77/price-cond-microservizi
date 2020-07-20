package com.intesasanpaolo.bear.cond0.cjindicatoricosto.utils;

import java.util.List;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.core.model.ispHeaders.ObjectFactory;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

import lombok.Builder;


public class ServiceUtil {
	private ServiceUtil() {}
	
	
	/**
	 * 
	 * @param header Deve essere di un tipo che si chiama INHEADER e avere tutti campi public
	 * @param ispWebservicesHeaderType
	 */
	public static void setHeaders(Object header, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		//if (!header.getClass().getSimpleName().equals("INHEADER")) {
		//	throw new ClassCastException();
		//}
		
		setHeader(header, "COD_ABI", getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
		setHeader(header, "CODICE_UO_RICH", getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA));
		setHeader(header, "COD_CLI_RICH", ispWebservicesHeaderType.getBusinessInfo().getCustomerID());
		setHeader(header, "CODICE_SOCIETA", ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
		setHeader(header, "COD_AZIENDA_DEST", ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
		setHeader(header, "CODICE_SPORTELLO", ispWebservicesHeaderType.getCompanyInfo().getISPBranchCode());
		setHeader(header, "CODICE_USERID", ispWebservicesHeaderType.getOperatorInfo().getUserID());
		setHeader(header, "COD_TIPO_LINGUA", ispWebservicesHeaderType.getRequestInfo().getLanguage());
		setHeader(header, "COD_RICH_CANALE", ispWebservicesHeaderType.getRequestInfo().getTransactionId());
		setHeader(header, "COD_RIS_RICH", ispWebservicesHeaderType.getTechnicalInfo().getCallerServerName());
		setHeader(header, "CODICE_TIPO_CANALE", ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
	}
	
	private static void setHeader(Object header, String headerName, String value) {
		if (value != null) {
			try {
				header.getClass().getField(headerName).set(header, value);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// non dovrebbe mai succedere perché i campi sono tutti public
				// eventualmente potrei aver sbagliato il nome del campo, ma in produzione non può succedere
				// l'ho intercettato prima
				throw new AssertionError(e);
			}
		}
	}
	
	private static String getAdditionalBusinessInfo(ISPWebservicesHeaderType obj, ParamList name) {
		for (Param param : obj.getAdditionalBusinessInfo().getParam()) {
			if (param.getName() == name) {
				return param.getValue();
			}
		}
		return null;
	}
	
	@Builder(builderMethodName = "buildISPWebservicesHeaderType")
	public static ISPWebservicesHeaderType buildISPWebservicesHeader(String codABI, String codUnitaOperativa, String customerID,
			String callerCompanyIDCode, String serviceCompanyIDCode, String userID, String isVirtualUser,
			String language, String serviceID, String serviceVersion, String timestamp, String transactionId,
			String applicationID, String callerProgramName, String channelIDCode) {

		ObjectFactory factory = new ObjectFactory();

		ISPWebservicesHeaderType obj = factory.createISPWebservicesHeaderType();
		obj.setRequestInfo(factory.createISPWebservicesHeaderTypeRequestInfo());
		obj.setOperatorInfo(factory.createISPWebservicesHeaderTypeOperatorInfo());
		obj.setCompanyInfo(factory.createISPWebservicesHeaderTypeCompanyInfo());
		obj.setBusinessInfo(factory.createISPWebservicesHeaderTypeBusinessInfo());
		obj.setTechnicalInfo(factory.createISPWebservicesHeaderTypeTechnicalInfo());
		obj.setAdditionalBusinessInfo(factory.createISPWebservicesHeaderTypeAdditionalBusinessInfo());

		obj.getRequestInfo().setTransactionId(transactionId);
		if (timestamp != null) {
			obj.getRequestInfo().setTimestamp(Long.parseLong(timestamp));
		}

		obj.getRequestInfo().setServiceID(serviceID);
		obj.getRequestInfo().setServiceVersion(serviceVersion);
		obj.getRequestInfo().setLanguage(language);
		obj.getOperatorInfo().setUserID(userID);
		if (isVirtualUser != null) {
			obj.getOperatorInfo().setIsVirtualUser(Boolean.parseBoolean(isVirtualUser));
		}
		// obj.getOperatorInfo().setNotISPUserID(headers.getFirst("ISPWebservicesHeader.OperatorInfo.NotISPUserID"));
		obj.getCompanyInfo().setISPCallerCompanyIDCode(callerCompanyIDCode);
		// obj.getCompanyInfo().setNotISPCompanyIDCode(headers.getFirst("ISPWebservicesHeader.CompanyInfo.NotISPCompanyIDCode"));
		// obj.getCompanyInfo().setISPBranchCode(headers.getFirst("ISPWebservicesHeader.CompanyInfo.ISPBranchCode"));
		// obj.getCompanyInfo().setISPServiceCompanyIDCode();
		obj.getBusinessInfo().setCustomerID(customerID);
		// obj.getBusinessInfo().setBusinessProcessName(headers.getFirst("ISPWebservicesHeader.BusinessInfo.BusinessProcessName"));
		// obj.getBusinessInfo().setBusinessProcessID(headers.getFirst("ISPWebservicesHeader.BusinessInfo.BusinessProcessID"));
		// obj.getBusinessInfo().setBusinessOperation(headers.getFirst("ISPWebservicesHeader.BusinessInfo.BusinessOperation"));
		// obj.getBusinessInfo().setBusinessFileID(headers.getFirst("ISPWebservicesHeader.BusinessInfo.BusinessFileID"));
		obj.getTechnicalInfo().setChannelIDCode(channelIDCode);
		obj.getTechnicalInfo().setApplicationID(applicationID);
		// obj.getTechnicalInfo().setCallerServerName(headers.getFirst("ISPWebservicesHeader.TechnicalInfo.CallerServerName"));
		obj.getTechnicalInfo().setCallerProgramName(callerProgramName);

		 
		addIfNonNull(obj.getAdditionalBusinessInfo().getParam(),createParam(ParamList.COD_ABI,codABI));
		addIfNonNull(obj.getAdditionalBusinessInfo().getParam(), createParam(ParamList.COD_UNITA_OPERATIVA, codUnitaOperativa));
		// addIfNonNull(obj.getAdditionalBusinessInfo().getParam(),
		// createParam(ParamList.DATA_CONTABILE,
		// headers.getFirst("ISPWebservicesHeader.AdditionalBusinessInfo.DataContabile")));
		// addIfNonNull(obj.getAdditionalBusinessInfo().getParam(),
		// createParam(ParamList.FLAG_PAPERLESS,
		// headers.getFirst("ISPWebservicesHeader.AdditionalBusinessInfo.FlagPaperless")));
		// addIfNonNull(obj.getAdditionalBusinessInfo().getParam(),
		// createParam(ParamList.COD_OPERATIVITA,
		// headers.getFirst("ISPWebservicesHeader.AdditionalBusinessInfo.CodOperativita")));
		// addIfNonNull(obj.getAdditionalBusinessInfo().getParam(),
		// createParam(ParamList.COD_TERMINALE_CICS,
		// headers.getFirst("ISPWebservicesHeader.AdditionalBusinessInfo.CodTerminaleCics")));

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

	
	
}
