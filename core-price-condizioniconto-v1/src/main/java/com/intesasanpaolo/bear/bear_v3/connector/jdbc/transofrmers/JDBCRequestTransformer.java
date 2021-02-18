package com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers;

import java.util.Arrays;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.dto.CondizioneDeroga;
import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.connector.jdbc.request.JDBCRequest;
import com.intesasanpaolo.bear.connector.jdbc.transformer.IJDBCRequestTransformer;

@Service
public class JDBCRequestTransformer implements IJDBCRequestTransformer<String, Void> {

	@Override
	public JDBCRequest<Void> transform(String query, Object... args) {
		
		JDBCRequest<Void> jdbcConnectorRequest = new JDBCRequest<>();
        jdbcConnectorRequest.setQuery(query);
        jdbcConnectorRequest.setRowMapper(new BeanPropertyRowMapper(CondizioneDeroga.class));
        jdbcConnectorRequest.setType((JDBCQueryType) args[0]);

        if (args.length > 1)
            jdbcConnectorRequest.setParams(Arrays.copyOfRange(args, 1, args.length));

		return jdbcConnectorRequest;
	}

}
