package com.intesasanpaolo.bear.cond0.cjvariazionicons.assembler;

import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.controller.CJVariazioniController;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.StampaResponse;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.StampaResponseResource;
import com.intesasanpaolo.bear.core.assembler.BaseResourceAssemblerSupport;

@Component
public class StampaResponseResourceAssembler extends BaseResourceAssemblerSupport<StampaResponse, StampaResponseResource>{

	public StampaResponseResourceAssembler() {
		super(CJVariazioniController.class, StampaResponseResource.class);
	}

	@Override
	public StampaResponseResource toResource(StampaResponse entity) {
		StampaResponseResource stampaResponseResource=new StampaResponseResource();
		stampaResponseResource.setDocumento(entity.getDocumento());
		stampaResponseResource.setKeyOper(entity.getKeyOper());
		stampaResponseResource.setEsitoStampaResource(new EsitoStampaResource());
		stampaResponseResource.getEsitoStampaResource().setCodErrore(entity.getEsitoStampa().getCodErrore());
		stampaResponseResource.getEsitoStampaResource().setDescErrore(entity.getEsitoStampa().getDescErrore()	);
		
		return stampaResponseResource;
	}

}
