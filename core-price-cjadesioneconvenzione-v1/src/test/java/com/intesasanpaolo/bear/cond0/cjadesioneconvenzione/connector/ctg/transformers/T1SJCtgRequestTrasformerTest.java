package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.InpNDG;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class T1SJCtgRequestTrasformerTest extends BaseTest{
	
	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private T1SJCtgRequestTrasformer t1sfCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		
		Mockito.when(beanFactoryMock.getBean(C_T1SJS00.class)).thenReturn(new C_T1SJS00());
		
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
		List<InpNDG> inpNDGList = new ArrayList<InpNDG>();
		T1SJRequest t1sjRequest = T1SJRequest.builder().
				ispWebservicesHeaderType(ispWebservicesHeaderType)
				.t1SjICapRes("")
				.t1SjIChiamante("")
				.t1SjICodCatRapp("1000")
				.t1SjICodFilRapp("")
				.t1SjICodFiscale("")
				.t1SjICodUtente("")
				.t1SjICodiceLingua("I")
				.t1SjIComuneRes("")
				.t1SjIDataRiferimento("")
				.t1SjIFilialeOper("")
				.t1SjIFirma("")
				.t1SjIFrazione("")
				.t1SjIIntestaz("")
				.t1SjIKeyOperazione("")
				.t1SjINdgIntestatario("")
				.t1SjINrPratica("20")
				.t1SjINrSuperpratica("2")
				.t1SjINumProgRapp("")
				.t1SjIProgStampa(0.0)
				.t1SjIPropostaComm("23")
				.t1SjIProvRes("")
				.t1SjISpecieGiu("")
				.t1SjITipoOfferta("")
				.t1SjITipoStampa("")
				.t1SjIViaRes("")
				.inpNDGList(inpNDGList)
				.build();
		
		CtgConnectorRequest<C_T1SJS00> ctgConnectorRequest = t1sfCtgRequestTrasformer.transform(t1sjRequest, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].T1SJ_I_COD_CAT_RAPP.equals("1000"));
	}

}
