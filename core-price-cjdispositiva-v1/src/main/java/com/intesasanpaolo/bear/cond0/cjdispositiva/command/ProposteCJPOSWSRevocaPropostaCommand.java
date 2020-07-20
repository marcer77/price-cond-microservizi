package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProposteCJPOSWSRevocaPropostaCommand extends BaseCommand<EsitoOperazioneCJPOSV2> {

	private Logger log = Logger.getLogger(ProposteCJPOSWSRevocaPropostaCommand.class);

	private ISPWebservicesHeaderType header = new ISPWebservicesHeaderType();
	private RevocaProposta revocaProposta = new RevocaProposta();

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Override
	public EsitoOperazioneCJPOSV2 execute() throws Exception {
		log.info("- execute START");
		if (canExecute()) {
			log.info("- execute OK");
			return proposteCJPOSWSService.revocaProposta(revocaProposta, header);
		} else {
			log.info("- execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;
		esitoControlli = revocaProposta != null;
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	public void setHeader(ISPWebservicesHeaderType header) {
		this.header = header;
	}

	public void setRevocaProposta(RevocaProposta revocaProposta) {
		this.revocaProposta = revocaProposta;
	}

}
