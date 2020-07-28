package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class RapportoDTO_OK_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(RapportoDTO_OK_Test.class);

	private RapportoDTO rapportoDTO;

	private String codFiliale = "12345";
	private String codCategoria = "1234";
	private String codProgressivo = "12345678";

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		rapportoDTO = new RapportoDTO();
		rapportoDTO.setCodFiliale(codFiliale);
		rapportoDTO.setCodCategoria(codCategoria);
		rapportoDTO.setCodProgressivo(codProgressivo);

	}

	@Test
	public void testRapportoCasoOK() {

		log.info("testRapportoCasoOK: " + rapportoDTO.toString());

		assertTrue(validaCampi(rapportoDTO).isEmpty());

	}

}
