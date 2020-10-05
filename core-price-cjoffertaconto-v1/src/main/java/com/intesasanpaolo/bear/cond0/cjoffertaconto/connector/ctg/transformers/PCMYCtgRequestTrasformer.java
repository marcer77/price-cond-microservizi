package com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.C_PCMYS00;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.INHEADER;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.INPBST;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.INPPRM;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.InPPRM;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class PCMYCtgRequestTrasformer implements ICtgRequestTransformer<PCMYRequest, C_PCMYS00> {
	private static final Logger logger = LoggerUtils.getLogger(PCMYCtgRequestTrasformer.class);

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_PCMYS00> transform(PCMYRequest request, Object... args) {
		C_PCMYS00 connector = beanFactory.getBean(C_PCMYS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();
		// TODO:CAMBIARE L'id!!!!
		HeaderBS headerBS = ServiceUtil.buildHeaders(BSTypeCall.PCMYS00_CALL, request.getIspWebservicesHeaderType());
		ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);

		logger.debug("headerBS = {}", headerBS);
		logger.debug("INHEADER = {}", ServiceUtil.stampaOggetto(connector.INHEADER[0]));

		INPBST inpbst = new INPBST();

		inpbst.COD_CAT_RAPP = ServiceUtil.ifNull(request.getCodCatRapp(), "");
		inpbst.COD_FIL_RAPP = ServiceUtil.ifNull(request.getCodFilRapp(), "");
		inpbst.NUM_PROG_RAPP = ServiceUtil.ifNull(request.getNumProgRapp(), "");
		inpbst.DATA_RIFERIMENTO = ServiceUtil.ifNull(request.getDataRiferimento(), "");
		inpbst.FUNZIONE = ServiceUtil.ifNull(request.getFunzione(), "");
		inpbst.TIPO_DA = ServiceUtil.ifNull(request.getTipoDA(), "");
		inpbst.INPPRM = new INPPRM[request.getInList().size()];
		int j = 0;
		for (InPPRM in : request.getInList()) {
			inpbst.INPPRM[j] = new INPPRM();
			inpbst.INPPRM[j].COD_PROMO = in.getCodPromo();
			inpbst.INPPRM[j].DECA_PROMO = in.getDecaPromo();
			inpbst.INPPRM[j].DECO_PROMO = in.getDecoPromo();
			j++;
		}

		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;

		logger.debug("INPBST = {}", ServiceUtil.stampaOggetto(connector.INPBST[0]));
		CtgConnectorRequest<C_PCMYS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
