package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.C_WKCJS00;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class WKCJCtgRequestTrasformerTest extends BaseTest{

	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private WKCJCtgRequestTrasformer wkcjCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		Mockito.when(beanFactoryMock.getBean(C_WKCJS00.class)).thenReturn(new C_WKCJS00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=this.mockISPWebservicesHeaderType();
		
		WKCJRequest wkcjRequest = WKCJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType).pratica("1234567890")
				.superpratica("1234567890").utente(ispWebservicesHeaderType.getOperatorInfo().getUserID()).tipoChiamata("A4")
				.dataRifer(DateUtils.dateToString(new Date(), "yyyyMMdd")).lingua("I").build();


		
		CtgConnectorRequest<C_WKCJS00> ctgConnectorRequest = wkcjCtgRequestTrasformer.transform(wkcjRequest, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].PRATICA=="1234567890");
	}
	

}
