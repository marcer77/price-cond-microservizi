package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTBST;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTESI;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class T1SJCtgResponseTansformerTest extends BaseTest{
	
	@Autowired
	private T1SJCtgResponseTansformer t1sfCtgResponseTansformer;
		
	@Test
	public void testTrasform01() {
		CtgConnectorResponse<C_T1SJS00> ctgResponse=new CtgConnectorResponse<C_T1SJS00>();
		ctgResponse.setResult(new C_T1SJS00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC="0000";
		
		ctgResponse.getResult().OUTSEG=new OUTSEG[1];
		ctgResponse.getResult().OUTSEG[0]=new OUTSEG();
		ctgResponse.getResult().OUTSEG[0].TXT_SEGNALAZIONE="";
		ctgResponse.getResult().OUTSEG[0].LIVELLO_SEGNALAZIONE="";
		
		ctgResponse.getResult().OUTBST=new OUTBST[1];
		ctgResponse.getResult().OUTBST[0]=new OUTBST();
		ctgResponse.getResult().OUTBST[0].T1SJ_O_KEY_OPERAZIONE="1213232";
		
		
		T1SJResponse fl03Response = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(fl03Response.getOutEsi().getMdwEsiRetc().equals("0000"));
	}
	
	@Test
	public void testTrasform02() {
		CtgConnectorResponse<C_T1SJS00> ctgResponse=new CtgConnectorResponse<C_T1SJS00>();
		ctgResponse.setResult(new C_T1SJS00());
	
		//
		ctgResponse.getResult().OUTESI=null;
		ctgResponse.getResult().OUTSEG=null;
		ctgResponse.getResult().OUTBST=null;
		T1SJResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res.getOutEsi()!=null);
		
	}
	
	@Test
	public void testTrasform03() {
		CtgConnectorResponse<C_T1SJS00> ctgResponse=new CtgConnectorResponse<C_T1SJS00>();
		ctgResponse.setResult(new C_T1SJS00());
	
		//
		ctgResponse.getResult().OUTESI=new OUTESI[0];
		ctgResponse.getResult().OUTSEG=new OUTSEG[0];
		ctgResponse.getResult().OUTBST=new OUTBST[0];
		T1SJResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res!=null);
		
	}
	
	@Test
	public void testTrasform04() {
		CtgConnectorResponse<C_T1SJS00> ctgResponse=new CtgConnectorResponse<C_T1SJS00>();
		ctgResponse.setResult(new C_T1SJS00());
	
		//
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTSEG=new OUTSEG[1];
		ctgResponse.getResult().OUTBST=new OUTBST[1];
		ctgResponse.getResult().OUTESI[0]=null;
		ctgResponse.getResult().OUTSEG[0]=null;
		ctgResponse.getResult().OUTBST[0]=null;
		
		T1SJResponse res = t1sfCtgResponseTansformer.transform(ctgResponse);
		assertTrue(res!=null);
		
	}

}
