package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

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

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(Parameterized.class)
@Ignore
public class RapportoDTO_KO_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(RapportoDTO_KO_Test.class);

	private static String codFiliale = "12345";
	private static String codCategoria = "1234";
	private static String codProgressivo = "12345678";

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { { null, null, null },

				{ "", "", "" },

				{ codFiliale, null, null }, { null, codCategoria, null }, { null, null, codProgressivo },

				{ codFiliale, "", "" }, { "", codCategoria, "" }, { "", "", codProgressivo },
				{ "123aZ", codCategoria, codProgressivo }, { "123AZ", codCategoria, codProgressivo },
				{ "123az", codCategoria, codProgressivo }, { "123456", codCategoria, codProgressivo },
				{ "1234", codCategoria, codProgressivo }, { codFiliale, "12AZ", codProgressivo },
				{ codFiliale, "12az", codProgressivo }, { codFiliale, "12aZ", codProgressivo },
				{ codFiliale, "123", codProgressivo }, { codFiliale, "12345", codProgressivo },
				{ codFiliale, codCategoria, "123456az" }, { codFiliale, codCategoria, "123456AZ" },
				{ codFiliale, codCategoria, "123456aZ" }, { codFiliale, codCategoria, "123456789" },
				{ codFiliale, codCategoria, "1234567" }

		});
	}

	@Parameter(0)
	public String codFilialeErrato;

	@Parameter(1)
	public String codCategoriaErrato;

	@Parameter(2)
	public String codProgressivoErrato;

	@Before
	public void initMocks() throws Exception {

	}

	@Test
	public void testRapportoCasoKO() {

		RapportoDTO dto = new RapportoDTO(codFilialeErrato, codCategoriaErrato, codProgressivoErrato);

		log.info("testRapportoCasoKO: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}

}
