package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.EnrolleeDAO;
import ua.training.dao.impl.EnrolleeDAOImpl;
import ua.training.web.ActionType;
import ua.training.web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class UnBlockEnrolleeCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5246349663895177353L;

	private static final Logger LOG = Logger.getLogger(UnBlockEnrolleeCommand.class);

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
		LOG.trace("Startin unblocking process");
		Integer id = Integer.parseInt(request.getParameter("userId"));
		LOG.trace("Get id =" + id);
		EnrolleeDAO enrolledao = new EnrolleeDAOImpl();
		enrolledao.unblockEnrollee(id);
		LOG.trace("Enrolee was unblocked");
		return Path.REDIRECT_TO_VIEW_ALL_USERS;
	}

}
