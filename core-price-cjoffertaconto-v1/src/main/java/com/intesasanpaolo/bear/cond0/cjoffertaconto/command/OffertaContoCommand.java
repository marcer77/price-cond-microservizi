package com.intesasanpaolo.bear.cond0.cjoffertaconto.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.InputEsponiDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsponiResponseResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.OffertaResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ProdottoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ValoriOffertaResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ValoriProdottoResource;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OffertaContoCommand extends BaseCommand<EsponiResponseResource> {

	private Logger log = Logger.getLogger(OffertaContoCommand.class);


	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	private InputEsponiDTO dto;
	
	public OffertaContoCommand(InputEsponiDTO inputEsponiDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = inputEsponiDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		log.info("canExecute END");
		return true;
	}

	@Override
	protected EsponiResponseResource doExecute() {
		log.info("doExecute START");
		log.info("doExecute END");
		//MOCK
		return getMockResponse();
	}

	//MOCK
	private EsponiResponseResource getMockResponse() {
		
		EsponiResponseResource response =new EsponiResponseResource();
		
		response.setEsito(new EsitoResource("00", ""));
		
		List<ValoriOffertaResource> valori = new ArrayList<>();
		valori.add(ValoriOffertaResource.builder().costo("13.34582")
				.costoListino("14.034522")
				.decorrenza("20200901")
				.scadenza("20210303")
				.flAgevolato("S")
				.build());
		
		valori.add(ValoriOffertaResource.builder().costo("13.34582")
				.costoListino("15.034522")
				.decorrenza("20200901")
				.scadenza("20210303")
				.flAgevolato("N")
				.build());
		
		OffertaResource offerta = OffertaResource.builder().codice("OFFH99C").valori(valori).build();
		response.setOfferta(offerta);
		
		List<ProdottoResource> prodotti = new ArrayList<>();
		
		List<ValoriProdottoResource> valoriProdotto = new ArrayList<>();
		
		valoriProdotto.add(ValoriProdottoResource.builder()
				.costo("16.034532")
				.costoPromo("15")
				.decorrenza("20201005")
				.scadenza("20201120")
				.flAcceso("N")
				.flPromo("S")
				.build());
		
		valoriProdotto.add(ValoriProdottoResource.builder()
				.costo("11.034532")
				.costoPromo("10")
				.decorrenza("20201005")
				.scadenza("20201120")
				.flAcceso("S")
				.flPromo("S")
				.build());
		
		prodotti.add(ProdottoResource.builder().codice("PRNH99C")
				.descrizione("XMESALUTE")
				.prodotti(valoriProdotto)
				.build());
		
		prodotti.add(ProdottoResource.builder().codice("PRNH94C")
				.descrizione("XMESALUTE-FAMILY")
				.prodotti(valoriProdotto)
				.build());
		
		
		
		response.setProdotti(prodotti);
		
		return response;
		
	}

}
