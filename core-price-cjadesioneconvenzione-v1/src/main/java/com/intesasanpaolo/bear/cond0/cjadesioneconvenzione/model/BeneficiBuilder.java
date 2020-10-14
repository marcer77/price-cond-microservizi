package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.Builder;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJGenericBusinessApplication;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.PaddingField;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBeneficioValoreParametrato;
import static com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil.withNoException;


public class BeneficiBuilder implements Builder<String> {

	private AdesioneResponseBenefici adesioneResponseBenefici;

	public BeneficiBuilder(AdesioneResponseBenefici adesioneResponseBenefici) {
		this.adesioneResponseBenefici = adesioneResponseBenefici;
	}
	

	@Override
	public String build() {
		
		StringWriter st=new StringWriter();
		//1  BEN-COD-CONDIZIONE CCCCCCCC	Benefici.codiceCondizione
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getCodiceCondizione(), 8));
		
		//2 BEN-FLG-MONIT-ATT		C	"se Benefici.flagRolling='S'  allora valorizzare a 'S'
		//altrimenti se Benefici.Configurazione_Fasce_Approvato.Disabilita_Monitoraggio ='S'
		//allora valorizzare a 'N'  altrimenti valorizzare a 'S'"
		String benFlgMonitATT="S".equals(adesioneResponseBenefici.getFlagRolling())? adesioneResponseBenefici.getFlagRolling():("S".equals(adesioneResponseBenefici.getConfigurazioneFasceApprovato().getDisabilitaMonitoraggio()) ? "N" : "S");
		st.append(PaddingField.rightPadSpaceOrTruncate(benFlgMonitATT,1));
		
		//3	BEN-COD-FASCIA		C	"se Benefici.flagRolling='S'  allora valorizzare a '9' altrimenti valorizzare con Benefici.codiceFascia"
		String benCODFascia="S".equals(adesioneResponseBenefici.getFlagRolling()) ? "9": adesioneResponseBenefici.getCodiceFascia();
		st.append(PaddingField.rightPadSpaceOrTruncate(benCODFascia,1));
		
		//4 BEN-NR-FASCIA NN "se Benefici.flagRolling='S' allora valorizzare a 99
		//altrimenti valorizzare con Benefici.numeroFascia"
		String benNRFascia= "S".equals(adesioneResponseBenefici.getFlagRolling()) ? "99": adesioneResponseBenefici.getNumeroFascia().toString();
		st.append(PaddingField.leftPadZeroOrTruncate(benNRFascia, 2));
		
		//5 BEN-DECO-BEN NN.NN.NNNN	Benefici.dataDecorrenza [da AAAAMMGG a GG.MM.AAAA]
		try {
			String benDecoBen = DateUtils.convertiDate(adesioneResponseBenefici.getDataDecorrenza(), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID, DateUtils.DATE_FORMAT_DD_MM_YYYY_DOTS);
			st.append(PaddingField.rightPadSpaceOrTruncate(benDecoBen, 10));
			
		} catch (ParseException e) {
			throw new  CJGenericBusinessApplication(CommonErrorCode.GENERIC_EXCEPTION, e.getMessage(), e);
		}
		
		//6 BEN-DECA-BEN	X(10)	NN.NN.NNNN	Benefici.dataScadenza   [da AAAAMMGG a GG.MM.AAAA]
		try {
			String benDecaBen = DateUtils.convertiDate(adesioneResponseBenefici.getDataScadenza(), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID, DateUtils.DATE_FORMAT_DD_MM_YYYY_DOTS);
			st.append(PaddingField.rightPadSpaceOrTruncate(benDecaBen, 10));
		} catch (ParseException e) {
			throw new  CJGenericBusinessApplication(CommonErrorCode.GENERIC_EXCEPTION, e.getMessage(), e);
			
		}
		
		
		//7	BEN-IND-VALORE	 C	Benefici.beneficio_Tipologia
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getBeneficioTipologia(), 1));
		
		//8	BEN-VAL-NUM	 SNNNNNNNNNNNNNNN 
		//	"se Benefici.parametro_Spread not null
		// allora valorizzare con valore assoluto di Benefici.parametro_Spread * 100000 altrimenti valorizzare con Benefici.beneficio_ValoreNumerico * 100000"
		
		st.append(getBenValNum());
		
		//9 BEN-VAL-COD  CCCCC Benefici.beneficio_ValoreCodice
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getBeneficioValoreCodice(), 5));
		
		//10 BEN-PRESENZA-FORM 	C "se Benefici.beneficio_ValoreParametrato not null allora valorizzare a 'S' altrimenti valorizzare a 'N'"
		st.append(PaddingField.rightPadSpaceOrTruncate(getValoreCodice(), 1));
		
		//11 BEN-PARAMETRO1		CCCCCCCC Benefici.parametro_Codice1
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroCodice1(), 8));
		
		//12 BEN-XC-PARAMETRO1  NNNNNNNN	Benefici.parametro_Perc1 * 100000
		BigDecimal benXCParametro1=  withNoException(()->adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroPerc1().multiply(new BigDecimal(100000)),BigDecimal.ZERO);
		st.append(PaddingField.leftPadZeroOrTruncate(benXCParametro1.toString(),8));
		
		//13 BEN-PARAMETRO2	CCCCCCCC	fisso a spazi
		st.append(PaddingField.rightPadSpaceOrTruncate("", 8));
		
		//14 BEN-XC-PARAMETRO2	9(3)V9(5)	NNNNNNNN	fisso a '00000000'
		st.append(PaddingField.leftPadZeroOrTruncate("", 8));
		
		//15 BEN-OPERAT-SPREAD	X(1)	C	
		//"se Benefici.parametro_Spread is null allora valorizzare a ' ' altrimenti se Benefici.parametro_Spread < 0 allora valorizzare a '-' altrimenti valorizzare a '+'"
		st.append(PaddingField.rightPadSpaceOrTruncate(getOperatoreSpread(),1));
		
		//16 BEN-VAL-NUM-DRV1 SNNNNNNNNNNNNNNNNNN Benefici.driver1_ValoreNumerico * 1000
		BigDecimal benValNumDRV1=withNoException(()->adesioneResponseBenefici.getDriver1ValoreNumerico().multiply(new BigDecimal(1000)),BigDecimal.ZERO); 
		String segno=benValNumDRV1.signum()<0?"-":"+";
		st.append(segno+PaddingField.leftPadZeroOrTruncate(benValNumDRV1.toString(), 18));
	
		//17 BEN-VAL-COD-DRV1	CCCCC	Benefici.driver1_ValoreCodice  	
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getDriver1ValoreCodice(), 5));
		
		//18 BEN-VAL-NUM-DRV2	SNNNNNNNNNNNNNNNNNN	Benefici.driver2_ValoreNumerico * 1000
		BigDecimal benValNumDRV2=withNoException(()->adesioneResponseBenefici.getDriver2ValoreNumerico().multiply(new BigDecimal(1000)),BigDecimal.ZERO); 
		segno=benValNumDRV2.signum()<0?"-":"+";
		st.append(segno+PaddingField.leftPadZeroOrTruncate(benValNumDRV2.toString(), 18));
		
		//19	BEN-VAL-COD-DRV2	CCCCC	Benefici.driver2_ValoreCodice
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getDriver2ValoreCodice(), 5));
		
		//20	BEN-FLG-ROLLING	X(1)	C	Benefici.flagRolling
		st.append(PaddingField.rightPadSpaceOrTruncate(adesioneResponseBenefici.getFlagRolling(), 1));
		
		
		return st.toString();
	}

	private String getOperatoreSpread() {
		//"se Benefici.parametro_Spread is null allora valorizzare a ' ' altrimenti se Benefici.parametro_Spread < 0 allora valorizzare a '-' altrimenti valorizzare a '+'"
				
		if (adesioneResponseBenefici.getBeneficioValoreParametrato() != null
				&& adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread() != null) {
			return adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread().signum() < 0 ? "-"
					: "+";
		} else {
			return " ";
		}
	}

	private String getBenValNum() {
		BigDecimal result=null;
		if (adesioneResponseBenefici.getBeneficioValoreParametrato() != null
				&& adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread() != null) {
			result= withNoException(()->adesioneResponseBenefici.getBeneficioValoreParametrato().getParametroSpread().abs().multiply(new BigDecimal(100000)),BigDecimal.ZERO);
		} else {
			result= withNoException(()->adesioneResponseBenefici.getBeneficioValoreNumerico().multiply(new BigDecimal(100000)),BigDecimal.ZERO);
		}
		String numero=PaddingField.leftPadZeroOrTruncate(result.toString(), 15);
		String segno=result.intValue()>=0?"+":"-";
		return segno+numero;
	}

	private String getValoreCodice() {
		
		AdesioneResponseBeneficioValoreParametrato valoreParametrato= adesioneResponseBenefici.getBeneficioValoreParametrato();
		boolean checkNotNull= valoreParametrato != null;
		boolean checkFieldsNotEmpty=StringUtils.isNotBlank(valoreParametrato.getParametroCodice1())
				||StringUtils.isNotBlank(valoreParametrato.getParametroCodice2())
				||valoreParametrato.getParametroPerc1() != null
				||valoreParametrato.getParametroPerc2() != null;
		
		checkNotNull=checkNotNull && checkFieldsNotEmpty;
	
		return checkNotNull?"S":"N";
		
	}
}
