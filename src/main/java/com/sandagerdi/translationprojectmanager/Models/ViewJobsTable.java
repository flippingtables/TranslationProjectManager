/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import com.sandagerdi.translationprojectmanager.TableModels.JobsTableModel;
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

/**
 *
 * @author Jóannes
 */
public class ViewJobsTable extends javax.swing.JPanel {

    private JTable clientTable;
    private JobsTableModel m_tableModel;

    private javax.swing.JScrollPane jScrollPane1;
    private JButton jButton1;
    private DatabaseConnection db = new DatabaseConnection();

    public ViewJobsTable() {

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

        db.Connect();
        CloseableIterator<Jobs> c = null;
        Vector<Object> jobs = null;
        try {
            c = db.getJobsDao().closeableIterator();
            jobs = new Vector<Object>();
            while (c.hasNext()) {
                try {
                    jobs.add(c.current());
                } catch (SQLException ex) {
                    Logger.getLogger(ClientsTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewJobTypesTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        List<Jobs> jobsList;
//        Vector<Object> jobs = null;
//        try {
//            jobsList = db.getJobsDao().queryForAll();
//            for (Jobs j : jobsList) {
//                jobs.add(j);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ViewJobsTable.class.getName()).log(Level.SEVERE, null, ex);
//        }

        db.Disconnet();
        m_tableModel = new JobsTableModel(jobs);
        clientTable = new JTable(m_tableModel);
        clientTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                System.out.println("SOMETHING: " + e);
                updateTable();
            }
        });
//        System.out.println(clientTable.getColumnName(1));
//        System.out.println(clientTable.getRowCount());
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
        db.Connect();
        CloseableIterator<Jobs> c = null;
        c = db.getJobsDao().closeableIterator();
        Vector<Object> jobs = new Vector<Object>();

        try {
            while (c.hasNext()) {
                jobs.add(c.current());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewJobTypesTable.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
                db.Disconnet();
            } catch (SQLException ex) {
                Logger.getLogger(ViewJobTypesTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        m_tableModel.setM_macDataVector(jobs);
        clientTable.setModel(m_tableModel);
        db.Disconnet();
    }

}
