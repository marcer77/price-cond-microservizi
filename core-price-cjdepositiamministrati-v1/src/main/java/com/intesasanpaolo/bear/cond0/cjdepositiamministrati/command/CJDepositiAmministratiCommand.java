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
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBRequest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBResponse;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBResponseRigheDiStampa;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBRequest;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBResponse;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.model.ctg.wkib.WKIBResponseRigheDiStampa;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.CondizioneStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.IntestazioneStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.NotaStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.PromozioneStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.RigheDiStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.StampaResponseResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.TitoloStampaResource;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.service.ctg.WKIBServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDepositiAmministratiCommand extends BaseCommand<StampaResponseResource> {

	private Logger log = Logger.getLogger(CJDepositiAmministratiCommand.class);
	
	private StampaRequestDTO stampaRequestDTO;
	
	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	
	@Autowired
	private WKIBServiceBS wkibServiceBS;
	
	@Override
	protected StampaResponseResource doExecute() throws Exception {
		log.info("execute START");
		
		StampaResponseResource stampaResponseResource = new StampaResponseResource();
		
		stampaResponseResource.setEsitoStampaResource(new EsitoStampaResource("00", ""));
		
		stampaResponseResource = buildStampaResponseResource(stampaResponseResource);
		
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
	
	private StampaResponseResource buildStampaResponseResource(StampaResponseResource stampaResponseResource) {
		log.info("buildStampaResponseResource START");

			WKIBResponse wkibResponse = null;
			wkibResponse = wkibServiceBS.callBS(buildWKIBRequest());
						
			stampaResponseResource = StampaResponseResource.builder().esitoStampaResource(new EsitoStampaResource(wkibResponse.getCodErrore(),wkibResponse.getMsgErrore()))
			.codDDS(wkibResponse.getCodDDS())
			.codTemplate(wkibResponse.getCodTemplate())
			.righe(new ArrayList<RigheDiStampaResource>())
			.build();
		
			if(CollectionUtils.isNotEmpty(wkibResponse.getElenco())) {
				for(WKIBResponseRigheDiStampa riga : wkibResponse.getElenco()) {
					
					RigheDiStampaResource rigaStampa = new RigheDiStampaResource();
					
					rigaStampa.setPrgStp(riga.getPrgStp());
					rigaStampa.setPrgStrut(riga.getPrgStrut());
					rigaStampa.setTipoStrut(riga.getTipoStrut());
					rigaStampa.setFlContinua(riga.getFlContinua());
					
					if("C".equals(riga.getTipoStrut())) {
						rigaStampa.setIntestazione(IntestazioneStampaResource.builder()
								.testo1(riga.getTesto1())
								.testo2(riga.getTesto2())
								.testo3(riga.getTesto3())
								.testo4(riga.getTesto4())
								.build());
					}
					if("T".equals(riga.getTipoStrut())) {
						rigaStampa.setTitolo(TitoloStampaResource.builder().testo(riga.getTesto()).build());
					}
					if("Y".equals(riga.getTipoStrut())) {
						rigaStampa.setCondizione(CondizioneStampaResource.builder()
								.codCond(riga.getCodCond())
								.dataDeco(riga.getDataDeco())
								.descrCond(riga.getDescrCond())
								.valore(riga.getValore())
								.indNota(riga.getIndNota())
								.build());
					}
					if("N".equals(riga.getTipoStrut())) {
						rigaStampa.setNota(NotaStampaResource.builder().num(riga.getNum()).testo(riga.getTestoNota()).build());
					}
					if("M".equals(riga.getTipoStrut())) {
						rigaStampa.setPromozione(PromozioneStampaResource.builder().testo(riga.getTestoPromozione()).build());
					}
					stampaResponseResource.getRighe().add(rigaStampa);
				}
				
			}
			
		log.info("buildStampaResponseResource END");
		return stampaResponseResource;
	}

	private WKIBRequest buildWKIBRequest() {
		log.info("buildWKIBRequest START");
		String codAbi = ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI);
		String userId = ispWebservicesHeaderType.getOperatorInfo().getUserID();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(stampaRequestDTO.getInfoStampa().getData());
		cal.add(Calendar.YEAR, 5);
		Date dataFine = cal.getTime();
		
		WKIBRequest wkibRequest = WKIBRequest.builder()
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
	
}
