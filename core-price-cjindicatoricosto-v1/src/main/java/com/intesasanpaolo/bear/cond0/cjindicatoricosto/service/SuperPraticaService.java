package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.mapper.LetturaRRowMapper;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.SuperPraticaRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.SuperPraticaResponse;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class SuperPraticaService extends BaseService{
	
	 @Autowired
	 private MultiDataSourceDb2Connector<String, Void, String> convRifMultiDataSourceConnector;
	 
	 @Autowired
	 private MultiDataSourceDb2Connector<Void, Void, Void> updateRifMultiDataSourceConnector;
	
	

	public SuperPraticaResponse recuperaInfoSuperPratica(SuperPraticaRequest superPraticaRequest) {
		return new SuperPraticaResponse();
	}

	public List<String> recuperaPraticheBySuperPratica(String codAbi, String codSuperPratic){
		logger.info("START letturaRConvenzioneDiRifiremento");

		String query = "SELECT DISTINCT" + 
				" NR_PRATICA" + 
				" FROM FIATT.TB59R009" + 
				" WHERE NR_SUPERPRATICA = :codSuperPratic";


		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratic", codSuperPratic);
		
		List<String> resultList = convRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
		logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return resultList;
	}
	
}