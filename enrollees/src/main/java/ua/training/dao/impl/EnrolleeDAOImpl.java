package ua.training.dao.impl;

import org.apache.log4j.Logger;
import ua.training.dao.ConnectionPool;
import ua.training.dao.EnrolleeDAO;
import ua.training.dao.Query;
import ua.training.entity.Enrollee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class EnrolleeDAOImpl implements EnrolleeDAO {

    private static final Logger LOG = Logger.getLogger(EnrolleeDAOImpl.class);

    Connection connection;


    @Override
    public List<Enrollee> getAllEnrollees() {
        List<Enrollee> enrolles = new ArrayList<Enrollee>();
        connection = ConnectionPool.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Query.SELECT_ALL_FROM_ENROLLEES)) {
            while (rs.next()) {
                enrolles.add(new Enrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setUserId(rs.getInt("User_idUser"))
                        .setBlockedStatus(rs.getBoolean("isBlocked")
                        )
                        .build()
                );
            }
        } catch (SQLException ex) {
            LOG.error("Can't get all Enrollees", ex);
        } finally {
            closeConnection();
        }
        return enrolles;
    }

    @Override
    public void addEnrollee(Enrollee enrollee) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement prstm = connection.prepareStatement(Query.INSERT_ENROLLEE)) {
            prstm.setString(1, enrollee.getCity());
            prstm.setString(2, enrollee.getRegion());
            prstm.setInt(3, enrollee.getUserId());
            prstm.setBoolean(4, enrollee.isBlockedStatus());
            prstm.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't add Enrollee", e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean deleteEnrollee(Integer enrolleeId) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(Query.DELETE_ENROLLEE)) {
            ps.setInt(1, enrolleeId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            LOG.error("Can't delete Enrollee", ex);
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public boolean updateEnrollee(Integer enrolleId, Enrollee enrollee) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.UPDATE_ENROLLEE)) {
            pstmt.setString(1, enrollee.getCity());
            pstmt.setString(2, enrollee.getRegion());
            pstmt.setInt(3, enrollee.getUserId());
            pstmt.setBoolean(4, enrollee.isBlockedStatus());
            pstmt.setInt(5, enrolleId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update enrollee", e);
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public List<Enrollee> getEnrollesByCity(String city) {
        List<Enrollee> enrollees = new ArrayList<Enrollee>();
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_ENROLLEE_BY_CITY)) {
            pstmt.setString(1, city);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_ENROLLEE_BY_CITY);
            while (rs.next()) {
                enrollees.add(new Enrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setUserId(rs.getInt("User_idUser"))
                        .setBlockedStatus(rs.getBoolean("isBlocked")
                        )
                        .build()
                );
            }
        } catch (SQLException e) {
            LOG.error("Can't get Enrollees by City", e);
        } finally {
            closeConnection();
        }
        return enrollees;
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
    public List<Enrollee> getEnrolleesByRegion(String region) {
        List<Enrollee> enrollees = new ArrayList<Enrollee>();
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_ENROLLEE_BY_REGION)) {
            pstmt.setString(1, region);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_ENROLLEE_BY_REGION);
            while (rs.next()) {
                enrollees.add(new Enrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setUserId(rs.getInt("User_idUser"))
                        .setBlockedStatus(rs.getBoolean("isBlocked")
                        )
                        .build()
                );
            }
        } catch (SQLException e) {
            LOG.error("Can't get Enrollees by Region", e);
        } finally {
            closeConnection();
        }
        return enrollees;
    }

    @Override
    public List<Enrollee> getEnrolleesByStatus(boolean status) {
        List<Enrollee> enrollees = new ArrayList<Enrollee>();
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_ENROLLEE_BY_STATUS)) {
            pstmt.setBoolean(1, status);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_ENROLLEE_BY_STATUS);
            while (rs.next()) {
                enrollees.add(new Enrollee.Builder()
                                .setId(rs.getInt("id"))
                                .setCity(rs.getString("city"))
                                .setRegion(rs.getString("region"))
                                .setUserId(rs.getInt("User_idUser"))
                                .setBlockedStatus(rs.getBoolean("isBlocked")
                                )
                                .build()
                );
            }
        } catch (SQLException e) {
            LOG.error("Can't get Enrollees by Status", e);
        } finally {
            closeConnection();
        }
        return enrollees;
    }

    @Override
    public boolean blockEnrollee(Enrollee enrollee) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.BLOCK_ENROLEE)) {
            pstmt.setInt(1, enrollee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public boolean unblockEnrollee(Enrollee enrollee) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.UNBLOCK_ENROLEE)) {
            pstmt.setInt(1, enrollee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public boolean blockEnrollee(int id) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.BLOCK_ENROLEE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public boolean unblockEnrollee(int id) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.UNBLOCK_ENROLEE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public Enrollee getEnrolleeById(Integer id) {
        Enrollee enrollee = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select * from Enrollee where id = ?;")) {
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                enrollee = new Enrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setUserId(rs.getInt("User_idUser"))
                        .setBlockedStatus(rs.getBoolean("isBlocked")
                        )
                        .build();
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return enrollee;
    }

    @Override
    public boolean isEnrolleeExistWithUserId(Integer idUser) {
        Enrollee enrollee = null;
        boolean b = false;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select * from enrollee where User_idUser = ?;")) {
            pstmt.setInt(1, idUser);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                enrollee = new Enrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setUserId(rs.getInt("User_idUser"))
                        .setBlockedStatus(rs.getBoolean("isBlocked")
                        )
                        .build();
            }
            rs.close();
            pstmt.close();
            if (enrollee == null) {
                b = false;
            } else {
                b = true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return b;
    }

    @Override
    public boolean getStatusOfEnrollee(Integer id) {
        boolean b = false;
        connection = ConnectionPool.getConnection();
        //todo pstmt переименовать переменную b переименовать
        try (PreparedStatement pstmt = connection.prepareStatement("select isBlocked from Enrollee where  id = ?;")) {
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs  = pstmt.getResultSet();
            while (rs.next()) {
                b = rs.getBoolean("isBlocked");
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return b;
    }

    @Override
    public boolean isEnrolleeExists(Integer id) {
        boolean b = false;
        Enrollee enrollee = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select * from Enrollee where  id = ?;")) {
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                enrollee = new Enrollee.Builder()
                        .setId(rs.getInt("id"))
                        .setCity(rs.getString("city"))
                        .setRegion(rs.getString("region"))
                        .setUserId(rs.getInt("User_idUser"))
                        .setBlockedStatus(rs.getBoolean("isBlocked")
                        )
                        .build();
                }
            pstmt.close();
            rs.close();
            if (enrollee == null) {
                b = false;
            } else {
                b = true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeConnection();
        }
        return b;
    }
}

