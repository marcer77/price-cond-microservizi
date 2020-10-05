package com.intesasanpaolo.bear.cond0.cjdispositiva.dto.ws.pcgestxme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GestioneDTO {

	private String tipoFunzione; //	PCK8-I-TIPO-FUNZIONE  input.codProcesso
	private String nrSuperPratica;//	PCK8-I-NR-SUPERPRATICA  input.codSuperPratica
	private String nrPratica;//	PCK8-I-NR-PRATICA  input.codPratica
	private String codFilRappAcc;//	PCK8-I-COD-FIL-RAPP-ACC  tab.Filiale
	private String categoria;//	PCK8-I-COD-CAT-RAPP-ACC  tab.Categoria
	private String conto;//	PCK8-I-NUM-PROG-RAPP-ACC  tab.Conto
	
}
