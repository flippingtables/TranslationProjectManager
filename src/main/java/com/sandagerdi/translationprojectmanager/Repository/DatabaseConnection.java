package com.sandagerdi.translationprojectmanager.Repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jóannes
 */
public class DatabaseConnection {

    private ConnectionSource connectionSource;// = null;
    private final static String DATABASE_URL = "jdbc:sqlite:C:\\apps\\GitHub\\TranslationProjectManager\\translationJobs.db";
    private Dao<Clients, Integer> clientDao;
    private Dao<JobTypes, Integer> jobTypesDao;

    public DatabaseConnection() {

        try {
            // create our data-source for the database
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }
            // setup our database and DAOs
//            setupDatabase(connectionSource);

            System.out.println("\n\nIt seems to have worked\n\n");
        } catch (SQLException ex) {

            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println("BUGGUR0");
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // destroy the data source which should close underlying connections
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (SQLException ex) {
                    System.out.println("BUGGUR");
                    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setupDatabase(ConnectionSource connectionSource) throws SQLException {
        clientDao = DaoManager.createDao(connectionSource, Clients.class);
        jobTypesDao = DaoManager.createDao(connectionSource, JobTypes.class);
        // if you need to create the table
        TableUtils.createTableIfNotExists(connectionSource, Clients.class);
        TableUtils.createTableIfNotExists(connectionSource, JobTypes.class);
    }

    public Dao<Clients, Integer> getClientsDao() {
        try {
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }

            try {
                clientDao = DaoManager.createDao(connectionSource, Clients.class);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            System.out.println("FUCKYUOGetClients");
        } finally {
            try {
                connectionSource.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientDao;
    }

    public Dao<JobTypes, Integer> getJobTypesDao() {

        try {
            jobTypesDao = DaoManager.createDao(connectionSource, JobTypes.class);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jobTypesDao;
    }

    public void Connect() {
        try {
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Disconnet() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (SQLException ex) {
                System.out.println("BUGGUR");
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setupDatabase(){
        try {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.INFO, "Setting up database...");
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }
            setupDatabase(connectionSource);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
