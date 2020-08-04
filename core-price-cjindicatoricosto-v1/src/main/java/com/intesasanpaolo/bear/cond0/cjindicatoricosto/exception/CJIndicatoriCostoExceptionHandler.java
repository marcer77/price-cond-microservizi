package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.exceptions.model.BearError;
import com.intesasanpaolo.bear.exceptions.model.BearErrorTypeEnum;
import com.intesasanpaolo.bear.exceptions.model.BearSeverityEnum;
import com.intesasanpaolo.bear.exceptions.model.ErrorMessage;
import com.intesasanpaolo.bear.exceptions.model.MessageForm;
import com.intesasanpaolo.bear.exceptions.response.MicroServiceExceptionResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CJIndicatoriCostoExceptionHandler {
	private static final Logger logger = LoggerUtils.getLogger(CJIndicatoriCostoExceptionHandler.class);

	@ExceptionHandler({ CJBaseException.class })
    public ResponseEntity<IndicatoriCostoResource> handleException(CJBaseException e) {
		logger.error("handleException {}", e.getMessage(), e);		    
		EsitoResource esito=new EsitoResource();
		esito.setCodErrore(e.getCode());
	    esito.setDescErrore(e.getMessage());
		IndicatoriCostoResource resource = IndicatoriCostoResource.builder().esito(esito).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(resource);    	
    } 
	
	@ExceptionHandler({MethodArgumentNotValidException.class })
    public ResponseEntity<IndicatoriCostoResource> handleException(MethodArgumentNotValidException e) {
    	
		logger.error("handleException {}", e.getMessage(), e);		    
		IndicatoriCostoResource resource = IndicatoriCostoResource.builder().pratica(null).build();
		
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
	
	@ExceptionHandler({Exception.class })
    public ResponseEntity<IndicatoriCostoResource> handleExceptionGeneric(Exception e) {
		IndicatoriCostoResource resource = IndicatoriCostoResource.builder().pratica(null).esito(null).build();
		
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
	
	//@ResponseStatus(BAD_REQUEST)
    //@ResponseBody
    //@ExceptionHandler(MethodArgumentNotValidException.class)
	/*public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

        private Error processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        Error error = new Error(BAD_REQUEST.value(), "validation error");
        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }

    static class Error {
        private final int status;
        private final String message;
        private List<FieldError> fieldErrors = new ArrayList<>();

        Error(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public void addFieldError(String path, String message) {
            FieldError error = new FieldError(path, message, message);
            fieldErrors.add(error);
        }

        public List<FieldError> getFieldErrors() {
            return fieldErrors;
        }
    }*/
}
