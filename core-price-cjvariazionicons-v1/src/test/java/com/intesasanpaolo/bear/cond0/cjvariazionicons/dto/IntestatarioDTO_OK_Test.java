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
public class IntestatarioDTO_OK_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(FirmatarioDTO_KO_Test.class);

	private IntestatarioDTO intestatarioDTO;

	private String intestazione = "Intestazione di test";
	private String ndg = "1234561234560";
	private String specieGiur = "PERSO";
	private String codFiscale = "RSSMRA80A01H703F";
	private String pIva = "12345678901";
	private List<RecapitoDTO> recapiti;

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

		RecapitoDTO recapitoDTO = new RecapitoDTO();
		recapitoDTO.setTipo("test tipo");
		recapitoDTO.setIndirizzo("via dei test");
		recapitoDTO.setCap("00000");
		recapitoDTO.setComune("Comune di test");
		recapitoDTO.setFrazione("Frazione di test");
		recapitoDTO.setProvincia("TE");
		recapiti.add(recapitoDTO);

		intestatarioDTO.setRecapiti(recapiti);

	}

	@Test
	public void testIntestatarioCasoOK() {

		log.info("testIntestatarioCasoOK: " + intestatarioDTO.toString());

		assertTrue(validaCampi(intestatarioDTO).isEmpty());

	}

}
