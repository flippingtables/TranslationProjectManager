package com.sandagerdi.translationprojectmanager.Repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author Jóannes
 */
public class DatabaseConnection {
    private static final Logger log = Logger.getLogger(DatabaseConnection.class.getName());
    private ConnectionSource connectionSource;
    private final static String DATABASE_URL = "jdbc:sqlite:translationJobs.db";

    private Dao<Clients, Integer> clientDao;
    private Dao<JobTypes, Integer> jobTypesDao;
    private Dao<Jobs, Integer> jobsDao;
    

    public DatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        try {
            // create our data-source for the database
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }
            // setup our database and DAOs
            log.log(Level.SEVERE, "\n\nIt seems to have worked\n\n");
        } catch (SQLException ex) {

            log.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
        } finally {
            // destroy the data source which should close underlying connections
            Disconnect();
        }
    }

    private void setupDatabase(ConnectionSource connectionSource) throws SQLException {
        clientDao = DaoManager.createDao(connectionSource, Clients.class);
        jobTypesDao = DaoManager.createDao(connectionSource, JobTypes.class);
        jobsDao = DaoManager.createDao(connectionSource, Jobs.class);
        // if you need to create the table
        TableUtils.createTableIfNotExists(connectionSource, Clients.class);
        TableUtils.createTableIfNotExists(connectionSource, JobTypes.class);
        TableUtils.createTableIfNotExists(connectionSource, Jobs.class);

        if (!clientDao.idExists(1)) {
            insertSomeDataToDatabase();
        }

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
            Disconnect();
        }
        return clientDao;
    }

    public Dao<JobTypes, Integer> getJobTypesDao() {

        try {
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }
            try {
                jobTypesDao = DaoManager.createDao(connectionSource, JobTypes.class);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            System.out.println("GetJobTypes");
        } finally {
            Disconnect();
        }
        return jobTypesDao;
    }

    public Dao<Jobs, Integer> getJobsDao() {

        try {
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
            }
            jobsDao = DaoManager.createDao(connectionSource, Jobs.class);
        } catch (SQLException e) {
            System.out.println("GetJobsDao");
        } finally {
            Disconnect();
        }

        return jobsDao;
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

    public void Disconnect() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (SQLException ex) {
                System.out.println("BUGGUR");
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setupDatabase() {
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

    private void insertSomeDataToDatabase() {
        try {
            Clients local = new Clients("Localeyes", "email@localeyes.com", "33223344", "LocaleyesContact");
            Clients zeit = new Clients("Zeitgeist", "email@zeitgeist.com", "33223344", "ZeitgeistContact");
            clientDao.create(local);
            clientDao.create(zeit);
            clientDao.refresh(local);
            clientDao.refresh(zeit);
            JobTypes a = new JobTypes(local, "Translation", "EN", "ES", 25.0, 25.0, 50.0, 0.065, 0.065, 0.065, 0.026, 0.026, 0.01, 0.01, 0.01);
            JobTypes b = new JobTypes(local, "Translation", "FR", "ES", 25.0, 25.0, 50.0, 0.065, 0.065, 0.065, 0.026, 0.026, 0.01, 0.01, 0.01);
            JobTypes c = new JobTypes(local, "Review", "EN", "ES", 25.0, 25.0, 50.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            JobTypes d = new JobTypes(local, "Review", "FR", "ES", 25.0, 25.0, 50.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            JobTypes e = new JobTypes(local, "DTP", "", "", 25.0, 25.0, 50.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

            jobTypesDao.create(a);
            jobTypesDao.create(b);
            jobTypesDao.create(c);
            jobTypesDao.create(d);
            jobTypesDao.create(e);

            JobTypes f = new JobTypes(zeit, "Translation", "EN", "ES", 35.0, 35.0, 50.0, 0.09, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            JobTypes g = new JobTypes(zeit, "Translation", "FR", "ES", 35.0, 35.0, 50.0, 0.09, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            JobTypes h = new JobTypes(zeit, "Review", "EN", "ES", 35.0, 35.0, 50.0, 0.035, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            JobTypes i = new JobTypes(zeit, "Review", "FR", "ES", 35.0, 35.0, 50.0, 0.035, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            JobTypes j = new JobTypes(zeit, "DTP", "", "", 35.0, 35.0, 35.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

            jobTypesDao.create(f);
            jobTypesDao.create(g);
            jobTypesDao.create(h);
            jobTypesDao.create(i);
            jobTypesDao.create(j);

            Jobs job = new Jobs(zeit, a, DateTime.now().toDate(), DateTime.now().toDate(), "001-13-12-434-Apple Channel Sales and Development-153578 - SST-CSnD-1745-iPadinK20iPadinexistingITInfrastructures", 0.0, 1147.0, 0.0, 14.0, 0.0, 0.0, 51.0, 10.0, 20.0, false);
            jobsDao.create(job);
            Jobs job1 = new Jobs(local, a, DateTime.now().toDate(), DateTime.now().toDate(), "Apple Channel Sales and Development-153578 - SST-CSnD-1745-iPadinK20iPadinexistingITInfrastructures", 0.0, 1147.0, 0.0, 14.0, 7.0, 32.0, 51.0, 10.0, 20.0, true);
            jobsDao.create(job1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
