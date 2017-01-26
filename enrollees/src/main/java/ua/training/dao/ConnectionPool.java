package ua.training.dao;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class ConnectionPool {
    private static final Logger LOG = Logger.getLogger(ConnectionPool.class);

    /**
     * DataSource field.
     */
    private static DataSource dataSource;


    /**
     * Constructor for JUnit tests.
     *
     * @param dataSource
     */
    public ConnectionPool(DataSource dataSource) {
        ConnectionPool.dataSource = dataSource;
    }

    /**
     * Get free connection from pool.
     *
     * @return connection.
     */
    public static synchronized Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/st4db";
        String username = "root";
        String password = "root";
        if (dataSource == null) {
            try {

                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/st4db");
            } catch (NamingException e) {
                LOG.warn("Cannot find the data source");
            }
        }

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOG.warn("Cannot establish connection" +e.getMessage()+ " "+e.getErrorCode());
            return null;
        }
    }

}
