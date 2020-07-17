package com.intesasanpaolo.bear.cond0.cjdispositiva.utils;

import org.apache.commons.lang3.StringUtils;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.AnagraficaPropostaCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.CondizioneCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.DatiCliente;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.PropostaCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaPropostaRequest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.WrapperMap;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.BusinessInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.CompanyInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.OperatorInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.RequestInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.TechnicalInfo;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

public class ProposteCJPOSWSUtils {

	public static InviaPropostaV2 _buildMockInviaPropostaV2() {

		InviaPropostaV2 inviaPropostaV2 = new InviaPropostaV2();
		PropostaCJPOSV2 propostaCJPOSV2 = new PropostaCJPOSV2();

		propostaCJPOSV2.setTipoChiamata("INS");
		propostaCJPOSV2.setCodiceOrigine("IN");
		propostaCJPOSV2.setRapportoReale("11653632401932571");
		propostaCJPOSV2.setAttributoRapporto("RB6324");
		AnagraficaPropostaCJPOS anagraficaPropostaCJPOS = new AnagraficaPropostaCJPOS();
		anagraficaPropostaCJPOS.setCodiceAbiProposta("01025");
		anagraficaPropostaCJPOS.setAnnoProposta("2020");
		anagraficaPropostaCJPOS.setCodiceTipoOperazione("N");
		anagraficaPropostaCJPOS.setCodiceOggettoProposta("01");
		anagraficaPropostaCJPOS.setAttributo("RB6324");
		anagraficaPropostaCJPOS.setMatricolaProponente("U004835");
		anagraficaPropostaCJPOS.setUoProponente("01383");
		propostaCJPOSV2.setDatiProposta(anagraficaPropostaCJPOS);
		DatiCliente datiCliente = new DatiCliente();
		datiCliente.setAbiCliente("01025");
		datiCliente.setNdgCliente("2896811838000");
		datiCliente.setPivaCliente("02417880032");
		datiCliente.setUoGestore("01383");
		datiCliente.setNominativoCliente("DE AGOSTINI POLSKA SP. Z O.O.");
		propostaCJPOSV2.setDatiCliente(datiCliente);
		propostaCJPOSV2.setAttributiPricing(new WrapperMap());
		CondizioneCJPOS condizione = new CondizioneCJPOS();
		condizione.setCodiceCondizione("03229");
		condizione.setTipoDeroga("N");
		condizione.setTipoValore("1");
		condizione.setIndPresenzaValProp("S");
		condizione.setValoreProposto("100");
		propostaCJPOSV2.getListaCondizioni().add(condizione);

		inviaPropostaV2.setDatiProposta(propostaCJPOSV2);

		return inviaPropostaV2;

	}
	
	public static RevocaProposta _buildMockRevocaProposta() {
		RevocaProposta revocaProposta = new RevocaProposta();
		RevocaPropostaRequest revocaPropostaRequest = new RevocaPropostaRequest();
		revocaPropostaRequest.setAnnoProposta("2020");
		revocaPropostaRequest.setCodiceAbiProposta("01025");
		revocaPropostaRequest.setCodiceProposta("001837R");
//		revocaPropostaRequest.setDataRespinta(value);
		revocaPropostaRequest.setMatricolaRespinta("U004835");
//		revocaPropostaRequest.setNoteRespinta(value);
		revocaPropostaRequest.setUoRespinta("03126");
		revocaProposta.setDatiProposta(revocaPropostaRequest);
		return revocaProposta;
	}

	public static ISPWebservicesHeaderType _buildMockedHeader() {

		ISPWebservicesHeaderType header = new ISPWebservicesHeaderType();

		RequestInfo requestInfo = new RequestInfo();
//    	<RequestInfo>
//            <TransactionId>NPUA020200417GEN00164904998</TransactionId>
		requestInfo.setTransactionId("NPUA020200417GEN00164904998");
//            <Timestamp>1587135953280</Timestamp>
		requestInfo.setTimestamp(1587135953280L);
//            <ServiceID>GESTCJPOSV</ServiceID>
		requestInfo.setServiceID("GESTCJPOSV");
//            <ServiceVersion>00</ServiceVersion>
		requestInfo.setServiceVersion("00");
//            <Language>I</Language>.
		requestInfo.setLanguage("I");
//         </RequestInfo>
		header.setRequestInfo(requestInfo);

		OperatorInfo operatorInfo = new OperatorInfo();
		operatorInfo.setUserID("U004835");
		operatorInfo.setIsVirtualUser(false);
//         <OperatorInfo UserID="U004835" IsVirtualUser="false"/>
		header.setOperatorInfo(operatorInfo);
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setISPCallerCompanyIDCode("01");
		companyInfo.setISPBranchCode("03126");
		companyInfo.setISPServiceCompanyIDCode("01");
//         <CompanyInfo>
//            <ISPCallerCompanyIDCode>01</ISPCallerCompanyIDCode>
//            <ISPBranchCode>03126</ISPBranchCode>
//            <ISPServiceCompanyIDCode>01</ISPServiceCompanyIDCode>
//         </CompanyInfo>
		header.setCompanyInfo(companyInfo);
		BusinessInfo businessInfo = new BusinessInfo();
		businessInfo.setCustomerID("0004888305502000");
		businessInfo.setBusinessProcessName("anonym");
		businessInfo.setBusinessProcessID("anonym");
		businessInfo.setBusinessOperation("anonym");
		businessInfo.setBusinessFileID("anonym");
//         <BusinessInfo>
//            <CustomerID>0004888305502000</CustomerID>
//            <BusinessProcessName>anonym</BusinessProcessName>
//            <BusinessProcessID>anonym</BusinessProcessID>
//            <BusinessOperation>anonym</BusinessOperation>
//            <BusinessFileID>anonym</BusinessFileID>
//         </BusinessInfo>
		header.setBusinessInfo(businessInfo);

		com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.TechnicalInfo technicalInfo = new TechnicalInfo();
		technicalInfo.setChannelIDCode("31");
		technicalInfo.setApplicationID("NPUC0");
		technicalInfo.setCallerServerName("salclp8940");
		technicalInfo.setCallerProgramName("NPUC0");
//         <TechnicalInfo>
//            <ChannelIDCode>31</ChannelIDCode>
//            <ApplicationID>NPUC0</ApplicationID>
//            <CallerServerName>salclp8940</CallerServerName>
//            <CallerProgramName>NPUC0</CallerProgramName>
//         </TechnicalInfo>
		header.setTechnicalInfo(technicalInfo);
		AdditionalBusinessInfo additionalBusinessInfo = new AdditionalBusinessInfo();

		Param p1 = new Param();
		p1.setName(ParamList.COD_ABI);
		p1.setValue("01025");

		Param p2 = new Param();
		p2.setName(ParamList.COD_UNITA_OPERATIVA);
		p2.setValue("03126");

		Param p3 = new Param();
		p3.setName(ParamList.COD_OPERATIVITA);
		p3.setValue("0");

		Param p4 = new Param();
		p4.setName(ParamList.DATA_CONTABILE);
		p4.setValue("17042020");

		additionalBusinessInfo.getParam().add(p1);
		additionalBusinessInfo.getParam().add(p2);
		additionalBusinessInfo.getParam().add(p3);
		additionalBusinessInfo.getParam().add(p4);
//         <AdditionalBusinessInfo>
//            <Param Name="CodABI" Value="01025"/>
//            <Param Name="CodUnitaOperativa" Value="03126"/>
//            <Param Name="CodOperativita" Value="0"/>
//            <Param Name="DataContabile" Value="17042020"/>
//         </AdditionalBusinessInfo>
		header.setAdditionalBusinessInfo(additionalBusinessInfo);
		return header;
	}

	public static ISPWebservicesHeaderType _buildMockedHeaderInviaProstaV2() {

		ISPWebservicesHeaderType header = new ISPWebservicesHeaderType();

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setTransactionId("NPUA020200417GEN00164904998");
		requestInfo.setTimestamp(1587135953280L);
		requestInfo.setServiceID("GESTCJPOSV");
		requestInfo.setServiceVersion("00");
		requestInfo.setLanguage("I");
		header.setRequestInfo(requestInfo);

		OperatorInfo operatorInfo = new OperatorInfo();
		operatorInfo.setUserID("U004835");
		operatorInfo.setIsVirtualUser(false);
		header.setOperatorInfo(operatorInfo);
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setISPCallerCompanyIDCode("01");
		companyInfo.setISPBranchCode("01383");//
		companyInfo.setISPServiceCompanyIDCode("01");
		header.setCompanyInfo(companyInfo);
		BusinessInfo businessInfo = new BusinessInfo();
		businessInfo.setCustomerID("0002896811838000");
		businessInfo.setBusinessProcessName("anonym");
		businessInfo.setBusinessProcessID("anonym");
		businessInfo.setBusinessOperation("anonym");
		businessInfo.setBusinessFileID("anonym");
		header.setBusinessInfo(businessInfo);

		com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.TechnicalInfo technicalInfo = new TechnicalInfo();
		technicalInfo.setChannelIDCode("31");
		technicalInfo.setApplicationID("NPUC0");
		technicalInfo.setCallerServerName("salclp8940");
		technicalInfo.setCallerProgramName("NPUC0");
		header.setTechnicalInfo(technicalInfo);
		AdditionalBusinessInfo additionalBusinessInfo = new AdditionalBusinessInfo();

		Param p1 = new Param();
		p1.setName(ParamList.COD_ABI);
		p1.setValue("01025");

		Param p2 = new Param();
		p2.setName(ParamList.COD_UNITA_OPERATIVA);
		p2.setValue("01383");

		Param p3 = new Param();
		p3.setName(ParamList.COD_OPERATIVITA);
		p3.setValue("0");

		Param p4 = new Param();
		p4.setName(ParamList.DATA_CONTABILE);
		p4.setValue("1007020");

		additionalBusinessInfo.getParam().add(p1);
		additionalBusinessInfo.getParam().add(p2);
		additionalBusinessInfo.getParam().add(p3);
		additionalBusinessInfo.getParam().add(p4);
		header.setAdditionalBusinessInfo(additionalBusinessInfo);
		return header;
	}
	
	public static ISPWebservicesHeaderType _buildMockedHeaderRevocaProposta() {

		ISPWebservicesHeaderType header = new ISPWebservicesHeaderType();

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setTransactionId("NPUA020200417GEN00164904998");
		requestInfo.setTimestamp(1587135953280L);
		requestInfo.setServiceID("GESTCJPOSV");
		requestInfo.setServiceVersion("00");
		requestInfo.setLanguage("I");
		header.setRequestInfo(requestInfo);

		OperatorInfo operatorInfo = new OperatorInfo();
		operatorInfo.setUserID("U004835");
		operatorInfo.setIsVirtualUser(false);
		header.setOperatorInfo(operatorInfo);
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setISPCallerCompanyIDCode("01");
		companyInfo.setISPBranchCode("03126");//
		companyInfo.setISPServiceCompanyIDCode("01");
		header.setCompanyInfo(companyInfo);
		BusinessInfo businessInfo = new BusinessInfo();
		businessInfo.setCustomerID("0004888305502000");
		businessInfo.setBusinessProcessName("anonym");
		businessInfo.setBusinessProcessID("anonym");
		businessInfo.setBusinessOperation("anonym");
		businessInfo.setBusinessFileID("anonym");
		header.setBusinessInfo(businessInfo);

		com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.TechnicalInfo technicalInfo = new TechnicalInfo();
		technicalInfo.setChannelIDCode("31");
		technicalInfo.setApplicationID("NPUC0");
		technicalInfo.setCallerServerName("salclp8940");
		technicalInfo.setCallerProgramName("NPUC0");
		header.setTechnicalInfo(technicalInfo);
		AdditionalBusinessInfo additionalBusinessInfo = new AdditionalBusinessInfo();

		Param p1 = new Param();
		p1.setName(ParamList.COD_ABI);
		p1.setValue("01025");

		Param p2 = new Param();
		p2.setName(ParamList.COD_UNITA_OPERATIVA);
		p2.setValue("03126");

		Param p3 = new Param();
		p3.setName(ParamList.COD_OPERATIVITA);
		p3.setValue("0");

		Param p4 = new Param();
		p4.setName(ParamList.DATA_CONTABILE);
		p4.setValue("1007020");

		additionalBusinessInfo.getParam().add(p1);
		additionalBusinessInfo.getParam().add(p2);
		additionalBusinessInfo.getParam().add(p3);
		additionalBusinessInfo.getParam().add(p4);
		header.setAdditionalBusinessInfo(additionalBusinessInfo);
		return header;
	}

}
