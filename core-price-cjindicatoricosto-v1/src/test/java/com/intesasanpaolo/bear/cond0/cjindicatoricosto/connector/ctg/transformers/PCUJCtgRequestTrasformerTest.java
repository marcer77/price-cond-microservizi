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

import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.C_PCUJS00;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@RunWith(SpringRunner.class)
public class PCUJCtgRequestTrasformerTest extends BaseTest{

	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private PCUJCtgRequestTrasformer pcujCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		Mockito.when(beanFactoryMock.getBean(C_PCUJS00.class)).thenReturn(new C_PCUJS00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=this.mockISPWebservicesHeaderType();
		
		PCUJRequest pcujRequest = PCUJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType).tipoFunzione("----")
				.codEvento("000").subEvento("0879").classificCliente("0000")
				.dataRiferimento(DateUtils.dateToString(new Date(), "yyyyMMdd")).codUtente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.filialeOper(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				.nrSuperpratica("0123456789").nrPratica("0123456789").build();


		
		CtgConnectorRequest<C_PCUJS00> ctgConnectorRequest = pcujCtgRequestTrasformer.transform(pcujRequest, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].NR_SUPERPRATICA=="0123456789");
	}
	

}
