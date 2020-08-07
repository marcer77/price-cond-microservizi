package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.C_PCUJS00;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTBST;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTESI;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTRIP;
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutRIP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutTAS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class PCUJCtgResponseTansformer implements ICtgResponseTransformer<C_PCUJS00, PCUJResponse> {
	private static final Logger logger = LoggerUtils.getLogger(PCUJCtgResponseTansformer.class);

	private static <T> boolean hasSomething(T[] objArray) {
		return objArray != null && objArray.length > 0 && objArray[0] != null;
	}

	@Override
	public PCUJResponse transform(CtgConnectorResponse<C_PCUJS00> ctgResponse) {
		C_PCUJS00 connector = ctgResponse.getResult();

		// OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ?
		// connector.OUTHEADER[0] : new OUTHEADER();
		OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
		OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
		OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();

		logger.debug("\n outBody={} \n outEsi={} \n outSeg={}", ServiceUtil.stampaOggetto(outBody), ServiceUtil.stampaOggetto(outEsi),
				ServiceUtil.stampaOggetto(outSeg));

		OutEsi outEsiModel = OutEsi.builder().mdwEsiRetc(outEsi.MDW_ESI_RETC).mdwEsiMsg(outEsi.MDW_ESI_MSG).mdwEsiAnom(outEsi.MDW_ESI_ANOM).build();
		OutSeg outSegModel = OutSeg.builder().txtSegnalazione(outSeg.TXT_SEGNALAZIONE).livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE).build();

		List<OutRIP> outRIPList = new ArrayList<OutRIP>();
		if (hasSomething(outBody.OUTRIP)) {
			Arrays.asList(outBody.OUTRIP).forEach(out -> {

				OutTAS outTAS = OutTAS.builder().build();
				if (hasSomething(out.OUTTAS)) {
					// si prende solo il primo elemento della lista
					outTAS = OutTAS.builder().codParametro(out.OUTTAS[0].COD_PARAMETRO).dataDeca(out.OUTTAS[0].DATA_DECA).dataDeco(out.OUTTAS[0].DATA_DECO)
							.flUsura(out.OUTTAS[0].FL_USURA).percParametro(out.OUTTAS[0].PERC_PARAMETRO).segnoValParametro(out.OUTTAS[0].SEGNO_VAL_PARAMETRO)
							.segnoValSpread(out.OUTTAS[0].SEGNO_VAL_SPREAD).tassoDebitore(out.OUTTAS[0].TASSO_DEBITORE)
							.valParametro(out.OUTTAS[0].VAL_PARAMETRO).valSpread(out.OUTTAS[0].VAL_SPREAD).build();

				}

				OutRIP outRIP = OutRIP.builder().codFt(out.COD_FT).dataScadenzaFido(out.DATA_SCADENZA_FIDO).divisaFido(out.DIVISA_FIDO)
						.importoFido(out.IMPORTO_FIDO).importoFidoEur(out.IMPORTO_FIDO_EUR).tipoFt(out.TIPO_FT).descrFt(out.DESCR_FT)
						.codCatRapRip(out.COD_CAT_RAP_RIP).codFilRappRip(out.COD_FIL_RAPP_RIP).numProgRappRip(out.NUM_PROG_RAPP_RIP).valCDF(out.VAL_CDF)
						.valTaeg(out.VAL_TAEG).valTeg(out.VAL_TEG).outTas(outTAS).build();

				outRIPList.add(outRIP);
			});
		}

		PCUJResponse response = PCUJResponse.builder().outEsi(outEsiModel).outSeg(outSegModel).codEsito(outBody.COD_ESITO).msgEsito(outBody.MSG_ESITO)
				.outRIPList(outRIPList).build();

		logger.debug("response={}", response);

		return response;
	}

}
