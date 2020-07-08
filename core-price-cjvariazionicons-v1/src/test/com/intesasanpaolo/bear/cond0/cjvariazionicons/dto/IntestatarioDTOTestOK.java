package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class IntestatarioDTOTestOK extends JUnitUtils {

	private Logger log = Logger.getLogger(FirmatarioDTOTestKO.class);

	private IntestatarioDTO intestatarioDTO;

	private static String intestazione = "Intestazione di test";
	private static String ndg = "1234561234560";
	private static String specieGiur = "PERSO";
	private static String codFiscale = "RSSMRA80A01H703F";
	private static String pIva = "12345678901";
	private static List<RecapitoDTO> recapiti;

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		intestatarioDTO = new IntestatarioDTO();
		intestatarioDTO.setNdg(ndg);
		intestatarioDTO.setIntestazione(intestazione);
		intestatarioDTO.setSpecieGiur(specieGiur);
		intestatarioDTO.setCodFiscale(codFiscale);
		intestatarioDTO.setPIva(pIva);

		recapiti = new ArrayList<RecapitoDTO>();

		recapiti.add(new RecapitoDTO());

		intestatarioDTO.setRecapiti(recapiti);

	}

	@Test
	public void testIntestatarioCasoOK() {

		log.info("testIntestatarioCasoOK: " + intestatarioDTO.toString());

		assertTrue(validaCampi(intestatarioDTO).isEmpty());

	}

}
