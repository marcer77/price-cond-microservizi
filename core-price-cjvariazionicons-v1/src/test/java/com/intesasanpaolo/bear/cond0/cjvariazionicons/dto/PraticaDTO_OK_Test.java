package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class PraticaDTO_OK_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(PraticaDTO_OK_Test.class);

	private PraticaDTO praticaDTO;

	private static String codSuperPratica = "1234561234560";
	private static String codPratica = "1234561234560";
	private static String codPropostaComm = "1234561234560";

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		praticaDTO = new PraticaDTO();
		praticaDTO.setCodSuperPratica(codSuperPratica);
		praticaDTO.setCodPratica(codPratica);
		praticaDTO.setCodPropostaComm(codPropostaComm);

	}

	@Test
	public void testPraticaCasoOK() {

		log.info("testPraticaCasoOK: " + praticaDTO.toString());

		assertTrue(validaCampi(praticaDTO).isEmpty());

	}

}
