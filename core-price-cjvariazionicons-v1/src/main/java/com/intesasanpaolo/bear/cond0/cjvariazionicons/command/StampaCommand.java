package com.intesasanpaolo.bear.cond0.cjvariazionicons.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.ResponseResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.service.FL03ServiceBS;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.service.T1SFServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StampaCommand extends BaseCommand<ResponseResource>{

	@Autowired
	private T1SFServiceBS  t1sfServiceBS;
	
	@Autowired
	private FL03ServiceBS fL03ServiceBS;
	
	private InputStampaDTO inputStampaDTO;

	
	public StampaCommand(InputStampaDTO inputStampaDTO) {
		super();
		this.inputStampaDTO = inputStampaDTO;
	}


	@Override
	public ResponseResource execute() throws Exception {
		return t1sfServiceBS.test(inputStampaDTO);
	}
	
	
	

}
