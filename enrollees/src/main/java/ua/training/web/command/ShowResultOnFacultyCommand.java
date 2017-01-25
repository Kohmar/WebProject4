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
public class ShowResultOnFacultyCommand extends Command{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3103911368195737803L;
	
	
	private static final Logger LOG = Logger.getLogger(MakeResultOnFacultyCommand.class);

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
		String s = request.getParameter("nameOfFaculty");
		request.getSession().setAttribute("currentFaculty", s);
		return Path.REDIRECT_TO_SHOW_RESULTS;
	}

}
