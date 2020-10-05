package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model;

import java.io.StringWriter;

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
		
		StringWriter st=new StringWriter();
		
		//1 COD-CONDIZIONE         	X(5)	CCCCC	...CovenantDaAttivare.Cod_Condizione
		st.append( PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCodCondizione(), 5));
		
		//2 CODICE-TEMPLATE        	X(8)	CCCCCCCC	...CovenantDaAttivare.codiceTemplate
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCodiceTemplate(), 8));
		
		//3	VERSIONE-TEMPLATE      	9(5)	CCCCC	...CovenantDaAttivare.versioneTemplate
		st.append(PaddingField.leftPadZeroOrTruncate(infoConvenant.getVersioneTemplate(), 5));
		
		//4	COVEN-DATA-INIZIO      	X(8)	CCCCCCCC	...CovenantDaAttivare.Covenant_DataInizio
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCovenantDataInizio(), 8));
		
		//5	COVEN-DATA-FINE        	X(8)	CCCCCCCC	...CovenantDaAttivare.Covenant_DataFine
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getCovenantDataFine(), 8));
		
		
		//6	BEN-INGR-PRES          	X(1)	C	...CovenantDaAttivare.BeneficioIngresso_Presente
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIngressoPresente(), 1));
		

		//7	BEN-INGR-DATA-INIZIO   	X(8)	CCCCCCCC	...CovenantDaAttivare.BeneficioIngresso_DataInizio
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIngressoDataInizio(), 8));
		
		//8	BEN-INGR-DATA-FINE     	X(8)	CCCCCCCC	...CovenantDaAttivare.BeneficioIngresso_DataFine
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIngressoDataFine(), 8));
	
		//9		BEN-INCONDIZ-PRESENTE  	X(1)	C	...CovenantDaAttivare.BeneficioIncondizionato_Presente
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIncondizionatoPresente(), 1));
		
		//10	BEN-INCONDIZ-DATA-INIZ 	X(8)	CCCCCCCC	...CovenantDaAttivare.BeneficioIncondizionato_DataInizio
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIncondizionatoDataInizio(), 8));
		
		//11	BEN-INCONDIZ-DATA-FINE 	X(8)	CCCCCCCC	...CovenantDaAttivare.BeneficioIncondizionato_DataFine
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioIncondizionatoDataFine(), 8));
			
		//12	BEN-INCONDIZ-NUMRILEV  	9(3)	NNN	...CovenantDaAttivare.BeneficioIncondizionato_NumRilevazioni
		st.append(PaddingField.leftPadZeroOrTruncate(infoConvenant.getBeneficioIncondizionatoNumRilevazioni(), 3));
		
		//13	BEN-CONDIZ-DATA-INIZ   	X(8)	CCCCCCCC	...CovenantDaAttivare.BeneficioCondizionato_DataInizio
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioCondizionatoDataInizio(), 8));
		
		//14	BEN-CONDIZ-DATA-FINE   	X(8)	CCCCCCCC	...CovenantDaAttivare.BeneficioCondizionato_DataFine
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getBeneficioCondizionatoDataFine(), 8));
				
		//15	FLG-EV-ETACLIENTE      	X(1)	C	...CovenantDaAttivare.Flag_EventoEtaCliente
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getFlagEventoEtaCliente(), 1));
		
		//16	FLG-EFF-RILEV	X(1)	C	...CovenantDaAttivare.Flag_EffettoRilevato
		st.append(PaddingField.rightPadSpaceOrTruncate(infoConvenant.getFlagEffettoRilevato(), 1));
				
		return st.toString();
				
	}
}
