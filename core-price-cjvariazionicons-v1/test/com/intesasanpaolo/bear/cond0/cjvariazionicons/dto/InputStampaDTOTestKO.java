package com.intesasanpaolo.bear.cond0.cjvariazionicons.dto;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.utils.JUnitUtils;

@RunWith(Parameterized.class)
public class InputStampaDTOTestKO extends JUnitUtils {

	private Logger log = Logger.getLogger(InputStampaDTOTestKO.class);

	private static String codAppl = "Codice appl di test";
	private static String codProcesso = "Codice processo di test";
	private static PraticaDTO pratica = new PraticaDTO();
	private static RapportoDTO rapporto = new RapportoDTO();
	private static IntestatarioDTO intestatario = new IntestatarioDTO();
	private static InfoStampaDTO infoStampa = new InfoStampaDTO();

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { { null, null, pratica, rapporto, intestatario, 13, infoStampa },
				{ "", "", pratica, rapporto, intestatario, 13, infoStampa },
				{ codAppl, null, pratica, rapporto, intestatario, 13, infoStampa },
				{ codAppl, "", pratica, rapporto, intestatario, 13, infoStampa },
				{ codAppl, codProcesso, pratica, rapporto, intestatario, 0, infoStampa },
				{ codAppl, codProcesso, pratica, rapporto, intestatario, 14, infoStampa },
				{ codAppl, codProcesso, null, rapporto, intestatario, 13, infoStampa },
				{ codAppl, codProcesso, pratica, null, intestatario, 13, infoStampa },
				{ codAppl, codProcesso, pratica, rapporto, null, 13, infoStampa },
				{ codAppl, codProcesso, pratica, rapporto, intestatario, 13, null } });
	}

	@Parameter(0)
	public String codApplErrato;

	@Parameter(1)
	public String codProcessoErrato;

	@Parameter(2)
	public PraticaDTO praticaErrata;

	@Parameter(3)
	public RapportoDTO rapportoErrato;

	@Parameter(4)
	public IntestatarioDTO intestatarioErrato;

	@Parameter(5)
	public int numFirmatari;

	@Parameter(6)
	public InfoStampaDTO infoStampaErrato;

	public List<FirmatarioDTO> listaErrataFirmatari;

	@Before
	public void initMocks() throws Exception {

		listaErrataFirmatari = new ArrayList<FirmatarioDTO>();

		for (int i = 0; i < numFirmatari; i++) {
			listaErrataFirmatari.add(new FirmatarioDTO());
		}

	}

	@Test
	public void testInputStampaCasoKO() {

		InputStampaDTO dto = new InputStampaDTO(codApplErrato, codProcessoErrato, praticaErrata, rapportoErrato,
				intestatarioErrato, listaErrataFirmatari, infoStampaErrato);

		log.info("testInputStampaCasoKO: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}

}
