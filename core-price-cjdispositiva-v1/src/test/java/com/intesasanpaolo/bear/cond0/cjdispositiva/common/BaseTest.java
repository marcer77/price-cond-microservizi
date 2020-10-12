package com.intesasanpaolo.bear.cond0.cjdispositiva.common;

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
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@SpringBootTest
@ActiveProfiles(profiles = "unittests")
@TestPropertySource({"classpath:application-unittests.yml"})
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

}
