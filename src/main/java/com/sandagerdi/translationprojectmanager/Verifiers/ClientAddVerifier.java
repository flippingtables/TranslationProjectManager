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

        if (clientContactName.equals("") || clientContactName.equals(null)) {
            return false;
        }
        if (clientContactPhone.equals("") || clientContactPhone.equals(null)) {
            return false;
        }
        if (clientEmail.equals("") || clientEmail.equals(null)) {
            return false;
        }
        if (clientName.equals("") || clientName.equals(null)) {
            return false;
        }

        return true;
    }

}
