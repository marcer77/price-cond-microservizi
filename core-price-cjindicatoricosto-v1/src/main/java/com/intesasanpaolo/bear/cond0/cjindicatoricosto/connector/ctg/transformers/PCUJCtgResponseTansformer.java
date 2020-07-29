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
import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.OUTTAS;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutRIP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutTAS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutCNF;
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

		logger.debug("\n outBody={} \n outEsi={} \n outSeg={}", ServiceUtil.stampaOggetto(outBody),
				ServiceUtil.stampaOggetto(outEsi), ServiceUtil.stampaOggetto(outSeg));

		List<OutRIP> outRIPList = new ArrayList<OutRIP>();
		if (hasSomething(outBody.OUTRIP)) {
			Arrays.asList(outBody.OUTRIP).forEach(out -> {
				List<OutTAS> outTasList = new ArrayList<OutTAS>();

				if (hasSomething(out.OUTTAS)) {
					Arrays.asList(out.OUTTAS).forEach(outTas -> {
						OutTAS outTAS = OutTAS.builder().codParametro(outTas.COD_PARAMETRO).dataDeca(outTas.DATA_DECA)
								.dataDeco(outTas.DATA_DECO).flUsura(outTas.FL_USURA)
								.percParametro(outTas.PERC_PARAMETRO).segnoValParametro(outTas.SEGNO_VAL_PARAMETRO)
								.segnoValSpread(outTas.SEGNO_VAL_SPREAD).tassoDebitore(outTas.TASSO_DEBITORE)
								.valParametro(outTas.VAL_PARAMETRO).valSpread(outTas.VAL_SPREAD).build();
						outTasList.add(outTAS);
					});
				}

				OutRIP outRIP = OutRIP.builder().codFt(out.COD_FT).dataScadenzaFido(out.DATA_SCADENZA_FIDO)
						.divisaFido(out.DIVISA_FIDO).importoFido(out.IMPORTO_FIDO).importoFidoEur(out.IMPORTO_FIDO_EUR)
						.tipoFt(out.TIPO_FT).outTasList(outTasList).build();
				outRIPList.add(outRIP);
			});
		}

		PCUJResponse response = PCUJResponse.builder().mdwEsiAnom(outEsi.MDW_ESI_ANOM).mdwEsiMsg(outEsi.MDW_ESI_MSG)
				.mdwEsiRetc(outEsi.MDW_ESI_RETC).livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE)
				.txtSegnalazione(outSeg.TXT_SEGNALAZIONE).codEsito(outBody.COD_ESITO).msgEsito(outBody.MSG_ESITO)

				.build();

		logger.debug("response={}", response);

		return response;
	}

}
