package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static final LocalDate END_OF_THE_WORLD_DATE = LocalDate.of(9999, 12, 31);
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final LocalDate getLastDayofMonth (LocalDate in){
        return  in.withDayOfMonth(1).minusDays(1);

    }
/*    public static Date addYear(Date ref) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(ref);
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();

    }
*/
/*    public static int daysBetween(Date end, Date start) {

        long difference = end.getTime() - start.getTime();
        double days = difference / (1000 * 60 * 60 * 24);
        int intero = (int) (days * 1000000);
        days = intero / 1000000d;
        double ceil = Math.ceil(days);
        return (int) (ceil);
    }
*/

    public static Date dateFromString(String value, DatePattern pattern) {
        Date date = null;
        if (value == null) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue());
            date = sdf.parse(value);
            // check the overflow/downflow of the value
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {

            DateUtils.logger.debug("Cannot parse value: " + value + " with this pattern: " + pattern.getValue() + " error index:" + ex.getErrorOffset());

        } catch (DateTimeParseException ex) {

            DateUtils.logger.debug("Cannot parse date time of value: " +
                    value + " with this pattern: " + pattern.getValue() + " parsed string: " + ex.getParsedString() + " error index:" + ex.getErrorIndex());

        }
        return date;
    }

    public static LocalDateTime localDateTimeFromString(String value, DatePattern pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getValue());
        LocalDateTime localDateTime = LocalDateTime.parse(value, formatter);
        if (!value.equals(localDateTime.format(formatter))) {
            localDateTime = null;
        }
        return localDateTime;
    }

    public static LocalDate localDateFromString(String value, DatePattern pattern) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern.getValue()));
    }

    public static String localDateToString(LocalDate localDate, DatePattern pattern) {
        if (localDate == null) {
            return null;
        }
        LocalDateTime ldt = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0, 0));
        return DateUtils.localDateToString(ldt, pattern);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, DatePattern pattern) {
        if (localDateTime == null) {
            return null;
        }
        return DateUtils.localDateToString(localDateTime, pattern);
    }

    public static String localDateToString(LocalDateTime localDateTime, DatePattern pattern) {
        String patternStr = pattern.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternStr);
        if (patternStr.contains("Z")) {
            ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Rome"));
            return zonedDateTime.format(formatter);
        } else {
            return localDateTime.format(formatter);
        }
    }

    public static LocalDateTime localDateTimeFromEpochString(String epoch) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(epoch)),
                ZoneId.systemDefault());
    }

    public static XMLGregorianCalendar localDateToXmlGregorian(LocalDate date) {
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.of("Europe/Rome")));
        XMLGregorianCalendar xcal = null;
        try {
            xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException e) {
            throw new TechnicalException("Convert error into DateUtils.localDateToXmlGregorian", "", e);
        }
        return xcal;
    }

    public static XMLGregorianCalendar sysDateToXmlGregorian() {
        GregorianCalendar gcal = GregorianCalendar.from(LocalDate.now().atStartOfDay(ZoneId.of("Europe/Rome")));
        gcal.setTime(new Date());
        XMLGregorianCalendar xcal;
        try {
            xcal = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gcal.get(Calendar.YEAR), gcal.get(Calendar.MONTH) + 1, gcal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            throw new TechnicalException("Convert error into DateUtils.sysDateToXmlGregorian", "", e);
        }
        return xcal;

    }

    public static XMLGregorianCalendar stringToXmlGregorian(String dateString, DatePattern pattern) throws ParseException, DatatypeConfigurationException {
        DateFormat format = new SimpleDateFormat(pattern.getValue());
        Date date = format.parse(dateString);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
    }

    public static XMLGregorianCalendar localDateToXmlGregorian(LocalDateTime datetime) {
        DateFormat format = new SimpleDateFormat(DatePattern.ISO_ZONED.getValue());
        try {
            Date date = format.parse(DateUtils.localDateToString(datetime, DatePattern.ISO_ZONED));
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);

            return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException | ParseException e) {
            throw new TechnicalException("Convert error into DateUtils.localDateToXmlGregorian", "", e);
        }
    }

    public static LocalDate xmlGregorianToLocalDate(XMLGregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return date.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    public static LocalDateTime xmlGregorianToLocalDateTime(XMLGregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return date.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }

    public static boolean isValidFormat(String value, DatePattern format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            DateUtils.logger.debug("Cannot parse value: " + value + " with this pattern: " + format.getValue() + " error index:" + ex.getErrorOffset());
        }
        return date != null;
    }

    public static LocalDate localDateNow() {
        return LocalDate.now(ZoneId.of("Europe/Rome"));
    }

    public static LocalDateTime localDateTimeNow() {
        return LocalDateTime.now(ZoneId.of("Europe/Rome"));
    }

    public static boolean hasAgeRequirement(LocalDate birthDate, int minimumAge, LocalDate referenceDate) {
        Period age = Period.between(birthDate, referenceDate);
        return age.getYears() >= minimumAge;
    }

    //calculate  age
    public static int getAge(LocalDate birthDate, LocalDate referenceDate) {
        Period age = Period.between(birthDate, referenceDate);
        return age.getYears();
    }


    /*public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar) {

        return xmlGregorianCalendar.toGregorianCalendar().getTime();

    }*/

    public enum DatePattern {

        

        ANAG("yyyyMMdd"),
        ISO("yyyy-MM-dd'T'HH:mm:ss.SSS"),
        ISO_ZONED("yyyy-MM-dd'T'HH:mm:ss.SSZ"),
        ISO_DATE("yyyy-MM-dd"),
        ISO_IT_SLASH("dd/MM/yyyy HH:mm:ss"),
        RUD("ddMMyyyyHHmmssSS"),
        AUP("yyyyMMddHHmmss"),
        LIVECYCLE("dd.MM.yyyy"),
        LIVECYCLE_TIME("HH:mm:ss"),
        LIVECYCLE_SLASH("dd/MM/yyyy"),
        WFM_DATIAGGIUNTIVI("yyyy-MM-dd'T'HH:mm:ss.SSZ"),
        GIORNALE("yyyy-MM-dd'T'HH:mm:ss"),
        T1SAVESPRA("yyyyMMdd"),
        PRICE("yyyyMMdd"),
        PRICE_GESTIONE("dd.MM.yyyy"),
        GESTIONE_RAPPORTI("yyyyMMdd"),
        CNDPRICEMS("yyyyMMdd"),
        STOREPARAM("ddMMyyyy HHmmss"),
        BATCH_ISSC("yyyyMM"),
        BATCH_RETRO_ISSC("yyyyMMdd"),
        BATCH_RETRO_ISSC_PERIOD("yyyyMM"),
        BATCH_CDM_DATE("yyyyMMdd"),
        BATCH_CDM_DATETIME("yyyyMMddHHmmss"),
        BATCH_CDM_TIME("HHmmss"),
        BATCH_DEBIT_DATE("dd.MM.yyyy"),
        NOTIFICATOR_TIMESTAMP("yyyyMMddHHmmssSSSSSS"),
        MCT_DATE("yyyyMMdd"),
        MCT_TIME("HHmmss"),
        MCT_DDMM("ddMM"),
        PROMOTION_DATE("yyyyMMdd"),
        CUSTOMER_DATA_DATE("yyyyMMdd"),
        INVOICE_DESCRIPTION("dd.MM.yyyy"),
        CONTI("yyyyMMdd"),
        CONTI_BLOCK_KEY("yyyyMMddHHmmss"),
        REPORT_ISSC_DESCRIPTION("MMyyyy"),
        QUAD_MCT("yyyyMMdd:HH:mm"),
        RIORD_DATE_GENE("yyMMdd"),
        RIORD_TIME("HHmmss"),
        RIORD_DATE_OP("yyyyMMdd");

        private String value;

        DatePattern(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
