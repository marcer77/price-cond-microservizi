package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers;

import static com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil.withNoException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseAdesioneDettaglio;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBeneficioValoreParametrato;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.BloccoValore;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ConfigurazioneFasce;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.Fasce;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.Valore;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ValoreIndicatore;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ValoreParametrato;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ArrayOfAdesioneResponseAdesioneDettaglio;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ArrayOfAdesioneResponseBenefici;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.ArrayOfFasce;
import com.intesasanpaolo.connector.ws.gen.convenzioniservice.GetRequisitiAdesioneConvenzioneResponse;

@Service
public class GetRequisitiAdesioneConvenzioneResponseTrasformer implements
ISoapResponseTransformer<GetRequisitiAdesioneConvenzioneResponse, RespGetRequisitiAdesioneConvenzione> {

	@Override
	public RespGetRequisitiAdesioneConvenzione transform(
			SoapConnectorResponse<GetRequisitiAdesioneConvenzioneResponse> soapConnectorResponse) {
		return populateResponse(soapConnectorResponse.getResponse());
	}

	private RespGetRequisitiAdesioneConvenzione populateResponse(GetRequisitiAdesioneConvenzioneResponse response) {

		return RespGetRequisitiAdesioneConvenzione.builder()
				.esitoErrorMessage(withNoException(() -> response.getGetRequisitiAdesioneConvenzioneResult().getValue()
						.getEsito().getValue().getErrorMessage().getValue(), null))
				.esitoResultCode(
						withNoException(
								() -> response.getGetRequisitiAdesioneConvenzioneResult().getValue().getEsito()
								.getValue().getResultCode().getValue(),
								null))
				.reponseLogErrorDescription(withNoException(() -> response.getGetRequisitiAdesioneConvenzioneResult()
						.getValue().getResponseLog().getValue().getErrorDescription().getValue(),
						null))
				.responseLogHasError(withNoException(() -> response.getGetRequisitiAdesioneConvenzioneResult()
						.getValue().getResponseLog().getValue().isHasError(), null))
				.responseLogResultSize(withNoException(() -> response.getGetRequisitiAdesioneConvenzioneResult()
						.getValue().getResponseLog().getValue().getResultSize(), null))
				.tabellaRequisiti(populateTabellaRequisiti(withNoException(() -> response
						.getGetRequisitiAdesioneConvenzioneResult().getValue().getTabellaRequisiti().getValue(), null)))
				.tabellaRequisitiLength(withNoException(() -> response.getGetRequisitiAdesioneConvenzioneResult()
						.getValue().getTabellaRequisitiLength(), 0))
				.tabellaBenefici(populateTabellaBenefici(withNoException(() -> response
						.getGetRequisitiAdesioneConvenzioneResult().getValue().getTabellaBenefici().getValue(), null)))
				.build();

	}

	private List<AdesioneResponseBenefici> populateTabellaBenefici(ArrayOfAdesioneResponseBenefici value) {
		List<AdesioneResponseBenefici> listRet = new ArrayList<>();
		if(value != null) {
			List<com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseBenefici> listOrig = value
					.getAdesioneResponseBenefici();
			if (CollectionUtils.isNotEmpty(listOrig)) {
				for (com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseBenefici adesioneResponseBenefici : listOrig) {

					listRet.add(AdesioneResponseBenefici.builder()
							.beneficioTipologia(withNoException(
									() -> adesioneResponseBenefici.getBeneficioTipologia().getValue(), null))
							.beneficioValoreCodice(withNoException(
									() -> adesioneResponseBenefici.getBeneficioValoreCodice().getValue(), null))
							.beneficioValoreNumerico(withNoException(
									() -> adesioneResponseBenefici.getBeneficioValoreNumerico().getValue(), null))
							.beneficioValoreParametrato(AdesioneResponseBeneficioValoreParametrato.builder()
									.parametroCodice1(withNoException(
											() -> adesioneResponseBenefici.getBeneficioValoreParametrato().getValue(), null)
											.getParametroCodice1().getValue())
									.parametroPerc1(
											withNoException(() -> adesioneResponseBenefici.getBeneficioValoreParametrato()
													.getValue().getParametroPerc1().getValue(), null))
									.parametroSpread(
											withNoException(() -> adesioneResponseBenefici.getBeneficioValoreParametrato()
													.getValue().getParametroSpread().getValue(), null))
									.build())
							.codiceCondizione(
									withNoException(() -> adesioneResponseBenefici.getCodiceCondizione().getValue(), null))
							.codiceFascia(
									withNoException(() -> adesioneResponseBenefici.getCodiceFascia().getValue(), null))
							.configurazioneFasceApprovato(
									ConfigurazioneFasce.builder()
									.codiceFasciaIndicatoreBeneficiIn(withNoException(
											() -> adesioneResponseBenefici.getConfigurazioneFasceApprovato()
											.getValue().getCodiceFasciaIndicatoreBeneficiIn().getValue(),
											null))
									.codificaIndicatore(withNoException(
											() -> adesioneResponseBenefici.getConfigurazioneFasceApprovato()
											.getValue().getCodificaIndicatore().getValue(),
											null))
									.codificaIndicatoreSottorequisito(
											withNoException(
													() -> adesioneResponseBenefici.getConfigurazioneFasceApprovato()
													.getValue().getCodificaIndicatoreSottorequisito(),
													null))
									.disabilitaMonitoraggio(
											withNoException(
													() -> adesioneResponseBenefici.getConfigurazioneFasceApprovato()
													.getValue().getDisabilitaMonitoraggio().getValue(),
													null))
									.listaFasce(populateListaFasce(withNoException(
											() -> adesioneResponseBenefici.getConfigurazioneFasceApprovato()
											.getValue().getListaFasce().getValue(),
											null)))
									.build())
							.dataDecorrenza(
									withNoException(() -> adesioneResponseBenefici.getDataDecorrenza().getValue(), null))
							.dataScadenza(
									withNoException(() -> adesioneResponseBenefici.getDataScadenza().getValue(), null))
							.driver1Tipologia(
									withNoException(() -> adesioneResponseBenefici.getDriver1Tipologia().getValue(), null))
							.driver1ValoreCodice(withNoException(
									() -> adesioneResponseBenefici.getDriver1ValoreCodice().getValue(), null))
							.driver1ValoreNumerico(withNoException(
									() -> adesioneResponseBenefici.getDriver1ValoreNumerico().getValue(), null))
							.driver2Tipologia(
									withNoException(() -> adesioneResponseBenefici.getDriver2Tipologia().getValue(), null))
							.driver2ValoreCodice(withNoException(
									() -> adesioneResponseBenefici.getDriver2ValoreCodice().getValue(), null))
							.driver2ValoreNumerico(withNoException(
									() -> adesioneResponseBenefici.getDriver2ValoreNumerico().getValue(), null))
							.flagRolling(withNoException(() -> adesioneResponseBenefici.getFlagRolling().getValue(), null))
							.numeroFascia(
									withNoException(() -> adesioneResponseBenefici.getNumeroFascia().getValue(), null))
							.build());

				}
			}
		}
		return listRet;
	}

	private List<Fasce> populateListaFasce(ArrayOfFasce value) {
		List<Fasce> listRet = new ArrayList<>();
		if(value != null) {
			List<com.intesasanpaolo.connector.ws.gen.convenzioniservice.Fasce> listOrig = value.getFasce();
			if(CollectionUtils.isNotEmpty(listOrig)) {
				for (com.intesasanpaolo.connector.ws.gen.convenzioniservice.Fasce fasce : listOrig) {

					listRet.add(Fasce.builder().valoreIndicatore(ValoreIndicatore.builder()
							.alfanumericoSogliaA(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getAlfanumericoSogliaA().getValue(), null))
							.alfanumericoSogliaDa(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getAlfanumericoSogliaDa().getValue(), null))
							.codiceFasciaIndicatore(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getCodiceFasciaIndicatore().getValue(), null))
							.numericoSogliaA(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getNumericoSogliaA().getValue(), null))
							.numericoSogliaDa(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getNumericoSogliaDa().getValue(), null))
							.numeroFasciaDifferenziazione(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getNumeroFasciaDifferenziazione(),
									Short.parseShort("0")))
							.tipoIndicatore(withNoException(
									() -> fasce.getValoreIndicatore().getValue().getTipoIndicatore().getValue(), null))
							.valore(Valore.builder()
									.blocco(BloccoValore.builder()
											.codice(withNoException(() -> fasce.getValoreIndicatore().getValue().getValore()
													.getValue().getBlocco().getValue().getCodice().getValue(), null))
											.tipoDeroga(
													withNoException(
															() -> fasce.getValoreIndicatore().getValue().getValore().getValue()
															.getBlocco().getValue().getTipoDeroga().getValue(),
															null))
											.valoreNumerico(
													withNoException(
															() -> fasce.getValoreIndicatore().getValue().getValore().getValue()
															.getBlocco().getValue().getValoreNumerico().getValue(),
															null))
											.valoreParametrato(ValoreParametrato.builder()
													.codice1(withNoException(() -> fasce.getValoreIndicatore().getValue()
															.getValore().getValue().getBlocco().getValue()
															.getValoreParametrato().getValue().getCodice1().getValue(), null))
													.perc1(withNoException(() -> fasce.getValoreIndicatore().getValue()
															.getValore().getValue().getBlocco().getValue()
															.getValoreParametrato().getValue().getPerc1().getValue(), null))
													.spread(withNoException(() -> fasce.getValoreIndicatore().getValue()
															.getValore().getValue().getBlocco().getValue()
															.getValoreParametrato().getValue().getSpread().getValue(), null))
													.build())
											.build())
									.build())
							.build()).build());

				}
			}
		}
		return listRet;
	}

	private List<AdesioneResponseAdesioneDettaglio> populateTabellaRequisiti(
			ArrayOfAdesioneResponseAdesioneDettaglio value) {
		List<AdesioneResponseAdesioneDettaglio> listRet = new ArrayList<>();
		if(value!=null) {
			List<com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseAdesioneDettaglio> listaOrig = value
					.getAdesioneResponseAdesioneDettaglio();
			if(CollectionUtils.isNotEmpty(listaOrig)) {
				for (com.intesasanpaolo.connector.ws.gen.convenzioniservice.AdesioneResponseAdesioneDettaglio adesioneResponseAdesioneDettaglio : listaOrig) {

					listRet.add(AdesioneResponseAdesioneDettaglio.builder()
							.flagRequisito(withNoException(
									() -> adesioneResponseAdesioneDettaglio.getFlagRequisito().getValue(), null))
							.indicatoreRequisito(withNoException(
									() -> adesioneResponseAdesioneDettaglio.getIndicatoreRequisito().getValue(), null))
							.valoreAlfanumericoRequisito(withNoException(
									() -> adesioneResponseAdesioneDettaglio.getValoreAlfanumericoRequisito().getValue(), null))
							.valoreNumericoRequisisto(withNoException(
									() -> adesioneResponseAdesioneDettaglio.getValoreNumericoRequisisto().getValue(), null))
							.build());
				}
			}
		}
		return listRet;
	}

}
