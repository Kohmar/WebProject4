package ua.training.dao;

import ua.training.entity.User;

import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public interface UserDAO {
    /**
     * Inserting User into database.
     * @param user
     * @return
     */
    User insertUser(User user);

    /**
     * Deleting user.
     * @param userId
     * @return
     */
    boolean deleteUser(Integer userId);

    /**
     * Updating user.
     * @param userId
     * @param user
     * @return
     */
    boolean updateUser(Integer  userId, User user);

    /**
     * Getting User by id.
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * Getting user by email.
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * Getting User by role.
     * @param userRole
     * @return
     */
    List<User> getUsersByRole(String userRole);

    /**
     * Getting All users.
     * @return
     */
    List<User> getAllUsers();

    /**
     * Getting User by first name.
     * @param firstname
     * @return
     */
    User getUserByFistName(String firstname);

    /**
     * Getting user by last name.
     * @param lastName
     * @return
     */
    User getUserByLastName(String lastName);

    /**
     * getting user by login.
     * @param login
     * @return
     */
    User getUserByLogin(String login);

    /**
     * Getting email by id.
     * @param id
     * @return
     */
    String getEmailById(Integer id);

    /**
     * Getting first name by id.
     * @param id
     * @return
     */
    String getFirstNameById(Integer id);

    /**
     * Getting first name by id.
     * @param id
     * @return
     */
    String getLastNameById(Integer id);

}
