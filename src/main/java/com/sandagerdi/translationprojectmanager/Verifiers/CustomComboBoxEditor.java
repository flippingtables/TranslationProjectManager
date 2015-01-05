/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Verifiers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.sandagerdi.translationprojectmanager.Models.AddNewJobPanel;
import com.sandagerdi.translationprojectmanager.Models.ViewJobsTable;
import com.sandagerdi.translationprojectmanager.Repository.Clients;
import com.sandagerdi.translationprojectmanager.Repository.DatabaseConnection;
import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Jóannes
 */
/**
 * Custom class for adding elements in the JComboBox.
 */
public class CustomComboBoxEditor extends DefaultCellEditor {

// Decalre a model that is used for adding the elements to the `Combo box`
    private final DefaultComboBoxModel model;
    private final DatabaseConnection db;
    private final Clients thisClient;
    private final Dao<JobTypes, Integer> jobTypesDao;

    public CustomComboBoxEditor(Clients client) {
        super(new JComboBox());
        this.db = new DatabaseConnection();
        this.model = (DefaultComboBoxModel) ((JComboBox) getComponent()).getModel();
        jobTypesDao = db.getJobTypesDao();
        thisClient = client;
    }

    @Override
    @SuppressWarnings({"unchecked", "unchecked"})
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        model.removeAllElements();
        //Clients client = (Clients) table.getModel().getValueAt(row, 0);
        QueryBuilder<JobTypes, Integer> qb = db.getJobTypesDao().queryBuilder();
       
        Where<JobTypes, Integer> where = qb.where();
        try {

            qb.where().eq(JobTypes.CLIENTS_ID_FIELD_NAME, thisClient.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ViewJobsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedQuery<JobTypes> preparedQuery = null;

        try {
            preparedQuery = qb.prepare();
        } catch (SQLException ex) {
            Logger.getLogger(AddNewJobPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<JobTypes> jobs = null;

        try {
            jobs = db.getJobTypesDao().query(preparedQuery);
            for (JobTypes job : jobs) {
                model.addElement(job);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewJobsTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    //finally return the component.
}
