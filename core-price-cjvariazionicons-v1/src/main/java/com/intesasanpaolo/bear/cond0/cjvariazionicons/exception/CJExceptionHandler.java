package com.intesasanpaolo.bear.cond0.cjvariazionicons.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.EsitoStampaResource;
import com.intesasanpaolo.bear.cond0.cjvariazionicons.resource.StampaResponseResource;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.exceptions.model.ErrorMessage;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class CJExceptionHandler {
	private static final Logger logger = LoggerUtils.getLogger(CJExceptionHandler.class);

	
	@ExceptionHandler({ MissingRequestHeaderException.class })
	public ResponseEntity<StampaResponseResource> handleMissingRequestHeaderException(MissingRequestHeaderException e,
			HttpServletRequest request, HttpServletResponse response) {
		
		logger.error("handleException {}", e.getMessage(), e);
		
		StampaResponseResource resource = StampaResponseResource.builder()
				.documento(null)
				.esitoStampaResource(null)
				.build();

		Map<String, List<ErrorMessage>> map = new HashMap<String, List<ErrorMessage>>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put("ERROR", list);
		resource.setReturnMessages(map);

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessageTitle(e.getHeaderName());
		errorMessage.setMessage(e.getMessage());
		list.add(errorMessage);

	   // throw new BearDomainException("generic.error", "generic.error", HttpStatus.BAD_REQUEST,BearErrorTypeEnum.TECHNICAL,BearSeverityEnum.ERROR);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resource);
	}
	
	
	
	@ExceptionHandler({MethodArgumentNotValidException.class })
    public ResponseEntity<StampaResponseResource> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request, HttpServletResponse response) {
    	
		logger.error("handleException {}", e.getMessage(), e);		    
		StampaResponseResource resource = StampaResponseResource.builder().documento(null).esitoStampaResource(null)
				.build();

		//////
		Map<String, List<ErrorMessage>> map= new HashMap<String, List<ErrorMessage>>();
		List<ErrorMessage> list=new ArrayList<>();
		map.put("ERROR", list);
		resource.setReturnMessages(map);
		
		BindingResult result = e.getBindingResult();
	    List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
	    fieldErrors.forEach(fe->{
	    	ErrorMessage errorMessage=new ErrorMessage();
		    //errorMessage.setMessageKey("mytest.error");
		   errorMessage.setMessage(fe.getDefaultMessage());
	       errorMessage.setMessageTitle(fe.getField());
	    	
	       //MessageForm messageForm=new MessageForm();
	       //messageForm.setFieldName(fe.getField());
	       //messageForm.setFormName("richiesta");
	       //errorMessage.setMessageForm(messageForm);
	       list.add(errorMessage);
					
	    });
	    
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resource);    	
    }
	@ExceptionHandler({org.springframework.http.converter.HttpMessageNotReadableException.class })
    public ResponseEntity<StampaResponseResource> handleInvalidFormatException(HttpMessageNotReadableException e,HttpServletRequest request, HttpServletResponse response) {
    	
		logger.error("handleException {}", e.getMessage(), e);		    
		StampaResponseResource resource = StampaResponseResource.builder().documento(null).esitoStampaResource(null)
				.build();

		//////
		Map<String, List<ErrorMessage>> map = new HashMap<String, List<ErrorMessage>>();
		List<ErrorMessage> list = new ArrayList<>();
		map.put("ERROR", list);
		resource.setReturnMessages(map);

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessageTitle(e.getClass().getName());
		errorMessage.setMessage(e.getMessage());
		list.add(errorMessage);
	    
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resource);    	
    }
	
	@ExceptionHandler({ CJBaseException.class })
    public ResponseEntity<StampaResponseResource> handleException(CJBaseException e) {
		logger.error("handleException {}", e.getMessage(), e);
		
		EsitoStampaResource esito=new EsitoStampaResource();
		esito.setCodErrore(e.getCode());
	    esito.setDescErrore(e.getMessage());
	    StampaResponseResource resource = StampaResponseResource.builder().esitoStampaResource(esito).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(resource);    	
    } 
	
	@ExceptionHandler({Exception.class })
    public ResponseEntity<StampaResponseResource> handleExceptionGeneric(Exception e) {
		StampaResponseResource resource = StampaResponseResource.builder().documento(null).esitoStampaResource(null)
				.build();
		
		logger.error("handleException {}", e.getMessage(), e);		    
		Map<String, List<ErrorMessage>> map= new HashMap<String, List<ErrorMessage>>();
		List<ErrorMessage> list=new ArrayList<>();
		map.put("ERROR", list);
		resource.setReturnMessages(map);
		
		ErrorMessage errorMessage=new ErrorMessage();
		//errorMessage.setMessageKey("");
		errorMessage.setMessageTitle("Errore durante la lavorazione della richiesta.");
		errorMessage.setMessage("Causa= ["+e.getCause()+"] - Messaggio=["+e.getMessage()+"]");
		errorMessage.setErrorCode("ERR000");
		errorMessage.setRetry(false);
		list.add(errorMessage);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resource); 
	
    }
	

	
}
