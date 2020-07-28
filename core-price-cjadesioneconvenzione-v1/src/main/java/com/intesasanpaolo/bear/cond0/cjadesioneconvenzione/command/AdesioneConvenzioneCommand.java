package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.StampaOutput;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.SuperPraticaRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.SuperPraticaResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.InpNDG;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ConvenzioniService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.SuperPraticaService;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ctg.FL03ServiceBS;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.service.ctg.T1SJServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdesioneConvenzioneCommand extends BaseCommand<StampaOutput> {

	private Logger log = Logger.getLogger(AdesioneConvenzioneCommand.class);

	@Autowired
	private SuperPraticaService superPraticaService;

	@Autowired
	private ConvenzioniHostService convenzioniHostService;

	@Autowired
	private ConvenzioniService convenzioniService;

	@Autowired
	private T1SJServiceBS t1SJServiceBS;

	@Autowired
	private FL03ServiceBS fL03ServiceBS;

	private InputStampaDTO dto;
	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	public AdesioneConvenzioneCommand(InputStampaDTO inputStampaDTO,
			ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = inputStampaDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;
		esitoControlli = dto != null && ispWebservicesHeaderType != null;
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	@Override
	protected StampaOutput doExecute() throws Exception {

		// Recupero informazioni superpratica (convenzione)
		SuperPraticaRequest superPraticaRequest = new SuperPraticaRequest();
		SuperPraticaResponse superPraticaResponse = superPraticaService.recuperaInfoSuperPratica(superPraticaRequest);

		String abi =ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);

		//invocazione VDM GetCovenantPerConvenzione

		ReqGetCovenantPerConvenzione getCovPerConRequest = buildRequestGetCovenantPerConvenzione(abi,superPraticaResponse);
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp = convenzioniHostService.getCovenantPerConvenzione(getCovPerConRequest);

		//invocazione VDM GetRequisitiAdesioneConvenzione 

		ReqGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzioneRequest = buildRequestGetRequisitiAdesioneConvenzione(abi,superPraticaResponse,getCovPerConResp);
		RespGetRequisitiAdesioneConvenzione getReqAdesConResp = convenzioniService.getRequisitiAdesioneConvenzione(getRequisitiAdesioneConvenzioneRequest);


		//PCMK   registrazione info covenant e benefici

		superPraticaService.salvaInfoCovenantAndBenefici();

		//T1SJ   preparazione stampa
		T1SJRequest t1SJRequest = buildT1SJRequest();
		T1SJResponse t1SJResponse = t1SJServiceBS.callBS(t1SJRequest);


		//chiamata alla BS FL03 - recupero
		FL03Request fl03Request = buildFL03Request(t1SJResponse);

		FL03Response fl03Response = fL03ServiceBS.callBS(fl03Request);

		StampaOutput stampaOutput = new StampaOutput();
		// TODO: costruire il modello di ritorno
		return stampaOutput;
	}

	private ReqGetCovenantPerConvenzione buildRequestGetCovenantPerConvenzione(String abi,SuperPraticaResponse superPraticaResponse) {
		ReqGetCovenantPerConvenzione getCovPerConRequest = ReqGetCovenantPerConvenzione.builder()
				.abi(abi)
				.userId(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.filialeUserId("?")
				.rapportoCategoria("?")
				.rapportoAbi("?")
				.rapportoConto("?")
				.rapportoFiliale("?")
				.applicativoId("?")
				.build();//TODO Da completare

		return getCovPerConRequest;
	}

	private ReqGetRequisitiAdesioneConvenzione buildRequestGetRequisitiAdesioneConvenzione(String abi,SuperPraticaResponse superPraticaResponse,List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp) {
		ReqGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzioneRequest = ReqGetRequisitiAdesioneConvenzione
				.builder()
				.abi(abi)
				.applicativoId("")
				.build(); //TODO Da completare

		return getRequisitiAdesioneConvenzioneRequest;
	}

	private T1SJRequest buildT1SJRequest() {

		RecapitoDTO recapito = dto.getIntestatario().getRecapiti().get(0);

		List<InpNDG> inpNDGList = new ArrayList<>();

		if (CollectionUtils.isNotEmpty(dto.getFirmatari())) {
			for (FirmatarioDTO firmatario : dto.getFirmatari()) {
				inpNDGList.add(InpNDG.builder().t1SjIIntestazFirma(firmatario.getIntestazione())
						.t1SjINdgFirma(firmatario.getNdg()).build());
			}
		}
		T1SJRequest t1SJRequest = T1SJRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.t1SjICapRes(recapito.getCap()) 
				.t1SjIChiamante("")//TODO
				.t1SjICodCatRapp(dto.getRapporto().getCodCategoria())
				.t1SjICodFiscale(dto.getIntestatario().getCodFiscale())
				.t1SjICodiceLingua(dto.getInfoStampa().getCodLingua())
				.t1SjICodUtente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.t1SjIComuneRes(recapito.getComune())
				.t1SjIDataRiferimento(""/*dto.getInfoStampa().getData()*/) //TODO verificare formato.
				.t1SjIFilialeOper(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, (ParamList.COD_UNITA_OPERATIVA)))
				.t1SjIFirma(dto.getInfoStampa().getTipoFirma())
				.t1SjIFrazione(recapito.getFrazione())
				.t1SjIIntestaz(dto.getIntestatario().getIntestazione())
				.t1SjIKeyOperazione(dto.getInfoStampa().getKeyOper())
				.t1SjINdgIntestatario(dto.getIntestatario().getNdg())
				.t1SjINrPratica(Double.valueOf(dto.getPratica().getCodPratica()))
				.t1SjINrSuperpratica(Double.valueOf(dto.getPratica().getCodSuperPratica()))
				.t1SjINumProgRapp(dto.getRapporto().getCodProgressivo())
				.t1SjIProgStampa(Double.valueOf(0)) //TODO Come valorizzare questo campo? E’ obbligatorio? In output alla BS è presente un campo t1SjOProgStampa che potrebbe indicare il numero di chiamate da effettuare alla BS FL03 
				.t1SjIPropostaComm(Double.valueOf(dto.getPratica().getCodPropostaComm()))
				.t1SjIProvRes(recapito.getProvincia())
				.t1SjISpecieGiu(dto.getIntestatario().getSpecieGiur())
				.t1SjITipoOfferta(dto.getInfoStampa().getTipoOfferta())
				.t1SjITipoStampa(dto.getInfoStampa().getTipoStampa())
				.t1SjIViaRes(recapito.getIndirizzo())
				.inpNDGList(inpNDGList )
				.build();

		return t1SJRequest;
	}

	private FL03Request buildFL03Request(T1SJResponse t1SJResponse) {
		FL03Request fl03Request = FL03Request.builder()
				.codApplic("ABC__")
				.codFunzione("UP")
				.codSottoApplic("ORDIN")
				.filler("")
				.keyOper(t1SJResponse.getT1SjOKeyOperazione())
				.numStrKey(1)
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.build();
		return fl03Request;
	}
}
