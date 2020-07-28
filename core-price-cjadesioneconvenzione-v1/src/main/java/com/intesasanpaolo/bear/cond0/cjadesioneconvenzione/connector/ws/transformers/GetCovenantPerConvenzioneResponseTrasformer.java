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
import static com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil.*;

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
					.beneficioCondizionatoDataFine(withNoException(()-> element.getBeneficioCondizionatoDataFine().getValue(),null))
					.beneficioCondizionatoDataInizio(withNoException(()-> element.getBeneficioCondizionatoDataInizio().getValue(),null))
					.beneficioIncondizionatoDataFine(withNoException(()-> element.getBeneficioIncondizionatoDataFine().getValue(),null))
					.beneficioIncondizionatoDataInizio(withNoException(()-> element.getBeneficioIncondizionatoDataInizio().getValue(),null))
					.beneficioIncondizionatoNumRilevazioni(withNoException(()-> element.getBeneficioIncondizionatoNumRilevazioni().getValue(),null))
					.beneficioIncondizionatoPresente(withNoException(()-> element.getBeneficioIncondizionatoPresente().getValue(),null))
					.beneficioIngressoDataFine(withNoException(()-> element.getBeneficioIngressoDataFine().getValue(),null))
					.beneficioIngressoDataInizio(withNoException(()-> element.getBeneficioIngressoDataInizio().getValue(),null))
					.beneficioIngressoPresente(withNoException(()-> element.getBeneficioIngressoPresente().getValue(),null))
					.codCondizione(withNoException(()-> element.getCodCondizione().getValue(),null))
					.codiceTemplate(withNoException(()-> element.getCodiceTemplate().getValue(),null))
					.covenantDataFine(withNoException(()-> element.getCovenantDataFine().getValue(),null))
					.covenantDataInizio(withNoException(()-> element.getCovenantDataInizio().getValue(),null))
					.flagEffettoRilevato(withNoException(()-> element.getFlagEffettoRilevato().getValue(),null))
					.flagEventoEtaCliente(withNoException(()-> element.getFlagEventoEtaCliente().getValue(),null)).build());
					

		}
		}
		return ret;

	}

}
