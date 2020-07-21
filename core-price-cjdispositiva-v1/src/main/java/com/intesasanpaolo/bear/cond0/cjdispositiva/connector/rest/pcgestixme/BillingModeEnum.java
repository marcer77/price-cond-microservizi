package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

public enum BillingModeEnum {

    NO_INV("NOINV"),
    INV_M("INVEM"),
    INV_CA("INVCA"),
    INV_IB("INVIB");

    @Getter
    private String code;

    BillingModeEnum(String code) {
        this.code = code;
    }

    public static BillingModeEnum valueOfCode(String value) {
        for (BillingModeEnum billingMode : BillingModeEnum.values()) {
            if (billingMode.getCode().equalsIgnoreCase(value)) {
                return billingMode;
            }
        }
        throw new TechnicalException(new StringBuilder("BillingModeEnum has not ").append(value).toString(), "", null);
    }

    public static boolean contains(String code) {
        try {
            BillingModeEnum.valueOfCode(code);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
