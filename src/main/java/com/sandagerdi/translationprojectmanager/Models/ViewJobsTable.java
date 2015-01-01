/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import com.sandagerdi.translationprojectmanager.TableModels.JobsTableModel;
import com.sandagerdi.translationprojectmanager.Util.Utils;
import com.sandagerdi.translationprojectmanager.Verifiers.CellEditor;
import com.sandagerdi.translationprojectmanager.Verifiers.DoubleVerifier;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

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

    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea textAreaAllJobs;
    private javax.swing.JTextArea textAreaSpecificJob;

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

        
        List<Object> jobs = getJobs();
       
        m_tableModel = new JobsTableModel(jobs);
        clientTable = new JTable(m_tableModel);
        clientTable.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                updateTable();
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                .addComponent(jScrollPane4))
                                        .addContainerGap())))
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
        textAreaAllJobs.setText("Total to date: " + calculatePriceForJobAll());
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
        db.Disconnect();
        return jobs;
    }

    private void setColumnWidths() {
        clientTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        for (int i = 1; i < 4; i++) {
            clientTable.getColumnModel().getColumn(i).setPreferredWidth(150);
        }
        for (int i = 4; i < clientTable.getColumnCount(); i++) {
            clientTable.getColumnModel().getColumn(i).setPreferredWidth(50);
        }
        clientTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private int[] getSelectedRows(ListSelectionModel selection) {
        int iMin = selection.getMinSelectionIndex();
        int iMax = selection.getMaxSelectionIndex();
        if ((iMin == -1) || (iMax == -1)) {
            return new int[0];
        }
        int[] rvTmp = new int[1 + (iMax - iMin)];
        int n = 0;
        for (int i = iMin; i <= iMax; i++) {
            if (selection.isSelectedIndex(i)) {
                rvTmp[n++] = i;
            }
        }
        int[] rv = new int[n];
        System.arraycopy(rvTmp, 0, rv, 0, n);
        return rv;
    }

    private String calculatePriceForJobAll() {
        int columns = m_tableModel.getRowCount();
        double total = 0.0;
        for (int i = 0; i < columns; i++) {
            total += calculatePriceForJob(m_tableModel.getValueAtRow(i));

        }
        return Utils.formatDoubleToLocale(total);
    }

    private double calculatePriceForJob(Jobs job) {

        JobTypes jobType = job.getJobType();
        double houly = jobType.getPay_hour() * job.getPay_hour();
        double newWords = jobType.getWords_new() * job.getWords_new();
        double fuzzy50 = jobType.getWords_fuzzy50() * job.getWords_fuzzy50();
        double fuzzy75 = jobType.getWords_fuzzy75() * job.getWords_fuzzy75();
        double fuzzy85 = jobType.getWords_fuzzy85() * job.getWords_fuzzy85();
        double fuzzy95 = jobType.getWords_fuzzy95() * job.getWords_fuzzy95();
        double match = jobType.getWords_match() * job.getWords_match();
        double rep = jobType.getWords_rep() * job.getWords_rep();
        double ICE = jobType.getWords_ice() * job.getWords_ice();

        double result = houly + newWords + fuzzy50 + fuzzy75 + fuzzy85 + fuzzy95 + match + rep + ICE;
        return result;
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
                int[] selectedRow = getSelectedRows(lsm);
                for (int i : selectedRow) {
                    int convertRowToModel = clientTable.convertRowIndexToModel(i);
                    textAreaSpecificJob.setText("Pay: " + Utils.formatDoubleToLocale(calculatePriceForJob(m_tableModel.getValueAtRow(i))));
                }
            }
        }
    }
    

}
