package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBeneficioValoreParametrato;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ConfigurazioneFasce;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class BeneficiBuilderTest {
	
	private Logger log = Logger.getLogger(BeneficiBuilderTest.class);
	
	
	@Before
	public void setUp() {
	}
	
	@Before
	public void initMocks() throws Exception {

		
	}

	@Test
	public void testBuilderOK() {
		AdesioneResponseBenefici ad=mockAdesioneResponseBenefici();
		ad.setFlagRolling("S");
		BeneficiBuilder beneficiBuilder = new BeneficiBuilder(ad);
		String beneficio=beneficiBuilder.build();
		log.info("testBuilderOK: " +beneficio);
		assertTrue(beneficio.length()>0);

	}
	
	@Test
	public void testBuilderOK1() {
		BeneficiBuilder beneficiBuilder = new BeneficiBuilder(mockAdesioneResponseBenefici());
		String beneficio=beneficiBuilder.build();
		log.info("testBuilderOK: " +beneficio);
		assertTrue(beneficio.length()>0);
	}
	
	@Test
	public void testBuilderOK2() {
		AdesioneResponseBenefici ad=mockAdesioneResponseBenefici();
		ad.getBeneficioValoreParametrato().setParametroSpread(new BigDecimal(10));
		BeneficiBuilder beneficiBuilder = new BeneficiBuilder(ad);
		String beneficio=beneficiBuilder.build();
		log.info("testBuilderOK: " +beneficio);
		assertTrue(beneficio.length()>0);
	}
	
	/*@Test
	public void testBuilderOK3() {
		AdesioneResponseBenefici ad=mockAdesioneResponseBenefici();
		ad.setBeneficioValoreParametrato(null);
		BeneficiBuilder beneficiBuilder = new BeneficiBuilder(ad);
		String beneficio=beneficiBuilder.build();
		log.info("testBuilderOK: " +beneficio);
		assertTrue(beneficio.length()>0);
	}*/
	/*private String getValoreCodice() {
		if (adesioneResponseBenefici.getBeneficioValoreParametrato() != null
				|| adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroPerc1() != null
				|| adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread() != null || StringUtils
						.isNotEmpty(adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroCodice1())) {
			return "S";
		} else {
			return "N";
		}
	}
	*/
	
	private AdesioneResponseBenefici mockAdesioneResponseBenefici() {
		AdesioneResponseBenefici adesioneResponseBenefici = new AdesioneResponseBenefici();
		adesioneResponseBenefici.setConfigurazioneFasceApprovato(new ConfigurazioneFasce());
		adesioneResponseBenefici.setNumeroFascia((short) 0);
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
		return adesioneResponseBenefici;
	}
}
