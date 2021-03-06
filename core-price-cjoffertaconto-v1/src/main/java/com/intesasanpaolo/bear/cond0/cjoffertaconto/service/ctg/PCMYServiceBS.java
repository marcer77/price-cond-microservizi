package com.intesasanpaolo.bear.cond0.cjoffertaconto.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.CTGConnectorPCMY;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers.PCMYCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.connector.ctg.transformers.PCMYCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYRequest;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class PCMYServiceBS extends BaseService {
	private static final Logger logger = LoggerUtils.getLogger(PCMYServiceBS.class);

	@Autowired
	private CTGConnectorPCMY ctgConnectorPCMY;

	@Autowired
	private PCMYCtgRequestTrasformer requestTransformer;

	@Autowired
	private PCMYCtgResponseTansformer responseTransformer;

	public PCMYResponse callBS(PCMYRequest request) {
		PCMYResponse response = PCMYResponse.builder().build();
		response= this.ctgConnectorPCMY.call(request, requestTransformer, responseTransformer,new Object[] {});
		String[] parametriAggiuntivi=new String[0];
		CJErrorUtil.checkErrore(BSType.PCMYS00, response.getOutEsi(),response.getOutSeg(),this::additionalCheckErrorFunction,parametriAggiuntivi);
		
		return response;
	}

	private boolean additionalCheckErrorFunction(String... st) {
		//String test= StringUtils.isNotEmpty(fl03Response.getCodErr())?fl03Response.getCodErr():"";
		//return !st[0].equalsIgnoreCase("0");
		return false;
	}

}
