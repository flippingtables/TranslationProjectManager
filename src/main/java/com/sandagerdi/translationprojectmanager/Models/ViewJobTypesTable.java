/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
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
public class ViewJobTypesTable extends javax.swing.JPanel {

    private JTable clientTable;
    private JobTypesTableModel m_tableModel;

    private javax.swing.JScrollPane jScrollPane1;
    private JButton jButton1;
    private DatabaseConnection db;

    public ViewJobTypesTable() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        //jScrollPane1 = new javax.swing.JScrollPane();
        //CloseableIterator<Clients> murtur = getClients();
        jButton1 = new javax.swing.JButton();
        jButton1.setText("Refresh JobTypes Table");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        db = new DatabaseConnection();
        db.Connect();
        CloseableIterator<JobTypes> c = null;
        c = db.getJobTypesDao().closeableIterator();
        Vector<Object> jobTypes = new Vector<Object>();
        while (c.hasNext()) {
            try {
                jobTypes.add(c.current());
            } catch (SQLException ex) {
                Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        m_tableModel = new JobTypesTableModel(jobTypes);
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
    //Onclick method for the Button
    //Used to update the table
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        m_tableModel.fireTableDataChanged();
    }

    private void updateTable() {
        CloseableIterator<JobTypes> c = null;
        c = db.getJobTypesDao().closeableIterator();
        Vector<Object> jobTypes =  new Vector<Object>();
        while (c.hasNext()) {
            try {
                jobTypes.add(c.current());
            } catch (SQLException ex) {
                Logger.getLogger(ViewJobTypesTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        m_tableModel.m_macDataVector = jobTypes;
        clientTable.setModel(m_tableModel);
    }
}
