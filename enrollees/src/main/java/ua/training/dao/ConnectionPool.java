package ua.training.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
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
    private static MysqlDataSource dataSource;


    /**
     * Constructor for JUnit tests.
     *
     * @param dataSource
     */
    public ConnectionPool(MysqlDataSource dataSource) {
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

        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("st4db");

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.trace("Cannot establish connection" + e.getMessage() + " " + e.getErrorCode());
            return null;
        }
    }

}
