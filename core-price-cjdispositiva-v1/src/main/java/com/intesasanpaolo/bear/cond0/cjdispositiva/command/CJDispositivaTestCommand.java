package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaTestCommand extends BaseCommand<String> {

	private Logger log = Logger.getLogger(CJDispositivaTestCommand.class);
	
	private int a = 0;
	private String message;

	@Override
	protected String doExecute() throws Exception{
		
		message = callInTransaction(()->add1(3),(x)->add1Rollback(message,-3));
		callInTransaction(()->add2(6));
	    System.out.println("messaggio esterno " + message);
		return "pippo";
	}
	
	private String add1(int value) {
		System.out.println("add1:" + value);
		this.a+=value;
		return "add1";
		
	}
	
	
	private String add1Rollback(String message,int value) {
		System.out.println("add1:" + value + " message:" + message);
		this.a+=value;
		return "add1";
		
	}
	
	
	private String add2(int value)  {
		System.out.println("add2:" + value);
		this.a+=value;
		if (true )throw new RuntimeException ("pippo Baudo è capellone");
		return "add2";
		
	}
	
	
	
	@Override
	public boolean canExecute() {
		return true;
	}
	

	
}
