package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;


@Service
public class RowMapperTasso implements RowMapper<TassoEntity> {

	public TassoEntity mapRow(ResultSet rs, int rowNum) {
		TassoEntity entity = null;
		try {

			entity= TassoEntity.builder()
					.cdParamTX(rs.getString("CDPARAMTX"))
					.codCondizioneTX(rs.getString("CODCONDIZIONETX"))
					.decaCdzTX(rs.getString("DECACDZTX"))
					.decoCdzTX(rs.getString("DECOCDZTX"))
					.percApplParTX(new BigDecimal(rs.getString("PERCAPPLPARTX")))
					.segnoSpreadTX(rs.getString("SEGNOSPREADTX"))
					.tipoValCdzTX(rs.getString("TIPOVALCDZTX"))
					.valoreCdzTX(new BigDecimal(rs.getString("VALORECDZTX")))
					.valoreSprdTX(new BigDecimal(rs.getString("VALORESPRDTX")))
					.build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return entity;
	}

}
