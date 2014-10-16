/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Jóannes
 */
public class ViewClientsTable extends javax.swing.JPanel {

    public JTable clientTable;
    public ClientTableModel m_tableModel;

    public ClientTableModel getM_tableModel() {
        return m_tableModel;
    }

    private javax.swing.JScrollPane jScrollPane1;
    private JButton jButton1;
    private DatabaseConnection db;// = new DatabaseConnection();
    private JButton deleteRow;

    public ViewClientsTable() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jButton1.setText("Refresh Client Table");
        deleteRow = new javax.swing.JButton();
        deleteRow.setText("Delete Selected Row!");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        deleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowActionPerformed(evt);
            }
        });

        db = new DatabaseConnection();
        CloseableIterator<Clients> c = null;
        c = db.getClientsDao().closeableIterator();
        Vector<Object> clients = new Vector<Object>();
        while (c.hasNext()) {
            try {
                clients.add(c.current());
            } catch (SQLException ex) {
                Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewClientsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        m_tableModel = new ClientTableModel(clients);
        clientTable = new JTable(m_tableModel);
        clientTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                System.out.println("Table Data Changed, updating tables");
                updateTable();
            }
        });

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(clientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(deleteRow))
                        .addContainerGap(34, Short.MAX_VALUE))
        );
    }

    //Onclick method for the Button
    //Used to update the table
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        m_tableModel.fireTableDataChanged();
    }

    private void updateTable() {
        CloseableIterator<Clients> c = db.getClientsDao().closeableIterator();
        Vector<Object> clients = new Vector<Object>();
        while (c.hasNext()) {
            try {
                clients.add(c.current());
            } catch (SQLException ex) {
                Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewClientsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        m_tableModel.m_macDataVector = clients;
        clientTable.setModel(m_tableModel);
    }

    private void deleteRowActionPerformed(ActionEvent evt) {
        int rowToDelete = clientTable.getSelectedRow();
        System.out.println("Selected Row:" + rowToDelete);
        m_tableModel.removeRow(rowToDelete);
//        updateTable();
    }

}
