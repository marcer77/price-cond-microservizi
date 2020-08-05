package com.intesasanpaolo.bear.cond0.cj.lib.utils;

public class PaddingField {

    //Funzione per riempire un campo, della lunghezza desiderata, nella direzione voluta scegliendo i metodi left o right
    public static String left(String field, int length) {
        return String.format("%1$" + length + "s", field);
    }

    public static String right(String field, int length) {
    	if(field!=null) {
    		return String.format("%1$-" + length + "s", field);
    	}
    	return null;
    }

    //Riempe field con zeri in base a length
    public static String paddingZeros(int field, int length) {
        return String.format("%0" + length + "d", field);
    }

    public static String paddingZeros(long field, int length) {
        return String.format("%0" + length + "d", field);
    }

    public static String paddingZeros(double field, int length) {
        return String.format("%0" + length + ".1f", field);
    }
}
