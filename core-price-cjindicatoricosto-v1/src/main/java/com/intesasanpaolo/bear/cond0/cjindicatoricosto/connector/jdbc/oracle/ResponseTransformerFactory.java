package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.oracle;

import java.util.List;

import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCResponseTransformer;

public class ResponseTransformerFactory {
    public static <T> IJDBCResponseTransformer<T, List<T>> of() {
        return jdbcResponse -> jdbcResponse.getResult();
    }
}
