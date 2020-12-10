package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.C_WKNBS00;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class WKNBCtgRequestTrasformerTest extends BaseTest{
	
	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private WKNBCtgRequestTrasformer wkibCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		Mockito.when(beanFactoryMock.getBean(C_WKNBS00.class)).thenReturn(new C_WKNBS00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=this.mockISPWebservicesHeaderType();
		
		WKNBRequest input = WKNBRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.tipoFunzione("04")
				.build();
		
		CtgConnectorRequest<C_WKNBS00> ctgConnectorRequest = wkibCtgRequestTrasformer.transform(input, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].TIPO_FUNZ.equals("04"));
	}
}
