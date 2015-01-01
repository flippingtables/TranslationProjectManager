/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.TableModels;

import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jóannes
 */
public class JobsTableModel extends AbstractTableModel {

    DatabaseConnection db = null;
    /*Jobs(Clients client, JobTypes jobType, Date dateCreated, Date dateDeadline,
     String description, double pay_hour, double words_new,
     double words_fuzzy50, double words_fuzzy75, double words_fuzzy85,
     double words_fuzzy95, double words_match, double words_rep, double words_ice) {*/
    public String[] m_colNames = {
        "Client", "Service", "Deadline", "Description",
        "Hours", "New", "Fuzzy 50", "Fuzzy 75",
        "Fuzzy 85", "Fuzzy 95", "Match", "Rep", "ICE"};

    public Class[] m_colTypes = {
        Clients.class, JobTypes.class, String.class, String.class,
        String.class, String.class, String.class, String.class,
        String.class, String.class, String.class, String.class, String.class};

    //private Vector m_macDataVector;
    private List<Object> m_macDataVector = Collections.synchronizedList(new ArrayList<Object>());

    public void setM_macDataVector(List<Object> m_macDataVector) {
        this.m_macDataVector = m_macDataVector;
    }

    public JobsTableModel(List<Object> macDataVector) {
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

        Jobs macData = (Jobs) (m_macDataVector.get(row));

        switch (col) {
            case 0:
                macData.setClient((Clients) value);
                break;
            case 1:
                macData.setJobType((JobTypes) value);
                break;
            case 2:
                macData.setDateDeadline((Date) value);
                break;
            case 3:
                macData.setDescription((String) value);
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
        }
        try {
            db.getJobsDao().createOrUpdate(macData);
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
        Jobs macData = (Jobs) (m_macDataVector.get(row));

        switch (col) {
            case 0:
                return ((Clients) macData.getClient()).toString();
            case 1:
                String serv = getService(macData);
                return serv;
            case 2:
                return macData.getDateDeadline().toString();
            case 3:
                return macData.getDescription();
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

        }
        return new String();
    }
    
    public Jobs getValueAtRow(int row) {
        Jobs macData = (Jobs) (m_macDataVector.get(row));

        return macData;
    }

    public boolean isCellEditable(int row, int column) {
        return (column >2);
    }
    
    public String getService(Jobs macData){
        String result = macData.getJobType().getService()+", "+ macData.getJobType().getSource_lang()+", "+macData.getJobType().getTarget_lang();   
        return result;
    }
}
