package ua.training.web.utils.writeFile;

import org.apache.log4j.Logger;
import ua.training.dao.impl.FacultyDAOImpl;
import ua.training.dao.impl.UserDAOImpl;
import ua.training.entity.FacultyEnrollee;


import java.io.*;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class WriteFileUtils {

	private static final Logger LOG = Logger.getLogger(WriteFileUtils.class);
	
	
	public static void wtireToFileResultsOfBudget(List<FacultyEnrollee> faculties) {
		LOG.trace("Starting write to file");
		try {
		File file = new File("C:/ResultsOfFaculty/Budget.txt");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF8"));
		for(FacultyEnrollee item : faculties) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			LOG.trace("first name = " + firstName);
			out.append("First name: ").append(firstName).append("\r\n");
			out.append("LastName : " + lastName + "\r\n");
			out.append("Faculty : " + nameOfFaculty + "\r\n");
			out.append("Sum of pionts : " + item.getSummaryPionts() + "\r\n");
			out.append("Status : Budget" + "\r\n");
			out.append("****************************" + "\r\n");
			
		}
		
		out.flush();
		out.close();
		} catch(Exception ex) {
			
		}
	}
	
	public static void wtireToFileResultsOfContract(List<FacultyEnrollee> faculties) throws IOException {
		LOG.trace("Starting write to file");
		File file = new File("C:/ResultsOfFaculty/Contract.txt");
//		PrintWriter printWriter = new PrintWriter("C:/ResultsOfFaculty/Contract.txt", "UTF-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF8"));
		
		for(FacultyEnrollee item : faculties) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			out.append("First name: " + firstName + "\r\n");
			out.append("LastName : " + lastName + "\r\n");
			out.append("Faculty : " + nameOfFaculty + "\r\n");
			out.append("Sum of pionts : " + item.getSummaryPionts() + "\r\n");
			out.append("Status : Contract" + "\r\n");
			out.append("****************************" + "\r\n");
			
		}
		out.flush();
		out.close();
		
		
	}
	
	public static void wtireToFileResultsOfNotBudgetNotContract(List<FacultyEnrollee> faculties) throws IOException {
		LOG.trace("Starting write to file");
		File file = new File("C:/ResultsOfFaculty/NotBudgetNotContract.txt");
//		PrintWriter printWriter = new PrintWriter("C:/ResultsOfFaculty/NotBudgetNotContract.txt", "UTF-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF8"));
		for(FacultyEnrollee item : faculties) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			out.append("First name: " + firstName + "\r\n");
			out.append("LastName : " + lastName + "\r\n");
			out.append("Faculty : " + nameOfFaculty + "\r\n");
			out.append("Sum of pionts : " + item.getSummaryPionts() + "\r\n");
			out.append("Status : Out Of Faculty" + "\r\n");
			out.append("****************************" + "\r\n");
			
		}
		out.flush();
		out.close();
		
		
	}
	
}
