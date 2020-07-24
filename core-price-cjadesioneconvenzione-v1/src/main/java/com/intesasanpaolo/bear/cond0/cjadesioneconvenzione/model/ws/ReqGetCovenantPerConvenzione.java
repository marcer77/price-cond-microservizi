package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqGetCovenantPerConvenzione {
	
	private String abi;
	private String applicativoId;
	private String codConvenzione;
	private String dataDiNascita;
	private String dataAdesione;
	private String filialeUserId;
	private String idProdottoCovenant;
	private String rapportoAbi;
	private String rapportoCategoria;
	private String rapportoConto;
	private String rapportoFiliale;
	private String userId;

}
