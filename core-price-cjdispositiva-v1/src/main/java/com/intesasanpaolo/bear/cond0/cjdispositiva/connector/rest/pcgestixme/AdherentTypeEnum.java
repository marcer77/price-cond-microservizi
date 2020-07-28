package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/*
    "TITOL", "holder"
    "ADEMA", "adult adherent"
    "ADEMI", "minor adherent"
 */

public enum AdherentTypeEnum {
    TITOL("TITOL", "Titolare"),
    ADEMA("ADEMA", "Aderente Maggiorenne"),
    ADEMI("ADEMI", "Aderente Minorenne");

    @Getter
    private String code;

    @Getter
    private String description;

    AdherentTypeEnum(String code, String desc) {
        this.code = code;
        description = desc;
    }

    public static AdherentTypeEnum valueOfCode(String value) {
        for (AdherentTypeEnum offert : AdherentTypeEnum.values()) {
            if (offert.getCode().equalsIgnoreCase(value)) {
                return offert;
            }
        }
        throw new TechnicalException("AdherentTypeEnum has not " + value, "", null);
    }

    public static boolean contains(String fe) {
        try {
            AdherentTypeEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String printCode() {
        return Arrays.stream(AdherentTypeEnum.values())
                .map(e -> e.getCode())
                .collect(joining(ToolConstants.ENUM_LIST_STRING_SEPARETOR));
    }
}
