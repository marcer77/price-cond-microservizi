package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.transformers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.connector.db2.request.DB2Request;
import com.intesasanpaolo.bear.connector.db2.transformer.IDB2RequestTransformer;

@Service
public class RequestDb2TransformerFactory {
	public static <DTO> IDB2RequestTransformer<String, DTO> of(RowMapper<?> mapper, DB2QueryType type) {
		return (query, args) -> {
			DB2Request<DTO> db2ConnectorRequest = new DB2Request<>();
			db2ConnectorRequest.setQuery(query);
			db2ConnectorRequest.setRowMapper(mapper);
			db2ConnectorRequest.setType(type);
			db2ConnectorRequest.setAbi((String) args[1]);
			db2ConnectorRequest.setParams((Object[]) args[0]);			
			return db2ConnectorRequest;
		};
	}
}