package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.C_WKIBS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.OUTBST;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.OUTESI;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.OUTSEG;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.OUTSTP;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;

@RunWith(SpringRunner.class)
public class WKIBCtgResponseTansformerTest extends BaseTest{
	
	@MockBean
	private BeanFactory beanFactoryMock;
	
	@Autowired
	private WKIBCtgResponseTansformer wkibCtgResponseTansformer;
	
	@Test
	public void testTrasform() {
		CtgConnectorResponse<C_WKIBS00> ctgResponse=new CtgConnectorResponse<C_WKIBS00>();
		ctgResponse.setResult(new C_WKIBS00());
		ctgResponse.getResult().OUTESI=new OUTESI[1];
		ctgResponse.getResult().OUTESI[0]=new OUTESI();
		ctgResponse.getResult().OUTESI[0].MDW_ESI_RETC="0000";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_MSG="OK";
		ctgResponse.getResult().OUTESI[0].MDW_ESI_ANOM="OK";

		ctgResponse.getResult().OUTBST=new OUTBST[1]; 
		ctgResponse.getResult().OUTBST[0]=new OUTBST();
		
		ctgResponse.getResult().OUTBST[0].OUTSTP=new OUTSTP[1];
		ctgResponse.getResult().OUTBST[0].OUTSTP[0]=new OUTSTP();
		
		ctgResponse.getResult().OUTSEG=new OUTSEG[1]; 
		ctgResponse.getResult().OUTSEG[0]=new OUTSEG();
		ctgResponse.getResult().OUTSEG[0].TXT_SEGNALAZIONE=" ";
		ctgResponse.getResult().OUTSEG[0].LIVELLO_SEGNALAZIONE=" ";
		
		WKIBResponse wkibResponse = wkibCtgResponseTansformer.transform(ctgResponse);
		assertTrue(wkibResponse.getOutEsi().getMdwEsiRetc().equals("0000"));
		
	}
}
