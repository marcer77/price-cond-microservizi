package com.intesasanpaolo.bear.cond0.cjindicatoricosto.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.TipoRichiestaEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCosto;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCostoPratica;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJRequest;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
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

	public IndicatoriCostoCommand(IndicatoriCostoDTO indicatoriCostoDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = indicatoriCostoDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;
		esitoControlli = dto != null && !StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode()) && !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId()) && !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	@Override
	protected IndicatoriCosto doExecute() throws Exception {
		List<IndicatoriCostoPratica> indicatoriCostoPraticaList = new ArrayList<>();

		IndicatoriCosto indicatoriCosto = IndicatoriCosto.builder().indicatoriCostoPraticaList(indicatoriCostoPraticaList).build();

		// Recupero informazioni superpratica (elenco pratiche)
		String abi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		List<String> pratiche = superPraticaService.recuperaPraticheBySuperPratica(abi, dto.getPratica().getCodSuperPratica());

		log.debug("pratiche recuperate da DB2 per superPratica={}: {}", dto.getPratica().getCodSuperPratica(), pratiche);
		log.debug("Tipo richiesta: {}", dto.getRichiesta());

		log.debug("Pratiche trovate {} in DB2:", pratiche.size());

		pratiche.forEach(pa -> {
			IndicatoriCostoPratica indicatoriCostoPratica = new IndicatoriCostoPratica();
			indicatoriCostoPratica.setPratica(pa);
			indicatoriCostoPraticaList.add(indicatoriCostoPratica);
		});
		if (TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString().equals(dto.getRichiesta())) {

			indicatoriCostoPraticaList.forEach((indPratica) -> {
				WKCJResponse wkcjResponse = callWKCJ(indPratica.getPratica());
				indPratica.setWkcjResponse(wkcjResponse);
			});

		}
		indicatoriCostoPraticaList.forEach((indPratica) -> {
			PCUJResponse pcujResponse = callPCUJ(indPratica.getPratica());
			indPratica.setPcujResponse(pcujResponse);
		});

		// TODO:
		indicatoriCosto.setCodErrore("00");
		indicatoriCosto.setDescErrore("");

		return indicatoriCosto;
	}

	private WKCJResponse callWKCJ(String pratica) {
		WKCJRequest wkcjRequest = WKCJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType).pratica(pratica).superpratica(dto.getPratica().getCodSuperPratica())
				.utente(ispWebservicesHeaderType.getOperatorInfo().getUserID()).tipoChiamata("A4").dataRifer(ServiceUtil.dateToString(new Date(), "yyyyMMdd")).lingua("I").build();

		WKCJResponse wkcjResponse = wkcjServiceBS.callBS(wkcjRequest);
		return wkcjResponse;
	}

	private PCUJResponse callPCUJ(String pratica) {

		PCUJRequest pcujRequest = PCUJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType)
				.tipoFunzione(dto.getRichiesta())
				.codEvento(dto.getEvento().getCodice())
				.subEvento(dto.getEvento().getSubCodice())
				.classificCliente(dto.getClassificazione())
				.dataRiferimento(ServiceUtil.dateToString(new Date(), "yyyyMMdd"))
				.codUtente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.filialeOper(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				.nrSuperpratica(dto.getPratica().getCodSuperPratica())
				.nrPratica(pratica)
				.build();
		
		PCUJResponse pcujResponse = pcujServiceBS.callBS(pcujRequest);

		return pcujResponse;
	}

}
