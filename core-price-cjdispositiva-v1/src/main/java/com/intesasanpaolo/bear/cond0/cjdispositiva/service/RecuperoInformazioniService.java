package com.intesasanpaolo.bear.cond0.cjdispositiva.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.PraticaDTO;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.service.BaseService;

@Service
public class RecuperoInformazioniService extends BaseService {

	private Logger log = Logger.getLogger(RecuperoInformazioniService.class);

	public InformazioniPraticaDTO recuperaInformazioni(PraticaDTO praticaDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		log.info(" - recuperaInformazioni START");
		log.info(" - recuperaInformazioni END");
		return new InformazioniPraticaDTO();
	}

	public boolean registrazioneCodFittizie() {
		log.info(" - registrazioneCodFittizie START");
		log.info(" - registrazioneCodFittizie END");
		return true;
	}
	
	public boolean aggiornaCodFittizie() {
		log.info(" - aggiornaCodFittizie START");
		log.info(" - aggiornaCodFittizie END");
		return true;
	}
}
