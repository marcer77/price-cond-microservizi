package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.factory;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitiAdesione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitoAdesione;

@Component
public class RequisitiAdesioneFactory {
	
	private Logger log = Logger.getLogger(RequisitiAdesioneFactory.class);
	
	public RequisitiAdesione createRequisitiAdesione() {
		
		// mockup
		List<RequisitoAdesione> listaRequisiti = new ArrayList<>();
		
		RequisitoAdesione req1 = RequisitoAdesione.builder()
				.flRequisito("OK")
				.cdRequisito("30")
				.dsRequisito("Famiglia merceologica")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("COMMERCIANTI")
				.build();
									
		RequisitoAdesione req2 = RequisitoAdesione.builder()
				.flRequisito("OK")
				.cdRequisito("31")
				.dsRequisito("Rating")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("0202")
				.build();
		
		RequisitoAdesione req3 = RequisitoAdesione.builder()
				.flRequisito("OK")
				.cdRequisito("32")
				.dsRequisito("Tipo portafoglio")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("03")
				.build();
		
		RequisitoAdesione req4 = RequisitoAdesione.builder()
				.flRequisito("OK")
				.cdRequisito("33")
				.dsRequisito("Data accensione")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("D20200101-")
				.build();					
		
		listaRequisiti.add(req1);
		listaRequisiti.add(req2);
		listaRequisiti.add(req3);
		listaRequisiti.add(req4);
		
		return RequisitiAdesione.builder()			
				.cdEsito("OK")
				.dsErrore("")
				.nrRequisiti(4l)
				.listaRequisiti(listaRequisiti)
				.build();
		
	}
}
