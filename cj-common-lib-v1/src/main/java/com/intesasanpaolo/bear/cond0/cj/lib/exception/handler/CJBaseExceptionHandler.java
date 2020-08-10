package com.intesasanpaolo.bear.cond0.cj.lib.exception.handler;

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

import com.intesasanpaolo.bear.cond0.cj.lib.exception.CJBaseException;
import com.intesasanpaolo.bear.cond0.cj.lib.exception.CommonErrorCode;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.core.resource.BaseResource;
import com.intesasanpaolo.bear.exceptions.model.BearSeverityEnum;
import com.intesasanpaolo.bear.exceptions.model.ErrorMessage;
import com.intesasanpaolo.bear.exceptions.resource.ErrorResource;

public abstract class CJBaseExceptionHandler<T extends BaseResource> {
	private static final Logger logger = LoggerUtils.getLogger(CJBaseExceptionHandler.class);

	public abstract T errorResponseForCJBaseException(String errorCode,String errorMessage );
	
	@ExceptionHandler({ CJBaseException.class })
    public ResponseEntity<T> handleCJBaseException(CJBaseException e) {
		logger.error("handleCJBaseException {}", e);
		T resource=errorResponseForCJBaseException(e.getErrorCode(), e.formattaMessaggio());
		return ResponseEntity.status(HttpStatus.OK).body(resource);    	
    } 
	
	@ExceptionHandler({ MissingRequestHeaderException.class })
	protected ResponseEntity<ErrorResource> handleMissingRequestHeaderException(MissingRequestHeaderException e,
			HttpServletRequest request, HttpServletResponse response) {

		logger.error("handleException", e);
		
		ErrorResource resource = new ErrorResource();
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
	protected ResponseEntity<ErrorResource> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request, HttpServletResponse response) {

		logger.error("handleException {}", e.getMessage(), e);
		ErrorResource resource = new ErrorResource();
		
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
	protected ResponseEntity<ErrorResource> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request,
			HttpServletResponse response) {

		logger.error("handleException {}", e.getMessage(), e);
		ErrorResource resource = new ErrorResource();
		
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
	protected ResponseEntity<ErrorResource> handleExceptionGeneric(Exception e) {
		ErrorResource resource = new ErrorResource();
		
		logger.error("handleException {}", e.getMessage(), e);
		Map<String, List<ErrorMessage>> map = new HashMap<>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put("ERROR", list);
		resource.setReturnMessages(map);

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessageTitle("Errore durante la lavorazione della richiesta.");
		errorMessage.setMessage("Causa= [" + e.getCause() + "] - Messaggio=[" + e.getMessage() + "]");
		errorMessage.setErrorCode("ERR000");
		errorMessage.setRetry(false);
		list.add(errorMessage);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resource);

	}

}
