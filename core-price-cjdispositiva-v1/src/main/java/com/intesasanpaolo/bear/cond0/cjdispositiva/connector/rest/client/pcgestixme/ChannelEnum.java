package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Getter;

public enum ChannelEnum {
    SPORTELLO("01"),
    ABC("31"),
    CDIL0("02"),
    SABE0("EK"),
    WFM("CH"),
    D8("D8");

    @Getter // from the FE, USED TO CALL ALL THE OTHER SERVICE
    private String code;

    ChannelEnum(String code) {
        this.code = code;
    }

    public static ChannelEnum valueOfCode(String value) {
        for (ChannelEnum channel : ChannelEnum.values()) {
            if (channel.getCode().equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new TechnicalException("ChannelEnum has not " + value, "", null);
    }

    public static boolean contains(String fe) {
        try {
            ChannelEnum.valueOfCode(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
