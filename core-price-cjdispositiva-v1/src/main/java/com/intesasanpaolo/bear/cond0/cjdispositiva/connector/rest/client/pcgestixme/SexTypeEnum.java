package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Getter;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public enum SexTypeEnum {
    MALE("M"),
    FEMALE("F"),
    TRANS("T"),
    UNKNOWN("X");

    @Getter
    private final String code;

    SexTypeEnum(String code) {
        this.code = code;
    }

    public static SexTypeEnum valueOfCode(String code) {
        for (SexTypeEnum offert : SexTypeEnum.values()) {
            if (offert.getCode().equalsIgnoreCase(code)) {
                return offert;
            }
        }
        throw new TechnicalException("The sex type enum does not have " + code, "", null);
    }

    public static boolean contains(String fe) {
        try {
            SexTypeEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String printCode() {
        return Arrays.stream(SexTypeEnum.values())
                .map(e -> e.getCode())
                .collect(joining(ToolConstants.ENUM_LIST_STRING_SEPARETOR));
    }
}
