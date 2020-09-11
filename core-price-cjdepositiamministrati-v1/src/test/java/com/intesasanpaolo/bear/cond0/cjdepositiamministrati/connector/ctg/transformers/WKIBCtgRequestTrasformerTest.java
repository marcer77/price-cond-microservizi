//package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.C_WKIBS00;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.common.BaseTest;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBRequest;
//import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
//import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
//
//@RunWith(SpringRunner.class)
//public class WKIBCtgRequestTrasformerTest extends BaseTest{
//	
//	@MockBean
//	private BeanFactory beanFactoryMock;
//
//	@Autowired
//	private WKIBCtgRequestTrasformer wkibCtgRequestTrasformer;
//	
//	@Test
//	public void testTrasform() {
//		Mockito.when(beanFactoryMock.getBean(C_WKIBS00.class)).thenReturn(new C_WKIBS00());
//		
//		ISPWebservicesHeaderType ispWebservicesHeaderType=this.mockISPWebservicesHeaderType();
//		
//		WKIBRequest input = WKIBRequest.builder()
//				.ispWebservicesHeaderType(ispWebservicesHeaderType)
//				.tipoFunzione("04")
//				.build();
//		
//		CtgConnectorRequest<C_WKIBS00> ctgConnectorRequest = wkibCtgRequestTrasformer.transform(input, null);
//		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].TIPO_FUNZ.equals("04"));
//	}
//}
