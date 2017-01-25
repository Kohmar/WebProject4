package ua.training.dao;

import ua.training.entity.Enrollee;

import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public interface EnrolleeDAO {
    /**
     * Getting all Enrollees.
     * @return
     */
    List<Enrollee> getAllEnrollees();

    /**
     * Adding Enrollee.
     * @param enrollee
     */
    void addEnrollee(Enrollee enrollee);

    /**
     * Deleting enrollee.
     * @param enrolleeId
     * @return
     */
    boolean deleteEnrollee(Integer enrolleeId);

    /**
     * Updating enrollee.
     * @param enrolleId
     * @param enrollee
     * @return
     */
    boolean updateEnrollee(Integer enrolleId, Enrollee enrollee);

    /**
     * Getting Enrollees by city.
     * @param city
     * @return
     */
    List<Enrollee> getEnrollesByCity(String city);

    /**
     * Getting Enrollees by region.
     * @param region
     * @return
     */
    List<Enrollee> getEnrolleesByRegion(String region);

    /**
     * Getting Enrollees ByStatus.
     * @param status
     * @return
     */
    List<Enrollee> getEnrolleesByStatus(boolean status);

    /**
     * Block enrollee.
     * @param enrollee
     * @return
     */
    boolean blockEnrollee(Enrollee enrollee);

    /**
     * Unblock enrollee.
     * @param enrollee
     * @return
     */
    boolean unblockEnrollee(Enrollee enrollee);

    /**
     * Block enrollee.
     * @param id
     * @return
     */
    boolean blockEnrollee(int id);

    /**
     * Unblock enrollee.
     * @param id
     * @return
     */
    boolean unblockEnrollee(int id);

    /**
     * Get enrollee by id.
     * @param id
     * @return
     */
    Enrollee getEnrolleeById(Integer id);

    /**
     * Shows is enrollee Exist.
     * @param idUser
     * @return
     */
    boolean isEnrolleeExistWithUserId(Integer idUser);

    /**
     * Gets status of enrollee.
     * @param id
     * @return
     */
    boolean getStatusOfEnrollee(Integer id);

    /**
     * Shows is enrollee Exists?
     * @param id
     * @return
     */
    boolean isEnrolleeExists(Integer id);

}
