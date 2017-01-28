package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.impl.DAOFactoryImpl;
import ua.training.entity.Enrollee;
import ua.training.entity.FacultyEnrollee;
import ua.training.entity.User;
import ua.training.web.ActionType;
import ua.training.web.Path;
import ua.training.web.utils.MarksValidator;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
@MultipartConfig
public class ConfirmMarksCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5099583718548817166L;

	
	private static final Logger LOG = Logger.getLogger(ConfirmMarksCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} else if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}

		LOG.debug("Finished executing Command");

		return result;
	}
	
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("request for only showing addFacultyForm.jsp");
		String mark1 = request.getParameter("0");
		String mark2 = request.getParameter("1");
		String mark3 = request.getParameter("2");
		return Path.FORWARD_FACULTY_ADD;
	}
	
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalStateException, ServletException {
		boolean valid = MarksValidator.isValidmarks(request.getParameter("0"), request.getParameter("1"), request.getParameter("2"));
		String result = null;
		if(valid == true) {
		Integer mark1 = Integer.parseInt(request.getParameter("0"));
		Integer mark2 = Integer.parseInt(request.getParameter("1"));
		Integer mark3 = Integer.parseInt(request.getParameter("2"));
		LOG.trace("mark1 = "  + mark1 + ", mark2 = " + mark2 + ", mark3 = " + mark3);
		Integer summaryPoint = mark1 + mark2 + mark3;
		User user = (User) request.getSession().getAttribute("user");
		Enrollee enrollee = (Enrollee) request.getSession().getAttribute("enrollee");
		Integer idFaculty = (Integer) request.getSession().getAttribute("FacultyId");
		FacultyEnrollee fe = new FacultyEnrollee.Builder()
				.setFacultyId(idFaculty)
				.setEnrolleeId(user.getId())
				.setFirstName(user.getFirstName())
				.setLastName(user.getLastName())
				.setCity(enrollee.getCity())
				.setRegion(enrollee.getRegion())
				.setsummaryPoints(summaryPoint)
				.build();
		LOG.trace("FacultyEnrollee was created" + fe);
		new DAOFactoryImpl().getDAOFacultyEnrollee().insertFacultyEnrollee(fe);
		LOG.trace("added to databese");
		result = Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		} else {
			LOG.error("Not Correct Marks! Try Again");
			result = Path.REDIRECT_TO_SHOW_FACULTY_SUBJECTS;
		}
		
		return result;
		
	}

}
