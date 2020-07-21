package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.common;

import java.io.IOException;

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



	/*@MockBean
	private GetProtocolloFaseCommand getProtocolloFaseCommandMock;

		

	private void mockProtocolloFase() throws Exception {
		ProtocolloFase pMock = new ProtocolloFase();
		pMock.setStato("IN");
		pMock.setProtocolloWf(codiceProtocolloTest);
		Mockito.when(getProtocolloFaseCommandMock.execute()).thenReturn(pMock);
	}

	public void createDelibera() {
		InitDeliberaDto initDeliberaDto=new InitDeliberaDto();
		String abi="01025";
		String nsg="1234519995125551";
		try {
			initDeliberaDto.setUtenteId("1234567");
			initDeliberaDto.setUtenteCollegato("1234567");
			initDeliberaDto.setCodTipologia("RV");
			initDeliberaDto.setUoProponente("12345");
			String inputJson=mapToJson(initDeliberaDto);
			String uri="/delibera/" + abi + "/" + nsg;
			MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status=mvcResult.getResponse().getStatus();

			log.info("inputJson : {}", inputJson);
			log.info("status = " + status);
			Assert.assertEquals(200, status);

			String content=mvcResult.getResponse().getContentAsString();
			DatiGeneraliDeliberaResource dati=mapFromJson(content, DatiGeneraliDeliberaResource.class);
			log.info("content = {}", content);
			this.codiceProtocolloTest=dati.getCodProtocollo();

		} catch (Exception ex) {
			log.error(ex.getMessage());
			fail("Errore in createDelibera: " + ex.getMessage() + " " + ex.getCause());
		}
	}
	*/
}
