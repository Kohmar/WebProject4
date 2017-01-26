package conecctionDb;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by user on 26.01.2017.
 */
public class MysqlConnection {

    private static final Logger LOG = Logger.getLogger(MysqlConnection.class);
    private static final String URL = "jdbc:mysql://localhost:3306/myDb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String ASTERIX = "*";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void getResult(final String whatItem, final String fromTable) throws SQLException {
        LOG.info("Connecting to database...");
        Connection conn = getConnection();
        LOG.info("Connect success");
        String what = StringUtils.isEmpty(whatItem) ? ASTERIX : whatItem;
        String from = StringUtils.isEmpty(fromTable)? "role_type":fromTable;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT whatItem FROM fromTable");
            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                System.out.println("index: " + result.getString(1) + " role_type: " + result.getString(2));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        conn.close();
    }

}
