package com.intesasanpaolo.bear.bear_v3.dto.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class Format {
	
	// Set contenente tutte le date corrispondenti alle festività fisse (interi rappresentanti
	// la data nel formato MMdd, dove MM è il numero del mese -1 in conformità con lo standard della
	// classe Calendar; gli zeri in testa sono ridondanti ma facilitano la lettura)
	private static Set<Integer> holidays;
	// Mappa contenente tutti i giorni di Pasqua già calcolati, la chiave è l'anno
	private static Map<Integer, Calendar> easters;
	static { 
		holidays = new HashSet<Integer>();
		// Capodanno 1 gennaio
		holidays.add(0001);
		// Epifania 6 gennaio
		holidays.add(0006);
		// Liberazione 25 aprile
		holidays.add(0325);
		// Festa del Lavoro 1 maggio
		holidays.add(0401);
		// Festa della Repubblica 2 giugno
		holidays.add(0502);
		// Ferragosto 15 agosto
		holidays.add(0715);
		// Ognissanti 1 novembre
		holidays.add(1001);
		// Immacolata 8 dicembre
		holidays.add(1108);
		// Natale 25 dicembre
		holidays.add(1125);
		// Santo Stefano 26 dicembre
		holidays.add(1126);
		
		easters = new HashMap<Integer, Calendar>();
	}

	public static String getDataDaVisualizzare(String data){
		if(data.matches("-"))
			return data;
		else
			return fromHostDate(data);
	}
	
	public static String fromHostDate(String fromHost) {
		String tmp=fromHost.trim();
		String result="";
		if(tmp.length()==8)
		{
			if(null != fromHost && !tmp.substring(0,4).equals("9999") && !tmp.substring(0,4).equals("0000")){
				result+=tmp.substring(6)+"-";
				result+=tmp.substring(4,6)+"-";
				result+=tmp.substring(0,4);
			}
		}
		return result;
	}
	
	public static String fromHostDateSenzaGestioneIllimitato(String fromHost) {
		String tmp=fromHost.trim();
		String result="";
		if(tmp.length()==8)
		{
			//if(null != fromHost && !tmp.substring(0,4).equals("9999") && !tmp.substring(0,4).equals("0000")){
				result+=tmp.substring(6)+"-";
				result+=tmp.substring(4,6)+"-";
				result+=tmp.substring(0,4);
			//}
		}
		return result;
	}
	
	public static String fromHostDateFormatoSlash(String fromHost) {
		String tmp=fromHost.trim();
		String result="";
		if(tmp.length()==8)
		{
			if(null != fromHost && !tmp.substring(0,4).equals("9999") && !tmp.substring(0,4).equals("0000")){
				result+=tmp.substring(6)+"/";
				result+=tmp.substring(4,6)+"/";
				result+=tmp.substring(0,4);
			}
		}
		return result;
	}
	
	public static String yyyyMMdd(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}

	
	public static String today_yyyyMMdd() {
		Date today = new Date();
		return yyyyMMdd(today);
	}
	
	public static String today_SSSSSS() {
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("SSSSSS");
		
		
		return dateFormat.format(today);
	}
	
	/*For example: MicroTimestamp.INSTANCE.get() = "2012-10-21 19:13:45.267128"*/
	public static String getMicroTimestamp()
	 {
		  long startDate = System.currentTimeMillis() ;
		  long startNanoseconds = System.nanoTime() ;
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
		  long microSeconds = (System.nanoTime() - startNanoseconds) / 1000 ;
	      long date = startDate + (microSeconds/1000) ;
	      return dateFormat.format(date) + String.format("%03d", microSeconds % 1000) ;
	 }
	
	public static String capodannoDi3anniFa_yyyyMMdd() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.YEAR, -3);
		gc.set(Calendar.MONTH,11);
		gc.set(Calendar.DATE,31);
		return dateFormat.format(gc.getTime());
		
	}
	
	public static String ultimoGiornoAnnoPrecedente_yyyyMMdd() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");	
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.YEAR, -1);
		gc.set(Calendar.MONTH,11);
		gc.set(Calendar.DATE,31);
		return dateFormat.format(gc.getTime());
		
	}
	
	public static boolean equalsExcludingTime(java.sql.Date date1, java.sql.Date date2) {
		if(date1 == null || date2 == null)
			return false;
		
		Calendar calendar1 = GregorianCalendar.getInstance();
		Calendar calendar2 = GregorianCalendar.getInstance();
		
	    calendar1.setTime(date1);
	    calendar2.setTime(date2);
	    
		return	calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR) &&
				calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
				calendar1.get(Calendar.ERA) == calendar2.get(Calendar.ERA);
	}
	
	public static Date mezzanotte_yyyyMMdd(java.sql.Date date) {
		Calendar calendar = GregorianCalendar.getInstance();

	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    return new java.sql.Date(calendar.getTime().getTime());
	}
  
	public static String tomorrow_yyyyMMdd() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DATE, +1);
		return dateFormat.format(gc.getTime());
	}
	
	public static String ddMMyyyy(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		return dateFormat.format(date);
	}

	public static String today_ddMMyyyy() {
		Date today = new Date();
		return ddMMyyyy(today);
	}
	
	public static String today_mm_yyyy() {
		Date today = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("MM/yyyy");
		return timeFormat.format(today);
	}
	
	public static String today_dd_mm_yyyy() {
		Date today = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
		return timeFormat.format(today);
	}
	
	public static String dotsToHostFormat(String inputDate) {
		String result = "";
		SimpleDateFormat dots = new SimpleDateFormat("dd.MM.yyyy");
		Date date;
		try {
			date = dots.parse(inputDate);
			SimpleDateFormat host = new SimpleDateFormat("yyyyMMdd");
			result = host.format(date);
		} catch (ParseException e) {}
		return result;
	}

	public static String HHmmssSSS(Date date){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmssSSS");
		return timeFormat.format(date);
	}
	
	public static String toStringYYYYMMDD_HHmmssSSS(Date date){
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return timeFormat.format(date);
	}
	
	public static String now_HHmmssSSS() {
		Date now = new Date();
		return HHmmssSSS(now);
	}
	

	public static GregorianCalendar toGregorianCalendar(String dateStr)//Occhio a getPCN1_O_DECA_CONV portata a YYYYMMDD su dateStr
	{
		SimpleDateFormat formatter;
		GregorianCalendar gc;
		Date date =new Date();
		if (null!=dateStr && !dateStr.trim().equals("")) {
			formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				date = formatter.parse(dateStr);
			} catch (ParseException Ex) {
				//log.error("intercettato errore applicativo: " + Ex.getMessage());
			}
			gc = new GregorianCalendar();
			gc.setTime(date);
			return gc;
		}
		return null;
	}

	/**
	 * Da GregorianCalendar a dd-MM-yyyy
	 */
	public static String fromGregorianCalendar(GregorianCalendar gc){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dataValue = dateFormat.format(gc.getTime());
		return dataValue;
	}
	
	/**
	 * Da Calendar a dd-MM-yyyy
	 */
	public static String fromCalendar(Calendar gc){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dataValue = dateFormat.format(gc.getTime());
		return dataValue;
	}
	
	
	/**
	 * Da YYYYMMDD a DD-MM-YYYY
	 */
	public static String fromDate(String data) {
		String result="";
		if(data.length()==8)
		{
			result+=data.substring(6)+"-";
			result+=data.substring(4,6)+"-";
			result+=data.substring(0,4);
		}
		if(result.equals(""))
			result = data;
		return result;
	}
	
	/**
	 * Da DD-MM-YYYY a YYYYMMDD
	 */
	public static String toDate(String data) {
		if (data == null)
			return null;
		String result = data;
		if(data.length() == 10)
			result=data.substring(6,10)+data.substring(3,5)+data.substring(0,2);
		return result;
	}
	
	/**
	 * Da YYYYMMDD a YYYY-MM-DD
	 */
	public static String toDateHostOrigination(String data) {
		String result = data;
		if(data.length() == 8)
			result=data.substring(0,4)+"-"+data.substring(4,6)+"-"+data.substring(6,8);
		return result;
	}
	
	/**
	 * Da YYYYMMDD a DD.MM.YYYY
	 */
	public static String toDateHostCmlt(String data) {
		String result = data;
		if(data.length() == 8)
			result=data.substring(6,8)+"."+data.substring(4,6)+"."+data.substring(0,4);
		return result;
	}
	

	/**
	 * Da DD.MM.YYYY a YYYYMMDD
	 */
	public static String fromDateHostCmlt(String data) {
		String result = data;
		if(data.length() == 10){
			result=data.substring(6)+data.substring(3,5)+data.substring(0,2);
		}
		return result;
	}
	
	/**
	 * Resituisce date nel formato "DD <mese in parole> YYYY" a partire da DD-MM-YYYY
	 */
	public static String toLongDate(String dateStr) {
		SimpleDateFormat formatter;
		Date date =new Date();
		if (null!=dateStr && !dateStr.trim().equals("")) {
			formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				date = formatter.parse(dateStr);
				return DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALIAN).format(date);

			} catch (ParseException Ex) {
				return dateStr;
			}
		}
		return dateStr;
	}
	
	/**
	 * Restituisce una stringa nel formato YYYYMMDD che rappresenta la data in input (nel formato )
	 * più n giorni
	 */
	public static String addNDays(String dataIniziale, int n){
		GregorianCalendar data = toGregorianCalendar(Format.fromDate(dataIniziale));
		data.add(GregorianCalendar.DAY_OF_MONTH, n);
		return toDate(fromGregorianCalendar(data));
	}
	
	/**
	 * Restituisce una stringa nel formato YYYYMMDD che rappresenta la data in input (nel formato )
	 * più n anni
	 */
	public static String addNYears(String dataIniziale, int n){
		String data = dataIniziale;
		if(dataIniziale!=null && !dataIniziale.equals("") && dataIniziale.length()==8){
			int anni = (new Integer(dataIniziale.substring(0,4))).intValue();
			anni += n;
			
			data = (new Integer(anni)).toString() + dataIniziale.substring(4);
		}
			
		return data;
	}
	
	/**
	 * Restituisce la data calcolata aggiungendo i giorni lavorativi indicati alla data specificata
	 * (tenendo dunque conto anche delle festività)
	 * 
	 * @param startDate
	 * @param days
	 *            (working days)
	 * @return resultDate = startDate + working days + weekends + holidays
	 */
	public static Date addNWorkingDays(Date startDate, int days) {
		// check input
		if (startDate == null)
			throw new IllegalArgumentException("startDate cannot be null");
		if (days < 0)
			throw new IllegalArgumentException("Number of working days to add must be non-negative");
		
		Calendar date = new GregorianCalendar();
		date.setTime(startDate);
		
		// cicla sul numero di giorni da aggiungere
		for (int i = 0; i < days; i++) {
			
			// verifica se il giorno corrente ed eventualmente i successivi sono festivi: in tal
			// caso, per ogni festività aggiungi un giorno alla data corrente
			while (!isWorkingDay(date))
				date.add(Calendar.DATE, 1);
			
			// aggiungi un giorno (lavorativo) alla data corrente
			date.add(Calendar.DATE, 1);
		}
		
		// se il giorno corrente (l'ultimo calcolato) ed eventualmente i successivi non sono
		// lavorativi, aggiungi giorni alla data corrente
		while (!isWorkingDay(date))
			date.add(Calendar.DATE, 1);
		return date.getTime();
	}
	
	private static boolean isWorkingDay(Calendar date) {
		// Verifica weekend
		if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
		    date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			return false;
		
		// Verifica festività fisse
		int dateMD = date.get(Calendar.MONTH) * 100 + date.get(Calendar.DATE);
		if (holidays.contains(dateMD))
			return false;
		
		// Verifica Pasqua e Pasquetta
		Calendar easter = getEaster(date.get(Calendar.YEAR));
		Calendar easterMonday = getEaster(date.get(Calendar.YEAR));
		easterMonday.add(Calendar.DATE, 1);
		int easterMD = easter.get(Calendar.MONTH) * 100 + easter.get(Calendar.DATE);
		int easterMondayMD = easter.get(Calendar.MONTH) * 100 + easter.get(Calendar.DATE);
		if (easterMD == dateMD || easterMondayMD == dateMD)
			return false;

		return true;
	}

	/**
	 * Calcola quando cade la Pasqua in un dato anno (secondo l'algoritmo di Gauss)
	 * 
	 * @param year
	 * @return Il giorno di Pasqua nell'anno indicato
	 */
	private static Calendar getEaster(int year) {
		if (year < 1583 || year > 2499)
			//log.error("WARNING: isWorkingDay - calcolo della data di easter potenzialmente errato, anno fuori range massimo: " + year);
		
		if (easters.containsKey(year))
			return (Calendar) easters.get(year).clone();
		
		int a = year % 19;
		int b = year % 4;
		int c = year % 7;
		
		// parametri m, n dipendono dal secolo
		int m = 0;
		int n = 0;
		if ((year >= 1583) && (year <= 1699)) {
			m = 22;
			n = 2;
		}
		if ((year >= 1700) && (year <= 1799)) {
			m = 23;
			n = 3;
		}
		if ((year >= 1800) && (year <= 1899)) {
			m = 23;
			n = 4;
		}
		if ((year >= 1900) && (year <= 2099)) {
			m = 24;
			n = 5;
		}
		if ((year >= 2100) && (year <= 2199)) {
			m = 24;
			n = 6;
		}
		if ((year >= 2200) && (year <= 2299)) {
			m = 25;
			n = 0;
		}
		if ((year >= 2300) && (year <= 2399)) {
			m = 26;
			n = 1;
		}
		if ((year >= 2400) && (year <= 2499)) {
			m = 25;
			n = 1;
		}
		
		int d = (19 * a + m) % 30;
		int e = (2 * b + 4 * c + 6 * d + n) % 7;
		
		Calendar easter = new GregorianCalendar();
		easter.set(Calendar.YEAR, year);
		
		// Se (d + e) < 10, allora la Pasqua cade il giorno (d + e + 22) del mese di marzo
		if (d + e < 10) {
			easter.set(Calendar.MONTH, Calendar.MARCH);
			easter.set(Calendar.DAY_OF_MONTH, d + e + 22);
		}
		// altrimenti si verificherà il (d + e - 9)-esimo giorno del mese di aprile
		else {
			easter.set(Calendar.MONTH, Calendar.APRIL);
			int day = d + e - 9;
			// eccezioni:
			// se la data risultante è il 26 aprile, allora la Pasqua è il 19 aprile;
			if (day == 26) {
				day = 19;
			}
			// se la data risultante è il 25 aprile, e d = 28, e = 6, a > 10, allora la Pasqua è
			// il 18 aprile
			if ((day == 25) && (d == 28) && (e == 6) && (a > 10)) {
				day = 18;
			}
			easter.set(Calendar.DAY_OF_MONTH, day);
		}
		
		easters.put(year, easter);
		return easter;
	}
	
	/**
	 * Restituisce una stringa nel formato DD-MM-YYYY che rappresenta la data in input (nel formato )
	 * più n giorni
	 */
	public static String addNDaysViewFormat(String dataIniziale, int n){
		GregorianCalendar data = toGregorianCalendar(dataIniziale);
		data.add(GregorianCalendar.DAY_OF_MONTH, n);
		return fromGregorianCalendar(data);
	}
	
	/**
	 * Restituisce una stringa nel formato DD-MM-YYYY che rappresenta la data in input (nel formato )
	 * più n mesi
	 */
	public static String addNMonthsViewFormat(String dataIniziale, int n){
		GregorianCalendar data = toGregorianCalendar(dataIniziale);
		data.add(GregorianCalendar.MONTH, n);
		return fromGregorianCalendar(data);
	}
	
	/**
	 * A partire da una data nel formato dd-mm-yyyy determina il trimestre in cui cade e a partire
	 * da quello ritorna l'ultimo giorno del trimestre precedente trimestre precedente
	 * @param data
	 * @return
	 */
	public static String getDataTrimestrePrecedente(String data){
		String dataTrimestreCorrente = getDataTrimestreCorrente(data);
		GregorianCalendar dataTrimestrePrecedente = toGregorianCalendar(dataTrimestreCorrente);
		dataTrimestrePrecedente.add(Calendar.DAY_OF_MONTH,-1);
		
		return fromGregorianCalendar(dataTrimestrePrecedente);
	}
	
	/**
	 * A partire da una data nel formato dd-mm-yyyy determinal'ultimo giorno del mese precedente
	 * @param data
	 * @return
	 */
	public static String getDataFineMesePrecedente(String data) throws Exception{

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime((new SimpleDateFormat("dd-MM-yyyy")).parse(data));
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		final Date dataNuova = calendar.getTime();
		
		return new SimpleDateFormat("dd-MM-yyyy").format(dataNuova);
	}
	
	/**
	 * A partire da una data nel formato dd-mm-yyyy determinal'ultimo giorno del mese 
	 * @param data
	 * @return
	 */
	public static String getDataFineMese(String data) throws Exception{

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime((new SimpleDateFormat("dd-MM-yyyy")).parse(data));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		final Date dataNuova = calendar.getTime();
		
		return new SimpleDateFormat("dd-MM-yyyy").format(dataNuova);
	}
	
	/**
	 * A partire da una data nel formato dd-mm-yyyy determina il trimestre in cui cade
	 * @param data
	 * @return
	 */
	public static String getDataTrimestreCorrente(String data){
		String anno = data.split("-")[2];
		GregorianCalendar dataInput = toGregorianCalendar(data);
		GregorianCalendar dataPrimoTrimestre = toGregorianCalendar("01-01-"+anno);
		
		String dataTrimestreCorrente = getDataTrimestre(dataInput, dataPrimoTrimestre);
		
		return dataTrimestreCorrente;
	}
	
//	/**
//	 * A partire da una data nel formato Date determina il trimestre in cui cade
//	 * 
//	 * @param data
//	 * @return data di inizio del trimestre che comprende la data passata come parametro
//	 */
//	public static Date getDataTrimestreCorrente(Date data) throws Exception {
//		GregorianCalendar dataInput = new GregorianCalendar();
//		dataInput.setTime(data);
//		GregorianCalendar dataPrimoTrimestre = toGregorianCalendar("01-01-" + dataInput.get(Calendar.YEAR));
//		
//		String dataTrimestreCorrente = getDataTrimestre(dataInput, dataPrimoTrimestre);
//		
//		return ConverterUtils.toDate(dataTrimestreCorrente, "dd-MM-yyyy");
//	}

	private static String getDataTrimestre(GregorianCalendar data, GregorianCalendar dataTrimestreInEsame){
		GregorianCalendar dataTrimestreSuccessivo = toGregorianCalendar(fromGregorianCalendar(dataTrimestreInEsame));
		dataTrimestreSuccessivo.add(Calendar.MONTH,3);
		
		if(dataTrimestreSuccessivo.after(data))
			return fromGregorianCalendar(dataTrimestreInEsame);
		else{
			return getDataTrimestre(data, dataTrimestreSuccessivo);
		}
	}
	
	/**
	 * A partire da una data nel formato dd-mm-yyyy determina il semestre in cui cade e a partire 
	 * da quello ritorna l'ultimo giorno del trimestre precedente semestre precedente
	 * @param data
	 * @return
	 */
	public static String getDataSemestrePrecedente(String data){
		String dataSemestreCorrente = getDataSemestreCorrente(data);
		GregorianCalendar dataSemestrePrecedente = toGregorianCalendar(dataSemestreCorrente);
		dataSemestrePrecedente.add(Calendar.DAY_OF_MONTH,-1);
		
		return fromGregorianCalendar(dataSemestrePrecedente);
	}
	
	/**
	 * A partire da una data nel formato dd-mm-yyyy determina il trimestre in cui cade
	 * @param data
	 * @return
	 */
	public static String getDataSemestreCorrente(String data){
		String anno = data.split("-")[2];
		GregorianCalendar dataInput = toGregorianCalendar(data);
		GregorianCalendar dataPrimoSemestre = toGregorianCalendar("01-01-"+anno);
		
		String dataSemestreCorrente = getDataSemestre(dataInput, dataPrimoSemestre);
		
		return dataSemestreCorrente;
	}
	
	private static String getDataSemestre(GregorianCalendar data, GregorianCalendar dataSemestreInEsame){
		GregorianCalendar dataSemestreSuccessivo = toGregorianCalendar(fromGregorianCalendar(dataSemestreInEsame));
		dataSemestreSuccessivo.add(Calendar.MONTH,6);
		
		if(dataSemestreSuccessivo.after(data))
			return fromGregorianCalendar(dataSemestreInEsame);
		else{
			return getDataTrimestre(data, dataSemestreSuccessivo);
		}
	}
	
	/**
	 * Converte una data dal formato dd-mm-yyyy al formato "dd month yyyy"
	 * dove month è il mese in formato stringa
	 */
	public static String dataFormatoStringa(String data){
		String month;
		String dataFormatoStringa = data;
		
		if(!data.equals("") && data.length()==10){
			String[] elementiData = data.split("-");
			
			int gmese=(new Integer(elementiData[0])).intValue();
			int mese=(new Integer(elementiData[1])).intValue();
			int anno=(new Integer(elementiData[2])).intValue();
			  
			switch(mese){
			case 1: month="gennaio"; break;
			case 2: month="febbraio"; break;
			case 3: month="marzo"; break;
			case 4: month="aprile"; break;
			case 5: month="maggio"; break;
			case 6: month="giugno"; break;
			case 7: month="luglio"; break;
			case 8: month="agosto"; break;
			case 9: month="settembre"; break;
			case 10: month="ottobre"; break;
			case 11: month="novembre"; break;
			case 12: month="dicembre"; break;
			default: month="Errore";
			}
			dataFormatoStringa = gmese+" "+month+" "+anno;
		}
		return dataFormatoStringa;
  
	}

	
	public static String DATA_LIMITE_INFERIORE = "19510101";
	public static String DATA_LIMITE_SUPERIORE = "99991231";
	
	public static String decodeMeseRiferimentoMint(String RIFERIMENTO_MINT) {
		String riferimento_mint="";
		try{
			if (!"".equals(RIFERIMENTO_MINT) && !"999999".equals(RIFERIMENTO_MINT)) {
				String annoRiferimentoMINT = RIFERIMENTO_MINT.substring(0,4);
				int meseRiferimentoMINT = new Integer(RIFERIMENTO_MINT.substring(4, 6)).intValue();
				
				switch (meseRiferimentoMINT) {
				case 1:
					riferimento_mint = "GENNAIO";
					break;
				case 2:
					riferimento_mint = "FEBBRAIO";
					break;
				case 3:
					riferimento_mint = "MARZO";
					break;
				case 4:
					riferimento_mint = "APRILE";
					break;
				case 5:
					riferimento_mint = "MAGGIO";
					break;
				case 6:
					riferimento_mint = "GIUGNO";
					break;
				case 7:
					riferimento_mint = "LUGLIO";
					break;
				case 8:
					riferimento_mint = "AGOSTO";
					break;
				case 9:
					riferimento_mint = "SETTEMBRE";
					break;
				case 10:
					riferimento_mint = "OTTOBRE";
					break;
				case 11:
					riferimento_mint = "NOVEMBRE";
					break;
				case 12:
					riferimento_mint = "DICEMBRE";
					break;
				default:
					riferimento_mint = "";
					break;
				}
				if (!riferimento_mint.equals(""))
					riferimento_mint += " " + annoRiferimentoMINT;
			}
		}catch(Exception e){
			riferimento_mint = "";
		}
		return riferimento_mint;
	}
	
	public static String decodeMeseAnnoRifMint(String RIFERIMENTO_MINT) {
		String riferimento_mint="";
		if (!RIFERIMENTO_MINT.equals("") && !RIFERIMENTO_MINT.equals("999999")) {
			String annoRiferimentoMINT = RIFERIMENTO_MINT.substring(2,6);
			int meseRiferimentoMINT = new Integer(RIFERIMENTO_MINT.substring(0, 2)).intValue();
			
			switch (meseRiferimentoMINT) {
			case 1:
				riferimento_mint = "GEN";
				break;
			case 2:
				riferimento_mint = "FEB";
				break;
			case 3:
				riferimento_mint = "MAR";
				break;
			case 4:
				riferimento_mint = "APR";
				break;
			case 5:
				riferimento_mint = "MAG";
				break;
			case 6:
				riferimento_mint = "GIU";
				break;
			case 7:
				riferimento_mint = "LUG";
				break;
			case 8:
				riferimento_mint = "AGO";
				break;
			case 9:
				riferimento_mint = "SET";
				break;
			case 10:
				riferimento_mint = "OTT";
				break;
			case 11:
				riferimento_mint = "NOV";
				break;
			case 12:
				riferimento_mint = "DIC";
				break;
			default:
				riferimento_mint = "";
				break;
			}
			if (!riferimento_mint.equals(""))
				riferimento_mint += " " + annoRiferimentoMINT;
		}
		return riferimento_mint;
	}
	
	/**
	 * Controlli validità date restituite da MLT. Il metodo verifica che siano valorizzate le date fornite dalle BS di CMLT/Origination con valori diversi da 00.00.0000,
	 * inoltre verifica che data inizio sia minore di data fine
	 * i controlli vengono fatti sulle date in formato dd.mm.yyyy
	 * @param dataInizio
	 * @param dataFine
	 * @param idDataInizio
	 * @param idDataFine
	 * @return
	 */
	public static String verificaValoriDateMlt(String dataInizio, String dataFine, String idDataInizio, String idDataFine){
		
		String strEsitoVerifica = "";
		
		if(dataInizio.equals("00.00.0000") && dataFine.equals("00.00.0000")){
			strEsitoVerifica = "Non sono verificate le condizioni per l'applicazione dello sconto (00.00.0000 per "+idDataInizio+" e "+ idDataFine+ " )";
		}
		else if(dataInizio.equals("00.00.0000")){
			strEsitoVerifica = idDataInizio +" valorizzata a 00.00.0000";
		}
		else if(dataFine.equals("00.00.0000")){
			strEsitoVerifica = idDataFine +" valorizzata a 00.00.0000";
		}
		
		if(strEsitoVerifica.equals("")){
			//verifico data deco <= dataDeca
			if((fromDateHostCmlt(dataInizio)).compareTo(fromDateHostCmlt(dataFine)) > 0){
				strEsitoVerifica = idDataInizio +" maggiore della "+ idDataFine+".";
			}
		}
		
		return strEsitoVerifica;
	}
	/***
	 * Formato data input: YYYYMMDD
	 * @param data
	 */
	public static String getDataInizioMese (String data){
		if(data!=null)
			return data.substring(0,6)+"01";
		
		return "";
	}
	/***
	 * Confronta data1 con data2. Se data1 è successiva a data2, restituisce true. Date in formato YYYYMMDD
	 * @param data1
	 * @param data2
	 * @return
	 */
	
	public static boolean isMajorDate (String data1, String data2){
		
		Date d1 = new Date(Integer.parseInt(data1.substring(0,4)), Integer.parseInt(data1.substring(4,6))-1, Integer.parseInt(data1.substring(6)));
		Date d2 = new Date(Integer.parseInt(data2.substring(0,4)), Integer.parseInt(data2.substring(4,6))-1, Integer.parseInt(data2.substring(6)));
		
		return d1.compareTo(d2) > 0;
		
	}
	
	
}
