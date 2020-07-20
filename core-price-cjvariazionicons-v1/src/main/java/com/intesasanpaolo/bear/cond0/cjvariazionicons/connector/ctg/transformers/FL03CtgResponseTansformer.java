package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTBST;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTESI;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class FL03CtgResponseTansformer implements ICtgResponseTransformer<C_FL03S00, FL03Response>{

	private static <T> boolean hasSomething(T[] objArray) {
        return objArray != null && objArray.length > 0 && objArray[0] != null;
    }
 
    @Override
    public FL03Response transform(CtgConnectorResponse<C_FL03S00> ctgResponse) {
    	C_FL03S00 connector = ctgResponse.getResult();
 
        //OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ? connector.OUTHEADER[0] : new OUTHEADER();
        OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
        OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
        OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();
        
        return FL03Response.builder()
        		.codAppli(outBody.COD_APPLIC)
        		.codErr(outBody.COD_ERR)
        		.codSottoAppl(outBody.COD_SOTTOAPPLIC)
        		.descErr(outBody.DESCR_ERR)
        		.formatoStr(outBody.FORMATO_STR)
        		.idTemplate( outBody.ID_TEMPLATE)
        		.keyOper(outBody.KEY_OPER)
        		.livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE)
        		.txtSegnalazione(outSeg.TXT_SEGNALAZIONE)
        		.mdwEsiAnom( outEsi.MDW_ESI_ANOM)
        		.mdwEsiMsg( outEsi.MDW_ESI_MSG)
        		.mdwEsiRetc(outEsi.MDW_ESI_RETC)
        		.numRapporto( outBody.NUM_RAPPORTO)
        		.stringaOut(outBody.STRINGA_OUT)
        		.build();
  
       
    }

}
