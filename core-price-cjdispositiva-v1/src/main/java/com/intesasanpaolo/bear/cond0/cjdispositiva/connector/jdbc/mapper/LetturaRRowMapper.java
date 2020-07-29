package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ConvRiferimento;


@Service
public class LetturaRRowMapper implements RowMapper<ConvRiferimento> {

	public ConvRiferimento mapRow(ResultSet rs, int rowNum) {
		ConvRiferimento convRiferimento = new ConvRiferimento();
		try {
			convRiferimento.setCodConvenzioneRf(rs.getString("codConvenzioneRf"));		 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return convRiferimento;
	}
	
}
