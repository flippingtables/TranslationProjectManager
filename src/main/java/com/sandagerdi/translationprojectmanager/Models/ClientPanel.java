/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Verifiers.ClientAddVerifier;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jóannes
 */
public class ClientPanel extends javax.swing.JPanel {

    private String clientContactPhone;
    private String clientContactName;
    private String clientEmail;
    private String clientName;

    /**
     * Creates new form ClientPanel
     */
    public ClientPanel() {
        //db = new DatabaseConnection();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addClientButton = new javax.swing.JButton();
        clientNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        clientConectEmailTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clientContactPhoneTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        clientContactNameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelErrorMessage = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 178));

        addClientButton.setText("Add Client");
        addClientButton.setToolTipText("");
        addClientButton.setActionCommand("");
        addClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClientButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Client Name:");

        jLabel2.setText("Client Contact Email:");

        jLabel3.setText("Client Contact Phone:");

        jLabel4.setLabelFor(clientContactNameTextField);
        jLabel4.setText("Client Contact Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Create a new Translation Client");
        jLabel5.setToolTipText("");

        labelErrorMessage.setPreferredSize(new java.awt.Dimension(0, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addClientButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clientContactNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientContactPhoneTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientConectEmailTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientNameTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(clientConectEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientContactPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(clientContactNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clientConectEmailTextField, clientContactNameTextField, clientContactPhoneTextField, clientNameTextField, jLabel1, jLabel2, jLabel3, jLabel4});

    }// </editor-fold>//GEN-END:initComponents

    private void addClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClientButtonActionPerformed
        clientName = this.clientNameTextField.getText();
        clientEmail = this.clientConectEmailTextField.getText();
        clientContactName = this.clientContactNameTextField.getText();
        clientContactPhone = this.clientContactPhoneTextField.getText();
        DatabaseConnection db = new DatabaseConnection();

        try {

            if (ClientAddVerifier.ClientInputAccepted(clientContactPhone, clientContactName, clientEmail, clientName)) {
                Clients client = new Clients(clientName, clientEmail, clientContactPhone, clientContactName);
                db.Connect();
                db.getClientsDao().create(client);
                db.Disconnect();
                labelErrorMessage.setText("Client added successfully");

                this.clientNameTextField.setText("");
                this.clientConectEmailTextField.setText("");
                this.clientContactNameTextField.setText("");
                this.clientContactPhoneTextField.setText("");

            } else {
                labelErrorMessage.setText("Input cannot be empty.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addClientButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClientButton;
    private javax.swing.JTextField clientConectEmailTextField;
    private javax.swing.JTextField clientContactNameTextField;
    private javax.swing.JTextField clientContactPhoneTextField;
    private javax.swing.JTextField clientNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelErrorMessage;
    // End of variables declaration//GEN-END:variables
}
