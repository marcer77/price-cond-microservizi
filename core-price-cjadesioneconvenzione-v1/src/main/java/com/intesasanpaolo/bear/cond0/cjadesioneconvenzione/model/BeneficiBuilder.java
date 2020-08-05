package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.Builder;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.PaddingField;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;

public class BeneficiBuilder implements Builder<String> {

	private AdesioneResponseBenefici adesioneResponseBenefici;

	public BeneficiBuilder(AdesioneResponseBenefici adesioneResponseBenefici) {
		this.adesioneResponseBenefici = adesioneResponseBenefici;
	}

	@Override
	public String build() {
		String strBuilder = PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getCodiceCondizione(), 8)
				+ PaddingField
						.rightPadSpaceOrTruncate("S".equals(adesioneResponseBenefici.getFlagRolling())
								? adesioneResponseBenefici.getFlagRolling()
								: ("S".equals(adesioneResponseBenefici.getConfigurazioneFasceApprovato()
										.getDisabilitaMonitoraggio()) ? "N" : "S"),
								1)
				+ PaddingField.rightPadSpaceOrTruncate("S".equals(adesioneResponseBenefici.getFlagRolling()) ? "9"
						: adesioneResponseBenefici.getCodiceFascia(), 1)
				+ PaddingField.leftPadZeroOrTruncate("S".equals(adesioneResponseBenefici.getFlagRolling()) ? "99"
						: adesioneResponseBenefici.getNumeroFascia().toString(), 2)
				+ PaddingField.rightPadSpaceOrTruncate(getDataFromattata(adesioneResponseBenefici.getDataDecorrenza()),
						10)
				+ PaddingField.rightPadSpaceOrTruncate(getDataFromattata(adesioneResponseBenefici.getDataScadenza()),
						10)
				+ PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getBeneficioTipologia(), 1)
				+ PaddingField.leftPadZeroOrTruncate(getSpread(), 15)
				+ PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getBeneficioValoreCodice(), 5)
				+ PaddingField.rightPadSpaceOrTruncate(getValoreCodice(), 1)
				+ PaddingField.rightPadSpaceOrTruncate(
						adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroCodice1(), 8)
				+ PaddingField.leftPadZeroOrTruncate(adesioneResponseBenefici.getBeneficioValoreParametrato()
						.getParametroPerc1().multiply(new BigDecimal(100000)).toString(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(
						adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroCodice2(), 8)
				+ PaddingField.leftPadZeroOrTruncate(
						adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroPerc2().toString(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(getOperatoreSpread(), 1)
				+ PaddingField
						.rightPadSpaceOrTruncate(adesioneResponseBenefici.getDriver1ValoreNumerico().signum() < 0 ? "-"
								: "+" + adesioneResponseBenefici.getDriver1ValoreNumerico()
										.multiply(new BigDecimal(1000)).toString(),
								18)
				+ PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getDriver1ValoreCodice(), 5)
				+ PaddingField
						.rightPadSpaceOrTruncate(adesioneResponseBenefici.getDriver1ValoreNumerico().signum() < 0 ? "-"
								: "+" + adesioneResponseBenefici.getDriver2ValoreNumerico()
										.multiply(new BigDecimal(1000)).toString(),
								18)
				+ PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getDriver2ValoreCodice(), 5)
				+ PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getFlagRolling(), 1);
		return strBuilder;
	}

	private String getDataFromattata(String data) {
		Date date = null;
		try {
			date = new SimpleDateFormat("ddMMyyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ServiceUtil.dateToString(date, "dd.MM.yyyy");
	}

	private String getOperatoreSpread() {
		if (adesioneResponseBenefici.getBeneficioValoreParametrato() != null
				&& adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread() != null) {
			return adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread().signum() < 0 ? "-"
					: "+";
		} else {
			return " ";
		}
	}

	private String getSpread() {
		if (adesioneResponseBenefici.getBeneficioValoreParametrato() != null
				&& adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread() != null) {
			return adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread().abs()
					.multiply(new BigDecimal(100000)).toString();
		} else {
			return adesioneResponseBenefici.getBeneficioValoreNumerico().multiply(new BigDecimal(100000)).toString();
		}
	}

	private String getValoreCodice() {
		if (adesioneResponseBenefici.getBeneficioValoreParametrato() != null
				&& adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroPerc1() != null
				&& adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread() != null && StringUtils
						.isNotEmpty(adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroCodice1())) {
			return "S";
		} else {
			return "N";
		}
	}
}
