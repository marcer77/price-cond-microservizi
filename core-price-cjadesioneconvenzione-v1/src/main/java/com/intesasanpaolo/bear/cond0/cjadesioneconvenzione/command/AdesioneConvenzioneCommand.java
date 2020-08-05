package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.BeneficiBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.InfoCovenantBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.InputStampaBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.StampaOutput;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.InpNDG;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
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
		logger.info(HeaderAttribute.ISP_HEADER_COD_ABI+" "+ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE+" "+ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
		logger.info(HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE+" "+ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
		logger.info(HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID+" "+ispWebservicesHeaderType.getOperatorInfo().getUserID());
		logger.info(HeaderAttribute.ISP_HEADER_TIMESTAMP+" "+ispWebservicesHeaderType.getRequestInfo().getTimestamp());
		logger.info(HeaderAttribute.ISP_HEADER_TRANCACTION_ID+" "+ispWebservicesHeaderType.getRequestInfo().getTransactionId());
		logger.info(HeaderAttribute.ISP_HEADER_APPLICATION_ID+" "+ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
		logger.info(HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE+" "+ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		esitoControlli = dto != null
				&& !StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	@Override
	protected StampaOutput doExecute() throws Exception {

		String abi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);

		// Recupero informazioni superpratica (convenzione)

		List<String> codConvenzione = superPraticaService.recuperaCodConvenzione(abi,
				dto.getPratica().getCodSuperPratica(), dto.getPratica().getCodPratica());
		StampaOutput stampaOutput = new StampaOutput();
		if (codConvenzione != null && codConvenzione.size() == 1) {
			// invocazione VDM GetCovenantPerConvenzione

			String codiceConvenzione = codConvenzione.get(0);

			ReqGetCovenantPerConvenzione getCovPerConRequest = buildRequestGetCovenantPerConvenzione(abi,
					codiceConvenzione);

			List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp = convenzioniHostService
					.getCovenantPerConvenzione(getCovPerConRequest);

			superPraticaService.deleteEntita(abi, dto.getPratica().getCodSuperPratica(),
					dto.getPratica().getCodPratica(), "00003");

			superPraticaService.deleteEntita(abi, dto.getPratica().getCodSuperPratica(),
					dto.getPratica().getCodPratica(), "00004");

			// invocazione VDM GetRequisitiAdesioneConvenzione

			ReqGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzioneRequest = buildRequestGetRequisitiAdesioneConvenzione(
					abi, codiceConvenzione);

			RespGetRequisitiAdesioneConvenzione getReqAdesConResp = convenzioniService
					.getRequisitiAdesioneConvenzione(getRequisitiAdesioneConvenzioneRequest);

			// PCMK registrazione info covenant e benefici
			registrazioneInfoConventantAndBenefici(getCovPerConResp, getReqAdesConResp);

			// T1SJ preparazione stampa
			T1SJRequest t1SJRequest = buildT1SJRequest();
			T1SJResponse t1SJResponse = t1SJServiceBS.callBS(t1SJRequest);

			// chiamata alla BS FL03 - recupero
			String docXML = "";

			String returnCode = "";

			for (int i = 0; i < 20; i++) { // Ciclo per un massimo di 20 volte

				if ("06".equals(returnCode)) { // Esco dal ciclo quando il codice di risposta e' 06
					break;
				} else {

					FL03Request fl03Request = buildFL03Request(t1SJResponse);

					FL03Response fl03Response = fL03ServiceBS.callBS(fl03Request);

					docXML = docXML + fl03Response.getStringaOut(); // Concatenazione delle response

					returnCode = fl03Response.getRc();
				}
			}

			stampaOutput.setDocXML(docXML);
			
			//delete
			String dtade = ServiceUtil.dateToString(new Date(), "yyyyMMdd"); // TODO CHIEDERE FORMATO
			superPraticaService.deleteEntita(abi, dto.getPratica().getCodSuperPratica(),
					dto.getPratica().getCodPratica(), dtade);
			
			//registrazione dati adesione
			registrazioneDatiAdesione(codiceConvenzione);
		} else {
			log.error("Lista presenta " + (codConvenzione != null ? codConvenzione.size() : 0) + " elementi.");
		}

		// TODO: costruire il modello di ritorno
		return stampaOutput;
	}
	
	private void registrazioneDatiAdesione(String codiceConvenzione) {
		
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		
		InputStampaBuilder inputStampaBuilder = new InputStampaBuilder(dto);
		TB59R009 entity = TB59R009.builder()
				.nrSuperpratica(dto.getPratica().getCodSuperPratica())
				.nrPratica(dto.getPratica().getCodPratica())
				.idEntita("DTADE")
				.stato("N")
				.progrEntita(1)
				.progrDati(1)
				.codEntita(codiceConvenzione)
				.datiEntita(inputStampaBuilder.build())
				.tipoAggiornamento("I")
				.codOpeUltModif(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.build();
		superPraticaService.insertEntita(codAbi, entity);
	}

	private void registrazioneInfoConventantAndBenefici(
			List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp,
			RespGetRequisitiAdesioneConvenzione getReqAdesConResp) {

		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);

		if (CollectionUtils.isNotEmpty(getCovPerConResp)) {

			int progEntita = 1;
			for (RespGetCovenantPerConvenzioneCovenantDaAttivare respGetCovenantPerConvenzioneCovenantDaAttivare : getCovPerConResp) {
				InfoCovenantBuilder infoCovenantBuilder = new InfoCovenantBuilder(
						respGetCovenantPerConvenzioneCovenantDaAttivare);
				TB59R009 entity = TB59R009.builder()
						.nrSuperpratica(dto.getPratica().getCodSuperPratica())
						.nrPratica(dto.getPratica().getCodPratica())
						.idEntita("00003")
						.stato("N")
						.progrEntita(progEntita)
						.datiEntita(infoCovenantBuilder.build())
						.tipoAggiornamento("I")
						.codOpeUltModif(ispWebservicesHeaderType.getOperatorInfo().getUserID())
						.build();
				progEntita++;
				superPraticaService.insertEntita(codAbi, entity);
			}

			//TODO IMPLEMENTARE INSERT PER getReqAdesConResp
			List<AdesioneResponseBenefici> benefici=getReqAdesConResp.getTabellaBenefici();
			for (AdesioneResponseBenefici beneficio:benefici) {
				BeneficiBuilder beneficiBuilder = new BeneficiBuilder(beneficio);
				
				TB59R009 entity = TB59R009.builder()
						.nrSuperpratica(dto.getPratica().getCodSuperPratica())
						.nrPratica(dto.getPratica().getCodPratica())
						.idEntita("00003")
						.stato("N")
						.progrEntita(progEntita)
						.datiEntita(beneficiBuilder.build())
						.tipoAggiornamento("I")
						.codOpeUltModif(ispWebservicesHeaderType.getOperatorInfo().getUserID())
						.build();
				progEntita++;
				superPraticaService.insertEntita(codAbi, entity);
				
			}
			
		}else {
			logger.error("La Lista getCovPerConResp e' vuota.");
		}

	}

	private ReqGetCovenantPerConvenzione buildRequestGetCovenantPerConvenzione(String abi, String codConvenzione) {
		ReqGetCovenantPerConvenzione getCovPerConRequest = ReqGetCovenantPerConvenzione.builder().abi(abi)
				.userId(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.applicativoId(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				.dataAdesione(ServiceUtil.dateToString(new Date(), "yyyyMMdd")) // TODO CHIEDERE FORMATO
				.filialeUserId(
						ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				.codConvenzione(codConvenzione).build();
		return getCovPerConRequest;
	}

	private ReqGetRequisitiAdesioneConvenzione buildRequestGetRequisitiAdesioneConvenzione(String abi,
			String codiceConvenzione) {

		ReqGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzioneRequest = ReqGetRequisitiAdesioneConvenzione
				.builder().abi(abi).applicativoId(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				.codiceConvenzione(codiceConvenzione)
				.codiciFiscali(Arrays.asList(dto.getIntestatario().getCodFiscale()))
				.dataAccensione(ServiceUtil.dateToString(dto.getInfoStampa().getData(), "YYYYMMGG")) // TODO CHIEDERE
																										// FORMATO
				.dataAdesione(ServiceUtil.dateToString(dto.getInfoStampa().getData(), "YYYYMMGG")) // TODO CHIEDERE
																									// FORMATO
				.filiale(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA)) // TODO
																															// CHIEDERE
																															// CONFERMA
																															// SE
																															// E'
																															// QUESTO
				.flagTipoCliente(dto.getIntestatario().getSpecieGiur()).ndg(dto.getIntestatario().getNdg())
				.pIva(dto.getIntestatario().getPIva()).rapportoCategoria(dto.getRapporto().getCodCategoria())
				.rapportoCodice(dto.getRapporto().getCodProgressivo())
				.rapportoFiliale(dto.getRapporto().getCodFiliale()).tipoChiamata("?") // TODO DA CHIEDERE
				.userId(ispWebservicesHeaderType.getOperatorInfo().getUserID()).build(); // TODO Da completare

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
		T1SJRequest t1SJRequest = T1SJRequest.builder().ispWebservicesHeaderType(ispWebservicesHeaderType)
				.t1SjICapRes(recapito.getCap()).t1SjIChiamante("")// TODO
				.t1SjICodCatRapp(dto.getRapporto().getCodCategoria())
				.t1SjICodFiscale(dto.getIntestatario().getCodFiscale())
				.t1SjICodiceLingua(dto.getInfoStampa().getCodLingua())
				.t1SjICodUtente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.t1SjIComuneRes(recapito.getComune()).t1SjIDataRiferimento(""/* dto.getInfoStampa().getData() */) // TODO
																													// verificare
																													// formato.
				.t1SjIFilialeOper(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType,
						(ParamList.COD_UNITA_OPERATIVA)))
				.t1SjIFirma(dto.getInfoStampa().getTipoFirma()).t1SjIFrazione(recapito.getFrazione())
				.t1SjIIntestaz(dto.getIntestatario().getIntestazione())
				.t1SjIKeyOperazione(dto.getInfoStampa().getKeyOper())
				.t1SjINdgIntestatario(dto.getIntestatario().getNdg())
				.t1SjINrPratica(dto.getPratica().getCodPratica())
				.t1SjINrSuperpratica(dto.getPratica().getCodSuperPratica())
				.t1SjINumProgRapp(dto.getRapporto().getCodProgressivo()).t1SjIProgStampa(Double.valueOf(0)) // TODO Come
																											// valorizzare
																											// questo
																											// campo? E’
																											// obbligatorio?
																											// In output
																											// alla BS è
																											// presente
																											// un campo
																											// t1SjOProgStampa
																											// che
																											// potrebbe
																											// indicare
																											// il numero
																											// di
																											// chiamate
																											// da
																											// effettuare
																											// alla BS
																											// FL03
				.t1SjIPropostaComm((StringUtils.isNotEmpty(dto.getPratica().getCodPropostaComm()) ? dto.getPratica().getCodPropostaComm() : ""))
				.t1SjIProvRes(recapito.getProvincia()).t1SjISpecieGiu(dto.getIntestatario().getSpecieGiur())
				.t1SjITipoOfferta(dto.getInfoStampa().getTipoOfferta())
				.t1SjITipoStampa(dto.getInfoStampa().getTipoStampa()).t1SjIViaRes(recapito.getIndirizzo())
				.inpNDGList(inpNDGList).build();
		return t1SJRequest;
	}

	private FL03Request buildFL03Request(T1SJResponse t1SJResponse) {
		FL03Request fl03Request = FL03Request.builder().codApplic("ABC__").codFunzione("UP").codSottoApplic("ORDIN")
				.filler("").keyOper(t1SJResponse.getT1SjOKeyOperazione()).numStrKey(1)
				.ispWebservicesHeaderType(ispWebservicesHeaderType).build();

		return fl03Request;
	}

}
