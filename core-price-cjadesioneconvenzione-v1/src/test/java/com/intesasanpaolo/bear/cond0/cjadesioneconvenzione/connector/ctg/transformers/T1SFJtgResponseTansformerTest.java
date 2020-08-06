package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTESI;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class T1SFJtgResponseTansformerTest extends BaseTest{
	
	@Autowired
	private T1SJCtgResponseTansformer t1sfCtgResponseTansformer;
		
	@Test
	public void testTrasform() {
		CtgConnectorResponse<C_T1SJS00> ctgResponse=new CtgConnectorResponse<C_T1SJS00>();
		ctgResponse.setResult(new C_T1SJS00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		//ctgResponse.getResult().OUTESI[0].ESITO="00";
		
		T1SJResponse fl03Response = t1sfCtgResponseTansformer.transform(ctgResponse);
		//assertTrue(fl03Response.getEsito().equals("00"));
	}

}
