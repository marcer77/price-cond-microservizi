package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INHEADER;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INPBST;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class FL03CtgRequestTrasformer implements ICtgRequestTransformer<InputStampaDTO, C_FL03S00> {

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_FL03S00> transform(InputStampaDTO inputStampaDTO, Object... args) {
		C_FL03S00 connector = beanFactory.getBean(C_FL03S00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = null;// input.getHeader();
		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = null;// input.getBody();

		CtgConnectorRequest<C_FL03S00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
