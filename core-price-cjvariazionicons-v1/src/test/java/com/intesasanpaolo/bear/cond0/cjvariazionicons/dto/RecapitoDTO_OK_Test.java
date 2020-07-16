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
public class RecapitoDTO_OK_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(RecapitoDTO_OK_Test.class);

	private RecapitoDTO recapitoDTO;

	private String tipo = "test tipo";

	private String indirizzo = "via dei test";

	private String cap = "00000";

	private String comune = "Comune di test";

	private String frazione = "Frazione di test";

	private String provincia = "TE";

	@Before
	public void setUp() {
	}

	@Before
	public void initMocks() throws Exception {

		recapitoDTO = new RecapitoDTO();
		recapitoDTO.setTipo(tipo);
		recapitoDTO.setIndirizzo(indirizzo);
		recapitoDTO.setCap(cap);
		recapitoDTO.setComune(comune);
		recapitoDTO.setFrazione(frazione);
		recapitoDTO.setProvincia(provincia);

	}

	@Test
	public void testRecapitoCasoOK() {

		log.info("testRecapitoCasoOK: " + recapitoDTO.toString());

		assertTrue(validaCampi(recapitoDTO).isEmpty());

	}

}
