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
public class PraticaDTO_KO_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(PraticaDTO_KO_Test.class);

	private static String codSuperPratica = "1234561234560";
	private static String codPratica = "1234561234560";
	private static String codPropostaComm = "1234561234560";

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { { null, null, null }, { null, codPratica, null },
				{ codSuperPratica, null, null }, { null, null, codPropostaComm }, { "", codPratica, "" },
				{ codSuperPratica, "", "" }, { "", "", codPropostaComm }, { "12345612345az", codPratica, "" },
				{ "12345612345AZ", codPratica, "" }, { "12345612345aZ", codPratica, "" },
				{ "1234561234560000", codPratica, "" }, { "1234", codPratica, "" },
				{ codSuperPratica, "12345612345az", codPropostaComm },
				{ codSuperPratica, "12345612345AZ", codPropostaComm },
				{ codSuperPratica, "12345612345aZ", codPropostaComm },
				{ codSuperPratica, "1234561234560000", codPropostaComm },
				{ codSuperPratica, "1234", codPropostaComm } });
	}

	@Parameter(0)
	public String codSuperPraticaErrato;

	@Parameter(1)
	public String codPraticaErrato;

	@Parameter(2)
	public String codPropostaCommErrato;

	@Before
	public void initMocks() throws Exception {

	}

	@Test
	public void testPraticaCasoKO() {

		PraticaDTO dto = new PraticaDTO(codSuperPraticaErrato, codPraticaErrato, codPropostaComm);

		log.info("testPraticaCasoKO: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}

}
