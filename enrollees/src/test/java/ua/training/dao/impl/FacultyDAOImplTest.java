package ua.training.dao.impl;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.dao.ConnectionPool;
import ua.training.dao.FacultyDAO;
import ua.training.entity.Faculty;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class FacultyDAOImplTest {
    private static FacultyDAO facultyDAO = null;
    private static Faculty testFaculty = null;

    @BeforeClass
    public static void beforeClass() {
        facultyDAO = new FacultyDAOImpl();
        testFaculty = new Faculty("Art Faculty", 2, 1);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/st4db");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            new ConnectionPool(dataSource);
        }catch(ClassNotFoundException ex) {
            System.out.println("Cannot get DataSource without JNDI");
        }
    }

    @Test
    public void testDeleteFaculty() {
        Assert.assertTrue(facultyDAO.deleteFaculty(testFaculty));
    }


    @Test
    public void tesDeleteFacultyById() {
        Assert.assertTrue(facultyDAO.deleteFaculty(testFaculty.getId()));
    }

    @Test
    public void testsGetNameOfFaculty() {
        Assert.assertNull(facultyDAO.getNameOfFacultyById(testFaculty.getId()));
    }

    @Test
    public void testGetAllFaculty() {
        Assert.assertNotNull(facultyDAO.getAllFaculty());
    }

    @Test
    public void testGetFacultyByName() {
        Assert.assertNotNull(facultyDAO.getFacultyByNameOfFaculty(testFaculty.getNameOfFaculty()));
    }


    @Test
    public void testInsertFaculty() {
        Assert.assertNotNull(facultyDAO.insertFaculty(testFaculty));
    }

}
