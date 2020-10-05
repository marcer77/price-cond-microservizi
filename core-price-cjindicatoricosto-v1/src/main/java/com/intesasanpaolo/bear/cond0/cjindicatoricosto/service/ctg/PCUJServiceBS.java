package com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg;

import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.CJErrorUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.CTGConnectorPCUJ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgRequestTrasformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers.PCUJCtgResponseTansformer;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.oracle.GenericJdbcConnector;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.oracle.RequestTransformerFactory;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.jdbc.oracle.ResponseTransformerFactory;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutTAS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class PCUJServiceBS extends BaseService {
	private static final Logger logger = LoggerUtils.getLogger(PCUJServiceBS.class);

	@Autowired
	private CTGConnectorPCUJ ctgConnectorPCUJ;

	@Autowired
	private PCUJCtgRequestTrasformer requestTransformer;

	@Autowired
	private PCUJCtgResponseTansformer responseTransformer;

	@Autowired
	private GenericJdbcConnector<String, Void, String> genericJdbcConnector;

	public PCUJResponse callBS(PCUJRequest pcujRequest) {
		PCUJResponse pcujResponse = this.ctgConnectorPCUJ.call(pcujRequest, requestTransformer, responseTransformer, new Object());
		String[] parametriAggiuntivi = new String[0];
		CJErrorUtil.checkErrore(BSType.PCUJS00, pcujResponse.getOutEsi(), pcujResponse.getOutSeg(), this::additionalCheckErrorFunction, parametriAggiuntivi);

		pcujResponse.getOutRIPList().forEach(rip -> {
			OutTAS outTAS = rip.getOutTas();
			String codParametro = outTAS.getCodParametro();
			outTAS.setDescrizioneIndiceDB(getDescrizioneCondizione(codParametro));
		});
		return pcujResponse;

	}

	private boolean additionalCheckErrorFunction(String... st) {
		return false;
	}

	/**
	 * 
	 * Recupera dal database oracle COND0 la descrizione dell'indice
	 * 
	 * 
	 * @param codParametro
	 * @return
	 */
	public String getDescrizioneCondizione(String codParametro) {
		if(StringUtils.isNotEmpty(codParametro)) {
			Map<String, Object> paramMap = new TreeMap<>();
			paramMap.put("codParametro", codParametro);
			//codIstituto si può assumere sempre valorizzato a "01"
			paramMap.put("codIstituto", "01");

			StringWriter query = new StringWriter();

			query.append(" SELECT DES_CONDIZIONE FROM COND_OWN.T_PC2_ANAG_CONDIZIONI ");
			query.append(" WHERE COD_CONDIZIONE = SUBSTR(:codParametro, 1, 5) ");
			query.append(" AND COD_ISTITUTO= :codIstituto");

			logger.info("getDescrizioneCondizione query: {}", query.toString());
			List<String> result = genericJdbcConnector.call(query.toString(), RequestTransformerFactory.of(new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("DES_CONDIZIONE");
				}
			}, JDBCQueryType.FIND), ResponseTransformerFactory.of(), paramMap);

			return !result.isEmpty() ? result.get(0) : "";
		}else {
			return "";
		}
	}
	
}
