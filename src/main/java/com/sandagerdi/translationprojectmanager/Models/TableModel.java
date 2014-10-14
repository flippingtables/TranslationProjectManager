/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

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
public class TableModel extends AbstractTableModel {
    public String[] m_colNames = { "Client Name", "Client Contact", "Client Email","Client Phone"};

    public Class[] m_colTypes = { String.class, String.class, String.class, String.class};

    Vector m_macDataVector;

    public TableModel(Vector macDataVector) {
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
        DatabaseConnection db = new DatabaseConnection();
        CloseableIterator<Clients> c = null;
        c = db.getClientsDao().closeableIterator();
        
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
            fireTableCellUpdated(row, col);
        } catch (SQLException ex) {
            Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
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
  }
