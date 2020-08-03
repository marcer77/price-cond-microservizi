package com.intesasanpaolo.bear.cond0.cjindicatoricosto.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
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
		List<IndicatoriCostoPratica> indicatoriCostoPraticaList = new ArrayList<>();
		IndicatoriCosto indicatoriCosto = IndicatoriCosto.builder()
				.indicatoriCostoPraticaList(indicatoriCostoPraticaList).build();

		// Recupero informazioni superpratica (elenco pratiche)
		String abi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		List<String> pratiche = superPraticaService.recuperaPraticheBySuperPratica(abi,dto.getPratica().getCodSuperPratica());
		
		log.debug("pratiche recuperate da DB2 per superPratica={}: {}", dto.getPratica().getCodSuperPratica(),
				pratiche);

		pratiche.forEach(pa -> {
			IndicatoriCostoPratica indicatoriCostoPratica =IndicatoriCostoPratica.builder().build();
			indicatoriCostoPratica.setPratica(pa);
			indicatoriCostoPraticaList.add(indicatoriCostoPratica);
		});

		if (TipoRichiestaEnum.CALCOLA_E_CONTROLLA.toString().equals(dto.getRichiesta())) {
			for (IndicatoriCostoPratica indPratica : indicatoriCostoPraticaList) {
				WKCJResponse wkcjResponse = callWKCJ(indPratica.getPratica());
				indPratica.setWkcjResponse(wkcjResponse);
			}
		}

		long count = indicatoriCostoPraticaList.stream()
				.filter(ele->ele.getWkcjResponse()!=null)
				.filter(ele -> CollectionUtils.isNotEmpty(ele.getWkcjResponse().getOutCNFList())).count();
		boolean checkPresenzaCondizioniVariate = count > 0;

		if (!checkPresenzaCondizioniVariate) {
			// invocazione PCUJ
			for (IndicatoriCostoPratica indPratica : indicatoriCostoPraticaList) {
				PCUJResponse pcujResponse = callPCUJ(indPratica.getPratica());
				indPratica.setPcujResponse(pcujResponse);
			}
		}
		
		//TODO:
		indicatoriCosto.setCodErrore("");
		indicatoriCosto.setDescErrore("");
		
		
		return indicatoriCosto;
	}

	private WKCJResponse callWKCJ(String pratica) throws Exception {
		WKCJRequest wkcjRequest = WKCJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType)
				.pratica(pratica).superpratica(dto.getPratica().getCodSuperPratica()).tipoChiamata("A4").build();

		WKCJResponse wkcjResponse = wkcjServiceBS.callBS(wkcjRequest);
		return wkcjResponse;
	}

	private PCUJResponse callPCUJ(String pratica) throws Exception {
		PCUJRequest pcujRequest = 
				PCUJRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.nrSuperpratica(Integer.valueOf(dto.getPratica().getCodSuperPratica()))
				.nrPratica(Integer.valueOf(pratica))
				.codEvento(dto.getEvento().getCodice())
				.subEvento(dto.getEvento().getSubCodice())
				.classificCliente(dto.getClassificazione())
				.tipoFunzione("A4")
				.build();
		
		PCUJResponse pcujResponse = pcujServiceBS.callBS(pcujRequest);

		return pcujResponse;
	}

	/*
	 * @FunctionalInterface public interface FunctionWithException<T, R, E extends
	 * Exception> {
	 * 
	 * R apply(T t) throws E; }
	 */
	/*static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
			  ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
			 
			    return i -> {
			        try {
			            throwingConsumer.accept(i);
			        } catch (Exception ex) {
			            try {
			                E exCast = exceptionClass.cast(ex);
			                System.err.println(
			                  "Exception occured : " + exCast.getMessage());
			            } catch (ClassCastException ccEx) {
			                throw new RuntimeException(ex);
			            }
			        }
			    };
			}*/

}
