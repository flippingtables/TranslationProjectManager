/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.TableModels;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jóannes
 */
public class ClientTableModel extends AbstractTableModel {

    public String[] m_colNames = {"Client Name", "Client Contact", "Client Email", "Client Phone"};

    public Class[] m_colTypes = {String.class, String.class, String.class, String.class};

    private Vector m_macDataVector;

    public void setM_macDataVector(Vector m_macDataVector) {
        this.m_macDataVector = m_macDataVector;
    }
    DatabaseConnection db;

    public ClientTableModel(Vector macDataVector) {
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
//        CloseableIterator<Clients> c = null;
//        c = db.getClientsDao().closeableIterator();

        Clients macData = (Clients) (m_macDataVector.elementAt(row));

        switch (col) {
            case 0:
                macData.setClientName((String) value);
                break;
            case 1:
                macData.setClientContactName((String) value);
                break;
            case 2:
                macData.setClientEmail((String) value);
                break;
            case 3:
                macData.setClientPhone((String) value);
                break;
        }
        try {
            db.getClientsDao().createOrUpdate(macData);
//            fireTableCellUpdated(row, col);
            fireTableDataChanged();
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
        Clients macData = (Clients) (m_macDataVector.elementAt(row));

        switch (col) {
            case 0:
                return macData.getClientName();
            case 1:
                return macData.getClientContactName();
            case 2:
                return macData.getClientEmail();
            case 3:
                return macData.getClientPhone();
        }

        return new String();
    }

    public boolean isCellEditable(int row, int column) {
        return (column != 4);
    }

    public void removeRow(int row) {
        //Update the database
        if (db == null) {
            db = new DatabaseConnection();
        }

        try {
            Clients toRemove = (Clients) m_macDataVector.get(row);
            Clients fromDB = db.getClientsDao().queryForSameId(toRemove);
            if (toRemove.equals(fromDB)) {
                m_macDataVector.removeElementAt(row);
                db.getClientsDao().delete(toRemove);
                fireTableDataChanged();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addRow(Clients client) {
        if (db == null) {
            db = new DatabaseConnection();
        }

        try {
            m_macDataVector.add(client);
            db.getClientsDao().create(client);
            fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(ClientTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
