package com.intesasanpaolo.bear.cond0.cjvariazionicons.command;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.StampaResponseResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.service.FL03ServiceBS;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.service.T1SFServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StampaCommand extends BaseCommand<StampaResponseResource> {

	@Autowired
	private T1SFServiceBS t1sfServiceBS;

	@Autowired
	private FL03ServiceBS fL03ServiceBS;

	private InputStampaDTO inputStampaDTO;
	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	public StampaCommand(InputStampaDTO inputStampaDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.inputStampaDTO = inputStampaDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	protected StampaResponseResource doExecute() throws Exception {
		//chiamata alla BS T1SF
		T1SFRequest t1sfRequest = T1SFRequest.builder().
				ispWebservicesHeaderType(ispWebservicesHeaderType)
				.iCodCatRapp(inputStampaDTO.getRapporto().getCodCategoria())
				.iCodFilRapp(inputStampaDTO.getRapporto().getCodFiliale())
				.iCodLingua(inputStampaDTO.getInfoStampa().getCodLingua())
				.iDataRiferimento(DateUtils.dateToString(inputStampaDTO.getInfoStampa().getData(),"yyyyMMdd"))
				.iFirma(inputStampaDTO.getInfoStampa().getTipoFirma())
				.iKeyOperazione(inputStampaDTO.getInfoStampa().getKeyOper())
				.iNrPratica(NumberUtils.isDigits(inputStampaDTO.getPratica().getCodPratica())?Integer.valueOf(inputStampaDTO.getPratica().getCodPratica()):null)
				.iNrSuperPratica(NumberUtils.isDigits(inputStampaDTO.getPratica().getCodSuperPratica())?Integer.valueOf(inputStampaDTO.getPratica().getCodSuperPratica()):null)
				.iNumProgRapp(inputStampaDTO.getRapporto().getCodProgressivo())
				.iPropostaComm(StringUtils.isNotEmpty(inputStampaDTO.getPratica().getCodPropostaComm())?Integer.valueOf(inputStampaDTO.getPratica().getCodPropostaComm()):null)
				.iTipoOfferta(inputStampaDTO.getInfoStampa().getTipoOfferta())
				.iTipoStampa(inputStampaDTO.getInfoStampa().getTipoStampa())
				.build();

		T1SFResponse t1sfResponse = t1sfServiceBS.callBS(t1sfRequest);

		String docXML = "";
		
		String returnCode = "";
		
		for(int i=0; i<20; i++) { //Ciclo per un massimo di 20 volte
			
			if("06".equals(returnCode)) { //Esco dal ciclo quando il codice di risposta e' 06
				break;
			}else {
				
				//chiamata alla BS FL03
				FL03Request fl03Request = FL03Request.builder()
						.codApplic("ABC__")
						.codFunzione("UP")
						.codSottoApplic("ORDIN")
						.filler("")
						.keyOper("01U01588620200710CMOD125914")
						.numStrKey(1)
						.ispWebservicesHeaderType(ispWebservicesHeaderType)
						.build();
		
				FL03Response fl03Response = fL03ServiceBS.callBS(fl03Request);
				
				docXML = docXML+fl03Response.getStringaOut(); //Concatenazione delle response
				
				returnCode = fl03Response.getRc();
				if (returnCode.equals(""))
					break;
			}
		}
				
		StampaResponseResource stampaResponseResource=new StampaResponseResource();
		stampaResponseResource.setDocumento(docXML);
		stampaResponseResource.setKeyOper("");
		stampaResponseResource.setEsitoStampaResource(new EsitoStampaResource());
		stampaResponseResource.getEsitoStampaResource().setCodErrore("00");
		stampaResponseResource.getEsitoStampaResource().setDescErrore("");
		
		return stampaResponseResource;
		
	}

}
