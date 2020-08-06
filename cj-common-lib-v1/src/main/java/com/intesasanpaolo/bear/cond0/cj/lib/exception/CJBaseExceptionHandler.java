package com.intesasanpaolo.bear.cond0.cj.lib.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.core.resource.BaseResource;
import com.intesasanpaolo.bear.exceptions.model.BearSeverityEnum;
import com.intesasanpaolo.bear.exceptions.model.ErrorMessage;

public abstract class CJBaseExceptionHandler<T extends BaseResource> {
	private static final Logger logger = LoggerUtils.getLogger(CJBaseExceptionHandler.class);

	public abstract T getBaseResource();

	@ExceptionHandler({ MissingRequestHeaderException.class })
	public ResponseEntity<T> handleMissingRequestHeaderException(MissingRequestHeaderException e,
			HttpServletRequest request, HttpServletResponse response) {

		logger.error(e.getMessage(), e);

		T resource = getBaseResource();
		Map<String, List<ErrorMessage>> map = new HashMap<>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put(BearSeverityEnum.ERROR.name(), list);
		resource.setReturnMessages(map);

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessageTitle(e.getHeaderName());
		errorMessage.setMessage(e.getMessage());
		list.add(errorMessage);

		// throw new BearDomainException("generic.error", "generic.error",
		// HttpStatus.BAD_REQUEST,BearErrorTypeEnum.TECHNICAL,BearSeverityEnum.ERROR);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resource);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<T> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request, HttpServletResponse response) {

		logger.error("handleException {}", e.getMessage(), e);
		T resource = getBaseResource();

		Map<String, List<ErrorMessage>> map = new HashMap<>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put(BearSeverityEnum.ERROR.name(), list);
		resource.setReturnMessages(map);

		BindingResult result = e.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		fieldErrors.forEach(fe -> {
			ErrorMessage errorMessage = new ErrorMessage();
			// errorMessage.setMessageKey("mytest.error");
			errorMessage.setMessage(fe.getDefaultMessage());
			errorMessage.setMessageTitle(fe.getField());

			// MessageForm messageForm=new MessageForm();
			// messageForm.setFieldName(fe.getField());
			// messageForm.setFormName("richiesta");
			// errorMessage.setMessageForm(messageForm);
			list.add(errorMessage);

		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resource);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public ResponseEntity<T> handleInvalidFormatException(HttpMessageNotReadableException e, HttpServletRequest request,
			HttpServletResponse response) {

		logger.error("handleException {}", e.getMessage(), e);
		T resource = getBaseResource();

		//////
		Map<String, List<ErrorMessage>> map = new HashMap<>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put(BearSeverityEnum.ERROR.name(), list);
		resource.setReturnMessages(map);

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessageTitle(e.getClass().getName());
		errorMessage.setMessage(e.getMessage());
		list.add(errorMessage);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resource);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<T> handleExceptionGeneric(Exception e) {
		T resource = getBaseResource();

		logger.error("handleException {}", e.getMessage(), e);
		Map<String, List<ErrorMessage>> map = new HashMap<>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put("ERROR", list);
		resource.setReturnMessages(map);

		ErrorMessage errorMessage = new ErrorMessage();
		// errorMessage.setMessageKey("");
		errorMessage.setMessageTitle("Errore durante la lavorazione della richiesta.");
		errorMessage.setMessage("Causa= [" + e.getCause() + "] - Messaggio=[" + e.getMessage() + "]");
		errorMessage.setErrorCode("ERR000");
		errorMessage.setRetry(false);
		list.add(errorMessage);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resource);

	}

}
