package com.sandagerdi.translationprojectmanager.Repository;
import Models.Client;
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

    private static ConnectionSource connectionSource = null;
    private final static String DATABASE_URL = "jdbc:sqlite:translationJobs.db";
    public Dao<Clients, Integer> accountDao;

    public DatabaseConnection() {
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
            // setup our database and DAOs
            setupDatabase(connectionSource);

            System.out.println("\n\nIt seems to have worked\n\n");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // destroy the data source which should close underlying connections
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void setupDatabase(ConnectionSource connectionSource) throws Exception {
        accountDao = DaoManager.createDao(connectionSource, Clients.class);
        
        // if you need to create the table
        TableUtils.createTableIfNotExists(connectionSource, Clients.class);
    }
}
