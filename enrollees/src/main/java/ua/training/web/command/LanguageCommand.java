package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.web.ActionType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class LanguageCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8853052548275306970L;

	private static final Logger LOGGER = Logger.getLogger(LanguageCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOGGER.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else {
			result = null;	
		}

		LOGGER.debug("End executing command");
		return result;
	}

	
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		final String action = "controller?";

		// get parameters
		String url = request.getParameter("url");
		String lang = request.getParameter("language");
		LOGGER.trace("url: " + url + ", lang: " + lang);

		// set language
		request.getSession().setAttribute("lang", lang);
		LOGGER.trace("Language has been changed to " + lang);

		// if language changes on login page
		if (url.equals("command=logout") || url.equals("")) {
			return null;
		}

		return action + url;
	
	}
}
