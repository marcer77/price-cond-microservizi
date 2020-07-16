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
public class FirmatarioDTO_KO_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(FirmatarioDTO_KO_Test.class);

	private static String intestazione = "Intestazione di test";
	private static String ndg = "1234561234560";

	@Before
	public void setUp() {
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramErrati() {
		return Arrays.asList(new Object[][] { 
			{ null, null }, 
			{ null, intestazione }, 
			{ ndg, null },
			{ "", intestazione }, 
			{ ndg, "" }, 
			{ "12345612345aZ", intestazione },
			{ "12345612345AZ", intestazione },
			{ "12345612345az", intestazione },
			{ "1234561234560000", intestazione },
			{ "1234", intestazione } });
	}

	@Parameter(0)
	public String ndgErrato;

	@Parameter(1)
	public String intestazioneErrata;

	@Before
	public void initMocks() throws Exception {}

	@Test
	public void testFirmatarioCasiKO() {

		FirmatarioDTO dto = new FirmatarioDTO(ndgErrato, intestazioneErrata);

		log.info("testFirmatarioCasoOK: " + dto.toString());

		assertTrue(!validaCampi(dto).isEmpty());

	}

}
