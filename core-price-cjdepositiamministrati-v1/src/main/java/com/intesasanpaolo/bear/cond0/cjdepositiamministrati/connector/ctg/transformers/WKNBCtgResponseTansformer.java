package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.C_WKNBS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTBST;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTESI;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTRC4;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTRCZ;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTRNO;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTRPR;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTRTS;
import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponse;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponseRigheDiStampa;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class WKNBCtgResponseTansformer implements ICtgResponseTransformer<C_WKNBS00, WKNBResponse>{

	private static final Logger logger = LoggerUtils.getLogger(WKNBCtgResponseTansformer.class);

	private static <T> boolean hasSomething(T[] objArray) {
		return objArray != null && objArray.length > 0 && objArray[0] != null;
	}
	
	@Override
	public WKNBResponse transform(CtgConnectorResponse<C_WKNBS00> ctgConnectorResponse) {
		C_WKNBS00 connector = ctgConnectorResponse.getResult();
		
		OUTBST outbst = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
        OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
        OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();
        
		List<WKNBResponseRigheDiStampa> elenco = new ArrayList<>();
		if (hasSomething(outbst.OUTSTP)) {
			Arrays.asList(outbst.OUTSTP).forEach(out -> {

				WKNBResponseRigheDiStampa wkibResponseRigheDiStampa = WKNBResponseRigheDiStampa.builder()
				.prgStp(out.PROGR_STP+"")
				.prgStrut(out.PROG_STRUT+"")
				.tipoStrut(out.TIPO_STRUT)
				.flContinua(out.FL_CONTINUA)
				.tipoSezione(out.TIPO_SEZ)
				.build();
				
				OUTRC4 outrc4 = hasSomething(out.OUTRC4) ? out.OUTRC4[0] : new OUTRC4();
				
				wkibResponseRigheDiStampa.setTesto1(outrc4.CAMPI4_1);
				wkibResponseRigheDiStampa.setTesto2(outrc4.CAMPI4_2);
				wkibResponseRigheDiStampa.setTesto3(outrc4.CAMPI4_3);
				wkibResponseRigheDiStampa.setTesto4(outrc4.CAMPI4_4);
				
				OUTRTS outrts = hasSomething(out.OUTRTS) ? out.OUTRTS[0] : new OUTRTS();
				
				wkibResponseRigheDiStampa.setTesto(outrts.TESTO);
				wkibResponseRigheDiStampa.setEvidTesto(outrts.EVID_TESTO);
				
				OUTRCZ outrcz = hasSomething(out.OUTRCZ) ? out.OUTRCZ[0] : new OUTRCZ();
				
				wkibResponseRigheDiStampa.setCodCond(outrcz.COD_COND);
				wkibResponseRigheDiStampa.setDataDeco(outrcz.DATA_DECO);
				wkibResponseRigheDiStampa.setEvidDtDeco(outrcz.EVID_DTDEC);
				
				wkibResponseRigheDiStampa.setDescrCond(outrcz.DESCR_CND);
				wkibResponseRigheDiStampa.setEvidDescr(outrcz.EVID_DESCR);
				wkibResponseRigheDiStampa.setValore(outrcz.VALORE);
				wkibResponseRigheDiStampa.setEvidValore(outrcz.EVID_VAL);
				wkibResponseRigheDiStampa.setIndNota(outrcz.IND_NOTA);
				wkibResponseRigheDiStampa.setEvidNota(outrcz.EVID_NOTA);
				OUTRNO outrno = hasSomething(out.OUTRNO) ? out.OUTRNO[0] : new OUTRNO();
				
				wkibResponseRigheDiStampa.setNum(outrno.NUM_NOTA);
				wkibResponseRigheDiStampa.setEvidNrNota(outrno.EVID_NR_NOTA);
				wkibResponseRigheDiStampa.setEvidTxNota(outrno.EVID_TX_NOTA);
				
				
				wkibResponseRigheDiStampa.setTestoNota(outrno.TESTO_NOTA);
				
				OUTRPR outrpr = hasSomething(out.OUTRPR) ? out.OUTRPR[0] : new OUTRPR();
				
				wkibResponseRigheDiStampa.setTestoPromozione(outrpr.TESTO_PROMO);
				
				elenco.add(wkibResponseRigheDiStampa);
			});
		}
		
        OutEsi outEsiModel=OutEsi.builder().mdwEsiRetc(outEsi.MDW_ESI_RETC).mdwEsiMsg(outEsi.MDW_ESI_MSG).mdwEsiAnom(outEsi.MDW_ESI_ANOM).build();
        OutSeg ouSegModel=OutSeg.builder().txtSegnalazione(outSeg.TXT_SEGNALAZIONE).livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE).build();
      
		WKNBResponse wkibResponse = WKNBResponse.builder()
        		.outEsi(outEsiModel)
        		.outSeg(ouSegModel)
				.codDDS(outbst.COD_DDS)
				.codTemplate(outbst.COD_TEMPL)
				.elenco(elenco)
				.build();
		
		logger.debug("wkibResponse={}", wkibResponse);
		
		return wkibResponse;
	}

}