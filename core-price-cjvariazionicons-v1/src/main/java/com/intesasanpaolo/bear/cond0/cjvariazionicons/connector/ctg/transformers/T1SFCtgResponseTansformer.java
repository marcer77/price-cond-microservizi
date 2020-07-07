package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.springframework.stereotype.Service;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTBST;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTESI;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTHEADER;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class T1SFCtgResponseTansformer implements ICtgResponseTransformer<C_T1SFS00, ResponseResource>{

	private static <T> boolean hasSomething(T[] objArray) {
        return objArray != null && objArray.length > 0 && objArray[0] != null;
    }
 
    @Override
    public ResponseResource transform(CtgConnectorResponse<C_T1SFS00> ctgResponse) {
    	C_T1SFS00 connector = ctgResponse.getResult();
 
        OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ? connector.OUTHEADER[0] : new OUTHEADER();
        OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
        OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
        OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();
 
        ResponseResource response = new ResponseResource();
        //response.setBody(outBody);
        //response.setHeader(outHeader);
        //response.setOutcome(outEsi);
        //response.setReport(outSeg);
 
        return response;
    }

}