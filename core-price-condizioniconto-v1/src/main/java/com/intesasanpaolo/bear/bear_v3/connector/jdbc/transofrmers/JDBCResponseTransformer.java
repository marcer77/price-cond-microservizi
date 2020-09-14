package com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.dto.CondizioneDeroga;
import com.intesasanpaolo.bear.connector.jdbc.response.JDBCResponse;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCResponseTransformer;

@Service
public class JDBCResponseTransformer implements IJDBCResponseTransformer<CondizioneDeroga,CondizioneDeroga> {

	@Override
	public CondizioneDeroga transform(JDBCResponse<CondizioneDeroga> jdbcResponse) {
		CondizioneDeroga result = jdbcResponse.getResult()!=null?jdbcResponse.getResult().get(0):null; 
		return result;
	}

}
