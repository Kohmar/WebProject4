package ua.training.dao;

import ua.training.entity.Subject;

import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public interface DAOFacultySubjects {
    /**
     * Finds subject of faculty,
     * @param facultyId
     * @return
     */
    List<Subject> findSubjectsByFacultyId(Integer facultyId);

    /**
     * Insert subject into Faculty.
     * @param facultyId
     * @param subjectId
     * @return
     */
    boolean insertSubjectsToFaculty(Integer facultyId,Integer subjectId);

}
