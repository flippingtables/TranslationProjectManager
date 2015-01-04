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
}
