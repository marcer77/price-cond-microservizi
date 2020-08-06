package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTESI;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class FL03CtgResponseTansformerTest extends BaseTest{

	@Autowired
	private FL03CtgResponseTansformer fl03CtgResponseTansformer;
	
	@Test
	public void testTrasform() {
		CtgConnectorResponse<C_FL03S00> ctgResponse=new CtgConnectorResponse<C_FL03S00>();
		ctgResponse.setResult(new C_FL03S00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC="00";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_MSG="OK";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_ANOM="OK";

		FL03Response fl03Response = fl03CtgResponseTansformer.transform(ctgResponse);
		assertTrue(fl03Response.getMdwEsiRetc().equals("00"));
	}
	
	
}
