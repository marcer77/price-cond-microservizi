package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;

@RunWith(Parameterized.class)
public class InfoStampaDTO_KO_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(InfoStampaDTO_KO_Test.class);
	
	private static Date data = new Date(System.currentTimeMillis());
	private static String tipoStampa = "Stampa di test";
	private static String tipoOfferta = "Offerta di test";
	private static String tipoFirma = "Firma di test";
	private static String codLingua = "Lingua di test";
	private static String keyOper = "123456789012345678901234567890";

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { { null, tipoStampa, tipoOfferta, tipoFirma, codLingua, keyOper },
				{ data, null, tipoOfferta, tipoFirma, codLingua, keyOper },
				{ data, tipoStampa, null, tipoFirma, codLingua, keyOper },
				{ data, tipoStampa, tipoOfferta, tipoFirma, null, keyOper },
				{ data, tipoStampa, tipoOfferta, tipoFirma, codLingua, null },
				{ data, "", tipoOfferta, tipoFirma, codLingua, keyOper },
				{ data, tipoStampa, "", tipoFirma, codLingua, keyOper },
				{ data, tipoStampa, tipoOfferta, tipoFirma, "", keyOper },
				{ data, tipoStampa, tipoOfferta, tipoFirma, codLingua, "" },
				{ data, tipoStampa, tipoOfferta, tipoFirma, codLingua, "12345678901234567890" },
				{ data, tipoStampa, tipoOfferta, tipoFirma, codLingua, "1234567890123456789012345678901234567890" } });
	}

	@Parameter(0)
	public Date dataErrata;

	@Parameter(1)
	public String tipoStampaErrata;

	@Parameter(2)
	public String tipoOffertaErrata;

	@Parameter(3)
	public String tipoFirmaErrata;

	@Parameter(4)
	public String codLinguaErrata;

	@Parameter(5)
	public String keyOpeErrato;

	@Before
	public void initMocks() throws Exception {
	}

	@Test
	public void testInfoStampaCasoKO() {

		InfoStampaDTO dto = new InfoStampaDTO(dataErrata, tipoStampaErrata, tipoOffertaErrata, tipoFirmaErrata,
				codLinguaErrata, keyOpeErrato);

		log.info("testInfoStampaCasoKO: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}
}
