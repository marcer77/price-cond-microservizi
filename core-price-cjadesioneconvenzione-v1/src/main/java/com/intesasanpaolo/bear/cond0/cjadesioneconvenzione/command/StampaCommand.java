package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.ResponseResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.T1SJServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StampaCommand extends BaseCommand<ResponseResource>{

	@Autowired
	private T1SJServiceBS t1sjServiceBS;
	
	
	private InputStampaDTO inputStampaDTO;

	
	public StampaCommand(InputStampaDTO inputStampaDTO) {
		super();
		this.inputStampaDTO = inputStampaDTO;
	}


	@Override
	public ResponseResource execute() throws Exception {
		return t1sjServiceBS.test(inputStampaDTO);
	}
	
	
	

}
