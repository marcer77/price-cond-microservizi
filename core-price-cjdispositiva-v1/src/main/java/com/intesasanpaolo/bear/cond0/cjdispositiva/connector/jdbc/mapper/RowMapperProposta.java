package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;


@Service
public class RowMapperProposta implements RowMapper<PropostaEntity> {

	public PropostaEntity mapRow(ResultSet rs, int rowNum) {
		PropostaEntity entity = null;
		try {

			entity= PropostaEntity.builder()
					.annoProposta(rs.getString("annoProposta"))
					.codiceProposta(rs.getString("codiceProposta")).build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return entity;
	}

}
