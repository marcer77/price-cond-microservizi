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
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;
import static com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil.*;


@Service
public class SuperPraticaService extends BaseService{

	@Autowired
	private MultiDataSourceDb2Connector<String, Void, String> convRifMultiDataSourceConnector;
	 
	@Autowired
	private MultiDataSourceDb2Connector<Void, Void, Void> updateRifMultiDataSourceConnector;
	
	public List<String> recuperaCodConvenzione(String codAbi, String codSuperPratica,String nrPratica){
		logger.info("START recuperaCodConvenzione");

		String query = "SELECT DISTINCT" + 
				" COD_ENTITA " + 
				" FROM FIATT.TB59R009" + 
				" WHERE NR_SUPERPRATICA = :codSuperPratica" +
				" AND NR_PRATICA = :numeroPratica" +
				" AND ID_ENTITA = '00001'";


		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("numeroPratica", nrPratica);
		
		List<String> resultList = convRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
		logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return resultList;
	}
	
	
	//@Transactional
	public void deleteEntita(String codAbi, String codSuperPratica,String nrPratica,String idEntita) {
		logger.info("START deleteEntita");

		String query = "DELETE" +
				" FROM FIATT.TB59R009" + 
				" WHERE NR_SUPERPRATICA = :codSuperPratica" +
				" AND NR_PRATICA = :numeroPratica" +
				" AND ID_ENTITA = :idEntita";


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
	public void insertEntita(String codAbi, String codSuperPratica,String numeroPratica,String idEntita, String stato, int progrEntita, int progDati,String codEntita, String datiEntita, String tipoAggiornamento, String codOpeUltModif) {
		logger.info("START insertEntita");

		String query = "INSERT" + 
					  " INTO" + 
					  " FIATT.TB59R009 (NR_SUPERPRATICA, NR_PRATICA, ID_ENTITA, STATO, PROGR_ENTITA, PROGR_DATI, COD_ENTITA, DATI_ENTITA, TIPO_AGGIORNAMENTO, COD_OPE_ULT_MODIF, DATA_INSER,DT_ULT_MODIFICA)" + 
					  " VALUES(:NR_SUPERPRATICA, :NR_PRATICA, :ID_ENTITA, :STATO, :PROGR_ENTITA, :PROGR_DATI, :COD_ENTITA, :DATI_ENTITA, :TIPO_AGGIORNAMENTO, :COD_OPE_ULT_MODIF, TIMESTAMP_FORMAT(:CURRENT_DATE,'YYYY-MM-DD HH24.MI.SS'), TIMESTAMP_FORMAT(:CURRENT_DATE,'YYYY-MM-DD HH24.MI.SS'))" ;


		String now  = dateToString(new Date(), "yyyy-MM-dd HH.mm.ss");
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("NR_SUPERPRATICA", codSuperPratica);
		paramMap.put("NR_PRATICA", numeroPratica);
		paramMap.put("ID_ENTITA", idEntita);
		paramMap.put("STATO", stato);
		paramMap.put("PROGR_ENTITA", progrEntita);
		paramMap.put("COD_ENTITA", codEntita);
		paramMap.put("PROGR_DATI", progDati);
		paramMap.put("DATI_ENTITA", datiEntita);
		paramMap.put("TIPO_AGGIORNAMENTO", tipoAggiornamento);
		paramMap.put("COD_OPE_ULT_MODIF", codOpeUltModif);
		
		paramMap.put("CURRENT_DATE", now);
		
		updateRifMultiDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
		
		logger.info("END insertEntita");
	}

	public void salvaInfoCovenantAndBenefici() {
		// TODO Auto-generated method stub
		
	}
	

}
