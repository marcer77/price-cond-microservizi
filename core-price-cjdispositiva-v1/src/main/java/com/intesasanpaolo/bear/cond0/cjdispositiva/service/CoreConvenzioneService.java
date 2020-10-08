package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperAdesione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperCovenantDaCessare;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperDatiIntestatarioTrasparenza;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperRapporto;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperString;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperTasso;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.DatiIntestatarioTrasparenza;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class CoreConvenzioneService extends BaseService {

	@Autowired
	private MultiDataSourceDb2Connector selectDataSourceConnector;

	@Autowired
	private MultiDataSourceDb2Connector<Void, Void, Void> updateRifMultiDataSourceConnector;

	public List<AdesioneEntity> acquisizioneDatiAdesione(String codAbi, String codPratica, String codSuperPratica) {
		logger.info("START acquisizioneDatiAdesione");
		String query = "SELECT substr(COD_ENTITA ,  1,  7 ) AS \"codConvenzione\""
				+ "     , substr(DATI_ENTITA,  1, 13 ) AS \"intestatarioNDG\""
				+ "     , substr(DATI_ENTITA, 14, 70 ) AS \"intestatazione\""
				+ "     , substr(DATI_ENTITA, 84,  5 ) AS \"intestatarioSpecieGiur\""
				+ "     , substr(DATI_ENTITA, 89, 16 ) AS \"intestatarioCodFiscale\""
				+ "     , substr(DATI_ENTITA,105, 11 ) AS \"intestatarioPIVA\""
				+ "     , substr(DATI_ENTITA,116,  5 ) AS \"rapportoCodFiliale\""
				+ "     , substr(DATI_ENTITA,121,  4 ) AS \"rapportoCodCategoria\""
				+ "     , substr(DATI_ENTITA,125,  8 ) AS \"rapportoCodProgressivo\""
				+ "     , substr(DATI_ENTITA,133,  8 ) AS \"infoStampaData\""
				+ "     , substr(DATI_ENTITA,141, 30 ) AS \"infoStampakeyOper\"" + "  FROM FIATT.TB59R009"
				+ " WHERE NR_SUPERPRATICA = :codSuperPratica" + "   AND NR_PRATICA = :codPratica"
				+ "   AND ID_ENTITA = 'DTADE';";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);

		List<AdesioneEntity> resultList = (List<AdesioneEntity>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperAdesione(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);

		logger.info("END acquisizioneDatiAdesione");
		return resultList;
	}

	public List<CovenantEntity> getElencoCovenantDaAttivare(String codAbi, String codPratica, String codSuperPratica) {
		logger.info("START getElencoCovenantDaAttivare");
		String query = " SELECT  substr(DATI_ENTITA,  1, 5) AS covCodCondizione " 
				+ ", substr(DATI_ENTITA,  6, 8) AS covCodiceTemplate"
				+ ", substr(DATI_ENTITA,  14, 5) AS covVersioneTemplate " 
				+ ", TRIM(substr(DATI_ENTITA,  19, 8)) AS covDataInizio"
				+ ", TRIM(substr(DATI_ENTITA,  27, 8)) AS covDataFine" 
				+ ", substr(DATI_ENTITA,  35, 1) AS covBeneficioIngressoPresente"
				+ ", TRIM(substr(DATI_ENTITA,  36, 8)) AS covBeneficioIngressoDataInizio" 
				+ ", TRIM(substr(DATI_ENTITA,  44, 8)) AS covBeneficioIngressoDataFine"
				+ ", substr(DATI_ENTITA,  52, 1) AS covBeneficioIncondPresente" 
				+ ", TRIM(substr(DATI_ENTITA,  53, 8)) AS covBeneficioIncondDataInizio"
				+ ", TRIM(substr(DATI_ENTITA,  61, 8)) AS covBeneficioIncondDataFine" 
				+ ", substr(DATI_ENTITA,  69, 3) AS covBeneficioIncondNumRilev"
				+ ", TRIM(substr(DATI_ENTITA,  72, 8)) AS covBeneficioCondDataInizio" 
				+ ", TRIM(substr(DATI_ENTITA,  80, 8)) AS covBeneficioCondDataFine"
				+ ", substr(DATI_ENTITA,  88, 1) AS covFlagEventoEtaCliente"
				+ ", substr(DATI_ENTITA,  89, 1) AS covFlagEffettoRilevato" 
				+ "  FROM FIATT.TB59R009 "
				+ " WHERE NR_SUPERPRATICA = :codSuperPratica " + "   AND NR_PRATICA = :codPratica "
				+ "   AND ID_ENTITA  = '00003' " + "   AND STATO      = 'A' " + " ORDER BY PROGR_DATI;";
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);

		List<CovenantEntity> resultList = (List<CovenantEntity>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperCovenantDaAttivare(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		int numCov = 1;

		if (CollectionUtils.isNotEmpty(resultList)) {
			for (CovenantEntity covenant : resultList) {
				covenant.setProgressivo(numCov++);
			}
		}

		logger.debug("Founded:", resultList);

		logger.info("END getElencoCovenantDaAttivare");
		return resultList;
	}
	
	public List<CovenantEntity> getElencoCovenantDaCessare(String codAbi, String codPratica, String codSuperPratica) {
		logger.info("START getElencoCovenantDaCessare");
		String query = " SELECT substr(COD_ENTITA , 1, 5) AS covEstFilRapp" + 
				"      , substr(COD_ENTITA , 6, 4) AS covEstCatRapp" + 
				"      , substr(COD_ENTITA ,10, 8) AS covEstNumRapp" + 
				"      , substr(DATI_ENTITA, 1, 5) AS covEstCodCondizione" + 
				"      , substr(DATI_ENTITA, 6, 8) AS covEstCodiceTemplate" + 
				"      , substr(DATI_ENTITA,14, 5) AS covEstVersioneTemplate" + 
				"  FROM FIATT.TB59R009 " + 
				" WHERE NR_SUPERPRATICA = :codSuperPratica " + 
				"   AND NR_PRATICA = :codPratica " + 
				"   AND ID_ENTITA  = '00030';";
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);

		List<CovenantEntity> resultList = (List<CovenantEntity>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperCovenantDaCessare(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		int numCov = 1;

		if (CollectionUtils.isNotEmpty(resultList)) {
			for (CovenantEntity covenant : resultList) {
				covenant.setProgressivo(numCov++);
			}
		}

		logger.debug("Founded:", resultList);

		logger.info("END getElencoCovenantDaCessare");
		return resultList;
	}

	public List<String> getLivelloGerarchia(String codAbi, String codConvenzione) {
		logger.info("START getLivelloGerarchia codAbi: {} codConvenzione:{}",codAbi,codConvenzione);
		String query = "SELECT (CASE COND_GER WHEN '' THEN '0' ELSE LIV_GER END) AS livGerarchia  FROM FIATT.TB01R007 WHERE COD_CONDIZIONE = :covCodCondizione || '000';";
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("covCodCondizione", codConvenzione);

		List<String> resultList = (List<String>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperString("livGerarchia"), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);

		logger.info("END getLivelloGerarchia");
		return resultList;
	}

	public List<String> getCondizioniFiglie(String codAbi, String codConvenzione) {
		logger.info("START getCondizioniFiglie");
		String query = "WITH GERARCHIE(GER, RIF, P, ELENCO) AS ( " + 
				"SELECT " + 
				"    COND_GER , MIN(COD_CONDIZIONE), 1, CAST(SUBSTR(MIN(COD_CONDIZIONE), 1, 5) AS VARCHAR(1000)) " + 
				"FROM " + 
				"    FIATT.TB01R007 " + 
				"WHERE " + 
				"    COND_GER = :covCodCondizione || '000' " + 
				"    AND LIV_GER = '2' GROUP BY COND_GER " + 
				"UNION ALL " + 
				"SELECT " + 
				"    COND_GER , COD_CONDIZIONE , P + 1 , CAST(ELENCO || ';' || SUBSTR(COD_CONDIZIONE, 1, 5) AS VARCHAR(1000)) " + 
				"FROM " + 
				"    GERARCHIE , FIATT.TB01R007 " + 
				"WHERE " + 
				"    P < 100 " + 
				"    AND COND_GER = GER " + 
				"    AND COD_CONDIZIONE = ( " + 
				"    SELECT " + 
				"        MIN(COD_CONDIZIONE) " + 
				"    FROM " + 
				"        FIATT.TB01R007 " + 
				"    WHERE " + 
				"        COND_GER = GER " + 
				"        AND LIV_GER = '2' " + 
				"        AND COD_CONDIZIONE > RIF) ) " + 
				"SELECT MAX(ELENCO) AS ELENCO FROM  GERARCHIE ;";
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("covCodCondizione", codConvenzione);

		List<String> resultList = (List<String>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperString("ELENCO"), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);

		logger.info("END getCondizioniFiglie");
		return resultList;
	}

	@Transactional
	public int updateRConvenzioneDiRifiremento(String codAbi, String codConvenzionePc) {
		logger.info("START letturaRConvenzioneDiRifiremento");

		String query = "UPDATE FIATT.TB07R007 SET  DATA_DECA_COLL = CAST(TO_date('9999-11-30','YYYY-MM-DD') AS date) WHERE COD_CONVENZIONE_PC = :codConvenzionePc";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codConvenzionePc", codConvenzionePc);

		updateRifMultiDataSourceConnector.call(query, RequestDb2TransformerFactory.of(null, DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		// logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return 1;
	}

	public int insertRConvenzioneDiRifiremento(String codAbi, String codConvenzionePc) {
		logger.info("START letturaRConvenzioneDiRifiremento");

		String query = "INSERT INTO FIATT.TB07R007 (COD_CONVENZIONE_PC, COD_CONVENZIONE_RF, COD_FAMIGLIA, DATA_DECO_COLL, DATA_DECA_COLL) VALUES(:codConvenzionePc, '9000000', '    ', '1951-01-01', '9999-12-31')";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codConvenzionePc", codConvenzionePc);

		updateRifMultiDataSourceConnector.call(query, RequestDb2TransformerFactory.of(null, DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		// logger.debug("Founded:", resultList);

		logger.info("END letturaRConvenzioneDiRifiremento");
		return 1;
	}
	
	public int deleteCodiciProposte(String codAbi,String codSuperPratica,String codPratica) {
		logger.info("START deleteCodiciProposte");
		String query = "DELETE FROM FIATT.TB59R009"
				+ " WHERE NR_SUPERPRATICA = :codSuperPratica" + 
				"   AND NR_PRATICA = :codPratica" + 
				"   AND ID_ENTITA = 'PRUSU'" ;
				
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);
		
		updateRifMultiDataSourceConnector.call(query, RequestDb2TransformerFactory.of(null, DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);
		logger.info("END deleteCodiciProposte");
		return 1;
		
	}
	
	public List<PropostaEntity> getCodiciProposte(String codAbi,String codSuperPratica,String codPratica) {
		logger.info("START getCodiciProposte");
		String query = "SELECT SUBSTR(COD_ENTITA, 1, 4) as annoProposta " + 
				"     , SUBSTR(COD_ENTITA, 5, 7) as codiceProposta " + 
				"   FROM FIATT.TB59R009 " + 
				"   WHERE NR_SUPERPRATICA = :codSuperPratica" + 
				"   AND NR_PRATICA = :codPratica" + 
				"   AND ID_ENTITA = 'PRUSU'; ";
				
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);
		
		
		List<PropostaEntity> resultList = (List<PropostaEntity>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperProposta(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);
		
		logger.info("END getCodiciProposte");
		return resultList;
		
	}
	
	public List<RapportoEntity> getElencoRapportiConTassiAbbattuti(String codAbi,String codSuperPratica,String codPratica){
		logger.info("START getElencoRapportiConTassiAbbattuti");
		
		String query = "SELECT DISTINCT" + 
				" SUBSTR(COD_ENTITA,  1, 5)   	as FilRappTX" + 
				" , SUBSTR(COD_ENTITA,  6, 4)   as CatRappTX" + 
				" , SUBSTR(COD_ENTITA, 10, 8)	as NumRappTX" + 
				" FROM FIATT.TB59R009 T" + 
				" WHERE 1=1" + 
				" AND NR_SUPERPRATICA = :codSuperPratica" + 
				" AND NR_PRATICA = :codPratica" + 
				" AND ID_ENTITA  = '00012'" + 
				" AND STATO='C' ";
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);
		
		logger.info("END getElencoRapportiConTassiAbbattuti");
		
		return (List<RapportoEntity>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperRapporto(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

	}
	
	public List<TassoEntity> getElencoTassiAbbattuti(String codAbi,String codSuperPratica,String codPratica,RapportoEntity rapporto){
		logger.info("START getElencoTassiAbbattuti");
		
		String query = "   SELECT" + 
				"   SUBSTR(DATI_ENTITA,43,05) 	    AS codCondizioneTX 	" + 
				",  SUBSTR(DATI_ENTITA,51,08) 		AS decoCdzTX	    " + 
				",  SUBSTR(DATI_ENTITA,59,08) 		AS decaCdzTX		" + 
				",  SUBSTR(DATI_ENTITA,67,01) 		AS tipoValCdzTX		" + 
				",  CAST(SUBSTR(DATI_ENTITA, 68, 15) AS numeric(15,5) ) / 10000  AS valoreCdzTX " + 
				",  TRIM(SUBSTR(DATI_ENTITA, 84, 05)) AS cdParamTX " + 
				",  CAST(TRIM(SUBSTR(DATI_ENTITA, 93, 10)) || '.0' AS numeric(15,5)) / 100000 AS percApplParTX " + 
				",  SUBSTR(DATI_ENTITA, 111, 1) AS segnoSpreadTX " + 
				",  CAST(TRIM(SUBSTR(DATI_ENTITA, 113, 10))  || '.0' AS numeric(15,5))/ 100000 AS valoreSprdTX" + 
				",  SUBSTR(DATI_ENTITA, 141, 12) AS ATTRIBUTO_RP " +
				"  FROM FIATT.TB59R009 T WHERE NR_SUPERPRATICA = :codSuperPratica" + 
				"   AND NR_PRATICA = :codPratica" + 
				" AND ID_ENTITA  = '00012'" +
			    " AND STATO='C' " + 
				" AND COD_ENTITA = :idEntita" ;
		
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);
		paramMap.put("idEntita", rapporto.getFiliale()+rapporto.getCategoria()+rapporto.getNumero());
		
		logger.info("END getElencoTassiAbbattuti");
		return (List<TassoEntity>) selectDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperTasso(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);
	}
	@Transactional
	public int saveCodiceProposta(String codAbi,String codSuperPratica,String codPratica,String codiceProposta,String userId) {
		
		logger.info("START saveCodiceProposta");

		String query = "INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (" + 
				":codSuperPratica , :codPratica, 'PRUSU' , 'N' , 1 ,1, :codiceProposta, '', 'I', :userId, CURRENT TIMESTAMP,CURRENT TIMESTAMP)";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		paramMap.put("codPratica", codPratica);
		paramMap.put("codiceProposta", codiceProposta);
		paramMap.put("userId", userId);
		

		updateRifMultiDataSourceConnector.call(query, RequestDb2TransformerFactory.of(null, DB2QueryType.UPDATE),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);


		logger.info("END saveCodiceProposta");
		
		return 1;
	}
	
	
	
	public List<String> getElencoPratiche(String codAbi,String codProcesso, String codSuperPratica,String codPratica) {
		
		StringWriter sw=new StringWriter();
		sw.append(" SELECT DISTINCT NR_PRATICA NR_PRATICA FROM FIATT.TB59R009 ")
			.append(" WHERE ID_ENTITA  = '00002' ")
			.append(" and NR_SUPERPRATICA = :codSuperPratica");
		
		if (!CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)) {			
			sw.append(" and NR_PRATICA = :codPratica ");
		}
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);
		if (!CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)) {			
			paramMap.put("codPratica", codPratica);			
		}
		List<String> resultList = (List<String>) selectDataSourceConnector.call(sw.toString(),
				RequestDb2TransformerFactory.of(new RowMapperString("NR_PRATICA"), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);
	
		if (CollectionUtils.isEmpty(resultList)) {
			
			String msg=CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)?
					"Nessuna pratica per la superPratica {}":"Pratica {} non trovata per la superPratica {} ";
			
			String[] params=CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)?new String[] {codSuperPratica}:new String[] {codPratica,codSuperPratica};
			
			throw CJDispositivaNotFoundDB2Exception.builder().messaggio(msg)
				.param(params).build();
		
		}			
		return resultList;
	}
	
	public DatiIntestatarioTrasparenza getDatiIntestatarioPerTrasparenza(String codAbi,String codProcesso, String codSuperPratica,String codPratica) {		
		
		
		StringWriter sw=new StringWriter();
		sw.append(" SELECT MIN(substr(DATI_ENTITA,  1, 13 )) TrasparenzaNDG ");
		sw.append(" , MIN(substr(DATI_ENTITA,116,  5 )) TrasparenzaFiliale ");
		sw.append(" , MIN(substr(DATI_ENTITA,121,  4 )) TrasparenzaCategoria ");
		sw.append(" , MIN(substr(DATI_ENTITA,125,  8 )) TrasparenzaNumRapp ");
		sw.append(" , MIN(substr(DATI_ENTITA,133,  8 )) TrasparenzaDataRiferimento ");
		sw.append(" FROM FIATT.TB59R009 WHERE  ID_ENTITA = 'DTADE' ");
		sw.append(" and NR_SUPERPRATICA = :codSuperPratica ");
		if (!CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)) {			
			sw.append(" and NR_PRATICA = :codPratica ");
		}		
		sw.append("GROUP BY NR_SUPERPRATICA ");
		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("codSuperPratica", codSuperPratica);	
		if (!CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(codProcesso)) {
			paramMap.put("codPratica", codPratica);
		}
					
		List<DatiIntestatarioTrasparenza> resultList=(List<DatiIntestatarioTrasparenza>) selectDataSourceConnector.call(sw.toString(),
				RequestDb2TransformerFactory.of(new RowMapperDatiIntestatarioTrasparenza(), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);
	
	
		return CollectionUtils.isNotEmpty(resultList)?resultList.get(0):null;
		
	}
	
	
	
}
