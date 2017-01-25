package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.UserDAO;
import ua.training.dao.impl.DAOFactoryImpl;
import ua.training.entity.User;
import ua.training.web.ActionType;
import ua.training.web.Path;
import ua.training.web.command.dto.UserConverter;
import ua.training.web.command.dto.UserDto;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class ListUsersCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8802137618226595298L;
	
	private static final Logger LOG = Logger.getLogger(ListUsersCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} 

		LOG.debug("Finished executing Command");

		return result;
	}
	
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Starting doGet() method in ListUsersCommand....");
		UserDAO ud = new DAOFactoryImpl().getUserDAO();
		List<User> collection = ud.getAllUsers();
		List<UserDto> userdto = new ArrayList<UserDto>();
		for(User item : collection) {
			userdto.add(UserConverter.getInstance().convert(item));
		}
		request.getSession().setAttribute("userses", userdto);
		
		return Path.FORWARD_TO_VIEW_ALL_USERS;
	}
	
}
