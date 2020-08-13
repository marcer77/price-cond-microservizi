package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTESI;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class T1SFCtgResponseTansformerTest extends BaseTest {

	@Autowired
	private T1SFCtgResponseTansformer t1sfCtgResponseTansformer;

	@Test
	public void testTrasform() {
		CtgConnectorResponse<C_T1SFS00> ctgResponse = new CtgConnectorResponse<C_T1SFS00>();
		ctgResponse.setResult(new C_T1SFS00());
		ctgResponse.getResult().OUTESI = new OUTESI[1];
		ctgResponse.getResult().OUTESI[0] = new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC = "0000";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_MSG = "OK";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_ANOM = "OK";
		ctgResponse.getResult().OUTSEG = new com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTSEG[1];
		ctgResponse.getResult().OUTSEG[0] = new com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTSEG();
		ctgResponse.getResult().OUTSEG[0].O_TXT_SEGNALAZIONE = " ";
		ctgResponse.getResult().OUTSEG[0].O_LIVELLO_SEGNALAZIONE = " ";

		T1SFResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res.getOutEsi().getMdwEsiRetc().equals("0000"));

	}

	@Test
	public void testTrasform02() {
		CtgConnectorResponse<C_T1SFS00> ctgResponse = new CtgConnectorResponse<C_T1SFS00>();
		ctgResponse.setResult(new C_T1SFS00());

		//
		ctgResponse.getResult().OUTESI = null;
		ctgResponse.getResult().OUTSEG = null;
		ctgResponse.getResult().OUTBST = null;
		T1SFResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res.getOutEsi() != null);

	}

	@Test
	public void testTrasform03() {
		CtgConnectorResponse<C_T1SFS00> ctgResponse = new CtgConnectorResponse<C_T1SFS00>();
		ctgResponse.setResult(new C_T1SFS00());

		//
		ctgResponse.getResult().OUTESI = new OUTESI[0];
		ctgResponse.getResult().OUTSEG = new com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTSEG[0];
		ctgResponse.getResult().OUTBST = new com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTBST[0];
		T1SFResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res != null);

	}

	@Test
	public void testTrasform04() {
		CtgConnectorResponse<C_T1SFS00> ctgResponse = new CtgConnectorResponse<C_T1SFS00>();
		ctgResponse.setResult(new C_T1SFS00());

		//
		ctgResponse.getResult().OUTESI = new OUTESI[1];
		ctgResponse.getResult().OUTSEG = new com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTSEG[1];
		ctgResponse.getResult().OUTBST = new com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTBST[1];

		//
		ctgResponse.getResult().OUTESI[0] = null;
		ctgResponse.getResult().OUTSEG[0] = null;
		ctgResponse.getResult().OUTBST[0] = null;

		T1SFResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res != null);

	}

}
