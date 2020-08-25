package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Getter;

public enum ConsentSectionEnum {
    SMART_CARE("ISSC"),
    DELEGATE("DEL"),
    ACCOUNT("CONTO");

    @Getter
    private String code;

    ConsentSectionEnum(String cod) {
        code = cod;
    }

    public static ConsentSectionEnum getFromCode(String codeS) {
        for (ConsentSectionEnum section : ConsentSectionEnum.values()) {
            if (section.code.equals(codeS)) {
                return section;
            }
        }
        throw new TechnicalException("No Section found with such code. Found: " + codeS, "ConsentSectionEnum.getFromCode", null);
    }
}
