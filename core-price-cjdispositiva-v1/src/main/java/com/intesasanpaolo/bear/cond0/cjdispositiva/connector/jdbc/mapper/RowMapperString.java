package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class RowMapperString implements RowMapper<String> {
	
	private String nomeColonna;
	
	public RowMapperString() {}

	public RowMapperString(String nomeColonna) {
		this.nomeColonna = nomeColonna;
	}

	public String mapRow(ResultSet rs, int rowNum) {
		String result = null;
		try {

			result = rs.getString(nomeColonna);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

}
