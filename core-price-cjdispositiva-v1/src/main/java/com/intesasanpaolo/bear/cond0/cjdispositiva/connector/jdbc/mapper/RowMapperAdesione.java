package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;


@Service
public class RowMapperAdesione implements RowMapper<AdesioneEntity> {

	public AdesioneEntity mapRow(ResultSet rs, int rowNum) {
		AdesioneEntity adesione = null;
		try {

			adesione = AdesioneEntity.builder().codConvenzione(rs.getString("codConvenzione"))
					.infoStampaData(rs.getString("infoStampaData"))
					.infoStampakeyOper(rs.getString("infoStampakeyOper"))
					.intestatarioCodFiscale(rs.getString("intestatarioCodFiscale"))
					.intestatarioNDG(rs.getString("intestatarioNDG"))
					.intestatarioPIVA(rs.getString("intestatarioPIVA"))
					.intestatarioSpecieGiur(rs.getString("intestatarioSpecieGiur"))
					.intestatazione(rs.getString("intestatazione"))
					.rapportoCodCategoria(rs.getString("rapportoCodCategoria"))
					.rapportoCodFiliale(rs.getString("rapportoCodFiliale"))
					.rapportoCodProgressivo(rs.getString("rapportoCodProgressivo"))
					.build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return adesione;
	}

}
