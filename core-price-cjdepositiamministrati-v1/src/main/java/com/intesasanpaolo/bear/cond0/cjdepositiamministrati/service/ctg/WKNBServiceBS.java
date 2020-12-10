package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.service.ctg;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.CTGConnectorWKNB;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers.WKNBCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers.WKNBCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBRequest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class WKNBServiceBS extends BaseService{
	
	private static final Logger logger = LoggerUtils.getLogger(WKNBServiceBS.class);	
	
	@Autowired
	private CTGConnectorWKNB ctgConnectorWKIB;
	
	@Autowired
	private WKNBCtgRequestTrasformer requestTransformer;

	@Autowired
	private WKNBCtgResponseTansformer responseTransformer;

	public WKNBResponse callBS(WKNBRequest wkibRequest) throws BSException {
		WKNBResponse wkibResponse = WKNBResponse.builder().build();
		wkibResponse = this.ctgConnectorWKIB.call(wkibRequest, requestTransformer, responseTransformer, null);
		String[] parametriAggiuntivi=new String[0];
		CJErrorUtil.checkErrore(BSType.WKNBS00, wkibResponse.getOutEsi(),wkibResponse.getOutSeg(),this::additionalCheckErrorFunction,parametriAggiuntivi);
		
		return wkibResponse;
	}
	
	private boolean additionalCheckErrorFunction(String... st) {
		//String test= StringUtils.isNotEmpty(fl03Response.getCodErr())?fl03Response.getCodErr():"";
		//return !st[0].equalsIgnoreCase("0");
		return false;
	}
}
