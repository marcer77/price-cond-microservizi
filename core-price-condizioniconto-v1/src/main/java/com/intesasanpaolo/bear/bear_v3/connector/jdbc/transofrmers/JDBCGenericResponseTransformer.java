package com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.connector.jdbc.response.JDBCResponse;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCResponseTransformer;

@Service
public class JDBCGenericResponseTransformer implements IJDBCResponseTransformer<Object, Object>{

    @Override
    public Object transform(JDBCResponse<Object> response) {
    	
    	//RowMapper
    	if(response.getResult() != null) {
    		return response.getResult();
		}
		
    	//Stored procedure    	
    	if (response.getStoredProcedureResult() != null) { 
    		return response.getStoredProcedureResult();
    	}
    	
    	//ResultSetExtractor
    	if(response.getResultSetExtr() != null) {
    		return response.getResultSetExtr();
    	}
    	
    	return null;
    	
    }

}
