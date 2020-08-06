package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO_OK_Test;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBeneficioValoreParametrato;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ConfigurazioneFasce;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class InfoCovenantBuilderTest extends JUnitUtils {
	
	private Logger log = Logger.getLogger(InfoCovenantBuilderTest.class);
	
	private InfoCovenantBuilder infoCovenantBuilder;

	@Before
	public void setUp() {
	}
	
	@Before
	public void initMocks() throws Exception {

		RespGetCovenantPerConvenzioneCovenantDaAttivare infoConvenant = new RespGetCovenantPerConvenzioneCovenantDaAttivare();
		infoCovenantBuilder = new InfoCovenantBuilder(infoConvenant);

	}

	@Test
	public void testBuilderOK() {

		log.info("testBuilderOK: " + infoCovenantBuilder.build());

	}
}
