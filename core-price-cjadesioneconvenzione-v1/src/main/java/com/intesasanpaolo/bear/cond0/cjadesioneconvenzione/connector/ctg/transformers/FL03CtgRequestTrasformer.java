package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INHEADER;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INPBST;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class FL03CtgRequestTrasformer implements ICtgRequestTransformer<FL03Request, C_FL03S00> {
	private static final Logger logger = LoggerUtils.getLogger(FL03CtgRequestTrasformer.class);	
	
	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_FL03S00> transform(FL03Request fl03Request, Object... args) {
		C_FL03S00 connector = beanFactory.getBean(C_FL03S00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();
		
		ServiceUtil.setBSHeaders(connector.INHEADER[0],BSTypeCall.FL03S00_CALL, fl03Request.getIspWebservicesHeaderType());
		logger.debug("INHEADER = {}",ServiceUtil.stampaOggetto(connector.INHEADER[0]));
		
		
		INPBST inpbst = new INPBST();
		inpbst.COD_APPLIC =ServiceUtil.ifNull(fl03Request.getCodApplic(),"");
		inpbst.COD_FUNZIONE = ServiceUtil.ifNull(fl03Request.getCodFunzione(),"");
		inpbst.COD_SOTTOAPPLIC = ServiceUtil.ifNull(fl03Request.getCodSottoApplic(),"");
		inpbst.FILLER = ServiceUtil.ifNull(fl03Request.getFiller(),"");
		inpbst.KEY_OPER = ServiceUtil.ifNull(fl03Request.getKeyOper(),"");
		inpbst.NUM_STR_KEY = ServiceUtil.ifNullAsInt(fl03Request.getNumStrKey(),0);

		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;

		logger.debug("INPBST = {}",ServiceUtil.stampaOggetto(connector.INPBST[0]));
		
		CtgConnectorRequest<C_FL03S00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
