package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import org.apache.commons.lang3.builder.Builder;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.PaddingField;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;

public class InfoCovenantBuilder implements Builder<String> {

	private RespGetCovenantPerConvenzioneCovenantDaAttivare infoConvenant;

	public InfoCovenantBuilder(RespGetCovenantPerConvenzioneCovenantDaAttivare infoConvenant) {
		this.infoConvenant = infoConvenant;
	}

	@Override
	public String build() {
		return PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCodCondizione(), 5)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCodiceTemplate(), 8)
				+ PaddingField.leftPadZeroOrTruncate(infoConvenant.getVersioneTemplate(), 5)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCovenantDataInizio(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCovenantDataFine(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIngressoPresente(), 1)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIngressoDataInizio(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIngressoDataFine(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIncondizionatoPresente(), 1)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioCondizionatoDataInizio(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioCondizionatoDataFine(), 8)
				+ PaddingField.leftPadZeroOrTruncate(infoConvenant.getBeneficioIncondizionatoNumRilevazioni(), 3)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioCondizionatoDataInizio(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioCondizionatoDataFine(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getFlagEventoEtaCliente(), 1)
				+ PaddingField.rightPadSpaceOrTruncate(infoConvenant.getFlagEffettoRilevato(), 8);
	}
}
