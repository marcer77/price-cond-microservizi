package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.mapper.LetturaRRowMapper;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception.SuperPraticaNotFoundDB2Exception;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class SuperPraticaService extends BaseService{
	
	 @Autowired
	 private MultiDataSourceDb2Connector<String, Void, String> convRifMultiDataSourceConnector;
	 
	
	public List<String> recuperaPraticheBySuperPratica(String codAbi, String codSuperPratica){
		logger.info("START recuperaPraticheBySuperPratica");

		String query = "SELECT DISTINCT" + 
				" NR_PRATICA " + 
				" FROM FIATT.TB59R009" + 
				" WHERE NR_SUPERPRATICA = :codSuperPratic";


		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratic", codSuperPratica);
		
		List<String> resultList = convRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
		logger.debug("Founded:", resultList);
		
		if (CollectionUtils.isEmpty(resultList)) {
			throw SuperPraticaNotFoundDB2Exception.builder().codSuperPratica(codSuperPratica).build();
		}
			

		logger.info("END letturaRConvenzioneDiRifiremento");
		return resultList;
	}
	
}