package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.command;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.TipoStrutEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.StampaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBRequest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponse;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wknb.WKNBResponseRigheDiStampa;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.CondizioneStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.IntestazioneStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.NotaStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.PromozioneStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.RigheDiStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.StampaResponseResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.TitoloStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.service.ctg.WKNBServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.core.properties.PropertiesManager;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDepositiAmministratiCommand extends BaseCommand<StampaResponseResource> {

	private Logger log = Logger.getLogger(CJDepositiAmministratiCommand.class);
	
	private StampaRequestDTO stampaRequestDTO;
	
	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	
	@Autowired
	private WKNBServiceBS wkibServiceBS;
	
	@Autowired
    private PropertiesManager propertiesManager;
	
	@Override
	protected StampaResponseResource doExecute() throws Exception {
		log.info("execute START");
		
		if(propertiesManager!=null && propertiesManager.get("CALL_MOCK")!=null && "S".equals(propertiesManager.get("CALL_MOCK", String.class, "N"))) {
			logger.info("doExecute CALL MOCKED");
			return buildStampaResponseResourceMock();
		}
		
		StampaResponseResource stampaResponseResource = buildStampaResponseResource();
		
		log.info("execute END");
		return stampaResponseResource;
	}
	
	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		boolean esitoControlli = false;
		esitoControlli = 
				!StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				&& !StringUtils.isEmpty(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_UNITA_OPERATIVA))
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getOperatorInfo().getUserID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getServiceID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getServiceVersion())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getRequestInfo().getTransactionId())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getApplicationID())
				&& !StringUtils.isEmpty(ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
		log.info("canExecute END - " + esitoControlli);
		return esitoControlli;
	}
	
	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	public void setStampaRequestDTO(StampaRequestDTO stampaRequestDTO) {
		this.stampaRequestDTO = stampaRequestDTO;
	}
	
	private StampaResponseResource buildStampaResponseResource() {
		log.info("buildStampaResponseResource START");

		WKNBResponse wkibResponse = wkibServiceBS.callBS(buildWKIBRequest());

		StampaResponseResource stampaResponseResource = StampaResponseResource.builder().esitoStampaResource(new EsitoStampaResource(wkibResponse.getCodErrore(),wkibResponse.getMsgErrore()))
				.codDDS(wkibResponse.getCodDDS())
				.codTemplate(wkibResponse.getCodTemplate())
				.righe(new ArrayList<RigheDiStampaResource>())
				.build();

		if(CollectionUtils.isNotEmpty(wkibResponse.getElenco())) {
			for(WKNBResponseRigheDiStampa riga : wkibResponse.getElenco()) {

				RigheDiStampaResource rigaStampa = new RigheDiStampaResource();

				rigaStampa.setPrgStp(riga.getPrgStp());
				rigaStampa.setPrgStrut(riga.getPrgStrut());
				rigaStampa.setTipoStrut(riga.getTipoStrut());
				rigaStampa.setFlContinua(riga.getFlContinua());
				rigaStampa.setTipoSezione(riga.getTipoSezione());

				if("C".equals(riga.getTipoStrut())) {
					rigaStampa.setIntestazione(IntestazioneStampaResource.builder()
							.testo1(riga.getTesto1())
							.testo2(riga.getTesto2())
							.testo3(riga.getTesto3())
							.testo4(riga.getTesto4())
							.build());
				}
				if("T".equals(riga.getTipoStrut())) {
					rigaStampa.setTitolo(TitoloStampaResource.builder()
							.testo(riga.getTesto())
							.evidTesto(riga.getEvidTesto()).build());
				}
				if("Y".equals(riga.getTipoStrut())) {
					rigaStampa.setCondizione(CondizioneStampaResource.builder()
							.codCond(riga.getCodCond())
							.dataDeco(riga.getDataDeco())
							.evidDataDeco(riga.getEvidDtDeco())
							.descrCond(riga.getDescrCond())
							.evidDescrCond(riga.getEvidDescr())
							.valore(riga.getValore())
							.evidValore(riga.getEvidValore())
							.indNota(riga.getIndNota())
							.evidNota(riga.getEvidNota())
							.build());
				}
				if("N".equals(riga.getTipoStrut())) {
					rigaStampa.setNota(NotaStampaResource.builder()
							.num(riga.getNum())
							.testo(riga.getTestoNota())
							.evidNum(riga.getEvidNrNota())
							.evidTesto(riga.getEvidTxNota())
							.build());
				}
				if("M".equals(riga.getTipoStrut())) {
					rigaStampa.setPromozione(PromozioneStampaResource.builder().testo(riga.getTestoPromozione()).build());
				}
				stampaResponseResource.getRighe().add(rigaStampa);
			}

		}

		stampaResponseResource.setEsitoStampaResource(new EsitoStampaResource("00", ""));
		log.info("buildStampaResponseResource END");
		return stampaResponseResource;
	}

	private WKNBRequest buildWKIBRequest() {
		log.info("buildWKIBRequest START");
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(stampaRequestDTO.getInfoStampa().getData());
		cal.add(Calendar.YEAR, 5);
		Date dataFine = cal.getTime();
		
		WKNBRequest wkibRequest = WKNBRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.tipoFunzione("04")
				.codAbi(codAbi)
				.codDipendente(userId)
				.codFiliale(stampaRequestDTO.getRapporto().getCodFiliale())
				.codCategoria(stampaRequestDTO.getRapporto().getCodCategoria())
				.codProgressivo(stampaRequestDTO.getRapporto().getCodProgressivo())
				.attributi(stampaRequestDTO.getRapporto().getAttributo())
				.ndg(stampaRequestDTO.getIntestatario().getNdg())
				.dataRif(DateUtils.dateToString(stampaRequestDTO.getInfoStampa().getData(), DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
				.codLingua(stampaRequestDTO.getInfoStampa().getCodLingua())
				.tipoStampa(stampaRequestDTO.getInfoStampa().getTipoStampa())
				.dataFine(DateUtils.dateToString(dataFine, DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
				.build();
		log.info("buildWKIBRequest END");
		return wkibRequest;
	}
	
	protected StampaResponseResource buildStampaResponseResourceMock() {
		log.info("mock START");
		StampaResponseResource stampaResponseResource = StampaResponseResource.builder().esitoStampaResource(new EsitoStampaResource("00","")).build();
				
		stampaResponseResource.setCodDDS("codDDS di prova");
		stampaResponseResource.setCodTemplate("Template di prova");
		RigheDiStampaResource riga = new RigheDiStampaResource();
		riga.setPrgStp("123");
		riga.setPrgStrut("1313");
		riga.setTipoStrut(TipoStrutEnum.INTESTAZIONE.toString());
		
		riga.setIntestazione(new IntestazioneStampaResource(stampaRequestDTO.getIntestatario().getIntestazione(), "testo mock2", "testo mock3", "testo mock4"));

		riga.setTitolo(new TitoloStampaResource("titolo mock","1"));
		
		riga.setCondizione(new CondizioneStampaResource("cod mock", DateUtils.dateToString(new Date(), DateUtils.DATE_FORMAT_DD_MM_YYYY_SLASH), "desc cond mock", "valore mock", "nota mock","1","0","1","0"));
		
		riga.setNota(new NotaStampaResource("1", "nota mock","1","0"));
		
		riga.setPromozione(new PromozioneStampaResource("Promozione mock"));
		
		stampaResponseResource.setRighe(new ArrayList<RigheDiStampaResource>());
		stampaResponseResource.getRighe().add(riga);
		log.info("mock END");
		return stampaResponseResource;
	}
}
