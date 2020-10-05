package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.oracle.GenericJdbcConnector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.oracle.RequestTransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.oracle.ResponseTransformerFactory;
import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class DBCond0Service extends BaseService{
	
	@Autowired
	private GenericJdbcConnector<Void, Void, Void> genericJdbcConnector;

	@Transactional
	public void annullaProposta(String abi,String annoProposta,String codiceProposta) {
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("cdIterEsito", "Q");
		paramMap.put("abi", abi);
		paramMap.put("annoProposta", annoProposta);
		paramMap.put("codiceProposta", codiceProposta);
		
		StringWriter query = new StringWriter();
		query.append(" UPDATE COND_OWN.T_PR_PROPOSTA ");
		query.append(" SET CD_ITER_ESITO= :cdIterEsito ");
		query.append(" WHERE ");
		query.append("  CD_PROPOSTA_ABI=:abi");
		query.append("  AND CD_PROPOSTA_ANNO= :annoProposta ");
		query.append("  AND CD_PROPOSTA = :codiceProposta");
		
		genericJdbcConnector.call(query.toString(), RequestTransformerFactory.of(null,JDBCQueryType.UPDATE), ResponseTransformerFactory.of(), paramMap);
	
	}
	

}
