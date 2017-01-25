package ua.training.dao;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public interface SubjectDAO {
    /**
     * Finds id of Subject by name of subject.
     * @param nameOfSubject
     * @return
     */
    Integer findIdSubjectByNameOfSubject(String nameOfSubject);
}
