package com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers;

import java.util.List;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.connector.jdbc.request.JDBCRequest;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCRequestTransformer;

@Service
public class JDBCGenericRequestTransformer implements IJDBCRequestTransformer<String, Void>{

    public enum ResultSetExtractorType {
        Row, ResultSet, SP, None
	}
	
	@SuppressWarnings("rawtypes")
	public class GenericRequestConfig {

		public GenericRequestConfig() {
			parameters = null;
		}

		public JDBCQueryType queryType;
		public ResultSetExtractorType extractorType;

		public RowMapper rowMapper;
		public ResultSetExtractor resultSetExtractor;
		public CallableStatementCreator callableStatementCreator;

		public Object parameters;
	}

	public GenericRequestConfig createConfig() {
		return new GenericRequestConfig();
	}

    @Override
    @SuppressWarnings("all")
    public JDBCRequest<Void> transform(String query, Object... args) {

		GenericRequestConfig config = (GenericRequestConfig)args[0];

        JDBCRequest<Void> jdbcConnectorRequest = new JDBCRequest<>();
        jdbcConnectorRequest.setQuery(query);
        jdbcConnectorRequest.setType(config.queryType);

        switch (config.extractorType) {

            case Row:
                jdbcConnectorRequest.setRowMapper(config.rowMapper);  
                break;
            case ResultSet:
                jdbcConnectorRequest.setResultSetExtractor(config.resultSetExtractor);
                break;
            case SP:
            	jdbcConnectorRequest.setCallableStatementCreator(config.callableStatementCreator);				
				break;
				
            default:
                break;
		}      
		        
		if (config.parameters != null) 
		switch (config.extractorType) {
			case Row:
			case ResultSet:
				jdbcConnectorRequest.setParams((Object[])config.parameters);
				break;
			
			case SP:
				jdbcConnectorRequest.setStoredProcedureParameters((List<SqlParameter>)config.parameters);
				break;
		}
		        
		return jdbcConnectorRequest;
    }
	
}
