package com.intesasanpaolo.bear.cond0.cjindicatoricosto.exception;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.resource.IndicatoriCostoResource;
import com.intesasanpaolo.bear.config.LoggerUtils;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CJIndicatoriCostoExceptionHandler {
	private static final Logger logger = LoggerUtils.getLogger(CJIndicatoriCostoExceptionHandler.class);

	@ExceptionHandler({ BSException.class })
    public ResponseEntity<IndicatoriCostoResource> handleException(BSException e) {
    	
		logger.error("handleException {}", e.getMessage(), e);		    
    	
		EsitoResource esito=new EsitoResource();
		esito.setCodErrore(e.getMdwEsiRetc());
		esito.setDescErrore(e.getMdwEsiMsg().trim()+"  - "+e.getMdwEsiAnom().trim());
		
		IndicatoriCostoResource resource = IndicatoriCostoResource.builder().esito(esito).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(resource);    	
    } 

    /*@ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
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
