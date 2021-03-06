package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJDispositivaNotFoundDB2Exception;
import com.intesasanpaolo.bear.cond0.cjdispositiva.exception.CJWebServiceException;
import com.intesasanpaolo.bear.cond0.cjdispositiva.factory.WsRequestFactory;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.RespRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResponseResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ConvenzioniHostService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.CoreConvenzioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
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
	
	protected ISPWebservicesHeaderType ispWebservicesHeaderType;
	
	protected WsRequestFactory wsRequestFactory = new WsRequestFactory();
	
	protected DispositivaRequestDTO dispositivaRequestDTO;
	
	@Override
	public boolean canExecute() {
		return true;
	}
	
	protected NewAccountOutput callGestioneService(String codFunzione, DispositivaRequestDTO dispositivaRequestDTO, AdesioneEntity adesione) {
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

			logger.info("- callGestioneService END");

			NewAccountInput newAccountInput = wsRequestFactory.assemblaRequestGestione(codFunzione, dispositivaRequestDTO, adesione,ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA) ,ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
			
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
	
	
}
