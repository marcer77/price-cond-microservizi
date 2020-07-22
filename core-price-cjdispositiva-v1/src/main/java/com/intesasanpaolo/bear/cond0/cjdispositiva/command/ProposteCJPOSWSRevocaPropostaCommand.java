package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProposteCJPOSWSRevocaPropostaCommand extends BaseCommand<EsitoResource> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSRevocaPropostaCommand.class);

	private ISPWebservicesHeaderType header = new ISPWebservicesHeaderType();
	private DispositivaRequestDTO dispositivaRequestDTO;
	private RevocaProposta revocaProposta;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Override
	public EsitoResource execute() throws Exception {
		log.info("- execute START");
		if (canExecute()) {
			log.info("- execute OK");
			EsitoResource esitoResource = new EsitoResource();
			revocaProposta = ProposteCJPOSWSUtils._buildMockRevocaProposta();
			EsitoOperazioneCJPOSV2 esito = proposteCJPOSWSService.revocaProposta(revocaProposta, header);
			esitoResource.setCodErrore(esito.getEsitoCodice());
			esitoResource.setDescErrore(esito.getEsitoMessaggio());
			
			return esitoResource;
		} else {
			log.info("- execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;
		esitoControlli = dispositivaRequestDTO != null && header != null;
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	public void setHeader(ISPWebservicesHeaderType header) {
		this.header = header;
	}

	public void setDispositivaRequestDTO(DispositivaRequestDTO dispositivaRequestDTO) {
		this.dispositivaRequestDTO = dispositivaRequestDTO;
	}

}
