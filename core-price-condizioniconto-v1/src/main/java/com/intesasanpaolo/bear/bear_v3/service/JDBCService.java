package com.intesasanpaolo.bear.bear_v3.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.connector.jdbc.JDBCConnector;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.JDBCGenericConnector;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers.JDBCGenericRequestTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers.JDBCGenericRequestTransformer.GenericRequestConfig;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers.JDBCGenericRequestTransformer.ResultSetExtractorType;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers.JDBCGenericResponseTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers.JDBCRequestTransformer;
import com.intesasanpaolo.bear.bear_v3.connector.jdbc.transofrmers.JDBCResponseTransformer;
import com.intesasanpaolo.bear.bear_v3.dto.CondizioneDeroga;
import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class JDBCService extends BaseService{
	
	@Autowired
	private JDBCConnector jdbcCndConnector;
	
	@Autowired
	private JDBCRequestTransformer jdbcRequestTransformer;
	
	@Autowired
	private JDBCResponseTransformer jdbcResponseTransformer;

	@Autowired
	private JDBCGenericConnector jdbcIstConnector;
	
	@Autowired
	private JDBCGenericConnector jdbcStdConnector;

	@Autowired
	private JDBCGenericRequestTransformer jdbcIstRequestTransformer;
	
	@Autowired
	private JDBCGenericResponseTransformer jdbcIstResponseTransformer;
	
	@Autowired
	private JDBCGenericRequestTransformer jdbcStdRequestTransformer;
	
	@Autowired
	private JDBCGenericResponseTransformer jdbcStdResponseTransformer;

	public CondizioneDeroga getDatiCondizione(String cdCnd)  {
		CondizioneDeroga response = jdbcCndConnector.call("SELECT * FROM COND_OWN.T_PC_CONDIZIONE WHERE CD_CONDIZIONE = '"+cdCnd+"'", jdbcRequestTransformer, jdbcResponseTransformer, JDBCQueryType.FIND);
		return response;
	}

	public String getCdSTD(String cdCnd, String cdIstituto, String dataOp)  {
		// si crea la configurazione da dare in pasto al connector
		GenericRequestConfig config = jdbcIstRequestTransformer.createConfig();
		config.queryType = JDBCQueryType.FIND;
        config.extractorType = ResultSetExtractorType.ResultSet;
        config.parameters = new Object[] {cdCnd,cdIstituto,dataOp,dataOp};
        // si istanzia il ResultSetExtractor
        config.resultSetExtractor = new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String cod = "";
				if (rs.next()) {
					cod = rs.getString("codCodice");
	        	}
				return cod;
			}
		};
		String response = (String)jdbcStdConnector.call("SELECT COD_CODICE AS codCodice FROM COND_OWN.T_PC2_COND_LISTINO WHERE COD_CONDIZIONE = ? AND COD_ISTITUTO = ? AND " + 
				"DATA_DECORRENZA < TO_DATE(?, 'YYYYMMDD') AND " + 
				"DATA_DECADENZA > TO_DATE(?, 'YYYYMMDD')", jdbcStdRequestTransformer, jdbcStdResponseTransformer, config);
		return response;
	}

	public String getValSTD(String cdCnd, String cdIstituto, String dataOp)  {
		// si crea la configurazione da dare in pasto al connector
		GenericRequestConfig config = jdbcStdRequestTransformer.createConfig();
		config.queryType = JDBCQueryType.FIND;
        config.extractorType = ResultSetExtractorType.ResultSet;
        config.parameters = new Object[] {cdCnd,cdIstituto,dataOp,dataOp};
        // si istanzia il ResultSetExtractor
        config.resultSetExtractor = new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String val = "";
				if (rs.next()) {
					val = rs.getString("numValore");
	        	}
				return val;
			}
		};
		String response = (String)jdbcStdConnector.call("SELECT NUM_VALORE AS numValore FROM COND_OWN.T_PC2_COND_LISTINO WHERE COD_CONDIZIONE = ? AND COD_ISTITUTO = ? AND " + 
				"DATA_DECORRENZA < TO_DATE(?, 'YYYYMMDD') " + 
				"AND DATA_DECADENZA > TO_DATE(?, 'YYYYMMDD')", jdbcStdRequestTransformer, jdbcStdResponseTransformer, config);
		return response;
	}
	
	public String getIstitutoFromAbi(String cdAbi) {
		// si crea la configurazione da dare in pasto al connector
		GenericRequestConfig config = jdbcIstRequestTransformer.createConfig();
		config.queryType = JDBCQueryType.FIND;
        config.extractorType = ResultSetExtractorType.ResultSet;
        config.parameters = new Object[] {cdAbi};
        // si istanzia il ResultSetExtractor
        config.resultSetExtractor = new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String codIstituto = "";
				if (rs.next()) {
					codIstituto = rs.getString("codiceIstituto");
	        	}
				return codIstituto;
			}
		};
		// si chiama il connector JDBC per recuperare il codice istituto
		String response = (String)jdbcIstConnector.call("SELECT COD_ISTITUTO AS codiceIstituto FROM COND_OWN.T_PC2_ANAG_ISTITUTI WHERE COD_ABI = ?", jdbcIstRequestTransformer, jdbcIstResponseTransformer, config);
		return response;		
	}
	
	public HashMap<String,String> getEtichette(HashMap<String,String> values){
		// si crea la configurazione da dare in pasto al connector
		GenericRequestConfig config = jdbcStdRequestTransformer.createConfig();
		config.queryType = JDBCQueryType.FIND;
        config.extractorType = ResultSetExtractorType.ResultSet;
        config.parameters = new Object[] {};
        // si istanzia il ResultSetExtractor
        config.resultSetExtractor = new ResultSetExtractor<HashMap<String,String>>() {
			@Override
			public HashMap<String,String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				HashMap<String, String> map = new HashMap<String, String>();
				String cnd = "";
				String etichetta = "";
				while (rs.next()) {
					cnd = rs.getString("codCnd");
					etichetta = rs.getString("codEtichetta");
					map.put(cnd, etichetta);
	        	}
				return map;
			}
		};
		HashMap<String,String> response = (HashMap<String,String>)jdbcStdConnector.call("SELECT CD_CND AS codCnd, CD_ETICHETTA AS codEtichetta" + 
				"		FROM COND_OWN.T_CP_PROD_CND " + 
				"	    WHERE CD_PROD = '"+ values.get("cdProd") + "'" +
				"	    AND (CD_DRIVER_1 = '" + values.get("cdDriver1") + "' OR CD_DRIVER_1 = '*' OR CD_DRIVER_1 IS NULL) " + 
				"	    AND (CD_DRIVER_2 = '" + values.get("cdDriver2") + "' OR CD_DRIVER_2 = '*' OR CD_DRIVER_2 IS NULL)" + 
				"	    AND (CD_DRIVER_3 = '" + values.get("cdDriver3") + "' OR CD_DRIVER_3 = '*' OR CD_DRIVER_3 IS NULL)" + 
				"	    AND (CD_DRIVER_4 = '" + values.get("cdDriver4") + "' OR CD_DRIVER_4 = '*' OR CD_DRIVER_4 IS NULL)" + 
				"	    AND (CD_DRIVER_5 = '" + values.get("cdDriver5") + "' OR CD_DRIVER_5 = '*' OR CD_DRIVER_5 IS NULL)" + 
				"	    AND (CD_DRIVER_6 = '" + values.get("cdDriver6") + "' OR CD_DRIVER_6 = '*' OR CD_DRIVER_6 IS NULL)" + 
				"	    AND (CD_DRIVER_7 = '" + values.get("cdDriver7") + "' OR CD_DRIVER_7 = '*' OR CD_DRIVER_7 IS NULL)" + 
				"	    AND (CD_DRIVER_8 = '" + values.get("cdDriver8") + "' OR CD_DRIVER_8 = '*' OR CD_DRIVER_8 IS NULL)" + 
				"	    AND (CD_DRIVER_9 = '" + values.get("cdDriver9") + "' OR CD_DRIVER_9 = '*' OR CD_DRIVER_9 IS NULL)" + 
				"	    AND (CD_DRIVER_10 = '" + values.get("cdDriver10") + "' OR CD_DRIVER_10 = '*' OR CD_DRIVER_10 IS NULL)" + 
				"	    AND FL_ELIMINATO = 'N'", jdbcStdRequestTransformer, jdbcStdResponseTransformer, config);
		return response;
	}
}
