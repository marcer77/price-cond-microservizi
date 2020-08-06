package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSErrorUtil;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
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
		String[] parametriAggiuntivi=new String[1];
		parametriAggiuntivi[0]="1";
		OutEsi outEsi=OutEsi.builder().mdwEsiRetc("0001").build();
		OutSeg outSeg=OutSeg.builder().livelloSegnalazione("E").build();
		
		//BSErrorUtil.checkErrore(BSType.FL03S00, ErrorCode.BS_EXCEPTION, outEsi,outSeg,this::additionalCheckErrorFunction,parametriAggiuntivi);
		BSErrorUtil.checkErrore(BSType.FL03S00, ErrorCode.BS_EXCEPTION, outEsi,outSeg,null,null);
		
		return fl03Response;
	}

	private boolean additionalCheckErrorFunction(String... st) {
		//String test= StringUtils.isNotEmpty(fl03Response.getCodErr())?fl03Response.getCodErr():"";
		return !st[0].equalsIgnoreCase("0");
	}
	
	/*private void checkErroreBS(FL03Response response) {
		String mdwEsiRetc = StringUtils.isNotBlank(response.getMdwEsiRetc()) ? response.getMdwEsiRetc() : "";
		// @TODO: controllare anche l'esito presente nel Body fl03Response.getRc() e fl03Response.getRc();?
		if (!mdwEsiRetc.equals("0000")) {
			throw BSException.builder().livelloSegnalazione(response.getLivelloSegnalazione())
					.txtSegnalazione(response.getTxtSegnalazione()).mdwEsiAnom(response.getMdwEsiAnom())
					.mdwEsiMsg(response.getMdwEsiMsg()).mdwEsiRetc(response.getMdwEsiRetc())
					.bsName(BSType.FL03S00.getCode()).errorCode(ErrorCode.BS_EXCEPTION).build();
		}
	}*/

}
