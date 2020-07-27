package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

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
		//ServiceUtil.setHeaders(obj, ispWebservicesHeaderType);
		//System.out.println(obj.getCOD_ABI());
		// Assert.assertTrue(inheader.COD_ABI.equals("01025"));

	}
}
