package com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums;

public enum CodProcessoEnum {

	CJ_CARTE_AZIENDALI_PG("CJCPG"),
	CJ_AFFIDAMENTI("CJAFF"),
	CJ_CUI_DA("CJDA");

    private final String text;

    CodProcessoEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
