package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.oracle;

import org.springframework.jdbc.core.RowMapper;

import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.connector.jdbc.request.JDBCRequest;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCRequestTransformer;

public class RequestTransformerFactory {
    public static <DTO> IJDBCRequestTransformer<String, DTO> of(RowMapper<?> mapper, JDBCQueryType type) {
        return (query, args) -> {
            JDBCRequest<DTO> jdbcRequest = new JDBCRequest<>();
            jdbcRequest.setQuery(query);
            jdbcRequest.setType(type);
            jdbcRequest.setParams(args);
            jdbcRequest.setRowMapper(mapper);
            return jdbcRequest;
        };
    }
}
