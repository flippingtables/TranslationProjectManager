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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jóannes
 */
public class ClientsTable extends javax.swing.JPanel {

    private DefaultTableModel tableModel = new DefaultTableModel();
    private ClientTableModel m_tableModel;
            
    /**
     * Creates new form ClientsTable
     */
    public ClientsTable() {
        initComponents();
        
        try {
            FillTable(clientTable);
        } catch (SQLException ex) {
            Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        clientTable = new JTable(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(clientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            FillTable(clientTable);
        } catch (SQLException ex) {
            Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseConnection db = new DatabaseConnection();
        CloseableIterator<Clients> c = null;
        c = db.getClientsDao().closeableIterator();
        Vector<Object> clients = new Vector<Object>();
        while (c.hasNext()){
            try {
                clients.add(c.current());
            } catch (SQLException ex) {
                Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        m_tableModel = new ClientTableModel(clients);
        clientTable = new JTable(m_tableModel);
        System.out.println(clientTable.getColumnName(1));
        System.out.println(clientTable.getRowCount());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clientTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void FillTable(JTable table) throws SQLException {

        DatabaseConnection db = new DatabaseConnection();
        CloseableIterator<Clients> c = null;
        c = db.getClientsDao().closeableIterator();

        int columns = c.getRawResults().getColumnCount();
        String[] columNamess = c.getRawResults().getColumnNames();

        Vector<String> columnNames = new Vector<String>();

        for (int i = 1; i < columns; i++) {
            System.out.println(columNamess[i]);
            columnNames.add(columNamess[i]);
        }

        // Data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (c.hasNext()) {
            Vector<Object> vector = new Vector<Object>();
            for (int i = 1; i <= columns; i++) {
                vector.add(c.current().getClientName());
                vector.add(c.current().getClientContactName());
                vector.add(c.current().getClientEmail());
                vector.add(c.current().getClientPhone());
            }
            data.add(vector);
        }
        System.out.println(data);
        System.out.println(columnNames);
        tableModel.setDataVector(data, columnNames);

    }

}
