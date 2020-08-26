package com.intesasanpaolo.bear.cond0.cj.lib.enums;

public enum TipoStrutEnum {
	
	INTESTAZIONE("C"),
	TITOLO("T"),
	CONDIZIONE("Y"),
	NOTA("N"),
	PROMOZIONE("M");

    private final String text;

    TipoStrutEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
