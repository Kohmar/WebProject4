package ua.training.dao.impl;

import org.apache.log4j.Logger;
import ua.training.dao.ConnectionPool;
import ua.training.dao.SubjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class SubjectDAOImpl implements SubjectDAO {

    Connection connection;

    private static final Logger LOGGER = Logger.getLogger(SubjectDAOImpl.class);

    @Override
    public Integer findIdSubjectByNameOfSubject(String nameOfSubject) {
        LOGGER.trace("finding id subject");
        Integer id = 0;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select id from Subject where nameOfSubject = ?;")) {
            pstmt.setString(1, nameOfSubject);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return id;
    }

    /**
     * Close connection.
     */
    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
