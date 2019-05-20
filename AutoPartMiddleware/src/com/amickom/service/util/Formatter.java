package com.amickom.service.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author David Omar S�nchez Rodr�guez
 * Na-at Consulting S.C.
 * 23/07/2009
 * Formatter.java
 */
public class Formatter {

    /**
     * NBSP
     */
    public static final String NBSP = "&nbsp;";
    /**
     * log
     */
    protected static final Logger log = Logger.getLogger(Formatter.class);
    /**
     * decimalFormat
     */
    private static DecimalFormat decimalFormat;
    /**
     * decimalFormatSC
     */
    private static DecimalFormat decimalFormatSC;
    /**
     * SimpleDateFormat
     */
    public static SimpleDateFormat ddMMyyFormat;
    /**
     * fullDateFormat
     */
    private static DateFormat fullDateFormat;
    /**
     * fullDateFormat
     */
    public static DateFormat MMddyyytFormat;
    /**
     * dateWithoutYear
     */
    private static DateFormat dateWithoutYear;
    /**
     * AMPM
     */
    public static final String[] AMPM = {"am", "pm"};
    /**
     * AMPM
     */
    public static final String MAR = "Mar";
    /**
     * MONTHS
     */
    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo",
        "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre", ""};
    /**
     * WEEKDAYS
     */
    public static final String[] WEEKDAYS = {"", "Domingo", "Lunes",
        "Martes", "Mi�rcoles", "Jueves", "Viernes", "S�bado"};
    /**
     * SHORT_MONTHS
     */
    public static final String[] SHORT_MONTHS = {"Ene", "Feb", MAR,
        "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct",
        "Nov", "Dic", ""};
    /**
     * SHORT_WEEKDAYS
     */
    public static final String[] SHORT_WEEKDAYS = {"", "Dom",
        "Lun", MAR, "Mie", "Jue", "Vie", "Sab"};

    /**
     * 
     */
    private Formatter() {
    }

    static {
        DateFormatSymbols symbols = new DateFormatSymbols();
        symbols.setAmPmStrings(AMPM);
        symbols.setMonths(MONTHS);
        symbols.setShortMonths(SHORT_MONTHS);
        symbols.setWeekdays(WEEKDAYS);
        symbols.setShortWeekdays(SHORT_WEEKDAYS);
        fullDateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", symbols);
        decimalFormat = new DecimalFormat("###,###,##0.00");
        decimalFormatSC = new DecimalFormat("###########0.00");
        ddMMyyFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateWithoutYear = new SimpleDateFormat("dd/MM");
        MMddyyytFormat = new SimpleDateFormat("MM/dd/yyyy");
    }

    /**
     * @param monto monto
     * @return String
     */
    public static String formatMonto(BigDecimal monto) {
        double data = 0;
        if (monto != null) {
            data = monto.doubleValue();
        }
        return formatMonto(data);
    }

    /**
     * @param monto monto
     * @return String
     */
    public static String formatMontoSC(BigDecimal monto) {
        double data = 0;
        if (monto != null) {
            data = monto.doubleValue();
        }
        return formatMontoSC(data);
    }

    /**
     * @param monto monto
     * @return String
     */
    public static String formatMonto(double monto) {
        StringBuffer buffer = new StringBuffer(
                decimalFormat.format(monto));
        return buffer.toString();
    }

    /**
     * @param monto monto
     * @return String
     */
    public static String formatMontoSC(double monto) {
        StringBuffer buffer = new StringBuffer(
                decimalFormatSC.format(monto));
        return buffer.toString();
    }

    /**
     * @param fecha fecha
     * @return String
     */
    public static String formatFechaLarga(Date fecha) {
        if (fecha == null) {
            return NBSP;
        }
        return fullDateFormat.format(fecha);
    }

    /**
     * @param fecha fecha
     * @return String
     */
    public static String formatMMddyyyyFecha(Date fecha) {
        if (fecha == null) {
            return NBSP;
        }
        return MMddyyytFormat.format(fecha);
    }

    /**
     * @param fecha fecha
     * @return String
     */
    public static String formatSA(Date fecha) {
        if (fecha == null) {
            return NBSP;
        }
        return dateWithoutYear.format(fecha);
    }

    /**
     * @param fecha fecha
     * @return String
     */
    public static String formatFechaCorta(Date fecha) {
        if (fecha == null) {
            return NBSP;
        }
        return ddMMyyFormat.format(fecha);
    }
}
