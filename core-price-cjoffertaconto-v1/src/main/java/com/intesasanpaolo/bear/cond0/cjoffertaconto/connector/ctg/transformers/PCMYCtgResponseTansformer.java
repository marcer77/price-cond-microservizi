package com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.C_PCMYS00;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTBST;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTESI;
import com.dsi.business.SSA_PC.integration.jdo.P_PCMYS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutCPR;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutOFF;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutPRD;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class PCMYCtgResponseTansformer implements ICtgResponseTransformer<C_PCMYS00, PCMYResponse>{
	private static final Logger logger = LoggerUtils.getLogger(PCMYCtgResponseTansformer.class);	
	
	private static <T> boolean hasSomething(T[] objArray) {
        return objArray != null && objArray.length > 0 && objArray[0] != null;
    }
 
    @Override
    public PCMYResponse transform(CtgConnectorResponse<C_PCMYS00> ctgResponse) {
    	C_PCMYS00 connector = ctgResponse.getResult();
 
        //OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ? connector.OUTHEADER[0] : new OUTHEADER();
        OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
        OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
        OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();
        
        logger.debug("\n outBody={} \n outEsi={} \n outSeg={}",ServiceUtil.stampaOggetto(outBody),ServiceUtil.stampaOggetto(outEsi),ServiceUtil.stampaOggetto(outSeg));
        
        OutEsi outEsiModel=OutEsi.builder().mdwEsiRetc(outEsi.MDW_ESI_RETC).mdwEsiMsg(outEsi.MDW_ESI_MSG).mdwEsiAnom(outEsi.MDW_ESI_ANOM).build();
        OutSeg ouSegModel=OutSeg.builder().txtSegnalazione(outSeg.TXT_SEGNALAZIONE).livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE).build();
        
        List<OutPRD>  outPrdList=new ArrayList<>();
        List<OutOFF>  outOffList=new ArrayList<> ();
        
        if (hasSomething(outBody.OUTPRD)) {
        	
        	Arrays.asList(outBody.OUTPRD).forEach(outPRD->{
        		
        		List<OutCPR> outCPRList=new ArrayList<>();
        		
        		if (hasSomething(outPRD.OUTCPR)) {
        			
        			Arrays.asList(outPRD.OUTCPR).forEach(outCPR->{
        				
        				OutCPR tmp=OutCPR.builder()
            					.costoProdotto(outCPR.COSTO_PRODOTTO)
            					.costoProdottoPRM(outCPR.COSTO_PRODOTTO_PRM)
            					.decaProdotto(outCPR.DECA_PRODOTTO)
            					.decoProdotto(outCPR.DECO_PRODOTTO)
            					.flgProdotto(outCPR.FLG_PRODOTTO)
            					.flgValPromo(outCPR.FLG_VAL_PROMO)
            					.build();
        				
            			outCPRList.add(tmp);
            				
        			});
        			
        		}
        		
        		
        		OutPRD tmp =OutPRD.builder()
        				.codCondizione(outPRD.COD_CONDIZIONE)
        				.descrProdotto(outPRD.DESCR_PRODOTTO)
        				.outCPRList(outCPRList)
        				.build();
        	
        		outPrdList.add(tmp);
        	});
        }
        
        if (hasSomething(outBody.OUTOFF)) {  	
        	Arrays.asList(outBody.OUTOFF).forEach(outOff->{
        		
        		OutOFF tmp= OutOFF
        				.builder()
        				.costoListino(outOff.COSTO_LISTINO)
        				.costoOfferta(outOff.COSTO_OFFERTA)
        				.decaOfferta(outOff.DECA_OFFERTA)
        				.decoOfferta(outOff.DECO_OFFERTA)
        				.flAgevolato(outOff.FL_AGEVOLATO)
        				.build();
        		
        		outOffList.add(tmp);
        	});	
        }
       
        
        PCMYResponse response= PCMYResponse.builder()
        		.outEsi(outEsiModel)
        		.outSeg(ouSegModel)
        		.codEsito( outBody.COD_ESITO)
        		.codOfferta(outBody.COD_OFFERTA)
        		.outPrdList(outPrdList)
        		.outOffList(outOffList)
        		.build();
          
        logger.debug("response={}",response);
        
        return response;
       
    }

}
