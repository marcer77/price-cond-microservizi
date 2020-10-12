package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TestRollbackCommand extends BaseCommand<EsitoResponseResource> {

	@Override
	public boolean canExecute() {
		return true;
	}


	@Override
	protected EsitoResponseResource doExecute() throws Exception{
		
		for(int i=0;i<5;i++) {
			final String opera = "OP" + i;
			callInTransaction(()->operation(opera),()->rollback(opera));
		}
		return null;

	}

	private Integer operation(String operazione) {
		if(!operazione.endsWith("4")) {
		System.out.println("Operazione: " + operazione);
		}else {
			throw new RuntimeException("Problemi");
		}
		return 1;
	}

	private Integer rollback(String operazione) {
		System.out.println("RollBack: " + operazione);
		return 1;

	}
}
