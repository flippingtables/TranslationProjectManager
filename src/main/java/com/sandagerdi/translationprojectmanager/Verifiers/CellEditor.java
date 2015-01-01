/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

import javax.swing.DefaultCellEditor;
import javax.swing.InputVerifier;
import javax.swing.JTextField;

/**
 *
 * @author Jóannes
 */
public class CellEditor extends DefaultCellEditor {

    InputVerifier verifier = null;

    public CellEditor(InputVerifier verifier) {
        super(new JTextField());
        this.verifier = verifier;
    }

    @Override
    public boolean stopCellEditing() {
        return verifier.verify(editorComponent) && super.stopCellEditing();
    }

}
