package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Getter;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public enum ContractStatusEnum {

    ALL("TUTTI", "*"),
    ACTIVE("ATTIV", "ATTIVO"),
    PENDING("APPES", "IN ATTESA DI FIRMA"),
    SUSPENDED("SOSPE", "SOSPESO"),
    DELETED("CANCE", "CHIUSO PER DISDETTA"),
    UNDONE("ANNUL", "ANNULLATO"),
    EXPIRE("SCADU", "SCADUTO"),
    REACTIVED("RIATT", "IN RIATTIVAZIONE");

    @Getter
    private final String code;
    @Getter
    private final String desc;

    ContractStatusEnum(String value, String descval) {
        code = value;
        desc = descval;
    }

    public static ContractStatusEnum valueOfCode(String val) {
        for (ContractStatusEnum enu : ContractStatusEnum.values()) {
            if (enu.getCode().equalsIgnoreCase(val)) {
                return enu;
            }
        }
        throw new TechnicalException("ContractStatusEnum has not " + val, "", null);
    }

    public static ContractStatusEnum valueOfDesc(String val) {
        for (ContractStatusEnum enu : ContractStatusEnum.values()) {
            if (enu.getDesc().equalsIgnoreCase(val)) {
                return enu;
            }
        }
        throw new TechnicalException("ContractStatusEnum has not " + val, "", null);
    }

    public static boolean contains(String fe) {
        try {
            ContractStatusEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String printCode() {
        return Arrays.stream(ContractStatusEnum.values())
                .map(e -> e.getCode())
                .collect(joining(ToolConstants.ENUM_LIST_STRING_SEPARETOR));
    }
}
