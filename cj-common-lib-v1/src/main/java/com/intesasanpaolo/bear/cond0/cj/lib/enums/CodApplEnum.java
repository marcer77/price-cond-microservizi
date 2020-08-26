package com.intesasanpaolo.bear.cond0.cj.lib.enums;

public enum CodApplEnum {

	CARTE("X"),
	FIDI("F"),
	AREA_FINANZA("D");

    private final String text;

    CodApplEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
