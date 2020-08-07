package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorPCUJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutTAS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class PCUJServiceBS extends BaseService {
	private static final Logger logger = LoggerUtils.getLogger(PCUJServiceBS.class);

	@Autowired
	private CTGConnectorPCUJ ctgConnectorPCUJ;

	@Autowired
	private PCUJCtgRequestTrasformer requestTransformer;

	@Autowired
	private PCUJCtgResponseTansformer responseTransformer;

	public PCUJResponse callBS(PCUJRequest pcujRequest) {
		PCUJResponse pcujResponse = new PCUJResponse();
		pcujResponse = this.ctgConnectorPCUJ.call(pcujRequest, requestTransformer, responseTransformer, null);
		String[] parametriAggiuntivi = new String[0];
		CJErrorUtil.checkErrore(BSType.PCUJS00, pcujResponse.getOutEsi(), pcujResponse.getOutSeg(),
				this::additionalCheckErrorFunction, parametriAggiuntivi);

		//TODO:RECUPERARE DESCRIZIONE DA DATABASE ORACLE a partire dal valore: rip.getOutTas().getCodParametro()
		pcujResponse.getOutRIPList().forEach(rip->{
			OutTAS outTAS=rip.getOutTas();
			String codPar=outTAS.getCodParametro();
			outTAS.setDescrizioneIndiceDB("____descrizione___indice_db");
		});
		return pcujResponse;

	}

	private boolean additionalCheckErrorFunction(String... st) {
		return false;
	}

}
