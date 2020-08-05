package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.C_PCUJS00;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.INHEADER;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.INPBST;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class PCUJCtgRequestTrasformer implements ICtgRequestTransformer<PCUJRequest, C_PCUJS00> {
	private static final Logger logger = LoggerUtils.getLogger(PCUJCtgRequestTrasformer.class);

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_PCUJS00> transform(PCUJRequest request, Object... args) {
		C_PCUJS00 connector = beanFactory.getBean(C_PCUJS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();

		HeaderBS headerBS = ServiceUtil.buildHeaders(BSTypeCall.PCUJS00_CALL, request.getIspWebservicesHeaderType());
		ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);

		logger.debug("headerBS = {}", headerBS);
		logger.debug("INHEADER = {}", ServiceUtil.stampaOggetto(connector.INHEADER[0]));

		INPBST inpbst = new INPBST();
		inpbst.CLASSIFIC_CLIENTE = ServiceUtil.ifNull(request.getClassificCliente(),"");
		inpbst.COD_CAT_RAPP = ServiceUtil.ifNull(request.getCodCatRapp(),"");
		inpbst.COD_EVENTO = ServiceUtil.ifNull(request.getCodEvento(),"");
		inpbst.COD_FIL_RAPP = ServiceUtil.ifNull(request.getCodFilRapp(),"");
		inpbst.COD_UTENTE = ServiceUtil.ifNull(request.getCodUtente(),"");
		inpbst.DATA_RIFERIMENTO = ServiceUtil.ifNull(request.getDataRiferimento(),"");
		inpbst.FILIALE_OPER = ServiceUtil.ifNull(request.getFilialeOper(),"");
		inpbst.NR_PRATICA = request.getNrPratica();
		inpbst.NR_SUPERPRATICA =request.getNrSuperpratica();
		inpbst.NUM_PROG_RAPP = ServiceUtil.ifNull(request.getNumProgRapp(),"");
		inpbst.PROPOSTA_COMM =ServiceUtil.ifNull(request.getPropostaComm(), "")  ;
		inpbst.SUB_EVENTO = ServiceUtil.ifNull(request.getSubEvento(),"");
		inpbst.TIPO_FUNZIONE = ServiceUtil.ifNull(request.getTipoFunzione(),"");

		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;

		logger.debug("INPBST = {}", ServiceUtil.stampaOggetto(connector.INPBST[0]));

		CtgConnectorRequest<C_PCUJS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
