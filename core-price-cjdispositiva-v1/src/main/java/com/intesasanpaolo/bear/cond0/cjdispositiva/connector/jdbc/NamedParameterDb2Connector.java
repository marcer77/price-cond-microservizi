package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc;

import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterUtils;

import com.intesasanpaolo.bear.connector.db2.DB2MultipleDatasourceConnector;
import com.intesasanpaolo.bear.connector.db2.transformer.IDB2RequestTransformer;
import com.intesasanpaolo.bear.connector.db2.transformer.IDB2ResponseTransformer;

public class NamedParameterDb2Connector<OUTPUT, DTO, RESOURCE> 
	extends DB2MultipleDatasourceConnector<String, OUTPUT, DTO, RESOURCE> {

    public OUTPUT call(String query, IDB2RequestTransformer<String, DTO> request,
            IDB2ResponseTransformer<RESOURCE, OUTPUT> response, Map<String, ?> paramMap, String abi) {

        Object[] params = (!paramMap.keySet().isEmpty()) ? NamedParameterUtils.buildValueArray(query, paramMap) : null;
        String parsedQuery = query.replaceAll(":\\w{0,}", "?");
        return call(parsedQuery, request, response, params, abi);

    }

}
