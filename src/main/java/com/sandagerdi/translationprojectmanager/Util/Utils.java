/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Util;

import java.text.NumberFormat;
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
}
