/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Models;

import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;

/**
 *
 * @author Jóannes
 */
public class Main extends javax.swing.JFrame {
    DatabaseConnection db = new DatabaseConnection();
    /**
     * Creates new form FUCKYOU
     */
    public Main() {
        db.setupDatabase();
        initComponents();
        //Initialize the database
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        viewClientsTable1 = new com.sandagerdi.translationprojectmanager.Models.ViewClientsTable();
        jobTypesPanel1 = new com.sandagerdi.translationprojectmanager.Models.JobTypesPanel();
        viewJobTypesTable1 = new com.sandagerdi.translationprojectmanager.Models.ViewJobTypesTable();
        clientPanel2 = new com.sandagerdi.translationprojectmanager.Models.ClientPanel();
        addNewJobPanel1 = new com.sandagerdi.translationprojectmanager.Models.AddNewJobPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("See Clients", viewClientsTable1);
        jTabbedPane1.addTab("Add Job Types", jobTypesPanel1);
        jTabbedPane1.addTab("See Job Types", viewJobTypesTable1);
        jTabbedPane1.addTab("Add Clients", clientPanel2);
        jTabbedPane1.addTab("Jobs", addNewJobPanel1);

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.sandagerdi.translationprojectmanager.Models.AddNewJobPanel addNewJobPanel1;
    private com.sandagerdi.translationprojectmanager.Models.ClientPanel clientPanel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.sandagerdi.translationprojectmanager.Models.JobTypesPanel jobTypesPanel1;
    private com.sandagerdi.translationprojectmanager.Models.ViewClientsTable viewClientsTable1;
    private com.sandagerdi.translationprojectmanager.Models.ViewJobTypesTable viewJobTypesTable1;
    // End of variables declaration//GEN-END:variables
}
