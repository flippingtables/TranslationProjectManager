/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobStatus;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import com.sandagerdi.translationprojectmanager.TableModels.JobsTableModel;
import com.sandagerdi.translationprojectmanager.Util.Utils;
import com.sandagerdi.translationprojectmanager.Verifiers.CellEditor;
import com.sandagerdi.translationprojectmanager.Verifiers.CustomComboBoxEditor;
import com.sandagerdi.translationprojectmanager.Verifiers.DoubleVerifier;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import org.joda.time.DateTime;

/**
 *
 * @author Jóannes
 */
public class ViewJobsTable extends javax.swing.JPanel {

    private JTable clientTable;
    private JobsTableModel m_tableModel;
    private javax.swing.JScrollPane jScrollPane1;
    private JButton buttonRefresh;
    private DatabaseConnection db;
    
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea textAreaAllJobs;
    private javax.swing.JTextArea textAreaSpecificJob;
    private javax.swing.JButton buttonDeleteJob;
    private javax.swing.JButton buttonMarkAsDone;
    
    public ViewJobsTable() {
        this.db = new DatabaseConnection();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        //jScrollPane1 = new javax.swing.JScrollPane();
        //CloseableIterator<Clients> murtur = getClients();
        buttonRefresh = new javax.swing.JButton();
        buttonRefresh.setText("Refresh JobTypes Table");

        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        List<Object> jobs = getJobs();

        m_tableModel = new JobsTableModel(jobs);
        clientTable = new JTable(m_tableModel) {
            //Implement table cell tool tips.           
            @Override
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    //comment row, exclude heading

                    tip = getValueAt(rowIndex, colIndex).toString();

                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };

        clientTable.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                updateTable();
            }
        });
        
        clientTable.setShowGrid(true);
        clientTable.setGridColor(Color.BLACK);

        ListSelectionModel selectionModel = clientTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new SharedListSelectionHandler(clientTable));
        clientTable.setSelectionModel(selectionModel);

        //Build output area.
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(clientTable);

        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaAllJobs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaSpecificJob = new javax.swing.JTextArea();

        buttonMarkAsDone = new javax.swing.JButton();
        buttonDeleteJob = new javax.swing.JButton();
        
        buttonDeleteJob.setText("Delete Job");
        buttonMarkAsDone.setText("Mark as Done");
        
        buttonDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowActionPerformed(evt);
            }
        });
        
        buttonMarkAsDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAsDoneActionPerformed(evt);
            }
        });
        
        jButton2.setText("jButton2");
        jLabel1.setText("This Job");
        textAreaAllJobs.setColumns(20);
        textAreaAllJobs.setRows(3);
        textAreaAllJobs.setEditable(false);
        jScrollPane3.setViewportView(textAreaAllJobs);
        jLabel2.setText("Total For All Jobs");
        textAreaSpecificJob.setColumns(20);
        textAreaSpecificJob.setRows(3);
        textAreaSpecificJob.setEditable(false);
        jScrollPane4.setViewportView(textAreaSpecificJob);

        clientTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() > 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    if (column == 1) {
                        int convertRowToModel = clientTable.convertRowIndexToModel(row);
                        TableColumn comboCol1 = clientTable.getColumnModel().getColumn(1);
                        comboCol1.setCellEditor(null);
                        Clients client = m_tableModel.getValueAtRow(convertRowToModel).getClient();
                        comboCol1.setCellEditor(new CustomComboBoxEditor(client));
                    }

                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonRefresh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonMarkAsDone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeleteJob)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDeleteJob)
                            .addComponent(buttonMarkAsDone))))
                .addContainerGap())
        );

        setColumnWidths();
        clientTable.setEditingColumn(2);
        clientTable.setEnabled(true);
        clientTable.getColumn("Hours").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("New").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("Fuzzy 50").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("Fuzzy 75").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("Fuzzy 85").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("Fuzzy 95").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("Match").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("Rep").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));
        clientTable.getColumn("ICE").setCellEditor(new CellEditor(textAreaAllJobs, new DoubleVerifier()));

        updateJobsAllTextArea();
    }

    //Onclick method for the Button
    //Used to update the table
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        m_tableModel.fireTableDataChanged();
    }

    private void updateTable() {
        List<Object> jobs = getJobs();
        m_tableModel.setM_macDataVector(jobs);

        clientTable.setModel(m_tableModel);
        updateJobsAllTextArea();
    }

    private void updateJobsAllTextArea() {
        textAreaAllJobs.setText("Total to date: " + Utils.calculatePriceForJobAll(m_tableModel));
        textAreaAllJobs.append("\nThis month: " + getJobPayThisMonth());
    }

    private List<Object> getJobs() {
        db.Connect();
        CloseableIterator<Jobs> c = null;
        c = db.getJobsDao().closeableIterator();
        List<Object> jobs = Collections.synchronizedList(new ArrayList<Object>());
        try {
            while (c.hasNext()) {
                jobs.add(c.current());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewJobTypesTable.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
                db.Disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(ViewJobTypesTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jobs;
    }

    private void setColumnWidths() {
        clientTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        for (int i = 1; i < 4; i++) {
            clientTable.getColumnModel().getColumn(i).setPreferredWidth(170);
        }
        for (int i = 4; i < clientTable.getColumnCount(); i++) {
            clientTable.getColumnModel().getColumn(i).setPreferredWidth(50);
        }
        clientTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

   

    

    class SharedListSelectionHandler implements ListSelectionListener {

        JTable clientTable;

        SharedListSelectionHandler(JTable clientTable) {
            this.clientTable = clientTable;
        }

        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (e.getValueIsAdjusting()) {
                return;
            }
            if (!lsm.isSelectionEmpty()) {
                int[] selectedRow = Utils.getSelectedRows(lsm);
                for (int i : selectedRow) {
                    int convertRowToModel = clientTable.convertRowIndexToModel(i);
                    Jobs rowJob = (Jobs) m_tableModel.getValueAtRow(i);
                    textAreaSpecificJob.setText("Pay: " + Utils.getFormattedPriceForJob(rowJob));
                    textAreaSpecificJob.append("\n");
                    textAreaSpecificJob.append("Date Finished:" + m_tableModel.getValueAtRow(i).getDateFinished());
                }
            }
        }
    }

    private String getJobPayThisMonth() {
        DateTime from = Utils.beginningOfMonth(new DateTime());
        DateTime to = Utils.endOfMonth(from);
        db.Connect();

        double result = 0.0;
        QueryBuilder<Jobs, Integer> qb = db.getJobsDao().queryBuilder();

        Where<Jobs, Integer> where = qb.where();
        try {
            qb.where().between("dateDeadline", from.toDate(), to.toDate());
        } catch (SQLException ex) {
            Logger.getLogger(ViewJobsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedQuery<Jobs> preparedQuery = null;

        try {
            preparedQuery = qb.prepare();
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Jobs> jobs = null;

        try {
            jobs = db.getJobsDao().query(preparedQuery);
            for (Jobs job : jobs) {
                result += Utils.calculatePriceForJob(job);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewJobsTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Utils.formatDoubleToLocale(result);
    }

    

    
    private void deleteRowActionPerformed(ActionEvent evt) {
        //Check if there is anything to delete
        int rowToDelete = clientTable.getSelectedRow();
        if (rowToDelete>=0){
        System.out.println("Selected Row:" + rowToDelete);
        m_tableModel.removeRow(rowToDelete);
        }

    }
    
    private void markAsDoneActionPerformed(ActionEvent evt) {
        int rowToModify = clientTable.getSelectedRow();
        if (rowToModify>=0){
            System.out.println("Marking as done:" + rowToModify);
            System.out.println("Status: " +m_tableModel.getStatus(rowToModify));
            m_tableModel.setStatus(rowToModify, JobStatus.FINISHED);
            System.out.println("StatusAfter: " +m_tableModel.getStatus(rowToModify));
            
        }
    }
}
