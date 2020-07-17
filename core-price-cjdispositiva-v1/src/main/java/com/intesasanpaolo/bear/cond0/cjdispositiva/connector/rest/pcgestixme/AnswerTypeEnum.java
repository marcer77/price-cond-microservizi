package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

public enum AnswerTypeEnum {

    MANDATORY("OBBLIGATORIO"),
    NOT_MANDATORY("FACOLTATIVO");

    @Getter
    private String code;

    AnswerTypeEnum(String consentType) {
        code = consentType;
    }

    public static AnswerTypeEnum valueOfCode(String value) {
        for (AnswerTypeEnum consent : AnswerTypeEnum.values()) {
            if (consent.getCode().equalsIgnoreCase(value)) {
                return consent;
            }
        }
        throw new TechnicalException("AnswerTypeEnum has not " + value, "", null);
    }

    public static boolean contains(String fe) {
        try {
            AnswerTypeEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
