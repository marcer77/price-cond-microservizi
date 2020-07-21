package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.transformers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.connector.ws.model.SoapConnectorResponse;
import com.intesasanpaolo.bear.connector.ws.transformer.ISoapResponseTransformer;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.GetCovenantPerConvenzioneResponse;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzione;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare;

@Service
public class GetCovenantPerConvenzioneResponseTrasformer implements
		ISoapResponseTransformer<ResponseGetCovenantPerConvenzione, List<RespGetCovenantPerConvenzioneCovenantDaAttivare>> {

	@Override
	public List<RespGetCovenantPerConvenzioneCovenantDaAttivare> transform(
			SoapConnectorResponse soapConnectorResponse) {

		GetCovenantPerConvenzioneResponse resp = (GetCovenantPerConvenzioneResponse) soapConnectorResponse
				.getResponse();

		return populateResponse(resp.getGetCovenantPerConvenzioneResult().getValue());
	}

	private List<RespGetCovenantPerConvenzioneCovenantDaAttivare> populateResponse(
			ResponseGetCovenantPerConvenzione value) {

		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> ret = new ArrayList<>();

		List<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare> arrayListDaAtt = value
				.getResponseGetCovenantPerConvenzione().getValue().getListaCovenantDaAttivare().getValue()
				.getResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare();
		if(CollectionUtils.isNotEmpty(arrayListDaAtt)) {
		for (ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare element : arrayListDaAtt) {
			ret.add(
			RespGetCovenantPerConvenzioneCovenantDaAttivare.builder()
					.beneficioCondizionatoDataFine(element.getBeneficioCondizionatoDataFine().getValue())
					.beneficioCondizionatoDataInizio(element.getBeneficioCondizionatoDataInizio().getValue())
					.beneficioIncondizionatoDataFine(element.getBeneficioIncondizionatoDataFine().getValue())
					.beneficioIncondizionatoDataInizio(element.getBeneficioIncondizionatoDataInizio().getValue())
					.beneficioIncondizionatoNumRilevazioni(element.getBeneficioIncondizionatoNumRilevazioni().getValue())
					.beneficioIncondizionatoPresente(element.getBeneficioIncondizionatoPresente().getValue())
					.beneficioIngressoDataFine(element.getBeneficioIngressoDataFine().getValue())
					.beneficioIngressoDataInizio(element.getBeneficioIngressoDataInizio().getValue())
					.beneficioIngressoPresente(element.getBeneficioIngressoPresente().getValue())
					.codCondizione(element.getCodCondizione().getValue())
					.codiceTemplate(element.getCodiceTemplate().getValue())
					.covenantDataFine(element.getCovenantDataFine().getValue())
					.covenantDataInizio(element.getCovenantDataInizio().getValue())
					.flagEffettoRilevato(element.getFlagEffettoRilevato().getValue())
					.flagEventoEtaCliente(element.getFlagEventoEtaCliente().getValue()).build());
					

		}
		}
		return ret;

	}

}
