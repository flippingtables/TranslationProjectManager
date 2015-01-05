/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

/**
 *
 * @author Jóannes
 */
public class ClientAddVerifier {

    public static boolean ClientInputAccepted(
            String clientContactPhone,
            String clientContactName,
            String clientEmail,
            String clientName
    ) {

        if (clientContactName == null || "".equals(clientContactName)) {
            return false;
        }
        if (clientContactPhone == null || "".equals(clientContactPhone)) {
            return false;
        }
        if (clientEmail == null || "".equals(clientEmail)) {
            return false;
        }
        return !("".equals(clientName) || clientName == null);
    }

    public static boolean StringInputVerifier(String... inputs) {
        for (String string : inputs) {
            if (string == null || "".equals(string)) {
                return false;
            }
        }
        return true;
    }

}
