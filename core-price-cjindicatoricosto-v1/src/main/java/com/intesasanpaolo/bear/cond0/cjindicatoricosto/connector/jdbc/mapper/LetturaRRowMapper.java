package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;



@Service
public class LetturaRRowMapper implements RowMapper<String> {

	public String mapRow(ResultSet rs, int rowNum) {
		String ret = null;
		try {
			ret = rs.getString("NR_PRATICA");		 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;
	}
	
}
