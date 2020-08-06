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
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class BeneficiBuilderTest extends JUnitUtils {
	
	private Logger log = Logger.getLogger(BeneficiBuilderTest.class);
	
	private BeneficiBuilder beneficiBuilder;

	@Before
	public void setUp() {
	}
	
	@Before
	public void initMocks() throws Exception {

		AdesioneResponseBenefici adesioneResponseBenefici = new AdesioneResponseBenefici();
		adesioneResponseBenefici.setConfigurazioneFasceApprovato(new ConfigurazioneFasce());
		adesioneResponseBenefici.setNumeroFascia((short) 0);
//		ddMMyyyy
		String data = "06082020"; 
		adesioneResponseBenefici.setDataDecorrenza(data);
		adesioneResponseBenefici.setDataScadenza(data);
		adesioneResponseBenefici.setBeneficioValoreNumerico(new BigDecimal(1));
		AdesioneResponseBeneficioValoreParametrato beneficioValoreParametrato = new AdesioneResponseBeneficioValoreParametrato();
		beneficioValoreParametrato.setParametroPerc1(new BigDecimal(1));
		beneficioValoreParametrato.setParametroPerc2(new BigDecimal(1));
		adesioneResponseBenefici.setBeneficioValoreParametrato(beneficioValoreParametrato);
		adesioneResponseBenefici.setDriver1ValoreNumerico(new BigDecimal(1));
		adesioneResponseBenefici.setDriver2ValoreNumerico(new BigDecimal(1));
		beneficiBuilder = new BeneficiBuilder(adesioneResponseBenefici);

	}

	@Test
	public void testBuilderOK() {

		log.info("testBuilderOK: " + beneficiBuilder.build());

	}
}
