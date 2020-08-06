package com.intesasanpaolo.bear.cond0.cj.lib.utils;

public class PaddingField {

    //Funzione per riempire un campo, della lunghezza desiderata, nella direzione voluta scegliendo i metodi left o right
    public static String left(String field, int length) {
        return String.format("%1$" + length + "s", field);
    }

    //riempie alla fine
    public static String right(String field, int length) {
    	return String.format("%1$-" + length + "s", field);
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
    
    // aggiunge all'inizio
    public static String leftPadZeroOrTruncate(String str, int size) {
        if (str == null) {
            return org.apache.commons.lang.StringUtils.leftPad("", size, "0");
        }

        if (str.length() > size) {
            return str.substring(0, size);
        }

        return org.apache.commons.lang.StringUtils.leftPad(str, size, "0");
    }

    // aggiunge alla fine
    public static String rightPadSpaceOrTruncate(String str, int size) {
        if (str == null) {
            return org.apache.commons.lang.StringUtils.rightPad("", size, " ");
        }

        if (str.length() > size) {
            return str.substring(0, size);
        }

        return org.apache.commons.lang.StringUtils.rightPad(str, size, " ");
    }

}
