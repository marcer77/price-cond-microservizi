package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.DatiIntestatarioTrasparenza;

public class RowMapperDatiIntestatarioTrasparenza implements RowMapper<DatiIntestatarioTrasparenza> {
	public DatiIntestatarioTrasparenza mapRow(ResultSet rs, int rowNum) {
		DatiIntestatarioTrasparenza entity = null;
		try {

			entity = DatiIntestatarioTrasparenza.builder().trasparenzaCategoria(rs.getString("TrasparenzaCategoria"))
					.trasparenzaDataRiferimento(rs.getString("TrasparenzaDataRiferimento"))
					.trasparenzaFiliale(rs.getString("TrasparenzaFiliale"))
					.trasparenzaNDG(rs.getString("TrasparenzaNDG"))
					.trasparenzaNumRapp(rs.getString("TrasparenzaNumRapp")).build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return entity;
	}
}
