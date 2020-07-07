package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import org.springframework.stereotype.Service;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.C_FL03S00;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTBST;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTESI;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTHEADER;
import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class FL03CtgResponseTansformer implements ICtgResponseTransformer<C_FL03S00, ResponseResource>{

	private static <T> boolean hasSomething(T[] objArray) {
        return objArray != null && objArray.length > 0 && objArray[0] != null;
    }
 
    @Override
    public ResponseResource transform(CtgConnectorResponse<C_FL03S00> ctgResponse) {
    	C_FL03S00 connector = ctgResponse.getResult();
 
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
