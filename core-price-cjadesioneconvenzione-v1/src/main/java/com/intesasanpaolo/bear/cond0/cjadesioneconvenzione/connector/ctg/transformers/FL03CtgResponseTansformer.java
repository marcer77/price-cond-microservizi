package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTBST;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTESI;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class FL03CtgResponseTansformer implements ICtgResponseTransformer<C_FL03S00, FL03Response>{
	private static final Logger logger = LoggerUtils.getLogger(FL03CtgResponseTansformer.class);	
	
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
        
        logger.debug("\n outBody={} \n outEsi={} \n outSeg={}",ServiceUtil.stampaOggetto(outBody),ServiceUtil.stampaOggetto(outEsi),ServiceUtil.stampaOggetto(outSeg));
        
        OutEsi outEsiModel=OutEsi.builder().mdwEsiRetc(outEsi.MDW_ESI_RETC).mdwEsiMsg(outEsi.MDW_ESI_MSG).mdwEsiAnom(outEsi.MDW_ESI_ANOM).build();
        OutSeg ouSegModel=OutSeg.builder().txtSegnalazione(outSeg.TXT_SEGNALAZIONE).livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE).build();
        
        FL03Response fl03Response= FL03Response.builder()
        		.outEsi(outEsiModel)
        		.outSeg(ouSegModel)
        		.codAppli(outBody.COD_APPLIC)
        		.codErr(outBody.COD_ERR)
        		.codSottoAppl(outBody.COD_SOTTOAPPLIC)
        		.descErr(outBody.DESCR_ERR)
        		.formatoStr(outBody.FORMATO_STR)
        		.idTemplate( outBody.ID_TEMPLATE)
        		.keyOper(outBody.KEY_OPER)
        		.numRapporto( outBody.NUM_RAPPORTO)
        		.stringaOut(outBody.STRINGA_OUT)
        		.rc(outBody.RC)
        		.build();
  
        logger.debug("fl03Response={}",fl03Response);
        
        return fl03Response;
       
    }

}
