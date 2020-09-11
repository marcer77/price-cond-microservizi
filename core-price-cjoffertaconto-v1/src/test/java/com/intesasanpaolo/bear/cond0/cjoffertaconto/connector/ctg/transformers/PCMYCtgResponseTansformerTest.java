package com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.C_PCMYS00;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTBST;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTCPR;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTESI;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTOFF;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTPRD;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class PCMYCtgResponseTansformerTest extends BaseTest{
	
	@MockBean
	private BeanFactory beanFactoryMock;
	
	@Autowired
	private PCMYCtgResponseTansformer pcmyCtgResponseTansformer;
	
	@Test
	public void testTrasform() {
		CtgConnectorResponse<C_PCMYS00> ctgResponse=new CtgConnectorResponse<C_PCMYS00>();
		ctgResponse.setResult(new C_PCMYS00());
		ctgResponse.getResult().OUTBST = new OUTBST[1];
		ctgResponse.getResult().OUTBST[0] = new OUTBST();
		ctgResponse.getResult().OUTESI = new OUTESI[1];
		ctgResponse.getResult().OUTESI[0] = new OUTESI();
		ctgResponse.getResult().OUTSEG = new OUTSEG[1];
		ctgResponse.getResult().OUTSEG[0] = new OUTSEG();
		ctgResponse.getResult().OUTBST[0].OUTOFF = new OUTOFF[1];
		ctgResponse.getResult().OUTBST[0].OUTOFF[0] = new OUTOFF();
		ctgResponse.getResult().OUTBST[0].OUTPRD = new OUTPRD[1];
		OUTPRD prod = new OUTPRD();
		OUTCPR prodVal = new OUTCPR();
		prod.OUTCPR = new OUTCPR[1];
		prod.OUTCPR[0] = prodVal;
		ctgResponse.getResult().OUTBST[0].OUTPRD[0] = prod;
		PCMYResponse pcmyResponse = pcmyCtgResponseTansformer.transform(ctgResponse);
		assertTrue(pcmyResponse!=null);
	}

}
