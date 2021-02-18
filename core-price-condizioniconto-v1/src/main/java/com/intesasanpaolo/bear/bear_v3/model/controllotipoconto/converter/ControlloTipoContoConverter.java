package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoResponse;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ListinoContoCorrente;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.RapportoAccessorio;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoRapportoAccessorio;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseBody;

public class ControlloTipoContoConverter {
	
	public ControlloTipoContoResponse to(ResponseBody input) {
		ControlloTipoContoResponse output = new ControlloTipoContoResponse();
		if (input != null) {
			output.setCdConvenzioneAde(input.PCMM_O_COD_CONV);
			output.setCdConvenzioneRif(input.PCMM_O_COD_CONV_RF);
			output.setCdPrdotto(input.PCMM_O_COD_PRODOTTO);
			output.setCdTipoConto(input.PCMM_O_FLG_CM);
			output.setDsConvenzione(input.PCMM_O_DESC_CONV);
			output.setDtDecorrenzaAdeConv(input.PCMM_O_DATA_DECO_CONV);
			output.setDtScadenzaAdeConv(input.PCMM_O_DATA_DECA_CONV);
			output.setFlCruscotto(input.PCMM_O_FLAG_CRUSCOTTO);
			output.setCdPromozione(input.PCMM_O_COD_PROMO);
			output.setDtDecorrenzaPromo(input.PCMM_O_DATA_DECO_PROMO);
			output.setDtScadenzaPromo(input.PCMM_O_DATA_DECA_PROMO);
			output.setListiniCC(new ArrayList<ListinoContoCorrente>());
			for (com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente listinoCC : input.PCMM_O_TAB_OUTLST) {
				output.getListiniCC().add(convertListinoCC(listinoCC));
			}
			output.setNiListiniCC(output.getListiniCC().size());
			output.setRapportiACC(new ArrayList<RapportoAccessorio>());
			for (ListinoRapportoAccessorio listinoACC : input.PCMM_O_TAB_OUTLAC) {
				output.getRapportiACC().add(convertListinoACC(listinoACC));
			}
			output.setNiListiniACC(output.getRapportiACC().size());
		}
		return output;
	}
	
	private ListinoContoCorrente convertListinoCC(com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente input) {
		ListinoContoCorrente listinoCC = new ListinoContoCorrente();
		listinoCC.setCdCnvLivAppl(input.PCMM_O_CND_LIV_APPL);
		listinoCC.setCdCondizione(input.PCMM_O_COD_CONDIZIONE);
		listinoCC.setCdDivisa(input.PCMM_O_CND_DIVISA);
		listinoCC.setCdListino(input.PCMM_O_COD_LISTINO);
		listinoCC.setCdProgrLegame(""+input.PCMM_O_PROG_LEGAME);
		listinoCC.setCdServizio(input.PCMM_O_COD_SERVIZIO);
		listinoCC.setDtDecorrenza(input.PCMM_O_DATA_DECO);
		listinoCC.setDtScadenza(input.PCMM_O_DATA_DECA);
		return listinoCC;
	}
	
	private RapportoAccessorio convertListinoACC(ListinoRapportoAccessorio input) {
		RapportoAccessorio listinoACC = new RapportoAccessorio();
		listinoACC.setCdCnvLivApplAcc(input.PCMM_O_CND_LIV_APPL_ACC);
		listinoACC.setCdConvenzioneAcc(input.PCMM_O_COD_CONV_ACC);
		listinoACC.setCdDivisaAcc(input.PCMM_O_CND_DIVISA_ACC);
		listinoACC.setCdListinoAcc(input.PCMM_O_COD_LISTINO_ACC);
		listinoACC.setCdProgrLegameAcc(""+input.PCMM_O_NUM_PROG_RAPP_ACC);
		listinoACC.setCdPromozioneAcc(input.PCMM_O_COD_PROMO_ACC);
		listinoACC.setCdRappCategoria(input.PCMM_O_COD_CAT_RAPP_ACC);
		listinoACC.setCdRappConto(input.PCMM_O_NUM_PROG_RAPP_ACC);
		listinoACC.setCdRappFiliale(input.PCMM_O_COD_FIL_RAPP_ACC);
		listinoACC.setCdServizioRapp(input.PCMM_O_COD_SERVIZIO_RAPP_ACC);
		listinoACC.setCdSocRappAcc(input.PCMM_O_COD_SOC_RAPP_ACC);
		listinoACC.setDsConvenzioneAcc(input.PCMM_O_DESC_CONV_ACC);
		listinoACC.setDtDecorrenzaAcc(input.PCMM_O_DATA_DECO_ACC);
		listinoACC.setDtDecorrenzaConvAcc(input.PCMM_O_DATA_DECO_CONV_ACC);
		listinoACC.setDtDecorrenzaPromoAcc(input.PCMM_O_DATA_DECO_PROMO_ACC);
		listinoACC.setFlEsposiz(input.PCMM_O_FLAG_ESPOSIZ);
		listinoACC.setNrValoreConvenzioneAcc(new BigDecimal(input.PCMM_O_CND_VALORE_ACC));
		return listinoACC;
	}
	
	public List<ListinoContoCorrente> getListiniCC(ResponseBody input){
		List<ListinoContoCorrente> list = new ArrayList<ListinoContoCorrente>();
		for (com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente listinoCC : input.PCMM_O_TAB_OUTLST) {
			list.add(convertListinoCC(listinoCC));
		}
		return list;
	}

	public List<RapportoAccessorio> getListiniACC(ResponseBody input){
		List<RapportoAccessorio> list = new ArrayList<RapportoAccessorio>();
		for (ListinoRapportoAccessorio listinoACC : input.PCMM_O_TAB_OUTLAC) {
			list.add(convertListinoACC(listinoACC));
		}
		return list;
	}
}
