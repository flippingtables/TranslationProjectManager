/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

import java.awt.Color;
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
                input.setBackground(Color.WHITE);
                verified = true;
            } else {
                input.setBackground(Color.RED);
            }
        } catch (NumberFormatException e) {
            input.setBackground(Color.RED);
        }
        return verified;
    }
}