package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class T1SFCtgRequestTrasformerTest extends BaseTest{
	
	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private T1SFCtgRequestTrasformer t1sfCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		
		Mockito.when(beanFactoryMock.getBean(C_T1SFS00.class)).thenReturn(new C_T1SFS00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("121")
				.callerCompanyIDCode("01")
				.callerProgramName("121")
				.channelIDCode("")
				.codABI("01025")
				.codUnitaOperativa("00700")
				.customerID("23232")
				.isVirtualUser("false")
				.language("IT")
				.serviceCompanyIDCode("01")
				.serviceID("FL030FLA01")
				.userID("343")
				.transactionId("3434343")
				.timestamp("0")
				.serviceVersion("00").build();
		
		T1SFRequest t1sfRequest = T1SFRequest.builder().
				ispWebservicesHeaderType(ispWebservicesHeaderType)
				.iCodCatRapp("1000")
				.iCodFilRapp("")
				.iCodFT("")
				.iCodLingua("")
				.iCQCatRapp("")
				.iCQFilRapp("")
				.iCQNumRapp("")
				.iDataDecorrenzaFido("")
				.iDataRiferimento("")
				.iDataScadenzaFido("")
				.iDivisaFido("")
				.iFirma("")
				.iFunzione("")
				.iImportoFido(20d)
				.iKeyOperazione("")
				.iNrPratica(20)
				.iNrSuperPratica(2)
				.iNumProgRapp("")
				.iProgFido(22)
				.iPropostaComm(23)
				.iPropostaUsura("")
				.iTipoFT("")
				.iTipoOfferta("")
				.build();
		
		CtgConnectorRequest<C_T1SFS00> ctgConnectorRequest = t1sfCtgRequestTrasformer.transform(t1sfRequest, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].I_COD_CAT_RAPP.equals("1000"));
	}

}
