package com.intesasanpaolo.bear.cond0.cj.lib.exception.handler;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;

import com.intesasanpaolo.bear.cond0.cj.lib.exception.BSException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJGenericBusinessApplication;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutEsi;
import com.intesasanpaolo.bear.cond0.cj.lib.model.OutSeg;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.BSType;
import com.intesasanpaolo.bear.core.resource.BaseResource;
import com.intesasanpaolo.bear.exceptions.resource.ErrorResource;

@RunWith(SpringRunner.class)
public class CJBaseExceptionHandlerTest {
	private CJBaseExceptionHandler<BaseResource> handler = new CJBaseExceptionHandler<BaseResource>() {

		@Override
		public BaseResource errorResponseForCJBaseException(String errorCode, String errorMessage) {
			return new BaseResource();
		}
	};

	@Before
	public void setup() {

	}

	@Test
	public void testHandleCJBaseException01() {

		BSException exc = BSException.builder().bsName(BSType.FL03S00.getCode())
				.outEsi(OutEsi.builder().mdwEsiRetc("0012").mdwEsiAnom("Test Errore").mdwEsiMsg("Test Errore").build())
				.outSeg(OutSeg.builder().livelloSegnalazione("Blocker").txtSegnalazione("E").build()).build();

		ResponseEntity<BaseResource> response = handler.handleCJBaseException(exc);

		assertEquals(HttpStatus.OK, response.getStatusCode());

	}
	
	@Test
	public void testHandleCJBaseException02() {

		BSException exc = BSException.builder().bsName(BSType.FL03S00.getCode())
				.outEsi(OutEsi.builder().mdwEsiRetc(null).mdwEsiAnom(null).mdwEsiMsg(null).build())
				.outSeg(OutSeg.builder().livelloSegnalazione(null).txtSegnalazione(null).build()).build();

		ResponseEntity<BaseResource> response = handler.handleCJBaseException(exc);

		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testHandleExceptionGeneric() {
		CJGenericBusinessApplication ex = CJGenericBusinessApplication.builder().errorCode("1212").message("Errore Generico...").build();
		ResponseEntity<ErrorResource> response = handler.handleExceptionGeneric(ex);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

	}

	@Test
	public void testHandleHttpMessageNotReadableException() {

		HttpMessageNotReadableException ex = new HttpMessageNotReadableException("", new HttpInputMessage() {

			@Override
			public HttpHeaders getHeaders() {
				return null;
			}

			@Override
			public InputStream getBody() throws IOException {
				return null;
			}
		});

		ResponseEntity<ErrorResource> response = handler.handleHttpMessageNotReadableException(ex, null, null);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}

	@Test
	public void testHandleMissingRequestHeaderException() {
		MissingRequestHeaderException exc = new MissingRequestHeaderException("header1", new MethodParameter(String.class.getDeclaredMethods()[0], 0));

		ResponseEntity<ErrorResource> response = handler.handleMissingRequestHeaderException(exc, null, null);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}

	@Test
	public void testHandleMethodArgumentNotValidException() {
		FieldError fieldError = new FieldError("", "test", "test");
		BindingResult bindingResult = new BindException("test", "test");
		bindingResult.addError(fieldError);
		MethodArgumentNotValidException exc = new MethodArgumentNotValidException(new MethodParameter(String.class.getDeclaredMethods()[0], 0), bindingResult);
		ResponseEntity<ErrorResource> response = handler.handleMethodArgumentNotValidException(exc, null, null);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
