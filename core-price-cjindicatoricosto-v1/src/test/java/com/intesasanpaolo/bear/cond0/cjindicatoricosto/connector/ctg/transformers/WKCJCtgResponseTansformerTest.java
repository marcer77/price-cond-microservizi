package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.C_WKCJS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTBST;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTCNF;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTESI;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class WKCJCtgResponseTansformerTest extends BaseTest{

	@Autowired
	private WKCJCtgResponseTansformer wkcjCtgResponseTansformer;
	

	@Test
	public void testTrasform01() {
		CtgConnectorResponse<C_WKCJS00> ctgResponse=new CtgConnectorResponse<C_WKCJS00>();
		ctgResponse.setResult(new C_WKCJS00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC="0000";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_MSG="OK";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_ANOM="OK";

		ctgResponse.getResult().OUTBST=new OUTBST[1]; 
		ctgResponse.getResult().OUTBST[0]=new OUTBST();
		ctgResponse.getResult().OUTBST[0].RET_CODE="0";
		ctgResponse.getResult().OUTBST[0].OUTCNF=new OUTCNF[1];
		ctgResponse.getResult().OUTBST[0].OUTCNF[0]=new OUTCNF();
		ctgResponse.getResult().OUTBST[0].OUTCNF[0].COD_CND="99999";
		
		ctgResponse.getResult().OUTSEG=new OUTSEG[1]; 
		ctgResponse.getResult().OUTSEG[0]=new OUTSEG();
		ctgResponse.getResult().OUTSEG[0].TXT_SEGNALAZIONE=" ";
		ctgResponse.getResult().OUTSEG[0].LIVELLO_SEGNALAZIONE=" ";
		
		WKCJResponse reponse = wkcjCtgResponseTansformer.transform(ctgResponse);
		assertTrue(reponse.getOutEsi().getMdwEsiRetc().equals("0000"));
		
	}
	
	
	
	@Test
	public void testTrasform02() {
		CtgConnectorResponse<C_WKCJS00> ctgResponse=new CtgConnectorResponse<C_WKCJS00>();
		ctgResponse.setResult(new C_WKCJS00());
		
		//
		ctgResponse.getResult().OUTESI=null;
		ctgResponse.getResult().OUTSEG=null;
		ctgResponse.getResult().OUTBST=null;
		WKCJResponse reponse = wkcjCtgResponseTansformer.transform(ctgResponse);
		assertTrue(reponse.getOutEsi()!=null);
		
	}
	
	@Test
	public void testTrasform03() {
		CtgConnectorResponse<C_WKCJS00> ctgResponse=new CtgConnectorResponse<C_WKCJS00>();
		ctgResponse.setResult(new C_WKCJS00());
		
		//
		ctgResponse.getResult().OUTESI=new OUTESI[0];
		ctgResponse.getResult().OUTSEG=new OUTSEG[0];
		ctgResponse.getResult().OUTBST=new OUTBST[0];
		WKCJResponse response = wkcjCtgResponseTansformer.transform(ctgResponse);
		assertTrue(response!=null);
		
	}
	
	@Test
	public void testTrasform04() {
		CtgConnectorResponse<C_WKCJS00> ctgResponse=new CtgConnectorResponse<C_WKCJS00>();
		ctgResponse.setResult(new C_WKCJS00());
		
		//
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTSEG=new OUTSEG[1];
		ctgResponse.getResult().OUTBST=new OUTBST[1];
		
		//
		ctgResponse.getResult().OUTESI[0]=null;
		ctgResponse.getResult().OUTSEG[0]=null;
		ctgResponse.getResult().OUTBST[0]=null;
		
		WKCJResponse response = wkcjCtgResponseTansformer.transform(ctgResponse);
		assertTrue(response!=null);
	
		
	}
	
	
}
