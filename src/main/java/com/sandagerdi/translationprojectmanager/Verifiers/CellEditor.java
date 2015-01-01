/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

import java.awt.Toolkit;
import javax.swing.DefaultCellEditor;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jóannes
 */
public class CellEditor extends DefaultCellEditor {

    InputVerifier verifier = null;
    JTextArea textAreaAllJobs;
    
    public CellEditor(JTextArea textAreaAllJobs, InputVerifier verifier) {
        super(new JTextField());
        
        this.textAreaAllJobs=textAreaAllJobs;
        this.verifier = verifier;
    }

    @Override
    public boolean stopCellEditing() {
                
        if (verifier.verify(editorComponent)==false){
            textAreaAllJobs.append("\n please enter a number.");
        }
        return verifier.verify(editorComponent) && super.stopCellEditing();
    }
    
}
