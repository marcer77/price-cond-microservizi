package com.intesasanpaolo.bear.cond0.cjindicatoricosto.command;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.dto.IndicatoriCostoDTO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.TipoRichiestaEnum;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums.WarningResult;
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
		/*boolean esitoControlli = false;
		esitoControlli = dto != null && !StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("- canExecute END - " + esitoControlli);*/
		
		return true;
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

		// invocazione WKCJ
		if (TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString().equals(dto.getRichiesta())) {

			indicatoriCostoPraticaList.forEach(indPratica -> {
				WKCJResponse wkcjResponse = callWKCJ(indPratica.getPratica());
				indPratica.setWkcjResponse(wkcjResponse);
			});

		}
		// invocazione PCUJ
		indicatoriCostoPraticaList.forEach(indPratica -> {
			PCUJResponse pcujResponse = callPCUJ(indPratica.getPratica());
			// recupero dati da database
			indPratica.setPcujResponse(pcujResponse);
		});

		
		//gestione warning
		WarningResult warningResult=null;
		// gestione gerarchia WARNING
		// check sul ritorno della WKCJ
		List<IndicatoriCostoPratica> wkcjWarningList = indicatoriCostoPraticaList.stream().filter(ele -> ele.getWkcjResponse() != null)
				.filter(ele -> CollectionUtils.isNotEmpty(ele.getWkcjResponse().getOutCNFList())).collect(Collectors.toList());

		if (CollectionUtils.isNotEmpty(wkcjWarningList)) {		
			warningResult = new WarningResult("01",null,"Warning - rilevate differenze in fase di controllo",40);			
		} else {		
			List<IndicatoriCostoPratica> pcujWarningList = indicatoriCostoPraticaList.stream()
					.filter(ele -> !"00".equals(ele.getPcujResponse().getCodEsito()))
					.collect(Collectors.toList());
						 
			warningResult= pcujWarningList.stream().map(ele->{
				String codEsito=ele.getPcujResponse().getCodEsito();
				String msgEsito=ele.getPcujResponse().getMsgEsito();
				
				WarningResult result=null;
				switch (codEsito) {
				case "01":
					result = new WarningResult(codEsito,msgEsito,"Warning - presenti variazioni condizioni economiche",30);				
					break;
				case "02":
					result = new WarningResult(codEsito,ele.getPcujResponse().getMsgEsito(),"Warning - presenti variazioni TEG",20);
					break;
				case "03":
					result =new WarningResult(codEsito,ele.getPcujResponse().getMsgEsito(),"Warning - presenti variazioni TAEG",10);
					break;
				default:
					result =new WarningResult(codEsito,ele.getPcujResponse().getMsgEsito(),"Warning generico",1);
				}
				
				return result;
			}).sorted().findFirst().orElse(null);
		}
		// solo per debug stampo gli esiti delle BS per tutte le pratiche:
		/*returnMessage.append("\n\n\n\nRisposta BS WKCJ per pratica:");
		indicatoriCostoPraticaList.forEach(indicatoriCostoPratica -> {
			returnMessage.append(" [ ");
			returnMessage.append(" Pratica:" + indicatoriCostoPratica.getPratica()).append(" Condizioni Variate: ");
			indicatoriCostoPratica.getWkcjResponse().getOutCNFList().forEach(cnd -> returnMessage.append("-").append(cnd.getCodCnd()).append(" - "));
			returnMessage.append(" ]");
		});
		returnMessage.append("Risposta BS PCUJ per pratica:");
		indicatoriCostoPraticaList.forEach(indicatoriCostoPratica -> {
			returnMessage.append(" [ ");
			returnMessage.append(" -Pratica:" + indicatoriCostoPratica.getPratica()).append(" [ ");
			returnMessage.append(" -CodEsito: " + indicatoriCostoPratica.getPcujResponse().getCodEsito());
			returnMessage.append(" -MsgEsito: " + indicatoriCostoPratica.getPcujResponse().getMsgEsito());
			returnMessage.append(" ] --- ");
		});*/
		////////////////////////////////////////
		
		if (warningResult!=null) {
			indicatoriCosto.setCodErrore(warningResult.getCodeBS());
			indicatoriCosto.setDescErrore(warningResult.getDescrizione().concat(warningResult.getMsgBS()!=null?warningResult.getMsgBS():""));
	
		}else {
			indicatoriCosto.setCodErrore("00");
			indicatoriCosto.setDescErrore("");
		}
		
		return indicatoriCosto;
	}

	private WKCJResponse callWKCJ(String pratica) {
		WKCJRequest wkcjRequest = WKCJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType).pratica(pratica)
				.superpratica(dto.getPratica().getCodSuperPratica()).utente(ispWebservicesHeaderType.getOperatorInfo().getUserID()).tipoChiamata("A4")
				.dataRifer(DateUtils.dateToString(new Date(), "yyyyMMdd")).lingua("I").build();

		return wkcjServiceBS.callBS(wkcjRequest);
	}

	private PCUJResponse callPCUJ(String pratica) {

		PCUJRequest pcujRequest = PCUJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType).tipoFunzione(dto.getRichiesta())
				.codEvento(dto.getEvento().getCodice()).subEvento(dto.getEvento().getSubCodice()).classificCliente(dto.getClassificazione())
				.dataRiferimento(DateUtils.dateToString(new Date(), "yyyyMMdd")).codUtente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.filialeOper(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				.nrSuperpratica(dto.getPratica().getCodSuperPratica()).nrPratica(pratica).build();

		return pcujServiceBS.callBS(pcujRequest);
	}

}
