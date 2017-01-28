package ua.training.dao.impl;

import org.apache.log4j.Logger;
import ua.training.dao.ConnectionPool;
import ua.training.dao.DAOFacultySubjects;
import ua.training.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class DAOFacultySubjectsImpl implements DAOFacultySubjects {

    private static final Logger LOG = Logger.getLogger(DAOFacultySubjectsImpl.class);

    Connection connection;

    @Override
    public List<Subject> findSubjectsByFacultyId(Integer facultyId) {
        LOG.trace("finding subjects by faculty id...");
        connection = ConnectionPool.getConnection();
        List<Integer> integers = new ArrayList<Integer>();
        List<Subject> subjects = new ArrayList<Subject>();
        try (PreparedStatement pstmt = connection.prepareStatement("select Subject_idSubject from Faculty_Subjects where Faculty_idFaculty = ?;")) {
            pstmt.setInt(1, facultyId);
            pstmt.execute();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                integers.add(rs.getInt("Subject_idSubject"));
            }
            for (Integer item : integers) {
                try (PreparedStatement pstmt1 = connection.prepareStatement("select * from Subject where id = ?;")) {
                    pstmt1.setInt(1, item);
                    pstmt1.execute();
                    ResultSet rs1 = pstmt1.executeQuery();
                    while (rs1.next()) {
                        subjects.add(new Subject(rs1.getString("nameOfSubject")));
                    }
                    pstmt1.close();
                    rs1.close();
                } catch (SQLException e) {
                    // TODO: handle exception
                }
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
            LOG.trace("subjects were found" + subjects.size());
        }
        return subjects;
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
    public boolean insertSubjectsToFaculty(Integer facultyId, Integer subjectId) {
        LOG.trace("Adding subjects to faculties");
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Faculty_Subjects(Faculty_idFaculty,Subject_idSubject) values (?,?);")) {
            pstmt.setInt(1, facultyId);
            pstmt.setInt(2, subjectId);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return true;
    }
}

