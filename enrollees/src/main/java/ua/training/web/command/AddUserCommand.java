package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.UserDAO;
import ua.training.dao.impl.DAOFactoryImpl;
import ua.training.entity.User;
import ua.training.web.ActionType;
import ua.training.web.Path;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class AddUserCommand extends Command {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7423187017766399581L;
	
	private static final Logger LOG = Logger.getLogger(AddUserCommand.class);
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
		
		return Path.FORWARD_FACULTY_ADD;
	}
	
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		String role = request.getParameter("role");
		
		
		UserDAO ud = new DAOFactoryImpl().getUserDAO();
		User user = new User.Builder()
				.setEmail(email)
				.setPassword(password)
				.setFirstName(firstName)
				.setLastName(lastName)
				.setLogin(login)
				.setRole(role)
				.build();
		ud.insertUser(user);
		LOG.trace("User added to database");
		return Path.REDIRECT_TO_VIEW_ALL_USERS;
		
		
	}

}
