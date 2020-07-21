package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TechnicalException extends RuntimeException {

    public final ExceptionMessageEnum type = ExceptionMessageEnum.T999_TECHNICAL_GENERIC_PROBLEM;
    private String origin;

    public TechnicalException(String message, String origin, Exception e) {
        super(message, e);
        this.origin = origin;
    }

    public TechnicalException(StringBuilder message, String origin, Exception e) {
        super(message.toString(), e);
        this.origin = origin;
    }
}
