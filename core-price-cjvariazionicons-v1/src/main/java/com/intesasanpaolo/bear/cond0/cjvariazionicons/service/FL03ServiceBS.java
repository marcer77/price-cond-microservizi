package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorFL03;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.FL03CtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.exception.ErrorCode;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class FL03ServiceBS extends BaseService {
	private static final Logger logger = LoggerUtils.getLogger(FL03ServiceBS.class);

	@Autowired
	private CTGConnectorFL03 ctgConnectorFL03;

	@Autowired
	private FL03CtgRequestTrasformer requestTransformer;

	@Autowired
	private FL03CtgResponseTansformer responseTransformer;

	public FL03Response callBS(FL03Request fl03Request) {
		FL03Response fl03Response = this.ctgConnectorFL03.call(fl03Request, requestTransformer, responseTransformer,new Object());
		checkErroreBS(fl03Response);
		return fl03Response;
	}

	private void checkErroreBS(FL03Response response) {
		String mdwEsiRetc = StringUtils.isNotBlank(response.getMdwEsiRetc()) ? response.getMdwEsiRetc() : "";
		// @TODO: controllare anche l'esito presente nel Body fl03Response.getRc() e fl03Response.getRc();?
		if (!mdwEsiRetc.equals("0000")) {
			throw BSException.builder().livelloSegnalazione(response.getLivelloSegnalazione())
					.txtSegnalazione(response.getTxtSegnalazione()).mdwEsiAnom(response.getMdwEsiAnom())
					.mdwEsiMsg(response.getMdwEsiMsg()).mdwEsiRetc(response.getMdwEsiRetc())
					.bsName(BSType.FL03S00.getCode()).errorCode(ErrorCode.BS_EXCEPTION).build();
		}
	}

}
