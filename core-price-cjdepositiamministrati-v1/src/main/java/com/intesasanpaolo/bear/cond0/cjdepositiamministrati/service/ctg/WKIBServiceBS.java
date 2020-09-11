//package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.service.ctg;
//
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
//import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
//import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.CTGConnectorWKIB;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers.WKIBCtgRequestTrasformer;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.transformers.WKIBCtgResponseTansformer;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBRequest;
//import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBResponse;
//import com.intesasanpaolo.bear.config.LoggerUtils;
//import com.intesasanpaolo.bear.service.BaseService;
//
//@Service
//public class WKIBServiceBS extends BaseService{
//	
//	private static final Logger logger = LoggerUtils.getLogger(WKIBServiceBS.class);	
//	
//	@Autowired
//	private CTGConnectorWKIB ctgConnectorWKIB;
//	
//	@Autowired
//	private WKIBCtgRequestTrasformer requestTransformer;
//
//	@Autowired
//	private WKIBCtgResponseTansformer responseTransformer;
//
//	public WKIBResponse callBS(WKIBRequest wkibRequest) throws BSException {
//		WKIBResponse wkibResponse = WKIBResponse.builder().build();
//		wkibResponse = this.ctgConnectorWKIB.call(wkibRequest, requestTransformer, responseTransformer, null);
//		String[] parametriAggiuntivi=new String[0];
//		CJErrorUtil.checkErrore(BSType.WKIBS00, wkibResponse.getOutEsi(),wkibResponse.getOutSeg(),this::additionalCheckErrorFunction,parametriAggiuntivi);
//		
//		return wkibResponse;
//	}
//	
//	private boolean additionalCheckErrorFunction(String... st) {
//		//String test= StringUtils.isNotEmpty(fl03Response.getCodErr())?fl03Response.getCodErr():"";
//		//return !st[0].equalsIgnoreCase("0");
//		return false;
//	}
//}
