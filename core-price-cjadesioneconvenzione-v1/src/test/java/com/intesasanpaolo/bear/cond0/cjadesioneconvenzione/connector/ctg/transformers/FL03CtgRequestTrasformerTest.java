package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.INPNDG;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.InpNDG;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class FL03CtgRequestTrasformerTest extends BaseTest{

	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private FL03CtgRequestTrasformer fl03CtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		Mockito.when(beanFactoryMock.getBean(C_FL03S00.class)).thenReturn(new C_FL03S00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=this.mockISPWebservicesHeaderType();
		
		FL03Request fl03Request = FL03Request.builder()
				.codApplic("ABC__")
				.codFunzione("UP")
				.codSottoApplic("ORDIN")
				.filler("")
				.keyOper("01U01588620200710CMOD125914")
				.numStrKey(1)
				
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.build();

		/*for (InpNDG tmp : request.getInpNDGList()) {
			inpbst.INPNDG[index] = new INPNDG();
			inpbst.INPNDG[index].T1SJ_I_INTESTAZ_FIRMA = ServiceUtil.ifNull(tmp.getT1SjIIntestazFirma(),"");
			inpbst.INPNDG[index].T1SJ_I_NDG_FIRMA = ServiceUtil.ifNull(tmp.getT1SjINdgFirma(),"");
			index++;
		}*/
		CtgConnectorRequest<C_FL03S00> ctgConnectorRequest = fl03CtgRequestTrasformer.transform(fl03Request, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].COD_FUNZIONE.equals("UP"));
	}
	

}
