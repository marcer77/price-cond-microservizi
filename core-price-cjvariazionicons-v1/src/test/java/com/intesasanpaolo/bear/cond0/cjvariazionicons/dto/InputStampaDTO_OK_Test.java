package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class InputStampaDTO_OK_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(InputStampaDTO_OK_Test.class);

	private InputStampaDTO inputStampaDTO;

	private static String codAppl = "Codice appl di test";
	private static String codProcesso = "Codice processo di test";
	private static PraticaDTO pratica = new PraticaDTO();
	private static RapportoDTO rapporto = new RapportoDTO();
	private static IntestatarioDTO intestatario = new IntestatarioDTO();
	private static List<FirmatarioDTO> listaFirmatari;
	private static InfoStampaDTO infoStampa = new InfoStampaDTO();

	@Before
	public void setUp() {
	}


	public String codApplErrato;

	public String codProcessoErrato;

	public PraticaDTO praticaErrata;

	public RapportoDTO rapportoErrato;

	public IntestatarioDTO intestatarioErrato;

	public int numFirmatari;

	public InfoStampaDTO infoStampaErrato;

	
	@Before
	public void initMocks() throws Exception {

		inputStampaDTO = new InputStampaDTO();
		inputStampaDTO.setCodAppl(codAppl);
		inputStampaDTO.setCodProcesso(codProcesso);

		inputStampaDTO.setPratica(pratica);
		inputStampaDTO.setRapporto(rapporto);
		inputStampaDTO.setIntestatario(intestatario);

		listaFirmatari = new ArrayList<FirmatarioDTO>();

		for (int i = 0; i < 13; i++) {
			listaFirmatari.add(new FirmatarioDTO());
		}

		inputStampaDTO.setFirmatari(listaFirmatari);

		inputStampaDTO.setInfoStampa(infoStampa);

	}

	//@Test
	public void testInputStampaCasoOK() {

		log.info("testInputStampaCasoOK: " + inputStampaDTO.toString());

		assertTrue(validaCampi(inputStampaDTO).isEmpty());

	}

	

}
