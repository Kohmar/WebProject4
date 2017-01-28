package ua.training.dao.impl;

import org.apache.log4j.Logger;
import ua.training.dao.ConnectionPool;
import ua.training.dao.Query;
import ua.training.dao.UserDAO;
import ua.training.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class UserDAOImpl implements UserDAO {

    Connection connection;

    final static Logger logger = Logger.getLogger(UserDAOImpl.class);


    @Override
    public User insertUser(User user) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.INSERT_USER)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getLogin());
            pstmt.setString(6, user.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't insert user", e);
        } finally {
            closeConnection();
        }
        return user;
    }


    @Override
    public boolean deleteUser(Integer userId) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.DELETE_USER)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't delete user", e);
        } finally {
            closeConnection();
        }
        return false;
    }


    @Override
    public boolean updateUser(Integer userId, User user) {
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.UPDATE_USER)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getLogin());
            pstmt.setString(6, user.getRole());
            pstmt.setInt(7, userId);
        } catch (SQLException e) {
            logger.error("Can't update user", e);
        } finally {
            closeConnection();
        }
        return true;
    }


    @Override
    public User getUserById(Integer userId) {
        User us = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_ID)) {
            pstmt.setInt(1, userId);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                us = new User.Builder()
                        .setId(rs.getInt("id"))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setLogin(rs.getString("login"))
                        .setRole(rs.getString("role"))
                        .build();
            }
        } catch (SQLException e) {
            logger.error("Can't find user by id", e);
        } finally {
            closeConnection();
        }
        return us;
    }


    @Override
    public User getUserByEmail(String email) {
        User us = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_EMAIL)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_EMAIL);
            us = new User.Builder()
                    .setId(rs.getInt("id"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setLogin(rs.getString("login"))
                    .setRole(rs.getString("role"))
                    .build();
        } catch (SQLException e) {
            logger.error("Can't find user by email", e);
        } finally {
            closeConnection();
        }
        return us;
    }


    @Override
    public List<User> getUsersByRole(String userRole) {
        List<User> users = new ArrayList<User>();
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_ROLE)) {
            pstmt.setString(1, userRole);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_ROLE);
            while (rs.next()) {
                users.add(new User.Builder()
                        .setId(rs.getInt("id"))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setLogin(rs.getString("login"))
                        .setRole(rs.getString("role"))
                        .build());
            }
        } catch (SQLException e) {
            logger.error("Can't find user by role", e);
        } finally {
            closeConnection();
        }

        return users;
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        connection = ConnectionPool.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Query.SELECT_ALL_USERS)) {
            while (rs.next()) {
                users.add(new User.Builder()
                        .setId(rs.getInt("id"))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setLogin(rs.getString("login"))
                        .setRole(rs.getString("role"))
                        .build()
                );

            }
        } catch (SQLException e) {
            logger.error("Can't get all users", e);
        } finally {
            closeConnection();
        }

        return users;
    }


    @Override
    public User getUserByFistName(String firstname) {
        User us = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_FIRSTNAME)) {
            pstmt.setString(1, firstname);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_FIRSTNAME);
            us = new User.Builder()
                    .setId(rs.getInt("id"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setLogin(rs.getString("login"))
                    .setRole(rs.getString("role"))
                    .build();
        } catch (SQLException e) {
            logger.error("Can't find user by first name", e);
        } finally {
            closeConnection();
        }
        return us;
    }


    @Override
    public User getUserByLastName(String lastName) {
        User us = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_LASTNAME)) {
            pstmt.setString(1, lastName);
            ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_LASTNAME);
            us = new User.Builder()
                    .setId(rs.getInt("id"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setLogin(rs.getString("login"))
                    .setRole(rs.getString("role"))
                    .build();
        } catch (SQLException e) {
            logger.error("Can't find user by last name", e);
        } finally {
            closeConnection();
        }
        return us;
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
    public User getUserByLogin(String login) {
        User user = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_LOGIN)) {
            pstmt.setString(1, login);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                user = new User.Builder()
                        .setId(rs.getInt("id"))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setLogin(rs.getString("login"))
                        .setRole(rs.getString("role"))
                        .build();
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Can't find user by login", e);
        } finally {
            closeConnection();
        }
        return user;
    }


    @Override
    public String getEmailById(Integer id) {
        String email = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select email from Users where id = ?;")) {
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                email = rs.getString("email");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            logger.error("Can't find user by login", e);
        } finally {
            closeConnection();
        }
        return email;
    }


    @Override
    public String getFirstNameById(Integer id) {
        String firstName = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select first_name from Users where id = ?;")) {
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                firstName = rs.getString("first_name");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            logger.error("Can't find user by login", e);
        } finally {
            closeConnection();
        }
        return firstName;
    }


    @Override
    public String getLastNameById(Integer id) {
        String lastName = null;
        connection = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("select last_name from Users where id = ?;")) {
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                lastName = rs.getString("last_name");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            logger.error("Can't find user by login", e);
        } finally {
            closeConnection();
        }
        return lastName;
    }
}

