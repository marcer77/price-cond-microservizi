package com.intesasanpaolo.bear.cond0.cjindicatoricosto.command;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCosto;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.SuperPraticaRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.SuperPraticaResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.SuperPraticaService;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg.PCUJServiceBS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.service.ctg.WKCJServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IndicatoriCostoCommand extends BaseCommand<IndicatoriCosto> {

	private Logger log = Logger.getLogger(IndicatoriCostoCommand.class);

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

		// invocazione WKCJ
		WKCJRequest wkcjRequest = WKCJRequest.builder().ambitoQ("").attribBpay("").catRapp("").catRappAppo("")
				.catRappBpay("").catSecRapAppo("").catSecRapp("").dataRifer("").dtDecoRapp("").filRapp("")
				.filRappAppo("").filRappBpay("").flBpay("").lingua("").ndg("").nroRapp("").nroRappAppo("")
				.nroRappBpay("").partitaRapp("").pratica("").settRapp("").settRappAppo("").superpratica("")
				.terminale("").tipoChiamata("").tipoStampa("").utente("")
				.ispWebservicesHeaderType(ispWebservicesHeaderType).build();

		WKCJResponse wkcjResponse = wkcjServiceBS.callBS(wkcjRequest);

		// invocazione PCUJ
		PCUJRequest pcujRequest = PCUJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType).build();

		PCUJResponse pcujResponse = pcujServiceBS.callBS(pcujRequest);

		//
		IndicatoriCosto indicatoriCosto = new IndicatoriCosto();
		// TODO: costruire il modello di ritorno
		return indicatoriCosto;
	}

}
