package com.intesasanpaolo.bear.cond0.cjindicatoricosto.enums;

public enum WarningEnum {
	//CALCOLA("CALC"),
	//CALCOLA_E_CONTROLLA("CTRL");
	X("","");
	/*00 – OK
	01 – Warning  rilevate differenze in fase di controllo
	02 – Warning  presenti variazioni TEG
	03 – Warning  pesenti variazioni TAEG
*/
	private String codice;
	private String descrizione;
	WarningEnum(final String codice,final String descrizione) {
        this.codice = codice;
        this.descrizione=descrizione;
    }

    @Override
    public String toString() {
        return codice;
    }
}
