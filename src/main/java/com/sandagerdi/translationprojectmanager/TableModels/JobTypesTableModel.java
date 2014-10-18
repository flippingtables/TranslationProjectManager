/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.TableModels;

import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jóannes
 */
public class JobTypesTableModel extends AbstractTableModel {

    DatabaseConnection db = null;

    public String[] m_colNames = {"Client", "Service", "Source", "Target",
        "Hour", "New", "Fuzzy 50", "Fuzzy 75",
        "Fuzzy 85", "Fuzzy 95", "Match", "Rep",
        "ICE", "Min", "Rush %"};
    public Class[] m_colTypes = {Clients.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class,
        String.class, String.class, String.class, String.class,
        String.class, String.class, String.class};
    private Vector m_macDataVector;

    public void setM_macDataVector(Vector m_macDataVector) {
        this.m_macDataVector = m_macDataVector;
    }

    public JobTypesTableModel(Vector macDataVector) {
        super();
        m_macDataVector = macDataVector;
    }

    public int getColumnCount() {
        return m_colNames.length;
    }

    public int getRowCount() {
        return m_macDataVector.size();
    }

    public void setValueAt(Object value, int row, int col) {
        if (db == null) {
            db = new DatabaseConnection();
        }
//        DatabaseConnection db = new DatabaseConnection();
//        CloseableIterator<JobTypes> c = null;
//        c = db.getJobTypesDao().closeableIterator();

        JobTypes macData = (JobTypes) (m_macDataVector.elementAt(row));

        switch (col) {
            case 0:
                macData.setClient((Clients) value);
                break;
            case 1:
                macData.setService((String) value);
                break;
            case 2:
                macData.setSource_lang((String) value);
                break;
            case 3:
                macData.setTarget_lang((String) value);
                break;
            case 4:
                macData.setPay_hour((double) value);
                break;
            case 5:
                macData.setWords_new((double) value);
                break;
            case 6:
                macData.setWords_fuzzy50((double) value);
                break;
            case 7:
                macData.setWords_fuzzy75((double) value);
                break;
            case 8:
                macData.setWords_fuzzy85((double) value);
                break;
            case 9:
                macData.setWords_fuzzy95((double) value);
                break;
            case 10:
                macData.setWords_match((double) value);
                break;
            case 11:
                macData.setWords_rep((double) value);
                break;
            case 12:
                macData.setWords_ice((double) value);
                break;
            case 13:
                macData.setPay_minimum((double) value);
                break;
            case 14:
                macData.setPay_rush((double) value);
                break;
        }
        try {
            db.getJobTypesDao().createOrUpdate(macData);
            fireTableCellUpdated(row, col);
        } catch (SQLException ex) {
            Logger.getLogger(ClientTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getColumnName(int col) {
        return m_colNames[col];
    }

    public Class getColumnClass(int col) {
        return m_colTypes[col];
    }

    public Object getValueAt(int row, int col) {
        JobTypes macData = (JobTypes) (m_macDataVector.elementAt(row));

        switch (col) {
            case 0:
                return ((Clients) macData.getClient()).toString();
            case 1:
                return macData.getService();
            case 2:
                return macData.getSource_lang();
            case 3:
                return macData.getTarget_lang();
            case 4:
                return macData.getPay_hour();
            case 5:
                return macData.getWords_new();
            case 6:
                return macData.getWords_fuzzy50();
            case 7:
                return macData.getWords_fuzzy75();
            case 8:
                return macData.getWords_fuzzy85();
            case 9:
                return macData.getWords_fuzzy95();
            case 10:
                return macData.getWords_match();
            case 11:
                return macData.getWords_rep();
            case 12:
                return macData.getWords_ice();
            case 13:
                return macData.getPay_minimum();
            case 14:
                return macData.getPay_rush();
        }

        return new String();
    }

    public boolean isCellEditable(int row, int column) {
        return (column != 4);
    }
}
