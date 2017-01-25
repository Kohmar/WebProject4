package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.web.ActionType;
import ua.training.web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class ShowSortedFacultyByBudgetSeatsCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6067740118220805976L;
	
	private static final Logger LOG = Logger.getLogger(ShowSortedFacultyByBudgetSeatsCommand.class);

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
		LOG.trace("Showing Faculties.jsp");
		return Path.FORWARD_VIEW_ALL_FACULTY;
	}
}
