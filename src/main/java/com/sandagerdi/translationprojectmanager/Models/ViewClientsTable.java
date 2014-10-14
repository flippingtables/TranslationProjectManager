/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jóannes
 */
public class ViewClientsTable extends javax.swing.JPanel {

    private JTable clientTable;
    private TableModel m_tableModel;

    private javax.swing.JScrollPane jScrollPane1;
    private JButton jButton1;
    private DatabaseConnection db;

    public ViewClientsTable() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        //jScrollPane1 = new javax.swing.JScrollPane();
        //CloseableIterator<Clients> murtur = getClients();
        jButton1 = new javax.swing.JButton();
        jButton1.setText("Refresh Client Table");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        m_tableModel = new TableModel(clients);
        clientTable = new JTable(m_tableModel);
        clientTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                System.out.println("SOMETHING: " + e);
                updateTable();
            }
        });
        System.out.println(clientTable.getColumnName(1));
        System.out.println(clientTable.getRowCount());
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(clientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 56, Short.MAX_VALUE))
        );
        clientTable.setEditingColumn(2);
        clientTable.setEnabled(true);

    }

    public void FillTable(JTable table, String Query) {

        DatabaseConnection db = new DatabaseConnection();
        List<Clients> c = null;
        try {
            c = db.getClientsDao().queryForAll();
            System.out.println("Size: " + c.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewClientsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        //try {
        System.out.println("Here");

        //To remove previously added rows
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        int columns = c.size();
        for (int client = 0; client < c.size(); client++) {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++) {
                row[i - 1] = c.get(client);
            }
            System.out.println("Rows: " + row.length);
            ((DefaultTableModel) table.getModel()).insertRow(client, row);
        }
        System.out.println("ta: " + table.getModel().getRowCount());
    }

    //Onclick method for the Button
    //Used to update the table
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        m_tableModel.fireTableDataChanged();
    }

    private void updateTable() {
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
        m_tableModel.m_macDataVector = clients;
        clientTable.setModel(m_tableModel);
    }
}
