package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTBST;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTESI;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class T1SJCtgResponseTansformer implements ICtgResponseTransformer<C_T1SJS00, T1SJResponse> {
	private static final Logger logger = LoggerUtils.getLogger(T1SJCtgResponseTansformer.class);

	private static <T> boolean hasSomething(T[] objArray) {
		return objArray != null && objArray.length > 0 && objArray[0] != null;
	}

	@Override
	public T1SJResponse transform(CtgConnectorResponse<C_T1SJS00> ctgResponse) {
		C_T1SJS00 connector = ctgResponse.getResult();

		// OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ?
		// connector.OUTHEADER[0] : new OUTHEADER();
		OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
		OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
		OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();
		  
		logger.debug("\n outBody={} \n outEsi={} \n outSeg={}",ServiceUtil.stampaOggetto(outBody),ServiceUtil.stampaOggetto(outEsi),ServiceUtil.stampaOggetto(outSeg));
	      
		 
        OutEsi outEsiModel=OutEsi.builder().mdwEsiRetc(outEsi.MDW_ESI_RETC).mdwEsiMsg(outEsi.MDW_ESI_MSG).mdwEsiAnom(outEsi.MDW_ESI_ANOM).build();
        OutSeg outSegModel=OutSeg.builder().txtSegnalazione(outSeg.TXT_SEGNALAZIONE).livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE).build();
       
		
		T1SJResponse t1sjResponse= T1SJResponse.builder()
				.outEsi(outEsiModel)
				.outSeg(outSegModel)
				.t1SjOKeyOperazione(outBody.T1SJ_O_KEY_OPERAZIONE)
				.t1SjOProgStampa(outBody.T1SJ_O_PROG_STAMPA)
				.t1SjOReturnCode(outBody.T1SJ_O_RETURN_CODE)
				.build();
		
		logger.debug("t1sjResponse={}",t1sjResponse);
		
		return t1sjResponse;

	}

}
