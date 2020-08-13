package com.intesasanpaolo.bear.cond0.cjindicatoricosto.assembler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJGenericBusinessApplication;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.command.IndicatoriCostoCommand;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.controller.CJIndicatoriCostoController;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.IndicatoriCosto;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.OutRIP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj.PCUJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutCNF;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.AffidamentoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.CondizioneResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.ParametriResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.PraticaResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.RapportoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.TanResource;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.core.assembler.BaseResourceAssemblerSupport;

@Component
public class IndicatoriCostoResourceAssembler
		extends BaseResourceAssemblerSupport<IndicatoriCosto, IndicatoriCostoResource> {
	
	private Logger log = LoggerUtils.getLogger(IndicatoriCostoCommand.class);

	public IndicatoriCostoResourceAssembler() {
		super(CJIndicatoriCostoController.class, IndicatoriCostoResource.class);
	}

	@Override
	public IndicatoriCostoResource toResource(IndicatoriCosto entity) {
		EsitoResource esitoResource = new EsitoResource();
		esitoResource.setCodErrore(entity.getCodErrore());
		esitoResource.setDescErrore(entity.getDescErrore());

		List<PraticaResource> praticaList = new ArrayList<>();

		entity.getIndicatoriCostoPraticaList().forEach(ent -> {
			List<CondizioneResource> condizioni = new ArrayList<>();
			List<AffidamentoResource> affidamenti = new ArrayList<>();

			WKCJResponse wkcjResponse = ent.getWkcjResponse();

			// condizioni
			List<OutCNF> outCNFList = wkcjResponse != null ? wkcjResponse.getOutCNFList() : new ArrayList<>();
			outCNFList.forEach(cv -> {
				CondizioneResource cond = CondizioneResource.builder().codice(cv.getCodCnd()).build();
				condizioni.add(cond);
			});

			// affidamenti
			PCUJResponse pcujResponse = ent.getPcujResponse() != null ? ent.getPcujResponse() : new PCUJResponse();
			List<OutRIP> outRIPList = pcujResponse.getOutRIPList() != null ? pcujResponse.getOutRIPList()
					: new ArrayList<>();

			outRIPList.forEach(outRip -> {
				
				IndicatoriResource indicatoriResource = new IndicatoriResource();
				indicatoriResource.setTeg(ServiceUtil.formattaNumero(outRip.getValTeg()));
				indicatoriResource.setTaeg(ServiceUtil.formattaNumero(outRip.getValTaeg()));
				indicatoriResource.setCdf(ServiceUtil.formattaNumero(outRip.getValCDF()));

				// TAN: la lista OutTasList conterrà al più un elemento
				// che servirà per valorizzare il campo composto TAN
				String valoreIndice=outRip.getOutTas().getSegnoValParametro();
				valoreIndice=valoreIndice+ServiceUtil.formattaNumero(outRip.getOutTas().getValParametro());
				
				ParametriResource parametriResource = ParametriResource.builder()
						.percApplic(ServiceUtil.formattaNumero(outRip.getOutTas().getPercParametro()))
						.valoreSpread(ServiceUtil.formattaNumero(outRip.getOutTas().getValSpread()))
						.segnoSpread(outRip.getOutTas().getSegnoValSpread())
						.descIndice(outRip.getOutTas().getDescrizioneIndiceDB())
						 .valoreIndice(valoreIndice)
						.build();
				
				TanResource tanResource = TanResource.builder().flUsura(outRip.getOutTas().getFlUsura())
						.valore(ServiceUtil.formattaNumero(outRip.getOutTas().getTassoDebitore())).parametri(parametriResource)
						.build();

					
				indicatoriResource.setTan(tanResource);
				
				RapportoResource rapporto=RapportoResource.builder()
						.categoria(outRip.getCodCatRapRip())
						.numero(outRip.getNumProgRappRip())
						.filiale(outRip.getCodFilRappRip())
						.build();
				
				//per la data SCADENZA in output al microservizio il formato è GG.MM.AAAA, invece il formato della data della BS è
				//DATA_SCADENZA_FIDO  è AAAAMMGG
				String dataScadenza=null;
				try {
					String dateConverted=DateUtils.convertiDate(outRip.getDataScadenzaFido(),DateUtils.DATE_FORMAT_YYYY_MM_DD ,DateUtils.DATE_FORMAT_DD_MM_YYYY_DOTS);
					dataScadenza=StringUtils.isNoneEmpty(dateConverted)?dateConverted:" .  .   ";				
				} catch (ParseException e) {
					throw new CJGenericBusinessApplication(CommonErrorCode.GENERIC_EXCEPTION,e.getMessage());
				}
				
				AffidamentoResource aff = AffidamentoResource.builder()
						.formaTecnica(outRip.getCodFt())
						.importo(ServiceUtil.formattaNumero(outRip.getImportoFido(),"#########"))
						.importoEUR(ServiceUtil.formattaNumero(outRip.getImportoFidoEur(),"#########"))
						.scadenza(dataScadenza)
						.tipoFTecnica(outRip.getTipoFt())
						.descFTecnica(outRip.getDescrFt())
						.divisa(outRip.getDivisaFido())
						.rapporto(rapporto)
						.indicatori(indicatoriResource).build();

				affidamenti.add(aff);

			});

			PraticaResource praticaResource = PraticaResource.builder().codPratica(ent.getPratica())
					.affidamenti(affidamenti).condizioni(condizioni).build();

			praticaList.add(praticaResource);

		});
		//
		IndicatoriCostoResource indicatoriCostoResource = IndicatoriCostoResource.builder().esito(esitoResource)
				.pratica(praticaList).build();
		return indicatoriCostoResource;
	}

}
