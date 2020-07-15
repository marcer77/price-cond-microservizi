package com.intesasanpaolo.bear.cond0.cjvariazionicons.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.EsitoStampa;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.StampaResponse;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Request;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.FL03Response;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFResponse;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.service.FL03ServiceBS;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.service.T1SFServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StampaCommand extends BaseCommand<StampaResponse> {

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
	protected StampaResponse doExecute() throws Exception {
		
		//chiamata alla BS T1SF
		T1SFRequest t1sfRequest = T1SFRequest.builder().
				ispWebservicesHeaderType(ispWebservicesHeaderType)
				.iCodCatRapp("")
				.iCodFilRapp("")
				.iCodFT("")
				.iCodLingua("")
				.iCQCatRapp("")
				.iCQFilRapp("")
				.iCQNumRapp("")
				.iDataDecorrenzaFido("")
				.iDataRiferimento("")
				.iDataScadenzaFido("")
				.iDivisaFido("")
				.iFirma("")
				.iFunzione("")
				.iImportoFido(20d)
				.iKeyOperazione("")
				.iNrPratica(20)
				.iNrSuperPratica(2)
				.iNumProgRapp("")
				.iProgFido(22)
				.iPropostaComm(23)
				.iPropostaUsura("")
				.iTipoFT("")
				.iTipoOfferta("")
				.build();

		//T1SFResponse t1sfResponse = t1sfServiceBS.callBS(t1sfRequest);

		
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

		
		StampaResponse stampaResponse=new StampaResponse();
		stampaResponse.setDocumento("<xml></xml>");
		stampaResponse.setKeyOper("");
		stampaResponse.setEsitoStampa(new EsitoStampa());
		stampaResponse.getEsitoStampa().setCodErrore("OK");
		stampaResponse.getEsitoStampa().setDescErrore("");
		
		
		return stampaResponse;
	}

}
