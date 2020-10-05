package com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums;

public enum TipoRichiestaEnum {

	CALCOLA("CALC"),
	CALCOLA_E_CONTROLLA("CTRL");

    private final String text;

    TipoRichiestaEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
