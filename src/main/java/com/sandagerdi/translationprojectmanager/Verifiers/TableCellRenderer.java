/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import com.sandagerdi.translationprojectmanager.TableModels.JobsTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jóannes
 */
class TableCellRenderer extends DefaultTableCellRenderer {
    private DatabaseConnection db = new DatabaseConnection();
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        JobsTableModel mymodel = (JobsTableModel) table.getModel();
        Clients client = (Clients) mymodel.getValueAt(row, 0);
        
        //int value  = (MyDocument ) mymodel.ge
        // Set the colors as per the value in the cell...
//        if(isJobFinished()){
//            setBackground(Color.YELLOW);
//        }// and so on...         
        return this;
        //return c;
    }
    
    private boolean isJobFinished(Jobs job){
        
        return true;
    }
}
