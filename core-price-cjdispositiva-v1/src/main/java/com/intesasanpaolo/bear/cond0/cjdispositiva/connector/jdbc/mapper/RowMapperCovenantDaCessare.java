package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.Covenant;


@Service
public class RowMapperCovenantDaCessare implements RowMapper<CovenantEntity> {

	public CovenantEntity mapRow(ResultSet rs, int rowNum) {
		CovenantEntity covenant = null;
		try {

			covenant = CovenantEntity.builder().codCondizione(rs.getString("covEstFilRapp"))
					.codiceTemplate(rs.getString("covEstCatRapp"))
					.versioneTemplate(rs.getInt("covEstNumRapp"))
					.rapportoCategoria(rs.getString("covEstCodCondizione"))
					.rapportoFiliale(rs.getString("covEstCodiceTemplate"))
					.rapportoConto(rs.getString("covEstVersioneTemplate"))
					.build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return covenant;
	}

}
