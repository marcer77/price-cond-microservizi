package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

public enum ConsentEnum {

    SCCON("SCCON"),
    SCCM1("SCCM1"),
    SCCM2("SCCM2"),
    DEL("DEL"),
    CONTO("CONTO"),
    C6("C6");

    @Getter
    private String code;

    ConsentEnum(String typeCode) {
        code = typeCode;
    }

    public static ConsentEnum valueOfCode(String value) {
        for (ConsentEnum consent : ConsentEnum.values()) {
            if (consent.getCode().equalsIgnoreCase(value)) {
                return consent;
            }
        }
        throw new TechnicalException("ConsentEnum has not " + value, "", null);
    }

    public static boolean contains(String fe) {
        try {
            ConsentEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
