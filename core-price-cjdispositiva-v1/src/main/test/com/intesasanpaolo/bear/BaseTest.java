package com.intesasanpaolo.bear;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.config.TestConfiguration;
import com.intesasanpaolo.bear.error.cache.BearRemoteErrorCache;

import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("unittests")
@ContextConfiguration(classes = { TestConfiguration.class })
public abstract class BaseTest {

	protected static final Logger logger = LoggerUtils.getLogger(BaseTest.class);

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	BearRemoteErrorCache bearRemoteErrorCache;

	// GET
	protected void getTestApplicationJson(String URI, String jsonLineTest, MediaType mediaType) throws Exception {
		mockMvc.perform(get(URI).accept(mediaType)).andExpect(content().json(jsonLineTest)).andExpect(status().isOk());
	}

	protected void getTestIsStatusOk(String URI, MediaType mediaType) throws Exception {
		mockMvc.perform(get(URI).accept(mediaType)).andExpect(status().isOk());
	}

	// POST
	protected void postTestIsStatusCreated(String URI, String requestJson, MediaType mediaType) throws Exception {
		mockMvc.perform(post(URI).contentType(mediaType).content(requestJson)).andExpect(status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
