package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.INHEADER;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.INPANA;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.INPBST;
import com.dsi.business.SSA_WK.integration.jdo.P_WKIBS00.C_WKIBS00;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class WKIBCtgRequestTrasformer implements ICtgRequestTransformer<WKIBRequest, C_WKIBS00>{
	private static final Logger logger = LoggerUtils.getLogger(WKIBCtgRequestTrasformer.class);

	@Autowired
	private BeanFactory beanFactory;
	
	@Override
	public CtgConnectorRequest<C_WKIBS00> transform(WKIBRequest input, Object... args) {
		C_WKIBS00 connector = beanFactory.getBean(C_WKIBS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();
		
		HeaderBS headerBS = ServiceUtil.buildHeaders(BSTypeCall.WKIBS00_CALL, input.getIspWebservicesHeaderType());
		ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);

		logger.debug("headerBS = {}", headerBS);
		logger.debug("INHEADER = {}", ServiceUtil.stampaOggetto(connector.INHEADER[0]));

		
		INPBST inpbst = new INPBST();
		
		inpbst.TIPO_FUNZ = ServiceUtil.ifNull(input.getTipoFunzione(),"");
		inpbst.COD_ABI = ServiceUtil.ifNull(input.getCodAbi(),"");
		inpbst.COD_DIPENDENTE = ServiceUtil.ifNull(input.getCodDipendente(),"");
		inpbst.COD_LINGUA = ServiceUtil.ifNull(input.getCodLingua(),"");
		
		INPANA inpana = new INPANA();
		
		inpana.COD_DIP = ServiceUtil.ifNull(input.getCodFiliale(),"");
		inpana.COD_CAT = ServiceUtil.ifNull(input.getCodCategoria(),"");
		inpana.NUM_RAPP = ServiceUtil.ifNull(input.getCodProgressivo(),"");
		inpana.COD_ATT_RAPP = ServiceUtil.ifNull(input.getAttributi(),"");
		
		inpana.COD_NDG = ServiceUtil.ifNull(input.getNdg(),"");
		
		inpana.DATA_RIF = ServiceUtil.ifNull(input.getDataRif(),"");
		inpana.DATA_FINE = ServiceUtil.ifNull(input.getDataFine(),"");
		
		inpbst.INPANA = new INPANA[1];
		inpbst.INPANA[0] = inpana;
		
		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;
		
		logger.debug("INPBST = {}", ServiceUtil.stampaOggetto(connector.INPBST[0]));
		logger.debug("INPANA = {}", ServiceUtil.stampaOggetto(inpbst.INPANA[0]));
		
		CtgConnectorRequest<C_WKIBS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);
		return ctgConnectorRequest;
	}

}
