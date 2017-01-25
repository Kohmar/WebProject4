package ua.training.dao.impl;

import ua.training.dao.*;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class DAOFactoryImpl extends DAOFactory {

    @Override
    public EnrolleeDAO getEnrolleeDAO() {
        return new EnrolleeDAOImpl();
    }

    @Override
    public FacultyDAO getFacultyDAO() {
        return new FacultyDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public MarkDAO getMarkDAO() {
        return new MarkDAOImpl();
    }

    @Override
    public DAOFacultySubjects getDAOFacultySubjects() {
        return new DAOFacultySubjectsImpl();
    }

    @Override
    public SubjectDAO getSubjectDAO() {
        return new SubjectDAOImpl();
    }

    @Override
    public DAOFacultyEnrollee getDAOFacultyEnrollee() {
        return new DAOFacultyEnrolleeImpl();
    }

}

