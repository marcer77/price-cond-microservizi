package com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {
	
	public String PCMM_O_COD_CONV;
	public String PCMM_O_COD_CONV_RF;
	public String PCMM_O_COD_PRODOTTO;
	public String PCMM_O_COD_PROMO;
	public String PCMM_O_DATA_DECA_CONV;
	public String PCMM_O_DATA_DECA_PROMO;
	public String PCMM_O_DATA_DECO_CONV;
	public String PCMM_O_DATA_DECO_PROMO;
	public String PCMM_O_DESC_CONV;
	public String PCMM_O_FLAG_CRUSCOTTO;
	public String PCMM_O_FLG_CM;
	public String PCMM_O_LISTA_COMPLETA_ACC;
	public String PCMM_O_LISTA_COMPLETA_CC;
	
	public List<ListinoRapportoAccessorio> PCMM_O_TAB_OUTLAC = new ArrayList<ListinoRapportoAccessorio>();
	public List<ListinoContoCorrente> PCMM_O_TAB_OUTLST = new ArrayList<ListinoContoCorrente>();
	public List<Promozione> PCMM_O_TAB_OUTPRM = new ArrayList<Promozione>();

}
