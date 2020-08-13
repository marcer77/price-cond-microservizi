package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTBST;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTESI;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class FL03CtgResponseTansformerTest extends BaseTest{

	@Autowired
	private FL03CtgResponseTansformer fl03CtgResponseTansformer;
	
	@Test
	public void testTrasform01() {
		CtgConnectorResponse<C_FL03S00> ctgResponse=new CtgConnectorResponse<C_FL03S00>();
		ctgResponse.setResult(new C_FL03S00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC="0000";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_MSG="OK";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_ANOM="OK";

		ctgResponse.getResult().OUTBST=new OUTBST[1]; 
		ctgResponse.getResult().OUTBST[0]=new OUTBST();
		ctgResponse.getResult().OUTBST[0].ID_TEMPLATE="10000";
		
		ctgResponse.getResult().OUTSEG=new OUTSEG[1]; 
		ctgResponse.getResult().OUTSEG[0]=new OUTSEG();
		ctgResponse.getResult().OUTSEG[0].TXT_SEGNALAZIONE=" ";
		ctgResponse.getResult().OUTSEG[0].LIVELLO_SEGNALAZIONE=" ";
		
		FL03Response fl03Response = fl03CtgResponseTansformer.transform(ctgResponse);
		assertTrue(fl03Response.getOutEsi().getMdwEsiRetc().equals("0000"));
		
	}
	
	
	
	@Test
	public void testTrasform02() {
		CtgConnectorResponse<C_FL03S00> ctgResponse=new CtgConnectorResponse<C_FL03S00>();
		ctgResponse.setResult(new C_FL03S00());
		
		//
		ctgResponse.getResult().OUTESI=null;
		ctgResponse.getResult().OUTSEG=null;
		ctgResponse.getResult().OUTBST=null;
		FL03Response fl03Response = fl03CtgResponseTansformer.transform(ctgResponse);
		assertTrue(fl03Response.getOutEsi()!=null);
		
	}
	
	@Test
	public void testTrasform03() {
		CtgConnectorResponse<C_FL03S00> ctgResponse=new CtgConnectorResponse<C_FL03S00>();
		ctgResponse.setResult(new C_FL03S00());
		
		//
		ctgResponse.getResult().OUTESI=new OUTESI[0];
		ctgResponse.getResult().OUTSEG=new OUTSEG[0];
		ctgResponse.getResult().OUTBST=new OUTBST[0];
		FL03Response fl03Response = fl03CtgResponseTansformer.transform(ctgResponse);
		assertTrue(fl03Response!=null);
		
	}
	
	@Test
	public void testTrasform04() {
		CtgConnectorResponse<C_FL03S00> ctgResponse=new CtgConnectorResponse<C_FL03S00>();
		ctgResponse.setResult(new C_FL03S00());
		
		//
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTSEG=new OUTSEG[1];
		ctgResponse.getResult().OUTBST=new OUTBST[1];
		
		//
		ctgResponse.getResult().OUTESI[0]=null;
		ctgResponse.getResult().OUTSEG[0]=null;
		ctgResponse.getResult().OUTBST[0]=null;
		
		FL03Response fl03Response = fl03CtgResponseTansformer.transform(ctgResponse);
		assertTrue(fl03Response!=null);
	
		
	}
	
	
}
