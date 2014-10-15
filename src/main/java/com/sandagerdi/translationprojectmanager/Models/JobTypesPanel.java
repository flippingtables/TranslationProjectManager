/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.j256.ormlite.dao.CloseableIterator;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Verifiers.ClientAddVerifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Jóannes
 */
public class JobTypesPanel extends javax.swing.JPanel {

    private DatabaseConnection db;
    private ClientTableModel m_tableModel;
    private JTable clientTable;

    /**
     * Creates new form JobTypesPanel
     */
    public JobTypesPanel() {
        initComponents();
        System.out.println("Updating the ComboBox");
        db = new DatabaseConnection();
        updateComboBox();
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                Object obj = jComboBox1.getSelectedItem();
                Clients c = (Clients) obj;
            }
        });
    }

    private void updateComboBox() {
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new Vector<>(clients)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfLanguage_Source = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfLanguage_Target = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfServiceType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfWords_Match = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPay_Hour = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfWords_Fuzzy95 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfWords_New = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfWords_Fuzzy85 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfWords_Fuzzy50 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfWords_Fuzzy75 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfWords_Rep = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfICE = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfPay_Minimum = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfPay_RushPercent = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        BtnAddJobType = new javax.swing.JButton();
        BtnClearFields = new javax.swing.JButton();
        labelErrorMessage = new javax.swing.JLabel();

        jLabel1.setText("Source:");

        tfLanguage_Source.setNextFocusableComponent(tfLanguage_Target);

        jLabel2.setText("Target:");

        tfLanguage_Target.setNextFocusableComponent(tfPay_Hour);

        jLabel3.setText("Service:");

        tfServiceType.setNextFocusableComponent(tfLanguage_Source);

        jLabel4.setText("Match:");

        tfWords_Match.setNextFocusableComponent(tfWords_Rep);

        jLabel5.setText("Hour:");

        tfPay_Hour.setNextFocusableComponent(tfPay_Minimum);

        jLabel6.setText("Fuzzy95:");

        tfWords_Fuzzy95.setNextFocusableComponent(tfWords_Match);

        jLabel7.setText("New:");

        tfWords_New.setNextFocusableComponent(tfWords_Fuzzy50);

        jLabel8.setText("Fuzzy 85:");

        tfWords_Fuzzy85.setNextFocusableComponent(tfWords_Fuzzy95);

        jLabel9.setText("Fuzzy 50");

        tfWords_Fuzzy50.setNextFocusableComponent(tfWords_Fuzzy75);

        jLabel10.setText("Fuzzy 75:");

        tfWords_Fuzzy75.setNextFocusableComponent(tfWords_Fuzzy85);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setNextFocusableComponent(tfServiceType);
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });

        jLabel11.setText("Client:");

        jLabel12.setText("Rep:");

        tfWords_Rep.setNextFocusableComponent(tfICE);

        jLabel13.setText("ICE:");

        tfICE.setNextFocusableComponent(jComboBox1);

        jLabel14.setText("Min:");

        tfPay_Minimum.setNextFocusableComponent(tfPay_RushPercent);

        jLabel15.setText("Rush %:");

        tfPay_RushPercent.setNextFocusableComponent(tfWords_New);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Add a new Job Type for Client");
        jLabel16.setToolTipText("");

        BtnAddJobType.setText("Add Job Type");
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

        labelErrorMessage.setPreferredSize(new java.awt.Dimension(0, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfLanguage_Target, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfLanguage_Source, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfPay_Hour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfPay_Minimum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfPay_RushPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(labelErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnClearFields)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnAddJobType)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfWords_Fuzzy95, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWords_New, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWords_Fuzzy85, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWords_Fuzzy50, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWords_Fuzzy75, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWords_Rep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfICE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWords_Match, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tfLanguage_Source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(tfLanguage_Target, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfPay_Hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfPay_Minimum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfPay_RushPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(labelErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfWords_New, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfWords_Fuzzy50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfWords_Fuzzy75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(tfWords_Rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfWords_Fuzzy85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfWords_Fuzzy95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfWords_Match, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnAddJobType)
                    .addComponent(BtnClearFields))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel12, jLabel13, jLabel14, jLabel15, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, tfICE, tfLanguage_Source, tfLanguage_Target, tfPay_Hour, tfPay_Minimum, tfPay_RushPercent, tfServiceType, tfWords_Fuzzy50, tfWords_Fuzzy75, tfWords_Fuzzy85, tfWords_Fuzzy95, tfWords_Match, tfWords_New, tfWords_Rep});

    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        //TODO horrible hack to constantly update the ComboBox with data from
        //      the tabledatabase.
        System.out.println("CLICKED COMBO");
        updateComboBox();
    }//GEN-LAST:event_jComboBox1FocusGained

    private void BtnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearFieldsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnClearFieldsActionPerformed

    private void BtnAddJobTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddJobTypeActionPerformed

        String ServiceType = this.tfServiceType.getText();
        String Language_Source = this.tfLanguage_Source.getText();
        String Language_Target = this.tfLanguage_Target.getText();

        double Pay_Hour = Double.parseDouble(this.tfPay_Hour.getText());
        double Pay_Minimum = Double.parseDouble(this.tfPay_Minimum.getText());
        double Pay_RushPercent = Double.parseDouble(this.tfPay_RushPercent.getText());
        double Words_Fuzzy50 = Double.parseDouble(this.tfWords_Fuzzy50.getText());
        double Words_Fuzzy75 = Double.parseDouble(this.tfWords_Fuzzy75.getText());
        double Words_Fuzzy85 = Double.parseDouble(this.tfWords_Fuzzy85.getText());
        double Words_Fuzzy95 = Double.parseDouble(this.tfWords_Fuzzy95.getText());
        double Words_Match = Double.parseDouble(this.tfWords_Match.getText());
        double Words_New = Double.parseDouble(this.tfWords_New.getText());
        double Words_Rep = Double.parseDouble(this.tfWords_Rep.getText());
        double ICE = Double.parseDouble(this.tfICE.getText());

        try {

            if (ClientAddVerifier.ClientInputAccepted(" ", " ", " ", " ")) {
                Object obj = jComboBox1.getSelectedItem();
                Clients c = (Clients) obj;
                //VALIDATE INPUT
                JobTypes newJob = new JobTypes(c, ServiceType, Language_Source, Language_Target,
                        Pay_Hour, Pay_Minimum, Pay_RushPercent, Words_New,
                        Words_Fuzzy50, Words_Fuzzy75, Words_Fuzzy85, Words_Fuzzy95,
                        Words_Match, Words_Rep, ICE);

                db.getJobTypesDao().create(newJob);
                db.getJobTypesDao().refresh(newJob);
                labelErrorMessage.setText("Job added successfully");

            } else {
                labelErrorMessage.setText("Input cannot be empty.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BtnAddJobTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddJobType;
    private javax.swing.JButton BtnClearFields;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelErrorMessage;
    private javax.swing.JTextField tfICE;
    private javax.swing.JTextField tfLanguage_Source;
    private javax.swing.JTextField tfLanguage_Target;
    private javax.swing.JTextField tfPay_Hour;
    private javax.swing.JTextField tfPay_Minimum;
    private javax.swing.JTextField tfPay_RushPercent;
    private javax.swing.JTextField tfServiceType;
    private javax.swing.JTextField tfWords_Fuzzy50;
    private javax.swing.JTextField tfWords_Fuzzy75;
    private javax.swing.JTextField tfWords_Fuzzy85;
    private javax.swing.JTextField tfWords_Fuzzy95;
    private javax.swing.JTextField tfWords_Match;
    private javax.swing.JTextField tfWords_New;
    private javax.swing.JTextField tfWords_Rep;
    // End of variables declaration//GEN-END:variables
}
