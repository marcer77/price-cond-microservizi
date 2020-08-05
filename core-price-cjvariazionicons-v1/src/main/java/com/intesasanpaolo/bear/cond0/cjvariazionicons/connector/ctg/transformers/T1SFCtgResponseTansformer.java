package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTBST;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTESI;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class T1SFCtgResponseTansformer implements ICtgResponseTransformer<C_T1SFS00, T1SFResponse>{
	private static final Logger logger = LoggerUtils.getLogger(T1SFCtgResponseTansformer.class);	
	
	private static <T> boolean hasSomething(T[] objArray) {
        return objArray != null && objArray.length > 0 && objArray[0] != null;
    }
 
    @Override
    public T1SFResponse transform(CtgConnectorResponse<C_T1SFS00> ctgResponse) {
    	C_T1SFS00 connector = ctgResponse.getResult();
 
       // OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ? connector.OUTHEADER[0] : new OUTHEADER();
    	OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
        OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
        OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();
        
        
        T1SFResponse response= T1SFResponse.builder()
        		.mdwEsiAnom( outEsi.MDW_ESI_ANOM)
        		.mdwEsiMsg( outEsi.MDW_ESI_MSG)
        		.mdwEsiRetc(outEsi.MDW_ESI_RETC)
        		.oLivelloSegnalazione(outSeg.O_LIVELLO_SEGNALAZIONE)
        		.oTxtSegnalazione(outSeg.O_TXT_SEGNALAZIONE)
        		.oKeyOperazione(outBody.O_KEY_OPERAZIONE)
        		.oReturnCode( outBody.O_RETURN_CODE)
        		.build();
        
        logger.debug("T1SFResponse={}",response);
        
        return response;
    }

}
