package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.FirmatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.PraticaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.RecapitoDTO;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@SpringBootTest
@ActiveProfiles(profiles = "unittests")
@TestPropertySource({"classpath:application-unittests.yml"/*, "classpath:env/settings-dev.yml"*/})
@ContextConfiguration(classes = { CoreTestConfig.class })
@WebAppConfiguration
@EnableWebMvc
public class BaseTest {
	protected final Logger log=org.slf4j.LoggerFactory.getLogger(this.getClass());
	protected String codiceProtocolloTest;
	protected MockMvc mvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	public ISPWebservicesHeaderType mockISPWebservicesHeaderType () {
		ISPWebservicesHeaderType ispWebservicesHeaderType=ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("121")
				.callerCompanyIDCode("01")
				.callerProgramName("121")
				.channelIDCode("")
				.codABI("01025")
				.codUnitaOperativa("00700")
				.customerID("23232")
				.isVirtualUser("false")
				.language("IT")
				.serviceCompanyIDCode("01")
				.serviceID("FL030FLA01")
				.userID("343")
				.transactionId("3434343")
				.timestamp("0")
				.serviceVersion("00").build();
		return ispWebservicesHeaderType;
	}
	
	public  InputStampaDTO buildInputStampaDTO() {
		InputStampaDTO inputStampaDTO=new InputStampaDTO();
		PraticaDTO pratica = new PraticaDTO();
		pratica.setCodPratica("0000655703");
		pratica.setCodPropostaComm("");
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
		intestatarioDTO.setPIVA("12345678901");

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
		
		return inputStampaDTO;
	}
	
}
