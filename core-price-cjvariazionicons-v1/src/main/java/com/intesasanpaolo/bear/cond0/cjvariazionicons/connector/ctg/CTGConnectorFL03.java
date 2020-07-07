package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.BaseCtgConnector;

@Service
public class CTGConnectorFL03 extends BaseCtgConnector<InputStampaDTO, ResponseResource, C_FL03S00> {
	private static final Logger logger = LoggerUtils.getLogger(CTGConnectorFL03.class);

	@Autowired
	private FL03CtgRequestTrasformer requestTransformer;

	@Autowired
	private FL03CtgResponseTansformer responseTransformer;

	public ResponseResource call(InputStampaDTO request) throws Exception {

		logger.debug("start CTGConnectorFL03.call()");

		try {
			ResponseResource response = super.call(request, requestTransformer, responseTransformer);

			logger.debug("MC after call, response=" + response.toString());

			return response;
		} catch (Exception e) {
			logger.debug("MC: call error !");
			logger.error("CtgConnectorZ3YC.call() exception:" + e.getMessage());
			throw e;
		}

	}

}
