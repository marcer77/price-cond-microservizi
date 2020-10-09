package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.C_WKCJS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.INHEADER;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.INPBST;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class WKCJCtgRequestTrasformer implements ICtgRequestTransformer<WKCJRequest, C_WKCJS00> {
	private static final Logger logger = LoggerUtils.getLogger(WKCJCtgRequestTrasformer.class);

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_WKCJS00> transform(WKCJRequest wkcjRequest, Object... args) {
		C_WKCJS00 connector = beanFactory.getBean(C_WKCJS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();
		
		HeaderBS headerBS = ServiceUtil.buildHeaders(BSTypeCall.WKCJS00_CALL, wkcjRequest.getIspWebservicesHeaderType());
		ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);

		logger.debug("headerBS = {}", headerBS);
		logger.debug("INHEADER = {}", ServiceUtil.stampaOggetto(connector.INHEADER[0]));

		
		INPBST inpbst = new INPBST();
		inpbst.AMBITO_Q=ServiceUtil.ifNull(wkcjRequest.getAmbitoQ(),"");
		inpbst.ATTRIB_BPAY=ServiceUtil.ifNull(wkcjRequest.getAttribBpay(),"");
		inpbst.CAT_RAPP=ServiceUtil.ifNull(wkcjRequest.getCatRapp(),"");
		inpbst.CAT_RAPP_APPO=ServiceUtil.ifNull(wkcjRequest.getCatRappAppo(),"");
		inpbst.CAT_RAPP_BPAY=ServiceUtil.ifNull(wkcjRequest.getCatRappBpay(),"");
		inpbst.CAT_SEC_RAP_APPO=ServiceUtil.ifNull(wkcjRequest.getCatSecRapAppo(),"");
		inpbst.CAT_SEC_RAPP=ServiceUtil.ifNull(wkcjRequest.getCatSecRapp(),"");
		inpbst.DATA_RIFER=ServiceUtil.ifNull(wkcjRequest.getDataRifer(),"");
		inpbst.DT_DECO_RAPP=ServiceUtil.ifNull(wkcjRequest.getDtDecoRapp(),"");
		inpbst.FIL_RAPP=ServiceUtil.ifNull(wkcjRequest.getFilRapp(),"");
		inpbst.FIL_RAPP_APPO=ServiceUtil.ifNull(wkcjRequest.getFilRappAppo(),"");
		inpbst.FIL_RAPP_BPAY=ServiceUtil.ifNull(wkcjRequest.getFilRappBpay(),"");
		inpbst.FL_BPAY=ServiceUtil.ifNull(wkcjRequest.getFlBpay(),"");
		inpbst.LINGUA=ServiceUtil.ifNull(wkcjRequest.getLingua(),"");
		inpbst.NDG=ServiceUtil.ifNull(wkcjRequest.getNdg(),"");
		inpbst.NRO_RAPP=ServiceUtil.ifNull(wkcjRequest.getNroRapp(),"");
		inpbst.NRO_RAPP_APPO=ServiceUtil.ifNull(wkcjRequest.getNroRappAppo(),"");
		inpbst.NRO_RAPP_BPAY=ServiceUtil.ifNull(wkcjRequest.getNroRappBpay(),"");
		inpbst.PARTITA_RAPP=ServiceUtil.ifNull(wkcjRequest.getPartitaRapp(),"");
		inpbst.PRATICA=ServiceUtil.ifNull(wkcjRequest.getPratica(),"");
		inpbst.SETT_RAPP=ServiceUtil.ifNull(wkcjRequest.getSettRapp(),"");
		inpbst.SETT_RAPP_APPO=ServiceUtil.ifNull(wkcjRequest.getSettRappAppo(),"");
		inpbst.SUPERPRATICA=ServiceUtil.ifNull(wkcjRequest.getSuperpratica(),"");
		inpbst.TERMINALE=ServiceUtil.ifNull(wkcjRequest.getTerminale(),"");
		inpbst.TIPO_CHIAMATA=ServiceUtil.ifNull(wkcjRequest.getTipoChiamata(),"");
		inpbst.TIPO_STAMPA=ServiceUtil.ifNull(wkcjRequest.getTipoStampa(),"");
		inpbst.UTENTE=ServiceUtil.ifNull(wkcjRequest.getUtente(),"");
		
		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;
		
		logger.debug("INPBST = {}", ServiceUtil.stampaOggetto(connector.INPBST[0]));

		CtgConnectorRequest<C_WKCJS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
		
	}

}
