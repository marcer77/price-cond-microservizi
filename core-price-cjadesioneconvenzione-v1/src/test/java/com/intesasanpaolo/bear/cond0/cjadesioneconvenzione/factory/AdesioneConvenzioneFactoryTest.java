package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.factory;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.AdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBeneficioValoreParametrato;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ConfigurazioneFasce;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdesioneConvenzioneFactoryTest extends BaseTest{

	@Autowired 
	private AdesioneConvenzioneFactory adesioneConvenzioneFactory;
	
	@Test
	public void test01() {
		InputStampaDTO inputStampaDTO=buildInputStampaDTO();
		
		RespGetRequisitiAdesioneConvenzione getReqAdesConResp=new RespGetRequisitiAdesioneConvenzione();
		getReqAdesConResp.setTabellaBeneficiLength(2);
		getReqAdesConResp.setTabellaBenefici(new ArrayList<AdesioneResponseBenefici>());
		
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
		getReqAdesConResp.getTabellaBenefici().add(adesioneResponseBenefici);
		//
		adesioneResponseBenefici = new AdesioneResponseBenefici();
		adesioneResponseBenefici.setConfigurazioneFasceApprovato(new ConfigurazioneFasce());
		adesioneResponseBenefici.setNumeroFascia((short) 0);
		data = "06082020"; 
		adesioneResponseBenefici.setFlagRolling("S");
		adesioneResponseBenefici.setDataDecorrenza(data);
		adesioneResponseBenefici.setDataScadenza(data);
		adesioneResponseBenefici.setBeneficioValoreNumerico(new BigDecimal(1));
		beneficioValoreParametrato = new AdesioneResponseBeneficioValoreParametrato();
		beneficioValoreParametrato.setParametroPerc1(new BigDecimal(1));
		beneficioValoreParametrato.setParametroPerc2(new BigDecimal(1));
		adesioneResponseBenefici.setBeneficioValoreParametrato(beneficioValoreParametrato);
		adesioneResponseBenefici.setDriver1ValoreNumerico(new BigDecimal(1));
		adesioneResponseBenefici.setDriver2ValoreNumerico(new BigDecimal(1));
		getReqAdesConResp.getTabellaBenefici().add(adesioneResponseBenefici);
		
		
		AdesioneConvenzione model=adesioneConvenzioneFactory.createAdesioneConvenzione(mockISPWebservicesHeaderType(), inputStampaDTO, new ArrayList<RespGetCovenantPerConvenzioneCovenantDaAttivare>(), getReqAdesConResp, "1234567");
		assertTrue(model.getTb59r009List().size()>0);
			
	}
	
}
