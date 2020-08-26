package com.intesasanpaolo.bear.cond0.cj.lib.enums;

public enum CodLinguaEnum {

	ITALIANO("0"),
	TEDESCO("1"),
	INGLESE("2"),
	FRANCESE("3"),
	SPAGNOLO("4");

    private final String text;

    CodLinguaEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
