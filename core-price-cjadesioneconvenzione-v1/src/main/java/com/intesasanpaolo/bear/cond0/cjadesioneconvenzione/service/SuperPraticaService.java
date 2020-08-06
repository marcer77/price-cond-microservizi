package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.mapper.LetturaRRowMapper;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;
import static com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil.*;

@Service
public class SuperPraticaService extends BaseService {

	@Autowired
	private MultiDataSourceDb2Connector<String, Void, String> convRifMultiDataSourceConnector;

	@Autowired
	private MultiDataSourceDb2Connector<Void, Void, Void> updateRifMultiDataSourceConnector;

	public List<String> recuperaCodConvenzione(String codAbi, String codSuperPratica, String nrPratica) {
		logger.info("recuperaCodConvenzione codAbi {} codSuperPratica {} nrPratica {} START ",codAbi,codSuperPratica,nrPratica);

		String query = "SELECT DISTINCT" + " COD_ENTITA " + " FROM FIATT.TB59R009"
				+ " WHERE NR_SUPERPRATICA = :codSuperPratica" + " AND NR_PRATICA = :numeroPratica"
				+ " AND ID_ENTITA = '00001'";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("numeroPratica", nrPratica);

		List<String> resultList = convRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);

		logger.info("END recuperaCodConvenzione");
		return resultList;
	}

	// @Transactional
	public void deleteEntita(String codAbi, String codSuperPratica, String nrPratica, String idEntita) {
		logger.info("deleteEntita codAbi {} codSuperPratica {} nrPratica {} idEntita {} START",codAbi,codSuperPratica,nrPratica,idEntita);

		String query = "DELETE" + " FROM FIATT.TB59R009" + " WHERE NR_SUPERPRATICA = :codSuperPratica"
				+ " AND NR_PRATICA = :numeroPratica" + " AND ID_ENTITA = :idEntita";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("numeroPratica", nrPratica);
		paramMap.put("idEntita", idEntita);

		updateRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.info("END deleteEntita");
	}

//	@Transactional
	public void insertEntita(String codAbi,TB59R009 entity) {
		logger.info("START insertEntita");

		String query = "INSERT INTO"
				+ " FIATT.TB59R009 (NR_SUPERPRATICA, NR_PRATICA, ID_ENTITA, STATO, PROGR_ENTITA, PROGR_DATI, COD_ENTITA, DATI_ENTITA, TIPO_AGGIORNAMENTO, COD_OPE_ULT_MODIF, DATA_INSER,DT_ULT_MODIFICA)"
				+ " VALUES(:NR_SUPERPRATICA, :NR_PRATICA, :ID_ENTITA, :STATO, :PROGR_ENTITA, :PROGR_DATI, :COD_ENTITA, :DATI_ENTITA, :TIPO_AGGIORNAMENTO, :COD_OPE_ULT_MODIF, :DATA_INSER, :DT_ULT_MODIFICA)";
//				+ "TIMESTAMP_FORMAT(:CURRENT_DATE,'YYYY-MM-DD HH24.MI.SS'), TIMESTAMP_FORMAT(:CURRENT_DATE,'YYYY-MM-DD HH24.MI.SS'))"; //FUNZIONE NON RICONOSCIUTA DA H2

		String now = dateToString(new Date(), "yyyy-MM-dd HH.mm.ss");
		String timestamp = dateToString(new Date(), "yyyy-MM-dd HH.mm.ss");
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("NR_SUPERPRATICA", entity.getNrSuperpratica());
		paramMap.put("NR_PRATICA", entity.getNrPratica());
		paramMap.put("ID_ENTITA", entity.getIdEntita());

		paramMap.put("STATO", entity.getStato());
		paramMap.put("PROGR_ENTITA", entity.getProgrEntita());
		paramMap.put("COD_ENTITA", entity.getCodEntita());
		paramMap.put("PROGR_DATI", entity.getProgrDati());
		paramMap.put("DATI_ENTITA", entity.getDatiEntita());
		paramMap.put("TIPO_AGGIORNAMENTO", entity.getTipoAggiornamento());
		paramMap.put("COD_OPE_ULT_MODIF", entity.getCodOpeUltModif());
		paramMap.put("DATA_INSER",timestamp);
		paramMap.put("DT_ULT_MODIFICA",timestamp);
		paramMap.put("CURRENT_DATE", now);

		updateRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.info("END insertEntita");
	}

}
