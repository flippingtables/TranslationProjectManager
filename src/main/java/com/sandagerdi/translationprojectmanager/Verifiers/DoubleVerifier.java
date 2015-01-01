/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Jóannes
 */
public class DoubleVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        boolean verified = false;
        String text = ((JTextField) input).getText();
        try {
            double inputDouble = Double.parseDouble(text);
            
            if (inputDouble >= 0.0){
               verified = true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return verified;
    }
}