package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.transformers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.INHEADER;
import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.INPBST;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;

@Service
public class T1SJCtgRequestTrasformer implements ICtgRequestTransformer<InputStampaDTO, C_T1SJS00> {
	
	@Autowired
	private BeanFactory beanFactory;

	@Override
	public CtgConnectorRequest<C_T1SJS00> transform(InputStampaDTO inputStampaDTO, Object... args) {
		C_T1SJS00 connector = beanFactory.getBean(C_T1SJS00.class);

		connector.INHEADER = new INHEADER[1];
		connector.INHEADER[0] = new INHEADER();

		connector.INHEADER[0].COD_ABI = "";
		connector.INHEADER[0].COD_BSM = "";
		connector.INHEADER[0].COD_RICH_CANALE = "";
		connector.INHEADER[0].COD_CLI_RICH = "";
		connector.INHEADER[0].COD_OPERATIVITA = "";
		connector.INHEADER[0].COD_RIC_TRAC = "";
		connector.INHEADER[0].RETCODE = 0;

		connector.INHEADER[0].CODICESTATO = "0010";
		connector.INHEADER[0].ID_SERVIZIO = "FL030FLA01";
		connector.INHEADER[0].CODICE_TIPO_CANALE = "EX";
		connector.INHEADER[0].CODICE_SOCIETA = "01";
		connector.INHEADER[0].CODICE_SPORTELLO = "00700";
		connector.INHEADER[0].CODICE_UO_RICH = "00700";
		connector.INHEADER[0].CODICE_USERID = "U292442";
		connector.INHEADER[0].MQM_NAME_DEST = " "; // fixed value
		connector.INHEADER[0].COD_RIS_RICH = " ";// fixed value
		connector.INHEADER[0].COD_RICH_CANALE = " ";// fixed value
		connector.INHEADER[0].DATA_CONT = new SimpleDateFormat("ddMMyyyy").format(new Date());
		connector.INHEADER[0].LUNGHEZZA_MSG = 751;
		connector.INHEADER[0].IND_MQ_SINCRONO = "S";
		connector.INHEADER[0].COD_TIPO_LINGUA = "I";
		connector.INHEADER[0].TIPO_SIC_APPL_INP = "00";
		connector.INHEADER[0].TIPO_SIC_APPL_OUT = "00";
		connector.INHEADER[0].IND_COMPRESS_INP = "N";
		connector.INHEADER[0].IND_COMPRESS_OUT = "N";
		connector.INHEADER[0].IND_ROUTING_MSG = "N";
		connector.INHEADER[0].COD_SSA_SERVIZIO = " "; // fixed value
		connector.INHEADER[0].IND_INOLTRO_REPLY = "S";
		connector.INHEADER[0].COD_ABI = "01025";
		connector.INHEADER[0].COD_AZIENDA_DEST = " "; // fixed value
		connector.INHEADER[0].COD_OPERATIVITA = " "; // fixed value
		connector.INHEADER[0].FLAG_PAPERLESS = " "; // fixed value
		connector.INHEADER[0].FLAG_RACF = " "; // fixed value
		connector.INHEADER[0].COD_RIC_TRAC = "";
		connector.INHEADER[0].COD_BSM = " "; // fixed value
		connector.INHEADER[0].SIC_TIMESTAMP = " "; // fixed value
		connector.INHEADER[0].SIC_MAC = " "; // fixed value
		connector.INHEADER[0].SIC_KEY = " "; // fixed value
		connector.INHEADER[0].COD_VERS_SIC = " "; // fixed value
		connector.INHEADER[0].COD_CLI_RICH = " "; // fixed value
		connector.INHEADER[0].COD_TERM_CICS = " "; // fixed value
		connector.INHEADER[0].COD_VERSIONE_BS = "00";

		connector.INPBST = new INPBST[1];
		connector.INPBST[0] = new INPBST();// input.getBody();

		CtgConnectorRequest<C_T1SJS00> ctgConnectorRequest = new CtgConnectorRequest<>();
		ctgConnectorRequest.setConnectorClient(connector);

		return ctgConnectorRequest;
	}

}
