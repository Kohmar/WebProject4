package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.FacultyDAO;
import ua.training.dao.impl.DAOFactoryImpl;
import ua.training.entity.Faculty;
import ua.training.web.ActionType;
import ua.training.web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class UpdateFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5941101029576184634L;
	
	
	private static final Logger LOG = Logger.getLogger(UpdateFacultyCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else if(actionType == ActionType.GET){
			result = doGet(request, response);
		}

		LOG.debug("End executing command");
		return result;
	}
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Starting process of updating");
		String nameOfFaculty = request.getParameter("nameOfFaculty");
		byte[] bytes = nameOfFaculty.getBytes(StandardCharsets.ISO_8859_1);
		nameOfFaculty = new String(bytes, StandardCharsets.UTF_8);
		Integer budgetSeats = Integer.parseInt(request.getParameter("budgetSeats"));
		Integer totalSeats = Integer.parseInt(request.getParameter("totalSeats"));
		Integer id = (Integer) request.getSession().getAttribute("idOfFaculty");
		Faculty faculty = new Faculty.Builder()
				.setNameOfFaculty(nameOfFaculty)
				.setBudgetSeats(budgetSeats)
				.setTotalSeats(totalSeats)
				.build();
		LOG.trace("Fields for new Faculty were got" + nameOfFaculty + " " + budgetSeats + " " + totalSeats);
		FacultyDAO facultydao = new DAOFactoryImpl().getFacultyDAO();
		facultydao.updateFaculty(id,faculty);
		
		LOG.trace("The Faculty in Data Base was updated");
		return Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		
	}
	
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("request for only showing updateFaculty.jsp");
		Integer id = Integer.parseInt(request.getParameter("facultyId"));
		LOG.trace("Id Of Faculty was got = " + id);
		request.getSession().setAttribute("idOfFaculty", id);
		return Path.FORWARD_UPDATE_FACULTY_FORM;
	}

}
