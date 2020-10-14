package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg.transformers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SFS00.C_T1SFS00;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.common.BaseTest;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.dto.RecapitoDTO;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.Inpndg;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.Ndg;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.model.ctg.T1SFRequest;
import com.intesasanpaolo.bear.connector.ctg.request.CtgConnectorRequest;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class T1SFCtgRequestTrasformerTest extends BaseTest{
	
	@MockBean
	private BeanFactory beanFactoryMock;

	@Autowired
	private T1SFCtgRequestTrasformer t1sfCtgRequestTrasformer;
	
	@Test
	public void testTrasform() {
		
		InputStampaDTO inputStampaDTO=new InputStampaDTO();
		PraticaDTO pratica = new PraticaDTO();
		pratica.setCodPratica("0000655703");
		//pratica.setCodPropostaComm("");
		pratica.setCodSuperPratica("0001161961");
		inputStampaDTO.setPratica(pratica);

		inputStampaDTO.setCodAppl("X");
		inputStampaDTO.setCodProcesso("CJCPG");
		
		RapportoDTO rapportoDTO = new RapportoDTO();
		rapportoDTO.setCodFiliale("12345");
		rapportoDTO.setCodCategoria("1234");
		rapportoDTO.setCodProgressivo("12345678");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		IntestatarioDTO intestatarioDTO = new IntestatarioDTO();
		
		intestatarioDTO.setNdg("1234561234560");
		intestatarioDTO.setIntestazione("Intestazione di test");
		intestatarioDTO.setSpecieGiur("PERSO");
		intestatarioDTO.setCodFiscale("RSSMRA80A01H703F");
		intestatarioDTO.setPIva("12345678901");

		ArrayList<RecapitoDTO> recapiti = new ArrayList<RecapitoDTO>();

		RecapitoDTO recapitoDTO = new RecapitoDTO();
		recapitoDTO.setTipo("test tipo");
		recapitoDTO.setIndirizzo("via dei test");
		recapitoDTO.setCap("00000");
		recapitoDTO.setComune("Comune di test");
		recapitoDTO.setFrazione("Frazione di test");
		recapitoDTO.setProvincia("TE");
		recapiti.add(recapitoDTO);

		intestatarioDTO.setRecapiti(recapiti);
		
		inputStampaDTO.setIntestatario(intestatarioDTO);

		ArrayList<FirmatarioDTO> listaFirmatari = new ArrayList<FirmatarioDTO>();

		for (int i = 0; i < 13; i++) {
			listaFirmatari.add(new FirmatarioDTO("1234561234560","Intestazione di test"));
		}

		inputStampaDTO.setFirmatari(listaFirmatari);

		InfoStampaDTO infoStampa = new InfoStampaDTO();
		infoStampa.setData(new Date(System.currentTimeMillis()));
		infoStampa.setTipoStampa("Stampa di test");
		infoStampa.setTipoOfferta("Offerta di test");
		infoStampa.setTipoFirma("Firma di test");
		infoStampa.setCodLingua("Lingua di test");
		infoStampa.setKeyOper("123456789012345678901234567890");
		infoStampa.setData(new Date());
		inputStampaDTO.setInfoStampa(infoStampa);
		
		Mockito.when(beanFactoryMock.getBean(C_T1SFS00.class)).thenReturn(new C_T1SFS00());
		
		ISPWebservicesHeaderType ispWebservicesHeaderType=mockISPWebservicesHeaderType();
		T1SFRequest t1sfRequest = T1SFRequest.builder().
				ispWebservicesHeaderType(ispWebservicesHeaderType)
				.iFunzione("CJAF")
				.iCodLingua(inputStampaDTO.getInfoStampa().getCodLingua())
				.iCodFilRapp(inputStampaDTO.getRapporto().getCodFiliale())
				.iCodCatRapp(inputStampaDTO.getRapporto().getCodCategoria())
				.iNumProgRapp(inputStampaDTO.getRapporto().getCodProgressivo())
				.iDataRiferimento(DateUtils.dateToString(inputStampaDTO.getInfoStampa().getData(),"yyyyMMdd"))
				.iKeyOperazione(inputStampaDTO.getInfoStampa().getKeyOper())
				.iTipoOfferta(inputStampaDTO.getInfoStampa().getTipoOfferta())
				.iNrSuperPratica(NumberUtils.isDigits(inputStampaDTO.getPratica().getCodSuperPratica())?Integer.valueOf(inputStampaDTO.getPratica().getCodSuperPratica()):null)
				.iNrPratica(NumberUtils.isDigits(inputStampaDTO.getPratica().getCodPratica())?Integer.valueOf(inputStampaDTO.getPratica().getCodPratica()):null)
				.iPropostaComm(StringUtils.isNotEmpty(inputStampaDTO.getPratica().getCodPropostaComm())?Integer.valueOf(inputStampaDTO.getPratica().getCodPropostaComm()):null)
				.iFirma(inputStampaDTO.getInfoStampa().getTipoFirma())
				.iTipoStampa(inputStampaDTO.getInfoStampa().getTipoStampa())
				.ndg(
					Ndg.builder()
					.iNdgIntestatario(inputStampaDTO.getIntestatario().getNdg())
					.iIntestaz(inputStampaDTO.getIntestatario().getIntestazione())
					.iCodFiscale(inputStampaDTO.getIntestatario().getCodFiscale())
					.iSpecieGiu(inputStampaDTO.getIntestatario().getSpecieGiur())
					.build()
				)
				.inpndg(
					Inpndg.builder()
					.iNdgFirma(inputStampaDTO.getFirmatari().stream().map(FirmatarioDTO::getNdg).collect(Collectors.toList()))
					.iIntestazFirma(inputStampaDTO.getFirmatari().stream().map(FirmatarioDTO::getIntestazione).collect(Collectors.toList()))
					.build()
				)
				.build();
		
		CtgConnectorRequest<C_T1SFS00> ctgConnectorRequest = t1sfCtgRequestTrasformer.transform(t1sfRequest, null);
		assertTrue(ctgConnectorRequest.getConnectorClient().INPBST[0].I_COD_CAT_RAPP.equals(inputStampaDTO.getRapporto().getCodCategoria()));
	}

}
