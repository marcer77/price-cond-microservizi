package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.INHEADER;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.INPBST;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.INPNDG;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.InpNDG;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class T1SJCtgRequestTrasformer implements ICtgRequestTransformer<T1SJRequest, C_T1SJS00> {
	private static final Logger logger = LoggerUtils.getLogger(T1SJCtgRequestTrasformer.class);

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_T1SJS00> transform(T1SJRequest request, Object... args) {
		C_T1SJS00 connector = beanFactory.getBean(C_T1SJS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();

		ServiceUtil.setBSHeaders(connector.INHEADER[0], BSTypeCall.FL03S00_CALL, request.getIspWebservicesHeaderType());
		logger.debug("INHEADER = {}", ServiceUtil.stampaOggetto(connector.INHEADER[0]));

		// body
		INPBST inpbst = new INPBST();

		//
		inpbst.INPNDG = new INPNDG[request.getInpNDGList().size()];
		int index = 0;
		for (InpNDG tmp : request.getInpNDGList()) {
			inpbst.INPNDG[index] = new INPNDG();
			inpbst.INPNDG[index].T1SJ_I_INTESTAZ_FIRMA = ServiceUtil.ifNull(tmp.getT1SjIIntestazFirma(),"");
			inpbst.INPNDG[index].T1SJ_I_NDG_FIRMA = ServiceUtil.ifNull(tmp.getT1SjINdgFirma(),"");
			index++;
		}
		//
		inpbst.T1SJ_I_CAP_RES = ServiceUtil.ifNull(request.getT1SjICapRes(),"");
		inpbst.T1SJ_I_CHIAMANTE = ServiceUtil.ifNull(request.getT1SjIChiamante(),"");
		inpbst.T1SJ_I_COD_CAT_RAPP = ServiceUtil.ifNull(request.getT1SjICodCatRapp(),"");
		inpbst.T1SJ_I_COD_FIL_RAPP = ServiceUtil.ifNull(request.getT1SjICodFilRapp(),"");
		inpbst.T1SJ_I_COD_FISCALE = ServiceUtil.ifNull(request.getT1SjICodFiscale(),"");
		inpbst.T1SJ_I_COD_UTENTE = ServiceUtil.ifNull(request.getT1SjICodUtente(),"");
		inpbst.T1SJ_I_CODICE_LINGUA = ServiceUtil.ifNull(request.getT1SjICodiceLingua(),"");
		inpbst.T1SJ_I_COMUNE_RES = ServiceUtil.ifNull(request.getT1SjIComuneRes(),"");
		inpbst.T1SJ_I_DATA_RIFERIMENTO = ServiceUtil.ifNull(request.getT1SjIDataRiferimento(),"");
		inpbst.T1SJ_I_FILIALE_OPER = ServiceUtil.ifNull(request.getT1SjIFilialeOper(),"");
		inpbst.T1SJ_I_FIRMA = ServiceUtil.ifNull(request.getT1SjIFirma(),"");
		inpbst.T1SJ_I_FRAZIONE = ServiceUtil.ifNull(request.getT1SjIFrazione(),"");
		inpbst.T1SJ_I_INTESTAZ = ServiceUtil.ifNull(request.getT1SjIIntestaz(),"");
		inpbst.T1SJ_I_KEY_OPERAZIONE = ServiceUtil.ifNull(request.getT1SjIKeyOperazione(),"");
		inpbst.T1SJ_I_NDG_INTESTATARIO = ServiceUtil.ifNull(request.getT1SjINdgIntestatario(),"");
		inpbst.T1SJ_I_NR_PRATICA =  ServiceUtil.ifNull(request.getT1SjINrPratica(),"");
		inpbst.T1SJ_I_NR_SUPERPRATICA =  ServiceUtil.ifNull(request.getT1SjINrSuperpratica(),"");
		inpbst.T1SJ_I_NUM_PROG_RAPP = ServiceUtil.ifNull(request.getT1SjINumProgRapp(),"");
		inpbst.T1SJ_I_PROG_STAMPA = ServiceUtil.ifNullAsInt(request.getT1SjIProgStampa(),0);
		inpbst.T1SJ_I_PROPOSTA_COMM = ServiceUtil.ifNull(request.getT1SjIPropostaComm(),"");
		inpbst.T1SJ_I_PROV_RES = ServiceUtil.ifNull(request.getT1SjIProvRes(),"");
		inpbst.T1SJ_I_SPECIE_GIU = ServiceUtil.ifNull(request.getT1SjISpecieGiu(),"");
		inpbst.T1SJ_I_TIPO_OFFERTA = ServiceUtil.ifNull(request.getT1SjITipoOfferta(),"");
		inpbst.T1SJ_I_TIPO_STAMPA = ServiceUtil.ifNull(request.getT1SjITipoStampa(),"");
		inpbst.T1SJ_I_VIA_RES = ServiceUtil.ifNull(request.getT1SjIViaRes(),"");

		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;

		
		logger.debug("INPBST = {}",ServiceUtil.stampaOggetto(connector.INPBST[0]));
		
		CtgConnectorRequest<C_T1SJS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		
		return ctgConnectorRequest;
	}

}
