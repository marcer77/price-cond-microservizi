package com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class ReqStoreCovenantAdesioneConvenzione {

	private String abi;
	private String applicativoId;
	private String codiceConvenzione;
	private String codiceConvenzioneOld;
	private String dataProposta;
	private String dataOperazione;
	private String filialeUserId;
	private String idProdottoCovenant;
	private List<Covenant> listaCovenantDaAttivare; 
	private List<Covenant> listaCovenantDaCessare; 
	private String nsg;
	private String numeroProposta;
	private String tipoOperazione;
	private String userId;

}
