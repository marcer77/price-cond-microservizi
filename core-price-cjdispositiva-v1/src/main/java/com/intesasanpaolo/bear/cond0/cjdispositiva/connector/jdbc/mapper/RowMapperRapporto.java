package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;


@Service
public class RowMapperRapporto implements RowMapper<RapportoEntity> {

	public RapportoEntity mapRow(ResultSet rs, int rowNum) {
		RapportoEntity entity = null;
		try {

			entity= RapportoEntity.builder().filiale(rs.getString("FILRAPPTX"))
					.categoria(rs.getString("CATRAPPTX"))
					.numero(rs.getString("NUMRAPPTX")).build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return entity;
	}

}
