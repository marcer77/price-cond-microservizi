package com.intesasanpaolo.bear.cond0.cjdispositiva.dto;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.AnagraficaPropostaCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.DatiCliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformazioniPraticaDTO {

	private AnagraficaPropostaCJPOS anagraficaPropostaCJPOS;
	private DatiCliente datiCliente;
	private PraticaDTO praticaDTO;
}
