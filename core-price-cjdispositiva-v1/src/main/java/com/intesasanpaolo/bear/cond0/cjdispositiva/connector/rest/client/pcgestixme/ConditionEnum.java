package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Getter;

public enum ConditionEnum {
    XMESALUTE_SINGOLO("XMS_SINGOLO"),
    XMESALUTE_GRUPPO_CORRENTISTI("XMS_GR_CONTO"),
    XMESALUTE_GRUPPO_NO_CORRENTISTI("XMS_GR_NO_CONTO");

    @Getter
    private String code;

    ConditionEnum(String code) {
        this.code = code;
    }

    public static ConditionEnum valueOfCode(String fe) {
        for (ConditionEnum en : ConditionEnum.values()) {
            if (en.getCode().equalsIgnoreCase(fe)) {
                return en;
            }
        }
        throw new TechnicalException("ConditionEnum has not " + fe, "", null);
    }

    public static boolean contains(String fe) {
        try {
            ConditionEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
