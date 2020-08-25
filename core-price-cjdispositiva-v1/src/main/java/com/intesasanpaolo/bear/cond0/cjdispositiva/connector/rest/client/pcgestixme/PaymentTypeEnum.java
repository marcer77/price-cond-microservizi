package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Getter;

public enum PaymentTypeEnum {
    BANK_ACCOUNT("ADDCC"); // Payment by bank account

    @Getter
    private String code;

    PaymentTypeEnum(String code) {
        this.code = code;
    }

    public static PaymentTypeEnum valueOfCode(String code) {
        for (PaymentTypeEnum offert : PaymentTypeEnum.values()) {
            if (offert.getCode().equalsIgnoreCase(code)) {
                return offert;
            }
        }
        throw new TechnicalException(new StringBuilder("PaymentTypeEnum code has not ").append(code).toString(), "", null);
    }

    public static boolean contains(String code) {
        try {
            PaymentTypeEnum.valueOfCode(code);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
