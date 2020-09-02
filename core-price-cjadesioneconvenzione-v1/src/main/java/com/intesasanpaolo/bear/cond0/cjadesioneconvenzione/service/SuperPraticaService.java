package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.mapper.LetturaRRowMapper;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.exception.CJConvenzioneNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.AdesioneConvenzione;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class SuperPraticaService extends BaseService {

	@Autowired
	private MultiDataSourceDb2Connector<String, Void, String> convRifMultiDataSourceConnector;

	@Autowired
	private MultiDataSourceDb2Connector<Void, Void, Void> updateRifMultiDataSourceConnector;

	
	/**
	 * Inserisce adesione a convenzione in una unica transazione
	 * 
	 * 
	 * @param adesioneConvenzione
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void inserisciAdesioneConvenzione(AdesioneConvenzione adesioneConvenzione) {
		//cancellazioni
		this.deleteEntita(adesioneConvenzione.getCodAbi(), adesioneConvenzione.getCodSuperPratica(),adesioneConvenzione.getCodPratica(), "00003");
		this.deleteEntita(adesioneConvenzione.getCodAbi(), adesioneConvenzione.getCodSuperPratica(),adesioneConvenzione.getCodPratica(), "00004");
		this.deleteEntita(adesioneConvenzione.getCodAbi(), adesioneConvenzione.getCodSuperPratica(),adesioneConvenzione.getCodPratica(), "00005");
		this.deleteEntita(adesioneConvenzione.getCodAbi(), adesioneConvenzione.getCodSuperPratica(),adesioneConvenzione.getCodPratica(), "DTADE");
		
		adesioneConvenzione.getTb59r009List().forEach(tb->{
			insertEntita(adesioneConvenzione.getCodAbi(),tb);
		});
		
		
	}

	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String recuperaCodConvenzione(String codAbi, String codSuperPratica, String nrPratica) {
		logger.info("recuperaCodConvenzione codAbi {} codSuperPratica {} nrPratica {} START ",codAbi,codSuperPratica,nrPratica);
		//SUBSTR(COD_ENTITA, 1, 7)
		String query = "SELECT  SUBSTR(COD_ENTITA, 1, 7) COD_ENTITA FROM FIATT.TB59R009"
				+ " WHERE NR_SUPERPRATICA = :codSuperPratica" + " AND NR_PRATICA = :numeroPratica"
				+ " AND ID_ENTITA = '00001'";
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("numeroPratica", nrPratica);

		List<String> resultList = convRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:{}", resultList);
		
		//if (CollectionUtils.isEmpty(resultList)) {
		//	 throw CJConvenzioneNotFoundDB2Exception.builder().codSuperPratica(codSuperPratica).nrPratica(nrPratica).build();
		//}
		return CollectionUtils.isNotEmpty(resultList)?resultList.get(0):null;
	}

	private void deleteEntita(String codAbi, String codSuperPratica, String nrPratica, String idEntita) {
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

	private void insertEntita(String codAbi,TB59R009 entity) {
		logger.info("START insertEntita");

		String query = "INSERT INTO"
				+ " FIATT.TB59R009 (NR_SUPERPRATICA, NR_PRATICA, ID_ENTITA, STATO, PROGR_ENTITA, PROGR_DATI, COD_ENTITA, DATI_ENTITA, TIPO_AGGIORNAMENTO, COD_OPE_ULT_MODIF, DATA_INSER,DT_ULT_MODIFICA)"
				+ " VALUES(:NR_SUPERPRATICA, :NR_PRATICA, :ID_ENTITA, :STATO, :PROGR_ENTITA, :PROGR_DATI, :COD_ENTITA, :DATI_ENTITA, :TIPO_AGGIORNAMENTO, :COD_OPE_ULT_MODIF, :DATA_INSER, :DT_ULT_MODIFICA)";
//				+ "TIMESTAMP_FORMAT(:CURRENT_DATE,'YYYY-MM-DD HH24.MI.SS'), TIMESTAMP_FORMAT(:CURRENT_DATE,'YYYY-MM-DD HH24.MI.SS'))"; //FUNZIONE NON RICONOSCIUTA DA H2

		String now = DateUtils.dateToString(new Date(), "yyyy-MM-dd HH.mm.ss");
		
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
		paramMap.put("DATA_INSER",now);
		paramMap.put("DT_ULT_MODIFICA",now);
		paramMap.put("CURRENT_DATE", now);

		updateRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.info("END insertEntita");
	}
	

}
