package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

public enum AdherentStatusEnum {

    ATTIVO("ATTIV", "ATTIVO"),
    INATTIVO("INATT", "NON ATTIVO"),
    MINORENNE_ATTIVO("MINOR", "MINORENNE ATTIVO"),
    DISATTIVATO("DISAT", "DISATTIVATO");

    @Getter
    private String code;
    @Getter
    private String desc;

    AdherentStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AdherentStatusEnum valueOfCode(String value) {
        for (AdherentStatusEnum offert : AdherentStatusEnum.values()) {
            if (offert.getCode().equalsIgnoreCase(value)) {
                return offert;
            }
        }
        throw new TechnicalException("AdherentStatusEnum has not " + value, "", null);
    }

    public static boolean contains(String fe) {
        try {
            AdherentStatusEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
