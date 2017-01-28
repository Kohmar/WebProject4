package ua.training.dao.impl;

import ua.training.dao.ConnectionPool;
import ua.training.dao.DAOFacultyEnrollee;
import ua.training.entity.FacultyEnrollee;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class DAOFacultyEnrolleeImpl implements DAOFacultyEnrollee {


    Connection connection;

    private static final Logger LOG = Logger.getLogger(DAOFacultyEnrolleeImpl.class);


    @Override
    public boolean insertFacultyEnrollee(FacultyEnrollee fe) {
        LOG.trace("Starting adding FacultyEnrollee");
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into faculty_enrollees(firstName,lastName,city,region,sumPoints,Faculty_idFaculty,Enrollee_idEnrollee) values (?,?,?,?,?,?,?);")) {
            pstmt.setString(1, fe.getFirstName());
            pstmt.setString(2, fe.getLastName());
            pstmt.setString(3, fe.getCity());
            pstmt.setString(4, fe.getRegion());
            pstmt.setInt(5, fe.getsummaryPoints());
            pstmt.setInt(6, fe.getFacultyId());
            pstmt.setInt(7, fe.getEnrolleeId());
            pstmt.executeUpdate();
            pstmt.close();
            LOG.trace("Faculty EnrolleeAdded to dataBase");
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return true;
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

    @Override
    public boolean isEmptyFaculty(Integer facultyID) {
        boolean isEmpty = false;
        List<FacultyEnrollee> fe = new ArrayList<FacultyEnrollee>();
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection
                .prepareStatement("SELECT * FROM Faculty_Enrollees where Faculty_idFaculty = ?;")) {
            pstmt.setInt(1, facultyID);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                fe.add(new FacultyEnrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setFacultyId(rs.getInt("Faculty_idFaculty"))
                        .setEnrolleeId(rs.getInt("Enrollee_idEnrollee"))
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setsummaryPoints(rs.getInt("sumPoints"))
                        .build()
                );
            }
            if (fe.isEmpty()) {
                isEmpty = true;
            } else {
                isEmpty = false;
            }
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return isEmpty;
    }

    @Override
    public List<FacultyEnrollee> getAllFacultyEnrollee() {
        List<FacultyEnrollee> fe = new ArrayList<FacultyEnrollee>();
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Faculty_Enrollees;")) {
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                fe.add(new FacultyEnrollee.Builder()
                        .setFacultyId(rs.getInt("Faculty_idFaculty"))
                        .setEnrolleeId(rs.getInt("Enrollee_idEnrollee"))
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setsummaryPoints(rs.getInt("sumPoints"))
                        .build()
                );
            }
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return fe;
    }

    @Override
    public boolean insertFacultyEnrolleeWithScan(FacultyEnrollee fe, InputStream is) {
        LOG.trace("Starting adding FacultyEnrollee");
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into faculty_enrollees(firstName,lastName,city,region,sumPoints,Faculty_idFaculty,Enrollee_idEnrollee,scan) values (?,?,?,?,?,?,?,?);")) {
            pstmt.setString(1, fe.getFirstName());
            pstmt.setString(2, fe.getLastName());
            pstmt.setString(3, fe.getCity());
            pstmt.setString(4, fe.getRegion());
            pstmt.setInt(5, fe.getsummaryPoints());
            pstmt.setInt(6, fe.getFacultyId());
            pstmt.setInt(7, fe.getEnrolleeId());
            if (is != null) {
                pstmt.setBlob(8, is);
            }
            pstmt.executeUpdate();
            pstmt.close();
            LOG.trace("Faculty Enrollee with scan of certificate Added to dataBase");
        } catch (SQLException e) {
            LOG.trace("Cannot added to DB");
        } finally {
            closeConnection();
        }
        return true;
    }
}

