package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.RequisitiAdesione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.RequisitiAdesioneResponseResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.RequisitoResource;
import com.intesasanpaolo.bear.core.assembler.BaseResourceAssemblerSupport;

public class RequisitiAdesioneResponseResourceAssembler extends BaseResourceAssemblerSupport<RequisitiAdesione, RequisitiAdesioneResponseResource> {
	 
	public RequisitiAdesioneResponseResourceAssembler(Class<?> controllerClass,
                                    Class<RequisitiAdesioneResponseResource> resourceType) {
        super(controllerClass, resourceType);
    }
 
    @Override
    public RequisitiAdesioneResponseResource toResource(RequisitiAdesione offerte) {    	
    	
    	List<RequisitoResource> listaRequisiti = offerte.getListaRequisiti().stream()
    		.map(requisito -> {
    			RequisitoResource requisitoResource = new RequisitoResource();
    			requisitoResource.setFlRequisito(requisito.getFlRequisito());
    			requisitoResource.setCdRequisito(requisito.getCdRequisito());
    			requisitoResource.setDsRequisito(requisito.getDsRequisito());
    			requisitoResource.setValNumericoRequisito(requisito.getValNumericoRequisito());
    			requisitoResource.setValAlfanumericoRequisito(requisito.getValAlfanumericoRequisito());
    			return requisitoResource;
    		})
    		.collect(Collectors.toList());
    	
    	return RequisitiAdesioneResponseResource.builder()
    		.cdEsito(offerte.getCdEsito())
    		.dsErrore(offerte.getDsErrore())
    		.nrRequisiti(offerte.getNrRequisiti())
    		.listaRequisiti(listaRequisiti)
    		.build();
    	
    }
	
}
