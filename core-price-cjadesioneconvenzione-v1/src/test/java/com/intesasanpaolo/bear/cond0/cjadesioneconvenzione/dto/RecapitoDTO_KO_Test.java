package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;

@RunWith(Parameterized.class)
public class RecapitoDTO_KO_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(RecapitoDTO_KO_Test.class);

	private static String tipo = "test tipo";

	private static String indirizzo = "via dei test";

	private static String cap = "00000";

	private static String comune = "Comune di test";

	private static String frazione = "Frazione di test";

	private static String provincia = "TE";

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { { null, null, null, null, null, null }, { "", "", "", "", "", "" },
				{ tipo, indirizzo, "0000", comune, frazione, provincia },
				{ tipo, indirizzo, "000000", comune, frazione, provincia },
				{ tipo, indirizzo, cap, "test comune maggiore di trentadue caratteri", frazione, provincia },
				{ tipo, indirizzo, cap, comune, "test frazione maggiore di venticinque caratteri", provincia },
				{ tipo, indirizzo, cap, comune, frazione, "AAA" }, { tipo, indirizzo, cap, comune, frazione, "A" } });
	}

	@Parameter(0)
	public String tipoErrato;

	@Parameter(1)
	public String indirizzoErrato;

	@Parameter(2)
	public String capErrato;

	@Parameter(3)
	public String comuneErrato;

	@Parameter(4)
	public String frazioneErrata;

	@Parameter(5)
	public String provinciaErrata;

	@Before
	public void initMocks() throws Exception {

	}

	@Test
	public void testRecapitoCasoKO() {

		RecapitoDTO dto = new RecapitoDTO(tipoErrato, indirizzoErrato, capErrato, comuneErrato, frazioneErrata,
				provinciaErrata);

		log.info("testRecapitoCasoKO: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}

}
