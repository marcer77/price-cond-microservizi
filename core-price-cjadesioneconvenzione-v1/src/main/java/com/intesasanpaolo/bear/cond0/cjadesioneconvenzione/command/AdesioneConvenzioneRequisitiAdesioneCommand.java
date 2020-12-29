package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.command;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.assembler.RequisitiAdesioneResponseResourceAssembler;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitiAdesione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.RequisitiAdesioneResponseResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.RequisitiAdesioneService;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdesioneConvenzioneRequisitiAdesioneCommand extends BaseCommand<RequisitiAdesioneResponseResource> {

	private Logger log = Logger.getLogger(AdesioneConvenzioneRequisitiAdesioneCommand.class);

	private RequisitiAdesioneResponseResourceAssembler requisitiAssembler = new RequisitiAdesioneResponseResourceAssembler(
			RequisitiAdesione.class, RequisitiAdesioneResponseResource.class);

	
	@Autowired
	private RequisitiAdesioneService requisitiAdesioneService;
	
	public AdesioneConvenzioneRequisitiAdesioneCommand() {
		super();
	}

	@Override
	public boolean canExecute() {
		log.debug("canExecute START");
		
		// mockup canExecute
		
		log.debug("canExecute END");
		return true;
	}

	@Override
	protected RequisitiAdesioneResponseResource doExecute() {
		log.debug("doExecute START");
				
		RequisitiAdesione requisitiAdesione = requisitiAdesioneService.getRequisitiAdesione();
				
		log.debug("doExecute END");
        return requisitiAssembler.toResource(requisitiAdesione);
	}

}
