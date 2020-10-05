package com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.C_PCMYS00;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.PromozioniDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.InPPRM;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class PCMYCtgRequestTrasformerTest extends BaseTest {

	@MockBean
	private BeanFactory beanFactoryMock;
	
	@Autowired
	private PCMYCtgRequestTrasformer pcmyCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		Mockito.when(beanFactoryMock.getBean(C_PCMYS00.class)).thenReturn(new C_PCMYS00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=this.mockISPWebservicesHeaderType();
		
		List<InPPRM> inList = new ArrayList<InPPRM>();
		InPPRM elem = new InPPRM();
		elem.setCodPromo("123");
		elem.setDecaPromo("20200911");
		elem.setDecoPromo("20200911");
		inList.add(elem);
		
		PCMYRequest input = PCMYRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.codCatRapp("1234")
				.codFilRapp("12345")
				.numProgRapp("12345678")
				.tipoDA("CU")
				.funzione(CodApplEnum.AREA_FINANZA.toString())
				.dataRiferimento("20200911")
				.inList(inList)
				.build();
		
		CtgConnectorRequest<C_PCMYS00> ctgConnectorRequest = pcmyCtgRequestTrasformer.transform(input, null);
		assertTrue(ctgConnectorRequest!=null);
	}

}
