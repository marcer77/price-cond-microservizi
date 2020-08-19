package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.MultiDataSourceDb2Connector;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperAdesione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperCovenant;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.mapper.RowMapperString;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.transformers.RequestDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.transformers.ResponseDb2TransformerFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.Covenant;
import com.intesasanpaolo.bear.connector.db2.DB2QueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class CoreConvenzioneService extends BaseService {

	@Autowired
	private MultiDataSourceDb2Connector<AdesioneEntity, Void, AdesioneEntity> convRifMultiDataSourceConnector;

	@Autowired
	private MultiDataSourceDb2Connector<CovenantEntity, Void, CovenantEntity> convenantDataSourceConnector;

	@Autowired
	private MultiDataSourceDb2Connector<String, Void, String> genericStringDataSourceConnector;

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

		List<AdesioneEntity> resultList = convRifMultiDataSourceConnector.call(query,
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

		List<CovenantEntity> resultList = convenantDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperCovenant(), DB2QueryType.FIND),
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

	public List<String> getLivelloGerarchia(String codAbi, String codConvenzione) {
		logger.info("START getLivelloGerarchia codAbi: {} codConvenzione:{}",codAbi,codConvenzione);
//		String query = "SELECT (CASE COND_GER WHEN '' THEN '0' ELSE LIV_GER END) AS livGerarchia  FROM FIATT.TB01R007 WHERE COD_CONDIZIONE = :covCodCondizione CONCAT '000';";
		String query = "SELECT 1 AS livGerarchia  FROM FIATT.TB01R007 WHERE COD_CONDIZIONE = :covCodCondizione ;";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("covCodCondizione", codConvenzione);

		List<String> resultList = genericStringDataSourceConnector.call(query,
				RequestDb2TransformerFactory.of(new RowMapperString("livGerarchia"), DB2QueryType.FIND),
				ResponseDb2TransformerFactory.of(), paramMap, codAbi);

		logger.debug("Founded:", resultList);

		logger.info("END getLivelloGerarchia");
		return resultList;
	}

	public List<String> getCondizioniFiglie(String codAbi, String codConvenzione) {
		logger.info("START getCondizioniFiglie");
		String query = 
				  "WITH                                                            "
				+ " MAMME(MAMMA, FIGLIA_MIN) "
				+ "    AS ( SELECT COND_GER                                        "
				+ "              , MIN(COD_CONDIZIONE)                             "
				+ "           FROM FIATT.TB01R007                                  "
				+ "          WHERE COND_GER = :covCodCondizione       CONCAT '000' "
				+ "            AND LIV_GER  = '2'                                  "
				+ "          GROUP BY COND_GER                                     "
				+ "       )                                                        "
				+ " , GERARCHIE(GER, RIF, P, ELENCO)                                "
				+ "    AS ( SELECT MAMMA                                           "
				+ "              , FIGLIA_MIN                                      "
				+ "              , 1                                               "
				+ "              , CAST(SUBSTR(FIGLIA_MIN,1,5) AS VARCHAR(1000))   "
				+ "           FROM MAMME                                           "
				+ "         UNION ALL                                              "
				+ "         SELECT COND_GER                                        "
				+ "              , COD_CONDIZIONE                                  "
				+ "              , P + 1                                           "
				+ "              , CAST(ELENCO CONCAT ';'                          "
				+ "                      CONCAT SUBSTR(COD_CONDIZIONE,1,5)         "
				+ "                  AS VARCHAR(1000))                             "
				+ "           FROM GERARCHIE                                       "
				+ "              , FIATT.TB01R007                                  "
				+ "          WHERE P < 100                                         "
				+ "            AND COND_GER = GER                                  "
				+ "            AND COD_CONDIZIONE =                                "
				+ "                ( SELECT MIN(COD_CONDIZIONE)                    "
				+ "                    FROM FIATT.TB01R007                         "
				+ "                   WHERE COND_GER = GER                         "
				+ "                     AND LIV_GER = '2'                          "
				+ "                     AND COD_CONDIZIONE  > RIF)                 "
				+ "      )                                                         "
				+ " , ELENCO_GER(GER,ELENCO)                                       "
				+ "    AS ( SELECT GER                                             "
				+ "              , MAX(ELENCO)                                     "
				+ "           FROM GERARCHIE                                       "
				+ "          GROUP BY GER )                                        "
				+ " SELECT ELENCO "
				+ " FROM ELENCO_GER; ";

		Map<String, Object> paramMap = new TreeMap<>();
		paramMap.put("covCodCondizione", codConvenzione);

		List<String> resultList = genericStringDataSourceConnector.call(query,
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

}
