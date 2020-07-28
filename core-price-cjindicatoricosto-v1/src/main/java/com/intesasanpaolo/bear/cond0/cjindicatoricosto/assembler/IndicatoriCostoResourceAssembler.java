package com.intesasanpaolo.bear.cond0.cjindicatoricosto.assembler;

import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller.CJIndicatoriCostoController;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCosto;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.core.assembler.BaseResourceAssemblerSupport;

@Component
public class IndicatoriCostoResourceAssembler
		extends BaseResourceAssemblerSupport<IndicatoriCosto, IndicatoriCostoResource> {

	public IndicatoriCostoResourceAssembler() {
		super(CJIndicatoriCostoController.class, IndicatoriCostoResource.class);
	}

	@Override
	public IndicatoriCostoResource toResource(IndicatoriCosto entity) {
		// TODO Auto-generated method stub
		return new IndicatoriCostoResource();
	}
}
