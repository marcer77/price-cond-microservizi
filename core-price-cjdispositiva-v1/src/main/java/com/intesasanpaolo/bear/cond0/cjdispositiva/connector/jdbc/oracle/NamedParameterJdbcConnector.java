package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.oracle;

import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterUtils;

import com.intesasanpaolo.bear.connector.jdbc.JdbcConnector;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCRequestTransformer;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCResponseTransformer;

public class NamedParameterJdbcConnector<OUTPUT, DTO, RESOURCE> extends JdbcConnector<String, OUTPUT, DTO, RESOURCE> {

    public OUTPUT call(String query, IJDBCRequestTransformer<String, DTO> request,
            IJDBCResponseTransformer<RESOURCE, OUTPUT> response, Map<String, ?> paramMap) {

        Object[] params = (!paramMap.keySet().isEmpty()) ? NamedParameterUtils.buildValueArray(query, paramMap) : null;
        String parsedQuery = query.replaceAll(":\\w{0,}", "?");
        return call(parsedQuery, request, response, params);

    }

}
