package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.Covenant;


@Service
public class RowMapperCovenantDaAttivare implements RowMapper<CovenantEntity> {

	public CovenantEntity mapRow(ResultSet rs, int rowNum) {
		CovenantEntity covenant = null;
		try {

			covenant = CovenantEntity.builder().codCondizione(rs.getString("covCodCondizione"))
					.codiceTemplate(rs.getString("covCodiceTemplate"))
					.versioneTemplate(rs.getInt("covVersioneTemplate"))
					.covenantDataInizio(rs.getString("covDataInizio"))
					.covenantDataFine(rs.getString("covDataFine"))
					.beneficioIngressoPresente(rs.getString("covBeneficioIngressoPresente"))
					.beneficioIngressoDataInizio(rs.getString("covBeneficioIngressoDataInizio"))
					.beneficioIngressoDataFine(rs.getString("covBeneficioIngressoDataFine"))
					.beneficioIncondizionatoPresente(rs.getString("covBeneficioIncondPresente"))
					.beneficioIncondizionatoDatainizio(rs.getString("covBeneficioIncondDataInizio"))
					.beneficioIncondizionatoDatainizio(rs.getString("covBeneficioIncondDataFine"))
					.beneficioIncondizionatoNumRilevazioni(rs.getString("covBeneficioIncondNumRilev"))
					.beneficioCondizionatoDataInizio(rs.getString("covBeneficioCondDataInizio"))
					.beneficioCondizionatoDataFine(rs.getString("covBeneficioCondDataFine"))
					.flagEventoEtaCliente(rs.getString("covFlagEventoEtaCliente"))
					.flagEffettoRilevato(rs.getString("covFlagEffettoRilevato"))
					.build();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return covenant;
	}

}
