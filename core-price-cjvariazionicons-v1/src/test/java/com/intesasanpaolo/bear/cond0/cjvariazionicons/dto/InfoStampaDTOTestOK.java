package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class InfoStampaDTOTestOK extends JUnitUtils {

	private Logger log = Logger.getLogger(InfoStampaDTOTestOK.class);

	private InfoStampaDTO infoStampaDTO;

	private static Date data = new Date(System.currentTimeMillis());
	private static String tipoStampa = "Stampa di test";
	private static String tipoOfferta = "Offerta di test";
	private static String tipoFirma = "Firma di test";
	private static String codLingua = "Lingua di test";
	private static String keyOper = "123456789012345678901234567890";

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		infoStampaDTO = new InfoStampaDTO();
		infoStampaDTO.setData(data);
		infoStampaDTO.setTipoStampa(tipoStampa);
		infoStampaDTO.setTipoOfferta(tipoOfferta);
		infoStampaDTO.setTipoFirma(tipoFirma);
		infoStampaDTO.setCodLingua(codLingua);
		infoStampaDTO.setKeyOper(keyOper);

	}

	@Test
	public void testInfoStampaCasoOK() {

		log.info("testInfoStampaDTOCasoOK: " + infoStampaDTO.toString());

		assertTrue(validaCampi(infoStampaDTO).isEmpty());

	}

}
