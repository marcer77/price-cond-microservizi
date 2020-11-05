package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.DatiIntestatarioTrasparenza;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.PropostaEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJRequest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ctg.WKCJResponse;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.DBCond0Service;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.RecuperoInformazioniService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ctg.WKCJServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

public class CJDispositivaCommand extends BaseCommand<EsitoResponseResource> {



	@Autowired
	protected GestioneService gestioneService;

	@Autowired
	protected ConvenzioniHostService convenzioniHostService;

	@Autowired
	protected CoreConvenzioneService coreConvenzioneService;

	@Autowired
	protected ProposteCJPOSWSService proposteCJPOSWSService;

	@Autowired
	protected WKCJServiceBS wkcjServiceBS;

	protected ISPWebservicesHeaderType ispWebservicesHeaderType;

	protected WsRequestFactory wsRequestFactory = new WsRequestFactory();

	protected DispositivaRequestDTO dispositivaRequestDTO;

	@Autowired
	private DBCond0Service dbCond0Service;

	@Autowired
	private RecuperoInformazioniService recuperoInformazioniService;

	@Override
	public boolean canExecute() {
		return true;
	}

	protected NewAccountOutput callGestioneService(String codFunzione, String codPratica,DispositivaRequestDTO dispositivaRequestDTO, AdesioneEntity adesione) {
		logger.info("callGestioneService START codFunzione:{} ", codFunzione);

		HashMap<String, String> headerParams = new HashMap<String, String>();
		//Valorizzare fisso per il momento funziona con PCGESTIXME
		headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceID","PCGESTIXME");

		headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode",
				ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
		headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode",
				ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
		headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI",
				ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI));
		headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa",
				ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA));
		headerParams.put("ISPWebservicesHeader.BusinessInfo.CustomerID",
				ispWebservicesHeaderType.getBusinessInfo().getCustomerID());
		headerParams.put("ISPWebservicesHeader.OperatorInfo.UserID",
				ispWebservicesHeaderType.getOperatorInfo().getUserID());
		headerParams.put("ISPWebservicesHeader.RequestInfo.Language",
				ispWebservicesHeaderType.getRequestInfo().getLanguage());
		//Valorizzare fisso per il momento funziona con 0
		headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceVersion","0");
		headerParams.put("ISPWebservicesHeader.RequestInfo.Timestamp",
				ispWebservicesHeaderType.getRequestInfo().getTimestamp() + "");
		headerParams.put("ISPWebservicesHeader.RequestInfo.TransactionId",
				ispWebservicesHeaderType.getRequestInfo().getTransactionId());
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.ApplicationID",
				ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.CallerProgramName",
				ispWebservicesHeaderType.getTechnicalInfo().getCallerProgramName());
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode",
				ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		headerParams.put("ISPWebservicesHeader.TechnicalInfo.CallerServerName",
				ispWebservicesHeaderType.getTechnicalInfo().getCallerServerName());

		logger.info("- callGestioneService END");

		NewAccountInput newAccountInput = wsRequestFactory.assemblaRequestGestione(codFunzione, codPratica ,dispositivaRequestDTO, adesione,ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA) ,ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());

		NewAccountOutput newAccountOutput = gestioneService.gestione(newAccountInput, headerParams);

		if(!"00".equals(newAccountOutput.getOutput().getDatiDebug().getReturnCode())) {
			throw CJWebServiceException.builder().webServiceName("WsGestione").codiceErroreWebService(newAccountOutput.getOutput().getDatiDebug().getReturnCode())
			.descrErroreWebService(newAccountOutput.getOutput().getDatiDebug().getTxTMessaggio()).build();
		}

		return newAccountOutput;

	}

	protected List<CovenantEntity> recuperaInfoCovenantDaAttivare(String codAbi, List<CovenantEntity> covenantDaAttivare) {
		logger.info("START recuperaInfoCovenantDaAttivare");
		for(CovenantEntity covenantEntity : covenantDaAttivare) {
			List<String> livelloGerarchia = coreConvenzioneService.getLivelloGerarchia(codAbi, covenantEntity.getCodCondizione());
			logger.info("livelloGerarchia: "+livelloGerarchia);
			if(CollectionUtils.isNotEmpty(livelloGerarchia)) {
				if("1".equals(livelloGerarchia.get(0))) {
					List<String> stringaElencoCondizioniFiglie = coreConvenzioneService.getCondizioniFiglie(codAbi, covenantEntity.getCodCondizione());
					if(CollectionUtils.isNotEmpty(stringaElencoCondizioniFiglie) && stringaElencoCondizioniFiglie.get(0)!=null) {
						logger.info("elencoCondizioniFiglie: "+stringaElencoCondizioniFiglie.get(0));
						covenantEntity.setCondizioniFiglie(stringaElencoCondizioniFiglie.get(0));
					}else {
						throw CJDispositivaNotFoundDB2Exception.builder().messaggio("CondizioniFiglie non recuperabili per il covCodCondizione: {}")
						.param(new String[]{covenantEntity.getCodCondizione()}).build();
					}
				}
				covenantEntity.setLivelloGerarchia(livelloGerarchia.get(0));
			}
		}
		logger.info("END recuperaInfoCovenantDaAttivare");
		return covenantDaAttivare;
	}

	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	public void setDispositivaRequestDTO(DispositivaRequestDTO dispositivaRequestDTO) {
		this.dispositivaRequestDTO = dispositivaRequestDTO;
	}

	protected RespRollbackStoreCovenantAdesioneConvenzione callRollbackConvenzioniHostService(AdesioneEntity adesione, List<CovenantEntity> covenantDaAttivare, List<CovenantEntity> covenantDaCessare, String codAbi, String codProcesso, String branchCode , String userId) {
		logger.info("callStoreCovenantAdesioneConvenzione START");
		ReqRollbackStoreCovenantAdesioneConvenzione request = wsRequestFactory.assemblaRequestConvenzione(adesione,covenantDaAttivare, covenantDaCessare, codAbi, codProcesso , branchCode, userId);
		RespRollbackStoreCovenantAdesioneConvenzione resp = convenzioniHostService.rollbackStoreCovenantAdesioneConvenzione(request);
		logger.info("callStoreCovenantAdesioneConvenzione END");
		checkResponseRollbackCovenantAdesioneConvenzione(resp);
		return resp;
	}

	private void checkResponseRollbackCovenantAdesioneConvenzione(RespRollbackStoreCovenantAdesioneConvenzione resp) {
		logger.info("checkResponseRollbackCovenantAdesioneConvenzione START");
		if(resp.getIsHasError().booleanValue()){
			throw CJWebServiceException.builder().webServiceName("RollbackCovenantAdesioneConvenzione").codiceErroreWebService("")
			.descrErroreWebService(resp.getErrorDescription()).build();
		}
		logger.info("checkResponseRollbackCovenantAdesioneConvenzione END");
	}


	protected void invokeWKCJ(ISPWebservicesHeaderType ispWebservicesHeaderType,String codProcesso, String codSuperPratica,String codPratica,String tipoChiamata) {

		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);

		DatiIntestatarioTrasparenza datiIntestarioTrasparenza= this.coreConvenzioneService.getDatiIntestatarioPerTrasparenza(codAbi,codProcesso, codSuperPratica, codPratica);

		boolean isCJDA=CodProcessoEnum.CJ_CUI_DA.toString().equals(codProcesso);

		WKCJRequest wkcjRequest=WKCJRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.dataRifer(datiIntestarioTrasparenza.getTrasparenzaDataRiferimento())
				.lingua("0")
				.utente(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				.terminale("CJDISPOSITIVA")
				.superpratica(codSuperPratica)
				.catSecRapp("0000")
				.partitaRapp(" ")
				.ndg(datiIntestarioTrasparenza.getTrasparenzaNDG())
				.dtDecoRapp(datiIntestarioTrasparenza.getTrasparenzaDataRiferimento())
				.catSecRapAppo("0000")
				.tipoChiamata(tipoChiamata)
				.pratica(isCJDA?codPratica:"")
				.settRapp(isCJDA?"DA":"")
				.filRapp(isCJDA?datiIntestarioTrasparenza.getTrasparenzaFiliale():"")
				.catRapp(isCJDA?datiIntestarioTrasparenza.getTrasparenzaCategoria():"")
				.nroRapp(isCJDA?datiIntestarioTrasparenza.getTrasparenzaNumRapp():"")
				.flBpay("0")
				.build();

		WKCJResponse wkcjResponse=this.wkcjServiceBS.callBS(wkcjRequest);

	}

	protected void annulloPratica(String codAbi, String codPratica, String codSuperPratica, String branchCode, String userId) {
		logger.debug("annulloPratica START codPratica: " + codPratica);
		List<AdesioneEntity> listaAdesioni = coreConvenzioneService.acquisizioneDatiAdesione(codAbi, codPratica , codSuperPratica);
		if(CollectionUtils.isNotEmpty(listaAdesioni)) {

			if( CodProcessoEnum.CJ_AFFIDAMENTI.toString().equalsIgnoreCase(dispositivaRequestDTO.getCodProcesso())) {

				List<PropostaEntity> listaProposte = coreConvenzioneService.getCodiciProposte(codAbi, codSuperPratica,  codPratica);

				if(CollectionUtils.isNotEmpty(listaProposte)) {
					for(PropostaEntity proposta : listaProposte) {
						//annulla proposta sul database oracle COND0
						dbCond0Service.annullaProposta(codAbi, proposta.getAnnoProposta(), proposta.getCodiceProposta());
					}
				}
				coreConvenzioneService.deleteCodiciProposte(codAbi, codSuperPratica,  codPratica);
			}

			List<CovenantEntity> covenantDaAttivare = coreConvenzioneService.getElencoCovenantDaAttivare(codAbi, codPratica , codSuperPratica);
			List<CovenantEntity> covenantDaCessare = coreConvenzioneService.getElencoCovenantDaCessare(codAbi, codPratica , codSuperPratica);

			if(CollectionUtils.isNotEmpty(covenantDaAttivare) || CollectionUtils.isNotEmpty(covenantDaCessare)) {
				if(CollectionUtils.isNotEmpty(covenantDaAttivare) ) {
					covenantDaAttivare = recuperaInfoCovenantDaAttivare(codAbi ,covenantDaAttivare);
				}

				// WS VDM rollback storecovenant
				callRollbackConvenzioniHostService(listaAdesioni.get(0), covenantDaAttivare, covenantDaCessare, codAbi, dispositivaRequestDTO.getCodProcesso(),branchCode , userId);
			}

			// IIB PCK8 PCGESTIXME/Gestione rollback aggiornamento Condizioni
			callGestioneService(CodProcessoEnum.CJ_AFFIDAMENTI.toString().equals(dispositivaRequestDTO.getCodProcesso()) ? "AAF": "ADA", codPratica,dispositivaRequestDTO, listaAdesioni.get(0));

			// BS PCMK aggiorna elenco cod.prop. fittizie
			callAggiornaCodfittizie();
		}
		logger.debug("annulloPratica END codPratica: " + codPratica);
	}

	private boolean callAggiornaCodfittizie() {
		logger.info("callAggiornaCodfittizie START");
		logger.info("callAggiornaCodfittizie END");
		return recuperoInformazioniService.aggiornaCodFittizie();
	}

}
