package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.LetturaRRowMapper;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ConvRiferimento;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.DatiAdesione;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;




@Service
public class CoreConvenzioneService extends BaseService{

	 @Autowired
	 private MultiDataSourceDb2Connector<ConvRiferimento, Void, ConvRiferimento> convRifMultiDataSourceConnector;
	 
	 @Autowired
	 private MultiDataSourceDb2Connector<Void, Void, Void> updateRifMultiDataSourceConnector;

	 public List<DatiAdesione> acquisizioneDatiAdesione(String codAbi, String codPratica, String codSuperPratica, String codConvenzione) {
		logger.info("START acquisizioneDatiAdesione");
		String query = 
				"SELECT substr(COD_ENTITA ,  1,  7 ) AS \"codConvenzione\"" + 
				"     , substr(DATI_ENTITA,  1, 13 ) AS \"intestatarioNDG\"" + 
				"     , substr(DATI_ENTITA, 14, 70 ) AS \"intestatazione\"" + 
				"     , substr(DATI_ENTITA, 84,  5 ) AS \"intestatarioSpecieGiur\"" + 
				"     , substr(DATI_ENTITA, 89, 16 ) AS \"intestatarioCodFiscale\"" + 
				"     , substr(DATI_ENTITA,105, 11 ) AS \"intestatarioPIVA\"" + 
				"     , substr(DATI_ENTITA,116,  5 ) AS \"rapportoCodFiliale\"" + 
				"     , substr(DATI_ENTITA,121,  4 ) AS \"rapportoCodCategoria\"" + 
				"     , substr(DATI_ENTITA,125,  8 ) AS \"rapportoCodProgressivo\"" + 
				"     , substr(DATI_ENTITA,133,  8 ) AS \"infoStampaData\"" + 
				"     , substr(DATI_ENTITA,141, 30 ) AS \"infoStampakeyOper\"" + 
				"  FROM FIATT.TB59R009" + 
				" WHERE NR_SUPERPRATICA = :codSuperPratica" + 
				"   AND NR_PRATICA = :codPratica" + 
				"   AND ID_ENTITA = 'DTADE';";
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);

		//TODO
		List<DatiAdesione> resultList = null;
//		List<DatiAdesione> resultList = convRifMultiDataSourceConnector.call(query,
//  				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
//  				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
		logger.debug("Founded:", resultList);
		
		logger.info("END acquisizioneDatiAdesione");
		return resultList;
	 }
	 
	
	//Lettura R. convenzione di rifiremento
	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<ConvRiferimento> letturaRConvenzioneDiRifiremento(String codAbi, String codConvenzionePc, String dataRichiestaElaborazione){
		logger.info("START letturaRConvenzioneDiRifiremento");

		String query = "SELECT  COD_CONVENZIONE_RF as codConvenzioneRf " + 
				"FROM   FIATT.TB07R007 " + 
				"WHERE  COD_CONVENZIONE_PC = :codConvenzionePc " ;
//		+ 
//				"AND  DATA_DECO_COLL    < :dataRiferimento " + 
//				"AND  DATA_DECA_COLL    >= :dataRiferimento " + 
//				"AND  DATA_DECO_COLL    < DATA_DECA_COLL";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codConvenzionePc", codConvenzionePc);
		paramMap.put("dataRiferimento", dataRichiestaElaborazione);
  		
		List<ConvRiferimento> resultList = convRifMultiDataSourceConnector.call(query,
  				RequestDb2TransformerFactory.of(new LetturaRRowMapper(), DB2QueryType.FIND),
  				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
		logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return resultList;
	}
	@Transactional
	public int updateRConvenzioneDiRifiremento(String codAbi, String codConvenzionePc){
		logger.info("START letturaRConvenzioneDiRifiremento");

		String query = "UPDATE FIATT.TB07R007 SET  DATA_DECA_COLL = CAST(TO_date('9999-11-30','YYYY-MM-DD') AS date) WHERE COD_CONVENZIONE_PC = :codConvenzionePc" ;


		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codConvenzionePc", codConvenzionePc);

  		
		updateRifMultiDataSourceConnector.call(query,
  				RequestDb2TransformerFactory.of(null, DB2QueryType.UPDATE),
  				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
	//	logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return 1;
	}
	
	public int insertRConvenzioneDiRifiremento(String codAbi, String codConvenzionePc){
		logger.info("START letturaRConvenzioneDiRifiremento");

		String query = "INSERT INTO FIATT.TB07R007 (COD_CONVENZIONE_PC, COD_CONVENZIONE_RF, COD_FAMIGLIA, DATA_DECO_COLL, DATA_DECA_COLL) VALUES(:codConvenzionePc, '9000000', '    ', '1951-01-01', '9999-12-31')"; 


		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codConvenzionePc", codConvenzionePc);

  		
		updateRifMultiDataSourceConnector.call(query,
  				RequestDb2TransformerFactory.of(null, DB2QueryType.UPDATE),
  				ResponseDb2TransformerFactory.of(), paramMap, codAbi);	
		
	//	logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return 1;
	}


}
