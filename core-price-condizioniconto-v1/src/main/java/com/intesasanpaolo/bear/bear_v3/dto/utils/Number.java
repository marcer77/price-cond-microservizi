package com.intesasanpaolo.bear.bear_v3.dto.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Number {

	
	private static DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
	private static DecimalFormat ft = (DecimalFormat) NumberFormat.getInstance(Locale.ITALIAN);
	
	public final static String ILLIMITATO_STRING = "Illimitato";
	public final static String ILLIMITATO_NUMERIC = "9.999999999E9";
	
	private final static double EPSILON = 1E-5; 
	
	/**
	 * Formatta un valore numerico in base alla descrizione dell'unità di misura
	 * 
	 * @param valueToFormat		valore double da formattare
	 * @param udmDescription 	descrizione dell'unità di misura (tabella "T_PC2_ANAG_UDM")
	 * @return					valore formattato
	 */
	public static String formatByUdm(double valueToFormat, String udmDescription){
		
		if (Double.toString(valueToFormat).equals(ILLIMITATO_NUMERIC)) 
			return "ILL.";

		if (udmDescription.equalsIgnoreCase("%") || udmDescription.equalsIgnoreCase("SPR"))
			ft.applyPattern("0.0000");
		else if (udmDescription.equalsIgnoreCase("PERM"))
			ft.applyPattern("0.000");
		else if (udmDescription.equalsIgnoreCase("COD")||udmDescription.equalsIgnoreCase("NUM")||udmDescription.equalsIgnoreCase("GG"))
			ft.applyPattern("0");
		else
			ft.applyPattern("#,###,##0.00");				
			
		if (udmDescription.equalsIgnoreCase("%"))
			return formatPercentage(ft.format(valueToFormat));
		return ft.format(valueToFormat);
	}

	
	/**
	 * formatta il numero con unità di misura di tipo percentuale 
	 * togliendo gli zero dopo la virgola.
	 * Se dopo tale operazione il numero rimane senza decimali toglie anche la virgola

	 * @param 	stringToFormat	la stringa numerica da formattare
	 * @return	il valore numerico (in formato percentuale) da formattare
	 */
	private static String formatPercentage(String stringToFormat){
		if  (stringToFormat.length()==0) return "";
		int idx;
		for (idx = stringToFormat.length()-1;; idx--){
			if (stringToFormat.charAt(idx)=='0')  continue;  
		break; 
		}
		if (stringToFormat.charAt(idx) ==',') 
			return stringToFormat.substring(0, idx); 
		return stringToFormat.substring(0, ++idx);
	}
	
	

	public static String segno(String segno){
		return (segno.equals("+")?"":segno);
	}
	
	public static String parseNumber13d5(double d){
		df.applyPattern("#######0.#####");
		return df.format(d).replace('.',',');	
	}
	
	public static String parseNumber15d5(double d){
		df.applyPattern("#########0.#####");
		return df.format(d).replace('.',',');	
	}
	public static String parseNumber13d2(double d){
		df.applyPattern("##########0.00");
		return df.format(d).replace('.',',');	
	}
	
	public static String parseDouble(double d){
	
		df.applyPattern("#########0.#####");
		return df.format(d).replace('.',',');	
	}
	
	public static String parseDoubleNoComma(double d){
		
		df.applyPattern("#########0.#####");
		return df.format(d);
	}
	
	public static String parseBigDecimal(BigDecimal d){
		DecimalFormat df = new DecimalFormat("#########0.#####");
		return df.format(d).replace('.',',');	
	}
	
	
	public static String toStringConverter(double d){		
		return ((Double.toString(d)).equals(ILLIMITATO_NUMERIC)) ? ILLIMITATO_STRING : Number.parseDouble(d); 		
	}
	
	public static double toDoubleConverter(String d){
		d = d.replace(',','.');
		return Double.parseDouble(d);
	}
	
	public static BigDecimal toBigDecimal(String s) {
		if (s == null || s.isEmpty())
			return null;
		if (s.equals(ILLIMITATO_STRING))
			s = ILLIMITATO_NUMERIC;
		// converti #.###,# nel formato standard
		else if (s.contains(","))
			s = s.replace(".", "").replace(",", ".");
		return new BigDecimal(s);
	}
	
	public static String toNumberConverter(String number){		
		return (number.equals(ILLIMITATO_STRING)) ? ILLIMITATO_NUMERIC : number; 		
	}
	
	public static String toNumberConverterNoE(String number){		
		return (number.equals(ILLIMITATO_STRING)) ? "9999999999" : number; 		
	}
	
	// dato una stringa che rappresenta una numero
	// lo formatta opportunamente a seconda di alcuni suoi possibili valori
	// es: 9.999999999E9 -> Illimitato
	public static String getStringConversionFromNumeric(String number){
		return (number.equals(ILLIMITATO_NUMERIC)) ? ILLIMITATO_STRING : number; 				
	}
	
	public static double toDouble5dec(BigDecimal d, RoundingMode roundMode) {
		if (d == null)
			return 0d;
		DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
		df.setRoundingMode(roundMode);
		df.applyPattern("0.0####");
		String s = d.equals(Number.ILLIMITATO_NUMERIC) ? Number.ILLIMITATO_STRING : df.format(d);
		return Double.parseDouble(s);
	}
	
	// Dati Num Decimali e Num Interi costruisce il valore formattato nel seguente modo:
	// es: 10 interi, 5 decimali => #########0.00000 (obbligatori il numero di decimali)
	public static String getValoreFromVincoli(double valore, int numInteri, int numDecimali){
		String valoreFormattato = "";
		if(numDecimali == 0){
			String patternString = getPatternString("#",numInteri-1)+"0";
			df.applyPattern(patternString);
			valoreFormattato = df.format(valore);
		}
		else{
			String patternString = getPatternString("#",numInteri-1)+"0."+getPatternString("0",numDecimali);
			df.applyPattern(patternString);
			valoreFormattato = df.format(valore).replace('.',',');		
		}
		return valoreFormattato;
	}
	
	// costruisce una stringa formata dal carattere patternCharacter (input)
	// ripetuti consecutivamente per numRipetizioni (input)
	private static String getPatternString(String patternCharacter, int numRipetizioni){
		String patternString = "";
		for(int i=0;i<numRipetizioni;i++)
			patternString += patternCharacter;
		return patternString;
	}
	
	
	public static double roundTo5dec(double number){
		return Math.round(number*100000.0)/100000.0;
	}
	
	public static double roundTo2dec(double number){
		return Math.round(number*100.0)/100.0;
	}
	
	public static double roundTo3dec(double number){
		return Math.round(number*1000.0)/1000.0;
	}
	/**
	 * Costruisce un double partendo da un BigDecimal	 * 
	 * @param 	bd 		L'oggetto BigDecimal da convertire
	 * @param 	scale 	I numeri dopo la virgola a cui viene approssimato l'output
	 * @return 			Il valore numerico double di ritorno
	 * */
	public static double bigDecimalToDouble(BigDecimal bd, int scale){	
		double out = 0.0;					
		if (bd != null){
			bd.setScale(scale, BigDecimal.ROUND_HALF_DOWN);			
			out = bd.doubleValue();
		}
		return out;
	}			
	/**
	 * Costruisce un BigDecimal partendo da un double
	 * @param 	d 		Il double da convertire
	 * @param 	scale 	I numeri dopo la virgola a cui viene approssimato l'output
	 * @return 			L'oggetto BigDecimal di ritorno
	 * */
	public static BigDecimal doubleToBigDecimal(double d, int scale){	
		String a = String.format("%."+scale+"f", d); 
		a = a.replaceAll(",", ".");
		BigDecimal bd = new BigDecimal(a);
		return bd;
	}
	
	public static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    }
		return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	}
	
	
	/*
	 * Data un numero salvato come stringa, se arriva con degli zero iniziali (ad es via tracciato host), rimuove gli zeri e lascia solo il numero.
	 * 
	 */
	
	public static String removeLeadingZeros(String value){
		
		if(value != null && value.length()>0){
			
			if(value.indexOf(",") < 0 || value.indexOf(".") < 0){
				int v = Integer.parseInt(value);
				value = Integer.toString(v);
			}
			else{
				double v = Double.parseDouble(value);
				value = Double.toString(v);
			}
		}

		return value;
	}
	
	/**
	 * Returns true if two doubles are considered equal. Tests if the absolute
	 * difference between two doubles has a difference less than {@value #EPSILON}
	 *
	 * @param a double to compare.
	 * @param b double to compare.
	 * @return true iff a is considered equal to b.
	 */
	public static boolean equals(double a, double b){
	    return equals(a, b, EPSILON);
	}


	/**
	 * Returns true if two doubles are considered equal. Tests if the absolute
	 * difference between the two doubles has a difference less than a given
	 * epsilon. Determining the given epsilon is highly dependant on the
	 * precision of the doubles that are being compared.
	 *
	 * @param a double to compare.
	 * @param b double to compare
	 * @param epsilon double which is compared to the absolute difference of two
	 * doubles to determine if they are equal.
	 * @return true iff a is considered equal to b.
	 */
	public static boolean equals(double a, double b, double epsilon){
	    return a == b || Math.abs(a - b) < epsilon;
	}


	/**
	 * Returns true if the first double is considered greater than the second
	 * double.  Test if the difference of first minus second is greater than
	 * {@value #EPSILON}.
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered greater than the second
	 *              double
	 */
	public static boolean greaterThan(double a, double b){
	    return greaterThan(a, b, EPSILON);
	}


	/**
	 * Returns true if the first double is considered greater than the second
	 * double. Test if the difference of first minus second is greater than
	 * a given epsilon.  Determining the given epsilon is highly dependant on
	 * the precision of the doubles that are being compared.
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered greater than the second
	 *              double
	 */
	public static boolean greaterThan(double a, double b, double epsilon){
	    return a - b > epsilon;
	}


	/**
	 * Returns true if the first double is considered lesser than the second
	 * double. Test if the difference of second minus first is greater than
	 * {@value #EPSILON}
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered lesser than the second
	 *              double
	 */
	public static boolean lesserThan(double a, double b){
	    return lesserThan(a, b, EPSILON);
	}


	/**
	 * Returns true if the first double is considered lesser than the second
	 * double. Test if the difference of second minus first is greater than
	 * a given epsilon. Determining the given epsilon is highly dependant on
	 * the precision of the doubles that are being compared.
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered lesser than the second
	 *              double
	 */
	public static boolean lesserThan(double a, double b, double epsilon){
	    return b - a > epsilon;
	}
	
	/**
	 * Returns true if the first double is considered greater than or equal to the second
	 * double.  Test if the difference of first minus second is greater or equal than
	 * -{@value #EPSILON}.
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered greater than the second
	 *              double
	 */
	public static boolean greaterEqualThan(double a, double b){
		return greaterEqualThan(a, b, -EPSILON);
	}
	
	/**
	 * Returns true if the first double is considered greater than or equal to the second
	 * double. Test if the difference of first minus second is greater or equal than
	 * a given epsilon.  Determining the given epsilon is highly dependant on
	 * the precision of the doubles that are being compared.
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered greater than the second
	 *              double
	 */
	public static boolean greaterEqualThan(double a, double b, double epsilon){
		return a - b >= epsilon;
	}
	
	/**
	 * Returns true if the first double is considered lesser than or equal to the second
	 * double. Test if the difference of second minus first is greater or equal than
	 * -{@value #EPSILON}
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered lesser than the second
	 *              double
	 */
	public static boolean lesserEqualThan(double a, double b){
		return lesserEqualThan(a, b, -EPSILON);
	}
	
	
	/**
	 * Returns true if the first double is considered lesser than or equal to the second
	 * double. Test if the difference of second minus first is greater or equal than
	 * a given epsilon. Determining the given epsilon is highly dependant on
	 * the precision of the doubles that are being compared.
	 *
	 * @param a first double
	 * @param b second double
	 * @return true iff the first double is considered lesser than the second
	 *              double
	 */
	public static boolean lesserEqualThan(double a, double b, double epsilon){
		return b - a >= epsilon;
	}

}