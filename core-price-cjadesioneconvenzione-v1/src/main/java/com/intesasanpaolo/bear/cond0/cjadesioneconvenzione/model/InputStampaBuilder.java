package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import java.io.StringWriter;

import org.apache.commons.lang3.builder.Builder;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.PaddingField;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;

/**
 * 
 * 
 * 
 * @author 
 *
 */
public class InputStampaBuilder implements Builder<String> {

	private InputStampaDTO inputStampa;

	public InputStampaBuilder(InputStampaDTO inputStampa) {
		this.inputStampa = inputStampa;
	}
	
	@Override
	public String build() {
		StringWriter st=new StringWriter();
		
		//input.intestatario.NDG	NNNNNNNNNNNNN	13
		st.append(PaddingField.leftPadZeroOrTruncate(inputStampa.getIntestatario().getNdg(),13));
		
		//input.intestatario.intestazione	70 C	70
		st.append(PaddingField.rightPadSpaceOrTruncate(inputStampa.getIntestatario().getIntestazione(), 70));
		
		//input.intestatario.specieGiur	CCCCC	5
		st.append(PaddingField.rightPadSpaceOrTruncate(inputStampa.getIntestatario().getSpecieGiur(), 5));
		
		//input.intestatario.codFiscale	CCCCCCNNCNNCNNNC	16
		st.append(PaddingField.rightPadSpaceOrTruncate(inputStampa.getIntestatario().getCodFiscale(), 16));		
		
		//input.intestatario.pIVA	NNNNNNNNNNN	11
		st.append(PaddingField.leftPadZeroOrTruncate(inputStampa.getIntestatario().getPIVA(), 11));
		
		//input.rapporto.codFiliale	NNNNN	5
		st.append(PaddingField.leftPadZeroOrTruncate(inputStampa.getRapporto().getCodFiliale(), 5));	
		
		//input.rapporto.codCategoria	NNNN	4
		st.append(PaddingField.leftPadZeroOrTruncate(inputStampa.getRapporto().getCodCategoria(), 4));		
		//input.rapporto.codProgressivo	NNNNNNNN	8
		st.append(PaddingField.leftPadZeroOrTruncate(inputStampa.getRapporto().getCodProgressivo(), 8));			
		
		//input.infoStampa.Data	AAAAMMGG	8
		st.append(PaddingField.rightPadSpaceOrTruncate(DateUtils.dateToString(inputStampa.getInfoStampa().getData(),"yyyyMMdd"), 8));	
		
		//input.infoStampa.keyOper	30 C	30
		st.append(PaddingField.rightPadSpaceOrTruncate(inputStampa.getInfoStampa().getKeyOper(), 30));	
			
		return st.toString();
		
	}
	
		
}
