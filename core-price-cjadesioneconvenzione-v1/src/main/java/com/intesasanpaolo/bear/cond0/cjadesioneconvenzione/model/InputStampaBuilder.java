package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import org.apache.commons.lang3.builder.Builder;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.PaddingField;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;

public class InputStampaBuilder implements Builder<String> {

	private InputStampaDTO inputStampa;

	public InputStampaBuilder(InputStampaDTO inputStampa) {
		this.inputStampa = inputStampa;
	}
	
	@Override
	public String build() {
		return 
				PaddingField.leftPadZeroOrTruncate(inputStampa.getIntestatario().getNdg(),13)
				+ PaddingField.rightPadSpaceOrTruncate(inputStampa.getIntestatario().getIntestazione(), 70)
				+ PaddingField.rightPadSpaceOrTruncate(inputStampa.getIntestatario().getSpecieGiur(), 5)
				+ PaddingField.rightPadSpaceOrTruncate(inputStampa.getIntestatario().getCodFiscale(), 16)
				+ PaddingField.leftPadZeroOrTruncate(inputStampa.getIntestatario().getPIva(), 11)
				+ PaddingField.leftPadZeroOrTruncate(inputStampa.getRapporto().getCodFiliale(), 5)
				+ PaddingField.leftPadZeroOrTruncate(inputStampa.getRapporto().getCodCategoria(), 4)
				+ PaddingField.leftPadZeroOrTruncate(inputStampa.getRapporto().getCodProgressivo(), 8)
				+ PaddingField.rightPadSpaceOrTruncate(DateUtils.dateToString(inputStampa.getInfoStampa().getData(),"yyyyMMdd"), 8)
				+ PaddingField.rightPadSpaceOrTruncate(inputStampa.getInfoStampa().getKeyOper(), 30)
				;
	}

}
