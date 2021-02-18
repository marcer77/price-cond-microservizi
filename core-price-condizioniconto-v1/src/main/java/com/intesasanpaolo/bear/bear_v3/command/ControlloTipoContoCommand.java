package com.intesasanpaolo.bear.bear_v3.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.intesasanpaolo.bear.bear_v3.dto.utils.StrUtils;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoResponse;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ControlloTipoContoRequest;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.ListinoContoCorrente;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.Promozione;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.RapportoAccessorio;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.converter.ControlloTipoContoConverter;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.converter.ControlloTipoContoRequestConverter;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.request.RequestHostBridge;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseBody;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseHeader;
import com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ResponseHostBridge;
import com.intesasanpaolo.bear.bear_v3.service.CondizioniContoService;
import com.intesasanpaolo.bear.bear_v3.service.JDBCService;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope("prototype")
public class ControlloTipoContoCommand extends BaseCommand<ControlloTipoContoResponse>{
	
	private ControlloTipoContoRequest request;
	
	@Autowired
	private CondizioniContoService service;
	
	@Autowired
	private JDBCService jdbcService;
	
	public ControlloTipoContoCommand(ControlloTipoContoRequest request) {
		this.request = request;
	}
	
	//richiamo il service per ottenere i listini
	@Override
	public ControlloTipoContoResponse doExecute() throws Exception {
		Gson gson = new Gson();
		try {
			logger.info("TEST LOG SYSTEM");
			logger.info("CONTROLLO TIPO CONTO REQUEST:\n" + gson.toJson(request));
			ControlloTipoContoRequestConverter requestConverter = new ControlloTipoContoRequestConverter();
			if (StrUtils.isNullOrEmpty(request.getCdAbi())) {
				throw new SystemException("Codice abi obbligatorio.");
			}
			String cdIstituto = jdbcService.getIstitutoFromAbi(request.getCdAbi());
			RequestHostBridge request = requestConverter.to(this.request, cdIstituto);
			//converti request nella request per hostbridge
			ResponseHostBridge response= service.controlloTipoConto(request);
			if (response.header.RETCODE != 0) {
				ControlloTipoContoResponse output = new ControlloTipoContoResponse();
				output.setCdEsito(CondizioniContoUtils.ESITO_KO);
				output.setMsgEsito(response.outcome.ESITO + " " + response.report.TXT_SEGNALAZIONE);
				return output;
			}
			//converti risposta hostbridge nella risposta microservizio (ControlloTipoContoOutput)
			//paginazione listini
			ControlloTipoContoConverter converter = new ControlloTipoContoConverter();
			ControlloTipoContoResponse output = converter.to(response.body);
			if (response.body != null) {
				String listaCompletaListiniCC = response.body.PCMM_O_LISTA_COMPLETA_CC;
				String listaCompletaListiniACC = response.body.PCMM_O_LISTA_COMPLETA_ACC;
				while("N".equalsIgnoreCase(listaCompletaListiniCC) || "N".equalsIgnoreCase(listaCompletaListiniACC)) {
					if (!output.getListiniCC().isEmpty()) {
						request.body.PCMM_I_COD_LISTINO = output.getListiniCC().get(output.getListiniCC().size()-1).getCdListino();
					}
					if (!output.getRapportiACC().isEmpty()) {
						request.body.PCMM_I_NUM_PROG_RAPP_ACC = output.getRapportiACC().get(output.getRapportiACC().size()-1).getCdRappConto();
						request.body.PCMM_I_COD_CAT_RAPP_ACC = output.getRapportiACC().get(output.getRapportiACC().size()-1).getCdRappCategoria();
						request.body.PCMM_I_COD_FIL_RAPP_ACC = output.getRapportiACC().get(output.getRapportiACC().size()-1).getCdRappFiliale();
					}
					response= service.controlloTipoConto(request);
					listaCompletaListiniCC = response.body.PCMM_O_LISTA_COMPLETA_CC;
					listaCompletaListiniACC = response.body.PCMM_O_LISTA_COMPLETA_ACC;
					output.getListiniCC().addAll(converter.getListiniCC(response.body));
					output.getRapportiACC().addAll(converter.getListiniACC(response.body));
					listaCompletaListiniCC = response.body.PCMM_O_LISTA_COMPLETA_CC;
					listaCompletaListiniACC = response.body.PCMM_O_LISTA_COMPLETA_ACC;
				}
			}
			output.setNiListiniCC(output.getListiniCC().size());
			output.setNiListiniACC(output.getRapportiACC().size());
			output.setCdEsito(CondizioniContoUtils.ESITO_OK);
			output.setMsgEsito("OK");
			
			//U0K3263 RE 25_11_2020
			output.setPromozioni(new ArrayList<>());
			List<com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.Promozione> promozioniBridge= response.body.PCMM_O_TAB_OUTPRM!=null?response.body.PCMM_O_TAB_OUTPRM:new ArrayList<>();
			promozioniBridge.forEach(promo->{
				Promozione p=new Promozione();
				p.setCdPromoMulti(promo.getPCMM_O_COD_PROMO_MULTI());
				p.setDsTitoloPromoMulti(promo.getPCMM_O_TITOLO_PROMO_MULTI());
				p.setCdRappCategoriaMulti(promo.getPCMM_O_COD_CAT_RAPP_MULTI());
				p.setCdRappContoMulti(promo.getPCMM_O_COD_PROG_RAPP_MULTI());
				p.setCdRappFilialeMulti(promo.getPCMM_O_COD_FIL_RAPP_MULTI());
				p.setDtDecorrenzaPromoMulti(promo.getPCMM_O_DECO_PROMO_MULTI());
				p.setDtScadenzaPromoMulti(promo.getPCMM_O_DECA_PROMO_MULTI());
				output.getPromozioni().add(p);
			});
			//
			
			logger.info("CONTROLLO TIPO CONTO RESPONSE:\n" + gson.toJson(output));
			return output;
		}catch(Exception e) {
			e.printStackTrace();
			ControlloTipoContoResponse output = new ControlloTipoContoResponse();
			output.setCdEsito(CondizioniContoUtils.ESITO_KO);
			output.setMsgEsito(e.getMessage());
			logger.info("CONTROLLO TIPO CONTO RESPONSE:\n" + gson.toJson(output));
			return output;
		}
	}
	
	// restituisce dati mockati
	private ControlloTipoContoResponse getMockedResponse() {
		ControlloTipoContoResponse mock = new ControlloTipoContoResponse();
		mock.setCdConvenzioneAde("");
		mock.setCdConvenzioneRif("");
		mock.setCdEsito("00");
		mock.setMsgEsito("OK");
		mock.setCdPrdotto("");
		mock.setCdPromozione("");
		mock.setCdTipoConto("");
		mock.setDsConvenzione("");
		mock.setFlCruscotto("");
		
		List<ListinoContoCorrente> listini = new ArrayList<ListinoContoCorrente>();
		ListinoContoCorrente listinoCC = new ListinoContoCorrente();
		listinoCC.setCdProgrLegame("1");
		listinoCC.setDtDecorrenza("20190101");
		listinoCC.setCdCnvLivAppl("");
		listinoCC.setCdCondizione("");
		listinoCC.setCdDivisa("");
		listinoCC.setCdListino("K001217");
		listinoCC.setCdServizio("CC");
		listinoCC.setDtScadenza("99991231");
		listini.add(listinoCC);
		
		ListinoContoCorrente listinoCC2 = new ListinoContoCorrente();
		listinoCC2.setCdProgrLegame("1");
		listinoCC2.setDtDecorrenza("20190101");
		listinoCC2.setCdCnvLivAppl("");
		listinoCC2.setCdCondizione("");
		listinoCC2.setCdDivisa("");
		listinoCC2.setCdListino("K001220");
		listinoCC2.setCdServizio("CC");
		listinoCC2.setDtScadenza("99991231");
		listinoCC2.setNrValoreConvenzione(new BigDecimal(0));
		listini.add(listinoCC2);
		
		ListinoContoCorrente listinoCC3 = new ListinoContoCorrente();
		listinoCC3.setCdProgrLegame("1");
		listinoCC3.setDtDecorrenza("20190101");
		listinoCC3.setCdCnvLivAppl("");
		listinoCC3.setCdCondizione("");
		listinoCC3.setCdDivisa("");
		listinoCC3.setCdListino("K001220");
		listinoCC3.setCdServizio("CC");
		listinoCC3.setDtScadenza("99991231");
		listinoCC3.setNrValoreConvenzione(new BigDecimal(0));
		listini.add(listinoCC3);
		
		mock.setListiniCC(listini);
		
		List<RapportoAccessorio> rapportiACC = new ArrayList<RapportoAccessorio>(); 
		
		RapportoAccessorio rappACC = new RapportoAccessorio();
		rappACC.setCdRappCategoria("1100");
		rappACC.setCdRappFiliale("00700");
		rappACC.setCdRappConto("00003654");
		rappACC.setCdListinoAcc("K001218");
		rappACC.setCdServizioRapp("SV");
		rappACC.setDtScadenzaAcc("99991231");
		rappACC.setDtDecorrenzaAcc("20190101");
		rappACC.setFlEsposiz("S");
		rappACC.setCdProgrLegameAcc("1");
		
		rapportiACC.add(rappACC);
		mock.setRapportiACC(rapportiACC);
		
		return mock;
	}
	
	private ResponseHostBridge getMockedResponseHostbridge() {
		ResponseHostBridge response = new ResponseHostBridge();
		ResponseBody body = new ResponseBody();
		body.PCMM_O_LISTA_COMPLETA_CC = "N";
		body.PCMM_O_TAB_OUTLST = new ArrayList<com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente>();
		com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente listinoCC1 = new com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente();
		listinoCC1.PCMM_O_COD_LISTINO = "K001217";
		listinoCC1.PCMM_O_COD_SERVIZIO = "CC";
		listinoCC1.PCMM_O_DATA_DECA = "99991231";
		listinoCC1.PCMM_O_DATA_DECO = "20190101";
		listinoCC1.PCMM_O_PROG_LEGAME = 1;
		body.PCMM_O_TAB_OUTLST.add(listinoCC1);
		com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente listinoCC2 = new com.intesasanpaolo.bear.bear_v3.model.controllotipoconto.hostbridge.response.ListinoContoCorrente();
		listinoCC2.PCMM_O_COD_LISTINO = "K001220";
		listinoCC2.PCMM_O_COD_SERVIZIO = "CC";
		listinoCC2.PCMM_O_DATA_DECA = "99991231";
		listinoCC2.PCMM_O_DATA_DECO = "20190101";
		listinoCC2.PCMM_O_PROG_LEGAME = 1;
		body.PCMM_O_TAB_OUTLST.add(listinoCC2);
		response.body = body;
		ResponseHeader header = new ResponseHeader();
		header.RETCODE = 0;
		response.header = header;
		return response;
	}

}
