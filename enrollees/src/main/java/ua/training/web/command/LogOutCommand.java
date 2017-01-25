package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.web.ActionType;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class LogOutCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5027715730899128008L;
	
	private static final Logger LOG = Logger.getLogger(LogOutCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else {
			result = null;
		}

		LOG.debug("End executing command");
		return result;
	}

	
	private String doPost(HttpServletRequest request,
			HttpServletResponse response) {
		LOG.trace("Starting process of Log Out...");
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		LOG.trace("Log Out complete");
		return "index.jsp";
		
	}
	
}
