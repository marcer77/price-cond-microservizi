package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import java.lang.reflect.Field;

import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INHEADER;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INPBST;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Request;
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
		
		HeaderBS headerBS= ServiceUtil.buildHeaders(BSTypeCall.FL03S00_CALL, fl03Request.getIspWebservicesHeaderType());
		ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);
		
		logger.debug("headerBS = {}",headerBS);
		logger.debug("INHEADER = {}",ServiceUtil.stampaOggetto(connector.INHEADER[0]));
		
		
		INPBST inpbst = new INPBST();
		inpbst.COD_APPLIC = fl03Request.getCodApplic();
		inpbst.COD_FUNZIONE = fl03Request.getCodFunzione();
		inpbst.COD_SOTTOAPPLIC = fl03Request.getCodSottoApplic();
		inpbst.FILLER = fl03Request.getFiller();
		inpbst.KEY_OPER = fl03Request.getKeyOper();
		inpbst.NUM_STR_KEY = fl03Request.getNumStrKey();

		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;

		logger.debug("INPBST = {}",ServiceUtil.stampaOggetto(connector.INPBST[0]));
		
		CtgConnectorRequest<C_FL03S00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
