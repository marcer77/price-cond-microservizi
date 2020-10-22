package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.INHEADER;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.INPBST;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.INPNDG;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.NDG;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSTypeCall;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderBS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class T1SFCtgRequestTrasformer  implements  ICtgRequestTransformer<T1SFRequest, C_T1SFS00> {
	private static final Logger logger = LoggerUtils.getLogger(T1SFCtgRequestTrasformer.class);	
	
	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_T1SFS00> transform(T1SFRequest t1sfRequest, Object... args) {
		C_T1SFS00 connector = beanFactory.getBean(C_T1SFS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();
		
		HeaderBS headerBS= ServiceUtil.buildHeaders(BSTypeCall.T1SFS00_CALL, t1sfRequest.getIspWebservicesHeaderType());
		ServiceUtil.setHeaders(connector.INHEADER[0], headerBS);
		
		logger.debug("headerBS = {}",headerBS);
		logger.debug("INHEADER = {}",ServiceUtil.stampaOggetto(connector.INHEADER[0]));
		logger.debug("t1sfRequest = {}",t1sfRequest);
		
		//body
		INPBST inpbst=new INPBST();
		inpbst.I_COD_CAT_RAPP=ServiceUtil.ifNull(t1sfRequest.getICodCatRapp(),"");
		inpbst.I_COD_FIL_RAPP=ServiceUtil.ifNull(t1sfRequest.getICodFilRapp(),"");
		inpbst.I_COD_FT=ServiceUtil.ifNull(t1sfRequest.getICodFT(),"");
		inpbst.I_COD_LINGUA=ServiceUtil.ifNull(t1sfRequest.getICodLingua(),"");
		inpbst.I_CQ_CAT_RAPP=ServiceUtil.ifNull(t1sfRequest.getICQCatRapp(),"");
		inpbst.I_CQ_FIL_RAPP=ServiceUtil.ifNull(t1sfRequest.getICQFilRapp(),"");
		inpbst.I_CQ_NUM_RAPP=ServiceUtil.ifNull(t1sfRequest.getICQNumRapp(),"");
		inpbst.I_DATA_DECORRENZA_FIDO=ServiceUtil.ifNull(t1sfRequest.getIDataDecorrenzaFido(),"");
		inpbst.I_DATA_RIFERIMENTO=ServiceUtil.ifNull(t1sfRequest.getIDataRiferimento(),"");
		inpbst.I_DATA_SCADENZA_FIDO=ServiceUtil.ifNull(t1sfRequest.getIDataScadenzaFido(),"");
		inpbst.I_DIVISA_FIDO=ServiceUtil.ifNull(t1sfRequest.getIDivisaFido(),"");
		inpbst.I_FIRMA=ServiceUtil.ifNull(t1sfRequest.getIFirma(),"");
		inpbst.I_FUNZIONE=ServiceUtil.ifNull(t1sfRequest.getIFunzione(),"");
		inpbst.I_IMPORTO_FIDO=ServiceUtil.ifNullAsDouble(t1sfRequest.getIImportoFido());
		inpbst.I_KEY_OPERAZIONE=ServiceUtil.ifNull(t1sfRequest.getIKeyOperazione(),"");
		
		inpbst.I_NR_PRATICA=t1sfRequest.getINrPratica();
		inpbst.I_NR_SUPERPRATICA=t1sfRequest.getINrSuperPratica();
		
		inpbst.I_NUM_PROG_RAPP=ServiceUtil.ifNull(t1sfRequest.getINumProgRapp(),"");
		inpbst.I_PROG_FIDO=ServiceUtil.ifNullAsInt(t1sfRequest.getIProgFido(),0);
		inpbst.I_PROPOSTA_COMM=ServiceUtil.ifNullAsInt(t1sfRequest.getIPropostaComm(), 0);
		inpbst.I_PROPOSTA_USURA=ServiceUtil.ifNull(t1sfRequest.getIPropostaUsura(), "");
		inpbst.I_TIPO_FT=ServiceUtil.ifNull(t1sfRequest.getITipoFT(), "");
		inpbst.I_TIPO_OFFERTA=ServiceUtil.ifNull(t1sfRequest.getITipoOfferta(), "");
		inpbst.I_TIPO_STAMPA=ServiceUtil.ifNull(t1sfRequest.getITipoStampa(), "");

		inpbst.NDG = new NDG[1];
		NDG ndg = new NDG();
		ndg.I_NDG_INTESTATARIO = ServiceUtil.ifNull(t1sfRequest.getNdg().getINdgIntestatario(), "");
		ndg.I_INTESTAZ = ServiceUtil.ifNull(t1sfRequest.getNdg().getIIntestaz(), "");
		ndg.I_COD_FISCALE = ServiceUtil.ifNull(t1sfRequest.getNdg().getICodFiscale(), "");
		ndg.I_SPECIE_GIU = ServiceUtil.ifNull(t1sfRequest.getNdg().getISpecieGiu(), "");
		ndg.I_COMUNE_RES  = ServiceUtil.ifNull(t1sfRequest.getNdg().getIComuneRes(), "");
		ndg.I_CAP_RES = ServiceUtil.ifNull(t1sfRequest.getNdg().getICapRes(), "");
		ndg.I_VIA_RES = ServiceUtil.ifNull(t1sfRequest.getNdg().getIViaRes(), "");
		ndg.I_FRAZIONE = ServiceUtil.ifNull(t1sfRequest.getNdg().getIFrazione(), "");
		ndg.I_PROV_RES = ServiceUtil.ifNull(t1sfRequest.getNdg().getIProvRes(), "");
		logger.debug("inpbst.NDG = {}",ServiceUtil.stampaOggetto(ndg));
		inpbst.NDG[0] = ndg;
		
		int totFirma = t1sfRequest.getInpndg().getINdgFirma()!=null ? t1sfRequest.getInpndg().getINdgFirma().size() :0;
		
		inpbst.INPNDG = new INPNDG[totFirma];
		for(int i=0; i<totFirma;i++) {
			INPNDG inpndg = new INPNDG();
			inpndg.I_NDG_FIRMA = (t1sfRequest.getInpndg().getINdgFirma().get(i));
			inpndg.I_INTESTAZ_FIRMA = (t1sfRequest.getInpndg().getIIntestazFirma().get(i));
			inpbst.INPNDG[i] = inpndg;
			logger.debug("inpbst.INPNDG[{}] = {}",i,ServiceUtil.stampaOggetto(inpndg));
		}
		
		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;
		
		logger.debug("INPBST = {}",ServiceUtil.stampaOggetto(connector.INPBST[0]));
		
		CtgConnectorRequest<C_T1SFS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
