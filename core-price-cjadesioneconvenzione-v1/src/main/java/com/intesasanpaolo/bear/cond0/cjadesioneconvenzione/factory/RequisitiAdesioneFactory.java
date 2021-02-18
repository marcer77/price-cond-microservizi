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
				.cdRequisito("01")
				.dsRequisito("Tipo Portafoglio")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("03")
				.build();
									
		RequisitoAdesione req2 = RequisitoAdesione.builder()
				.flRequisito("OK")
				.cdRequisito("02")
				.dsRequisito("Portafoglio")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("6")
				.build();
		
		RequisitoAdesione req3 = RequisitoAdesione.builder()
				.flRequisito("OK")
				.cdRequisito("03")
				.dsRequisito("Rating")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("21")
				.build();
		
		RequisitoAdesione req4 = RequisitoAdesione.builder()
				.flRequisito("WA")
				.cdRequisito("06")
				.dsRequisito("Data validità documento")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito(null)
				.build();					

		RequisitoAdesione req5 = RequisitoAdesione.builder()
				.flRequisito("ND")
				.cdRequisito("07")
				.dsRequisito("Accredito dello stipendio")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito(null)
				.build();					

		RequisitoAdesione req6 = RequisitoAdesione.builder()
				.flRequisito("WA")
				.cdRequisito("22")
				.dsRequisito("Requisito generico")
				.valNumericoRequisito("")
				.valAlfanumericoRequisito("Start up innovative*cliente non presente in lista Imprese iscritte alla sezione speciale per Start Up Innovative del R.I*")
				.build();					

		listaRequisiti.add(req1);
		listaRequisiti.add(req2);
		listaRequisiti.add(req3);
		listaRequisiti.add(req4);
		listaRequisiti.add(req5);
		listaRequisiti.add(req6);
		
		return RequisitiAdesione.builder()			
				.cdEsito("OK")
				.dsErrore("")
				.nrRequisiti(4l)
				.listaRequisiti(listaRequisiti)
				.build();
		
	}
}
