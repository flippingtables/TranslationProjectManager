/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Util;

import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ListSelectionModel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Jóannes
 */
public class Utils {

    //Used for checking if a string is parseable to a double
    public static boolean parseableDouble(String input) {
        boolean result = false;
        try {
            Double.parseDouble(input);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
    
    public static double toDouble(String input){
        return Double.parseDouble(input);
    }

    public static Date parseHoursMinutes(String string) {
        DateTimeFormatter dateStringFormat = DateTimeFormat.forPattern("HH:mm");
        System.out.println("Input: "+ string);
        DateTime time = dateStringFormat.parseDateTime(string);
        
        System.out.println("Parsed time: "+time.getHourOfDay()+":"+time.getMinuteOfHour());
        if (time == null) {
            return null;
        } else {
            return time.toDate();
        }
    }
    
    public static String formatDoubleToLocale(double input){
        
        NumberFormat numberFormatter;
        
        numberFormatter = NumberFormat.getNumberInstance(Locale.getDefault());
        numberFormatter.setMaximumFractionDigits(2);
        
        return numberFormatter.format(input);
    }
    
    public static String convertTo24HoursFormat(String twelveHourTime)
            throws ParseException {
        // Replace with KK:mma if you want 0-11 interval
        DateFormat TWELVE_TF = new SimpleDateFormat("hh:mma");
    // Replace with kk:mm if you want 1-24 interval
        DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("kk:mm");
    
        return TWENTY_FOUR_TF.format(
                TWELVE_TF.parse(twelveHourTime));
    }
    
    public static Format getLocaleSpecificCurrencyFormat(){
         Format currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
         return currency;
    }
    public static Format getLocaleSpecificNumberFormat(){
         Format number = NumberFormat.getNumberInstance(Locale.getDefault());
         return number;
    }
    
    public static Format getLocaleSpecificDateFormat(){
         Format date = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
         return date;
    }   
    
    public static int[] getSelectedRows(ListSelectionModel selection) {
        int iMin = selection.getMinSelectionIndex();
        int iMax = selection.getMaxSelectionIndex();
        if ((iMin == -1) || (iMax == -1)) {
            return new int[0];
        }
        int[] rvTmp = new int[1 + (iMax - iMin)];
        int n = 0;
        for (int i = iMin; i <= iMax; i++) {
            if (selection.isSelectedIndex(i)) {
                rvTmp[n++] = i;
            }
        }
        int[] rv = new int[n];
        System.arraycopy(rvTmp, 0, rv, 0, n);
        return rv;
    }
    
    /* Month */
    public static DateTime endOfMonth(DateTime dateTime) {
        return endOfDay(dateTime).withDayOfMonth(dateTime.dayOfMonth().getMaximumValue());
    }

    public static DateTime beginningOfMonth(DateTime dateTime) {
        return beginningOfday(dateTime).withDayOfMonth(1);
    }

    /* Day */
    public static DateTime endOfDay(DateTime dateTime) {
        return endOfHour(dateTime).withHourOfDay(23);
    }

    public static DateTime beginningOfday(DateTime dateTime) {
        return beginningOfHour(dateTime).withHourOfDay(0);
    }

    /* Hour */
    public static DateTime beginningOfHour(DateTime dateTime) {
        return dateTime.withMillisOfSecond(0).withSecondOfMinute(0).withMinuteOfHour(0);
    }

    public static DateTime endOfHour(DateTime dateTime) {
        return dateTime.withMillisOfSecond(999).withSecondOfMinute(59).withMinuteOfHour(59);
    }
}
