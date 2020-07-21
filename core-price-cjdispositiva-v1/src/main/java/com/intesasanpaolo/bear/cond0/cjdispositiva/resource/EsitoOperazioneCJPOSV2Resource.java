package com.intesasanpaolo.bear.cond0.cjdispositiva.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsitoOperazioneCJPOSV2Resource {

	protected String codiceProposta;
	protected String esitoCodice;
	protected String esitoMessaggio;
	protected String faseIter;
	protected String statoIter;
	protected String esitoIter;
	
}
