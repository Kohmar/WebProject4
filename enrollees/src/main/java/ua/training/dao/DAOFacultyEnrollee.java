package ua.training.dao;

import ua.training.entity.FacultyEnrollee;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public interface DAOFacultyEnrollee {

    /**
     * Insert FacultyEnrollee.
     * @param fe
     * @return
     */
    boolean insertFacultyEnrollee(FacultyEnrollee fe);

    /**
     * Checks the availability of registrated enrollees on faculty.
     * @param facultyID
     * @return
     */
    boolean isEmptyFaculty(Integer facultyID);

    /**
     * Gets all FacultyEnrollees.
     * @return
     */
    List<FacultyEnrollee> getAllFacultyEnrollee();

    /**
     * Insert FacultyEnrollee with scan.
     * @param fe
     * @param is
     * @return
     */
    boolean insertFacultyEnrolleeWithScan(FacultyEnrollee fe, InputStream is);
}
