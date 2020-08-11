package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.transformers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.connector.db2.transformer.IDB2ResponseTransformer;

@Service
public class ResponseDb2TransformerFactory {
    public static <T> IDB2ResponseTransformer<T, List<T>> of() {
        return jdbcResponse -> jdbcResponse.getResult();
    }
}