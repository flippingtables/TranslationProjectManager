/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Util;

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
            result=true;
        } catch (NumberFormatException e) {
            result=false;
        }
        return result;
    }
}
