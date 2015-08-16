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
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import com.sandagerdi.translationprojectmanager.Util.ClipboardManager;
import com.sandagerdi.translationprojectmanager.Util.Utils;
import com.sandagerdi.translationprojectmanager.Verifiers.ClientAddVerifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author Jóannes
 */
public class AddNewJobPanel extends javax.swing.JPanel {

    DatabaseConnection db = new DatabaseConnection();

    /**
     * Creates new form AddNewJobPanel
     */
    public AddNewJobPanel() {
        initComponents();

        DateTime now = new DateTime();
        initializeComboBoxes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfWords_Match = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfWords_Fuzzy95 = new javax.swing.JTextField();
        BtnAddJobType = new javax.swing.JButton();
        BtnClearFields = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfWords_New = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfWords_Fuzzy85 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfWords_Fuzzy50 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfWords_Fuzzy75 = new javax.swing.JTextField();
        cbClients = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfWords_Rep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfICE = new javax.swing.JTextField();
        cbServices = new javax.swing.JComboBox();
        cbSourceLanguage = new javax.swing.JComboBox();
        cbTargetLanguage = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        tfHours = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        isRushCheckBox = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabelErrorMessage = new javax.swing.JLabel();
        jButtonPasteJob = new javax.swing.JButton();
        jtf_DeadLine = new javax.swing.JTextField();

        jLabel3.setText("Service:");

        jLabel4.setText("Rep:");

        tfWords_Match.setText("0.0");

        jLabel5.setText("Description:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Add a new job for client");
        jLabel16.setToolTipText("");

        jLabel6.setText("Fuzzy95:");

        tfWords_Fuzzy95.setText("0.0");

        BtnAddJobType.setText("Add Job");
        BtnAddJobType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddJobTypeActionPerformed(evt);
            }
        });

        BtnClearFields.setText("Clear Fields");
        BtnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearFieldsActionPerformed(evt);
            }
        });

        jLabel7.setText("New:");

        tfWords_New.setText("0.0");

        jLabel8.setText("Fuzzy 85:");

        tfWords_Fuzzy85.setText("0.0");

        jLabel9.setText("Fuzzy 50");

        tfWords_Fuzzy50.setText("0.0");

        jLabel10.setText("Fuzzy 75:");

        tfWords_Fuzzy75.setText("0.0");

        cbClients.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbClients.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClientsItemStateChanged(evt);
            }
        });
        cbClients.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbClientsFocusGained(evt);
            }
        });

        jLabel11.setText("Client:");

        jLabel1.setText("Source:");

        jLabel12.setText("ICE:");

        tfWords_Rep.setText("0.0");

        jLabel2.setText("Target:");

        jLabel13.setText("Hours:");

        tfICE.setText("0.0");

        cbServices.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbSourceLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EN", "FR" }));

        cbTargetLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ES" }));

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(2);
        jScrollPane1.setViewportView(taDescription);

        jLabel17.setText("Deadline:");

        tfHours.setText("0.0");

        jLabel15.setText("Match:");

        jLabel18.setText("Rush:");
        jLabel18.setPreferredSize(new java.awt.Dimension(32, 14));

        jButtonPasteJob.setText("Get Clipboard");
        jButtonPasteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasteJobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addComponent(jButtonPasteJob))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbClients, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbServices, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTargetLanguage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSourceLanguage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jtf_DeadLine, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfWords_Rep)
                                        .addComponent(tfICE)
                                        .addComponent(tfWords_New)
                                        .addComponent(tfWords_Fuzzy85)
                                        .addComponent(tfHours)
                                        .addComponent(tfWords_Fuzzy50)
                                        .addComponent(tfWords_Match)
                                        .addComponent(tfWords_Fuzzy95)
                                        .addComponent(tfWords_Fuzzy75, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(isRushCheckBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnClearFields)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnAddJobType))
                            .addComponent(jLabelErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel13, jLabel15, jLabel18, jLabel4, jLabel6, jLabel7, jLabel8, jLabel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfWords_New, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfWords_Fuzzy50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfWords_Fuzzy75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfWords_Fuzzy85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfWords_Fuzzy95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfWords_Match, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfWords_Rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isRushCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(BtnAddJobType)
                            .addComponent(BtnClearFields)
                            .addComponent(jButtonPasteJob))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelErrorMessage))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(cbSourceLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(cbTargetLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_DeadLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel13, jLabel15, jLabel4, jLabel6, jLabel7, jLabel8, jLabel9, tfHours, tfICE, tfWords_Fuzzy50, tfWords_Fuzzy75, tfWords_Fuzzy85, tfWords_Fuzzy95, tfWords_Match, tfWords_Rep});

    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddJobTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddJobTypeActionPerformed
//
        Clients client = null;
        String ServiceType = (String) this.cbServices.getSelectedItem().toString();
        String Language_Source = (String) this.cbSourceLanguage.getSelectedItem().toString();
        String Language_Target = (String) this.cbTargetLanguage.getSelectedItem().toString();
        String Description = this.taDescription.getText();
        double Pay_Hour = Double.parseDouble(this.tfHours.getText());
        double Words_Fuzzy50 = Double.parseDouble(this.tfWords_Fuzzy50.getText());
        double Words_Fuzzy75 = Double.parseDouble(this.tfWords_Fuzzy75.getText());
        double Words_Fuzzy85 = Double.parseDouble(this.tfWords_Fuzzy85.getText());
        double Words_Fuzzy95 = Double.parseDouble(this.tfWords_Fuzzy95.getText());
        double Words_Match = Double.parseDouble(this.tfWords_Match.getText());
        double Words_New = Double.parseDouble(this.tfWords_New.getText());
        double Words_Rep = Double.parseDouble(this.tfWords_Rep.getText());
        double ICE = Double.parseDouble(this.tfICE.getText());
        Date dateDeadline = getDeadlineDate();
        Date dateNow = new Date();
        boolean isRush = this.isRushCheckBox.isSelected();

        try {
            if (ClientAddVerifier.StringInputVerifier(ServiceType, Language_Source, Language_Target)) {
                Object obj = cbClients.getSelectedItem();
                client = (Clients) obj;
                //VALIDATE INPUT
                /*public Jobs(Clients client, JobTypes jobType, Date dateCreated, Date dateDeadline,
                 String description, double pay_hour, double words_new, double words_fuzzy50,
                 double words_fuzzy75, double words_fuzzy85, double words_fuzzy95,
                 double words_match, double words_rep, double words_ice) {
                 */
                JobTypes job = getJobTypes(client, ServiceType, Language_Source, Language_Target);
                Jobs newJob = new Jobs(client, job, dateNow,
                        dateDeadline, Description, Pay_Hour,
                        Words_New, Words_Fuzzy50, Words_Fuzzy75, Words_Fuzzy85, Words_Fuzzy95,
                        Words_Match, Words_Rep, ICE, isRush);

                db.getJobsDao().create(newJob);
                db.getJobsDao().refresh(newJob);
                jLabelErrorMessage.setText("Job added successfully");

            } else {
                jLabelErrorMessage.setText("Input cannot be empty.");
            }
//
        } catch (SQLException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnAddJobTypeActionPerformed

    private void BtnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearFieldsActionPerformed
        // TODO add your handling code here:
//        System.out.println("Time:" + jFormattedTextField1.getValue().toString());
//        try {
//            String time = convertTo24HoursFormat(tfTime.getText());
//            System.out.println("Time: " + time);
//        } catch (ParseException ex) {
//            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_BtnClearFieldsActionPerformed

    private void cbClientsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbClientsFocusGained
        //TODO horrible hack to constantly update the ComboBox with data from
        //      the tabledatabase.
        System.out.println("CLICKED COMBO");

//        updateComboBox();
    }//GEN-LAST:event_cbClientsFocusGained

    private void cbClientsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClientsItemStateChanged
        // TODO add your handling code here:
        updateServicesComboBox();
    }//GEN-LAST:event_cbClientsItemStateChanged

    private void jButtonPasteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasteJobActionPerformed
        // TODO add your handling code here:

        Map<String, String> jobsFromClipboard = ClipboardManager.getMatchingJobsFromClipBoard();
        this.tfHours.setText(jobsFromClipboard.get("hours"));
        this.tfWords_Fuzzy50.setText(jobsFromClipboard.get("50"));
        this.tfWords_Fuzzy75.setText(jobsFromClipboard.get("75"));
        this.tfWords_Fuzzy85.setText(jobsFromClipboard.get("85"));
        this.tfWords_Fuzzy95.setText(jobsFromClipboard.get("95"));
        this.tfWords_Match.setText(jobsFromClipboard.get("match"));
        this.tfWords_New.setText(jobsFromClipboard.get("new"));
        this.tfWords_New.setText(jobsFromClipboard.get("review"));
        this.tfWords_Rep.setText(jobsFromClipboard.get("rep"));
        this.tfICE.setText(jobsFromClipboard.get("ice"));
    }//GEN-LAST:event_jButtonPasteJobActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddJobType;
    private javax.swing.JButton BtnClearFields;
    private javax.swing.JComboBox cbClients;
    private javax.swing.JComboBox cbServices;
    private javax.swing.JComboBox cbSourceLanguage;
    private javax.swing.JComboBox cbTargetLanguage;
    private javax.swing.JCheckBox isRushCheckBox;
    private javax.swing.JButton jButtonPasteJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jtf_DeadLine;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField tfHours;
    private javax.swing.JTextField tfICE;
    private javax.swing.JTextField tfWords_Fuzzy50;
    private javax.swing.JTextField tfWords_Fuzzy75;
    private javax.swing.JTextField tfWords_Fuzzy85;
    private javax.swing.JTextField tfWords_Fuzzy95;
    private javax.swing.JTextField tfWords_Match;
    private javax.swing.JTextField tfWords_New;
    private javax.swing.JTextField tfWords_Rep;
    // End of variables declaration//GEN-END:variables

    private Date getDeadlineDate() {
        String dateString = jtf_DeadLine.getText();
        Date date = Utils.parseDateFromString(dateString);
        System.out.println("Date:" + date.toString());
        return date;
    }

    private void initializeComboBoxes() {
        updateClientsComboBox();
        updateServicesComboBox();
    }

    private void updateClientsComboBox() {
        db.Connect();
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
            Logger.getLogger(JobTypesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbClients.setModel(new javax.swing.DefaultComboBoxModel(new Vector<>(clients)));
        db.Disconnect();
    }

    private void updateServicesComboBox() {
        db.Connect();
        Clients currentClient = (Clients) cbClients.getSelectedItem();
        System.out.println("SelectedClient:" + currentClient.getId());

        QueryBuilder<JobTypes, Integer> queryBuilder = db.getJobTypesDao().queryBuilder();
        Where<JobTypes, Integer> where = queryBuilder.where();

        String Language_Source = this.cbSourceLanguage.getSelectedItem().toString();
        String Language_Target = this.cbTargetLanguage.getSelectedItem().toString();
        try {
            where.eq(JobTypes.CLIENTS_ID_FIELD_NAME, currentClient.getId());

            where.eq(JobTypes.JOBTYPES_SOURCE_LANG_FIELD_NAME, Language_Source);

            where.eq(JobTypes.JOBTYPES_TARGET_LANG_FIELD_NAME, Language_Target);
            where.and(3);

        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        // prepare our sql statement
        PreparedQuery<JobTypes> preparedQuery = null;

        try {
            preparedQuery = queryBuilder.prepare();
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        Where<JobTypes, Integer> where1 = queryBuilder.where();

        try {
            where1.eq(JobTypes.CLIENTS_ID_FIELD_NAME, currentClient.getId());
            where1.eq(JobTypes.JOBTYPES_SERVICE_FIELD_NAME, "DTP");
            where1.and(2);

        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        // prepare our sql statement
        PreparedQuery<JobTypes> preparedQuery1 = null;

        try {
            preparedQuery1 = queryBuilder.prepare();
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<JobTypes> jobs = null;
        try {

            jobs = db.getJobTypesDao().query(preparedQuery);
            List<JobTypes> a = db.getJobTypesDao().query(preparedQuery1);
            for (JobTypes a1 : a) {
                jobs.add(a1);
            }
//            
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Number of Jobs: " + jobs.size());

        List<String> jobTypesVector = new ArrayList<>();
        for (JobTypes j : jobs) {

            jobTypesVector.add(j.getService());

        }

        cbServices.setModel(new javax.swing.DefaultComboBoxModel(jobTypesVector.toArray()));
        db.Disconnect();

    }

    private JobTypes getJobTypes(Clients client, String service, String source, String target) {
        db.Connect();

        // get our query builder from the DAO
        QueryBuilder<JobTypes, Integer> queryBuilder = db.getJobTypesDao().queryBuilder();
        Where<JobTypes, Integer> where = queryBuilder.where();
        try {
            if (("DTP").equals(service)) {
                where.eq(JobTypes.CLIENTS_ID_FIELD_NAME, client.getId());
                where.and();
                where.eq(JobTypes.JOBTYPES_SERVICE_FIELD_NAME, service);
            } else {
                where.eq(JobTypes.CLIENTS_ID_FIELD_NAME, client.getId());
                where.and();
                where.eq(JobTypes.JOBTYPES_SERVICE_FIELD_NAME, service);
                where.and();
                where.eq(JobTypes.JOBTYPES_SOURCE_LANG_FIELD_NAME, source);
                where.and();
                where.eq(JobTypes.JOBTYPES_TARGET_LANG_FIELD_NAME, target);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        // prepare our sql statement
        PreparedQuery<JobTypes> preparedQuery = null;
        try {
            preparedQuery = queryBuilder.prepare();
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<JobTypes> accountList = null;
        try {
            // query for all accounts that have "qwerty" as a password
            accountList = db.getJobTypesDao().query(preparedQuery);
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.Disconnect();
        if (accountList.size() > 0) {
            return accountList.get(0);
        }

        return null;
    }

}
