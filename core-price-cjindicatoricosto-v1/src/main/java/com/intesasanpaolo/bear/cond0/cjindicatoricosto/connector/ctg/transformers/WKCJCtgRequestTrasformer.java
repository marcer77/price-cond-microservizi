package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.C_WKCJS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.INHEADER;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.INPBST;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class WKCJCtgRequestTrasformer implements ICtgRequestTransformer<WKCJRequest, C_WKCJS00> {

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_WKCJS00> transform(WKCJRequest wkcjRequest, Object... args) {
		C_WKCJS00 connector = beanFactory.getBean(C_WKCJS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();
		//HeaderBS headerBS = ServiceUtil.buildHeaders(BSTypeCall.PCUJS00_CALL, request.getIspWebservicesHeaderType());
		//ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);

		//connector.INHEADER[0].ID_SERVIZIO = "WKCJCNTRZE";
	
		INPBST inpbst = new INPBST();
		inpbst.AMBITO_Q=wkcjRequest.getAmbitoQ();
		inpbst.ATTRIB_BPAY=wkcjRequest.getAttribBpay();
		inpbst.CAT_RAPP=wkcjRequest.getCatRapp();
		inpbst.CAT_RAPP_APPO=wkcjRequest.getCatRappAppo();
		inpbst.CAT_RAPP_BPAY=wkcjRequest.getCatRappBpay();
		inpbst.CAT_SEC_RAP_APPO=wkcjRequest.getCatSecRapAppo();
		inpbst.CAT_SEC_RAPP=wkcjRequest.getCatSecRapp();
		inpbst.DATA_RIFER=wkcjRequest.getDataRifer();
		inpbst.DT_DECO_RAPP=wkcjRequest.getDtDecoRapp();
		inpbst.FIL_RAPP=wkcjRequest.getFilRapp();
		inpbst.FIL_RAPP_APPO=wkcjRequest.getFilRappAppo();
		inpbst.FIL_RAPP_BPAY=wkcjRequest.getFilRappBpay();
		inpbst.FL_BPAY=wkcjRequest.getFlBpay();
		inpbst.LINGUA=wkcjRequest.getLingua();
		inpbst.NDG=wkcjRequest.getNdg();
		inpbst.NRO_RAPP=wkcjRequest.getNroRapp();
		inpbst.NRO_RAPP_APPO=wkcjRequest.getNroRappAppo();
		inpbst.NRO_RAPP_BPAY=wkcjRequest.getNroRappBpay();
		inpbst.PARTITA_RAPP=wkcjRequest.getPartitaRapp();
		inpbst.PRATICA=wkcjRequest.getPratica();
		inpbst.SETT_RAPP=wkcjRequest.getSettRapp();
		inpbst.SETT_RAPP_APPO=wkcjRequest.getSettRappAppo();
		inpbst.SUPERPRATICA=wkcjRequest.getSuperpratica();
		inpbst.TERMINALE=wkcjRequest.getTerminale();
		inpbst.TIPO_CHIAMATA=wkcjRequest.getTipoChiamata();
		inpbst.TIPO_STAMPA=wkcjRequest.getTipoStampa();
		inpbst.UTENTE=wkcjRequest.getUtente();
		
		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;

		CtgConnectorRequest<C_WKCJS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
		
	}

}
