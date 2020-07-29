package com.intesasanpaolo.bear.cond0.cjindicatoricosto.command;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCosto;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutCNF;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.SuperPraticaService;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg.PCUJServiceBS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg.WKCJServiceBS;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IndicatoriCostoCommand extends BaseCommand<IndicatoriCosto> {

	private Logger log = LoggerUtils.getLogger(IndicatoriCostoCommand.class);

	@Autowired
	private SuperPraticaService superPraticaService;

	@Autowired
	private WKCJServiceBS wkcjServiceBS;

	@Autowired
	private PCUJServiceBS pcujServiceBS;

	private IndicatoriCostoDTO dto;
	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	public IndicatoriCostoCommand(IndicatoriCostoDTO indicatoriCostoDTO,
			ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = indicatoriCostoDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;
		esitoControlli = dto != null && ispWebservicesHeaderType != null;
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	@Override
	protected IndicatoriCosto doExecute() throws Exception {
		
		// Recupero informazioni superpratica (elenco pratiche)
		String abi =ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		List<String> pratiche = superPraticaService.recuperaPraticheBySuperPratica(abi, dto.getPratica().getCodSuperPratica());
		//List<String> pratiche=new ArrayList<String>();
		//pratiche.add("2323");
		// invocazione WKCJ
		for (String pratica:pratiche) {
			
			WKCJRequest wkcjRequest = WKCJRequest.builder()
					.ispWebservicesHeaderType(ispWebservicesHeaderType)
					.pratica(pratica)
					.superpratica(dto.getPratica().getCodSuperPratica())
					.tipoChiamata("A4")
					.build();
			
			WKCJResponse wkcjResponse = wkcjServiceBS.callBS(wkcjRequest);
			//TODO:POPOLARE CONDIZIONI VARIATE
			//List<OutCNF> condizioniVariate=wkcjResponse.getOutCNFList();
		}

		for (String pratica:pratiche) {
			PCUJRequest pcujRequest = PCUJRequest.builder()
					.ispWebservicesHeaderType(ispWebservicesHeaderType)
					.nrSuperpratica(Integer.valueOf(dto.getPratica().getCodSuperPratica()))
					.nrPratica(Integer.valueOf(pratica))
					.build();

			PCUJResponse pcujResponse = pcujServiceBS.callBS(pcujRequest);
			//TODO:POPOLARE AFFIDAMENTI
			//pcujResponse.getOutRIPList().get(0).getOutTasList().get(0).;
		}
		
		//
		IndicatoriCosto indicatoriCosto = new IndicatoriCosto();
		// TODO: costruire il modello di ritorno
		return indicatoriCosto;
	}

}
