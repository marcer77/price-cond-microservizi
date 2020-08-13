package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.resource.BaseResource;
import com.intesasanpaolo.bear.exceptions.model.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RunWith(SpringRunner.class)
public class ServiceUtilTest {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	class HeaderMock {
		public int RETCODE;

		public String CODICESTATO;

		public String ID_SERVIZIO;

		public String CODICE_TIPO_CANALE;

		public String CODICE_SOCIETA;

		public String CODICE_SPORTELLO;

		public String CODICE_UO_RICH;

		public String CODICE_USERID;

		public String MQM_NAME_DEST;

		public String COD_RIS_RICH;

		public String COD_RICH_CANALE;

		public String DATA_CONT;

		public int LUNGHEZZA_MSG;

		public String IND_MQ_SINCRONO;

		public String COD_TIPO_LINGUA;

		public String TIPO_SIC_APPL_INP;

		public String TIPO_SIC_APPL_OUT;

		public String IND_COMPRESS_INP;

		public String IND_COMPRESS_OUT;

		public String IND_ROUTING_MSG;

		public String COD_SSA_SERVIZIO;

		public String IND_INOLTRO_REPLY;

		public String COD_ABI;

		public String COD_AZIENDA_DEST;

		public String COD_OPERATIVITA;

		public String FLAG_PAPERLESS;

		public String FLAG_RACF;

		public String COD_RIC_TRAC;

		public String HSP_IND_ATOM;

		public String HSP_TRN_ATOM;

		public String HSP_PGM_ATOM;

		public String HSP_TIMEOUT;

		public String HSP_ACRONIMO;

		public String HSP_FLAG24X7;

		public String HSP_CONV_NULL;

		public String HSP_ACRONIMO_PROVIDER;

		public String HSP_TIMEIIB;

		public String COD_BSM;

		public String SIC_TIMESTAMP;

		public String SIC_KEY;

		public String SIC_MAC;

		public String COD_VERS_SIC;

		public String COD_CLI_RICH;

		public String COD_TERM_CICS;

		public String COD_VERSIONE_BS;

	}

	@Test
	public void testSetHeaders() {
		HeaderMock obj = new HeaderMock();

		// INHEADER inheader = new INHEADER();

		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("121").callerCompanyIDCode("01").callerProgramName("121").channelIDCode("")
				.codABI("01025").codUnitaOperativa("00700").customerID("23232").isVirtualUser("false").language("IT")
				.serviceCompanyIDCode("01").serviceID("FL030FLA01").userID("343").transactionId("3434343")
				.timestamp("0").serviceVersion("00").build();
		// ServiceUtil.setHeaders(obj, ispWebservicesHeaderType);
		// System.out.println(obj.getCOD_ABI());
		// Assert.assertTrue(inheader.COD_ABI.equals("01025"));

	}

	@Test
	public void testFormattaDouble() {
		Double d = new Double(123.5677);
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(d, null));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(10000.232, null));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(0.23343, "#######.##"));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(0.23343, "#######"));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(10000.232, "#######"));
	}

	@Test
	public void testFormattaNumero() {
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(10000.232));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(null));
	}

	

	@Test
	public void testIfNull() {
		ServiceUtil.ifNull(null, "valore");
		ServiceUtil.ifNull("test", "valore");
	}

	@Test
	public void testIfNullAsInt() {
		ServiceUtil.ifNullAsInt(null, 0);
		ServiceUtil.ifNullAsInt(13, 0);
	}

	@Test
	public void testStampaOggetto() {
		BaseResource baseResource=new BaseResource();
		baseResource.setEntityId("12");
		baseResource.setReturnMessages(new HashMap<String, List<ErrorMessage>>());
		String st=ServiceUtil.stampaOggetto(baseResource).toString();
		Assert.assertTrue(!st.equals(""));
	}

	@Test
	public void testSetBSHeaders() {
		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("0").callerCompanyIDCode("01").callerProgramName("1").channelIDCode("0").codABI("01025")
				.codUnitaOperativa("0").customerID("0").isVirtualUser("false").language("I").serviceCompanyIDCode("01")
				.serviceID("00").userID("U015886").transactionId("0").timestamp("0").serviceVersion("0").build();

		HeaderMock header = new HeaderMock();

		ServiceUtil.setBSHeaders(header, BSTypeCall.FL03S00_CALL, ispWebservicesHeaderType);
	}
	
	@Test	
	public void testIfNullAsDouble() throws ParseException {
		Double d=ServiceUtil.ifNullAsDouble(null);
		Assert.assertTrue(d==0);
		d=ServiceUtil.ifNullAsDouble(40);
		Assert.assertTrue(d==40);
	}
	
	
}
