package com.intesasanpaolo.bear.cond0.cjindicatoricosto.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
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
import com.intesasanpaolo.bear.core.assembler.BaseResourceAssemblerSupport;

@Component
public class IndicatoriCostoResourceAssembler
		extends BaseResourceAssemblerSupport<IndicatoriCosto, IndicatoriCostoResource> {

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
					: new ArrayList<OutRIP>();

			outRIPList.forEach(outRip -> {
				IndicatoriResource indicatoriResource = new IndicatoriResource();

				indicatoriResource.setTeg(ServiceUtil.formattaNumero(outRip.getValTeg()));
				indicatoriResource.setTaeg(ServiceUtil.formattaNumero(outRip.getValTaeg()));
				indicatoriResource.setCdf(ServiceUtil.formattaNumero(outRip.getValCDF()));

				// TAN: la lista OutTasList conterrà al più un elemento
				// che servirà per valorizzare il campo composto TAN
				outRip.getOutTasList().forEach(tas -> {

					ParametriResource parametriResource = ParametriResource.builder()
							.valoreIndice(ServiceUtil.formattaNumero(tas.getValParametro()))
							.percApplic(ServiceUtil.formattaNumero(tas.getPercParametro()))
							.valoreSpread(ServiceUtil.formattaNumero(tas.getValSpread()))
							.segnoSpread(tas.getSegnoValSpread()).descIndice(tas.getCodParametro()).build();

					TanResource tanResource = TanResource.builder().flUsura(tas.getFlUsura())
							.valore(ServiceUtil.formattaNumero(tas.getTassoDebitore())).parametri(parametriResource)
							.build();

					indicatoriResource.setTan(tanResource);
				});

				RapportoResource rapporto=RapportoResource.builder()
						.categoria(outRip.getCodCatRapRip())
						.numero(outRip.getNumProgRappRip())
						.filiale(outRip.getCodFilRappRip())
						.build();
				
				AffidamentoResource aff = AffidamentoResource.builder()
						.formaTecnica(outRip.getCodFt())
						.importo(ServiceUtil.formattaNumero(outRip.getImportoFidoEur()))
						.scadenza(outRip.getDataScadenzaFido())
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

	private void buildIndicatori() {

	}
}
