package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

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
public class T1SFCtgResponseTansformerTest extends BaseTest{
	
	@Autowired
	private T1SFCtgResponseTansformer t1sfCtgResponseTansformer;
		
	@Test
	public void testTrasform() {
		CtgConnectorResponse<C_T1SFS00> ctgResponse=new CtgConnectorResponse<C_T1SFS00>();
		ctgResponse.setResult(new C_T1SFS00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		//ctgResponse.getResult().OUTESI[0].ESITO="00";
		
		T1SFResponse fl03Response = t1sfCtgResponseTansformer.transform(ctgResponse);
		//assertTrue(fl03Response.getEsito().equals("00"));
	}

}
