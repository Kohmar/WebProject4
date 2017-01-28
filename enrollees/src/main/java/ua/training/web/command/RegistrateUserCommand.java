package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.UserDAO;
import ua.training.dao.impl.DAOFactoryImpl;
import ua.training.entity.User;
import ua.training.web.ActionType;
import ua.training.web.utils.RegistrateUserValidator;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class RegistrateUserCommand extends Command{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267961749096370859L;
	
	private static final Logger LOG = Logger.getLogger(RegistrateUserCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.POST == actionType) {
			result = doPost(request, response); 
		}
		LOG.debug("Finished executing Command");

		return result;
	}

	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Starting doPost in RegistrateCommand");
		String firstName = request.getParameter("firstName");
		byte[] bytes = firstName.getBytes(StandardCharsets.ISO_8859_1);
		firstName = new String(bytes, StandardCharsets.UTF_8);
		String lastName = request.getParameter("lastName");
		byte[] bytes1 = lastName.getBytes(StandardCharsets.ISO_8859_1);
		lastName = new String(bytes1, StandardCharsets.UTF_8);
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = "client";
		String result = null;
		LOG.trace("Fields were got : " + "first Name = " + firstName + ", last Name = " + lastName +
				", email = " + email + ",login = " + login + ", password = " + password + ",role = " + role);
		
		boolean valid = RegistrateUserValidator.validateUserParameters(firstName, lastName, email, password, login);
		if(valid == true) {
		User user = new User.Builder()
				.setEmail(email)
				.setPassword(password)
				.setFirstName(firstName)
				.setLastName(lastName)
				.setLogin(login)
				.setRole(role)
				.build();
		UserDAO userdao = new DAOFactoryImpl().getUserDAO();
		userdao.insertUser(user);

		result = "index.jsp";
		LOG.trace("User was added to data base and fields are valid");
		} else if(valid == false){
			LOG.error("NOT CORRECT INPUT FIELDS, TRY AGAIN PLEASE");
			result = "index.jsp";
		}
		
		return result;
	}
	
}
