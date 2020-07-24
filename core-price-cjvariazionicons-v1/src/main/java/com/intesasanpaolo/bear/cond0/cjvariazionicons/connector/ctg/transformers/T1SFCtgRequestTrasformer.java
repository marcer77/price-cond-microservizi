package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.INHEADER;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.INPBST;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class T1SFCtgRequestTrasformer  implements  ICtgRequestTransformer<T1SFRequest, C_T1SFS00> {

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_T1SFS00> transform(T1SFRequest t1sfRequest, Object... args) {
		C_T1SFS00 connector = beanFactory.getBean(C_T1SFS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();// input.getHeader();	
		ServiceUtil.setHeaders(connector.INHEADER[0], t1sfRequest.getIspWebservicesHeaderType());		
		connector.INHEADER[0].ID_SERVIZIO = "??";
		
		//body
		INPBST inpbst=new INPBST();
		inpbst.I_COD_CAT_RAPP=t1sfRequest.getICodCatRapp();
		inpbst.I_COD_FIL_RAPP=t1sfRequest.getICodFilRapp();
		inpbst.I_COD_FT=t1sfRequest.getICodFT();
		inpbst.I_COD_LINGUA=t1sfRequest.getICodLingua();
		inpbst.I_CQ_CAT_RAPP=t1sfRequest.getICQCatRapp();
		inpbst.I_CQ_FIL_RAPP=t1sfRequest.getICQFilRapp();
		inpbst.I_CQ_NUM_RAPP=t1sfRequest.getICQNumRapp();
		inpbst.I_DATA_DECORRENZA_FIDO=t1sfRequest.getIDataDecorrenzaFido();
		inpbst.I_DATA_RIFERIMENTO=t1sfRequest.getIDataRiferimento();
		inpbst.I_DATA_SCADENZA_FIDO=t1sfRequest.getIDataScadenzaFido();
		inpbst.I_DIVISA_FIDO=t1sfRequest.getIDivisaFido();
		inpbst.I_FIRMA=t1sfRequest.getIFirma();
		inpbst.I_FUNZIONE=t1sfRequest.getIFunzione();
		inpbst.I_IMPORTO_FIDO=t1sfRequest.getIImportoFido();
		inpbst.I_KEY_OPERAZIONE=t1sfRequest.getIKeyOperazione();
		inpbst.I_NR_PRATICA=t1sfRequest.getINrPratica();
		inpbst.I_NR_SUPERPRATICA=t1sfRequest.getINrSuperPratica();
		inpbst.I_NUM_PROG_RAPP=t1sfRequest.getINumProgRapp();
		inpbst.I_PROG_FIDO=t1sfRequest.getIProgFido();
		inpbst.I_PROPOSTA_COMM=t1sfRequest.getIPropostaComm();
		inpbst.I_PROPOSTA_USURA=t1sfRequest.getIPropostaUsura();
		inpbst.I_TIPO_FT=t1sfRequest.getITipoFT();
		inpbst.I_TIPO_OFFERTA=t1sfRequest.getITipoOfferta();
		
		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = inpbst;
		
		
		CtgConnectorRequest<C_T1SFS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
