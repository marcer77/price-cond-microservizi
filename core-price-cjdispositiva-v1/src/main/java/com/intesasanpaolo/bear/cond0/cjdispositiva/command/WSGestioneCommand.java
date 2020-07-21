package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class WSGestioneCommand extends BaseCommand<NewAccountOutput> {
	private Logger log = Logger.getLogger(WSGestioneCommand.class);

	private HashMap<String, String> headerParams;
	private NewAccountInput newAccountInput;

	@Autowired
	private GestioneService gestioneService;

	@Override
	public NewAccountOutput execute() throws Exception {
		log.info("- execute START");
		if (canExecute()) {
			log.info("- execute OK");
			return gestioneService.gestione(newAccountInput, headerParams);
		} else {
			log.info("- execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;

		esitoControlli = (newAccountInput != null) && (headerParams!=null && headerParams.size()>0);
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	public void setHeaderParams(HashMap<String, String> headerParams) {
		this.headerParams = headerParams;
	}

	public void setNewAccountInput(NewAccountInput newAccountInput) {
		this.newAccountInput = newAccountInput;
	}
}
