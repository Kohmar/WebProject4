package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.EnrolleeDAO;
import ua.training.dao.impl.EnrolleeDAOImpl;
import ua.training.entity.Enrollee;
import ua.training.web.ActionType;
import ua.training.web.Path;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class ListEnrolleesCommand extends Command{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2198947123920988813L;
	
	private static final Logger LOG = Logger.getLogger(ListEnrolleesCommand.class);
	

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
	
	
	private String doGet(HttpServletRequest request,
			HttpServletResponse response) {
		EnrolleeDAO enrolledao = new EnrolleeDAOImpl();
		Collection<Enrollee> enrollees = enrolledao.getAllEnrollees();
		LOG.trace("Enrollees found: " + enrollees);
		request.setAttribute("enrollees", enrollees);
		
		
		return Path.FORWARD_VIEW_ALL_ENROLLEES;
				
		
	}

}
