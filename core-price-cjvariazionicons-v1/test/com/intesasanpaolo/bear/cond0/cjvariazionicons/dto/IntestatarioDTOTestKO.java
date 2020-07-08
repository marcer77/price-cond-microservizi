package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(Parameterized.class)
public class IntestatarioDTOTestKO extends JUnitUtils {

	private Logger log = Logger.getLogger(FirmatarioDTOTestKO.class);

	private static String intestazione = "Intestazione di test";
	private static String ndg = "1234561234560";
	private static String specieGiur = "PERSO";
	private static String codFiscale = "RSSMRA80A01H703F";
	private static String pIva = "12345678901";
	private static List<RecapitoDTO> recapitiErr;

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { { intestazione, ndg, specieGiur, codFiscale, pIva, 1 },
				{ null, ndg, specieGiur, codFiscale, pIva, 1 }, { "", ndg, specieGiur, codFiscale, pIva, 1 },
				{ intestazione, null, specieGiur, codFiscale, pIva, 1 },
				{ intestazione, "", specieGiur, codFiscale, pIva, 1 }, { intestazione, ndg, null, codFiscale, pIva, 1 },
				{ intestazione, ndg, "", codFiscale, pIva, 1 }, { intestazione, ndg, specieGiur, null, pIva, 1 },
				{ intestazione, ndg, specieGiur, "", pIva, 1 }, { intestazione, ndg, specieGiur, codFiscale, null, 1 },
				{ intestazione, ndg, specieGiur, codFiscale, "", 1 },
				{ intestazione, ndg, specieGiur, codFiscale, "123456789", 1 },
				{ intestazione, ndg, specieGiur, codFiscale, "123456789123", 1 },
				{ intestazione, ndg, "123456", codFiscale, pIva, 1 },
				{ intestazione, ndg, specieGiur, "RSSMRA0A01H703F0", pIva, 1 },
				{ intestazione, ndg, specieGiur, codFiscale, pIva, 0 } });
	}

	@Parameter(0)
	public String ndgErr;
	@Parameter(1)
	public String intestazioneErr;
	@Parameter(2)
	public String specieGiurErr;
	@Parameter(3)
	public String codFiscaleErr;
	@Parameter(4)
	public String pIvaErr;
	@Parameter(5)
	public int numRecapiti;

	@Before
	public void initMocks() throws Exception {

		recapitiErr = new ArrayList<RecapitoDTO>();
		for (int i = 0; i < numRecapiti; i++) {
			recapitiErr.add(new RecapitoDTO());
		}

	}

	@Test
	public void testIntestatarioCasoKO() {

		IntestatarioDTO dto = new IntestatarioDTO(ndgErr, intestazioneErr, specieGiurErr, codFiscaleErr, pIvaErr,
				recapitiErr);

		log.info("testIntestatarioCasoKO: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}
}
