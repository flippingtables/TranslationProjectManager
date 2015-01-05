/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jóannes
 */
public class ClipboardManager {

    /**
     * Get the String residing on the clipboard.
     *
     * @return any text found on the Clipboard; if none found, return an empty
     * String.
     */
    public static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText
                = (contents != null)
                && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public static Map<String, String> getMatchingJobsFromClipBoard(){
        String[] input = getClipboardContents().split("\n");
        Map<String, String> result = new HashMap<>();
        Map<String, String> maps = new HashMap<>();
        maps.put("hours", "(Hours:? )(\\d+)");
        maps.put("rep", "(Repetitions:? )(\\d+)");
        maps.put("ice", "(ICE Matches:? )(\\d+)");
        maps.put("match", "(100% Matches:? )(\\d+)");
        maps.put("95", "(Fuzzy 95% - 99%:? )(\\d+)");
        maps.put("85", "(Fuzzy 85% - 94%:? )(\\d+)");
        maps.put("75", "(Fuzzy 75% - 84%:? )(\\d+)");
        maps.put("50", "(Fuzzy 50% - 74%:? )(\\d+)");
        maps.put("new", "(New Words:? )(\\d+)");
        maps.put("review", "(Review Words:? )(\\d+)");
        maps.put("due", "^(Due:?) (.*)$");
        
        for (String ssn : input) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                Pattern p = Pattern.compile(entry.getValue());
                Matcher m = p.matcher(ssn);
                if (m.find()) {
                    int count = m.groupCount();
                    for (int i = 1; i <= count; i++) {
                        System.out.print(m.group(i));
                        System.out.print("\t");
                        
                    }
                    result.put(entry.getKey(), m.group(2));
                    System.out.println("");
                }
            }

        }
        return result;
    }
}
