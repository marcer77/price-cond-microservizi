package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.C_PCUJS00;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTESI;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTRIP;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTTAS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class PCUJCtgResponseTansformerTest extends BaseTest{

	@Autowired
	private PCUJCtgResponseTansformer pcujCtgResponseTansformer;
	

	@Test
	public void testTrasform01() {
		CtgConnectorResponse<C_PCUJS00> ctgResponse=new CtgConnectorResponse<C_PCUJS00>();
		ctgResponse.setResult(new C_PCUJS00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC="0000";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_MSG="OK";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_ANOM="OK";

		ctgResponse.getResult().OUTBST=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTBST[1]; 
		ctgResponse.getResult().OUTBST[0]=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTBST();
		ctgResponse.getResult().OUTBST[0].COD_ESITO="0";
		ctgResponse.getResult().OUTBST[0].MSG_ESITO="-ESITO-";
		
		ctgResponse.getResult().OUTBST[0].OUTRIP=new OUTRIP[1];
		ctgResponse.getResult().OUTBST[0].OUTRIP[0]=new OUTRIP();
		ctgResponse.getResult().OUTBST[0].OUTRIP[0].COD_FT="99999";
		ctgResponse.getResult().OUTBST[0].OUTRIP[0].OUTTAS=new OUTTAS[1];
		ctgResponse.getResult().OUTBST[0].OUTRIP[0].OUTTAS[0]=new OUTTAS();
		ctgResponse.getResult().OUTBST[0].OUTRIP[0].OUTTAS[0].FL_USURA="S";
		ctgResponse.getResult().OUTBST[0].OUTRIP[0].OUTTAS[0].SEGNO_VAL_SPREAD="+";
		
		ctgResponse.getResult().OUTSEG=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTSEG[1]; 
		ctgResponse.getResult().OUTSEG[0]=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTSEG();
		ctgResponse.getResult().OUTSEG[0].TXT_SEGNALAZIONE=" ";
		ctgResponse.getResult().OUTSEG[0].LIVELLO_SEGNALAZIONE=" ";
		
		PCUJResponse response = pcujCtgResponseTansformer.transform(ctgResponse);
		assertTrue(response.getOutEsi().getMdwEsiRetc().equals("0000"));
		
	}
	
	
	
	@Test
	public void testTrasform02() {
		CtgConnectorResponse<C_PCUJS00> ctgResponse=new CtgConnectorResponse<C_PCUJS00>();
		ctgResponse.setResult(new C_PCUJS00());
		
		ctgResponse.getResult().OUTESI=null;
		ctgResponse.getResult().OUTSEG=null;
		ctgResponse.getResult().OUTBST=null;
		PCUJResponse reponse = pcujCtgResponseTansformer.transform(ctgResponse);
		assertTrue(reponse.getOutEsi()!=null);
		
	}
	
	@Test
	public void testTrasform03() {
		CtgConnectorResponse<C_PCUJS00> ctgResponse=new CtgConnectorResponse<C_PCUJS00>();
		ctgResponse.setResult(new C_PCUJS00());
		
		//
		ctgResponse.getResult().OUTESI=new OUTESI[0];
		ctgResponse.getResult().OUTSEG=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTSEG[0];
		ctgResponse.getResult().OUTBST=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTBST[0];
		PCUJResponse response = pcujCtgResponseTansformer.transform(ctgResponse);
		assertTrue(response!=null);
		
	}
	
	@Test
	public void testTrasform04() {
		CtgConnectorResponse<C_PCUJS00> ctgResponse=new CtgConnectorResponse<C_PCUJS00>();
		ctgResponse.setResult(new C_PCUJS00());
		
		//
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTSEG=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTSEG[1];
		ctgResponse.getResult().OUTBST=new com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTBST[1];
		
		//
		ctgResponse.getResult().OUTESI[0]=null;
		ctgResponse.getResult().OUTSEG[0]=null;
		ctgResponse.getResult().OUTBST[0]=null;
		
		PCUJResponse response = pcujCtgResponseTansformer.transform(ctgResponse);
		assertTrue(response!=null);
	
		
	}
	
	
}
