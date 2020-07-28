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
public class FirmatarioDTO_OK_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(FirmatarioDTO_OK_Test.class);

	private FirmatarioDTO firmatarioDTO;

	private String intestazione = "Intestazione di test";
	private String ndg = "1234561234560";

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		firmatarioDTO = new FirmatarioDTO();
		firmatarioDTO.setNdg(ndg);
		firmatarioDTO.setIntestazione(intestazione);

	}

	@Test
	public void testFirmatarioCasoOK() {

		log.info("testFirmatarioCasoOK: " + firmatarioDTO.toString());

		assertTrue(validaCampi(firmatarioDTO).isEmpty());

	}

}
