package com.intesasanpaolo.bear.cond0.cjvariazionicons.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.CTGConnectorT1SF;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers.T1SFCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.exception.ErrorCode;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class T1SFServiceBS extends BaseService {
	//private static final Logger logger = LoggerUtils.getLogger(T1SFServiceBS.class);

	@Autowired
	private CTGConnectorT1SF ctgConnectorT1SF;

	@Autowired
	private T1SFCtgRequestTrasformer requestTransformer;

	@Autowired
	private T1SFCtgResponseTansformer responseTransformer;

	public T1SFResponse callBS(T1SFRequest t1sfRequest) {
		T1SFResponse t1sfResponse = this.ctgConnectorT1SF.call(t1sfRequest, requestTransformer, responseTransformer,
				new Object());
		checkErroreBS(t1sfResponse);
		return t1sfResponse;
	}

	private void checkErroreBS(T1SFResponse t1sfResponse) {
		String mdwEsiRetc = StringUtils.isNotBlank(t1sfResponse.getMdwEsiRetc()) ? t1sfResponse.getMdwEsiRetc() : "";
		//@TODO: controllare anche l'esito presente nel Body oReturnCode?
		if (!mdwEsiRetc.equals("0000")) {
			throw BSException.builder().livelloSegnalazione(t1sfResponse.getOLivelloSegnalazione()).txtSegnalazione(t1sfResponse.getOTxtSegnalazione())
					.mdwEsiAnom(t1sfResponse.getMdwEsiAnom()).mdwEsiMsg(t1sfResponse.getMdwEsiMsg())
					.mdwEsiRetc(t1sfResponse.getMdwEsiRetc()).bsName(BSType.T1SFS00.getCode()).errorCode(ErrorCode.BS_EXCEPTION).build();
		}
	}
}
