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

import com.intesasanpaolo.bear.cond0.cj.lib.result.WarningResult;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.HeaderAttribute;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.factory.AdesioneConvenzioneFactory;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.AdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.StampaOutput;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.InpNDG;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJRequest;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ctg.T1SJResponse;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetCovenantPerConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.ReqGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.resource.StampaResponseResource;
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
public class AdesioneConvenzioneCommand extends BaseCommand<StampaResponseResource> {

	private Logger log = Logger.getLogger(AdesioneConvenzioneCommand.class);

	@Autowired
	private AdesioneConvenzioneFactory adesioneConvenzioneFactory;

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

	private String codAbi;

	public AdesioneConvenzioneCommand(InputStampaDTO inputStampaDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = inputStampaDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		/*boolean esitoControlli = false;
		logger.info(HeaderAttribute.ISP_HEADER_COD_ABI + " " + ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
		logger.info(HeaderAttribute.ISP_HEADER_CALLER_COMPANY_ID_CODE + " " + ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
		logger.info(HeaderAttribute.ISP_HEADER_SERVICE_COMPANY_ID_CODE + " " + ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
		logger.info(HeaderAttribute.ISP_HEADER_OPERATOR_INFO_USER_ID + " " + ispWebservicesHeaderType.getOperatorInfo().getUserID());
		logger.info(HeaderAttribute.ISP_HEADER_TIMESTAMP + " " + ispWebservicesHeaderType.getRequestInfo().getTimestamp());
		logger.info(HeaderAttribute.ISP_HEADER_TRANCACTION_ID + " " + ispWebservicesHeaderType.getRequestInfo().getTransactionId());
		logger.info(HeaderAttribute.ISP_HEADER_APPLICATION_ID + " " + ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
		logger.info(HeaderAttribute.ISP_HEADER_CHANNEL_ID_CODE + " " + ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		esitoControlli = dto != null && !StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("canExecute END - " + esitoControlli);
		return esitoControlli;*/
		return true;
	}

	@Override
	protected StampaResponseResource doExecute() {
		log.info("doExecute START");
		
		StampaResponseResource stampaResponseResource=new StampaResponseResource();
		StampaOutput stampaOutput = new StampaOutput();

		codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);

		// Recupero informazioni superpratica (convenzione)
		String codiceConvenzione = superPraticaService.recuperaCodConvenzione(codAbi, dto.getPratica().getCodSuperPratica(), dto.getPratica().getCodPratica());

		logger.info("doExecute Recuperato codConvenzione {}", codiceConvenzione);

		
		List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp = null;
		RespGetRequisitiAdesioneConvenzione getReqAdesConResp = null;
		
		boolean codiceConvenzioneFound = StringUtils.isNotEmpty(codiceConvenzione);
		if(codiceConvenzioneFound) {

			// invocazione VDM GetCovenantPerConvenzione
			ReqGetCovenantPerConvenzione getCovPerConRequest = buildRequestGetCovenantPerConvenzione(codAbi, codiceConvenzione);
			getCovPerConResp = convenzioniHostService.getCovenantPerConvenzione(getCovPerConRequest);

			// invocazione VDM GetRequisitiAdesioneConvenzione
			ReqGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzioneRequest = buildRequestGetRequisitiAdesioneConvenzione(codAbi, codiceConvenzione);
			getReqAdesConResp = convenzioniService.getRequisitiAdesioneConvenzione(getRequisitiAdesioneConvenzioneRequest);

		}
		
		//Nel caso il codice convenzione non è stato trovato, verrà inserito solo il record con ID_ENTITA=’DTADE’
		AdesioneConvenzione adesioneConvenzione = adesioneConvenzioneFactory.createAdesioneConvenzione(ispWebservicesHeaderType, dto, getCovPerConResp,
				getReqAdesConResp, codiceConvenzione);

		this.superPraticaService.inserisciAdesioneConvenzione(adesioneConvenzione);

		String docXML = null;
		String codiceErrore = null;
		String descErrore = null;		

		if(codiceConvenzioneFound) {
			// T1SJ preparazione stampa
			T1SJResponse t1SJResponse = preparazioneStampa();

			codiceErrore = t1SJResponse.getT1SjOReturnCode();  
			logger.debug("T1SJ response: " + t1SJResponse);
			
			if("00".equalsIgnoreCase(codiceErrore)) {
				// chiamata alla BS FL03 - recupero
				docXML = generazioneXML(t1SJResponse, stampaOutput);
				stampaOutput.setDocXML(docXML);
			}else {
				codiceErrore = "04";
				descErrore = "Nessuna stampa da produrre";
			}

		}else {
			codiceErrore = "04";
			descErrore = "Nessuna convezione associata";
		}
		
		stampaResponseResource.setDocumento(docXML);
		stampaResponseResource.setKeyOper(dto.getInfoStampa().getKeyOper());
		stampaResponseResource.setEsitoStampaResource(new EsitoStampaResource());
		stampaResponseResource.getEsitoStampaResource().setCodErrore(codiceErrore!=null?codiceErrore:"00");
		stampaResponseResource.getEsitoStampaResource().setDescErrore(descErrore!=null?descErrore:"");
		
		return stampaResponseResource;
	}

	private String generazioneXML(T1SJResponse t1SJResponse, StampaOutput stampaOutput) {
		log.info("generazioneXML START");
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
		log.info("generazioneXML END docXML generato: " + docXML);

		return docXML;
	}

	private T1SJResponse preparazioneStampa() {
		log.info("preparazioneStampa START");
		T1SJRequest t1SJRequest = buildT1SJRequest();
		T1SJResponse t1SJResponse = t1SJServiceBS.callBS(t1SJRequest);
		log.info("preparazioneStampa END");
		return t1SJResponse;
	}

	/**
	 * 
	 * @param abi
	 * @param codConvenzione
	 * @return
	 */
	private ReqGetCovenantPerConvenzione buildRequestGetCovenantPerConvenzione(String abi, String codConvenzione) {
		log.info("buildRequestGetCovenantPerConvenzione START");
		ReqGetCovenantPerConvenzione getCovPerConRequest = ReqGetCovenantPerConvenzione.builder()
				.userId(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.applicativoId(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				.abi(abi)
				.dataAdesione(DateUtils.dateToString(new Date(),DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
				.filialeUserId(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				.codConvenzione(codConvenzione)
				.build();
		log.info("buildRequestGetCovenantPerConvenzione END");
		return getCovPerConRequest;
	}

	private ReqGetRequisitiAdesioneConvenzione buildRequestGetRequisitiAdesioneConvenzione(String abi, String codiceConvenzione) {
		log.info("buildRequestGetRequisitiAdesioneConvenzione START");
		ReqGetRequisitiAdesioneConvenzione getRequisitiAdesioneConvenzioneRequest = ReqGetRequisitiAdesioneConvenzione.builder()
				.abi(abi)
				.applicativoId(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				.codiceConvenzione(codiceConvenzione)
				.dataAccensione(DateUtils.dateToString(dto.getInfoStampa().getData(), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID)) 
				.dataAdesione(DateUtils.dateToString(dto.getInfoStampa().getData(), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
				.filiale(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				.tipoChiamata("2") 
				.rol("S")
				.userId(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.build();
		log.info("buildRequestGetRequisitiAdesioneConvenzione END");
		return getRequisitiAdesioneConvenzioneRequest;
	}

	private T1SJRequest buildT1SJRequest() {
		log.info("buildT1SJRequest START");
		RecapitoDTO recapito = dto.getIntestatario().getRecapiti().get(0);

		List<InpNDG> inpNDGList = new ArrayList<>();

		if (CollectionUtils.isNotEmpty(dto.getFirmatari())) {
			for (FirmatarioDTO firmatario : dto.getFirmatari()) {
				inpNDGList.add(InpNDG.builder().t1SjIIntestazFirma(firmatario.getIntestazione()).t1SjINdgFirma(firmatario.getNdg()).build());
			}
		}
		
		T1SJRequest t1SJRequest = T1SJRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.t1SjICapRes(recapito.getCap())
				.t1SjIChiamante(dto.getCodAppl())
				.t1SjICodCatRapp(dto.getRapporto().getCodCategoria())
				.t1SjICodFiscale(StringUtils.isEmpty(dto.getIntestatario().getCodFiscale()) ? dto.getIntestatario().getPIVA() : dto.getIntestatario().getCodFiscale())
				.t1SjICodiceLingua(dto.getInfoStampa().getCodLingua())
				.t1SjICodUtente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.t1SjIComuneRes(recapito.getComune())
				.t1SjIDataRiferimento(DateUtils.dateToString(dto.getInfoStampa().getData(), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID)) 																							
				.t1SjIFilialeOper(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, (ParamList.COD_UNITA_OPERATIVA)))
				.t1SjIFirma(dto.getInfoStampa().getTipoFirma())
				.t1SjIFrazione(recapito.getFrazione())
				.t1SjIIntestaz(dto.getIntestatario().getIntestazione())
				.t1SjIKeyOperazione(dto.getInfoStampa().getKeyOper())
				.t1SjINdgIntestatario(dto.getIntestatario().getNdg())
				.t1SjINrPratica(dto.getPratica().getCodPratica())
				.t1SjINrSuperpratica(dto.getPratica().getCodSuperPratica())
				.t1SjINumProgRapp(dto.getRapporto().getCodProgressivo())
				.t1SjIProgStampa(Double.valueOf(0))
				.t1SjIPropostaComm((StringUtils.isNotEmpty(dto.getPratica().getCodPropostaComm()) ? dto.getPratica().getCodPropostaComm() : ""))
				.t1SjIProvRes(recapito.getProvincia())
				.t1SjISpecieGiu(dto.getIntestatario().getSpecieGiur())
				.t1SjITipoOfferta(dto.getInfoStampa().getTipoOfferta())
				.t1SjITipoStampa(dto.getInfoStampa().getTipoStampa())
				.t1SjIViaRes(recapito.getIndirizzo())
				.t1SjIFunzione(dto.getCodProcesso())
				.t1SjICodFilRapp(dto.getRapporto().getCodFiliale())
				.inpNDGList(inpNDGList).build();
		log.info("buildT1SJRequest END");
		return t1SJRequest;
	}

	private FL03Request buildFL03Request(T1SJResponse t1SJResponse) {
		log.info("buildFL03Request START");
		FL03Request fl03Request = FL03Request.builder().codApplic("ABC__").codFunzione("UP").codSottoApplic("ORDIN").filler("")
				.keyOper(t1SJResponse.getT1SjOKeyOperazione()).numStrKey(1).ispWebservicesHeaderType(ispWebservicesHeaderType).build();
		log.info("buildFL03Request END");
		return fl03Request;
	}

}
